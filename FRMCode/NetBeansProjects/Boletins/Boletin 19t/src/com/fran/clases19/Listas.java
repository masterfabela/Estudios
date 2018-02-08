package com.fran.clases19;

import java.util.*;
import javax.swing.JOptionPane;

public class Listas {

    public ArrayList <Libro> li=new ArrayList();
    
    public void engadir()throws Nullexception{
        
        String tit=JOptionPane.showInputDialog("Introduza o titulo do novo libro:");
        String ref=JOptionPane.showInputDialog("Introduza o seu Isbn:");
        String aut=JOptionPane.showInputDialog("Introduza o seu autor:");
        float pre=Float.parseFloat(JOptionPane.showInputDialog("Introduza o prezo:"));
        int uds=Integer.parseInt(JOptionPane.showInputDialog("De cantas unidades se dispón:"));
        li.add(new Libro(tit,ref,aut,pre,uds));
        if(li.get(1)==null){
            throw new Nullexception("Devolto ArrayList null");
        }
    }
    public void vender(String r)throws Nullexception{
        int n=0;
        for(Libro l1:li){
            if(l1.isbn.equalsIgnoreCase(r)){
                n=li.lastIndexOf(l1);
                
            }
        }
        li.remove(n);
        if(li.get(1)==null){
            throw new Nullexception("Devolto ArrayList null");
        }
    }
    public void amosartodo()throws Nullexception{
        for(Libro l1:li){
            System.out.println("Titulo: "+l1.titulo+" Isbn: "+l1.isbn);
        }
        if(li.isEmpty()){
            throw new Nullexception("Devolto ArrayList null");
        }
    }
    public void amosar(String r)throws Nullexception{
        int n=0;
        for(Libro l1:li){
            if(l1.isbn.equalsIgnoreCase(r)){
                n=li.lastIndexOf(l1);
                
            }
        }
        System.out.println("Titulo: "+li.get(n).titulo+" Isbn: "+li.get(n).isbn+
                "\nAutor: "+li.get(n).autor+" Prezo: "+li.get(n).prezo+" Unidades dispoñibles:"+li.get(n).unidades);
        if(li.isEmpty()){
            throw new Nullexception("Devolto ArrayList null");
        }
    }
    public void baixas()throws Nullexception{
        int elim=0,fin=li.size();
        
        for(int i=0;i<fin;i++){
        if(li.get(i).unidades==0){
            li.remove(i);
            i=i-1;
            fin=fin-1;
            elim++;
        }
        }
        System.out.println("Deronse de baixa "+elim+" libros");
        if(li.get(1)==null){
            throw new Nullexception("Devolto ArrayList null");
        }
    }
        public void baixas2(){
            Iterator it=li.iterator();
            while(it.hasNext()){
                Libro aux=(Libro)it.next();
                if(aux.unidades==0){
                    it.remove();
                }
            }
        }
    public void borrartodo(){
        li.removeAll(li);
        
    }
}
