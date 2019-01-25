/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

/**
 *
 * @author a18franciscorm
 */
public class FioLector extends Thread{
    private String cadea;
    private int lonxitude;
    private String iniciais="";
    
    public void run(){
        lonxitude=cadea.length();
        String[] division=cadea.split(" ");
        for(String d1:division){
            iniciais+=d1.charAt(0);
        }
        System.out.println("A liña mide: "+lonxitude+", coas iniciais:"+iniciais);
    }

    public FioLector(String cadea) {
        this.cadea = cadea;
        run();
    }

    public FioLector(String cadea, Runnable target) {
        super(target);
        this.cadea = cadea;
    }
    
}
