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
    private int id;
    private String titulo;
    private float prezo;
    private Autores autores;

    public Libros() {
    }

    public Libros(int id, String titulo, float prezo) {
        this.id = id;
        this.titulo = titulo;
        this.prezo = prezo;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
