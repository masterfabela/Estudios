/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Produto implements Serializable{
    String codigo;
    int stockActual;
    int stockMinimo=30;
    float prezo;
    Empresa cif;
    Set<Venta> ventas;

    public Produto() {
    }

    public Produto(String codigo, int stockActual, float precioUnitario) {
        this.codigo = codigo;
        this.stockActual = stockActual;
        this.prezo = precioUnitario;
        this.ventas=new HashSet();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo(float precioUnitario) {
        this.prezo = precioUnitario;
    }

    public Empresa getCif() {
        return cif;
    }

    public void setCif(Empresa cif) {
        this.cif = cif;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
    

    
    
}
