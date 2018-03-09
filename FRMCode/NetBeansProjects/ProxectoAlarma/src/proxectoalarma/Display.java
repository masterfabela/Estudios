/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectoalarma;

/**
 *
 * @author femio23
 */
public class Display {
    static int vista;

    public Display() {
        this.vista =0;
    }
    
    public static void showhora(){
        System.out.println("Hora actual "+Config.hora.getHours()+":"+Config.hora.getMinutes()+":"+Config.hora.getSeconds());
    }
    public static void showhalarma(){
        System.out.println("Alarma actual "+Config.halarma.getHours()+":"+Config.halarma.getMinutes()+":"+Config.halarma.getSeconds());
    }
    public static void cambiovista(){
        if(vista==0){
            vista=1;
        }else{
            vista=0;
        }
    }
    public static void visualizar(){
        if(vista==0){
            showhora();
        }else{
            showhalarma();
        }
    }
}
