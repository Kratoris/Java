/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionControl;

import GestionModelo.Administrador;
import GestionModelo.Estudiante;
import GestionModelo.Registro;
import GestionVista.AutenticarAdministrador;
import GestionVista.AutenticarEstudiante;
import GestionVista.ConsultarAdministrador;
import GestionVista.ConsultarEstudiante;
import GestionVista.CrearAdministrador;
import GestionVista.CrearEstudiante;
import GestionVista.EditarAdministrador;
import GestionVista.EditarEstudiante;
import GestionVista.EliminarAdministrador;
import GestionVista.EliminarEstudiante;
import GestionVista.MostrarConsulta;
import Utilidades.CampoVacio;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryzen 5
 */
public class ControladorUsuarios {

    CrearAdministrador crearAdministrador;
    CrearEstudiante crearEstudiante;
    ConsultarAdministrador consultarAdmin;
    ConsultarEstudiante consultarEstudiante;
    EditarEstudiante editarEstudiante;
    EditarAdministrador editarAdmin;
    EliminarAdministrador eliminarAdmin;
    EliminarEstudiante eliminarEstudiante;
    AutenticarEstudiante autenticarEstudiante;
    AutenticarAdministrador autenticarAdministrador;
    Registro registro;
    Estudiante estudiante1;
    Administrador admin1;
    MostrarConsulta mostrar;

    public ControladorUsuarios() {
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public CrearAdministrador getCrearAdministrador() {
        return crearAdministrador;
    }

    public void setCrearAdministrador(CrearAdministrador crearAdministrador) {
        this.crearAdministrador = crearAdministrador;
    }

    public CrearEstudiante getCrearEstudiante() {
        return crearEstudiante;
    }

    public void setCrearEstudiante(CrearEstudiante crearEstudiante) {
        this.crearEstudiante = crearEstudiante;
    }

    public ConsultarAdministrador getConsultarAdmin() {
        return consultarAdmin;
    }

    public void setConsultarAdmin(ConsultarAdministrador consultarAdmin) {
        this.consultarAdmin = consultarAdmin;
    }

    public ConsultarEstudiante getConsultarEstudiante() {
        return consultarEstudiante;
    }

    public void setConsultarEstudiante(ConsultarEstudiante consultarEstudiante) {
        this.consultarEstudiante = consultarEstudiante;
    }

    public EditarEstudiante getEditarEstudiante() {
        return editarEstudiante;
    }

    public MostrarConsulta getMostrar() {
        return mostrar;
    }

    public void setMostrar(MostrarConsulta mostrar) {
        this.mostrar = mostrar;
    }
    
    

    public void setEditarEstudiante(EditarEstudiante editarEstudiante) {
        this.editarEstudiante = editarEstudiante;
    }

    public EditarAdministrador getEditarAdmin() {
        return editarAdmin;
    }

    public void setEditarAdmin(EditarAdministrador editarAdmin) {
        this.editarAdmin = editarAdmin;
    }

    public EliminarAdministrador getEliminarAdmin() {
        return eliminarAdmin;
    }

    public void setEliminarAdmin(EliminarAdministrador eliminarAdmin) {
        this.eliminarAdmin = eliminarAdmin;
    }

    public EliminarEstudiante getEliminarEstudiante() {
        return eliminarEstudiante;
    }

    public void setEliminarEstudiante(EliminarEstudiante eliminarEstudiante) {
        this.eliminarEstudiante = eliminarEstudiante;
    }

    public AutenticarEstudiante getAutenticarEstudiante() {
        return autenticarEstudiante;
    }

    public void setAutenticarEstudiante(AutenticarEstudiante autenticarEstudiante) {
        this.autenticarEstudiante = autenticarEstudiante;
    }

    public AutenticarAdministrador getAutenticarAdministrador() {
        return autenticarAdministrador;
    }

    public void setAutenticarAdministrador(AutenticarAdministrador autenticarAdministrador) {
        this.autenticarAdministrador = autenticarAdministrador;
    }

    public void crearEstudiante() throws Exception {
        Estudiante estudiante = new Estudiante();

        try {
            estudiante.setIdEstudiante(Integer.parseInt(this.crearEstudiante.getTxtId()));
            VerificarVacioException(this.crearEstudiante.getTxtId());
            estudiante.setNombre(this.crearEstudiante.getTxtNombres());
            VerificarVacioException(this.crearEstudiante.getTxtNombres());
            estudiante.setPrimerApellido(this.crearEstudiante.getTxtPrimerApellido());
            VerificarVacioException(this.crearEstudiante.getTxtPrimerApellido());
            estudiante.setSegundoApellido(this.crearEstudiante.getTxtSegundoApellido());
            VerificarVacioException(this.crearEstudiante.getTxtSegundoApellido());
            estudiante.setCorreo(this.crearEstudiante.getTxtCorreo());
            VerificarVacioException(this.crearEstudiante.getTxtCorreo());
            estudiante.setContrasena(this.crearEstudiante.getTxtContraseña());
            VerificarVacioException(this.crearEstudiante.getTxtContraseña());

            registro.registrarEstudiante(estudiante);

        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void crearAdministrador() throws Exception {
        Administrador administrador = new Administrador();

        try {

            administrador.setIdAdminitrador(Integer.parseInt(this.crearEstudiante.getTxtId()));
            VerificarVacioException(this.crearAdministrador.getTxtId());
            administrador.setNombre(this.crearAdministrador.getTxtNombres());
            VerificarVacioException(this.crearAdministrador.getTxtNombres());
            administrador.setPrimerApellido(this.crearAdministrador.getTxtPrimerApellido());
            VerificarVacioException(this.crearAdministrador.getTxtPrimerApellido());
            administrador.setSegundoApellido(this.crearAdministrador.getTxtSegundoApellido());
            VerificarVacioException(this.crearAdministrador.getTxtSegundoApellido());
            administrador.setCorreo(this.crearAdministrador.getTxtCorreo());
            VerificarVacioException(this.crearAdministrador.getTxtCorreo());
            administrador.setContrasena(this.crearAdministrador.getTxtContraseña());
            VerificarVacioException(this.crearAdministrador.getTxtContraseña());

            registro.registrarAdministrador(administrador);

        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void rellenarCamposEstudiante() {
        Estudiante estudiante = new Estudiante();
        try {
            estudiante = registro.encontrarEstudiante(Integer.parseInt(this.editarEstudiante.getTxtId()));
            editarEstudiante.setTxtId(String.valueOf(estudiante.getIdEstudiante()));
            editarEstudiante.setTxtNombres(estudiante.getNombre());
            editarEstudiante.setTxtPrimerApellido(estudiante.getPrimerApellido());
            editarEstudiante.setTxtSegundoApellido(estudiante.getSegundoApellido());
            editarEstudiante.setTxtCorreo(estudiante.getCorreo());
            editarEstudiante.setTxtContraseña(estudiante.getContrasena());

        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el estudiante ingresado");
        }
    }

    public void rellenarCamposAdministrador() {
        Administrador administrador = new Administrador();
        try {
            administrador = registro.encontrarAdministrador(Integer.parseInt(this.editarAdmin.getTxtId()));
            editarAdmin.setTxtId(String.valueOf(administrador.getIdAdminitrador()));
            editarAdmin.setTxtNombres(administrador.getNombre());
            editarAdmin.setTxtPrimerApellido(administrador.getPrimerApellido());
            editarAdmin.setTxtSegundoApellido(administrador.getSegundoApellido());
            editarAdmin.setTxtCorreo(administrador.getCorreo());
            editarAdmin.setTxtContraseña(administrador.getContrasena());

        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el administrador ingresado");
        }
    }

    public void editarEstudiante() throws Exception {
        Estudiante estudiante = new Estudiante();

        try {
            estudiante.setIdEstudiante(Integer.parseInt(this.editarEstudiante.getTxtId()));
            VerificarVacioException(this.editarEstudiante.getTxtId());
            estudiante.setNombre(this.editarEstudiante.getTxtNombres());
            VerificarVacioException(this.editarEstudiante.getTxtNombres());
            estudiante.setPrimerApellido(this.editarEstudiante.getTxtPrimerApellido());
            VerificarVacioException(this.editarEstudiante.getTxtPrimerApellido());
            estudiante.setSegundoApellido(this.editarEstudiante.getTxtSegundoApellido());
            VerificarVacioException(this.editarEstudiante.getTxtSegundoApellido());
            estudiante.setCorreo(this.editarEstudiante.getTxtCorreo());
            VerificarVacioException(this.editarEstudiante.getTxtCorreo());
            estudiante.setContrasena(this.editarEstudiante.getTxtContraseña());
            VerificarVacioException(this.editarEstudiante.getTxtContraseña());
            registro.editarEstudiante(estudiante);

        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el estudiante ingresado");
        }
    }

    public void editarAdministrador() throws Exception {
        Administrador administrador = new Administrador();

        try {
            administrador.setIdAdminitrador(Integer.parseInt(this.editarAdmin.getTxtId()));
            VerificarVacioException(this.editarAdmin.getTxtId());
            administrador.setNombre(this.editarAdmin.getTxtNombres());
            VerificarVacioException(this.editarAdmin.getTxtNombres());
            administrador.setPrimerApellido(this.editarAdmin.getTxtPrimerApellido());
            VerificarVacioException(this.editarAdmin.getTxtPrimerApellido());
            administrador.setSegundoApellido(this.editarAdmin.getTxtSegundoApellido());
            VerificarVacioException(this.editarAdmin.getTxtSegundoApellido());
            administrador.setCorreo(this.editarAdmin.getTxtCorreo());
            VerificarVacioException(this.editarAdmin.getTxtCorreo());
            administrador.setContrasena(this.editarAdmin.getTxtContraseña());
            VerificarVacioException(this.editarAdmin.getTxtContraseña());
            registro.editarAdministrador(administrador);

        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el administrador ingresado");
        }
    }

    public void VerificarVacioException(String campo) throws CampoVacio {

        if (campo.trim().equals("")) {
            throw new CampoVacio();
        }
    }

    public void eliminarAdministrador() {
        Administrador administrador = new Administrador();
        try {
            administrador.setIdAdminitrador(Integer.parseInt(this.eliminarAdmin.getTxtId()));
            VerificarVacioException(this.eliminarAdmin.getTxtId());

            administrador = registro.encontrarAdministrador(Integer.parseInt(this.eliminarAdmin.getTxtId()));
            administrador.setEstado("I");
            registro.editarAdministrador(administrador);
        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el administrador ingresado");
        }

    }

    public void eliminarEstudiante() {
        Estudiante estudiante = new Estudiante();
        try {
            estudiante.setIdEstudiante(Integer.parseInt(this.eliminarEstudiante.getTxtId()));
            VerificarVacioException(this.eliminarEstudiante.getTxtId());

            estudiante = registro.encontrarEstudiante(Integer.parseInt(this.eliminarEstudiante.getTxtId()));
            estudiante.setEstado("I");
            registro.editarEstudiante(estudiante);
        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el estudiante ingresado");
        }

    }

    public boolean consultarEstudiante() {
        boolean estado = false;
        try {
            estudiante1 = registro.encontrarEstudiante(Integer.parseInt(this.consultarEstudiante.getTxtId()));
            VerificarVacioException(this.consultarEstudiante.getTxtId());

            if (estudiante1 != null) {
                estado = true;
            }
        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estado;
    }

    public boolean consultarAdministrador() {
        boolean estado = false;
        try {
            admin1 = registro.encontrarAdministrador(Integer.parseInt(this.consultarAdmin.getTxtId()));
            VerificarVacioException(this.consultarEstudiante.getTxtId());

            if (admin1 != null) {
                estado = true;
            }
        } catch (CampoVacio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estado;
    }

    public void mostrarCamposConsultarEstudiante() {
        Estudiante estu = new Estudiante();
        estu = estudiante1;
        try {
            mostrar.setTxtId(String.valueOf(estudiante1.getIdEstudiante()));
            mostrar.setTxtNombres(estudiante1.getNombre());
            mostrar.setTxtPrimerApellido(estudiante1.getPrimerApellido());
            mostrar.setTxtSegundoApellido(estudiante1.getSegundoApellido());
            mostrar.setTxtCorreo(estudiante1.getCorreo());
            mostrar.setTxtContraseña(estudiante1.getContrasena());
            mostrar.setTxtEstado(estudiante1.getEstado());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el estudiante ingresado");
        }
    }

    public void mostrarCamposConsultarAdministrador() {
        Administrador administrador = new Administrador();
        administrador = admin1;
        try {
            mostrar.setTxtId(String.valueOf(admin1.getIdAdminitrador()));
            mostrar.setTxtNombres(admin1.getNombre());
            mostrar.setTxtPrimerApellido(admin1.getPrimerApellido());
            mostrar.setTxtSegundoApellido(admin1.getSegundoApellido());
            mostrar.setTxtCorreo(admin1.getCorreo());
            mostrar.setTxtContraseña(admin1.getContrasena());
            mostrar.setTxtEstado(admin1.getEstado());
        } catch (java.lang.NullPointerException x) {
            JOptionPane.showMessageDialog(null, "No existe el administrador ingresado");
        }
    }
}
