/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectoalarma;

import java.util.Date;

/**
 *
 * @author femio23
 */
public class Config {
    Date hora;
    Date halarma;

    public Config() {
        hora=new Date();
        halarma=new Date();
    }
    
    public void inchora(){
        halarma.setHours(halarma.getHours()+1);
        System.out.println(halarma);
    }
    
    public void incmin(){
        halarma.setMinutes(halarma.getMinutes()+1);
        System.out.println(halarma);
    }
    
    public boolean compH(){
        boolean toca=false;
        
        return toca;
    }
}
