/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("libreria", "libreria.neo");

        server.startServer(true);
        int opcion = 0;
        do {
            System.out.println("MENU");
            System.out.println("1.- Cerrar Sesión");
            try {
                opcion = Integer.parseInt(entradaTeclado.readLine());
                switch (opcion) {
                case 1:
                    server.close();
                    break;
            }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } while (opcion != 0);
    }
    
}
