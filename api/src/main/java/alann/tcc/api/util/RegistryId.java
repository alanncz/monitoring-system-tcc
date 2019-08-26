/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.api.util;

import alann.tcc.shared.model.TypeData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alann
 */
public class RegistryId implements Serializable {
    
    private String taskName;
    private String idRequest;
    private List<TypeData> listTypeData;
    
    public RegistryId(){}

    public RegistryId(String taskName, String idRequest, List<TypeData> listTypeData) {
        this.taskName = taskName;
        this.idRequest = idRequest;
        this.listTypeData = listTypeData;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public List<TypeData> getListTypeData() {
        return listTypeData;
    }

    public void setListTypeData(List<TypeData> listTypeData) {
        this.listTypeData = listTypeData;
    }

    @Override
    public String toString() {
        return "RegistryId{" + "taskName=" + taskName + ", idRequest=" + idRequest + ", listTypeData=" + listTypeData + '}';
    }
    
}
