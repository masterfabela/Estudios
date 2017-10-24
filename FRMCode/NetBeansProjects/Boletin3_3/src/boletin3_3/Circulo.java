package boletin3_3;

public class Circulo {
    double radio;
    static double pi=3.14d;
    
    public Circulo(){
    radio=0;
    }
    public Circulo(double r){
    radio=r;
    }
    public double getCirculo(){
        return radio;
    }
    public void setCirculo(double r){
        radio=r;
    }
    public double calcarea(){
    return (pi*Math.pow(radio, radio));
    }
    public double calccir(){
    return (pi*radio*2);
}
