package boletin5_3;
import java.util.Scanner;
public class Boletin5_3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza un número");
        int n=sc.nextInt();
        Numero nu=new Numero(n);
        nu.getsigno();
    }
    
}
