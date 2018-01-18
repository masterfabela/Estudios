
package boletin17_3;

import javax.swing.JOptionPane;

public class Metodos {
     public Metodos() {
    }
    public int[] creadorn(int[]array){
        for(int i=0;i<array.length;i++){
        int n= (int)(Math.random()*10+1);
        array[i]=n;
        }
    return array;
    }
    public String[] creadorp(String[]array){
        for(int i=0;i<array.length;i++){
        String p= JOptionPane.showInputDialog("Introduza o nome do alumno.");
        array[i]=p;
        }
    return array;
    }
    public void cualificador(int[]array){
        int aprobados=0,suspensos=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>=5)
                aprobados++;
            else
                suspensos++;
        }
        System.out.println("Suspensos="+suspensos+".\nAprobados="+aprobados+".");
    }
    public void mediador(int[]array){
        int acumulador=0;
    for(int i=0;i<array.length;i++){
            acumulador=acumulador+array[i];
        }
        System.out.println("A media do curso é de "+acumulador/array.length+".");
    }
    public void mathonra(int[]array){
        int nmax=0;
    for(int i=0;i<array.length;i++){
            if(array[i]>nmax)
                nmax=array[i];
        }
        System.out.println("A nota maxima foi de "+nmax+".");
    }
}
