package boletin17_1;

public class Boletin17_1 {

    public static void main(String[] args) {
        Metodos m1=new Metodos();
        int[]numeros=new int[6];
        numeros=m1.creador(numeros);
        for(int i=numeros.length-1;i>-1;i--){
            System.out.println(numeros[i]);
        }
        
        System.out.println("O primeiro elemento do array é: "+numeros[0]);
    }
}
    

