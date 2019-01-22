/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes.modelo.Pojos;

import java.sql.Date;
import servidor.modelo.*;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author a18franciscorm
 */
public class Movemento {
    private String numeroConta;
    private Date dataOperacion;
    private Time hora;
    private double cantidade;
    private double saldoAnterior;

    public Movemento() {
    }

    public Movemento(String numeroConta, Date dataOperacion, Time hora, double cantidade, double saldoAnterior) {
        this.numeroConta = numeroConta;
        this.dataOperacion = dataOperacion;
        this.hora = hora;
        this.cantidade = cantidade;
        this.saldoAnterior = saldoAnterior;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Date getDataOperacion() {
        return dataOperacion;
    }

    public void setDataOperacion(Date dataOperacion) {
        this.dataOperacion = dataOperacion;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getCantidade() {
        return cantidade;
    }

    public void setCantidade(double cantidade) {
        this.cantidade = cantidade;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }
    
}
