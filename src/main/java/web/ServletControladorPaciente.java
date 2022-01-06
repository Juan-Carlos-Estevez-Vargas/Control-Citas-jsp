package web;

// Librerías
import datos.PacienteJDBC;
import dominio.Paciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorPaciente")
public class ServletControladorPaciente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el parámetro de la acción a realizar
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPaciente(request, response);
                    break;
                case "eliminar":
                    this.eliminarPaciente(request, response);
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
                    this.insertarPaciente(request, response);
                    break;
                case "modificar":
                    this.modificarPaciente(request, response);
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
        List<Paciente> pacientes = new PacienteJDBC().listar();

        // Compartiendo la información con el frontend (alcance sesión)
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacientes", pacientes);
        sesion.setAttribute("totalPacientes", pacientes.size());

        // Redireccionando a la página de pacientes.jsp
        response.sendRedirect("pacientes.jsp");
    }

    // Método para insertar un paciente a la base de datos
    private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String idPaciente = request.getParameter("idPaciente");
        String tipoIdentificacion = request.getParameter("tipoIdentificacion");
        String eps = request.getParameter("eps");
        String historiaClinica = request.getParameter("historiaClinica");

        // Creando el objeto Paciente (modelo)
        Paciente paciente = new Paciente(nombre, fechaNacimiento, idPaciente, tipoIdentificacion, eps, historiaClinica);

        // Insertando el Paciente en la base de datos
        int registrosModificados = new PacienteJDBC().insertar(paciente);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de Médicos)
        this.accionDefalult(request, response);
    }

    // Método para modificar un paciente
    private void modificarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String idPaciente = request.getParameter("idPaciente");
        String tipoIdentificacion = request.getParameter("tipoIdentificacion");
        String eps = request.getParameter("eps");
        String historiaClinica = request.getParameter("historiaClinica");

        // Creando el objeto Paciente (modelo)
        Paciente paciente = new Paciente(nombre, fechaNacimiento, idPaciente, tipoIdentificacion, eps, historiaClinica);

        // Modificando el paciente en la base de datos
        int registrosModificados = new PacienteJDBC().actualizar(paciente);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para eliminar pacientes
    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarPaciente.jsp
        String idPaciente = request.getParameter("idPaciente");
        
        // Recuperando o encontrando el objeto paciente asociado al idPaciente
        Paciente paciente = new PacienteJDBC().encontrar(new Paciente(idPaciente));
        System.out.println(paciente);

//        // Creando el objeto paciente (modelo)
//        Paciente paciente = new Paciente(idPaciente);
//
        // Modificando el paciente en la base de datos
        int registrosModificados = new PacienteJDBC().eliminar(paciente);
        System.out.println("Registros Eliminados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para editar un paciente
    private void editarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el idPaciente
        String idPaciente = request.getParameter("idPaciente");

        // Recuperando o encontrando el objeto paciente asociado al idPaciente
        Paciente paciente = new PacienteJDBC().encontrar(new Paciente(idPaciente));
        request.setAttribute("paciente", paciente);
        String jspEditar = "/WEB-INF/paginas/pacientes/editarPaciente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

}
