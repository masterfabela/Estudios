
package boletin5_5;
import java.util.Scanner;
public class Boletin5_5 {

    public static void main(String[] args) {
        System.out.println("Introduce o primeiro numero");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Numero n1=new Numero(n);
        System.out.println("Introduce o segundo numero");
        n=sc.nextInt();
        Numero n2=new Numero(n);
        System.out.println("Introduce o terceiro numero");
        n=sc.nextInt();
        Numero n3=new Numero(n);
maior(n1,n2,n3);
    }
    public static void maior(Numero n1, Numero n2, Numero n3){
        if (n1.valor>n2.valor){
        if (n1.valor>n3.valor){
            System.out.println("O numero maior dos 3 é "+n1.valor);
        }else{ System.out.println("O numero maior dos 3 é "+n3.valor);}
        }else{
        if (n2.valor>n3.valor){
        System.out.println("O numero maior dos 3 é "+n2.valor);
        }else{
        System.out.println("O numero maior dos 3 é "+n3.valor);
        }
        }
    }
}
