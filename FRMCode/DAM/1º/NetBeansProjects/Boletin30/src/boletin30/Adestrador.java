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
public class Adestrador extends SeleccionFutbol{
    private int idFederacion;

    public Adestrador(int idFederacion, int id, int idade, String nome, String apelidos) {
        super(id, idade, nome, apelidos);
        this.idFederacion = idFederacion;
    }

    @Override
    public String toString() {
        return "Adestrador{" +"nome= "+nome+ " apelidos= "+apelidos+" id= "+id+" idade= "+idade+ "idFederacion=" + idFederacion + '}';
    }
    
    
    
    public void planificarAdestramento(){
        System.out.println("O adestrador "+nome+" planifica o adestramento.");
    }

    @Override
    public void concentrarse() {
        System.out.println("O adestrador "+nome+" concentrase.");
    }

    @Override
    public void viaxar() {
        System.out.println("O adestrador "+nome+" viaxa.");
    }

    @Override
    public void adestrar() {
        System.out.println("O adestrador "+nome+" adestra.");
    }

    @Override
    public void xogarPartido() {
        System.out.println("O adestrador "+nome+" xoga o partido.");
    }
}
