/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import fontys.observer.BasicPublisher;
import fontys.observer.RemotePropertyListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Jeroen0606
 */
public class Test extends UnicastRemoteObject implements ITest{
    private BasicPublisher publisher;    
    
    public Test() throws RemoteException{
               
    }
    
    
    public void addListener(RemotePropertyListener RPL, String property) {
        publisher.addListener(RPL, property);
    }    

    @Override
    public String getText() throws RemoteException {
        return "HOI KASPÈR!!";
    }
}
