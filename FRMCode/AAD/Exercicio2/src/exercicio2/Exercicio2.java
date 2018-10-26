/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

import java.util.Scanner;

/**
 *
 * @author a18franciscorm
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector c1=new Conector();
        Scanner sc=new Scanner(System.in);
        c1.conectar();
        c1.estructurar();
        int opcion;
        do{
            c1.main_menu();
            opcion=0;
            opcion=sc.nextInt();
            switch(opcion){
                case 1:c1.insert_menu();
                break;
                case 2:c1.erese_menu();
                break;
                case 3:c1.query_menu();
                break;
                case 4:c1.update_menu();
                break;
                case 5:c1.pechar();
                break;
            }
        }while(opcion!=5);
        
    }
    
}
