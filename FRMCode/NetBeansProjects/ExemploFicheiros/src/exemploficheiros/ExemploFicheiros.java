package exemploficheiros;
import java.util.ArrayList;
import lectura.*;
import persoas.Alumno;
public class ExemploFicheiros {

    public static void main(String[] args) {
        LerFicheiro lf1=new LerFicheiro();
        LerPalabras lp1=new LerPalabras();
        LerNumeros ln1=new LerNumeros();
        LerObxetos lo1=new LerObxetos();
        //lf1.leerliñas();
        //lp1.leerp();
        //ln1.leernum();
        //ln1.sumapares();
        ArrayList<Alumno>s= new ArrayList();
        s=lo1.suspenso();
    }
    
}
