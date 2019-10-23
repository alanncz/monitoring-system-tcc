/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.collector.send.Send;
import alann.tcc.shared.model.CollectTimeInfo;
import alann.tcc.shared.model.DataTimeInfo;
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
public class OperationCollectTimeInfo implements Runnable {

    private final DataTimeInfo dataTimeInfo;
    private static Semaphore semaphore = new Semaphore(1);
    private static List<CollectTimeInfo> listCollect = new ArrayList();
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public OperationCollectTimeInfo(DataTimeInfo dataTimeInfo) {
        this.dataTimeInfo = dataTimeInfo;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            CollectTimeInfo collect = getCollect();
            setCollect(collect);
            semaphore.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(OperationCollectTimeInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private CollectTimeInfo getCollect() throws InterruptedException {
        if (!listCollect.isEmpty()) {
            for (int k = 0; k < listCollect.size(); k++) {
                CollectTimeInfo aux = listCollect.get(k);
                if (aux.getId().compareTo(dataTimeInfo.getId()) == 0) {
                    return aux;
                }
            }
        }
        return null;
    }

    private void setCollect(CollectTimeInfo collect) {
        if (dataTimeInfo.getTypeTimeRecorded() == 1) {
            collect.setInitTime(dataTimeInfo.getTimeRecord());
            collect.getIps().add(0, dataTimeInfo.getIp());
        }
        if (dataTimeInfo.getTypeTimeRecorded() == 2) {
            collect.setEndTime(dataTimeInfo.getTimeRecord());
            collect.getIps().add(1, dataTimeInfo.getIp());
            if (dataTimeInfo.isEndCommit()) {
                TemporaryRepository.set(collect);
                executor.submit(new Send());
                listCollect.remove(collect);
            }
        }
        collect.setCommit();
    }

    public static void newCollect(CollectTimeInfo collect) throws InterruptedException {
        semaphore.acquire();
        listCollect.add(collect);
        semaphore.release();
    }

}
