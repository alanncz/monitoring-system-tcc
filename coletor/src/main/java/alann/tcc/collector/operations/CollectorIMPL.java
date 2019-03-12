/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.shared.model.Collect;
import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.CollectSizePacketInfo;
import alann.tcc.shared.model.CollectThreadInfo;
import alann.tcc.shared.model.CollectTimeInfo;
import alann.tcc.shared.model.DataInfo;
import alann.tcc.shared.model.DataMemoryInfo;
import alann.tcc.shared.model.DataSizePacketInfo;
import alann.tcc.shared.model.DataThreadInfo;
import alann.tcc.shared.model.DataTimeInfo;
import alann.tcc.shared.model.RegistryCollect;
import alann.tcc.shared.model.TypeData;
import alann.tcc.shared.services.Collector;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class CollectorIMPL implements Collector {

    private ExecutorService executor = Executors.newCachedThreadPool();
    private static Semaphore semaphore = new Semaphore(1);

    @Override
    public void newCollect(DataInfo dataInfo) throws RemoteException {

        try {
            semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dataInfo.toString());

        if (dataInfo.getTypeData() == TypeData.TaskTime) {
            executor.submit(new OperationCollectTimeInfo((DataTimeInfo) dataInfo));
            
        } else if (dataInfo.getTypeData() == TypeData.TaskMemory) {
            executor.submit(new OperationCollectMemoryInfo((DataMemoryInfo) dataInfo)); 
            
        } else if (dataInfo.getTypeData() == TypeData.TaskSizePacket) {
            executor.submit(new OperationCollectSizePacketInfo((DataSizePacketInfo) dataInfo));  
            
        } else if (dataInfo.getTypeData() == TypeData.TaskThread) {
            executor.submit(new OperationCollectThreadInfo((DataThreadInfo) dataInfo));
        }
        semaphore.release();
        
    }    

    @Override
    public void newIdCollect(RegistryCollect rid) throws RemoteException {

        try {
            semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int k = 0; k < rid.getListTypeData().size(); k++) {
            
            TypeData td = rid.getListTypeData().get(k);
            
            if (null != td) switch (td) {
                
                case TaskCont:
                    Collect collect = new Collect();
                    setCollect(collect, rid);
                    collect.setTypeData(TypeData.TaskCont);
                    executor.submit(new OperationCollect(collect));
                    break;
                
                case TaskMemory:
                    try {
                        CollectMemoryInfo cmi = new CollectMemoryInfo();
                        setCollect(cmi, rid);
                        cmi.setTypeData(TypeData.TaskMemory);
                        OperationCollectMemoryInfo.newCollect(cmi);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                    
                case TaskTime:
                    try {
                        CollectTimeInfo cti = new CollectTimeInfo();
                        setCollect(cti, rid);
                        cti.setTypeData(TypeData.TaskTime);
                        OperationCollectTimeInfo.newCollect(cti);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                    
                    case TaskThread:
                    try {
                        CollectThreadInfo cti = new CollectThreadInfo();
                        setCollect(cti, rid);
                        cti.setTypeData(TypeData.TaskThread);
                        OperationCollectThreadInfo.newCollect(cti);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                  
                    case TaskSizePacket:
                    try {
                        CollectSizePacketInfo cspi = new CollectSizePacketInfo();
                        setCollect(cspi, rid);
                        cspi.setTypeData(TypeData.TaskSizePacket);
                        OperationCollectSizePacketInfo.newCollect(cspi);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CollectorIMPL.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                    
                default:
                    break;
            }
            
        }
        semaphore.release();

    }

    private Collect setCollect(Collect collect, RegistryCollect rid) {
        collect.setId(rid.getIdRequest());
        collect.setTaskName(rid.getTaskName());
        collect.setAppReference(rid.getAppReference());
        collect.setDate(LocalDate.now());
        return collect;
    }

}
