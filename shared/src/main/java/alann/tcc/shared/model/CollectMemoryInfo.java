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
public class CollectMemoryInfo extends Collect {
    
    private List<DataMemoryCollect> collections;

    public CollectMemoryInfo() {
        this.collections = new ArrayList();
    }

    public List<DataMemoryCollect> getCollections() {
        return collections;
    }

    public void setCollections(List<DataMemoryCollect> collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "CollectMemoryInfo{" + "collections=" + collections + '}';
    }
    
}
