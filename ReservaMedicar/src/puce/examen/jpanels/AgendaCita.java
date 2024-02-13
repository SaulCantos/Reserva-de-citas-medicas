package puce.examen.jpanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import puce.examen.clases.Cita;
import puce.examen.clases.Paciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class AgendaCita extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> pacienteComboBox;
    private JTextArea pacienteInfoArea;
    private JComboBox<String> areaMedicaComboBox;
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> consultorioComboBox;
    private ReservasMedicasApp parent;
    private JSpinner fechaCitaSpinner;
    private JTextField horaTextField;
    private List<Cita> listaCitas; // Lista de citas

    public AgendaCita(ReservasMedicasApp parent, List<Cita> listaCitas) {
        this.parent = parent;
        this.listaCitas = listaCitas; // Inicializar lista de citas
        setTitle("Agenda de Citas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 446, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPaciente = new JLabel("Seleccionar Paciente:");
        lblPaciente.setBounds(10, 11, 136, 14);
        contentPane.add(lblPaciente);

        pacienteComboBox = new JComboBox<>();
        pacienteComboBox.setBounds(156, 8, 150, 20);
        contentPane.add(pacienteComboBox);

        JButton btnAgregarPaciente = new JButton("Agregar Paciente");
        btnAgregarPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        });
        btnAgregarPaciente.setBounds(309, 7, 115, 23);
        contentPane.add(btnAgregarPaciente);

        JLabel lblPacienteInfo = new JLabel("Información del Paciente:");
        lblPacienteInfo.setBounds(10, 40, 200, 14);
        contentPane.add(lblPacienteInfo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 65, 400, 100);
        contentPane.add(scrollPane);

        pacienteInfoArea = new JTextArea();
        pacienteInfoArea.setEditable(false);
        scrollPane.setViewportView(pacienteInfoArea);

        JLabel lblAreaMedica = new JLabel("Elegir Área Médica:");
        lblAreaMedica.setBounds(10, 180, 200, 14);
        contentPane.add(lblAreaMedica);

        areaMedicaComboBox = new JComboBox<>();
        areaMedicaComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Medicina General", "Odontología"}));
        areaMedicaComboBox.setBounds(170, 177, 150, 20);
        contentPane.add(areaMedicaComboBox);

        JLabel lblDoctor = new JLabel("Elige un Doctor:");
        lblDoctor.setBounds(10, 210, 200, 14);
        contentPane.add(lblDoctor);

        doctorComboBox = new JComboBox<>();
        doctorComboBox.setBounds(170, 207, 150, 20);
        contentPane.add(doctorComboBox);

        JLabel lblConsultorio = new JLabel("Elige Consultorio:");
        lblConsultorio.setBounds(10, 240, 200, 14);
        contentPane.add(lblConsultorio);

        consultorioComboBox = new JComboBox<>();
        consultorioComboBox.setBounds(170, 237, 150, 20);
        contentPane.add(consultorioComboBox);

        SpinnerDateModel spinnerModel = new SpinnerDateModel();
        spinnerModel.setCalendarField(Calendar.DAY_OF_MONTH);
        fechaCitaSpinner = new JSpinner(spinnerModel);
        fechaCitaSpinner.setEditor(new JSpinner.DateEditor(fechaCitaSpinner, "dd/MM/yyyy"));
        fechaCitaSpinner.setBounds(170, 270, 150, 20);
        contentPane.add(fechaCitaSpinner);

        JLabel lblHora = new JLabel("Hora (HH:mm):");
        lblHora.setBounds(10, 302, 150, 20);
        contentPane.add(lblHora);
        
        horaTextField = new JTextField();
        horaTextField.setBounds(170, 302, 150, 20);
        contentPane.add(horaTextField);

        JButton btnGuardarCita = new JButton("Guardar Cita");
        btnGuardarCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCita();
            }
        });
        btnGuardarCita.setBounds(170, 333, 150, 23);
        contentPane.add(btnGuardarCita);
        
        JLabel lblEligeFechaDe = new JLabel("Elige Fecha de Cita:");
        lblEligeFechaDe.setBounds(10, 273, 200, 14);
        contentPane.add(lblEligeFechaDe);

        llenarDatos();
        llenarPacientes();
    }

    private void agregarPaciente() {
        String pacienteSeleccionado = pacienteComboBox.getSelectedItem().toString();
        if (pacienteSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente.", "Paciente No Seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Paciente paciente = parent.getPacientes().get(pacienteSeleccionado);
        mostrarInfoPaciente(paciente);
    }

    private void mostrarInfoPaciente(Paciente paciente) {
        String info = "Nombre: " + paciente.getNombre() + "\n";
        info += "Edad: " + paciente.getEdad() + "\n";
        info += "Cédula: " + paciente.getCedula() + "\n";
        pacienteInfoArea.setText(info);
    }

    private void llenarDatos() {
        doctorComboBox.addItem("David Delgado");
        doctorComboBox.addItem("Jephersoon Chavez");

        consultorioComboBox.addItem("Consultorio de Medicina General");
        consultorioComboBox.addItem("Consultorio de Odontología");
    }

    private void llenarPacientes() {
        for (Map.Entry<String, Paciente> entry : parent.getPacientes().entrySet()) {
            pacienteComboBox.addItem(entry.getKey());
        }
    }

    private void guardarCita() {
        String pacienteSeleccionado = pacienteComboBox.getSelectedItem().toString();
        if (pacienteSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente.", "Paciente No Seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Paciente paciente = parent.getPacientes().get(pacienteSeleccionado);

        Date fechaCita = new Date(((java.util.Date) fechaCitaSpinner.getValue()).getTime());

        String hora = horaTextField.getText();

        if (!validarHora(hora)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una hora válida en formato HH:mm.", "Hora Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cita cita = new Cita(fechaCita.toLocalDate(), hora, paciente);
        listaCitas.add(cita); // Agregar la nueva cita a la lista de citas

        parent.getVentanaListaCitas().actualizarListaCitas(listaCitas); // Actualizar la lista de citas en la ventana de lista de citas
    }

    private boolean validarHora(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            sdf.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
