package boletin4_3;

public class Boletin4_3 {

    public static void main(String[] args) {
        Circulo c1=new Circulo(3);
        System.out.println("O radio do circulo é "+c1.getRadio());
        c1.setRadio(4);
        System.out.println("O radio do circulo é "+c1.getRadio());
        System.out.println("A área do circulo é "+c1.calcarea());
        System.out.println("A lonxitude do circulo é "+c1.calclonx());
    }
    
}
