
package boletin7_3;
import java.util.Scanner;
public class Boletin7_3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce o precio orixinal:");
        float p1=sc.nextFloat();
        System.out.println("Introduce o precio rebaixado:");
        float p2=sc.nextFloat();
        Rebaixas rb=new Rebaixas();
        System.out.println("O desconto e do "+rb.calp(p1, p2)+"%.");
    }
    
}
