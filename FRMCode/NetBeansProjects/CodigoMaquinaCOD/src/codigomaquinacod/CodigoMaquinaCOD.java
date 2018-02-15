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
public class CodigoMaquinaCOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Productos[] prod=new Productos[3];
        prod[0]=new Productos("Chocolate",1.50f);
        prod[1]=new Productos("Café",2.50f);
        prod[2]=new Productos("Té",0.90f);
    }
    
}
