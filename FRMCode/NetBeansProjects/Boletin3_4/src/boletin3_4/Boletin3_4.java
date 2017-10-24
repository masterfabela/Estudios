package boletin3_4;
import java.util.Scanner;
public class Boletin3_4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Calculo m1=new Calculo();
        m1.amosarPatacas();
        m1.amosarPolbo();
        System.out.println("Introduza os kg de polbo que suma a o almacen:");
        int c=sc.nextInt();
        m1.engadirPolbo(c);
         System.out.println("Introduza os kg de patacas que suma a o almacen:");
         c=sc.nextInt();
         m1.engadirPatacas(c);
         System.out.println("Cos productos que temos, podemos atender a "+m1.clientesposibles()+" clientes");
    }
    
}
