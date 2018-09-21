package proxecto_intervalo;

import javax.swing.JOptionPane;

public class Operacion {
    private int numerador,denominador;
    public Operacion(){}
    
    public void dividir() throws ExceptionNumerador{
        numerador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numerador"));
        denominador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o denominador"));
        if(numerador<20||numerador>100){
            throw new ExceptionNumerador("O numerador ha de estar entre o 20 e o 100");
        }
        System.out.println("O resultado é "+numerador/denominador);
    }
}
