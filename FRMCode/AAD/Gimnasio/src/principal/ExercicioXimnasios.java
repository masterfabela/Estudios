/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Cliente.controlador.Altas;
import Cliente.controlador.Consultas;
import Server.controlador.Controlador;
import Server.vista.Vista;
import java.util.Scanner;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a18franciscorm
 */
public class ExercicioXimnasios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador c1=new Controlador();
        Vista v=new Vista();
        Scanner sc=new Scanner(System.in);
        Altas a1=new Altas();
        c1.start();
        Consultas c=new Consultas();
        byte opcion=0;
        while(opcion!=10){
            v.menuPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:a1.altaXimnasio();
                break;
                case 2:a1.altaActividades();
                break;
                case 3:a1.altaSocio();
                break;
                case 4:a1.altaUsos();
                break;
                case 5:;
                break;
                case 6:;
                break;
                case 7:;
                break;
                case 8:c.consultarCliente();
                break;
                case 9:;
                break;
                default:
                    if(opcion==10)
                        System.out.println("Adeus");
                    else
                        System.out.println("\n\nErro de entrada(1-10)\n\n\n");
                break;
            }
        }
        c1.pechar();
    }
    
}
