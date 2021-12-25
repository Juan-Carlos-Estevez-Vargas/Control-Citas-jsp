package datos;

import dominio.Citas;
import dominio.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitasJDBC {

    // Variables con las consultas de tipo SQL
    private static final String SQL_SELECT = "SELECT medico.nombre, paciente.nombre, citas.hora FROM medico JOIN citas ON idMedico = medico JOIN paciente ON idPaciente = paciente";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM citas WHERE idCita = ?";
    private static final String SQL_INSERT = "INSERT INTO citas (medico, paciente, hora) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE citas SET medico = ?, paciente = ?, hora = ? WHERE idCita = ?";
    private static final String SQL_DELETE = "DELETE FROM citas WHERE idCita = ?";

    // Método para listar los pacientes
    public List<Citas> listar() {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Citas cita = null;
        List<Citas> citas = new ArrayList<>();

        try {
            // Ejecutando la sentencia SQL de tipo SELECT
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            // Iterando los pacientes de la base de datos
            while (rs.next()) {
                // Recuperando los campos
                String medico = rs.getString("nombre");
                String paciente = rs.getString("nombre");
                String hora = rs.getString("hora");
                

                // Creando un nuevo paciente
                cita = new Citas(medico, paciente, hora);
                // Añadiendo paciente a la lista de pacientes
                citas.add(cita);
            }
            System.out.println(citas);
        } catch (SQLException ex) {
            System.err.println("Error al listar los pacientes: " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return citas;
    }

    // Método para buscar un paciente
    public Paciente encontrar(Paciente paciente) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Ejecutando la sentencia SQL de tipo SELECT_BY_ID
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, paciente.getIdPaciente()); // Seteando el parámetro de la consulta preparada
            rs = stmt.executeQuery();
            rs.absolute(1); // Posicionandonos en el primer registro encontrado

            // Recuperando los campos
            String nombre = rs.getString("nombre");
            String fechaNacimiento = rs.getString("fechaNacimiento");
            String idPaciente = rs.getString("idPaciente");
            String tipoIdentificacion = rs.getString("tipoIdentificacion");
            String eps = rs.getString("eps");
            String historiaClinica = rs.getString("historiaClinica");

            // Setenado los campos al paciente (Creando un nuevo paciente)
            paciente.setNombre(nombre);
            paciente.setFechaNacimiento(fechaNacimiento);
            paciente.setIdPaciente(idPaciente);
            paciente.setTipoIdentificacion(tipoIdentificacion);
            paciente.setEps(eps);
            paciente.setHistoriaClinica(historiaClinica);
        } catch (SQLException ex) {
            System.err.println("Error al encontrar el paciente " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return paciente;
    }

    // Método para insertar un paciente a la base de datos
    public int insertar(Paciente paciente) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo INSERT
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getFechaNacimiento());
            stmt.setString(3, paciente.getIdPaciente());
            stmt.setString(4, paciente.getTipoIdentificacion());
            stmt.setString(5, paciente.getEps());
            stmt.setString(6, paciente.getHistoriaClinica());

            // Ejecutando la sentencia SQL_INSERT
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al insertar paciente " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método pata actualizar un paciente en la base de datos
    public int actualizar(Paciente paciente) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo UPDATE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getFechaNacimiento());
            stmt.setString(3, paciente.getIdPaciente());
            stmt.setString(4, paciente.getTipoIdentificacion());
            stmt.setString(5, paciente.getEps());
            stmt.setString(6, paciente.getHistoriaClinica());
            stmt.setString(7, paciente.getIdPaciente());

            // Ejecutando la sentencia SQL_UPDATE
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar paciente " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método para eliminar un paciente
    public int eliminar(Paciente paciente) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo DELETE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, paciente.getIdPaciente());

            // Ejecutando la sentencia SQL_DELETE
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al eliminar el paciente " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
}