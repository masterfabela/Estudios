/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author a18franciscorm
 */
public class ContaPrazo extends Conta{
    private float interese;
    private LocalDate dataVencemento;

    public ContaPrazo() {
    }

    public ContaPrazo(float interese, LocalDate dataVencemento, String numero, String surursal, double saldoActual, Set<Cliente> clientes) {
        super(numero, surursal, saldoActual, clientes);
        this.interese = interese;
        this.dataVencemento = dataVencemento;
    }

    public float getInterese() {
        return interese;
    }

    public void setInterese(float interese) {
        this.interese = interese;
    }

    public LocalDate getDataVencemento() {
        return dataVencemento;
    }

    public void setDataVencemento(LocalDate dataVencemento) {
        this.dataVencemento = dataVencemento;
    }
    
}
