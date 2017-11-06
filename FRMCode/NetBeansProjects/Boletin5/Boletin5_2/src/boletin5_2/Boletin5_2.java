package boletin5_2;
import java.util.Scanner;
public class Boletin5_2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testVar = 43;
        System.out.println("Introduza o primeiro valor:");
        short n=sc.nextShort();
        Numero n1=new Numero(n);
        System.out.println("Introduza o primeiro valor:");
        n=sc.nextShort();
        Numero n2=new Numero(n);
       
       
       if (n1.getv()>=n2.getv()){
           System.out.println("A resta de ambos numeros é = "+(n1.getv()-n2.getv()));
       }
       System.out.println("A suma de ambos numeros é = "+(n1.getv()+n2.getv()));
       
    }
    
}
