/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

/**
 *
 * @author alann
 */
public class DataMemoryInfo extends DataInfo {

    private long initMemory;
    private long endMemory;
    private boolean complete;
    
    public DataMemoryInfo(){
        this.complete = false;
    }

    public long getInitMemory() {
        return initMemory;
    }

    public void setInitMemory(long initMemory) {
        this.initMemory = initMemory;
    }

    public long getEndMemory() {
        return endMemory;
    }

    public void setEndMemory(long endMemory) {
        this.endMemory = endMemory;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "DataMemoryInfo{" + "initMemory=" + initMemory + ", endMemory=" + endMemory + ", complete=" + complete + '}';
    }
    
}
