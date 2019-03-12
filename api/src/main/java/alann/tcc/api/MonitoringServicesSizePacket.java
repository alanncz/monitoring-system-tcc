/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api;

import alann.tcc.shared.model.DataSizePacketInfo;
import alann.tcc.shared.model.TypeData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class MonitoringServicesSizePacket extends MonitoringServices {
    
    private static List<DataSizePacketInfo> listSizePacketInfo = new ArrayList();
    
    private static DataSizePacketInfo isExisDataInfo(RegistryId rid) throws UnknownHostException{
        if(!listSizePacketInfo.isEmpty()){
            for(int k = 0; k < listSizePacketInfo.size(); k++){
                DataSizePacketInfo dspi = listSizePacketInfo.get(k);
                if (dspi.getId().compareTo(rid.getIdRequest()) == 0) return dspi;
            }
        }
        return getDataInfo(rid);
    }
    
    public static void dataInput(RegistryId rid, Object object, boolean unique, boolean end) throws UnknownHostException, IOException {
        DataSizePacketInfo dspi = isExisDataInfo(rid);
        dspi.setDataInput(sizePacket(object));
        if (unique) dspi.setCommit(dspi.getCommit() - 1);
        dspi.setCommit(dspi.getCommit() - 1);
        dspi.setEndCommit(end);
        if(dspi.getCommit() == 0) {
            sendCollect(dspi);
            listSizePacketInfo.remove(dspi);
        }
        
    }
    
    public static void dataOutPut(RegistryId rid, Object object, boolean unique, boolean end) throws UnknownHostException, IOException{
        DataSizePacketInfo dspi = isExisDataInfo(rid);
        dspi.setDataOutput(sizePacket(object));
        if (unique) dspi.setCommit(dspi.getCommit() - 1);
        dspi.setCommit(dspi.getCommit() - 1);
        dspi.setEndCommit(end);
        if(dspi.getCommit() == 0) {
            sendCollect(dspi);
            listSizePacketInfo.remove(dspi);
        }
    }
    
    private static DataSizePacketInfo getDataInfo(RegistryId rid) throws UnknownHostException{
        DataSizePacketInfo dspi = new DataSizePacketInfo();
        String ip = InetAddress.getLocalHost().getHostAddress();
        dspi.setId(rid.getIdRequest());
        dspi.setIp(ip);
        dspi.setAppReference(Configuration.getAppReference());
        dspi.setTaskName(rid.getTaskName());
        dspi.setTypeData(TypeData.TaskSizePacket);
        listSizePacketInfo.add(dspi);
        return dspi;
    }
    
    public static int sizePacket(byte[] bytes){
        return bytes.length;
    }

    public static int sizePacket(Object object) throws IOException {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return bytes.length;

    }
    
}
