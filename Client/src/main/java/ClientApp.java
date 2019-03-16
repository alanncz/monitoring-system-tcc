
import alann.tcc.api.Configuration;
import alann.tcc.api.RegistryId;
import alann.tcc.api.RegistryIdManager;
import alann.tcc.shared.model.TypeData;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
        
        
        RegistryId rid = RegistryIdManager.newRegistryId("Main", ListTypeData());
        
        NewPessoa np = new NewPessoa();
        np.newPessoa(rid);

        //View view = MonitoringServices.getVIew(cc.getAppReference());
    }

    public static void Configuration() throws RemoteException, NotBoundException {

        String idApp = "9b7ff11723c64b3b83e18c84cc3b5575";
        String hostCollector = "localhost";
        Configuration.appConfiguration(idApp);
        Configuration.configurationCollector(hostCollector);

    }
    
    public static ArrayList<TypeData> ListTypeData(){
        ArrayList<TypeData> registryIds = new ArrayList();
        registryIds.add(TypeData.TaskTime);
        registryIds.add(TypeData.TaskMemory);
        registryIds.add(TypeData.TaskSizePacket);
        registryIds.add(TypeData.TaskThread);
        return registryIds;
    }

}
