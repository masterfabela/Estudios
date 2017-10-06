package boletin2_2;
public class Boletin2_2 {

    public static void main(String[] args) {
        float l=3f,a;
        //a=L*L;
        //Tamén e posible facelo da seguinte maneira,
        //engadimos librería math para realizar operacions.
        //Neste caso, utilizarase a operacion "potencia", pow()
        a=(float)Math.pow(l,2);
        System.out.println("Area = "+a);
    }
    
}
