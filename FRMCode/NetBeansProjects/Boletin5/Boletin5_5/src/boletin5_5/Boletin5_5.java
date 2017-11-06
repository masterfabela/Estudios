package boletin5_5;
import java.util.Scanner;
public class Boletin5_5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza o primeiro numero a comparar:");
        int n=sc.nextInt();
        Numero n1=new Numero(n);
        System.out.println("Introduza o segundo numero a comparar:");
        n=sc.nextInt();
        Numero n2=new Numero(n);
        System.out.println("Introduza o terceiro numero a comparar:");
        n=sc.nextInt();
        Numero n3=new Numero(n);
        if (n1.getv()>n2.getv()&&n1.getv()>n3.getv()){
            System.out.println("O numero maior é "+n1.getv());
        }else{if(n2.getv()>n3.getv()){
            System.out.println("O numero maior é "+n2.getv());
        }else{
            System.out.println("O numero maior é "+n3.getv());
        }
            
            }
    }
    
}
