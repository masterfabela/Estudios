package boletin9_4;
import java.util.Scanner;
public class Boletin9_4 {

    public static void main(String[] args) {
        int n;
        Tablas t1=new Tablas();
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Introduza o numero do que quere calcular a taboa de multiplicar:");
            n=sc.nextInt();
            t1.calcular(n);
         }while(n!=0);
            
       
        
    }
    
}
