/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.services.ConfigurationService;
import alann.tcc.shared.services.NewTask;
import alann.tcc.shared.services.Receiver;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author alann
 */
public class ServerMain {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException {
        
        Thread t = new Thread(new InsertOperation());
        t.start();
        
        Receiver obj1 = new ReceiverIMPL();
        ConfigurationService obj2 = new ConfigurationServiceIMPL();
        NewTask obj3 = new NewTaskIMPL();
        //Logger obj3 = new LoggerIMPL();
        
        Receiver stub1 = (Receiver) UnicastRemoteObject.exportObject(obj1, 0);
        ConfigurationService stub2 = (ConfigurationService) UnicastRemoteObject.exportObject(obj2, 0);
        NewTask stub3 = (NewTask) UnicastRemoteObject.exportObject(obj3, 0);
        //Logger stub3 = (Logger) UnicastRemoteObject.exportObject(obj3, 0);
        
        Registry registry = LocateRegistry.createRegistry(9876);
        registry.bind("Receiver", stub1);
        registry.bind("ConfigurationService", stub2);
        registry.bind("NewTask", stub3);
        //registry.bind("Logger", stub3);
        System.out.println("Servidor de monitoramento rodando");
    }
    
}
