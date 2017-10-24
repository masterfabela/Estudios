package boletin3_1;

public class Coche {
    private int velocidade ;
    
    public Coche(){
       velocidade =0 ;
    }
    public int getVelocidade(){
    return velocidade;
    }
    public void acelerar (int valor){
    velocidade=velocidade+valor;
    }
    public void frenar (int menos){
    velocidade=velocidade-menos;
 }    
}
