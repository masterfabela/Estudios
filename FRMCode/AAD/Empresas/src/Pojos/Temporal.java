/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.sql.Date;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Temporal extends Empregado{
    private Date dataInicio,dataFin;
    private float importe;
    Set<Venta>venta;

    @Override
    public void calculoNomina() {
    }
    public void calculaFecha(Date inicio,Date fin){
        
    }
}
