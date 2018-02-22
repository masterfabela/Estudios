package boletin20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Metodos {
        Scanner sc;
        File fich;
        Libro l1;
    public void importar(ArrayList l, String d){
        fich=new File(d);
        try{
            sc=new Scanner(fich).useDelimiter(",\\s*");
            while(sc.hasNext()){
                l1=new Libro(sc.next(),sc.next(),Float.parseFloat(sc.next()),Integer.parseInt(sc.next()));
                l.add(l1);
            }
        }
        catch(FileNotFoundException fnfe1){
            System.out.println("Erro:"+fnfe1.getMessage());
        }
        finally{
            sc.close();
        }
    }
    public void existe(String d){
        File fich=new File(d);
        System.out.println(fich.exists());
    }
    public void visualizar(ArrayList l){
        for(Object l2:l){
                System.out.println(l2.toString());
            }
    }
    public void engadir(ArrayList l){
        String a,t;
        int c;
        float p;
        JOptionPane.showMessageDialog(null,"Introduza os datos do Libro a engadir.");
        t=JOptionPane.showInputDialog("Titulo do libro.");
        a=JOptionPane.showInputDialog("Autor do libro.");
        p=Float.parseFloat(JOptionPane.showInputDialog("Prezo de venta do libro."));
        c=Integer.parseInt(JOptionPane.showInputDialog("Cantidade de exemplares a engadir."));
        l.add(new Libro(t,a,p,c));
    }
    public void consultar(String t, ArrayList l){
        int cont=0;
        System.out.println(t);
        for(int i=0;i<l.size();i++){
            Libro l1=(Libro)l.get(i);
            if(l1.getTitulo().equalsIgnoreCase(t)){
                System.out.println("O prezo de "+l1.getTitulo()+" = "+l1.getPrezo()+" €.");
                cont++;
            }
        }
        if(cont==0){
                System.out.println("O libro consultado non se atopa na base de datos.");
            }
    }
    public void visualizafich(String d){
        fich=new File(d);
        try{
            sc=new Scanner(fich);
            
            }
            catch(FileNotFoundException fnfe2){
                System.out.println("Erro: "+fnfe2.getMessage());
            }
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
    public void borrar(ArrayList l){
        Libro l1;
        for(int i=0;i<l.size();i++){
            l1=(Libro)l.get(i);
            if(l1.getUnidades()==0){
                l.remove(i);
                
            }
        }
    }
    public void modificar(ArrayList l, String t){
        Libro l1;
        for(int i=0;i<l.size();i++){
            l1=(Libro)l.get(i);
            if(l1.getTitulo().equalsIgnoreCase(t)){
                String a,ti;
                int c;
                float p;
                l.remove(i);
                JOptionPane.showMessageDialog(null,"Introduza novos datos do Libro a modificar.");
                t=JOptionPane.showInputDialog("Titulo do libro.");
                a=JOptionPane.showInputDialog("Autor do libro.");
                p=Float.parseFloat(JOptionPane.showInputDialog("Prezo de venta do libro."));
                c=Integer.parseInt(JOptionPane.showInputDialog("Cantidade de exemplares a engadir."));
                l.add(new Libro(t,a,p,c));
            }
        }
    }
    public void volcado(ArrayList l,String d){
        PrintWriter escribir=null;
        fich=new File(d);
        Libro l1;
        try{
            escribir=new PrintWriter(fich);
            for(int i=0;i<l.size();i++){
                l1=(Libro)l.get(i);
            escribir.println(l1.getTitulo()+","+l1.getAutor()+","+l1.getPrezo()+","+l1.getUnidades()+",");
            }
            }
        catch(FileNotFoundException fnfe2){
            System.out.println("Erro: "+fnfe2.getMessage());
        }
        finally{
        escribir.close();
        }
    }
}
