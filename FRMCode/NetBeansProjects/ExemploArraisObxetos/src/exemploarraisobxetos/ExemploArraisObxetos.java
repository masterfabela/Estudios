package exemploarraisobxetos;
import java.util.Arrays;

public class ExemploArraisObxetos {

    public static void main(String[] args) {
        MetodosArray ma1=new MetodosArray();
        Persoa []pa1=ma1.creararray();
        ma1.amosar(pa1);
        /*String dni=JOptionPane.showInputDialog("Que DNI buscas?");
        System.out.println(ma1.buscar(pa1,dni));*/
        //ordenar
        Arrays.sort(pa1);
        ma1.amosar(pa1);
        
        
        
    }
    
    
}
