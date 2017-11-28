package boletin10_2;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Boletin10_2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="s";
        int n=-1,i=-1;
        do{    
            n=(int) (Math.random() * 50) + 1;
            JOptionPane.showMessageDialog(null,n);
                do{
                    i=Integer.parseInt(JOptionPane.showInputDialog("Xogador 1, introduza o numero de intentos que terá o xogador 2:"));
                }while(i<1 &&i>49);
                Xogadores x1=new Xogadores(n,i);
                x1.xogar();
                System.out.println("Desexa volver a xogar?");
                s=sc.next();
        }while(s =="s");
    }
    
}
