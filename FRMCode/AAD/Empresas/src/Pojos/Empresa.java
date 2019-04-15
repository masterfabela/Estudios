/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Empresa {
    String cif, nome, direccion, telefono;
    Set<Produto> produtos;
    Set<Empregado> empregados;

    public Empresa() {
    }

    public Empresa(String cif, String nome, String direccion, String telefono) {
        this.cif = cif;
        this.nome = nome;
        this.direccion = direccion;
        this.telefono = telefono;
        produtos=new HashSet();
        empregados=new HashSet();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Set<Empregado> empregados) {
        this.empregados = empregados;
    }
    
    
}
