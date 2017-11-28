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
            JOptionPane.showMessageDialog(null,"Acertaches!!! Noraboa.");
            intentos=0;
        }else{
            int nu=numero-n;
        if(nu<0){
            nu=nu*(-1);
        }if(nu<=5){
             JOptionPane.showMessageDialog(null,"Fallaches, pero estas moi preto.");
        intentos--;
        }else{
        if(nu<=10){
        JOptionPane.showMessageDialog(null,"Fallaches, pero estas preto.");
         intentos--;
        }else{
        if(nu<=20){
        JOptionPane.showMessageDialog(null,"Fallaches, e estas lonxe.");
         intentos--;
        }else{
            JOptionPane.showMessageDialog(null,"Fallaches, e estas moi lonxe.");
             intentos--;
        }
        }
        }
        }
        
    }while(intentos>0);
        JOptionPane.showMessageDialog(null,"Fin do xogo.");
    }
}
