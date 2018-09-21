package boletin9_6;
import java.util.Scanner;
public class Soldos {
    
    public Soldos (){}
    Scanner sc=new Scanner(System.in);
    int b,t,a;
    public void calcdatos(){
        int soldo;
    do{
        System.out.println("Introduza os soldos para procesalos.");
        soldo=sc.nextInt();
        while(soldo<0){
            System.out.println("Error, introduce un soldo valido(Positivo).");
            soldo=sc.nextInt();
        }
        if(soldo<1000&&soldo>0){
            b++;
            t++;
            }else{
                if(soldo>=1000 &&soldo<=1750){
                a++;
                t++;
                }
             }
    }while(soldo!=0);
        System.out.println("O numero de persoas que cobra entre 1000 e 1750 é "+a+" perosas."+
                                     "O porcentaxe que cobra menos de 1000 euros é do "+(b*100)/t+"%.");
        System.out.println(t);
    }
}
