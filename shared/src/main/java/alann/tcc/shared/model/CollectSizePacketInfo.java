/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class CollectSizePacketInfo extends Collect {
    
    List<DataSizePacketCollect> collections;
    
    public CollectSizePacketInfo(){
        this.collections = new ArrayList();
    }

    public CollectSizePacketInfo(List<DataSizePacketCollect> collections) {
        this.collections = collections;
    }

    public List<DataSizePacketCollect> getCollections() {
        return collections;
    }

    public void setCollections(List<DataSizePacketCollect> collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "CollectSizePacketInfo{" + "collections=" + collections + '}';
    }
       
}
