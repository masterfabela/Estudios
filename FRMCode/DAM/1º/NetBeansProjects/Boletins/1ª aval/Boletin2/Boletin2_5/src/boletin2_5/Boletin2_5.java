
package boletin2_5;
import java.util.Scanner;
public class Boletin2_5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float m,mn;
     System.out.println("Indique la distancia en millas nauticas");
     mn=sc.nextFloat();
     m=mn*1852;
     System.out.println(mn+"Millas nauticas son "+m+"metros");
    }
    
}
