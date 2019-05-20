/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;

/**
 *
 * @author Femio
 */
public class Asalariado extends Vendedor implements Serializable {

    private float salario;

    public Asalariado() {
    }

    public Asalariado(float soldo, String nome, String apelidos, String numeroSS, String dni) {
        super(dni, nome, apelidos, numeroSS);
        this.salario = soldo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public float calculoRemuneracion() {
        return salario;
    }

}
