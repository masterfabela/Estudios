/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes;
import contascorrentes.modelo.Metodos.*;
import contascorrentes.vista.*;
import java.util.Scanner;
import servidor.controlador.Server;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a18franciscorm
 */
public class ContasCorrentes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server=new Server();
        server.start();
        Vista v=new Vista();
        Altas a1=new Altas();
        ODBServer s=server.encenderServer();
        byte opcion=0;
        Scanner sc=new Scanner(System.in);
        while(opcion!=11){
            v.menuPrincipal();
            opcion=sc.nextByte();
            switch(opcion){
                case 1:a1.altaCCorrente();
                break;
                case 2:a1.altaCPrazo();
                break;
                case 3:a1.altaMovemento();
                break;
                case 4:a1.test();
                break;
                case 5:;
                break;
                case 6:;
                break;
                case 7:;
                break;
                case 8:;
                break;
                case 9:;
                break;
                case 10:;
                break;
                default:
                    if(opcion==11)
                        System.out.println("Adeus");
                    else
                        System.out.println("\n\nErro de entrada(1-11)\n\n\n");
                break;
            }
        }
        server.pechar(s);
        
    }
    
}
