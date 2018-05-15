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
public class Masaxista extends SeleccionFutbol{
    String titulacion;
    int anosExperiencia;

    public Masaxista(String titulacion, int anosExperiencia, int id, int idade, String nome, String apelidos) {
        super(id, idade, nome, apelidos);
        this.titulacion = titulacion;
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public String toString() {
        return "Masaxista{" +"nome= "+nome+ " apelidos= "+apelidos+" id= "+id+" idade= "+idade+ "titulacion=" + titulacion + ", anosExperiencia=" + anosExperiencia + '}';
    }
    
    
    
    public void darMasaxe(){
        System.out.println("O masaxista "+nome+" da unha masaxe.");
    }

    @Override
    public void concentrarse() {
        System.out.println("O masaxista "+nome+" concentrase.");
    }

    @Override
    public void viaxar() {
        System.out.println("O masaxista "+nome+" viaxa.");
    }

    @Override
    public void adestrar() {
        System.out.println("O masaxista "+nome+" adestra.");
    }

    @Override
    public void xogarPartido() {
        System.out.println("O masaxista "+nome+" xoga o partido.");
    }
}
