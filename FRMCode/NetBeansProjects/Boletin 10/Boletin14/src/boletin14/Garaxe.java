package boletin14;
import javax.swing.JOptionPane;
public class Garaxe {
    int numcoches=3,t;
    String m;
    
    public void probsitio(){
        if(numcoches!=5){
            System.out.println("Plazas dispoñibles");
            JOptionPane.showMessageDialog(null, "Vai a introducir os datos par poder rexistrarse");
            m=JOptionPane.showInputDialog("Introduza a matricula");
            t=(int)(Math.random()*10)+1;
            
            
        }else{
            System.out.println("Completo");
        }
    }
    public void saida(Coches c){
        System.out.println("Vai ter que pagar: "+c.prezo);
        float recivido=Float.parseFloat(JOptionPane.showInputDialog("Introduza o diñeiro"));
        System.out.println("***FACTURA***"+
                                  "\nMatricula: "+c.matricula+
                                  "\nTempo: "+c.tempo+
                                  "\nPrezo: "+c.prezo+
                                  "\nRecivido: "+recivido+
                                  "\nVolta: "+(recivido-c.prezo)+
                                  "\n\nGrazas por usar \nos noso servicios");
        numcoches--;
    }
}
