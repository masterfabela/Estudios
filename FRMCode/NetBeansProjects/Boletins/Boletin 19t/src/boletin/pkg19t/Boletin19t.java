package boletin.pkg19t;
import com.fran.clases19.*;
import javax.swing.JOptionPane;
public class Boletin19t {

    public static void main(String[] args) {
        Listas l1=new Listas();
        l1.li.add(new Libro("El Silmarilion","2578Rº","John R.R.Tolkien",25.50f,12));
        l1.li.add(new Libro("A la sobra del águila","2612Rº","Arturo Perez Reverte",20f,0));
        l1.li.add(new Libro("Mortadelo y Filemon Superhumor vol.3","1032Rº","Francisco Ibañez",15.50f,3));
        try{
        l1.amosartodo();
        //l1.vender(JOptionPane.showInputDialog("Introduza o Isbn do libro a borrar:"));
        //l1.amosar(JOptionPane.showInputDialog("Introduza o Isbn do libro a amosar:"));
        l1.baixas();
        l1.amosartodo();
        l1.engadir();
        l1.amosartodo();
        l1.baixas2();
        l1.amosartodo();
        l1.borrartodo();
        l1.amosartodo();
        }
        catch(Nullexception ne1){
                System.out.println(ne1.getMessage());
        }
        
    }
    
}
