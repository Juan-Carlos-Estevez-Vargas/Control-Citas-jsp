
package dominio;

public class Paciente {
    // Mapeo de la tabla Paciente de la base de datos
    private String nombre;
    private String fechaNacimiento;
    private String idPaciente;
    private String tipoIdentificacion;
    private String eps;
    private String historiaClinica;

    //------------- Constructores -------------------------------------------------------
    public Paciente() {
    }

    public Paciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(String nombre, String fechaNacimiento, String idPaciente, String tipoIdentificacion, String eps, String historiaClinica) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.idPaciente = idPaciente;
        this.tipoIdentificacion = tipoIdentificacion;
        this.eps = eps;
        this.historiaClinica = historiaClinica;
    }
    // -------------- Fin Constructores -------------------------------------------------

    //--------- Setters and Getters -----------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
    //--------------------- Fin Setters and Getters -------------------------------------

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", idPaciente=" + idPaciente + ", tipoIdentificacion=" + tipoIdentificacion + ", eps=" + eps + ", historiaClinica=" + historiaClinica + '}';
    }
      
}
