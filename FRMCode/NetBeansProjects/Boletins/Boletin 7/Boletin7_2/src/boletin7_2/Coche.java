
package boletin7_2;

public class Coche {

    private int velocidade ;
    Coche (){
        velocidade = 0;
    }
    int getVelocidade() {
        return velocidade;
    }
    void acelerar(int cantidade){
    velocidade=velocidade+cantidade;
    }
    void frena ( int menos ){
    velocidade=velocidade-menos;
    }
}
