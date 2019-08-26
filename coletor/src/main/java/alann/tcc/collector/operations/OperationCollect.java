/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.collector.operations;

import alann.tcc.collector.send.Send;
import alann.tcc.shared.model.Collect;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author alann
 */
public class OperationCollect implements Runnable {
    
    private final Collect collect;
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public OperationCollect(Collect collect){
        this.collect = collect;
    }

    @Override
    public void run() {
        TemporaryRepository.set(collect);
        executor.submit(new Send());
        
    }
    
    
}
