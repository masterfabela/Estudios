package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LerFicheiro {
    Scanner sc;
    File fich;
    public void leerliñas(){

        fich=new File("prime.txt");
        String lectura;
        try {
            sc=new Scanner(fich);
            while(sc.hasNext()){
                lectura=sc.nextLine();
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
    
}
