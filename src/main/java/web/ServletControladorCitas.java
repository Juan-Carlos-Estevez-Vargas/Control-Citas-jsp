package web;

// Librerías
import datos.CitasJDBC;
import dominio.Citas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorCitas")
public class ServletControladorCitas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el parámetro de la acción a realizar
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCita(request, response);
                    break;
                case "eliminar":
                    this.eliminarCita(request, response);
                    break;
                default:
                    this.accionDefalult(request, response);
            }
        } else {
            this.accionDefalult(request, response);
        }
    }

    // Método para procesar las peticiones de tipo POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el parámetro de la acción a realizar
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCita(request, response);
                    break;
                case "modificar":
                    this.modificarCita(request, response);
                    break;
                case "eliminar":
                    this.eliminarCita(request, response);
                default:
                    this.accionDefalult(request, response);
            }
        } else {
            this.accionDefalult(request, response);
        }
    }

    //------------- Métodos CRUD -----------------------------------------------------------
    private void accionDefalult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Listando las citas
        List<Citas> citas = new CitasJDBC().listar();

        // Compartiendo la información con el frontend (alcance sesión)
        HttpSession sesion = request.getSession();
        sesion.setAttribute("citas", citas);
        sesion.setAttribute("totalCitas", citas.size());

        // Redireccionando a la página de citas.jsp
        response.sendRedirect("citas.jsp");
    }

    // Método para insertar un médico a la base de datos
    private void insertarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarCita.jsp
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        String nombreMedico = request.getParameter("nombreMedico");
        String nombrePaciente = request.getParameter("nombre");
        String hora = request.getParameter("hora");

        // Creando el objeto cita (modelo)
        Citas cita = new Citas(idCita, nombreMedico, nombrePaciente, hora);

        // Insertando la cita en la base de datos
        int registrosModificados = new CitasJDBC().insertar(cita);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de Médicos)
        this.accionDefalult(request, response);
    }

    // Método para modificar una cita
    private void modificarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarCita.jsp
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        String nombreMedico = request.getParameter("nombreMedico");
        String nombrePaciente = request.getParameter("nombre");
        String hora = request.getParameter("hora");

        // Creando el objeto cita (modelo)
        Citas cita = new Citas(idCita, nombreMedico, nombrePaciente, hora);

        // Modificando la cita en la base de datos
        int registrosModificados = new CitasJDBC().actualizar(cita);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de citas)
        this.accionDefalult(request, response);
    }

    // Método para eliminar citas
    private void eliminarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCita = Integer.parseInt(request.getParameter("idCita"));

        // Creando el objeto cita (modelo)
        Citas cita = new Citas(idCita);

        // Modificando la cita en la base de datos
        int registrosModificados = new CitasJDBC().eliminar(cita);
        System.out.println("Registros Eliminados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de citas)
        this.accionDefalult(request, response);
    }

    // Método para editar un médico
    private void editarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el idCita
        int idCita = Integer.parseInt(request.getParameter("idCita"));

        // Recuperando o encontrando el objeto cita asociado al idCita
        Citas cita = new CitasJDBC().encontrar(new Citas(idCita));
        request.setAttribute("cita", cita);
        String jspEditar = "/WEB-INF/paginas/citas/editarCita.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

}
