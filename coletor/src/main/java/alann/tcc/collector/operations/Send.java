/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.shared.model.Collect;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import alann.tcc.shared.services.Receiver;

/**
 *
 * @author alann
 */
public class Send implements Runnable {

    @Override
    public void run() {
            Collect collect = TemporaryRepository.get();
            try {
                Registry registry = LocateRegistry.getRegistry(9876);
                Receiver stub = (Receiver) registry.lookup("Receiver");
                stub.addCollect(collect);
            } catch (NotBoundException | RemoteException e) {
                System.err.println("Client exception: " + e.toString());
            }
    }

}
