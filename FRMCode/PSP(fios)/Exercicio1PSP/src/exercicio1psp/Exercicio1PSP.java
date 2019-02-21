/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Linea> ts= new LinkedList();
        FioLector f1=null;
        ts.add(new Linea("T","Test",0));
        for(String s1:args){
            try{
                System.out.println(s1);
                BufferedReader br=new BufferedReader(new FileReader(s1));
            f1=new FioLector(br,ts);
            f1.start();
            }catch(FileNotFoundException fnfe1){
                System.out.println(fnfe1);
            }try{
                f1.join();
            }catch(InterruptedException ie1){
                ie1.getMessage();
            }
        }
        File saida=new File("saida.txt");
            try{
                PrintStream ps=new PrintStream(new FileOutputStream(saida));
                for(Linea ll:ts){
                    System.out.println(ll.toString());
                    ps.println(ll.devolvedor());
                }
                ps.close();
            }catch(FileNotFoundException fnfe1){}
    }
}
