/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author femio23
 */
public class Libro {
    int codigo;
    String titulo;
    String categoria;
    float precio;
    String fechaPublicacion;

    public Libro() {
    }

    public Libro(int codigo, String titulo, String categoria, float precio, String fechaPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", precio=" + precio + ", fechaPublicacion=" + fechaPublicacion + '}';
    }

}
