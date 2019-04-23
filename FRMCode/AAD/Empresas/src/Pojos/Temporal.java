/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Temporal extends Empregado implements Serializable{
    private Date dataInicio,dataFin;
    private float importe; 
    Set<Venta>ventas;
    float soldo;

    public float getSoldo() {
        return soldo;
    }

    public void setSoldo(float soldo) {
        this.soldo = soldo;
    }

    @Override
    public void calculoNomina() {
        soldo=importe*obterTempo()-importe*obterTempo()*super.getRetencion();
    }
    public long obterTempo(){
        long tempo=(dataFin.getTime()-dataInicio.getTime())*1000*60*60*24;
        return tempo;
    }

    public Temporal() {
    }

    public Temporal(Date dataInicio, Date dataFin, float importe, String dni, String nome, String telefono, String cif, float retencion) {
        super(dni, nome, telefono, cif, retencion);
        this.dataInicio = dataInicio;
        this.dataFin = dataFin;
        this.importe = importe;
        this.ventas=new HashSet();
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFin() {
        return dataFin;
    }

    public void setDataFin(Date dataFin) {
        this.dataFin = dataFin;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    
    
}
