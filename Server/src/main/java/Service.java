
import alann.tcc.api.RegistryId;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alann
 */
public interface Service extends Remote {
    
    public void newPessoa(RegistryId rid, Pessoa pessoa)throws RemoteException;
    
}
