/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionpspserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author a18franciscorm
 */
public interface RMICalcInterface extends Remote{
    public int suma(int a, int b)throws RemoteException;
    public int resta(int a, int b)throws RemoteException;
    public int multip(int a, int b)throws RemoteException;
    public int div(int a, int b)throws RemoteException;
}
