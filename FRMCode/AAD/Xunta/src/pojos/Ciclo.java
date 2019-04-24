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
public class Ciclo implements Serializable{
    private String codigo,nome;
    private Set<Instituto>institutos;
    private Set<Taller>talleres;

    public Ciclo() {
    }

    public Ciclo(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.institutos = new HashSet<Instituto>();
        this.talleres = new HashSet<Taller>();
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

    public Set<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(Set<Instituto> institutos) {
        this.institutos = institutos;
    }

    public Set<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Taller> talleres) {
        this.talleres = talleres;
    }
    
}
