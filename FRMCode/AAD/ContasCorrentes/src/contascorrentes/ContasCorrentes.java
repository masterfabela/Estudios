/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contascorrentes;
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
        ODBServer odb=server.encenderServer();
        
        server.pecharServer(odb);
    }
    
}
