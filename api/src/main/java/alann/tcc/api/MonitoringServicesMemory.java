/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api;

import alann.tcc.shared.model.DataMemoryInfo;
import alann.tcc.shared.model.TypeData;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class MonitoringServicesMemory extends MonitoringServices {

    private static List<DataMemoryInfo> listDataMemoryInfo = new ArrayList();

    public static void initMemory(RegistryId rid) throws UnknownHostException {
        Runtime rt = Runtime.getRuntime();
        long memory = rt.freeMemory();
        String ip = InetAddress.getLocalHost().getHostAddress();
        DataMemoryInfo dmi = new DataMemoryInfo();
        
        dmi.setAppReference(Configuration.getAppReference());
        dmi.setInitMemory(memory);
        dmi.setTaskName(rid.getTaskName());
        dmi.setTypeData(TypeData.TaskMemory);
        dmi.setIp(ip);
        dmi.setId(rid.getIdRequest());
        dmi.setEndCommit(false);
        listDataMemoryInfo.add(dmi);

    }

    public static void endMemory(RegistryId rid, boolean end) {
        Runtime rt = Runtime.getRuntime();
        long memory = rt.freeMemory();
        for(int k = 0; k < listDataMemoryInfo.size(); k++){
            DataMemoryInfo dmi = listDataMemoryInfo.get(k);
            if (dmi.getId().compareTo(rid.getIdRequest()) == 0){
                dmi.setEndMemory(memory);
                dmi.setEndCommit(end);
                sendCollect(dmi);
                listDataMemoryInfo.remove(dmi);
            }
        }
    }

}
