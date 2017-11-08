package extradescontos;
import java.util.Scanner;
public class Extradescontos {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Factura d=new Factura();
        System.out.println("Introduza o precio do producto:");
        double p=sc.nextDouble();
        d.setp(p);
        System.out.println("Introduza a cantidade de productos:");
        int n=sc.nextInt();
        d.setc(n);
        d.facturar();
        
    }
    
}
