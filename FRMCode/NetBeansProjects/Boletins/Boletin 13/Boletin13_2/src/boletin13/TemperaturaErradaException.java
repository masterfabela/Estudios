
package boletin13;

public class TemperaturaErradaException extends Exception{
    public TemperaturaErradaException(){
    super("Non se pode operar con temperaturas < a 80ºC");
    }
    public TemperaturaErradaException(String s){
    super(s);
    }
}
