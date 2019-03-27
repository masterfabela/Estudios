/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author femio23
 */
public class Departamento implements Serializable{
    private String nDep,nomeDep,localidade;
    private Set<Empregado> empregados;

    public Departamento() {
    }

    public Departamento(String nDep, String nomeDep, String localidade) {
        this.nDep = nDep;
        this.nomeDep = nomeDep;
        this.localidade = localidade;
        this.empregados=new HashSet<>();
        
    }

    public String getnDep() {
        return nDep;
    }

    public void setnDep(String nDep) {
        this.nDep = nDep;
    }

    public String getNomeDep() {
        return nomeDep;
    }

    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Set<Empregado> empregados) {
        this.empregados = empregados;
    }
    
}
