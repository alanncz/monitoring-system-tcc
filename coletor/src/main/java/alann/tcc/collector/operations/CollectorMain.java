/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.shared.services.Collector;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author alann
 */
public class CollectorMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Collector obj = new CollectorIMPL();
        Collector stub = (Collector) UnicastRemoteObject.exportObject(obj, 0);
        Registry registry = LocateRegistry.createRegistry(1234);
        registry.bind("Collector", stub);
        System.out.println("Coletor rodando");
    }

}
