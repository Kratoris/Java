/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import persistencia.ControladorPersistencia;

/**
 *
 * @author Ryzen 5
 */
@Entity
@Table (name="registros")
public class Registro {
    
    @Id
    private int idRegistro;
    
    ControladorPersistencia control;
    @Basic
//            @Column (name= "idEstudiante");
    Estudiante estudiante;
//    @Column (name= "idAdministrador");
    Administrador administrador;
//    @Column (name= "estadoRegistro");
    private String estadoRegistro;

    public Registro() {
    }

    public void registrarEstudiante(Estudiante estudiante) {

        Estudiante est = new Estudiante();
        est.setIdEstudiante(estudiante.getIdEstudiante());
        est.setIdUsuario(estudiante.getIdUsuario());
        est.setNombre(estudiante.getNombre());
        est.setPrimerApellido(estudiante.getPrimerApellido());
        est.setSegundoApellido(estudiante.getSegundoApellido());
        est.setContrasena(estudiante.getContrasena());
        est.setCorreo(estudiante.getCorreo());
        est.setEstado("A");
        control.crearEstudiante(est);
    }

    public void registrarAdministrador(Administrador administrador) {
        Administrador admin = new Administrador();
        admin.setIdAdminitrador(administrador.getIdAdminitrador());
        admin.setIdUsuario(administrador.getIdUsuario());
        admin.setNombre(administrador.getNombre());
        admin.setPrimerApellido(administrador.getPrimerApellido());
        admin.setSegundoApellido(administrador.getSegundoApellido());
        admin.setContrasena(administrador.getContrasena());
        admin.setCorreo(administrador.getCorreo());
        admin.setEstado("A");
        control.crearAdministrador(admin);
    }

    public void editarEstudiante(Estudiante estudiante) {
        Estudiante est = new Estudiante();
        est.setIdEstudiante(estudiante.getIdEstudiante());
        est.setIdUsuario(estudiante.getIdUsuario());
        est.setNombre(estudiante.getNombre());
        est.setPrimerApellido(estudiante.getPrimerApellido());
        est.setSegundoApellido(estudiante.getSegundoApellido());
        est.setContrasena(estudiante.getContrasena());
        est.setCorreo(estudiante.getCorreo());
        est.setEstado("A");
        control.modificarEstudiante(est);
    }

    public void editarAdministrador(Administrador administrador) {
        Administrador admin = new Administrador();
        admin.setIdAdminitrador(administrador.getIdAdminitrador());
        admin.setIdUsuario(administrador.getIdUsuario());
        admin.setNombre(administrador.getNombre());
        admin.setPrimerApellido(administrador.getPrimerApellido());
        admin.setSegundoApellido(administrador.getSegundoApellido());
        admin.setContrasena(administrador.getContrasena());
        admin.setCorreo(administrador.getCorreo());
        admin.setEstado("A");
        control.modificarAdministrador(admin);
    }
    
    public Estudiante encontrarEstudiante(int id){
        Estudiante estudiante = new Estudiante();
        return control.encontrarEstudiante(id);
    }
    
    public Administrador encontrarAdministrador(int id){
        Administrador administrador = new Administrador();
        return control.encontrarAdministrador(id);
    }

    public String consultarEstudiante(int id) {
        String resultado = ""; 
        
        Estudiante est = new Estudiante();
        est = control.encontrarEstudiante(id);
        if(est.getEstado().equals("A")){
            est.toString();
        }else{
            resultado = "El estudiante no existe";
        }
        return resultado;
    }

    public String consultarAdministrador(int id) {
        String resultado = ""; 
        Administrador admin = new Administrador();
        admin = control.encontrarAdministrador(id);
        if(admin.getEstado().equals("A")){
            admin.toString();
        }else{
            resultado = "El estudiante no existe";
        }
        return resultado;
        
    }

    public void eliminarEstudiante(int id) {
        Estudiante estudiante = new Estudiante();

        estudiante = control.encontrarEstudiante(id);
        estudiante.setEstado("I");
        control.modificarEstudiante(estudiante);

    }
    
    public void eliminarAdministrador(int id) {
        Administrador admin = new Administrador();

        admin = control.encontrarAdministrador(id);
        admin.setEstado("I");
        control.modificarAdministrador(admin);

    }

}
