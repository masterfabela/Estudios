package exemploarraylist;

import java.util.*;
import javax.swing.JOptionPane;

public class Metodos {
    ArrayList <Integer> lista1=new ArrayList();
        
    public void creador(){
        for(int i=0;i<(Integer.parseInt(JOptionPane.showInputDialog("Cantos elementos desexa engadir?")));i++){
        //Xerar enteiros aleatorios.
        int v=(int)(1+Math.random()*10);
            lista1.add(v);
        }
    }
    public void engadir (int n){
        lista1.add(n);
    }
    public void borrarit (){
        Iterator it=lista1.iterator();
        while(it.hasNext())
            System.out.println("Vaise eliminar "+it.next());
        it.remove();
    }
    public void amosarit (){
        Iterator it=lista1.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    public void quitarposicion(int p){
        //usar p como contador para o for, e saltar as posicions con it.next .
        lista1.remove(p);
        
        
    }
    public void borrarelemento(int e){
        //borrar elemento, mediante a busca do mesmo.
        lista1.remove(e);
        
    }
    public void mudarposicio(int p, int v){
        lista1.set(p,v);
    }
    public void mudarelem(int e,int v){
        int aux=lista1.lastIndexOf(e);
        lista1.set(aux, v);
    }
    public void menmay(){
        
    }
}
