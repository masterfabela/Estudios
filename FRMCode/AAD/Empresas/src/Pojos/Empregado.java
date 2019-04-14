/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author femio23
 */
public abstract class Empregado {
    private String dni,nome,telefono,cif;
    private float retencion;
    public abstract void calculoNomina();

    public Empregado() {
    }

    public Empregado(String dni, String nome, String telefono, String cif, float retencion) {
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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public float getRetencion() {
        return retencion;
    }

    public void setRetencion(float retencion) {
        this.retencion = retencion;
    }
    
}
