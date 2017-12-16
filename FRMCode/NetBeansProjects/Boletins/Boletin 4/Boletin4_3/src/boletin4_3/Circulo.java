package boletin4_3;

public class Circulo {
    double radio;
    final double pi=3.14;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Circulo() {
    }
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    public double calcarea(){
    double area=pi*Math.pow(radio, 2);
        return area;
    }
    public double calclonx(){
    double lonx=2*pi*radio;
        return lonx;
    }
}
