package aguinaldo;
import java.util.Scanner;
public class Aguinaldo {

    public static void main(String[] args) {
       String n;
        do{
        Scanner sc=new Scanner(System.in);
        MetodoGrat mg=new MetodoGrat();
        System.out.println("Benvido a o programa de calculo de bonificacions."+
                "\nVai introducir os datos do empregado:"+
                "\nNome:");
        n=sc.next();
        System.out.println("Numero de fillos:");
        int nf=sc.nextInt();
        System.out.println("Horas ausente:");
        float ha=sc.nextFloat();
        Empregado e=new Empregado(n,nf,ha);
        mg.calcgrat(e);
        System.out.println(mg.toString());
            System.out.println("****Gratificacion Extra****"+
         "\nNome: "+e.getn()+
         "\nNumero de fillos: "+e.getf()+
         "\nHoras ausente: "+e.getha()+
         "\n***************************"+
         "\n*******GRATIFICACION*******"+
         "\nFixa: "+mg.gratf+
         "\nVariable: "+mg.gratv+
         "\nGratificacion Total:"+
          mg.t);
        }
        while( n.equals("*"));
        System.out.println("Fin");
    }
    
}
