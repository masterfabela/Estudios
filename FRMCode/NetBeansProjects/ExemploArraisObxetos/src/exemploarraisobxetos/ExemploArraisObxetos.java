package exemploarraisobxetos;

import javax.swing.JOptionPane;

public class ExemploArraisObxetos {

    public static void main(String[] args) {
        MetodosArray ma1=new MetodosArray();
        Persoa []pa1=ma1.creararray();
        ma1.amosar(pa1);
        String dni=JOptionPane.showInputDialog("Que DNI buscas?");
        ma1.buscar(pa1,dni);
        System.out.println(ma1.buscar(pa1,dni));
        
    }
    
    
}
