/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas;

import BD.Creador;


/**
 *
 * @author femio23
 */
public class Empresas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creador.creaTaboas();
        Vista.menuPrincipal();
        
    }
    
}
