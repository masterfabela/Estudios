package ex_ticket_bar;
import java.util.Scanner;
public class Ex_ticket_bar {

    public static void main(String[] args) {
        int cc,a,v,e,t;
        Scanner sc=new Scanner(System.in);
        System.out.println("Cantas cocacolas consumiron?");
        cc=sc.nextInt();
        System.out.println("Cantas augas consumiron?");
        a=sc.nextInt();
        t=cc*3+a*2;
        System.out.println("O importe total é de "+t+".  Canto importe entrega?");
        e=sc.nextInt();
        v=e-t;
     System.out.println("'Casa Pepe'\n\n"
             + "Consumicions:\n"
             + " "+cc+" Cocacolas = 15.\n"
             + " "+a+" Augas     = 7.\n\n"
             + "Importe total= "+t+".\n\n"
             + "Entregado    = "+e+".\n"
             + "Volta        = "+v+".\n\n"
             + "Grazas pola sua visita");
    }
    
}
