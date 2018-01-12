
package boletin7_2;
import java.util.Scanner;
public class Boletin7_2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Coche c=new Coche();
        System.out.println("Bos dias, o coche está encendido e preparado."
                + "\nPulse 1 para aumentar a velocidade ou 2 para diminuila.");
        int i=sc.nextInt();
    if (i==1){
        System.out.println("En canto quere incrementar a velocidade?");
        int a=sc.nextInt();
    c.acelerar(a);
    }else{
    System.out.println("En canto quere reducir a velocidade?");
        int a=sc.nextInt();
        c.frena(a);
    }
        System.out.println("A velocidade actual é de "+c.getVelocidade()+" Km/h.");
    }
}