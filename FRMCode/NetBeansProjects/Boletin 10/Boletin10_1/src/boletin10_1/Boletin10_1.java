package boletin10_1;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Boletin10_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="s";
        int n=-1,i=-1;
        do{
            do{
                
            n=(int) Float.parseFloat(JOptionPane.showInputDialog("Xogador 1, introduza o numero co que se vai a xogar (entre 1 e 50):"));
            }while(n<0 &&n>50);
            
                do{
                    i=Integer.parseInt(JOptionPane.showInputDialog("Xogador 1, introduza o numero de intentos que terá o xogador 2:"));
                }while(i<1 &&i>49);
                Xogador x1=new Xogador(n,i);
                x1.xogar();
                System.out.println("Desexa volver a xogar?");
                s=sc.next();
        }while(s =="s");
    }
    
}
