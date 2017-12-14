package boletin4;

public class Coche {
    int velocidade =0;

public int getVelocidade(){
return velocidade;
}
public void acelerar(int valor){
velocidade=velocidade+valor;
}
public void frenar(int menos){
velocidade=velocidade-menos;
}

}