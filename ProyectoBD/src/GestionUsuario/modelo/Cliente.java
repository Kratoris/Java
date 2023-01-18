/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionUsuario.modelo;

import Utilidades.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryzen 5
 */
public class Cliente extends Usuario{
    
    private String id_Cliente;


    public Cliente() {
    }

    public Cliente(String id_Cliente, String codigo_Ciudad, String nombres, String apellido1, String apellido2, String telefono, String direccion, String correo, String estado) {
        super(codigo_Ciudad, nombres, apellido1, apellido2, telefono, direccion, correo, estado);
        this.id_Cliente = id_Cliente;
    }

    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public boolean registrarCliente() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "insert into usuarios(id_Cliente,codigo_Ciudad,nombres_Cliente,apellido1_Cliente,apellido2_Cliente,telefono_Cliente,direccion_Cliente,correo_Cliente,estado)";
        sql += "values (";
        sql += "'" + this.id_Cliente + "','" + this.codigo_Ciudad + "','" + this.nombres + "','" + this.apellido1 + "','" + this.apellido2
                + "','" + this.telefono  + "','" + this.direccion + "','" + this.correo + "','" + this.estado  + "')";
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return exito;
    }

//    
//    public void actualizarCliente() {
//        Conexion c = new Conexion();
//        boolean exito = false;
//        String sql = "update usuarios set identificacion='" + this.identificación + "',";
//        sql += "contrasena = '" + this.contrasena + "',";
//        sql += "correo = '" + this.correo + "',";
//        sql += "telefono = '" + this.telefono + "',";
//        sql += "tipoUsuario = '" + this.TipoUsuario + "',";
//        sql += "nombre = '" + this.nombre + "' ";
//        sql += " where numUsu = " + this.numUsu;
//        try {
//            exito = c.ejecutarSql(sql);
//            c.cerrarConexion();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
//        }
//    }
    
    
     public void eliminarCliente() {
         
     }

}
