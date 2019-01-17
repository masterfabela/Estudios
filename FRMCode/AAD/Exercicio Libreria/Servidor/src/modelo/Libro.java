/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author femio23
 */
public class Libro {
    String codigo;
    String titulo;
    String categoria;
    float precio;
    LocalDate fechaPublicacion;

    public Libro() {
    }

    public Libro(String codigo, String titulo, String categoria, float precio, LocalDate fechaPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", precio=" + precio + ", fechaPublicacion=" + fechaPublicacion + '}';
    }

}
