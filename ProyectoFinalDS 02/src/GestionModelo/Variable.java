/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ryzen 5
 */
@Entity
@Table (name="variables")
public class Variable implements Serializable {
    
    @Id
    private int idVariable;
    
    @Basic
    private String nombreVariable;
    private String estadoVariable;

    public Variable() {
    }

    public Variable(int idVariable, String nombreVariable,String estadoVariable) {
        this.idVariable = idVariable;
        this.nombreVariable = nombreVariable;
        this.estadoVariable=estadoVariable;
    }

    public String getEstadoVariable() {
        return estadoVariable;
    }

    public void setEstadoVariable(String estadoVariable) {
        this.estadoVariable = estadoVariable;
    }
    

    public int getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(int idVariable) {
        this.idVariable = idVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
    
    
    
}
