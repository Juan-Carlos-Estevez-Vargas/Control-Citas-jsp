package web;

// Librerías
import datos.MedicoJDBC;
import dominio.Medico;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorMedico")
public class ServletControladorMedico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el parámetro de la acción a realizar
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarMedico(request, response);
                    break;
                case "eliminar":
                    this.eliminarMedico(request, response);
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
                    this.insertarMedico(request, response);
                    break;
                case "modificar":
                    this.modificarMedico(request, response);
                    break;
                case "eliminar":
                    this.eliminarMedico(request, response);
                default:
                    this.accionDefalult(request, response);
            }
        } else {
            this.accionDefalult(request, response);
        }
    }

    //------------- Métodos CRUD -----------------------------------------------------------
    private void accionDefalult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Listando los médicos
        List<Medico> medicos = new MedicoJDBC().listar();

        // Compartiendo la información con el frontend (alcance sesión)
        HttpSession sesion = request.getSession();
        sesion.setAttribute("medicos", medicos);
        sesion.setAttribute("totalMedicos", medicos.size());

        // Redireccionando a la página de médicos.jsp
        response.sendRedirect("medicos.jsp");
    }

    // Método para insertar un médico a la base de datos
    private void insertarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarMedico.jsp
        String nombre = request.getParameter("nombre");
        String identificacion = request.getParameter("idMedico");
        String tipoIdentificacion = request.getParameter("tipoIdentificacion");
        String NTarjetaProfesional = request.getParameter("NTarjetaProfesional");
        double aniosExperiencia = 0;
        String aniosExperienciaString = request.getParameter("aniosExperiencia");
        String especialidad = request.getParameter("especialidad");
        String horaInicioAtencion = request.getParameter("horaInicioAtencion");
        String horaFinAtencion = request.getParameter("horaFinAtencion");

        if (aniosExperienciaString != null && !"".equals(aniosExperienciaString)) {
            aniosExperiencia = Double.parseDouble(aniosExperienciaString);
        }

        // Creando el objeto Médico (modelo)
        Medico medico = new Medico(nombre, identificacion, tipoIdentificacion, NTarjetaProfesional, aniosExperiencia, especialidad, horaInicioAtencion, horaFinAtencion);

        // Insertando el Médico en la base de datos
        int registrosModificados = new MedicoJDBC().insertar(medico);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de Médicos)
        this.accionDefalult(request, response);
        
    }

    // Método para modificar un médico
    private void modificarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarMedico.jsp
        String nombre = request.getParameter("nombre");
        String identificacion = request.getParameter("idMedico");
        String tipoIdentificacion = request.getParameter("tipoIdentificacion");
        String NTarjetaProfesional = request.getParameter("NTarjetaProfesional");
        double aniosExperiencia = 0;
        String aniosExperienciaString = request.getParameter("aniosExperiencia");
        String especialidad = request.getParameter("especialidad");
        String horaInicioAtencion = request.getParameter("horaInicioAtencion");
        String horaFinAtencion = request.getParameter("horaFinAtencion");

        if (aniosExperienciaString != null && !"".equals(aniosExperienciaString)) {
            aniosExperiencia = Double.parseDouble(aniosExperienciaString);
        }

        // Creando el objeto Médico (modelo)
        Medico medico = new Medico(nombre, identificacion, tipoIdentificacion, NTarjetaProfesional, aniosExperiencia, especialidad, horaInicioAtencion, horaFinAtencion);

        // Modificando el Médico en la base de datos
        int registrosModificados = new MedicoJDBC().actualizar(medico);
        System.out.println("Registros Modificados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para eliminar médicos
    private void eliminarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando los valores del formulario agregarMedico.jsp
        String idMedico = request.getParameter("idMedico");

        // Creando el objeto médico (modelo)
        Medico medico = new Medico(idMedico);
        
        // Modificando el médico en la base de datos
        int registrosModificados = new MedicoJDBC().eliminar(medico);
        System.out.println("Registros Eliminados = " + registrosModificados);

        // Redirigiendo a la accion por default (listado actualizado de clientes)
        this.accionDefalult(request, response);
    }

    // Método para editar un médico
    private void editarMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperando el idMedico
        String idMedico = request.getParameter("idMedico");

        // Recuperando o encontrando el objeto médico asociado al idMedico
        Medico medico = new MedicoJDBC().encontrar(new Medico(idMedico));
        request.setAttribute("medico", medico);
        String jspEditar = "/WEB-INF/paginas/medico/editarMedico.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

}
