/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author a18franciscorm
 */
public class FioLector extends Thread {

    private BufferedReader br;
    private int lonxitude = 0;
    private String iniciais = "";
    LinkedList ll;
    Comparator c=new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    @Override
    public void run() {
        try {
            while (br.ready()) {
                iniciais = "";
                lonxitude = 0;
                String cadea=br.readLine();
                String[] fraccion = cadea.split(" ");
                for (String d1 : fraccion) {
                    iniciais += d1.charAt(0);
                    lonxitude += d1.length();
                }
                gardado(cadea,iniciais,lonxitude);
            }
        } catch (IOException ioe1) {
            ioe1.getMessage();
        }
    }
    public synchronized void gardado(String cadea,String iniciais,double lonxude){
        String l1=" ";
        byte repeticion=1;
        l1=iniciais+" "+String.valueOf(lonxitude)+" "+cadea+" "+repeticion;
        if(ll.contains(l1)){
            int index=ll.indexOf(l1);
            repeticion++;
            ll.remove(index);
            l1=iniciais+" "+String.valueOf(lonxitude)+" "+cadea+" "+repeticion;
            ll.add(l1);
        }else{
            ll.add(l1);
        }
        System.out.println(l1);
        ll.sort(c);
    }
    public FioLector(BufferedReader br, LinkedList ll) {
        this.br = br;
        this.ll = ll;
    }

}
