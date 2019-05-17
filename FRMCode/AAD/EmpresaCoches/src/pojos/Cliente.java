/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class Cliente implements Serializable{
    private String dni,nome,apelidos,direccion;
    private Set<Coche>reservas,coches;

    public Cliente() {
    }

    public Cliente(String dni, String nome, String apelidos,String direccion) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
        this.direccion = direccion;
        this.reservas = new HashSet<Coche>();
        this.coches = new HashSet<Coche>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Coche> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Coche> reservas) {
        this.reservas = reservas;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }
    
}
