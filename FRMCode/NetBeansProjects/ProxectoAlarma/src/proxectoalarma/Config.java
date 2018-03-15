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
    private static boolean end=false;
 /**
  * Constructor da clase, que se encarga de inicializar tanto a hora, como a hora de alarma, á cal lle engade un minuto, para evitar que coincidan o principio.
  */
    public Config() {
        hora=new Date();
        halarma=new Date();
        halarma.setMinutes(halarma.getMinutes()+1);
    }
    /**
     * Este método encargase de facer avanzar a hora.
     */
    public static void refresh(){
        hora.setSeconds(hora.getSeconds()+1);
    }
    /**
     * Este metodo incrementa o campo hora, tanto da hora actual como da alarma.
     * @param n Este parámetro indica o numero de unidades que se ha de aumentar.
     */
    public static void inchora(int n){
        if(!Display.isModoalarma()){
             if(hora.getHours()+n>=24){
                int aux=24-(hora.getHours()+n);
                hora.setHours(aux);
            }else{

            hora.setHours(hora.getHours()+n);
            }
        }else{
            if(halarma.getHours()+n>=24){
                int aux=24-(halarma.getHours()+n);
                halarma.setHours(aux);
            }else{

            halarma.setHours(halarma.getHours()+n);

            }
        }
    }
     /**
     * Este metodo incrementa o campo minutos, tanto da hora actual como da alarma.
     * @param n Este parámetro indica o numero de unidades que se ha de aumentar.
     */
    public static void incmin(int n){
         if(!Display.isModoalarma()){
             if(hora.getMinutes()+n>=60){
                int aux=60-(hora.getMinutes()+n);
                hora.setMinutes(aux);
            }else{
            hora.setMinutes(hora.getMinutes()+n);
            }
         }else{
            if(halarma.getMinutes()+n>=60){
                int aux=60-(halarma.getMinutes()+n);
                halarma.setMinutes(aux);
            }else{
            halarma.setMinutes(halarma.getMinutes()+n);
            }
         }
    }
    /**
     * Este metodo ocupase de comparar a hora actual e a de alarma, e se coinciden, face saltar a alarma.
     * @return Devolve un true se coinciden ambas horas, en caso contrario, devolve false.
     */
    public static boolean compH(){
        boolean toca=false;
        if(hora.getHours()==halarma.getHours()&&hora.getMinutes()==halarma.getMinutes()){
            toca=true;
        }
        return toca;
    }
    /**
     * Este método comproba o valor de end, para así finalizar a execución do TimerTask, se se devolve true.
     * @return devolve o valor de end.
     */
    public static boolean fin(){
        return end;
    }
    /**
     * Este metodo ocupase de dar valor a variable end.
     * @param n Se se introduce true, fará saltar a alarma.
     */
    public static void sfinalizar(boolean n){
        end=n;
    }
}
