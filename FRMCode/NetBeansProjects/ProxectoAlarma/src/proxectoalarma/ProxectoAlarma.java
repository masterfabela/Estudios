package proxectoalarma;

import java.awt.Toolkit;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author femio23
 */
public class ProxectoAlarma {
            Timer timer;
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
    public ProxectoAlarma(){
        timer=new Timer();
        timer.schedule
    }

public class Reloj extends TimerTask{
    Toolkit al=Toolkit.getDefaultToolkit();
    Config a;
    Timer ti;
    public void impo(Config c,Timer t){
        a=c;
        ti=t;
    }
    @Override
    public void run(){
        if(a.compH()==true){
            al.beep();
            System.out.println("Despertaaa");
            ti.cancel();
            ti.purge();
        }
    }
}

}
