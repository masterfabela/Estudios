/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author a18franciscorm
 */
public class Uso {
    private Date data;
    private Time hinicio,hfin;
    private String nome;
    private float importeUso;

    public Uso() {
    }

    public Uso(Date data, Time hinicio, Time hfin, String nome, float importeUso) {
        this.data = data;
        this.hinicio = hinicio;
        this.hfin = hfin;
        this.nome = nome;
        this.importeUso = importeUso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHinicio() {
        return hinicio;
    }

    public void setHinicio(Time hinicio) {
        this.hinicio = hinicio;
    }

    public Time getHfin() {
        return hfin;
    }

    public void setHfin(Time hfin) {
        this.hfin = hfin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getImporteUso() {
        return importeUso;
    }

    public void setImporteUso(float importeUso) {
        this.importeUso = importeUso;
    }
    
}
