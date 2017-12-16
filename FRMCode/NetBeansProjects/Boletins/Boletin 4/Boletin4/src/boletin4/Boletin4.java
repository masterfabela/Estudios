package boletin4;
import java.util.Scanner;
public class Boletin4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Coche c1=new Coche();
        System.out.println("Bos dias, a velocidade actual do coche é "+c1.getVelocidade()+" Km/h"+
                                     "\nIntroduza o valor a aumentar na velocidade");
        int v1=sc.nextInt();
        c1.acelerar(v1);
        System.out.println("A velocidade actual é de "+c1.getVelocidade()+" Km/h"+
                                     "\nIntroduza o valor a diminuir na velocidade");
        v1=sc.nextInt();
        c1.frenar(v1);
        System.out.println("A velocidade actual é de "+c1.getVelocidade()+" Km/h");
    }
    
}
