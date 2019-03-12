
import alann.tcc.api.Configuration;
import alann.tcc.api.MonitoringServicesMemory;
import alann.tcc.api.MonitoringServicesSizePacket;
import alann.tcc.api.MonitoringServicesThread;
import alann.tcc.api.MonitoringServicesTime;
import alann.tcc.api.RegistryId;
import alann.tcc.api.RegistryIdManager;
import alann.tcc.shared.model.TypeData;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alann
 */
public class ClientApp {

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException, UnknownHostException, IOException {

        Configuration();
        
        ArrayList<TypeData> registryIds = new ArrayList();
        registryIds.add(TypeData.TaskTime);
        registryIds.add(TypeData.TaskMemory);
        registryIds.add(TypeData.TaskSizePacket);
        registryIds.add(TypeData.TaskThread);
        
        
        RegistryId rid = RegistryIdManager.newRegistryId("Main", registryIds);
        
        MonitoringServicesThread.initQtdaThread(rid);
        MonitoringServicesTime.initTime(rid);
        MonitoringServicesMemory.initMemory(rid);
        
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
        
        MonitoringServicesThread.contNewThread(rid, 2);
        
        Registry registry = LocateRegistry.getRegistry(1111);
        Service stub = (Service) registry.lookup("Service");
        
        Pessoa p = new Pessoa();
        p.setNome("Alann Rodrigues Ferreira");
        p.setCpf("096.601.104-05");
        p.setIdade(25);
        
        MonitoringServicesSizePacket.dataOutPut(rid, p,true, false);
        MonitoringServicesMemory.endMemory(rid, false);
        MonitoringServicesThread.endQtdaThread(rid, false);
        
        stub.newPessoa(rid, p);
        

        Thread.sleep(1000);
        //View view = MonitoringServices.getVIew(cc.getAppReference());
    }

    public static void Configuration() throws RemoteException, NotBoundException {

        String idApp = "bb3c19cb42ee48c5b7fc85095cf07001";
        String hostCollector = "localhost";
        Configuration.appConfiguration(idApp);
        Configuration.configurationCollector(hostCollector);

    }

}
