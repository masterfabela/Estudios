
package boletin13;

import javax.swing.JOptionPane;

public class Boletin13 {

    public static void main(String[] args) {
        float cel;
        ConversorTemperaturas ct1=new ConversorTemperaturas();
        cel=Float.parseFloat(JOptionPane.showInputDialog("Introduzca a temperatura en grados Celsius"));
        try{
            System.out.println(ct1.caf(cel));
        }catch(TemperaturaErradaException ter1){
            System.out.println(ter1.getMessage());
        }
        System.out.println(ct1.car(cel));
    }
    
}
