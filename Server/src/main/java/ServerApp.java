
import alann.tcc.api.Configuration;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alann
 */
public class ServerApp {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {
        
        Configuration();
        
        Service obj = new ServiceIMPL();
        Service stub = (Service) UnicastRemoteObject.exportObject(obj, 0);
        Registry registry = LocateRegistry.createRegistry(1111);
        registry.bind("Service", stub);
        System.out.println("Servidor do cliente rodando");
    }

    public static void Configuration() throws RemoteException, NotBoundException {
        
        String idApp = "8f3e877f737c4d54852dc9ffb8b98358";
        String hostCollector = "localhost";
        Configuration.appConfiguration(idApp);
        Configuration.configurationCollector(hostCollector);
        
    }
    
}
