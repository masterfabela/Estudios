package boletin2_6;
import java.util.Scanner;
public class Boletin2_6 {

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    float pr,pa,d;
    System.out.println("Introduzca el precio real.");
    pr=sc.nextFloat();
    System.out.println("Introduzca el precio abonado.");
    pa=sc.nextFloat();
    d = 100-(100*pa/pr);
    System.out.println("El descuento ha sido del "+d+"%");
    }
    
    
}
