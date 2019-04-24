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
 * @author femio23
 */
public class Taller implements Serializable{
    private String codigo,nome;
    private Set<Ciclo> ciclos;

    public Taller() {
    }

    public Taller(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.ciclos = new HashSet<Ciclo>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
    
}
