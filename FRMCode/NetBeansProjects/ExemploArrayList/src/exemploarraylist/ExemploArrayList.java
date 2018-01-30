package exemploarraylist;

import java.util.*;
import javax.swing.JOptionPane;

public class ExemploArrayList {

    public static void main(String[] args) {
        //lista tipo Object:
//        ArrayList lista=new ArrayList();
//        lista.add(1);
//        lista.add("Hola");
//        lista.add(1.6);
//        lista.add('e');
//        for(int i=0;i<lista.size();i++){
//            System.out.println(lista.get(i));
//        }
        Metodos m1=new Metodos();
        ArrayList <Integer> lista1=new ArrayList();
        lista1.add(2);
        lista1.add(new Integer(7));
        //Este arraylist non adminte Stringlista1.add('r');
        m1.amosarit(lista1);
        //Menu de opcions.
        JOptionPane.showMessageDialog(null, "Benvido a o menú de opcións.");
        String o=JOptionPane.showInputDialog("Para engadir elemento, introduza a letra \"e\"\n,e para eliminalo,introduza \"d\" ");
        
        switch(o){
            case "e":
                m1.engadir(lista1);
                break;
            case "d":
                m1.borrarit(lista1);
                break;
            default:
                System.out.println("Caracter introducido non válido.");
                break;
        }
        m1.amosarit(lista1);
        
    }
    
}
