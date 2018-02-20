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
public class Dinero {
    private float crédito=0,cambio=0;

    public float getCrédito() {
        return crédito;
    }

    public void setCrédito(float crédito) {
        this.crédito = crédito;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
    
    public float introducirmonedas(float p){
        float aux=0;
        aux=Float.parseFloat(JOptionPane.showInputDialog("Precio: "+p+"\nIntroduzca crédito:"));
        return aux;
    }
    public float calcularcambio(Productos p, Dinero d){
        float aux=0;
        aux=d.getCrédito()-p.getPrelegido();
        d.setCambio(aux);
        return aux;
    }
    public boolean comprobarcredito(Dinero d,Productos p){
        boolean aux=false;
        if(d.crédito>=p.getPrelegido()){
        aux=true;
        }
       return aux; 
    }
    public void devolvercambio(Dinero d){
        float aux=d.getCambio()+0.01f;
        int u=(int)aux/1;
        aux=aux%1;
        int c=(int)(aux/0.5f);
        aux=aux%0.5f;
        int v=(int)(aux/0.2f);
        aux=aux%0.2f;
        int di=(int)(aux/0.1f);
        System.out.println("Se devuelve:\n"+
                        u+" Monedas de 1€,\n"+
                        c+" Moneda de 0.5€,\n"+
                        v+" Monedas de 0.2€,\n"+
                        di+" Monedas de 0.1€.\n");
    }
}
