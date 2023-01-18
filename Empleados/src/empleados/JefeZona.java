package empleados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JefeZona extends Empleado {

    //Atributos:
    private String despacho;
    private Secretario secretario;
    private Coche coche;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();

    //Constructores:
    public JefeZona() {
    }

    public JefeZona(String despacho, Secretario secretario, Coche coche) {
        this.despacho = despacho;
        this.secretario = secretario;
        this.coche = coche;
    }

    public JefeZona(String despacho, Secretario secretario, Coche coche, String nombre, String apellido, String direccion, int dni, int antiguedad, int telefono, double salario) {
        super(nombre, apellido, direccion, dni, antiguedad, telefono, salario);
        this.despacho = despacho;
        this.secretario = secretario;
        this.coche = coche;
    }

    //Metodos:
    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public void addVendedor(Vendedor vendedor) {

        try {
            vendedores.add(vendedor);
        } 
        catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Indice fuera de rango");
        }
    }

    public void borrarVendedor(Vendedor vendedor) {
        try {
            vendedores.remove(vendedor);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Indice fuera de rango");
        }
    }

    public String listarVendedores() {
        String lista = "";

        for (Vendedor cl : vendedores) {
            lista += cl.getNombre() + " " + cl.getApellido() + ", ";
        }

        return lista;
    }

    @Override
    public void imprimir() {
        String mensaje;

        mensaje = "\nJEFE DE ZONA: \nNombre: " + getNombre() + " Despacho: " + despacho + " Secretario: " + secretario
                + coche + " Apellido: " + getApellido() + " Direccion: " + getDireccion() + " DNI: "
                + getDni() + " Telefono: " + getTelefono() + " Salario " + getSalario() + " Anios de antiguedad: "
                + getAntiguedad() + " Lista de Vendedores: " + listarVendedores();

        System.out.println(mensaje);
    }

    @Override
    public void incrementoSalario() {
        setSalario(getSalario() * 1.20);
    }
}
