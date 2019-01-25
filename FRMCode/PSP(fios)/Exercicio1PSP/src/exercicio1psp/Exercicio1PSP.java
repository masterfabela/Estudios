/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet<Fila> ts= new TreeSet();
        for(String s1:args){
            try{
                BufferedReader br=new BufferedReader(new FileReader(s1));
            FioLector f1=new FioLector(br,ts);
            }catch(FileNotFoundException fnfe1){
                System.out.println(fnfe1);
            }
        }
        for(Fila s:ts){
            System.out.println(s.lonxitude+" "+s.iniciais+" "+s.cadena+" "+s.repeticion);
        }
    }
}
