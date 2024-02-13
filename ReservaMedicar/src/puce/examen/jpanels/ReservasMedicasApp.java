package puce.examen.jpanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import puce.examen.clases.Cita;
import puce.examen.clases.Paciente;

public class ReservasMedicasApp extends JFrame {
    private ArrayList<Cita> citas = new ArrayList<>();
    private HashMap<String, Paciente> pacientes = new HashMap<>();
    private VentanaListaCitas ventanaListaCitas;
    
    public ReservasMedicasApp() {
        setTitle("Reservas Médicas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuArchivo.add(menuItemSalir);

        JMenu menuCitas = new JMenu("Citas");
        menuBar.add(menuCitas);

        JMenuItem menuItemAgregarCita = new JMenuItem("Agregar Cita");
        menuItemAgregarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarCita();
            }
        });
        menuCitas.add(menuItemAgregarCita);

        JMenuItem menuItemVisualizarPacientes = new JMenuItem("Visualizar Pacientes");
        menuItemVisualizarPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaVisualizarPacientes();
            }
        });
        menuCitas.add(menuItemVisualizarPacientes);
        
        JMenuItem menuItemAgendaCita = new JMenuItem("Agenda de Citas");
        menuItemAgendaCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgendaCitas();
            }
        });
        menuCitas.add(menuItemAgendaCita);

        JMenu menuCalendario = new JMenu("Calendario");
        menuBar.add(menuCalendario);

        JMenuItem menuItemListaCitas = new JMenuItem("Lista de Citas");
        menuItemListaCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaListaCitas();
            }
        });
        menuCalendario.add(menuItemListaCitas);

        setVisible(true);
    }

    private void abrirVentanaAgregarCita() {
        VentanaAgregarCita ventanaAgregarCita = new VentanaAgregarCita(this);
        ventanaAgregarCita.setVisible(true);
    }

    void abrirVentanaListaCitas() {
        if (!citas.isEmpty()) {
            VentanaListaCitas ventanaListaCitas = new VentanaListaCitas(citas);
            ventanaListaCitas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay citas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirVentanaAgendaCitas() {
        AgendaCita agendaCita = new AgendaCita(this, citas);
        agendaCita.setVisible(true);
    }

    private void abrirVentanaVisualizarPacientes() {
        if (!pacientes.isEmpty()) {
            ArrayList<Paciente> listaPacientes = new ArrayList<>(pacientes.values());
            VentanaVisualizarPacientes ventanaVisualizarPacientes = new VentanaVisualizarPacientes(listaPacientes);
            ventanaVisualizarPacientes.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay pacientes registrados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.put(paciente.getNombre(), paciente);
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public boolean verificarCitaExistente(LocalDate fechaCita) {
        for (Cita cita : citas) {
            if (cita.getFechaCita().equals(fechaCita)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public HashMap<String, Paciente> getPacientes() {
        return pacientes;
    }

    public VentanaListaCitas getVentanaListaCitas() {
        if (ventanaListaCitas == null) {
            ventanaListaCitas = new VentanaListaCitas(new ArrayList<Cita>());
        }
        return ventanaListaCitas;
    }
    
    public static void main(String[] args) {
        new ReservasMedicasApp();
    }

    public void setVentanaListaCitas(VentanaListaCitas ventanaListaCitas) {
        this.ventanaListaCitas = ventanaListaCitas;
    }
}
