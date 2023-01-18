/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Ryzen 5
 */
@Entity
@Table(name = "Guias")
public class Guia implements Serializable {

    @Id
    private int codigoGuia;
//    @Column(name = "nombreGuia") ;
    private String nombreGuia;
//    @Column(name = "ultimaModificacion");
    private String ultimaModificacion;
//    @Column(name = "fechaCreacion");
    private String fechaCreacion;
    private String procedimientos;
    private String materiales;
    private String saberes;
    private String nombreImgAnexo;
//    @Column(name = "estadoGuia");
    private String estadoGuia;

    public Guia() {
    }

    public Guia(int codigoGuia, String nombreGuia, String ultimaModificacion, String fechaCreacion, String procedimientos, String materiales, String saberes, String nombreImgAnexo, String estadoGuia) {
        this.codigoGuia = codigoGuia;
        this.nombreGuia = nombreGuia;
        this.ultimaModificacion = ultimaModificacion;
        this.fechaCreacion = fechaCreacion;
        this.procedimientos = procedimientos;
        this.materiales = materiales;
        this.saberes = saberes;
        this.nombreImgAnexo = nombreImgAnexo;
        this.estadoGuia = estadoGuia;
    }

    public String getEstadoGuia() {
        return estadoGuia;
    }

    public void setEstadoGuia(String estadoGuia) {
        this.estadoGuia = estadoGuia;
    }

    public int getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(int codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    public String getNombreGuia() {
        return nombreGuia;
    }

    public void setNombreGuia(String nombreGuia) {
        this.nombreGuia = nombreGuia;
    }

    public String getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(String procedimientos) {
        this.procedimientos = procedimientos;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getSaberes() {
        return saberes;
    }

    public void setSaberes(String saberes) {
        this.saberes = saberes;
    }

    public String getNombreImgAnexo() {
        return nombreImgAnexo;
    }

    public void setNombreImgAnexo(String nombreImgAnexo) {
        this.nombreImgAnexo = nombreImgAnexo;
    }

}
