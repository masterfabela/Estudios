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

    public Fixo() {
    }

    public Fixo( int salario, int trienios, String dni, String nome, String telefono, String cif, float retencion) {
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

    @Override
    public void calculoNomina() {
        float soldo=(salario+trienios)-(salario+trienios)*super.getRetencion();
    }
    
}
