/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author alann
 */

public class Collect implements Serializable {

    private String id;
    private AppReference appReference;
    private String taskName;
    private Enum typeData;
    private LocalDate date;
    private boolean complete;
    
    public Collect(){}
    
     public Collect(DataInfo dataInfo) { 
        this.typeData = dataInfo.getTypeData();
        this.appReference = dataInfo.getAppReference();
        this.taskName = dataInfo.getTaskName();
        this.id = dataInfo.getId();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Enum getTypeData() {
        return typeData;
    }

    public void setTypeData(Enum typeData) {
        this.typeData = typeData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppReference getAppReference() {
        return appReference;
    }

    public void setAppReference(AppReference appReference) {
        this.appReference = appReference;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Collect{" + "id=" + id + ", appReference=" + appReference + ", taskName=" + taskName + ", typeData=" + typeData + ", date=" + date + ", complete=" + complete + '}';
    }

}
