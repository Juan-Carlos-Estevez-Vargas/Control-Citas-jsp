package datos;

// Importando librerías
import dominio.Medico;
import java.sql.*;
import java.util.*;

public class MedicoJDBC {

    // Variables con las consultas de tipo SQL
    private static final String SQL_SELECT = "SELECT * FROM medico";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM medico WHERE idMedico = ?";
    private static final String SQL_INSERT = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE medico SET nombre = ?, idMedico = ?, tipoIdentificacion = ?, NTarjetaProfesional = ?, aniosExperiencia = ?, especialidad = ?, horaInicioAtencion = ?, horaFinAtencion = ? WHERE idMedico = ?";
    private static final String SQL_DELETE = "DELETE FROM medico WHERE idMedico = ?";

    // Método para listar los médicos
    public List<Medico> listar() {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = null;
        List<Medico> medicos = new ArrayList<>();

        try {
            // Ejecutando la sentencia SQL de tipo SELECT
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            // Iterando los médicos de la base de datos
            while (rs.next()) {
                // Recuperando los campos
                String nombre = rs.getString("nombre");
                String idMedico = rs.getString("idMedico");
                String tipoIdentificacion = rs.getString("tipoIdentificacion");
                String NTarjetaProfesional = rs.getString("NTarjetaProfesional");
                double aniosExperiencia = rs.getDouble("aniosExperiencia");
                String especialidad = rs.getString("especialidad");
                String horaInicioAtencion = rs.getString("horaInicioAtencion");
                String horaFinAtencion = rs.getString("horaFinAtencion");

                // Creando un nuevo medico
                medico = new Medico(nombre, idMedico, tipoIdentificacion, NTarjetaProfesional, aniosExperiencia, especialidad, horaInicioAtencion, horaFinAtencion);
                // Añadiendo médico a la lista de clientes
                medicos.add(medico);
            }
            System.out.println(medicos);
        } catch (SQLException ex) {
            System.err.println("Error al listar los médicos: " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return medicos;
    }

    // Método para buscar un médico
    public Medico encontrar(Medico medico) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Ejecutando la sentencia SQL de tipo SELECT_BY_ID
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, medico.getIdMedico()); // Seteando el parámetro de la consulta preparada
            rs = stmt.executeQuery();
            rs.absolute(1); // Posicionandonos en el primer registro encontrado

            // Recuperando los campos
            String nombre = rs.getString("nombre");
            String idMedico = rs.getString("idMedico");
            String tipoIdentificacion = rs.getString("tipoIdentificacion");
            String NTarjetaProfesional = rs.getString("NTarjetaProfesional");
            double aniosExperiencia = rs.getDouble("aniosExperiencia");
            String especialidad = rs.getString("especialidad");
            String horaInicioAtencion = rs.getString("horaInicioAtencion");
            String horaFinAtencion = rs.getString("horaFinAtencion");

            // Setenado los campos al médico (Creando un nuevo médico)
            medico.setNombre(nombre);
            medico.setIdMedico(idMedico);
            medico.setTipoIdentificacion(tipoIdentificacion);
            medico.setNTarjetaProfesional(NTarjetaProfesional);
            medico.setAniosExperiencia(aniosExperiencia);
            medico.setEspecialidad(especialidad);
            medico.setHoraInicioAtencion(horaInicioAtencion);
            medico.setHoraFinAtencion(horaFinAtencion);
        } catch (SQLException ex) {
            System.err.println("Error al encontrar médico " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return medico;
    }

    // Método para insertar un médico a la base de datos
    public int insertar(Medico medico) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo INSERT
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getIdMedico());
            stmt.setString(3, medico.getTipoIdentificacion());
            stmt.setString(4, medico.getNTarjetaProfesional());
            stmt.setDouble(5, medico.getAniosExperiencia());
            stmt.setString(6, medico.getEspecialidad());
            stmt.setString(7, medico.getHoraInicioAtencion());
            stmt.setString(8, medico.getHoraFinAtencion());

            // Ejecutando la sentencia SQL_INSERT
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al insertar médico " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método pata actualizar un médico en la base de datos
    public int actualizar(Medico medico) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo UPDATE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getIdMedico());
            stmt.setString(3, medico.getTipoIdentificacion());
            stmt.setString(4, medico.getNTarjetaProfesional());
            stmt.setDouble(5, medico.getAniosExperiencia());
            stmt.setString(6, medico.getEspecialidad());
            stmt.setString(7, medico.getHoraInicioAtencion());
            stmt.setString(8, medico.getHoraFinAtencion());
            stmt.setString(2, medico.getIdMedico());

            // Ejecutando la sentencia SQL_UPDATE
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar médico " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }

    // Método para eliminar un médico
    public int eliminar(Medico medico) {

        // Declarando los objetos
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            // Ejecutando la sentencia SQL de tipo DELETE
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);

            // Seteando los parámetros a la consulta preparada
            stmt.setString(1, medico.getIdMedico());

            // Ejecutando la sentencia SQL_DELETE
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error al eliminar médico " + ex.getMessage());
        } finally {
            // Cerrando los objetos
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
}
