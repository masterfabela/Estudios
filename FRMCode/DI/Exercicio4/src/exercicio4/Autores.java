/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;

import java.io.Serializable;

/**
 *
 * @author a18franciscorm
 */
public class Autores implements Serializable {
    private int dniautor;
    private String nombre;
    private String nacionalidad;

    public Autores() {
    }
    
    public Autores(int dniautor, String nombre, String nacionalidad) {
        this.dniautor = dniautor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getDniautor() {
        return dniautor;
    }

    public void setDniautor(int dniautor) {
        this.dniautor = dniautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
