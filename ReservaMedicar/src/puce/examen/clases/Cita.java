package puce.examen.clases;

import java.time.LocalDate;

public class Cita {
    private LocalDate fechaCita;
    private String horaCita;
    private Paciente paciente;

    public Cita(LocalDate fechaCita, String horaCita, Paciente paciente) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.paciente = paciente;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
