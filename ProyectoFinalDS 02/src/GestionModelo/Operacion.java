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
@Table (name="operaciones")
public class Operacion implements Serializable {
    
    @Id
    private int idOperacion;
    @Basic
    private String nombreOperacion;
    private String estadoOperacion;

    public Operacion() {
    }

    public Operacion(int idOperacion, String nombreOperacion, String estadoOperacion) {
        this.idOperacion = idOperacion;
        this.nombreOperacion = nombreOperacion;
        this.estadoOperacion = estadoOperacion;
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    
    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }
    
    
    
}
