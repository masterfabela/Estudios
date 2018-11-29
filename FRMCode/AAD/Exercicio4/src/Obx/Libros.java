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
    private Autores autor;

    public Libros() {
    }

    public Libros(String titulo, float prezo, Autores autor) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.prezo = prezo;
        this.autor = autor;
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

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
    
}
