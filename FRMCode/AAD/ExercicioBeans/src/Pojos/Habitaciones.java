/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;

/**
 *
 * @author Femio
 */
public class Habitaciones implements Serializable{
    private int idHabitacion;
    private boolean ocupada;
    private String tipo;
    private float pvp;

    public Habitaciones() {
    }

    public Habitaciones(int idHabitacion, boolean ocupada, String tipo, float pvp) {
        this.idHabitacion = idHabitacion;
        this.ocupada = ocupada;
        this.tipo = tipo;
        this.pvp = pvp;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }
    
}
