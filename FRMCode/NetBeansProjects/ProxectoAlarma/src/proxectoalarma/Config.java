/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectoalarma;

import java.awt.Toolkit;
import java.util.Date;

/**
 *
 * @author femio23
 */
public class Config {
    static Date hora;
    static Date halarma;
    Toolkit toolkit=Toolkit.getDefaultToolkit();

    public Config() {
        hora=new Date();
        halarma=new Date();
    }
    public static void refresh(){
        hora=new Date();
    }
    public static void inchora(){
        halarma.setHours(halarma.getHours()+1);
        System.out.println(halarma);
    }
    
    public static void incmin(){
        halarma.setMinutes(halarma.getMinutes()+1);
        System.out.println(halarma);
    }
    
    public static boolean compH(){
        boolean toca=false;
        if(hora.getHours()==halarma.getHours()&&hora.getMinutes()==halarma.getMinutes()){
            toca=true;
        }
        return toca;
    }
}
