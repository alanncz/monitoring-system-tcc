/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.collector.send.Send;
import alann.tcc.shared.model.CollectSizePacketInfo;
import alann.tcc.shared.model.DataSizePacketCollect;
import alann.tcc.shared.model.DataSizePacketInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class OperationCollectSizePacketInfo implements Runnable {

    private final DataSizePacketInfo dataSizePacketInfo;
    private static Semaphore semaphore = new Semaphore(1);
    private static List<CollectSizePacketInfo> listCollect = new ArrayList();
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public OperationCollectSizePacketInfo(DataSizePacketInfo dataSizePacketInfo){
        this.dataSizePacketInfo = dataSizePacketInfo;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            CollectSizePacketInfo collect = getCollect();
            setCollect(collect);
            semaphore.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(OperationCollectMemoryInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private CollectSizePacketInfo getCollect() throws InterruptedException {
        if (!listCollect.isEmpty()) {
            for (int k = 0; k < listCollect.size(); k++) {
                CollectSizePacketInfo aux = listCollect.get(k);
                if (aux.getId().compareTo(dataSizePacketInfo.getId()) == 0) {
                    return aux;
                }
            }
        }
        return null;
    }
    
    private void setCollect(CollectSizePacketInfo collect){
        
        DataSizePacketCollect dspc = new DataSizePacketCollect();
        dspc.setIp(dataSizePacketInfo.getIp());
        dspc.setDataOutput(dataSizePacketInfo.getDataOutput());
        dspc.setDataInput(dataSizePacketInfo.getDataInput());
        
        collect.getCollections().add(dspc);
        
        if (dataSizePacketInfo.isEndCommit()){
            TemporaryRepository.set(collect);
            executor.submit(new Send());
            listCollect.remove(collect);
        }
        
    }
    
    public static void newCollect(CollectSizePacketInfo collect) throws InterruptedException{
        semaphore.acquire();
        listCollect.add(collect);
        semaphore.release();
    }

}
