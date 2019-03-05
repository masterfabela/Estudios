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
public class Clientes implements Serializable{
    private String dni,nombre,tf;

    public Clientes() {
    }

    public Clientes(String dni, String nombre, String tf) {
        this.dni = dni;
        this.nombre = nombre;
        this.tf = tf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
    
    
}
