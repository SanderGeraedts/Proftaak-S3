/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.Remote;

/**
 *
 * @author Jeroen0606
 */
public interface ILobbyController extends Remote {
    public void startGame();
    
    public int getUserID();
    
    public boolean getReady();
}
