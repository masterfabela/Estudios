/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes;
import contascorrentes.modelo.Metodos.*;
import contascorrentes.vista.*;
import java.sql.Date;
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
        Baixas b1=new Baixas();
        Consultas c1= new Consultas();
        Modificacions m1=new Modificacions();
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
                case 4:m1.modificarInterese();
                break;
                case 5:b1.baixaCPrazo();
                break;
                case 6:c1.buscaC();
                break;
                case 7:c1.clienteSaldo();
                break;
                case 8:c1.clienteNumerosVermellos();
                break;
                case 9:c1.mediaSaldo();
                break;
                case 10:c1.consultaMovementos();
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
