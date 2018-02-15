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
    private float precio;

    public Productos(String producto, float precio) {
        this.producto = producto;
        this.precio = precio;
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
    
}
