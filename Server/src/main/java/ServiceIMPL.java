
import alann.tcc.api.MonitoringServicesMemory;
import alann.tcc.api.MonitoringServicesSizePacket;
import alann.tcc.api.MonitoringServicesThread;
import alann.tcc.api.MonitoringServicesTime;
import alann.tcc.api.RegistryId;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alann
 */
public class ServiceIMPL implements Service {
    
    private static ArrayList<Pessoa> pessoas = new ArrayList();

    public ServiceIMPL() {
    }

    @Override
    public void newPessoa(RegistryId rid, Pessoa pessoa) throws RemoteException {

        try {
            
            MonitoringServicesTime.endTime(rid);
            MonitoringServicesMemory.initMemory(rid);
            MonitoringServicesThread.initQtdaThread(rid);
            
            Pessoa p = new Pessoa();
            p.setNome(pessoa.getNome());
            p.setIdade(pessoa.getIdade());
            pessoas.add(p);      

            MonitoringServicesSizePacket.dataInput(rid, pessoa, true, true);
            MonitoringServicesMemory.endMemory(rid, true);
            MonitoringServicesThread.endQtdaThread(rid, true);

            System.out.println("chegou aqui");
            String nome = pessoa.getNome();
            System.out.println(nome);
            
        } catch (IOException ex) {
            Logger.getLogger(ServiceIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
