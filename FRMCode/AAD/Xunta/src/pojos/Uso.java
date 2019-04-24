/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author femio23
 */
public class Uso implements Serializable{
    private Date data;
    private Time hora;
    private Ciclo ciclo;
    private Taller taller;

    public Uso() {
    }

    public Uso(Date data, Time hora, Ciclo ciclo, Taller taller) {
        this.data = data;
        this.hora = hora;
        this.ciclo = ciclo;
        this.taller = taller;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }
    
}
