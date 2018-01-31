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
        m1.engadir(2);
        m1.engadir(7);
        //Este arraylist non adminte -->Stringlista1.add('r');
        m1.amosarit();
        //Menu de opcions.
        JOptionPane.showMessageDialog(null, "Benvido a o menú de opcións, introduza a accion a realizar.");
        String o=JOptionPane.showInputDialog("e:Engadir\ndp:borrado por posición\nde:borrado por elemento\nmp:modificar por posicion\nme:modificar por elemento");
        
        switch(o){
            case "e":
                m1.engadir(Integer.parseInt(JOptionPane.showInputDialog("Indique o valor enteiro a engadir")));
                break;
            case "dp":
                m1.quitarposicion(Integer.parseInt(JOptionPane.showInputDialog("Indique a posicion a borrar")));
                break;
            case "de":
                m1.borrarelemento(Integer.parseInt(JOptionPane.showInputDialog("Indique o elemento a borrar")));
                break;
            case "mp":
                m1.mudarposicio(Integer.parseInt(JOptionPane.showInputDialog("Indique a posicion do elemento a modificar")),Integer.parseInt(JOptionPane.showInputDialog("Indique o valor co que sustituir")));
                break;
            case "me":
                m1.mudarelem(Integer.parseInt(JOptionPane.showInputDialog("Indique o valor a buscar para sustituir")), Integer.parseInt(JOptionPane.showInputDialog("Indique o valor co que sustituir")));
                break;
            default:
                System.out.println("Caracter introducido non válido.");
                break;
        }
        m1.amosarit();
    }
    
}
