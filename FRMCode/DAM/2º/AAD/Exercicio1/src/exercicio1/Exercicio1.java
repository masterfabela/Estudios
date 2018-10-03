/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector c1=new Conector();
        CreaTaboas ct1=new CreaTaboas();
        Scanner sc=new Scanner(System.in);
        int opcion=0,opcionEngadido=0,opcionBorrado=0;
        do{
            System.out.println("Menú:\n"
                + "1-Inicio da BD.\n"
                + "2-Engadir filas.\n"
                + "3-Borrado de filas.\n"
                + "4-Modificacions.\n"
                + "5-Consultas.\n"
                + "6-Fin.");
        opcion=sc.nextInt();
        switch(opcion){
                case 0:opcion=sc.nextInt();
                break;
                
                case 1:c1.conectar();
                ct1.estructurar(c1.conect);
                break;
                
                 case 2:
                     do{
                         
                     System.out.println("Engadir:\n"
                + "1-Libro.\n"
                + "2-Autor.\n");
                     opcionEngadido=sc.nextInt();
                 switch(opcionEngadido){
                     case 1:c1.engadirLibro(sc);
                     break;
                     case 2:c1.engadirAutor(sc);
                     break;
                     default:opcionEngadido=0;
                         System.out.println("Engada un valor válido:");
                         break;
                 }
                     }while(opcionEngadido==0);  
                break;
                
                case 3:do{
                     System.out.println("Eliminar:\n"
                + "1-Libro.\n"
                + "2-Autor.\n");
                     opcionBorrado=sc.nextInt();
                 switch(opcionBorrado){
                     case 1:c1.ereseLibro(sc);
                     break;
                     case 2:c1.ereseAutor(sc);
                     break;
                     default:opcionBorrado=0;
                         System.out.println("Engada un valor válido:");
                         break;
                 }
                     }while(opcionBorrado==0);
                     
                     
                break;
                
                case 4:c1.modificar(sc);
                break;
                
                case 5:
                    System.out.println("Consultas:\n"
                + "1-Ver autor/es de un libro.\n"
                + "2-Ver libros de un autor.\n"
                + "3-Ver tódolos libros.\n"
                + "4-Ver todolos autores, xunto cos seus libros");
                    int x=sc.nextInt();
                  c1.consultar(sc,x);
                    
                break;
                case 6:c1.pechar();
                break;
        }
        }while(opcion!=6);
        
        
    }
    
}
