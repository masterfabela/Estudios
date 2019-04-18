/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Temporal extends Empregado{
    private Date dataInicio,dataFin;
    private float importe;
    Set<Venta>venta;

    @Override
    public void calculoNomina() {
    }
    public void calculaFecha(Date inicio,Date fin){
        
    }

    public Temporal() {
    }

    public Temporal(Date dataInicio, Date dataFin, float importe, String dni, String nome, String telefono, String cif, float retencion) {
        super(dni, nome, telefono, cif, retencion);
        this.dataInicio = dataInicio;
        this.dataFin = dataFin;
        this.importe = importe;
        this.venta=new HashSet();
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

    public Set<Venta> getVenta() {
        return venta;
    }

    public void setVenta(Set<Venta> venta) {
        this.venta = venta;
    }

    
    
}
