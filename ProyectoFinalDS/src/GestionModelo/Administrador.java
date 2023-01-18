/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Ryzen 5
 */

@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Administrador extends Usuario {

    @Column (name= "idAdminitrador")
    private int idAdminitrador;

    public Administrador() {
    }

    public Administrador(int idAdminitrador, int idUsuario, String nombre, String primerApellido, String segundoApellido, String contrasena, String correo, String estado) {
        super(idUsuario, nombre, primerApellido, segundoApellido, contrasena, correo, estado);
        this.idAdminitrador = idAdminitrador;
    }

    public int getIdAdminitrador() {
        return idAdminitrador;
    }

    public void setIdAdminitrador(int idAdminitrador) {
        this.idAdminitrador = idAdminitrador;
    }

    @Override
    public String toString() {
        return "Administrador\n" + "idAdminitrador :" + this.getIdAdminitrador()
                + "\n" + "Primer apellido: " + this.getPrimerApellido()
                + "\n" + "Segundo apellido:" + this.getSegundoApellido()
                + "\n" +  "contrasena" + this.getContrasena()
                + "\n" +  "correo" + this.getCorreo()
                + "\n" +  "estado" + this.getEstado();   
    }
    

}
