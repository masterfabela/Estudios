
package boletin14;

public class SobrecochesException extends Exception{
    
    SobrecochesException(){
    super("Info da excepcion");
    }
    SobrecochesException(String mensaxe){
    super(mensaxe);
    }
}
