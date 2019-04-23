/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;

/**
 *
 * @author femio23
 */
public class Fixo extends Empregado implements Serializable{
    private int salario, trienios;
    float soldo;

    public Fixo() {
    }

    public Fixo( int salario, int trienios, String dni, String nome, String telefono, Empresa cif, float retencion) {
        super(dni, nome, telefono, cif, retencion);
        this.salario = salario;
        this.trienios = trienios;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getTrienios() {
        return trienios;
    }

    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }

    public float getSoldo() {
        return soldo;
    }

    public void setSoldo(float soldo) {
        this.soldo = soldo;
    }

    @Override
    public void calculoNomina() {
        soldo=(salario+trienios)-(salario+trienios)*super.getRetencion();
        System.out.println("A nomina é de "+soldo+" €.");
    }
    
}
