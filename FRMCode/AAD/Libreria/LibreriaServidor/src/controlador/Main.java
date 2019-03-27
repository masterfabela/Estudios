package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a14damianld
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
        ODBServer server = ODBFactory.openServer(8000);
        server.addBase("libreria", "libreria.neo");

        server.startServer(true);
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1.- Cerrar Sesión");
            opcion = Integer.parseInt(entradaTeclado.readLine());
            switch (opcion) {
                case 1:
                    server.close();
                    break;
            }

        } while (opcion != 0);

    }

}
