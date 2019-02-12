/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.modelo;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author a18franciscorm
 */
public abstract class Conta {
    private String numero,surursal;
    private double saldoActual;
    private Set<Cliente> clientes;

    public Conta() {
    }

    public Conta(String numero, String surursal, double saldoActual, Set<Cliente> clientes) {
        this.numero = numero;
        this.surursal = surursal;
        this.saldoActual = saldoActual;
        this.clientes = clientes;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSurursal() {
        return surursal;
    }

    public void setSurursal(String surursal) {
        this.surursal = surursal;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
