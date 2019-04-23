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
public abstract class Empregado implements Serializable{
    private String dni,nome,telefono;
    private float retencion;
    private Empresa cif;
    public abstract void calculoNomina();

    public Empregado() {
    }

    public Empregado(String dni, String nome, String telefono, Empresa cif, float retencion) {
        this.dni = dni;
        this.nome = nome;
        this.telefono = telefono;
        this.cif = cif;
        this.retencion = retencion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getCif() {
        return cif;
    }

    public void setCif(Empresa cif) {
        this.cif = cif;
    }


    public float getRetencion() {
        return retencion;
    }

    public void setRetencion(float retencion) {
        this.retencion = retencion;
    }
    
}
