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
public class Talleres implements Serializable{
    private int codTaller;
    private String nombre;
    private Set<Ciclos> ciclo;
    
    public Talleres() {
    }


    public Talleres(int codTaller, String nombre, Set<Ciclos> ciclo) {
        this.codTaller = codTaller;
        this.nombre = nombre;
        this.ciclo = ciclo;
    }


    public Set<Ciclos> getCiclo() {
        return ciclo;
    }

    public void setCiclo(Set<Ciclos> ciclo) {
        this.ciclo = ciclo;
    }

    public int getCodTaller() {
        return codTaller;
    }

    public void setCodTaller(int codTaller) {
        this.codTaller = codTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
