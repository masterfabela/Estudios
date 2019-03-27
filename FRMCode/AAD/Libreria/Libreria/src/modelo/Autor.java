/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author a14damianld
 */
public class Autor {

    private String dni;
    private String nombre;
    private String direccion;
    private int edad;
    private String nacionalidad;
    private ArrayList<Libro> libro;

    public Autor(String dni, String nombre, String direccion, int edad, String nacionalidad, ArrayList<Libro> libro) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.libro = libro;
    }

    public Autor() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Libro> getLibro() {
        return libro;
    }

    public void setLibro(ArrayList<Libro> libro) {
        this.libro = libro;
    }

}
