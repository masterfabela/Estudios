
package boletin2_7;
import java.util.Scanner;
public class Boletin2_7 {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double tc,tk,tf;
        System.out.println("Introduzca la temperatura e ºC");
        tc=sc.nextDouble();
        tk=tc+273;
        tf=tc*1.86+32;
        System.out.println(tc+"ºC = "+tk+"ºK = "+tf+"ºF");
    }
    
}
