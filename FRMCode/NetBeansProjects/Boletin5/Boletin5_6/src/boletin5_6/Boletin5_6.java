package boletin5_6;
import java.util.Scanner;
public class Boletin5_6 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza os datos do primeiro artigo:\nNome:");
        String n=sc.nextLine();
        System.out.println("Introduza a cantidade de productos vendidos:");
        int c=sc.nextInt();
        Artigo primeiro=new Artigo(n,c);
        primeiro.tipo(primeiro);
        
    }
    
}
