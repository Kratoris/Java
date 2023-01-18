/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionUsuario.controlador;

import GestionUsuario.modelo.Cliente;
import GestionUsuario.vista.CrearCliente;
import GestionUsuario.vista.EditarCliente;
import GestionUsuario.vista.EliminarCliente;
import Utilidades.Principal;
import Utilidades.camposVacios;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Frank
 */
public class ControlUsuario {

    public Principal p;
    CrearCliente crear;
    EditarCliente editar;
    EliminarCliente eliminar;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static boolean bandera;
    int numUsuarios;

    public ControlUsuario() {
    }

    public Principal getP() {
        return p;
    }

    public void setP(Principal p) {
        this.p = p;
    }

    public CrearCliente getCrear() {
        return crear;
    }

    public void setCrear(CrearCliente crear) {
        this.crear = crear;
    }

    public EditarCliente getEditar() {
        return editar;
    }

    public void setEditar(EditarCliente editar) {
        this.editar = editar;
    }

    public EliminarCliente getEliminar() {
        return eliminar;
    }

    public void setEliminar(EliminarCliente eliminar) {
        this.eliminar = eliminar;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        ControlUsuario.clientes = clientes;
    }

    public static boolean isBandera() {
        return bandera;
    }

    public static void setBandera(boolean bandera) {
        ControlUsuario.bandera = bandera;
    }

    public int getNumUsuarios() {
        return numUsuarios;
    }

    public void setNumUsuarios(int numUsuarios) {
        this.numUsuarios = numUsuarios;
    }

    public void registrarCliente() {
        Cliente cliente = new Cliente();

        try {
            cliente.setNombres(this.crear.getTxtNombres());
            VerificarVacioException(this.crear.getTxtNombres());
            cliente.setApellido1(this.crear.getTxtPrimerApellido());
            VerificarVacioException(this.crear.getTxtPrimerApellido());
            cliente.setApellido2(this.crear.getTxtSegundoApellido());
            VerificarVacioException(this.crear.getTxtSegundoApellido());
            cliente.setTelefono(this.crear.getTxtTelefono());
            VerificarVacioException(this.crear.getTxtTelefono());
            cliente.setDireccion(this.crear.getTxtDireccion());
            VerificarVacioException(this.crear.getTxtDireccion());
            cliente.setCorreo(this.crear.getTxtCorreo());
            VerificarVacioException(this.crear.getTxtCorreo());
            cliente.setCodigo_Ciudad(this.crear.getTxtCodigoCiudad());
            VerificarVacioException(this.crear.getTxtCodigoCiudad());
            cliente.setEstado(this.crear.getCbEstado());
            VerificarVacioException(this.crear.getCbEstado());
            cliente.setId_Cliente(this.crear.getTxtId());
            VerificarVacioException(this.crear.getTxtId());
            
            
            if (!cliente.registrarCliente()) {
                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente");
            }
        } catch (camposVacios ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

//       public void editarCliente() {
//        Cliente cliente = new Cliente();
//        u.setNumUsu(ed.getTxtId());
//        u.setIdentificación(Long.parseLong(ed.getTxtIdentificacion()));
//        u.setNombre(ed.getTxtNombres());
//        u.setCorreo(ed.getTxtCorreo());
//        u.setTelefono(ed.getTxtTelefono());
//        u.setTipoUsuario(ed.getCbxUsuarios());
//        u.setContrasena(ed.getTxtContrasena());
//
//        cliente.editarCliente();
//    }
    public void eliminarCliente() {

    }

    public void VerificarVacioException(String campo) throws camposVacios {

        if (campo.trim().equals("")) {
            throw new camposVacios();
        }
    }
}
