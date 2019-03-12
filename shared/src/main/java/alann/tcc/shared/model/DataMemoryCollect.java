/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

import java.io.Serializable;

/**
 *
 * @author alann
 */
public class DataMemoryCollect implements Serializable{
    
    private String ip;
    private long initMemory;
    private long endMemory;
    
    public DataMemoryCollect(){}

    public DataMemoryCollect(String ip, long initMemory, long endMemory) {
        this.ip = ip;
        this.initMemory = initMemory;
        this.endMemory = endMemory;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    @Override
    public String toString() {
        return "DataMemoryCollect{" + "ip=" + ip + ", initMemory=" + initMemory + ", endMemory=" + endMemory + '}';
    }
    
}
