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
public class DataThreadCollect implements Serializable {
    
    private String ip;
    private int initThreads;
    private int endThreads;
    private int instanceThreads;
    
    public DataThreadCollect(){}

    public DataThreadCollect(String ip, int initThreads, int endThreads, int instanceThreads) {
        this.ip = ip;
        this.initThreads = initThreads;
        this.endThreads = endThreads;
        this.instanceThreads = instanceThreads;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getInitThreads() {
        return initThreads;
    }

    public void setInitThreads(int initThreads) {
        this.initThreads = initThreads;
    }

    public int getEndThreads() {
        return endThreads;
    }

    public void setEndThreads(int endThreads) {
        this.endThreads = endThreads;
    }

    public int getInstanceThreads() {
        return instanceThreads;
    }

    public void setInstanceThreads(int instanceThreads) {
        this.instanceThreads = instanceThreads;
    }

    @Override
    public String toString() {
        return "DataThreadCollect{" + "ip=" + ip + ", initThreads=" + initThreads + ", endThreads=" + endThreads + ", instanceThreads=" + instanceThreads + '}';
    }
    
}
