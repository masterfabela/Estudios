/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplodata;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author femio23
 */
public class TraballadorDate {
    String nome;
    Date dataAlta,dataBaixa;
    ArrayList<TraballadorDate> listrab=new ArrayList();
    public TraballadorDate() {
    }

    public TraballadorDate(String nome, Date dataAlta, Date dataBaixa) {
        this.nome = nome;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    public void inicializar(){
        listrab.add(new TraballadorDate("Pepe",new Date(2015,3,2),new Date(2018,5,7)));
    }
    public void visalta(){
        listrab.stream().forEach(t1->System.out.println("Dado de alta: "+t1.dataAlta));
    }
    public void tempoAlta(){
    listrab.stream().forEach(t1->System.out.println("Este empregado leva de alta "+(t1.dataBaixa.getDay()-t1.dataAlta.getDay())+" dias,"+(t1.dataBaixa.getMonth()-t1.dataAlta.getMonth())+" meses,"+(t1.dataBaixa.getYear()-t1.dataAlta.getYear())+" anos"));
    }
    public void antiguidade(){
        listrab.stream().forEach(t1->System.out.println((t1.dataBaixa.getYear()-t1.dataAlta.getYear())+" anos de antiguidade."));
    }
}
