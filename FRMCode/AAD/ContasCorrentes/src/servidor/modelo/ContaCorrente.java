/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.modelo;

import java.util.Set;

/**
 *
 * @author a18franciscorm
 */
public class ContaCorrente extends Conta{
    private Set<Movemento> movementos;

    public ContaCorrente() {
    }

    public ContaCorrente(Set<Movemento> movementos, String numero, String surursal, double saldoActual, Set<Cliente> clientes) {
        super(numero, surursal, saldoActual, clientes);
        this.movementos = movementos;
    }

    public Set<Movemento> getMovementos() {
        return movementos;
    }

    public void setMovementos(Set<Movemento> movementos) {
        this.movementos = movementos;
    }
    
}
