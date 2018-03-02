package proxectoalarma;

/**
 *
 * @author femio23
 */
public class ProxectoAlarma {
    
    public static void main(String[] args) {
        Display d1=new Display();
        Config c1=new Config();
        d1.visualizar(c1);
        d1.cambiovista();
        d1.visualizar(c1);
        c1.inchora();
        c1.incmin();
        d1.cambiovista();
        d1.visualizar(c1);
        d1.cambiovista();
        d1.visualizar(c1);
        
    }
}

