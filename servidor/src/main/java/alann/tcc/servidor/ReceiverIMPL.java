/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.model.Collect;
import alann.tcc.shared.services.Receiver;
import java.rmi.RemoteException;

/**
 *
 * @author alann
 */
public class ReceiverIMPL implements Receiver{

    @Override
    public void addCollect(Collect collect) throws RemoteException {
        
        System.out.println(collect.toString());
        TemporaryRepository.set(collect);
    }
    
}
