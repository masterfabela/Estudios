/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin29;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Boletin29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos m1=new Metodos();
        ArrayList<Barco> lista=new ArrayList();
        Barco d1= new DeporMotor(200,10,"ASD123");
        Barco v1= new Velerio(3,50,"QWE456");
        Barco y1= new Yate(3000,4,25,"ZXC789");
        lista.add(d1);
        lista.add(v1);
        lista.add(y1);
        //m1.facturaIndividual(y1,1, 20);
        m1.facturaTotal(lista, 1,2);
    }
    
}
