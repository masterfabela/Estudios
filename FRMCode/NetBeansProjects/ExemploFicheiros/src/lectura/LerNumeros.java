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
public class LerNumeros {
    Scanner sc;
    File fich;
    public void leernum(){
        int lectura;
        fich=new File("num.txt");
        try {
            sc=new Scanner(fich).useDelimiter("\\s*,\\s*");
            while(sc.hasNext()){
                lectura=sc.nextInt();
                System.out.println(lectura);

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
    public void sumapares(){
        int lectura,aux=0;
        fich=new File("num.txt");
        try {
            sc=new Scanner(fich).useDelimiter("\\s*,\\s*");
            while(sc.hasNext()){
                lectura=sc.nextInt();
                System.out.println(lectura);
                if(lectura%2==0){
                    aux=aux+lectura;
                }

            }                
            sc.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro1"+ex.getMessage());
            
        }
        finally{
            sc.close();
        }
        System.out.println("o total dos pares é :"+aux);
    }
}
