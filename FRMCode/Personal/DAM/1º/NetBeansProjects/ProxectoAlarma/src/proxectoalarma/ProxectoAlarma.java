package proxectoalarma;

import java.awt.Toolkit;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author femio23
 */
public class ProxectoAlarma {
            Timer timer;
            Config c1;
            static int auxil=0;
             String s="p";
    public static void main(String[] args) throws InterruptedException{
        Display.setModoalarma(false);
        new ProxectoAlarma();
        
        while(Config.fin()==false){
            if(!Display.isModoalarma()){
                auxil=Integer.parseInt(JOptionPane.showInputDialog("Alarma activa:"+Config.getactiva()+"\nMenú modo hora"+"\n1-Cambiar modo."
                    + "\n2-Incrementar horas."+ "\n3-Incrementar minutos."+"\n4-Alarma on/off."));
            }else{
                auxil=Integer.parseInt(JOptionPane.showInputDialog("Alarma activa:"+Config.getactiva()+"\nMenú modo alarma\n1-Cambiar modo."
                    + "\n2-Incrementar horas."+ "\n3-Incrementar minutos."+"\n4-Alarma on/off."));
            }
             switch(auxil){
                case 1:Display.cambiovista();
                auxil=0;
                break;
                case 2:Config.inchora(1);
                Display.visualizar();
                auxil=0;
                break;
                case 3:Config.incmin(1);
                Display.visualizar();
                auxil=0;
                break;
                case 4:
                if(Config.getactiva()==true){
                    Config.setactiva(false);
                }else{
                    Config.setactiva(true);
                }
                Display.visualizar();
                auxil=0;
                break;
                default:
                break;
            }
        }
    }
    /**
     * Constructor da clase principal, necesario para iniciar o fio.
     */
    public ProxectoAlarma(){
        new Config();
        timer=new Timer();
        timer.schedule(new Reloj(),0,1000);
    }
/**
 * Inner class que se utiliza para poder realizar os traballos cos fios.
 */
public class Reloj extends TimerTask{
    Toolkit al=Toolkit.getDefaultToolkit();
    /**
     * Metodo sobreescrito que executa en bucle as instruccions do reloxo.
     */
    @Override
    public void run(){
        Config.refresh();
        if(Config.compH()==true){
            al.beep();
            s=JOptionPane.showInputDialog("¿Retrasar alarma?\n        y/n.");
            if(s.equals("y")){
                if(!Display.isModoalarma()){
                    Display.cambiovista();
                    Config.incmin(5);
                    s="p";
                    Display.cambiovista();
                }else{
                    Config.incmin(5);
                    s="p";
                }
            }else{
                timer.cancel();
                timer.purge();
                System.out.println("Que teña un bo dia.");
                Config.sfinalizar(true);
            }
        }else{
            
            Display.visualizar();
            Config.sfinalizar(false);
        }
    }
}

}
