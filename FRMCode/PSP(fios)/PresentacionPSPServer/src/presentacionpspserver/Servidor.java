/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionpspserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author a18franciscorm
 */
public class Servidor implements RMICalcInterface {

    public static void main(String[] args) {
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(5555);
            System.out.println("Registro creado.");
        } catch (Exception e) {
            System.out.println("Error en la creación del registro:");
            e.printStackTrace();
        }
        Servidor serverObject = new Servidor();
        try {
            reg.rebind("Calculadora", (RMICalcInterface) UnicastRemoteObject.exportObject(serverObject, 0));
            System.out.println("Registro inscrito.");
        } catch (Exception e) {
            System.out.println("Error en la inscripción del registro:");
            e.printStackTrace();
        }
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        int resultado = a + b;
        System.out.println("El resultado de la suma es: " + resultado);
        return resultado;
    }

    @Override
    public int resta(int a, int b) throws RemoteException {
        int resultado = a - b;
        System.out.println("El resultado de la resta es: " + resultado);
        return resultado;
    }

    @Override
    public int multip(int a, int b) throws RemoteException {
        int resultado = a * b;
        System.out.println("El resultado de la multiplicación es: " + resultado);
        return resultado;
    }

    @Override
    public int div(int a, int b) throws RemoteException {
        int resultado = a / b;
        System.out.println("El resultado de la división es: " + resultado);
        return resultado;
    }
}
