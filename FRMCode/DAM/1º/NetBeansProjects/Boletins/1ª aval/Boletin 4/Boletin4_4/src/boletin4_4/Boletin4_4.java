package boletin4_4;

public class Boletin4_4 {

    public static void main(String[] args) {
        Almacen a1=new Almacen();
        System.out.print("Kgs de patacas:");
        a1.amosarPatacas();
        System.out.print("Kgs de polbo:");
        a1.amosarPolbo();
        a1.engadirPolbo(2);
        a1.engadirPatacas(50);
        System.out.print("Kgs de patacas:");
        a1.amosarPatacas();
        System.out.print("Kgs de polbo:");
        a1.amosarPolbo();
        a1.calclientes();
    }
    
}
