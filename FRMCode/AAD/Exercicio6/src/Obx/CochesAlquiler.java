/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class CochesAlquiler extends Coches implements Serializable{
    private float precioDia;
    private char estado;
    private Set<Usos> uso;

    public CochesAlquiler() {
    }

    public CochesAlquiler(float precioDia, char estado, String codigo, String marca, String modelo, String cif) {
        super(codigo, marca, modelo, cif);
        this.precioDia = precioDia;
        this.estado = estado;
    }

    
    
    public float getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(float precioDia) {
        this.precioDia = precioDia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Set<Usos> getUso() {
        return uso;
    }

    public void setUso(Set<Usos> uso) {
        this.uso = uso;
    }
    
}
