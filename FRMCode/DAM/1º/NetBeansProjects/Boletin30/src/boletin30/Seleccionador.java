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
public class Seleccionador extends SeleccionFutbol{

    public Seleccionador(int id, int idade, String nome, String apelidos) {
        super(id, idade, nome, apelidos);
    }

    @Override
    public String toString() {
        return "Seleccionador{" +"nome= "+nome+ " apelidos= "+apelidos+" id= "+id+" idade= "+idade +'}';
    }
    
    public void seleccionarXogador(){
        System.out.println("O seleccionador selecciona a x xogador.");
    }

    @Override
    public void concentrarse() {
        System.out.println("O seleccionador selecciona concentrase.");
    }

    @Override
    public void viaxar() {
        System.out.println("O seleccionador viaxa.");
    }

    @Override
    public void adestrar() {
        System.out.println("O seleccionador adestra.");
    }

    @Override
    public void xogarPartido() {
        System.out.println("O seleccionador xoga.");
    }
    
}
