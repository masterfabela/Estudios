/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

/**
 *
 * @author a18franciscorm
 */
public class Fila {
    String lonxitude,iniciais, cadena,repeticion;

    public Fila(String lonxitude, String iniciais, String cadena, String repeticion) {
        this.lonxitude = lonxitude;
        this.iniciais = iniciais;
        this.cadena = cadena;
        this.repeticion = repeticion;
    }

    public String getLonxitude() {
        return lonxitude;
    }

    public void setLonxitude(String lonxitude) {
        this.lonxitude = lonxitude;
    }

    public String getIniciais() {
        return iniciais;
    }

    public void setIniciais(String iniciais) {
        this.iniciais = iniciais;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }
    
}
