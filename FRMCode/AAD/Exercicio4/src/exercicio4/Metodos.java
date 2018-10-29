package exercicio4;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a18franciscorm
 */
public class Metodos {
    Scanner sc=new Scanner(System.in);
    public byte menuPrincipal(){
        byte opcion;
        System.out.println("----Menu principal:----"
                + "1-Conectar.\n"
                + "2-Insertar filas.\n"
                + "3-Borrado de filas.\n"
                + "4-Modificación de filas.\n"
                + "5-Consultas.\n"
                + "6-Fin");
        opcion=sc.nextByte();
        if(opcion>=1 && opcion<=6)
            return opcion;
        else
            return 0;
    }
}
