
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
    public void cualificador(int[]array,String[]arrai){
        System.out.println("*****Lista de aprobados*****");
        for(int i=0;i<array.length;i++){
            if(array[i]>=5)
                System.out.println("Alumno: "+arrai[i]+" - Nota: "+array[i]);
        }
    }
    public void buscador(int[]array,String[]arrai){
        String n=JOptionPane.showInputDialog("A quen desexas buscar?");
        int acerto=0;
        for(int i=0;i<arrai.length;i++){
            if(n.equalsIgnoreCase(arrai[i])){
                System.out.println("O alumno "+n+" ten unha nota de "+array[i]);
                acerto++;
            }
        }
        if (acerto==0)
            System.out.println("Non se topou a ninguen con dito nome");
    }
    public int[] ordec(int[]array,String[]arrai){
    int i,j;
    int aux;
    String aux1;
    for(i=0;i<array.length-1;i++){
        for(j=i+1;j<array.length;j++){
            if(array[i]>array[j]){
                aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                aux1=arrai[i];
                arrai[i]=arrai[j];
                arrai[j]=aux1;
            }
        }
    }
        return array;
    }
}
