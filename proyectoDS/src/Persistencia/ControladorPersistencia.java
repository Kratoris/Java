/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import GestionarUsuario.Modelo.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryzen 5
 */
public class ControladorPersistencia {

    UsuarioJpaController usuJPA = new UsuarioJpaController();

       public void crearUsuario(Usuario usuario) {
        try {
            usuJPA.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarUsuario(String idUsuario) {
        try {
            usuJPA.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        
        try {
            usuJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listarUsuarios() {
        List <Usuario> listarUsuarios = usuJPA.findUsuarioEntities();
        return listarUsuarios;
    }

    public Usuario encontrarElemento(String id) {
        Usuario usu = usuJPA.findUsuario(id);
        
        return usu;
    }
    
}
