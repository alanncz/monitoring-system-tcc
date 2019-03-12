/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.services;

import alann.tcc.shared.model.DataInfo;
import alann.tcc.shared.model.RegistryCollect;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alann
 */
public interface Collector extends Remote {
    
    public void newCollect(DataInfo dataInfo)throws RemoteException;
    public void newIdCollect(RegistryCollect rid) throws RemoteException;
    
}
