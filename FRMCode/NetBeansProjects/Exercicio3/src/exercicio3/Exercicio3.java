/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import java.util.Scanner;

/**
 *
 * @author Femio
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Conector c1=new Conector();
        int opcion=0;
        while(opcion!=6){
        System.out.println("========MENU========\n"
                + "1-Creación Y/O Conexion\n"
                + "2-Altas\n"
                + "3-Baixas\n"
                + "4-Modificacións\n"
                + "5-Consultas\n"
                + "6-Fin\n");
        opcion=sc.nextInt();
        switch(opcion){
            case 1:
                c1.conectar();
                c1.crearBD();
            ;
            break;
            
            case 2:
                c1.altas();
                ;
            break;
            
            case 3:
                c1.baixas();
                ;
            break;
            
            case 4:
                c1.modificacions();
                ;
            break;
            
            case 5:
                c1.consultas();
                ;
            break;
            case 6:
                c1.pechar();
                ;
            break;
        }
        }
        /*
        Profesores y alumnos tienen una relación de varios a varios.
        Alumnos y asignaturas tienen una relación varioa a varios.
        Profesores y asignaturas tienen una relación varios a varios.
        Alumnos y notas tienen una relación uno a varios.*/
    }
    
}
