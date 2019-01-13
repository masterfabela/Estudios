/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Autor {
    String dni,nombre,direccion,nacionalidad;
    int edad;
    ArrayList <Libro> libros;

    public Autor() {
    }

    public Autor(String dni, String nombre, String direccion, String nacionalidad, int edad, ArrayList<Libro> libros) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.libros = libros;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", nacionalidad=" + nacionalidad + ", edad=" + edad + ", libros=" + libros + '}';
    }
    
}
