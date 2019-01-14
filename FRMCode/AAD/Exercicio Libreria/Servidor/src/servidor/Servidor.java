/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.util.Scanner;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author femio23
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("libreria", "libreria.neo");
        server.startServer(true);
        byte opcion = 0;
        do {
            System.out.println("MENU\n"
                    + "1.- Cerrar Sesión");
            opcion = sc.nextByte();
            switch (opcion) {
                case 1: server.close();
                break;
                default:opcion=0;
                break;
            }
        } while (opcion != 1);
    }
}