/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Femio
 */
public class Usos implements Serializable{
    private String codigo;
    private Date FechaAlquiler;
    private Date FechaEntrada;
    private float importe;

    public Usos() {
    }

    public Usos(String codigo, Date FechaAlquiler, Date FechaEntrada, float importe) {
        this.codigo = codigo;
        this.FechaAlquiler = FechaAlquiler;
        this.FechaEntrada = FechaEntrada;
        this.importe = importe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(Date FechaAlquiler) {
        this.FechaAlquiler = FechaAlquiler;
    }

    public Date getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(Date FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
}
