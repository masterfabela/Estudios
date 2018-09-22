/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserializable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Femio
 */
public class TestSerializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos m1=new Metodos();
        
        try{m1.gardar();}
        catch(IOException e1){
            System.out.println("Erro:"+e1.getMessage());
        }
        
        try{
            System.out.println(m1.leer().n1);
        }
        catch(IOException | ClassNotFoundException e1){
            System.out.println("Erro:"+e1.getMessage());
        }
    }
    
}
