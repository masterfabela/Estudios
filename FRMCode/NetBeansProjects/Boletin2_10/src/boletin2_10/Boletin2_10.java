
package boletin2_10;
import java.util.Scanner;
public class Boletin2_10 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double v,k,d,sb,sl;
        final double sf=1234 ;
        System.out.println("Introduzca el importe de ventas realizado:");
        v=sc.nextFloat();
        System.out.println("Introduzca la cantidad de kilometros recorridos:");
        k=sc.nextFloat();
        System.out.println("Introduzca la cantidad de dietas consumidas:");
        d=sc.nextFloat();
        sb= sf+(5.*v/100)+2*k+30*d;
        sl= sb-(18*sb/100)-36;
        System.out.println("El sueldo bruto a percivir será de "+sb+", y el sueldo liquido"
                + "\n será de "+sl+" mensuales");
    }
    
}
