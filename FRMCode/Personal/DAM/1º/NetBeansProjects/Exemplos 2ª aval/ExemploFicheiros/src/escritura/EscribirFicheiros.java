/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author femio23
 */
public class EscribirFicheiros  {
    PrintWriter escribir;
    FileWriter f1;
    File fich;
    public void escribirFrases(){
        try{
        fich=new File("frases.txt");
        escribir=new PrintWriter(fich);
        escribir.print("H");
        escribir.print("o");
        escribir.print("l");
        escribir.println("a");
        //escribir.println("Qtal?");
        escribir.println("Adeus");
        
        escribir.close();
        }
        catch(FileNotFoundException fnfe1){
            System.out.println("O arquivo non existe.");
        }
        finally{
            escribir.close();
        }
    }
    public void engadir()throws IOException{
        try{
        f1=new FileWriter(new File("frases.txt"),true);
        escribir.println("Adeus");
        
        f1.close();
        }
        catch(FileNotFoundException fnfe1){
            System.out.println("O arquivo non existe.");
        }
        catch(IOException ioe1){
            System.out.println("Erro4.");
        }
        finally{
            f1.close();
        }
    }
}
