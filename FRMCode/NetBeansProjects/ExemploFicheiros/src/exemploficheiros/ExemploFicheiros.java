package exemploficheiros;
import java.util.ArrayList;
import lectura.*;
import persoas.Alumno;
import escritura.EscribirFicheiros;
public class ExemploFicheiros {

    public static void main(String[] args) {
        LerFicheiro lf1=new LerFicheiro();
        LerPalabras lp1=new LerPalabras();
        LerNumeros ln1=new LerNumeros();
        LerObxetos lo1=new LerObxetos();
        EscribirFicheiros ef1=new EscribirFicheiros();
        //lf1.leerliñas();
        //lp1.leerp();
        //ln1.leernum();
        //ln1.sumapares();
//        ArrayList<Alumno>s= new ArrayList();
//        s=lo1.suspenso();
//        System.out.println(s.toString());
//        for(Alumno s1:s){
//            System.out.println(s1.toString());
//        }
        ef1.escribirFrases();
        
    }
    
}
