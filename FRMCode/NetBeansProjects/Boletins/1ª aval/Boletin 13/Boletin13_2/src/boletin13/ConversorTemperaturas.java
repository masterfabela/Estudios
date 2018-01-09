
package boletin13;

import javax.swing.JOptionPane;


public class ConversorTemperaturas {
    final private float condicion=80f;
    private float f,r;
    public ConversorTemperaturas(){}

    
    public float caf (float c) throws TemperaturaErradaException {
        if(c<condicion){
            throw new TemperaturaErradaException("Non se pode operar con temperaturas inferiores a 80º celsius.");
        }else{
        f=(float) (c*(9/5)+32.4);
        }
    return f;
    }
    public float car(){
        float c=Float.parseFloat(JOptionPane.showInputDialog("Introduzca a temperatura en º Celsius"));
        try{
            if (c<condicion){
        throw new TemperaturaErradaException("Non se pode traballar con temperaturas < 80ºC");
        }else{
        r=((float)(4)/5)*c;
            }
        }catch(TemperaturaErradaException ter1){
            System.out.println(ter1.getMessage());}
        return r;
    }
    
}
