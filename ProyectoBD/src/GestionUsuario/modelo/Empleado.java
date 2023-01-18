/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionUsuario.modelo;

/**
 *
 * @author Ryzen 5
 */
public class Empleado extends Usuario{
    
    private String id_Empleado;
    private String id_Cargo;

    public Empleado() {
    }

    public Empleado(String id_Empleado, String id_Cargo, String codigo_Ciudad, String nombres, String apellido1, String apellido2, String telefono, String direccion, String correo, String estado) {
        super(codigo_Ciudad, nombres, apellido1, apellido2, telefono, direccion, correo, estado);
        this.id_Empleado = id_Empleado;
        this.id_Cargo = id_Cargo;
    }

    public String getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(String id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getId_Cargo() {
        return id_Cargo;
    }

    public void setId_Cargo(String id_Cargo) {
        this.id_Cargo = id_Cargo;
    }
    
    


    
}
