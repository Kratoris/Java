/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarUsuario.Controlador;

import GestionarUsuario.Modelo.Usuario;
import GestionarUsuario.Vista.Principal;
import Persistencia.ControladorPersistencia;
import java.util.List;

/**
 *
 * @author Ryzen 5
 */
public class ControlAdministrador {

    ControladorPersistencia control = new ControladorPersistencia();
    Principal principal;

    public void registrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(principal.getTxtNombre());
        usuario.setPrimerApellido(principal.getTxtPrimerApellido());
        usuario.setSegundoApellido(principal.getTxtSegundoApellido());
        usuario.setContrasena(principal.getContrasena());
        usuario.setCorreo(principal.getTxtCorreo());
        usuario.setEstado(principal.getCbxEstado());
        usuario.setIdentificacion(principal.getTxtIdentificacion());
//        usuario.setTelefono(principal.getTxtTelefono_registro());
        System.out.println(usuario.toString());
        control.crearUsuario(usuario);
    }

    public String listarUsuarios() {
        String lista = "";
        List<Usuario> listaUsuarios = control.listarUsuarios();
        for (Usuario usu : listaUsuarios) {
            lista += usu.toString() + "\n";
        }
        return lista;
    }

    public Principal getPrincipal() {
        return principal;
    }
    
    public void consutar(String id){
        control.encontrarElemento(id);
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
