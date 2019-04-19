/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author femio23
 */
public class Venta implements Serializable{
    Date data;
    Time hora;
    String codigo, temporal;
    int cantidade;
    float importe;
    Produto produto;
    Temporal empregado;

    public Venta() {
    }

    public Venta(Date dataVenta, Time horaVenta, String codigoArtigo, int numeroUnidades, float importe, Produto produto, Temporal empregado) {
        this.data = dataVenta;
        this.hora = horaVenta;
        this.codigo = codigoArtigo;
        this.cantidade = numeroUnidades;
        this.importe = importe;
        this.produto = produto;
        this.empregado = empregado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Temporal getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Temporal empregado) {
        this.empregado = empregado;
    }
    
}
