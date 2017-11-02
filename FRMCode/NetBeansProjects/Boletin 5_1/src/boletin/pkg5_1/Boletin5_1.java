package boletin.pkg5_1;
import java.util.Scanner;
public class Boletin5_1 {

    public static void main(String[] args) {
        //Vamos a distinguir entre positivos e negativos.
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce o número:");
        int mem=sc.nextInt();
        Numero num1=new Numero(mem);
        if (num1.getnum()>0)
            System.out.println(num1.getnum()+" é positivo.");
    }
    
}
