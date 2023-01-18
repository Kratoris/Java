/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import GestionModelo.Administrador;
import GestionModelo.Estudiante;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilidades.NonexistentEntityException;

/**
 *
 * @author Ryzen 5
 */
public class ControladorPersistencia {
     EstudianteJpaController estudianteJPA = new EstudianteJpaController();
     AdministradorJpaController adminJPA = new AdministradorJpaController();

    public void crearEstudiante(Estudiante estudiante) {
        try {
            estudianteJPA.create(estudiante);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearAdministrador(Administrador administrador) {
        try {
            adminJPA.create(administrador);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEstudiante(int id) {
        try {
            estudianteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarAdministrador(int id) {
        try {
            adminJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEstudiante(Estudiante estudiante) {

        try {
            estudianteJPA.edit(estudiante);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarAdministrador(Administrador administrador) {

        try {
            adminJPA.edit(administrador);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Estudiante> listarEstudiantes() {

        List<Estudiante> listarEstudiantes = estudianteJPA.findEstudianteEntities();
        return listarEstudiantes;
    }
    
    public List<Administrador> listarAdministradores() {

        List<Administrador> listarAdministradores = adminJPA.findAdministradorEntities();
        return listarAdministradores;
    }
    
  public Estudiante encontrarEstudiante(int id) {
        Estudiante estudiante = estudianteJPA.findEstudiante(id);

        return estudiante;
    }
  
  public Administrador encontrarAdministrador(int id) {
        Administrador administrador = adminJPA.findAdministrador(id);

        return administrador;
    }
}
