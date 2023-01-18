/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaxyz;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class Vendedor extends Empleado {

    Coche coche;
    String telefono_movil;
    String area_venta;
    int porcentaje_comision;
    ArrayList<String> clientes= new ArrayList<String>();

    public Vendedor(Coche coche, String telefono_movil, String area_venta, int porcentaje_comision, String nombre, String apellido, String DNI, String direccion, String telefono, long salario) {
        super(nombre, apellido, DNI, direccion, telefono, salario);
        this.coche = coche;
        this.telefono_movil = telefono_movil;
        this.area_venta = area_venta;
        this.porcentaje_comision = porcentaje_comision;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getArea_venta() {
        return area_venta;
    }

    public void setArea_venta(String area_venta) {
        this.area_venta = area_venta;
    }

    public int getPorcentaje_comision() {
        return porcentaje_comision;
    }

    public void setPorcentaje_comision(int porcentaje_comision) {
        this.porcentaje_comision = porcentaje_comision;
    }
    
    public void agregarCliente(String c){
        this.clientes.add(c);
    }
    
    public void quitarCliente(String c){
        clientes.remove(c);
      
    }

    public ArrayList<String> getClientes() {
        return clientes;
    }
    
    @Override
    public void imprimir() {
        String listado="Lista";
        for(String c : clientes){
            listado+=c+"\n";
        }
        
 JOptionPane.showMessageDialog(null,"Información del Vendedor:\n"
                  + "Nombres:"+this.getNombre()
                  + "\nApellidos:"+this.getApellido()
                  + "\nDNI:"+this.getDNI()
                  + "\nTelefono:"+this.getTelefono()
                  + "\nDireccion:"+this.getDireccion()
                  + "\nSalario:"+this.getSalario()
                  + "\nZona de venta:"+this.getArea_venta()
                  + "\nCoche:"+this.getCoche()
                  + "\nClientes:"+listado
                    );

    }

    @Override
    public void incrementarSalario() {
           this.salario = (long) (this.getSalario() * 1.1);
    }
    
}
