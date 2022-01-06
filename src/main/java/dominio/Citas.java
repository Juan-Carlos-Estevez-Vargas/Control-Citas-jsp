package dominio;

public class Citas {
    // Mapeo de la tabla Citas de la base de datos
    private int idCita;
    private String medico;
    private String paciente;
    private String hora;

    // ---------- Constructores -----------------------------------------------------------
    public Citas() {
    }

    public Citas(int idCita) {
        this.idCita = idCita;
    }

    public Citas(String medico, String paciente, String hora) {
        this.medico = medico;
        this.paciente = paciente;
        this.hora = hora;
    }

    public Citas(int idCita, String medico, String paciente, String hora) {
        this.idCita = idCita;
        this.medico = medico;
        this.paciente = paciente;
        this.hora = hora;
    }
    // ---------- Fin Constructores ------------------------------------------------------
    
    // ------- Getters and Setters --------------------------------------------------------
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    // ------------- Fin Getters and Setters ----------------------------------------------

    @Override
    public String toString() {
        return "Citas{" + "idCita=" + idCita + ", medico=" + medico + ", paciente=" + paciente + ", hora=" + hora + '}';
    }

}
