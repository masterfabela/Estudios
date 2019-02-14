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
    Escritor esc=new Escritor();

    @Override
    public void run() {
        try {
            String cadea=br.readLine();
            while (!cadea.equalsIgnoreCase(null)){
                iniciais = "";
                lonxitude = 0;
                String[] fraccion = cadea.split(" ");
                for (String d1 : fraccion) {
                    iniciais += d1.charAt(0);
                    lonxitude += d1.length();
                }
                Linea test=new Linea(iniciais,cadea,lonxitude);
                esc.gardado(test,ll);
                cadea=br.readLine();
            }
            br.close();
        } catch (IOException ioe1) {
            ioe1.getMessage();
        }
        
    }
    public FioLector(BufferedReader br, LinkedList ll) {
        this.br = br;
        this.ll = ll;
    }

}
