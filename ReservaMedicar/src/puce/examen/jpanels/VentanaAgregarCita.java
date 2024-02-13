package puce.examen.jpanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import puce.examen.clases.Paciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class VentanaAgregarCita extends JFrame {

    private JPanel contentPane;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField cedulaField;
    private JTextField pesoField;
    private JTextField fechaNacimientoField;
    private JComboBox<String> generoComboBox;
    private JTextField codigoField;
    private JTextField direccionField;
    private ReservasMedicasApp parent;

    public VentanaAgregarCita(ReservasMedicasApp parent) {
        this.parent = parent;
        setTitle("Agregar Cita");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 350, 286);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 11, 63, 14);
        contentPane.add(lblNombre);

        nombreField = new JTextField();
        nombreField.setBounds(133, 8, 169, 20);
        contentPane.add(nombreField);
        nombreField.setColumns(10);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(10, 36, 63, 14);
        contentPane.add(lblEdad);

        edadField = new JTextField();
        edadField.setBounds(133, 33, 169, 20);
        contentPane.add(edadField);
        edadField.setColumns(10);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(10, 61, 63, 14);
        contentPane.add(lblCedula);

        cedulaField = new JTextField();
        cedulaField.setBounds(133, 58, 169, 20);
        contentPane.add(cedulaField);
        cedulaField.setColumns(10);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(10, 86, 63, 14);
        contentPane.add(lblPeso);

        pesoField = new JTextField();
        pesoField.setBounds(133, 83, 169, 20);
        contentPane.add(pesoField);
        pesoField.setColumns(10);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setBounds(10, 111, 126, 14);
        contentPane.add(lblFechaNacimiento);

        fechaNacimientoField = new JTextField();
        fechaNacimientoField.setBounds(133, 108, 169, 20);
        contentPane.add(fechaNacimientoField);
        fechaNacimientoField.setColumns(10);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(10, 139, 126, 14);
        contentPane.add(lblGenero);

        generoComboBox = new JComboBox<>();
        generoComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Hombre", "Mujer"}));
        generoComboBox.setBounds(133, 136, 169, 20);
        contentPane.add(generoComboBox);

        JLabel lblCodigo = new JLabel("Código (3 dígitos):");
        lblCodigo.setBounds(10, 164, 126, 14);
        contentPane.add(lblCodigo);

        codigoField = new JTextField();
        codigoField.setBounds(133, 161, 169, 20);
        contentPane.add(codigoField);
        codigoField.setColumns(10);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 189, 126, 14);
        contentPane.add(lblDireccion);

        direccionField = new JTextField();
        direccionField.setBounds(133, 186, 169, 20);
        contentPane.add(direccionField);
        direccionField.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCita();
            }
        });
        btnGuardar.setBounds(133, 214, 89, 23);
        contentPane.add(btnGuardar);
    }

    private void guardarCita() {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        String cedula = cedulaField.getText();
        double peso = Double.parseDouble(pesoField.getText());
        String fechaNacimiento = fechaNacimientoField.getText();
        String genero = generoComboBox.getSelectedItem().toString();
        String codigo = codigoField.getText();
        String direccion = direccionField.getText();

        if (codigo.length() != 3) {
            JOptionPane.showMessageDialog(this, "El código debe tener exactamente 3 dígitos.", "Código Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Paciente paciente = new Paciente(nombre, edad, cedula, peso, fechaNacimiento, genero, codigo, direccion);
        parent.agregarPaciente(paciente);

        JOptionPane.showMessageDialog(this, "Cita guardada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.setText("");
        edadField.setText("");
        cedulaField.setText("");
        pesoField.setText("");
        fechaNacimientoField.setText("");
        generoComboBox.setSelectedIndex(0);
        codigoField.setText("");
        direccionField.setText("");
    }
}
