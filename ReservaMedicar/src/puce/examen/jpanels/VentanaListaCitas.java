package puce.examen.jpanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import puce.examen.clases.Cita;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VentanaListaCitas extends JFrame {

    private JPanel contentPane;
    private JPanel citasPanel;

    public VentanaListaCitas(ArrayList<Cita> citas) {
        setTitle("Lista de Citas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        citasPanel = new JPanel();
        citasPanel.setLayout(new BoxLayout(citasPanel, BoxLayout.Y_AXIS)); // Cambio de GridLayout a BoxLayout
        scrollPane.setViewportView(citasPanel);

        actualizarListaCitas(citas);
    }

    public void actualizarListaCitas(List<Cita> listaCitas) {
        Collections.sort(listaCitas, new Comparator<Cita>() {
            @Override
            public int compare(Cita cita1, Cita cita2) {
                int comparacionFecha = cita1.getFechaCita().compareTo(cita2.getFechaCita());
                if (comparacionFecha == 0) {
                    return cita1.getHoraCita().compareTo(cita2.getHoraCita());
                }
                return comparacionFecha;
            }
        });

        citasPanel.removeAll();

        for (Cita cita : listaCitas) {
            JPanel citaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            citaPanel.setBorder(BorderFactory.createEtchedBorder());
            JLabel fechaLabel = new JLabel("Fecha de Cita: " + cita.getFechaCita() + " - Hora: " + cita.getHoraCita());
            JLabel nombreLabel = new JLabel("Nombre del Paciente: " + cita.getPaciente().getNombre());
            citaPanel.add(fechaLabel);
            citaPanel.add(nombreLabel);
            citasPanel.add(citaPanel);
        }

        citasPanel.revalidate();
        citasPanel.repaint();
    }
}
