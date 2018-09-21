
package boletin7_1;

public class Temperatura {
    public Temperatura(){}
    public double pasoCAF(double n){
        double valor =1.8*n+32;
        return valor;
    }
    public double pasoFAC(double n){
        double valor =(n-32)*1.8;
        return valor;
    }
}
