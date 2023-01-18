package GestionModelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ryzen 5
 */
@Entity
@Table(name = "estudiantes")
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Estudiante extends Usuario implements Serializable {

 
    @Column(name = "idEstudiante")
    private int idEstudiante;

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int idUsuario, String nombre, String primerApellido, String segundoApellido, String contrasena, String correo, String estado) {
        super(idUsuario, nombre, primerApellido, segundoApellido, contrasena, correo, estado);
        this.idEstudiante = idEstudiante;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante " + "\n"+ "nombre:" + this.getNombre()
                + "\n" + "Primer apellido: " + this.getPrimerApellido()
                + "\n" + "Segundo apellido:" + this.getSegundoApellido()
                + "\n" +  "contrasena" + this.getContrasena()
                + "\n" +  "correo" + this.getCorreo()
                + "\n" +  "estado" + this.getEstado();       
    }

   

   

    
   

}
