/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class Institutos implements Serializable{
    private int codInsti;
    private String tf;
    private Set<Ciclos> ciclo;

    public int getCodInsti() {
        return codInsti;
    }

    public void setCodInsti(int codInsti) {
        this.codInsti = codInsti;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public Set<Ciclos> getCiclo() {
        return ciclo;
    }

    public void setCiclo(Set<Ciclos> ciclo) {
        this.ciclo = ciclo;
    }

    public Institutos(int codInsti, Set<Ciclos> ciclo) {
        this.codInsti = codInsti;
        this.ciclo = ciclo;
    }

    public Institutos(int codInsti, String tf) {
        this.codInsti = codInsti;
        this.tf = tf;
    }

    public Institutos() {
    }
    
}
