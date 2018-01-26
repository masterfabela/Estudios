
package boletin17_1;

public class Metodos {

    public Metodos() {
    }
    
    public static int[] creador(int[]array){
        for(int i=0;i<array.length;i++){
        int n= (int)(Math.random()*50+1);
        array[i]=n;
        }
    return array;
    }
    
}
