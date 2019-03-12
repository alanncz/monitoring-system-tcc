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
public class DataInfo implements Serializable {
    
    private String ip;
    private String id;
    private String taskName;
    private Enum typeData;
    private AppReference appReference;
    private boolean endCommit; //indentifica se os dados enviados sao de um endPoint de uma tarefa.
    
    public DataInfo(){}

    public DataInfo(String ip, String id, String taskName, Enum typeData, AppReference appReference, boolean endCommit) {
        this.ip = ip;
        this.id = id;
        this.taskName = taskName;
        this.typeData = typeData;
        this.appReference = appReference;
        this.endCommit = endCommit;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Enum getTypeData() {
        return typeData;
    }

    public void setTypeData(Enum typeData) {
        this.typeData = typeData;
    }

    public AppReference getAppReference() {
        return appReference;
    }

    public void setAppReference(AppReference appReference) {
        this.appReference = appReference;
    }

    public boolean isEndCommit() {
        return endCommit;
    }

    public void setEndCommit(boolean endCommit) {
        this.endCommit = endCommit;
    }

    @Override
    public String toString() {
        return "DataInfo{" + "ip=" + ip + ", id=" + id + ", taskName=" + taskName + ", typeData=" + typeData + ", appReference=" + appReference + ", endCommit=" + endCommit + '}';
    }

    
    
}
