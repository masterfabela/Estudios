/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author femio23
 */
public class Boletin21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList lista=new ArrayList();
        Metodos m1=new Metodos();
        Palabra p1=new Palabra();
        Comparator c =new Comparator<Palabra>() {
            @Override
            public int compare(Palabra o1, Palabra o2) {
                return o1.getPal().compareTo(o2.getPal());
            }
        };
        lista=m1.creador();
        for(Object l1:lista){
            System.out.println(l1.toString());
        }
        lista.sort(c);
        for(Object l1:lista){
            System.out.println(l1.toString());
        }
        m1.grabar(lista, "Lista.txt");
        
    }
    
}
