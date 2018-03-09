package proxectoalarma;

import java.awt.Toolkit;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author femio23
 */
public class ProxectoAlarma {
            Timer timer;
            Config c1;
    public static void main(String[] args) throws InterruptedException{
        new ProxectoAlarma();
        new Display();
        
       
        Display.cambiovista();
        Display.visualizar(c1);
        c1.inchora();
        c1.incmin();
        d1.cambiovista();
        d1.visualizar(c1);
        d1.cambiovista();
        d1.visualizar(c1);
        //pasar as funcions a o run.

    }
    public ProxectoAlarma(){
        c1=new Config();
        timer=new Timer();
        timer.schedule(new Reloj(),0,1000);
        Display.visualizar(c1);
    }

public class Reloj extends TimerTask{
    Toolkit al=Toolkit.getDefaultToolkit();
    Config a;
    public void impo(Config c){
        a=c;
    }
    @Override
    public void run(){
        
        if(a.compH()==true){
            al.beep();
            System.out.println("Despertaaa");
            timer.cancel();
            timer.purge();
        }else{
            System.out.println("Segue dormindo.");
        }
    }
}

}
