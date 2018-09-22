/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomaquinacod;

/**
 *
 * @author femio23
 */
public class Cafetera {
    private int cantazucar=5;
    public void soltarvaso(){
        System.out.println("Plock, cae el vaso");
    }
    public void elaborarbebida(Productos p){
        System.out.println("Bssss, sale "+p.getPelegido()+" con "+cantazucar+"/10 azucar.");
        
    }
    public void soltarpalo(){
        System.out.println("Click, cae el palo.");
    }

    public int getCantazucar() {
        return cantazucar;
    }

    public void setCantazucar(int cantazucar) {
        this.cantazucar = cantazucar;
    }
    
}
