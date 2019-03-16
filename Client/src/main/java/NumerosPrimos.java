
import alann.tcc.api.MonitoringServicesMemory;
import alann.tcc.api.MonitoringServicesSizePacket;
import alann.tcc.api.MonitoringServicesThread;
import alann.tcc.api.MonitoringServicesTime;
import alann.tcc.api.RegistryId;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alann
 */
public class NumerosPrimos {

    public void numerosPrimos(RegistryId rid) throws UnknownHostException, RemoteException, NotBoundException, IOException {

        MonitoringServicesTime.initTime(rid);
        MonitoringServicesMemory.initMemory(rid);
        MonitoringServicesThread.initQtdaThread(rid);

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();

        MonitoringServicesThread.contNewThread(rid, 2);

        Registry registry = LocateRegistry.getRegistry(1111);
        Service stub = (Service) registry.lookup("Service");

        Random rand = new Random();
        int randomNum = rand.nextInt((20000 - 10000) + 1) + 10000;


        MonitoringServicesSizePacket.dataOutPut(rid, randomNum, false, false);
        MonitoringServicesThread.endQtdaThread(rid, false);

        ArrayList lista = stub.numerosPrimos(rid, randomNum);

        MonitoringServicesSizePacket.dataInput(rid, lista, false, true);
        MonitoringServicesMemory.endMemory(rid, true);

    }

}
