package com.fran.clases19;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Listas {

    public ArrayList <Libro> li=new ArrayList();
    
    public void engadir(){
        
        String tit=JOptionPane.showInputDialog("Introduza o titulo do novo libro:");
        String ref=JOptionPane.showInputDialog("Introduza o seu Isbn:");
        String aut=JOptionPane.showInputDialog("Introduza o seu autor:");
        float pre=Float.parseFloat(JOptionPane.showInputDialog("Introduza o prezo:"));
        int uds=Integer.parseInt(JOptionPane.showInputDialog("De cantas unidades se dispón:"));
        li.add(new Libro(tit,ref,aut,pre,uds));
//        if(li.get(1)==null){
//            throw new Nullexception("Devolto ArrayList null");
//        }
    }
    public void vender(String r){
        int n=0;
        for(Libro l1:li){
            if(l1.isbn.equalsIgnoreCase(r)){
                n=li.lastIndexOf(l1);
                
            }
        }
        li.remove(n);
//        if(li.get(1)==null){
//            throw new Nullexception("Devolto ArrayList null");
//        }
    }
    public void amosartodo(){
        for(Libro l1:li){
            System.out.println("Titulo: "+l1.titulo+" Isbn: "+l1.isbn);
        }
//        if(li.get(1)==null){
//            throw new Nullexception("Devolto ArrayList null");
//        }
    }
    public void amosar(String r){
        int n=0;
        for(Libro l1:li){
            if(l1.isbn.equalsIgnoreCase(r)){
                n=li.lastIndexOf(l1);
                
            }
        }
        System.out.println("Titulo: "+li.get(n).titulo+" Isbn: "+li.get(n).isbn+
                "\nAutor: "+li.get(n).autor+" Prezo: "+li.get(n).prezo+" Unidades dispoñibles:"+li.get(n).unidades);
//        if(li.get(1)==null){
//            throw new Nullexception("Devolto ArrayList null");
//        }
    }
    public void baixas(){
        int elim=0;
        for(Libro l1:li){
        if(l1.unidades==0){//o iterator, polo problema de sustitución
            li.remove(l1);
            elim++;
            System.out.println(l1.isbn);
        }
        }
        System.out.println("Deronse de baixa "+elim+" libros");
//        if(li.get(1)==null){
//            throw new Nullexception("Devolto ArrayList null");
//        }
    }
    public void borrartodo(){
        for(Libro l1:li){
            li.remove(l1);
        }
    }
}
