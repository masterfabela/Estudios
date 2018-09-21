/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin29;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Metodos {
    public void facturaIndividual(Barco b,int dias,float prezo){
        System.out.println("Factura nº: xxxxx"+"\nDatos: "+b.toString()+"\nPrezo:"+(b.aluger(b, dias)*prezo));
        
    }
    public void facturaTotal(ArrayList<Barco> l,int dias,float prezo){
        System.out.println("Factura nº: xxxxx");
        int i=1;
        for(Barco l1:l){
            System.out.println("Datos barco nº"+i+": "+l1.toString()+"\nPrezo:"+(l1.aluger(l1, dias)*prezo));
            i++;
        }
    }
}
