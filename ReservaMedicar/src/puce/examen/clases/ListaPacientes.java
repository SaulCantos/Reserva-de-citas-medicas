package puce.examen.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaPacientes {
    private ArrayList<Paciente> pacientes;

    public ListaPacientes() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public ArrayList<Paciente> obtenerListaPacientes() {
        return pacientes;
    }

    public void ordenarPorNombre() {
        Collections.sort(pacientes, Comparator.comparing(Paciente::getNombre));
    }
}