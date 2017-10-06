package boletin2_4;
import java.util.Scanner;
public class Boletin2_4 {

    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
     float n1,n2,s,r,p,d;
     System.out.println("Indique el primer operando");
     n1=sc.nextFloat();
     System.out.println("Indique el segundo operando");
     n2=sc.nextFloat();
     s=n1+n2;
     r=n1-n2;
     p=n1*n2;
     d=n1/n2;
     System.out.println(n1+"+"+n2+"="+s);
     System.out.println(n1+"-"+n2+"="+r);
     System.out.println(n1+"*"+n2+"="+p);
     System.out.println(n1+"/"+n2+"="+d);
     
    }
    
}
