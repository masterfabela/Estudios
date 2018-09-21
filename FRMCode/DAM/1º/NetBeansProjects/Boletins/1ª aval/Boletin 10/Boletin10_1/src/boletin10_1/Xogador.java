package boletin10_1;
import javax.swing.JOptionPane;

public class Xogador {
    int intentos,numero;
    public Xogador(int num, int intt){
    numero=num;
    intentos=intt;
    
    }
    public void xogar(){
        
    do{
        int n=(int) Float.parseFloat(JOptionPane.showInputDialog("Xogador 2, Introduza un numero, ten "+intentos+" intentos"));
        if(numero==n){
            JOptionPane.showMessageDialog(null,"Acertaches!!! Noraboa.");
            intentos=0;
        }else{
        if(numero>n){
        JOptionPane.showMessageDialog(null,"Fallaches, o numero é maior que o teu.");
        intentos--;
        }else{
        JOptionPane.showMessageDialog(null,"Fallaches, o numero é menor que o teu");
        intentos--;
            }
        }
        
    }while(intentos>0);
        JOptionPane.showMessageDialog(null,"Fin do xogo.");
    }
}
