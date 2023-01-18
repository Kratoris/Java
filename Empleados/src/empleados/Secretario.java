package empleados;

import javax.swing.JOptionPane;

public class Secretario extends Empleado {

    //Atributos:
    private String despacho;
    private int numFax;

    //Constructores:
    public Secretario() {
    }

    public Secretario(String despacho, int numFax) {
        this.despacho = despacho;
        this.numFax = numFax;
    }

    public Secretario(String despacho, int numFax, String nombre, String apellido, String direccion, int dni, int antiguedad, int telefono, double salario) {
        super(nombre, apellido, direccion, dni, antiguedad, telefono, salario);
        this.despacho = despacho;
        this.numFax = numFax;
    }

    //Metodos:
    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public int getNumFax() {
        return numFax;
    }

    public void setNumFax(int numFax) {
        try {
            this.numFax = numFax;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    @Override
    public void imprimir() {
        String mensaje;

        mensaje = "\nSECRETARIO: \nNombre: " + getNombre() + " Apellido: " + getApellido() + " Direccion: "
                + getDireccion() + " DNI: " + getDni() + " Despacho: " + despacho + " Numero de Fax: " + numFax
                + " Telefono: " + getTelefono() + " Salario " + getSalario() + " Anios de antiguedad: " + getAntiguedad();

        System.out.println(mensaje);
    }

    @Override
    public void incrementoSalario() {
        setSalario(getSalario() * 1.05);
    }
}
