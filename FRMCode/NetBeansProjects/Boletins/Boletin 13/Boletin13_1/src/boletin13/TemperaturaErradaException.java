
package boletin13;

public class TemperaturaErradaException extends Exception{
    //f
    public TemperaturaErradaException(){
    super("Non se pode operar con temperaturas < a 80ºC");
    }
    public TemperaturaErradaException(String s){
    super(s);
    }
}
