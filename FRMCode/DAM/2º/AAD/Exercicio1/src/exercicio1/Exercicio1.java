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
        System.out.println("Menú:"
                + "1-Inicio da BD.\n"
                + "2-Engadir filas.\n"
                + "3-Borrado de filas.\n"
                + "4-Modificacions.\n"
                + "5-Consultas.\n"
                + "6-Fin.");
        int opcion=0;
        
        do{
        opcion=sc.nextInt();
        switch(opcion){
                case 0:opcion=sc.nextInt();
                break;
                case 1:c1.conectar();
                ct1.estructurar(c1.conect);
                break;
                case 6:c1.pechar();
                break;
        }
        }while(opcion!=6);
        
        
    }
    
}
