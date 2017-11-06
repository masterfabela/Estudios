package boletin5_3;
import java.util.Scanner;
public class Boletin5_3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza o numero a consultar:");
        int n=sc.nextInt();
        Numero Num=new Numero(n);
        if (Num.getv()<0){
            System.out.println("-");
        }else{
        if (Num.getv()==0){
            System.out.println("0");
        }else{
            System.out.println("+");
        }
        }

    }
    
}
