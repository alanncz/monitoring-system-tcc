/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api.util;

import alann.tcc.api.configuration.Configuration;
import alann.tcc.shared.services.Collector;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.UUID;
import alann.tcc.shared.model.RegistryCollect;
import alann.tcc.shared.services.NewTask;
import java.util.List;

/**
 *
 * @author alann
 */
public class RegistryIdManager {

    public static RegistryId newRegistryId(String TasName, List typeData) throws RemoteException, NotBoundException {
        UUID uuid = UUID.randomUUID();
        RegistryId rid = new RegistryId();
        rid.setIdRequest(uuid.toString());
        rid.setTaskName(TasName);
        rid.setListTypeData(typeData);
        newTask(rid);
        newIdCollect(rid);
        return rid;
    }

    private static void newTask(RegistryId rid) throws RemoteException, NotBoundException {
        Registry registry2 = LocateRegistry.getRegistry(9876);
        NewTask stub2 = (NewTask) registry2.lookup("NewTask");

        String idApp = Configuration.getAppReference().getId();
        String idExecucao = rid.getIdRequest();
        String taskName = rid.getTaskName();

        stub2.newCollect(idApp, idExecucao, taskName);
    }

    private static void newIdCollect(RegistryId rid) throws RemoteException, NotBoundException {
        String host = Configuration.getHostCollector();
        int port = Configuration.getPortHost();
        Registry registry = LocateRegistry.getRegistry(host, port);
        Collector stub = (Collector) registry.lookup("Collector");

        RegistryCollect rc = new RegistryCollect();
        rc.setIdRequest(rid.getIdRequest());
        rc.setTaskName(rid.getTaskName());
        rc.setListTypeData(rid.getListTypeData());
        rc.setAppReference(Configuration.getAppReference());
        stub.newIdCollect(rc);

    }

}
