/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author a18franciscorm
 */
public class Escritor {
    Comparator c=(Comparator<Linea>) (Linea o1, Linea o2) -> o1.getIniciais().compareTo(o2.getIniciais());
    public synchronized void gardado(Linea linea,LinkedList<Linea> l){
        System.out.println(l.indexOf(linea));
        if(l.contains(linea)){
            System.out.println("Ping");
            for(int i=0;i<l.size();i++){
                if (l.get(i).equals(linea)) {
                    l.get(i).setCantidade(l.get(i).getCantidade() + 1);
                }
            }
        }else{
            l.add(linea);
            l.sort(c);
        }   
        
    }
}
