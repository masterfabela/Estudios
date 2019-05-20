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
public abstract class Vendedor implements Serializable {

    private String nome, apelidos, numeroSS, dni;

    public abstract float calculoRemuneracion();

    public Vendedor() {
    }

    public Vendedor(String dni, String nome, String apelidos, String numeroSS) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.numeroSS = numeroSS;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

}
