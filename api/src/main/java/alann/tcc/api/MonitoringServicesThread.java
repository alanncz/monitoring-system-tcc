/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api;

import alann.tcc.shared.model.DataThreadInfo;
import alann.tcc.shared.model.TypeData;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class MonitoringServicesThread extends MonitoringServices {

    private static List<DataThreadInfo> listDataThreadInfo = new ArrayList();

    public static void initQtdaThread(RegistryId rid) throws UnknownHostException {
        
        String ip = InetAddress.getLocalHost().getHostAddress();
        int qtda = Thread.activeCount();
        DataThreadInfo dti = new DataThreadInfo();
        dti.setAppReference(Configuration.getAppReference());
        dti.setIp(ip);
        dti.setId(rid.getIdRequest());
        dti.setInitQtdaThread(qtda);
        dti.setTaskName(rid.getTaskName());
        dti.setTypeData(TypeData.TaskThread);
        dti.setEndCommit(false);
        listDataThreadInfo.add(dti);

    }

    public static void endQtdaThread(RegistryId rid, boolean end) {
        
        int qtda = Thread.activeCount();
        for(int k = 0; k < listDataThreadInfo.size(); k++){
            DataThreadInfo dti = listDataThreadInfo.get(k);
            if (dti.getId().compareTo(rid.getIdRequest()) == 0){
                dti.setEndQtdaThread(qtda);
                dti.setEndCommit(end);
                sendCollect(dti);
                listDataThreadInfo.remove(dti);
            }
        }

    }
    
    public static void contNewThread(RegistryId rid, int qtda){
        for(int k = 0; k < listDataThreadInfo.size(); k++){
            DataThreadInfo dti = listDataThreadInfo.get(k);
            if (dti.getId().compareTo(rid.getIdRequest()) == 0){
                dti.setQtdaThreadInstance(dti.getQtdaThreadInstance() + qtda);
            }
        }      
    }

}
