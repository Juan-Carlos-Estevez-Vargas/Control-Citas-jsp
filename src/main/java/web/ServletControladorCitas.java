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
                    break;
                default:
                    this.accionDefalult(request, response);
            }
        } else {
            this.accionDefalult(request, response);
        }
    }

    //------------- Métodos CRUD -----------------------------------------------------------
    private void accionDefalult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Listando los pacientes
        List<Citas> citas = new CitasJDBC().listar();

        // Compartiendo la información con el frontend (alcance sesión)
        HttpSession sesion = request.getSession();
        sesion.setAttribute("citas", citas);
        sesion.setAttribute("totalCitas", citas.size());

        // Redireccionando a la página de pacientes.jsp
        response.sendRedirect("citas.jsp");
    }

    // Método para insertar un paciente a la base de datos
    private void insertarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        String medico = request.getParameter("medico");
        String paciente = request.getParameter("paciente");
        String hora = request.getParameter("hora");

        // Creando el objeto Citas (modelo)
        Citas cita = new Citas(idCita, medico, paciente, hora);

        // Insertando la Cita en la base de datos
        int registrosModificados = new CitasJDBC().insertar(cita);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de Médicos)
        this.accionDefalult(request, response);
    }

    // Método para modificar un paciente
    private void modificarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        String medico = request.getParameter("medico");
        String paciente = request.getParameter("paciente");
        String hora = request.getParameter("hora");

         // Creando el objeto Citas (modelo)
        Citas cita = new Citas(idCita, medico, paciente, hora);

        // Modificando el paciente en la base de datos
        int registrosModificados = new CitasJDBC().actualizar(cita);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para eliminar pacientes
    private void eliminarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        
        // Creando el objeto paciente (modelo)
        Citas cita = new Citas(idCita);

        // Modificando el paciente en la base de datos
        int registrosModificados = new CitasJDBC().eliminar(cita);
        System.out.println("Registros Eliminados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para editar un paciente
    private void editarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el idPaciente
       int idCita = Integer.parseInt(request.getParameter("idCita"));

        // Recuperando o encontrando el objeto paciente asociado al idPaciente
        Citas cita = new CitasJDBC().encontrar(new Citas(idCita));
        request.setAttribute("cita", cita);
        String jspEditar = "/WEB-INF/paginas/citas/editarCita.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

}
