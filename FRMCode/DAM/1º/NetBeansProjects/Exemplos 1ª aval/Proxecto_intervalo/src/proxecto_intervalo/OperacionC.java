package proxecto_intervalo;

import javax.swing.JOptionPane;

public class OperacionC {
    private int numerador,denominador;

    public OperacionC() {
    }
    public void dividirc() throws ExceptionNumerador{
        numerador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numerador"));
        denominador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o denominador"));
        
        try{
            if(numerador<20||numerador>100){
            throw new ExceptionNumerador("O numerador ha de estar entre o 20 e o 100");
        }
        System.out.println("O resultado é "+numerador/denominador);
        }catch(ExceptionNumerador en2){
            System.out.println(en2.getMessage());
        }
    }
    
}
