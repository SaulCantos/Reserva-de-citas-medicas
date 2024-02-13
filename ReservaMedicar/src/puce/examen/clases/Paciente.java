package puce.examen.clases;

import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private int edad;
    private String cedula;
    private double peso;
    private String fechaNacimiento;
    private String genero;
    private String codigo;
    private String direccion;

    public Paciente(String nombre, int edad, String cedula, double peso, String fechaNacimiento, String genero, String codigo, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.codigo = codigo;
        this.direccion = direccion;
    }

    public Paciente() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCedula() {
        return cedula;
    }

    public double getPeso() {
        return peso;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }
}
