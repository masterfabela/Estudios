package boletin9_5;
import java.util.Scanner;
public class Boletin9_5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=1;
        while(n>0){
            System.out.println(" ");
            System.out.println("Introduza un número para a serie:");
            n=sc.nextInt();
            Series s1=new Series(n);
            s1.cs();
            
        }
    }
    
}
