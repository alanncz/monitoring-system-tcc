/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.collector.send.Send;
import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.DataMemoryInfo;
import alann.tcc.shared.model.DataMemoryCollect;
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
public class OperationCollectMemoryInfo implements Runnable {
    
    private final DataMemoryInfo dataMemoryInfo;
    private static Semaphore semaphore = new Semaphore(1);
    private static List<CollectMemoryInfo> listCollect = new ArrayList();
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public OperationCollectMemoryInfo(DataMemoryInfo dataMemoryInfo){
        this.dataMemoryInfo = dataMemoryInfo;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            CollectMemoryInfo collect = getCollect();
            setCollect(collect);
            semaphore.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(OperationCollectMemoryInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private CollectMemoryInfo getCollect() throws InterruptedException {
        if (!listCollect.isEmpty()) {
            for (int k = 0; k < listCollect.size(); k++) {
                CollectMemoryInfo aux = listCollect.get(k);
                if (aux.getId().compareTo(dataMemoryInfo.getId()) == 0) {
                    return aux;
                }
            }
        }
        return null;
    }
    
    private void setCollect(CollectMemoryInfo collect){
        
        DataMemoryCollect dmc = new DataMemoryCollect();
        dmc.setIp(dataMemoryInfo.getIp());
        dmc.setInitMemory(dataMemoryInfo.getInitMemory());
        dmc.setEndMemory(dataMemoryInfo.getEndMemory());
        collect.getCollections().add(dmc);
        
        if (dataMemoryInfo.isEndCommit()){
            TemporaryRepository.set(collect);
            executor.submit(new Send());
            listCollect.remove(collect);
        }
        
    }
    
    public static void newCollect(CollectMemoryInfo collect) throws InterruptedException{
        semaphore.acquire();
        listCollect.add(collect);
        semaphore.release();
    }
    
}
