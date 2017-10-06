package boletin2_3;
import java.util.Scanner;//importamos a llibreria do Scanner.
public class Boletin2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//declaramos variable escaner.
        float e,cd,usd;
        System.out.println("Introduzca la cantidad de euros.");
        e= sc.nextFloat();//invocamos escaner, para que introduzca un float.
        System.out.println("Introduzca el tipo de cambio.");
        cd = sc.nextFloat();
        usd=e*cd;
        System.out.println(e+"euros son "+usd+"dolares");
    }
    
}
