
package exemplotrychatch;

import javax.swing.JOptionPane;

public class PropagarExcepcion {
    private int numerador,denominador;

    public PropagarExcepcion() {
    }
    public void dividirPE() throws ArithmeticException{
        numerador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numerador"));
        denominador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o denominador"));
        if(denominador==0){
        throw new ArithmeticException("Non é posible dividir entre 0.");//Aqui se propaga a excepcion
        }else{
            System.out.println("Resultado="+numerador/denominador);
        }
        
    }
}
