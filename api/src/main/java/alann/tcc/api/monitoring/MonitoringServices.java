/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api.monitoring;

import alann.tcc.api.send.SendDataInfo;
import alann.tcc.api.util.RegistryId;
import alann.tcc.api.configuration.Configuration;
import alann.tcc.api.configuration.Configuration;
import alann.tcc.shared.model.DataInfo;
import alann.tcc.shared.model.TypeData;

/**
 *
 * @author alann
 */
public class MonitoringServices {


    public static void contTaskExecute(RegistryId rid) {
        DataInfo di = new DataInfo();
        di.setId(rid.getIdRequest());
        di.setAppReference(Configuration.getAppReference());
        di.setTaskName(rid.getTaskName());
        di.setTypeData(TypeData.TaskCont);
        sendCollect(di);
    }

    public static void sendCollect(DataInfo dataInfo) {
        String host = Configuration.getHostCollector();
        int port = Configuration.getPortHost();
        SendDataInfo.send(dataInfo, host, port);
    }

}
