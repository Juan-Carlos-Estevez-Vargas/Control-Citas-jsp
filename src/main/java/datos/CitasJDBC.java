package datos;

import dominio.Citas;
import dominio.Paciente;
import java.sql.*;
import java.util.*;

public class CitasJDBC {

    // Variables con las consultas de tipo SQL
    private static final String SQL_SELECT = "SELECT * FROM citas";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM citas WHERE idCita = ?";
    private static final String SQL_INSERT = "INSERT INTO pcitas VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE citas SET idCita = ?, medico = ?, paciente = ?, hora = ? WHERE idCita = ?";
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
                int idCita = rs.getInt("idCita");
                String medico = rs.getString("medico");
                String paciente = rs.getString("paciente");
                String hora = rs.getString("hora");

                // Creando una nueva cita
                cita = new Citas(idCita, medico, paciente, hora);
                // Añadiendo pla cita a la lista de citas
                citas.add(cita);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar las citas: " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return citas;
    }

    // Método para buscar una cita
    public Citas encontrar(Citas cita) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Ejecutando la sentencia SQL de tipo SELECT_BY_ID
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cita.getIdCita()); // Seteando el parámetro de la consulta preparada
            rs = stmt.executeQuery();
            rs.absolute(1); // Posicionandonos en el primer registro encontrado

            // Recuperando los campos
            int idCita = rs.getInt("idCita");
            String medico = rs.getString("medico");
            String paciente = rs.getString("paciente");
            String hora = rs.getString("hora");

            // Setenado los campos a la cita (Creando una nueva cita)
            cita.setIdCita(idCita);
            cita.setMedico(medico);
            cita.setPaciente(paciente);
            cita.setHora(hora);
        } catch (SQLException ex) {
            System.err.println("Error al encontrar la cita " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return cita;
    }

    // Método para insertar una cita a la base de datos
    public int insertar(Citas cita) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo INSERT
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);

            // Seteando los parámetros a la consulta preparada
            stmt.setInt(1, cita.getIdCita());
            stmt.setString(2, cita.getMedico());
            stmt.setString(3, cita.getPaciente());
            stmt.setString(4, cita.getHora());

            // Ejecutando la sentencia SQL_INSERT
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al insertar cita " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método pata actualizar un paciente en la base de datos
    public int actualizar(Citas cita) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo UPDATE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);

            // Seteando los parámetros a la consulta preparada
            stmt.setInt(1, cita.getIdCita());
            stmt.setString(2, cita.getMedico());
            stmt.setString(3, cita.getPaciente());
            stmt.setString(4, cita.getHora());

            // Ejecutando la sentencia SQL_UPDATE
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar cita " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método para eliminar un paciente
    public int eliminar(Citas cita) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo DELETE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);

            // Seteando los parámetros a la consulta preparada
            stmt.setInt(1, cita.getIdCita());

            // Ejecutando la sentencia SQL_DELETE
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al eliminar cita " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
}
