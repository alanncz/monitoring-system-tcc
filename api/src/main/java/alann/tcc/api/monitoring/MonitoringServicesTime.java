package alann.tcc.api.monitoring;

import alann.tcc.api.util.RegistryId;
import alann.tcc.api.configuration.Configuration;
import alann.tcc.api.configuration.Configuration;
import alann.tcc.shared.model.DataInfo;
import alann.tcc.shared.model.DataTimeInfo;
import alann.tcc.shared.model.TypeData;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alann
 */
public class MonitoringServicesTime  extends MonitoringServices {

    public static void initTime(RegistryId rid) throws UnknownHostException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DataTimeInfo dataInfo = (DataTimeInfo) dataConfiguration(timestamp, rid);
        dataInfo.setTypeTimeRecorded(1);
        sendCollect(dataInfo);

    }

    public static void endTime(RegistryId rid) throws UnknownHostException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DataTimeInfo dataInfo = (DataTimeInfo) dataConfiguration(timestamp, rid);
        dataInfo.setTypeTimeRecorded(2);
        dataInfo.setEndCommit(true);
        sendCollect(dataInfo);

    }

    private static DataInfo dataConfiguration(Timestamp timestamp, RegistryId rid) throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        DataTimeInfo dataTimeInfo = new DataTimeInfo();
        dataTimeInfo.setIp(ip);
        dataTimeInfo.setAppReference(Configuration.getAppReference());
        dataTimeInfo.setTaskName(rid.getTaskName());
        dataTimeInfo.setId(rid.getIdRequest());
        dataTimeInfo.setTypeData(TypeData.TaskTime);
        dataTimeInfo.setTimeRecord(timestamp);
        return dataTimeInfo;

    }

}
