/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;

/**
 *
 * @author a18franciscorm
 */
public class Telefonos implements Serializable {
    private int dni;
    private int ntel;
    private Autores autores;

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public Telefonos() {
    }

    public Telefonos( int dni, int ntel) {
        this.dni = dni;
        this.ntel = ntel;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNtel() {
        return ntel;
    }

    public void setNtel(int ntel) {
        this.ntel = ntel;
    }

    
    
}
