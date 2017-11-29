package exemplotrychatch;

import javax.swing.JOptionPane;

public class Captura {
    private int numerador,denominador;
    String s;
    
    public Captura(){}
    public void dividircaptura(){
        numerador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numerador"));
        denominador=Integer.parseInt(JOptionPane.showInputDialog("Introduza o denominador"));
        try{
            int resultado=numerador/denominador;
            System.out.println(numerador+"/"+denominador+"="+resultado);
        }catch(ArithmeticException e){
            System.out.println("Non se pode dividir entre 0.");
            //System.out.println("Erro:\n"+e.getMessage());
            //System.out.println(e.toString());
            //e.printStackTrace();
         }
        
        
        /*s=JOptionPane.showInputDialog("Hola, di algo");
        JOptionPane.showMessageDialog(null,s);*/
    }
}
