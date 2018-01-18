package boletin17_4;

public class Boletin17_4 {

    public static void main(String[] args) {
         
        String[]letras={"A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
        int[] numeros={3,11,20,9,22,7,4,18,13,12,19,5,12,8,16,1,15,0,17,2,10,6,14};
        Metodos m1=new Metodos();
        String numero=m1.creador();
        int n=m1.divisor(numero);
        System.out.println("A letra correspondente o seu DNI é: "+m1.letra(numeros,letras,n));
         for(int i=0;i<numeros.length;i++){
             System.out.println("A o resto "+numeros[i]+" correspondelle a letra "+letras[i]);
         }
        
    }
    
}
