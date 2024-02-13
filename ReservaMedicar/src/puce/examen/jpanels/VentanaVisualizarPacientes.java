package puce.examen.jpanels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import puce.examen.clases.Paciente;

public class VentanaVisualizarPacientes extends JFrame {
    private JPanel panelPrincipal;

    public VentanaVisualizarPacientes(ArrayList<Paciente> pacientes) {
        setTitle("Visualizar Pacientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(pacientes);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents(ArrayList<Paciente> pacientes) {
        panelPrincipal = new JPanel(new GridLayout(0, 2, 5, 10));
        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (Paciente paciente : pacientes) {
            JPanel panelPaciente = new JPanel(new GridLayout(0, 1));
            panelPaciente.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel labelNombre = new JLabel("Nombre: " + paciente.getNombre());
            JLabel labelEdad = new JLabel("Edad: " + paciente.getEdad());
            JLabel labelCedula = new JLabel("Cédula: " + paciente.getCedula());

            panelPaciente.add(labelNombre);
            panelPaciente.add(labelEdad);
            panelPaciente.add(labelCedula);

            panelPrincipal.add(panelPaciente);
        }
    }

    public void actualizarPacientes(ArrayList<Paciente> pacientes) {
        panelPrincipal.removeAll();
        for (Paciente paciente : pacientes) {
            JPanel panelPaciente = new JPanel(new GridLayout(0, 1));
            panelPaciente.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel labelNombre = new JLabel("Nombre: " + paciente.getNombre());
            JLabel labelEdad = new JLabel("Edad: " + paciente.getEdad());
            JLabel labelCedula = new JLabel("Cédula: " + paciente.getCedula());

            panelPaciente.add(labelNombre);
            panelPaciente.add(labelEdad);
            panelPaciente.add(labelCedula);

            panelPrincipal.add(panelPaciente);
        }
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private int obtenerIndicePacienteAModificar(ArrayList<Paciente> pacientes) {
        return -1;
    }

    private void modificarDatosPaciente(Paciente paciente) {
    }
}
