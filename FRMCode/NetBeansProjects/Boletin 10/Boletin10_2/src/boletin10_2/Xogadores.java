package boletin10_2;
import javax.swing.JOptionPane;

public class Xogadores {
    int intentos,numero;
    public Xogadores(int num, int intt){
    numero=num;
    intentos=intt;
    
    }
    public void xogar(){
        
    do{
        int n=(int) Float.parseFloat(JOptionPane.showInputDialog("Xogador 2, Introduza un numero, ten "+intentos+" intentos"));
        if(numero==n){
            System.out.println("Acertaches!!! Noraboa.");
            intentos=0;
        }else{
            System.out.print("Fallaches, o numero é ");
        }if(numero>n){
        System.out.println("maior que o teu.");
        intentos--;
        }else{
        System.out.println("menor que o teu");
        intentos--;
        }
        
    }while(intentos>0);
        System.out.println("Fin do xogo.");
    }
}
