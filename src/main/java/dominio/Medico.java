package dominio;

public class Medico {
    // Mapeo de la tabla Medico de la base de datos
    private String nombre;
    private String idMedico;
    private String tipoIdentificacion;
    private String NTarjetaProfesional;
    private double aniosExperiencia;
    private String especialidad;
    private String horaInicioAtencion;
    private String horaFinAtencion;

    // Constructores ---------------------------------------------------------------------
    public Medico() {
    }

    public Medico(String idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(String nombre, String tipoIdentificacion, String NTarjetaProfesional, double aniosExperiencia, String especialidad, String horaInicioAtencion, String horaFinAtencion) {
        this.nombre = nombre;
        this.tipoIdentificacion = tipoIdentificacion;
        this.NTarjetaProfesional = NTarjetaProfesional;
        this.aniosExperiencia = aniosExperiencia;
        this.especialidad = especialidad;
        this.horaInicioAtencion = horaInicioAtencion;
        this.horaFinAtencion = horaFinAtencion;
    }

    public Medico(String nombre, String idMedico, String tipoIdentificacion, String NTarjetaProfesional, double aniosExperiencia, String especialidad, String horaInicioAtencion, String horaFinAtencion) {
        this.nombre = nombre;
        this.idMedico = idMedico;
        this.tipoIdentificacion = tipoIdentificacion;
        this.NTarjetaProfesional = NTarjetaProfesional;
        this.aniosExperiencia = aniosExperiencia;
        this.especialidad = especialidad;
        this.horaInicioAtencion = horaInicioAtencion;
        this.horaFinAtencion = horaFinAtencion;
    }
    // ---------------------- Fin Constructores ----------------------------------------------------------------

    // ----------- Métodos Setters and Setters --------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNTarjetaProfesional() {
        return NTarjetaProfesional;
    }

    public void setNTarjetaProfesional(String NTarjetaProfesional) {
        this.NTarjetaProfesional = NTarjetaProfesional;
    }

    public double getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(double aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHoraInicioAtencion() {
        return horaInicioAtencion;
    }

    public void setHoraInicioAtencion(String horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }

    public String getHoraFinAtencion() {
        return horaFinAtencion;
    }

    public void setHoraFinAtencion(String horaFinAtencion) {
        this.horaFinAtencion = horaFinAtencion;
    }
    // --------- Finalización Setters and Getters -------------------------------------------------

    @Override
    public String toString() {
        return "Medico{" + "nombre=" + nombre + ", idMedico=" + idMedico + ", tipoIdentificacion=" + tipoIdentificacion + ", NTarjetaProfesional=" + NTarjetaProfesional + ", aniosExperiencia=" + aniosExperiencia + ", especialidad=" + especialidad + ", horaInicioAtencion=" + horaInicioAtencion + ", horaFinAtencion=" + horaFinAtencion + '}';
    }
}
