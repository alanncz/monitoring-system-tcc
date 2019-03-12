/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.services;

import alann.tcc.shared.model.AppReference;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alann
 */
public interface ConfigurationService extends Remote {
    
    public AppReference getAppReference(String idApp) throws RemoteException;
    
}
