package exemplo_métodos;
import java.util.Scanner;
public class Exemplo_Métodos {

    public static void main(String[] args) {
        //creacion de obxeto sen valores
        Rectangulo primeiro=new Rectangulo();
        primeiro.amosar();
        //creacion do obxeto con valores
        Rectangulo segundo=new Rectangulo(3,5);
        segundo.amosar();
        //creacion de obxeto con valores introducidos por teclado
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduza a base:");
        float b=sc.nextFloat();
        System.out.println("Introduza a altura");
        float a=sc.nextFloat();
        Rectangulo terceiro=new Rectangulo(b,a);
        //invocado de metodos, con e sen parámetro
        terceiro.amosar();
        terceiro.calcArea(b, a);
        terceiro.calcPerim(b, a);
        segundo.setBase(10);
        System.out.println(segundo.getAltura());
        
    }
    
}
