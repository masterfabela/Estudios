
package testclases;
import javax.swing.JOptionPane;
public class Testclases {

    public static void main(String[] args) {
 
        Rectangulo rec1=new Rectangulo(8,9);
        System.out.println("Rec1="+rec1.toString());
        /*Rectangulo rec2=new Rectangulo(6);
        System.out.println("Rec2="+rec2.toString());*/
        Rectangulo rec3=rec1.incrementar();
        System.out.println("Rec3="+rec3.toString());
        System.out.println("A area é = "+rec3.calcarea());
        System.out.println("Rec3="+rec3.mudarbase());
        float altura;
        altura=Float.parseFloat(JOptionPane.showInputDialog("Introduce altura"));
        JOptionPane.showMessageDialog(null,"A altura é "+altura);
        
        
    }
    
}
