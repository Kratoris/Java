/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GestionarUsuario.Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oscan
 */
@Entity

public class Usuario implements Serializable {

    @Id
    private String identificacion;

    @Basic
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String contrasena;
    private String correo;
    private String telefono;
    private String estado;

    public Usuario() {
    }

    public Usuario(String nombre, String primer_Apellido, String segundo_Apellido, String contrasena, String correo, String estado, String identificacion, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primer_Apellido;
        this.segundoApellido = segundo_Apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.estado = estado;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return " " + nombre + " " + primerApellido + " " + segundoApellido;
    }

}
