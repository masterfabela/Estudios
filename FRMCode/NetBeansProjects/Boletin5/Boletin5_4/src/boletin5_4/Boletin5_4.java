
package boletin5_4;
import java.util.Scanner;
public class Boletin5_4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce os datos da primeira persoa:\nNome:");
        String gu=sc.nextLine();
        System.out.println("Peso:");
        float g=sc.nextFloat();
        Persoa p1=new Persoa(g,gu);
        System.out.println("Introduce os datos da segunda persoa:\nNome:");
        String ha=sc.nextLine();
        System.out.println("Peso:");
        float a=sc.nextFloat();
        Persoa p2=new Persoa(g,gu);
pesado(p1,p2);
    }
    public static void pesado(Persoa p1, Persoa p2){
        if (p1.peso>p2.peso){
            float mem =p1.peso-p2.peso;
            System.out.println("A persoa mais pesada é "+p1.nome+", e a diferencia de peso entre elas é de "+mem+" Kg.");
        }else{
        float mem =p2.peso-p1.peso;
            System.out.println("A persoa mais pesada é "+p2.nome+", e a diferencia de peso entre elas é de "+mem+" Kg.");
        }
    }
}
