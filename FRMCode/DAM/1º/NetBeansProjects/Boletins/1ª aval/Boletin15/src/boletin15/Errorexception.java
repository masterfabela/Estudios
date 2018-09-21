
package boletin15;

public class Errorexception extends Exception{
    String s;

    public Errorexception() {
        super("Solo se puede trabajar con numeros positivos." );
    }
    
}
