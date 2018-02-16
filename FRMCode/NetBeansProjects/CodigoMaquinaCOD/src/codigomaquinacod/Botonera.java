/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomaquinacod;

import javax.swing.JOptionPane;

/**
 *
 * @author femio23
 */
public class Botonera {
    public void azplus(Cafetera c){
        c.setCantazucar(c.getCantazucar()+1);
    }
    public void azless(Cafetera c){
        c.setCantazucar(c.getCantazucar()-1);
    }
    public boolean comprobar(Cafetera c){
        if(c.getCantazucar()>10||c.getCantazucar()<0){
            c.setCantazucar(5);
            return false;
        }
        return true;
    }
    public String elegirbebida(Productos[]menu){
        String elexido=JOptionPane.showInputDialog(null, "Opcions:"+"\n"+menu[0].getProducto()+
        "\n"+menu[1].getProducto()+"\n"+menu[2].getProducto()+"\nIntroduza o nome da bebida elixida.");
        return elexido;
    }
}
