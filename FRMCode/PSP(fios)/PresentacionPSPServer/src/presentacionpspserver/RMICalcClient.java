package presentacionpspserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 *
 * @author a16cristiancc
 */
public class RMICalcClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RMICalcInterface calc = null;
        try {
            System.out.println("Localizando registro de objetos remotos...");
            Registry registry = LocateRegistry.getRegistry("localhost", 5555);
            System.out.println("Obteniendo el stub del objeto remoto...");
            calc = (RMICalcInterface)registry.lookup("Calculadora");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (calc != null) {
            System.out.println("Realizando operaciones con el objeto remoto...");
            try {
                System.out.println("2 + 2 =" + calc.suma(2, 2));
                System.out.println("99 - 45 =" + calc.resta(99, 45));
                System.out.println("125 * 3 =" + calc.multip(125, 3));
                System.out.println("1250 / 5 =" + calc.div(1250, 5));
            } catch (RemoteException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Terminado");
        }
    }

}
