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

    final private BufferedReader br;
    private int lonxitude = 0;
    private String iniciais = "";
    LinkedList<Linea> ll;
    Comparator c=(Comparator<Linea>) (Linea o1, Linea o2) -> o1.getIniciais().compareTo(o2.getIniciais());

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
                wait();
                gardado(cadea,iniciais,lonxitude);
            }
        } catch (IOException ioe1) {
            ioe1.getMessage();
        }
        catch (InterruptedException ioe1) {
            ioe1.getMessage();
        }
         
    }
    public synchronized void gardado(String cadea,String iniciais,int lonxude){
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).getCadea().equals(cadea)){
               ll.get(i).setCantidade(ll.get(i).getCantidade()+1);
           }else{
               ll.add(new Linea(iniciais,cadea,lonxude,1));
               ll.sort(c);
           }
        }
        notify();
        }
    
    public FioLector(BufferedReader br, LinkedList ll) {
        this.br = br;
        this.ll = ll;
    }

}
