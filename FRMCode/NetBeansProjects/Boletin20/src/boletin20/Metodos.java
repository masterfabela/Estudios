package boletin20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    public void importar(ArrayList l, String d){
        Scanner sc= null;
        File fich=new File(d);
        Libro l1;
        try{
            sc=new Scanner(fich).useDelimiter(",\\s*");
            while(sc.hasNext()){
                l1=new Libro(sc.next(),sc.next(),Float.parseFloat(sc.next()),Integer.parseInt(sc.next()));
                l.add(l1);
            }
            for(Object l2:l){
                System.out.println(l2.toString());
            }
            
        }
        catch(FileNotFoundException fnfe1){
            System.out.println("Erro:"+fnfe1.getMessage());
        }
        finally{
            sc.close();
        }
    }
    public void existe(String d){
        Scanner sc= null;
        File fich=new File(d);
        System.out.println(fich.exists());
        
    }
}
