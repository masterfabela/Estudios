
package boletin7_1;
import java.util.Scanner;
public class Boletin7_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Temperatura temp=new Temperatura();
        System.out.println("Benvido a o programa de conversion de temperatura:"+
                "\n1:Paso de Kelvin a Fahrenheit.\n2:Paso de Fahrenheit a Kelvin.");
        int n=sc.nextInt();
        if (n==1){
            System.out.println("Introduza a temperatura en Kelvin:");
            double t=sc.nextDouble();
            System.out.println("A temperatura e de "+temp.pasoCAF(t)+"ºF.");
            }else{
            System.out.println("Introduza a temperatura en Fahrenheit:");
            double t=sc.nextDouble();
            System.out.println("A temperatura e de "+temp.pasoFAC(t)+"ºK.");
            
                }
    }
    
}
