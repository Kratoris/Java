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
public class JefeZona extends Empleado {

    Secretario secreatario;
    ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    Coche coche;

    public JefeZona(Secretario secreatario, Coche coche, String nombre, String apellido, String DNI, String direccion, String telefono, long salario) {
        super(nombre, apellido, DNI, direccion, telefono, salario);
        this.secreatario = secreatario;
        this.coche = coche;
    }

    public Secretario getSecreatario() {
        return secreatario;
    }

    public void setSecreatario(Secretario secreatario) {
        this.secreatario = secreatario;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }
    
    public void agregarVendedor(Vendedor v){
        vendedores.add(v);
    } 
    
    public void eliminarVendedor(int indice){
        vendedores.remove(indice);
    }

    @Override
    public void imprimir() {
           String listado="Lista";
        for(Vendedor v : vendedores){
            listado+=v.getNombre()+" "+v.getApellido()+"\n";
        }
        
 JOptionPane.showMessageDialog(null,"Información del Vendedor:\n"
                  + "Nombres:"+this.getNombre()
                  + "\nApellidos:"+this.getApellido()
                  + "\nDNI:"+this.getDNI()
                  + "\nTelefono:"+this.getTelefono()
                  + "\nDireccion:"+this.getDireccion()
                  + "\nSalario:"+this.getSalario()
                  + "\nSecretario:"+this.secreatario.getNombre()+" "+secreatario.getApellido()
                  + "\nCoche:"+this.getCoche()
                  + "\nVendedores:\n"+listado
                    );


    }

    @Override
    public void incrementarSalario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
