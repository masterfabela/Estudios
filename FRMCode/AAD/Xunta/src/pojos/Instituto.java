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
public class Instituto implements Serializable{
    private String codigo,telefono;
    private Set<Ciclo>ciclos;

    public Instituto() {
    }

    public Instituto(String codigo, String telefono) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.ciclos=new HashSet<Ciclo>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
    
}
