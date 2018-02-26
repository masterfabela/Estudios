/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author femio23
 */
public class Metodos {
    File fich;

    public ArrayList creador(){
        ArrayList l1=new ArrayList();
        
        int cant=Integer.parseInt(JOptionPane.showInputDialog(null, "Indique cantas palabras vai a introducir:"));
        for(int i=0;i<cant;i++){
            String s=JOptionPane.showInputDialog(null, "Introduza a "+(i+1)+"ª palabra.");
            Palabra aux=new Palabra(s);
            l1.add(aux);
        }
        return l1;
    }
    public void grabar(ArrayList<Palabra> l,String dir){
        fich=new File(dir);
        PrintWriter grab=null;
        try{
            grab=new PrintWriter(fich);
            System.out.println(fich.exists());
            for(Palabra l1:l){
                grab.println(l1.getPal());
                System.out.println("Grabando ");
                
            }
            grab.close();
            System.out.println("Finalizado.");
        }
        catch(FileNotFoundException fnfe1){
            System.out.println("Erro: "+ fnfe1.getMessage());
        }
        finally{
            grab.close();
        }
    }
    
    
    
        
    
}
