/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.modelView;

import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.CollectSizePacketInfo;
import alann.tcc.shared.model.CollectThreadInfo;
import alann.tcc.shared.model.CollectTimeInfo;

/**
 *
 * @author alann
 */
public class Execucao {
    
    private String id;
    private CollectTimeInfo CollectTimeInfo;
    private CollectThreadInfo CollectThreadInfo;
    private CollectMemoryInfo CollectMemoryInfo;
    private CollectSizePacketInfo tCollectSizePacketInfo;
    
    public Execucao(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CollectTimeInfo getCollectTimeInfo() {
        return CollectTimeInfo;
    }

    public void setCollectTimeInfo(CollectTimeInfo CollectTimeInfo) {
        this.CollectTimeInfo = CollectTimeInfo;
    }

    public CollectThreadInfo getCollectThreadInfo() {
        return CollectThreadInfo;
    }

    public void setCollectThreadInfo(CollectThreadInfo CollectThreadInfo) {
        this.CollectThreadInfo = CollectThreadInfo;
    }

    public CollectMemoryInfo getCollectMemoryInfo() {
        return CollectMemoryInfo;
    }

    public void setCollectMemoryInfo(CollectMemoryInfo CollectMemoryInfo) {
        this.CollectMemoryInfo = CollectMemoryInfo;
    }

    public CollectSizePacketInfo gettCollectSizePacketInfo() {
        return tCollectSizePacketInfo;
    }

    public void settCollectSizePacketInfo(CollectSizePacketInfo tCollectSizePacketInfo) {
        this.tCollectSizePacketInfo = tCollectSizePacketInfo;
    }

    @Override
    public String toString() {
        return "Execucao{" + "id=" + id + ", CollectTimeInfo=" + CollectTimeInfo + ", CollectThreadInfo=" + CollectThreadInfo + ", CollectMemoryInfo=" + CollectMemoryInfo + ", tCollectSizePacketInfo=" + tCollectSizePacketInfo + '}';
    }
    
}
