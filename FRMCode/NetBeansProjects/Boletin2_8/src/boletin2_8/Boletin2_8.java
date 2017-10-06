package boletin2_8;
import java.util.Scanner;
public class Boletin2_8 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c,v,ci,u,s;
        System.out.println("Introdizca la cantidad de billetes de 100 Euros.");
        c=sc.nextInt();
        System.out.println("Introdizca la cantidad de billetes de 20 Euros.");
        v=sc.nextInt();
        System.out.println("Introdizca la cantidad de billetes de 5 Euros.");
        ci=sc.nextInt();
        System.out.println("Introdizca la cantidad de monedas de 1 Euro.");
        u=sc.nextInt();
        s=100*c+v*20+ci*5+u;
        System.out.println(c+" billetes de 100 Euros,"+v+" billetes de 20 Euros,"+
        ci+" billetes de 5 Euros\n,"+u+"monedas de 1 Euro suman un total de "+s+" Euros");
        
    }
    
}
