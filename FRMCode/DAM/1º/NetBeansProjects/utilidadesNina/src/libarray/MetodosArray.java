package libarray;

import javax.swing.JOptionPane;

public class MetodosArray {
    public static void reverseorder(float[]array){
    int i,j;
    float aux;
    for(i=0;i<array.length/2;i++){
                aux=array[i];
                array[i]=array[array.length-1-i];
                array[array.length-1-i]=aux;
                
                
            
        }
    }
    public static int lerint(){
        int datos;
        datos=Integer.parseInt(JOptionPane.showInputDialog("Introduza o dato."));
        return datos;
    }
}
