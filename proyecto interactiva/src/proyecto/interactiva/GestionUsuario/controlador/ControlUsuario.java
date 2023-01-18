/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.interactiva.GestionUsuario.controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyecto.interactiva.GestionUsuario.modelo.Usuario;
import proyecto.interactiva.GestionUsuario.vista.*;
import proyecto.interactiva.Principal;

/**
 *
 * @author Frank
 */
public class ControlUsuario {

    //Atributos:
    public Principal p;
    Login_Usuario login;
    Registro_Usuario registro;
    public Listado listado;
    EditorUsuario ed;
    public static ArrayList<Usuario> users = new ArrayList<>();
    public static ArrayList<Usuario> Clientes = new ArrayList<>();
    public static ArrayList<Usuario> Administradores = new ArrayList<>();
    public static ArrayList<Usuario> Agentes = new ArrayList<>();
    public static boolean bandera;
    int numUsuarios;
    public static Usuario usuario_sesion;

    public ControlUsuario() {
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        ControlUsuario.bandera = bandera;
    }

    public Login_Usuario getLogin() {
        return login;
    }

    public void setLogin(Login_Usuario login) {
        this.login = login;
    }

    public Registro_Usuario getRegistro() {
        return registro;
    }

    public void setRegistro(Registro_Usuario registro) {
        this.registro = registro;
    }

    public Listado getListado() {
        return listado;
    }

    public static Usuario getUsuario_sesion() {
        return usuario_sesion;
    }

    public static void setUsuario_sesion(Usuario usuario_sesion) {
        ControlUsuario.usuario_sesion = usuario_sesion;
    }

    public void setListado(Listado listado) {
        this.listado = listado;
    }

    public EditorUsuario getEd() {
        return ed;
    }

    public void setEd(EditorUsuario ed) {
        this.ed = ed;
    }

    public void registro() {
        Usuario u = new Usuario();

        u.setIdentificación(Long.parseLong(this.registro.getTxtDocumento_registro()));
        u.setNombre(this.registro.getTxtNombres_registro());
        u.setTelefono(this.registro.getTxtTelefono_registro());
        u.setCorreo(this.registro.getTxtCorreo_registro());
        u.setTipoUsuario(this.registro.getCbxUsuarios());

        String temp02 = Character.toString(u.getNombre().trim().charAt(u.getNombre().trim().length() - 1));
        String temp01 = Character.toString(u.getNombre().trim().charAt(0));
        String contrasena = temp01 + u.getIdentificación() + temp02;
        u.setContrasena(contrasena.toUpperCase());

        if (!u.registrarUsuario()) {
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
        }
    }

    public void inicioSesion() {
        long id = Long.parseLong(login.getIdentificacion());
        String contrasena = login.getContrasena();
        Usuario u = new Usuario();
        u.setIdentificación(id);
        u.setContrasena(contrasena);
        if (ControlUsuario.usuario_sesion == null) {
            ControlUsuario.usuario_sesion = u.iniciarSesion();
            if (usuario_sesion != null) {
                JOptionPane.showMessageDialog(null, "Bienvenido\n" + usuario_sesion.getNombre());
                login.dispose();
                login.p.mostrarUsuario();
                listadoTipo();
                //Cliente Administrador Agente de ventas
                for (int i = 0; i < this.numUsuarios; i++) {
                    if (users.get(i).getIdentificación() == id) {
                        if (users.get(i).getTipoUsuario().equals("Administrador")) {
                            login.habilitarMenu("Usuarios");
                            login.habilitarMenu("Cerrar Sesión");
                            setBandera(true);
                        } else if (users.get(i).getTipoUsuario().equals("Agente de ventas")) {
                            login.habilitarMenu("Usuarios");
                            login.habilitarMenu("Cerrar Sesión");
                            setBandera(true);
                        } else if (users.get(i).getTipoUsuario().equals("Cliente")) {
                            login.habilitarMenu("Cerrar Sesión");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario en la sesión");
        }
    }

    public void listadoUsuario() {
        Usuario usu = new Usuario();

        ArrayList<Usuario> usuarios = usu.listarUsuarios();
        for (Usuario temp : usuarios) {
            String data[] = {String.valueOf(temp.getNumUsu()), String.valueOf(temp.getIdentificación()), temp.getNombre(), temp.getCorreo(), temp.getTelefono(), temp.getTipoUsuario(), temp.getContrasena()};
            this.listado.addFila(data);
        }
    }

    public void seleccionarUsuario(int id) {
        Usuario u = new Usuario();
        u = u.seleccionarUsuario(id);

        EditorUsuario US = new EditorUsuario();
        US.setTxtId(String.valueOf(u.getNumUsu()));
        US.setTxtIdentificacion(String.valueOf(u.getIdentificación()));
        US.setTxtNombre(u.getNombre());
        US.setTxtCorreo(u.getCorreo());
        US.setTxtTelefono(u.getTelefono());
        US.setCbxTipoUsuario(u.getTipoUsuario());
        US.setTxtContrasena(u.getContrasena());

        US.setLocationRelativeTo(listado);
        US.setVisible(true);
    }

    public void actualizarUsuario() {
        Usuario u = new Usuario();
        u.setNumUsu(ed.getTxtId());
        u.setIdentificación(Long.parseLong(ed.getTxtIdentificacion()));
        u.setNombre(ed.getTxtNombres());
        u.setCorreo(ed.getTxtCorreo());
        u.setTelefono(ed.getTxtTelefono());
        u.setTipoUsuario(ed.getCbxUsuarios());
        u.setContrasena(ed.getTxtContrasena());

        u.actualizarUsuario();
    }

    public void listadoTipo() {
        Usuario usu = new Usuario();
        //Cliente Administrador Agente de ventas
        ArrayList<Usuario> usuarios = usu.listarUsuarios();
        this.numUsuarios = usuarios.size();
        users = usuarios;

        for (int i = 0; i < usuarios.size(); i++) {
            switch (usuarios.get(i).getTipoUsuario()) {
                case "Cliente":
                    Clientes.add(usuarios.get(i));
                    System.out.println("cosa1");
                    break;
                case "Administrador":
                    Administradores.add(usuarios.get(i));
                    System.out.println("cosa2");
                    break;
                case "Agente de ventas":
                    Agentes.add(usuarios.get(i));
                    System.out.println("cosa3");
                    break;
                default:
                    break;
            }
        }
    }

}
