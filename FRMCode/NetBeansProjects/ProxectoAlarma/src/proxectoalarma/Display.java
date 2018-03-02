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
    int vista;

    public Display() {
        this.vista =0;
    }
    
    public void showhora(Config c){
        System.out.println("Hora actual "+c.hora.getHours()+":"+c.hora.getMinutes()+":"+c.hora.getSeconds());
    }
    public void showhalarma(Config c){
        System.out.println("Alarma actual "+c.halarma.getHours()+":"+c.halarma.getMinutes()+":"+c.halarma.getSeconds());
    }
    public void cambiovista(){
        if(vista==0){
            vista=1;
        }else{
            vista=0;
        }
    }
    public void visualizar(Config c){
        if(vista==0){
            showhora(c);
        }else{
            showhalarma(c);
        }
    }
}
