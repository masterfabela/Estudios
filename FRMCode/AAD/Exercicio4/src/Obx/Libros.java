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
public class Libros implements Serializable {
    private int idlibro;
    private String titulo;
    private float prezo;

    public Libros() {
    }

    public Libros(int idlibro, String titulo, float prezo) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.prezo = prezo;
    }

    

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    
    
}
