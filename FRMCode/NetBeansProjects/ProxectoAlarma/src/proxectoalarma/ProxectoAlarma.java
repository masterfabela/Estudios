/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectoalarma;

import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author femio23
 */
public class ProxectoAlarma {
    Timer timer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PanelAlarma pa1=new PanelAlarma();

        
        new ProxectoAlarma();
        
        
        
        
        
    }
 

        public ProxectoAlarma() {
            ProgramaAlarma pa1=new ProgramaAlarma();
            Timer timer=new Timer();
            timer.schedule(new ProgramaAlarma(),0,1000);
        }
    
    
    
    
    public class ProgramaAlarma extends TimerTask{
        Date hora,horad;

        public Date getHora() {
            return hora;
        }

        public void setHora(Date hora) {
            this.hora = hora;
        }

        public Date getHorad() {
            return horad;
        }

        public void setHorad(Date horad) {
            this.horad = horad;
        }

        public ProgramaAlarma(Date horad) {
            this.horad = horad;
        }

        public ProgramaAlarma() {
        }


        @Override
        public void run(){
            SimpleDateFormat formato=new SimpleDateFormat("hh:mm:ss");
            hora=new Date();
            try {
                Date a=formato.parse("Thu Jan 01 10:07:30 CET 1970");
                horad=formato.format(a);
            } catch (ParseException ex) {
                Logger.getLogger(ProxectoAlarma.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(hora==horad){
                System.out.println("Despertaaaa.");
                Toolkit son=Toolkit.getDefaultToolkit();
                son.beep();
                timer.cancel();
                timer.purge();
            }else{
                System.out.println("Son as "+formato.format(hora)+", toca ás "+horad+".");
            }
        }
    }
}

