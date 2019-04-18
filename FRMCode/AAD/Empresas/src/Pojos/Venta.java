/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author femio23
 */
public class Venta {
    Date dataVenta;
    Time horaVenta;
    String codigoArtigo, temporal;
    int numeroUnidades;
    float importe;

    public Venta() {
    }

    public Venta(Date dataVenta, Time horaVenta, String codigoArtigo, int numeroUnidades, float importe) {
        this.dataVenta = dataVenta;
        this.horaVenta = horaVenta;
        this.codigoArtigo = codigoArtigo;
        this.numeroUnidades = numeroUnidades;
        this.importe = importe;
    }

    public Date getDataVenta() {
        return dataVenta;
    }

    public void setDataVenta(Date dataVenta) {
        this.dataVenta = dataVenta;
    }

    public Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public String getCodigoArtigo() {
        return codigoArtigo;
    }

    public void setCodigoArtigo(String codigoArtigo) {
        this.codigoArtigo = codigoArtigo;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
}
