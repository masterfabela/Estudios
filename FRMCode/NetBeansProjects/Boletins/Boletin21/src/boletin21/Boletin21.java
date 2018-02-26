/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin21;

import java.util.ArrayList;
import java.util.Collections;

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
        lista=m1.creador();
        for(Object l1:lista){
            System.out.println(l1.toString());
        }
        m1.ordenar(lista);
        for(Object l1:lista){
            System.out.println(l1.toString());
        }
//        m1.grabar(lista, "Lista.txt");
        
    }
    
}
