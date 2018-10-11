/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin17_2;

/**
 *
 * @author femio23
 */
public class Metodos {

    public Metodos() {
    }
    public int[] creador(int[]array){
        for(int i=0;i<array.length;i++){
        int n= (int)(Math.random()*10+1);
        array[i]=n;
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
