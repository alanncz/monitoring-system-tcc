/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.collector.send.Send;
import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.CollectThreadInfo;
import alann.tcc.shared.model.DataThreadCollect;
import alann.tcc.shared.model.DataThreadInfo;
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
public class OperationCollectThreadInfo implements Runnable {
    
    private final DataThreadInfo dataThreadInfo;
    private static Semaphore semaphore = new Semaphore(1);
    private static List<CollectThreadInfo> listCollect = new ArrayList();
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public OperationCollectThreadInfo(DataThreadInfo dataThreadInfo) {
        this.dataThreadInfo = dataThreadInfo;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            CollectThreadInfo collect = getCollect();
            setCollect(collect);
            semaphore.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(OperationCollectMemoryInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private CollectThreadInfo getCollect() throws InterruptedException {
        if (!listCollect.isEmpty()) {
            for (int k = 0; k < listCollect.size(); k++) {
                CollectThreadInfo aux = listCollect.get(k);
                if (aux.getId().compareTo(dataThreadInfo.getId()) == 0) {
                    return aux;
                }
            }
        }
        return null;
    }
    
    public static void newCollect(CollectThreadInfo collect) throws InterruptedException{
        semaphore.acquire();
        listCollect.add(collect);
        semaphore.release();
    }
    
    private void setCollect(CollectThreadInfo collect){
        DataThreadCollect dtc = new DataThreadCollect();
        dtc.setIp(dataThreadInfo.getIp());
        dtc.setInitThreads(dataThreadInfo.getInitQtdaThread());
        dtc.setEndThreads(dataThreadInfo.getEndQtdaThread());
        dtc.setInstanceThreads(dataThreadInfo.getQtdaThreadInstance());
        collect.getCollections().add(dtc);
        if (dataThreadInfo.isEndCommit()){
            TemporaryRepository.set(collect);
            executor.submit(new Send());
            listCollect.remove(collect);            
        }
        
    }

    
}
