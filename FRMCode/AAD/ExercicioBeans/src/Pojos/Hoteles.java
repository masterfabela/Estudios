/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Femio
 */
public class Hoteles implements Serializable{
    private int idHotel;
    private String nombre,tf;
    private ArrayList<Habitaciones> habitaciones= new ArrayList<Habitaciones>();
    private ArrayList<Reservas> reservas= new ArrayList<Reservas>();

    public Hoteles() {
    }

    public Hoteles(int idHotel, String nombre, String tf) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.tf = tf;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public ArrayList<Habitaciones> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitaciones> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) {
        this.reservas = reservas;
    }
    
}
