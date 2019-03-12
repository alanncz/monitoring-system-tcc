/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alann
 */
public interface NewTask extends Remote {
    
    public void newCollect(String idApp,String idExecucao, String taskName) throws RemoteException;
    
}
