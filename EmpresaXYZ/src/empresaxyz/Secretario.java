/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaxyz;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class Secretario extends Empleado {

    String despacho, fax;

    public Secretario(String despacho, String fax, String nombre, String apellido, String DNI, String direccion, String telefono, long salario) {
        super(nombre, apellido, DNI, direccion, telefono, salario);
        this.despacho = despacho;
        this.fax = fax;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @Override
    public void imprimir() {
          JOptionPane.showMessageDialog(null,"Información del Secretario:\n"
                  + "Nombres:"+this.getNombre()
                  + "\nApellidos:"+this.getApellido()
                  + "\nDNI:"+this.getDNI()
                  + "\nTelefono:"+this.getTelefono()
                  + "\nDireccion:"+this.getDireccion()
                  + "\nSalario:"+this.getSalario()
                  + "\nDespacho:"+this.getDespacho()
                  + "\nfax:"+this.getFax()
                    );
    }

    @Override
    public void incrementarSalario() {
         this.salario = (long) (this.getSalario() * 1.05);
    }
    
}
