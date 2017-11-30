
package exemplotrychatch;

import javax.swing.JOptionPane;

public class DividirExcepcionsPropias {
    private int numerador,denominador;
    
    public DividirExcepcionsPropias() {
    }
        public void dividirEP()throws ExcepcionsPropias{
        numerador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numerador"));
        denominador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o denominador"));
            int resultado=numerador/denominador;
            System.out.println(numerador+"/"+denominador+"="+resultado);
            if(denominador==0){
            throw new ExcepcionsPropias("Non se pode / entre 0");
            }
            System.out.println("Resultado= "+numerador/denominador);
        }
}
