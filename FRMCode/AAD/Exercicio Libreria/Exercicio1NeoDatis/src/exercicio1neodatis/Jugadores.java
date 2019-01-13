/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1neodatis;

/**
 *
 * @author femio23
 */
public class Jugadores {
    String deporte;
    String nombre;

    public Jugadores() {
    }

    public Jugadores(String deporte, String nombre) {
        this.deporte = deporte;
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
