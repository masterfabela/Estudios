/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes.modelo.Pojos;

import servidor.modelo.*;
import java.util.Set;

/**
 *
 * @author a18franciscorm
 */
public class Cliente {
    private String dni,nome,direccion;
    private Set<Conta> contas;

    public Cliente() {
    }

    public Cliente(String dni, String nome, String direccion, Set<Conta> contas) {
        this.dni = dni;
        this.nome = nome;
        this.direccion = direccion;
        this.contas = contas;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }
    
}
