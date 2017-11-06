package boletin5_4;
import java.util.Scanner;
public class Boletin5_4 {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Introduza os datos da primeira persoa a comparar:\nPeso:");
       float n=sc.nextFloat();
       System.out.println("\nNome;");
       String s=sc.next();
       Persoa p1=new Persoa(n,s);
       System.out.println("Introduza os datos da segunda persoa a comparar:\nPeso:");
       n=sc.nextFloat();
       System.out.println("\nNome;");
       s=sc.next();
       Persoa p2=new Persoa(n,s);
       if (p1.getp()>p2.getp()){
           System.out.println("O que pesa mais é "+p1.getn()+",con "+p1.getp()+" Kgs, e a diferencia entre eles e de "+
                   (p1.getp()-p2.getp())+" Kgs.");
       }else{
       System.out.println("O que pesa mais é "+p2.getn()+",con "+p2.getp()+" Kgs, e a diferencia entre eles e de "+
                   (p2.getp()-p1.getp())+" Kgs.");
       }
    }
    
}
