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
public class CollectThreadInfo extends Collect {
    
    private List<DataThreadCollect> collections;
    
    public CollectThreadInfo(){
        this.collections = new ArrayList();
    }

    public List<DataThreadCollect> getCollections() {
        return collections;
    }

    public void setCollections(List<DataThreadCollect> collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "CollectThreadInfo{" + "collections=" + collections + '}';
    }  
    
}
