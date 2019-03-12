/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api;

import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.services.ConfigurationService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author alann
 */
public class Configuration {
    
    private static AppReference appReference;
    private static String hostCollector;
    private static final int portHost = 1234;
    
    public Configuration(){}

    public static AppReference getAppReference() {
        return appReference;
    }

    public static void setAppReference(AppReference appReference) {
        Configuration.appReference = appReference;
    }

    public static String getHostCollector() {
        return hostCollector;
    }

    public static void setHostCollector(String hostCollector) {
        Configuration.hostCollector = hostCollector;
    }

    public static int getPortHost() {
        return portHost;
    }

    public static void appConfiguration(String idApp) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(9876);
        ConfigurationService stub = (ConfigurationService) registry.lookup("ConfigurationService"); 
        appReference = stub.getAppReference(idApp); 
        System.out.println(appReference.toString());
    }
    
    public static void configurationCollector(String host){
        hostCollector = host;    
    }

}
