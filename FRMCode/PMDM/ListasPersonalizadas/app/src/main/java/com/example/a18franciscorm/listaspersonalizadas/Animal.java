package com.example.a18franciscorm.listaspersonalizadas;

/**
 * Created by a18franciscorm on 17/01/2019.
 */

public class Animal {
    int idFoto,idColor;
    String nombre,descripcion;

    public Animal( int idFoto, int idColor, String nombre, String descripcion) {
        this.idFoto = idFoto;
        this.idColor = idColor;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public int getIdColor() {
        return idColor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
