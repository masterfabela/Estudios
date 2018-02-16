/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomaquinacod;



/**
 *
 * @author femio23
 */
public class Productos {
    private String pelegido,producto;
    private float precio,prelegido;

    public Productos(String producto, float precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public Productos() {
    }

    public String getPelegido() {
        return pelegido;
    }

    public String getProducto() {
        return producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPelegido(String pelegido) {
        this.pelegido = pelegido;
    }

    public float getPrelegido() {
        return prelegido;
    }

    public void setPrelegido(float prelegido) {
        this.prelegido = prelegido;
    }
    
}
