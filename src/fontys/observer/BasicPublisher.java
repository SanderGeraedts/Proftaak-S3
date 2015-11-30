package fontys.observer;

import java.beans.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 * @version 1.4 Usage of Publisher-interface is removed because this interface is
 * Remote and objects of this class work locally within the same virtual
 * machine;
 */
public class BasicPublisher{

    /**
     * de listeners die onder de null-String staan geregistreerd zijn listeners
     * die op alle properties zijn geabonneerd
     */
    private HashMap<String, Set<RemotePropertyListener>> listenersTable;
    /**
     * als een listener zich bij een onbekende property registreert wordt de
     * lijst met bekende properties in een RuntimeException meegegeven (zie
     * codering checkInBehalfOfProgrammer)
     */
    private String propertiesString;

    /**
     * er wordt een basicpublisher gecreeerd die voor de meegegeven properties
     * remote propertylisteners kan registeren en hen op de hoogte zal houden in
     * geval van wijziging; de basicpublisher houdt ook een lijstje met remote
     * propertylisteners bij die zich op alle properties hebben geabonneerd.
     *
     * @param properties
     */
    public BasicPublisher(String[] properties) {
        listenersTable = new HashMap<String, Set<RemotePropertyListener>>();
        listenersTable.put(null, new HashSet<RemotePropertyListener>());
        for (String s : properties) {
            listenersTable.put(s, new HashSet<RemotePropertyListener>());
        }
        setPropertiesString();
    }

    /**
     * listener abonneert zich op PropertyChangeEvent's zodra property is
     * gewijzigd
     *
     * @param listener
     * @param property mag null zijn, dan abonneert listener zich op alle
     * properties; property moet wel een eigenschap zijn waarop je je kunt
     * abonneren
     */
    public void addListener(RemotePropertyListener listener, String property) {
        checkInBehalfOfProgrammer(property);

        listenersTable.get(property).add(listener);
    }

    /**
     * het abonnement van listener voor PropertyChangeEvent's mbt property wordt
     * opgezegd
     *
     * @param listener PropertyListener
     * @param property mag null zijn, dan worden alle abonnementen van listener
     * opgezegd
     */
    public void removeListener(RemotePropertyListener listener, String property) {
        if (property != null) {
            Set<RemotePropertyListener> propertyListeners = listenersTable.get(property);
            if (propertyListeners != null) {
                propertyListeners.remove(listener);
                listenersTable.get(null).remove(listener);
            }
        } else { //property == null, dus alle abonnementen van listener verwijderen
            Set<String> keyset = listenersTable.keySet();
            for (String key : keyset) {
                listenersTable.get(key).remove(listener);
            }
        }
    }

    /**
     * alle listeners voor property en de listeners met een algemeen abonnement
     * krijgen een aanroep van propertyChange
     *
     * @param source de publisher
     * @param property een geregistreerde eigenschap van de publisher (null is
     * toegestaan, in dat geval krijgen alle listeners een aanroep van
     * propertyChange)
     * @param oldValue oorspronkelijke waarde van de property van de publisher
     * (mag null zijn)
     * @param newValue nieuwe waarde van de property van de publisher
     */
    public void inform(Object source, String property, Object oldValue, Object newValue) {
        checkInBehalfOfProgrammer(property);

        Set<RemotePropertyListener> alertable;
        alertable = listenersTable.get(property);
        if (property != null) {
            alertable.addAll(listenersTable.get(null));
        } else {
            Set<String> keyset = listenersTable.keySet();
            for (String key : keyset) {
                alertable.addAll(listenersTable.get(key));
            }
        }

        for (RemotePropertyListener listener : alertable) {

            PropertyChangeEvent evt = new PropertyChangeEvent(
                    source, property, oldValue, newValue);
            try {
                listener.propertyChange(evt);
            } catch (RemoteException ex) {
                removeListener(listener, null);
                Logger.getLogger(BasicPublisher.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * property wordt alsnog bij publisher geregistreerd; voortaan kunnen alle
     * propertylisteners zich op wijziging van deze property abonneren; als
     * property al bij deze basicpublisher bekend is, verandert er niets
     *
     * @param property niet de lege string
     */
    public void addProperty(String property) {
        if (property.equals("")) {
            throw new RuntimeException("a property cannot be an empty string");
        }

        if (listenersTable.containsKey(property)) {
            return;
        }

        listenersTable.put(property, new HashSet<RemotePropertyListener>());
        setPropertiesString();
    }

    /**
     * property wordt bij publisher gederegistreerd; alle propertylisteners die
     * zich op wijziging van deze property hadden geabonneerd worden voortaan
     * niet meer op de hoogte gehouden; als property=null worden alle properties
     * (ongelijk aan null) gederegistreerd;
     *
     * @param property is geregistreerde property bij deze basicpublisher
     */
    public void removeProperty(String property) {
        checkInBehalfOfProgrammer(property);

        if (property != null) {
            listenersTable.remove(property);
        } else {
            Set<String> keyset = listenersTable.keySet();
            for (String key : keyset) {
                if (key != null) {
                    listenersTable.remove(key);
                }
            }
        }
        setPropertiesString();
    }

    private void setPropertiesString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        Iterator<String> it = listenersTable.keySet().iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(", ").append(it.next());
        }
        sb.append(" }");
        propertiesString = sb.toString();
    }

    private void checkInBehalfOfProgrammer(String property)
            throws RuntimeException {
        if (!listenersTable.containsKey(property)) {
            throw new RuntimeException("property " + property + " is not a "
                    + "published property, please make a choice out of: "
                    + propertiesString);
        }
    }

    /**
     *
     * @return alle properties inclusief de null-property
     */
    public Iterator<String> getProperties() {
        return listenersTable.keySet().iterator();
    }
}
