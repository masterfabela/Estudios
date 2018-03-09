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
        Config.incmin();
       
        Display.cambiovista();
        Display.visualizar();
        Display.cambiovista();
        Display.visualizar();
        Display.cambiovista();
        Display.visualizar();
        //pasar as funcions a o run.

    }
    public ProxectoAlarma(){
        c1=new Config();
        timer=new Timer();
        timer.schedule(new Reloj(),0,1000);
        Display.visualizar();
    }

public class Reloj extends TimerTask{
    Toolkit al=Toolkit.getDefaultToolkit();
    Config a;
    public void impo(Config c){
        a=c;
    }
    @Override
    public void run(){
        
        Config.refresh();
        if(a.compH()==true){
            al.beep();
            System.out.println("Despertaaa");
            timer.cancel();
            timer.purge();
        }else{
            System.out.println("Segue dormindo.");
            Display.showhora();
        }
    }
}

}
