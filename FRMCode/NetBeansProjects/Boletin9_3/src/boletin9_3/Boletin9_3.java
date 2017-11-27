
package boletin9_3;
import java.util.Scanner;
public class Boletin9_3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float n1,n2;
        System.out.println("Vai a introducir os datos do rectangulo"
                                  +"\n***************************************");
        do{
            System.out.println("Base:");
            n1=sc.nextFloat();
        }while(n1<0);
        do{
            System.out.println("Altura:");
            n2=sc.nextFloat();
        }while(n2<0);
        Rectangulos r1=new Rectangulos(n1,n2);
        r1.calcarea();
    }
    
}
