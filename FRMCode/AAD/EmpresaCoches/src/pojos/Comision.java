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
public class Comision extends Vendedor implements Serializable {

    private float comision;
    private Set<Coche> coches;

    public Comision() {
    }

    public Comision(float comision, String nome, String apelidos, String numeroSS, String dni) {
        super(dni, nome, apelidos, numeroSS);
        this.comision = comision;
        this.coches = new HashSet<Coche>();
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public float calculoRemuneracion() {
        return comision * coches.size();
    }
}
