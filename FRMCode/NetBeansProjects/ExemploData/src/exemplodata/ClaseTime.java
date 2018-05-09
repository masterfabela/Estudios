/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplodata;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author femio23
 */
public class ClaseTime {
    String nome;
    LocalDate dataAlta;
    LocalDate dataBaixa;
    ArrayList<ClaseTime> listrab=new ArrayList();

    public ClaseTime() {
    }

    public ClaseTime(String nome, LocalDate dataAlta, LocalDate dataBaixa) {
        this.nome = nome;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }
    
    public void inicializar(){
        //o ano, debe introducirse 1900-ano desexado, e xaneiro sería o mes 0.
        dataAlta=LocalDate.of(2015, 6, 2);
        dataBaixa = LocalDate.now();
        listrab.add(new ClaseTime("Pepe",dataAlta, dataBaixa));
    }
    public void visalta(){
        listrab.stream().forEach(t1->System.out.println("Dado de alta: "+t1.dataAlta));
    }
    public void tempoAlta(){
    listrab.stream().forEach(t1->System.out.println("Este empregado leva de alta "+
            (t1.dataBaixa.getDayOfMonth()-t1.dataAlta.getDayOfMonth())+" dias, "+
            (t1.dataBaixa.getMonthValue()-t1.dataAlta.getMonthValue())+" meses e "+
            (t1.dataBaixa.getYear()-t1.dataAlta.getYear())+" anos"));
    }
    public void antiguidade(){
        listrab.stream().forEach(t1->System.out.println((t1.dataBaixa.getYear()-t1.dataAlta.getYear())+" anos de antiguidade."));
    }
}
