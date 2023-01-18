package empleados;

import javax.swing.JOptionPane;

public abstract class Empleado {

    //Atributos:
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    private int antiguedad;
    private int telefono;
    private double salario;
    private Empleado supervisor;

    //Constructores:
    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String direccion, int dni, int antiguedad, int telefono, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.antiguedad = antiguedad;
        this.telefono = telefono;
        this.salario = salario;
    }

    //Metodos:
    public Empleado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        try {
            this.dni = dni;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        try {
            this.antiguedad = antiguedad;
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {

        try {
            this.telefono = telefono;
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        try {
            this.salario = salario;
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    public abstract void imprimir();

    public abstract void incrementoSalario();

}
