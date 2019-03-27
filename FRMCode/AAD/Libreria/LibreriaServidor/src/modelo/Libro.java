/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author a14damianld
 */
public class Libro {

    private int codigo;
    private String titulo;
    private String categoria;
    private float precio;
    private Date fechaPublicacion;

    public Libro(int codigo, String titulo, String categoria, float precio, Date fechaPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libro() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}
