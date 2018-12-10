/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class CochesVenta extends Coches implements Serializable{
    private float precioVenta;

    public CochesVenta() {
    }

    public CochesVenta(float precioVenta, String codigo, String marca, String modelo, String cif) {
        super(codigo, marca, modelo, cif);
        this.precioVenta = precioVenta;
    }

    
    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
}
