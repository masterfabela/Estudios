/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author femio23
 */
public class LerPalabras {
    Scanner sc;
    File fich;
    public void leerp(){

        fich=new File("prime.txt");
        String lectura;
        try {
            sc=new Scanner(fich).useDelimiter("\\s*,\\s*");
            while(sc.hasNext()){
                System.out.println(sc.next());

            }                
            sc.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro1"+ex.getMessage());
            
        }
        finally{
            sc.close();
        }
        System.out.println(fich.exists());
    }
}
