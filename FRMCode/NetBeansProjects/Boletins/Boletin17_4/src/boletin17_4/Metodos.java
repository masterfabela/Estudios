
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
    public String letra(int[]array,String[]arrai,int n){
        String L="Ñ,Produceuse un erro.";
        int w=0;
        for(int i=0;i<array.length;i++){
        if(n==array[i]){
        L=arrai[i];
        w++;
        }
        }
       if(w!=1){
           L="Ñ,Produceuse un erro.";
       }
        return L;
    }
}
