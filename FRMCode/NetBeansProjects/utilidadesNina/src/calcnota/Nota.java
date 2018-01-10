package calcnota;

import javax.swing.JOptionPane;

/**
 *
 * @author femio23
 */
public class Nota {
    public static float calcnota(){
        float notaf;
        float n1=Float.parseFloat(JOptionPane.showInputDialog("Introduzca a primeira nota:"));
        float n2=Float.parseFloat(JOptionPane.showInputDialog("Introduzca a segunda nota:"));
        notaf=(n1+n2)/2;
        return notaf;
    }
}
