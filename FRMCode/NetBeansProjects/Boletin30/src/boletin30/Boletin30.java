/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin30;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author femio23
 */
public class Boletin30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SeleccionFutbol fut=new Futbolista(25,777,"Xose","Gonzalez Vázquez",9,"dianteiro");
        SeleccionFutbol ades=new Adestrador(7753,45,999,"Naira","Ramirez Ogando");
        SeleccionFutbol mas=new Masaxista("Tecnico Sanitario",3,30,111,"Alberto","Diaz Troncoso");
        SeleccionFutbol sel=new Seleccionador(50,666,"Carme","Ramirez Lagoa");
        ArrayList<SeleccionFutbol> lista=new ArrayList();
        lista.add(fut);
        lista.add(ades);
        lista.add(mas);
        lista.add(sel);
        for(SeleccionFutbol l1:lista){
            System.out.println(l1.toString());
        }
    }
    
}
