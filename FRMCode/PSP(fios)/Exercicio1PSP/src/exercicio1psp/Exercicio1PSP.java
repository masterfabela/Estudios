/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br=new BufferedReader(new FileReader(args[0]));
        try{
            while(br.ready()){
                FioLector fl=new FioLector(br.readLine());
                
            }
            }
        catch(IOException ioe1){
            System.out.println(ioe1.getMessage());
        }
       
        
    }
    
}
