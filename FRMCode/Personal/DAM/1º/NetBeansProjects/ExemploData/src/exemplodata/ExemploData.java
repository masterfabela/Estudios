/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplodata;

/**
 *
 * @author femio23
 */
public class ExemploData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TraballadorDate td1=new TraballadorDate();
        ClaseTime ct1=new ClaseTime();
//        td1.inicializar();
//        System.out.println(td1.listrab.get(0).dataAlta);
//        td1.tempoAlta();
//        td1.antiguidade();
        ct1.inicializar();
        System.out.println(ct1.listrab.get(0).dataAlta);
        ct1.tempoAlta();
        ct1.antiguidade();
        
    }
    
}
