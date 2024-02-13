package puce.examen.jpanels;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import puce.examen.clases.Cita;

class PanelCitas extends JPanel {
    private JTextArea citasArea;

    public PanelCitas() {
        setLayout(new BorderLayout());
        citasArea = new JTextArea(10, 40);
        citasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(citasArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void actualizarCitas(ArrayList<Cita> citas) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                citasArea.setText("");
                for (Cita cita : citas) {
                    citasArea.append("Fecha de Cita: " + cita.getFechaCita() + ", Paciente: " + cita.getPaciente().getNombre() + "\n");
                }
            }
        });
    }

	public ArrayList<Cita> getCitas() {
		return null;
	}
}
