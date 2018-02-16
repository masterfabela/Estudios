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
public class CodigoMaquinaCOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Botonera b1=new Botonera();
        Productos p1=new Productos();

        Cafetera c1=new Cafetera();
        Dinero d1=new Dinero();
        Display dp1=new Display();
        
        float aux=0;
        Productos[] prod=new Productos[3];
        prod[0]=new Productos("Chocolate",1.50f);
        prod[1]=new Productos("Café",0.90f);
        prod[2]=new Productos("Té",0.80f);
        
        p1.setPelegido(b1.elegirbebida(prod));
        p1.setPrelegido(dp1.mostrarprecio(prod,p1.getPelegido()));
        while(d1.comprobarcredito(d1,p1)==false){ 
        aux=d1.introducirmonedas();
        d1.setCrédito(d1.getCrédito()+aux);
        dp1.mostrarcredito(d1);
        }
        System.out.println("Suficiente");
        
        JOptionPane.showMessageDialog(null,"Elija la cantidad de azucar.");
        boolean suf=false;
        while(suf==false){
        int mem=Integer.parseInt(JOptionPane.showInputDialog("Azucar = "+c1.getCantazucar()+"\nMais=2\nMenos=1\nSuficiente=0"));
        switch (mem){
        case(1):b1.azless(c1);
        break;
        case(2):b1.azplus(c1);
        break;
        case(0):
            if(b1.comprobar(c1)){
            suf=true;
            }
        break;
        default:
            if(b1.comprobar(c1)){
            suf=true;
            }
        break;
        }
        }
        
        c1.soltarvaso();
        c1.elaborarbebida(p1);
        c1.soltarpalo();
        d1.calcularcambio(p1, d1);
        dp1.mostrarcambio(d1);
        d1.devolvercambio(d1);
        
        
    }
    
    
}
