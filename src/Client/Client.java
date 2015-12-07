/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.ITest;
import fontys.observer.RemotePropertyListener;
import java.beans.PropertyChangeEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Kasper & Jeroen!
 */
public class Client extends Application implements RemotePropertyListener {

    private ITest test;
    
    //RMI:
    private static final int port = 1099;
    private static final String bindName = "Test";
    private Registry registry;
    //todo PAS DIT AAN
    private static final String ip = "169.254.161.102";
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException {
        System.out.println("Pressed Button: " );
    }
    
    
    public Client() throws RemoteException {
        
        
        try {
            registry = LocateRegistry.getRegistry(ip, port);
        } catch (RemoteException e) {
            System.out.println("Kan registry niet vinden: " + e.getMessage());
        }
        
        try {
            test = (ITest) registry.lookup(bindName);
        } catch (NotBoundException e) {
            System.out.println("Probleem bij het binden: " + e.getMessage());
        } catch (RemoteException e) {
            System.out.println("Probleem bij het binden: " + e.getMessage());
        }
        
        System.out.println(test.getText());
        
    }
    
    public static void main(String[] args) throws RemoteException 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
 
    }

}
