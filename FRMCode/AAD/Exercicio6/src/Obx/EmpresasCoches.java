/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class EmpresasCoches  implements Serializable{
    private String cif;
    private String NombreEmpresa;
    private String Telf;
    private Set<Coches> coche;

    public EmpresasCoches() {
    }

    public EmpresasCoches(String cif, String NombreEmpresa, String Telf) {
        this.cif = cif;
        this.NombreEmpresa = NombreEmpresa;
        this.Telf = Telf;
        this.coche = new HashSet();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public String getTelf() {
        return Telf;
    }

    public void setTelf(String Telf) {
        this.Telf = Telf;
    }

    public Set<Coches> getCoche() {
        return coche;
    }

    public void setCoche(Set<Coches> coche) {
        this.coche = coche;
    }
    
    
}
