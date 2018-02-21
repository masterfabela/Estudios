package boletin20;

import java.util.ArrayList;


public class Boletin20 {

    public static void main(String[] args) {
        Metodos m1=new Metodos();
        Libro l1=new Libro();
        ArrayList <Libro> libreria=new ArrayList();
        m1.existe("Libreria.txt");
        m1.importar(libreria,"Libreria.txt");
        
    }
    
}
