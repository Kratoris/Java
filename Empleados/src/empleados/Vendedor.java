package empleados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Vendedor extends Empleado {

    //Atributos:
    private Coche coche;
    private int telMovil;
    private String areaVentas;
    private double porcentajeVentas;
    private ArrayList<String> clientes = new ArrayList<>();

    //Constructores:
    public Vendedor() {
    }

    public Vendedor(Coche coche, int telMovil, String areaVentas, double porcentajeVentas) {
        this.coche = coche;
        this.telMovil = telMovil;
        this.areaVentas = areaVentas;
        this.porcentajeVentas = porcentajeVentas;
    }

    public Vendedor(Coche coche, int telMovil, String areaVentas, double porcentajeVentas, String nombre, String apellido, String direccion, int dni, int antiguedad, int telefono, double salario) {
        super(nombre, apellido, direccion, dni, antiguedad, telefono, salario);
        this.coche = coche;
        this.telMovil = telMovil;
        this.areaVentas = areaVentas;
        this.porcentajeVentas = porcentajeVentas;
    }

    //Metodos:
    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public int getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(int telMovil) {
        try {
            this.telMovil = telMovil;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
        }
    }

    public String getAreaVentas() {
        return areaVentas;
    }

    public void setAreaVentas(String areaVentas) {
        this.areaVentas = areaVentas;
    }

    public void addCliente(String ciente) {
        try {
            clientes.add(ciente);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Indice fuera de rango");
        }
    }

    public void borrarCliente(String cliente) {
        try {
            clientes.remove(cliente);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Indice fuera de rango");
        }
    }

    public String listarClientes() {
        String mensaje = "";

        for (String cl : clientes) {
            mensaje += cl + ", ";
        }

        return mensaje;
    }

    @Override
    public void imprimir() {
        String mensaje;

        mensaje = "\nVENDEDOR: \nNombre: " + getNombre() + " Apellido: " + getApellido() + " Direccion: "
                + getDireccion() + " DNI: " + getDni() + " Telefono: " + getTelefono()
                + " Telefono Movil" + telMovil + " Salario " + getSalario() + " Porcentaje de Ventas: "
                + porcentajeVentas + " Anios de antiguedad: " + getAntiguedad() + " Coche: " + coche
                + " Area de ventas: " + areaVentas + " Lista de Clientes: " + listarClientes();

        System.out.println(mensaje);
    }

    @Override
    public void incrementoSalario() {
        setSalario(getSalario() * 1.10);
    }

}
