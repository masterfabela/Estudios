package boletin14;
import javax.swing.JOptionPane;
public class Garaxe {
    int t;
    int numcoches=(int)(Math.random()*5)+1;
    String m;
    
    public void probsitio() throws SobrecochesException{
        if(numcoches!=5){
            System.out.println("Plazas dispoñibles: "+(5-numcoches));
            JOptionPane.showMessageDialog(null, "Vai a introducir os datos par poder rexistrarse");
            m=JOptionPane.showInputDialog("Introduza a matricula");
            t=(int)(Math.random()*10)+1;
            
            
        }else{
            System.out.println("Completo");
            throw new SobrecochesException ("Non e posible admitir mais coches no aparcadoiro");
        }
    }
    public void saida(Coches c){
        System.out.println("Vai ter que pagar: "+c.prezo);
        float recivido=Float.parseFloat(JOptionPane.showInputDialog("Introduza o diñeiro"));
        while(recivido<=c.prezo){
            JOptionPane.showMessageDialog(null,"Diñeiro introducido insuficiente.");
            recivido=Float.parseFloat(JOptionPane.showInputDialog("Introduza o diñeiro"));
        }
        System.out.println("***FACTURA***"+
                                  "\nMatricula: "+c.matricula+
                                  "\nTempo: "+c.tempo+" horas"+
                                  "\nPrezo: "+c.prezo+" Euros"+
                                  "\nRecivido: "+recivido+" Euros"+
                                  "\nVolta: "+(recivido-c.prezo)+" Euros"+
                                  "\n\nGrazas por usar \no noso aparcadoiro");
        numcoches--;
    }
}
