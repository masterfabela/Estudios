/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin30;

/**
 *
 * @author femio23
 */
public class Futbolista extends SeleccionFutbol{
    private int dorsal;
    private String demarcacion;

    public Futbolista(int idade,int id,String nome,String apelidos,int dorsal, String demarcacion) {
        super(idade,id,nome,apelidos);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }
    

    @Override
    public void concentrarse() {
        System.out.println("O xogador "+nome+" concentrase.");
    }

    @Override
    public void viaxar() {
        System.out.println("O xogador "+nome+" viaxa.");
    }
    

    @Override
    public void adestrar() {
    System.out.println("O xogador "+nome+" adestra.");
    }


    @Override
    public void xogarPartido() {
        System.out.println("O xogador "+nome+" xoga.");
    }
    public void entrevista(){
        System.out.println("O xogador "+nome+" concede unha entrevista.");
    }

    @Override
    public String toString() {
        return "Futbolista{" +"nome= "+nome+ " apelidos "+apelidos+" id= "+id+"idade"+idade+"dorsal= " + dorsal + ", demarcacion= " + demarcacion + '}';
    }
    
}
