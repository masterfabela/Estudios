
package boletin17_4;

import javax.swing.JOptionPane;

public class Metodos {

    public Metodos() {
    }
        
    public String creador(){
        String p= JOptionPane.showInputDialog("Introduza SO o seu numero de DNI.");
        return p;
    }
    public int divisor(String n){
        int r;
        r=Integer.parseInt(n);
        r=r%23;
        return r;
    }
    public char letra(int[]array,char[]arrai,int n){
        char L='Ñ';
        int w=0;
        for(int i=0;i<array.length;i++){
        if(n==array[i]){
        L=arrai[i];
        w++;
        }
        }
       if(w!=1){
           L='ñ';
       }
        return L;
    }
}
