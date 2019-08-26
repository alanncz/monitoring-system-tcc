package alann.tcc.api.send;


import alann.tcc.shared.model.DataInfo;
import alann.tcc.shared.services.Collector;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alann
 */
public class SendDataInfo {

    public static void send(DataInfo dataInfo, String host, int port) {

        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Collector stub = (Collector) registry.lookup("Collector");
            stub.newCollect(dataInfo);
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
}
