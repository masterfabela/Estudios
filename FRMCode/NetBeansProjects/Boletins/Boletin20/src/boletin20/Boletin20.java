package boletin20;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Boletin20 {

    public static void main(String[] args) {
        Metodos m1=new Metodos();
        Libro l1=new Libro();
        ArrayList <Libro> libreria=new ArrayList();
        boolean repetir=true;
        while(repetir){
            m1.existe("Libreria.txt");
            m1.importar(libreria,"Libreria.txt");
            int menu=Integer.parseInt(JOptionPane.showInputDialog("Menú de opcions:\n"+
                    "engadir→1\n"+"consultar→2\n"+"visualizar→3\n"+"borrar→4\n"+"modificar→5\n"+"imprimir titulos→6"));
            switch(menu){
                case 1:m1.engadir(libreria);
                break;
                case 2:m1.consultar(JOptionPane.showInputDialog("Titulo do libro a consultar."),libreria);
                break;
                case 3:m1.visualizafich("Libreria.txt");
                break;
                case 4:m1.borrar(libreria);
                break;
                case 5:m1.modificar(libreria,JOptionPane.showInputDialog("Titulo do libro a modificar."));
                break;
                case 6:m1.volcartitulo("Libreria.txt",JOptionPane.showInputDialog("Introduza o autor do que desexa imprimir os seus libros."));
                break;
                default:System.out.println("Opcion non valida.");
                break;
            }
            m1.volcado(libreria,"Libreria.txt");
            String mem=(JOptionPane.showInputDialog("Desexa volver a empezar?\nS/N."));
            if(mem.equalsIgnoreCase("S")){
                repetir=true;
            }else{
                repetir=false;
            }
        }
        System.out.println("Adeus");
    }
        
}
    

