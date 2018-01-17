package exemploarraisobxetos;

import javax.swing.JOptionPane;

public class ExemploArraisObxetos {

    public static void main(String[] args) {
        MetodosArray ma1=new MetodosArray();
        ma1.amosar(ma1.creararray());
        String dni=JOptionPane.showInputDialog("Que DNI buscas?");
        ma1.buscar(ma1.creararray(),dni);
        
    }
    
    
}
