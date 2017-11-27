package boletin9_1;
import java.util.Scanner;
public class Boletin9_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Numeros n1=new Numeros();
        int n;
        
        for(int i=0;i<10;i++){
            System.out.println("Introduce un numero:");
            n=sc.nextInt();
            n1.calcular(n);
        }
        System.out.println(n1.toString());
    }
    
}
