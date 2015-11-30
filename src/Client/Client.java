/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import fontys.observer.RemotePropertyListener;
import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Kasper & Jeroen!
 */
public class Client implements RemotePropertyListener {

    
    //RMI:
    private static final int port = 1099;
    private static final String bindName = "Test";
    private Registry registry;
    //todo PAS DIT AAN
    private static final String ip = "192.168.2.11";
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException {
        System.out.println("Pressed Button: " );
    }
    
    
    public Client() {
        try {
            registry = LocateRegistry.getRegistry(ip, port);
        } catch (RemoteException e) {
            System.out.println("Kan registry niet vinden: " + e.getMessage());
        }
        
        System.out.println();
    }

}
