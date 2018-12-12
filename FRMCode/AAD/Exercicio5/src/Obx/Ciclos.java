/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class Ciclos implements Serializable{
    private int codCiclo;
    private String nombreCiclo;
    private Set<Institutos> instituto;
    private Set<Talleres> taller;

    public Ciclos() {
    }

    public Ciclos(int codCiclo, String nombreCiclo, Set<Institutos> instituto, Set<Talleres> taller) {
        this.codCiclo = codCiclo;
        this.nombreCiclo = nombreCiclo;
        this.instituto = instituto;
        this.taller = taller;
    }

    public int getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(int codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public Set<Institutos> getInstituto() {
        return instituto;
    }

    public void setInstituto(Set<Institutos> instituto) {
        this.instituto = instituto;
    }

    public Set<Talleres> getTaller() {
        return taller;
    }

    public void setTaller(Set<Talleres> taller) {
        this.taller = taller;
    }
    
}
