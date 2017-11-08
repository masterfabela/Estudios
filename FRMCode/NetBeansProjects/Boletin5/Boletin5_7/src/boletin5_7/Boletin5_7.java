package boletin5_7;
import java.util.Scanner;
public class Boletin5_7 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Parametros ej=new Parametros();
        System.out.println("Elixa a opcion da figura da que vai a calculala superficie, premendo o boton indicado:"+
                "\nRectangulo=1.\nTriangulo=2.\nCirculo=3.");
        int mem=sc.nextInt();
        switch (mem){
            case 1:{
                System.out.println("Introduza os datos do rectangulo:\nBase:");
                float n=sc.nextFloat();
                ej.setb(n);
                System.out.println("Altura:");
                n=sc.nextFloat();
                ej.seta(n);
                System.out.println("A superficie do rectangulo = "+(ej.base*ej.altura));
            }
            break;
            case 2:{
             System.out.println("Introduza os datos do triangulo:\nBase:");
                float n=sc.nextFloat();
                ej.setb(n);
                System.out.println("Altura:");
                n=sc.nextFloat();
                ej.seta(n);
                 System.out.println("A superficie do triangulo = "+((ej.base*ej.altura)/2));
            }
            break;
            case 3:{
                System.out.println("Introduza os datos do circulo:\nRadio:");
                float n=sc.nextFloat();
                ej.setr(n);
                 System.out.println("A superficie do circulo = "+Math.pow(ej.radio,2)*ej.pi);
            }
            break;
            default:System.out.println("Error, introducido valor erroneo.");
            }
        
        }
    }