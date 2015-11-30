package fontys.observer;

import java.rmi.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: Fontys Hogeschool ICT</p>
 *
 * @author Frank Peeters
 * @version 1.3
 *
 * de methode removeAllListeners verwijderd omdat er anders onbewust of onterecht
 * listeners worden verwijderd waarover de opdrachtgever geen rechten heeft;
 * de specificatie van addListener is aangescherpt ivm toegestane properties.
 */
public interface RemotePublisher extends Remote {

    /**
     * listener abonneert zich op PropertyChangeEvent's zodra property is 
     * gewijzigd
     * @param listener
     * @param property mag null zijn, dan abonneert listener zich op alle
     * properties; property moet wel een eigenschap zijn waarop je je kunt
     * abonneren
     */
    void addListener(RemotePropertyListener listener, String property)
            throws RemoteException;

    /**
     * het abonnement van listener voor PropertyChangeEvent's mbt property wordt
     * opgezegd
     * @param listener PropertyListener
     * @param property mag null zijn, dan worden alle abonnementen van listener
     * opgezegd
     */
    void removeListener(RemotePropertyListener listener, String property)
            throws RemoteException;

}
