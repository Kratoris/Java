/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.interactiva.GestionUsuario.modelo;

import Utilidades.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Frank E. Gil M.
 */
public class Usuario {

    //Atributos:
    private String nombre;
    private long identificación;
    private String contrasena;
    private String correo;
    private String telefono;
    private int numUsu;
    private String TipoUsuario;

    //Constructor:
    public Usuario() {
    }

    //Metodos:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificación() {
        return identificación;
    }

    public void setIdentificación(long identificación) {
        this.identificación = identificación;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumUsu() {
        return numUsu;
    }

    public void setNumUsu(int numUsu) {
        this.numUsu = numUsu;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public Usuario iniciarSesion() {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuarios where identificacion='" + this.identificación + "' and contrasena='" + this.contrasena + "' ";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            if (rs.next()) {
                u = new Usuario();
                u.setIdentificación(rs.getInt("identificacion"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setContrasena(rs.getString("contrasena"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {

        }
        return u;
    }

    public boolean registrarUsuario() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "insert into usuarios(identificacion,contrasena,correo,telefono,tipoUsuario,nombre)";
        sql += "values (";
        sql += "'"+this.identificación+"','"+this.contrasena+"','"+this.correo+"','"+this.telefono+"','"+this.TipoUsuario+"','"+this.nombre+"')";
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return exito;
    }

    public ArrayList<Usuario> listarUsuarios() {
        Conexion c = new Conexion();
        ArrayList<Usuario> users = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            ResultSet rs = c.ejecutarQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNumUsu(rs.getInt("numUsu"));
                u.setIdentificación(rs.getInt("identificacion"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipoUsuario(rs.getString("tipoUsuario"));
                users.add(u); 
            }
            c.cerrarConexion();
        } catch (SQLException e) {

        }
        return users;
    }

    public void actualizarUsuario() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "update usuarios set identificacion='" + this.identificación + "',";
        sql += "contrasena = '" + this.contrasena + "',";
        sql += "correo = '" + this.correo + "',";
        sql += "telefono = '" + this.telefono + "',";
        sql += "tipoUsuario = '" + this.TipoUsuario + "',";
        sql += "nombre = '" + this.nombre + "' ";
        sql += " where numUsu = " + this.numUsu;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }

    public Usuario seleccionarUsuario(int id) {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuarios where numUsu=" + id;
        try {
            ResultSet rs = c.ejecutarQuery(sql);
            while (rs.next()) {
                u = new Usuario();
                u.setNumUsu(rs.getInt("numUsu"));
                u.setIdentificación(rs.getInt("identificacion"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipoUsuario(rs.getString("tipoUsuario"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {

        }
        return u;
    }

}
