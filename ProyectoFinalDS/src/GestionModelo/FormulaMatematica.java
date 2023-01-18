/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ryzen 5
 */

@Entity
@Table (name="formulasMatemasticas")
public class FormulaMatematica implements Serializable {

    @Id
    private int idFormulaMatematica;
//    @Column(name = "nombreFormula") ;
    private String nombreFormula;
    ArrayList<Variable> listaVariables;
    ArrayList<Operacion> listaOperaciones;
//    @Column(name = "nombreFormula") ;
    private String estadoFormulaMatematica;

    public FormulaMatematica() {
    }

    public FormulaMatematica(int idFormulaMatematica, String nombreFormula, String estadoFormulaMatematica) {
        this.idFormulaMatematica = idFormulaMatematica;
        this.nombreFormula = nombreFormula;
        this.estadoFormulaMatematica = estadoFormulaMatematica;
    }

    public String getEstadoFormulaMatematica() {
        return estadoFormulaMatematica;
    }

    public void setEstadoFormulaMatematica(String estadoFormulaMatematica) {
        this.estadoFormulaMatematica = estadoFormulaMatematica;
    }

    public int getIdFormulaMatematica() {
        return idFormulaMatematica;
    }

    public void setIdFormulaMatematica(int idFormulaMatematica) {
        this.idFormulaMatematica = idFormulaMatematica;
    }

    public String getNombreFormula() {
        return nombreFormula;
    }

    public void setNombreFormula(String nombreFormula) {
        this.nombreFormula = nombreFormula;
    }

    public void añadirVariable(Variable var) {
        listaVariables.add(var);
    }

    public void añadirOperacion(Operacion operacion) {
        listaOperaciones.add(operacion);
    }

    public String ListarVariables() {
        String resultado ="";
        for(int i = 0; i < listaVariables.size(); i++) {
            resultado += listaVariables.get(i).getNombreVariable()+ "\n";
        }
        return resultado;
    }

    public String ListarOperaciones() {
        String resultado ="";
        for(int i = 0; i < listaOperaciones.size(); i++) {
            resultado += listaOperaciones.get(i).getNombreOperacion()+ "\n";
        }
        return resultado;
    }

}
