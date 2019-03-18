/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class CollectTimeInfo extends Collect implements Serializable{
    
    private List<String> ips;
    private Timestamp initTime;
    private Timestamp endTime;
    private boolean complete;
    private int commit;
    private String milisegundos;
    
    public CollectTimeInfo(){
        this.ips = new ArrayList();
        this.commit = 2;
        this.complete = false;
    }

    public CollectTimeInfo(DataTimeInfo dataInfo) {
        super(dataInfo);
        this.ips = new ArrayList();
        this.commit = 2;
        this.complete = false;
    } 

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public Timestamp getInitTime() {
        return initTime;
    }

    public void setInitTime(Timestamp initTime) {
        this.initTime = initTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    } 
    
    public int getCommit() {
        return commit;
    }

    public void setCommit() {
        this.commit --;
        if (this.commit == 0) this.complete = true;
    }
    
     @Override
    public boolean isComplete(){
        if (this.complete == true) return true;
        return false;
    }

    public String getMilisegundos() {
        return milisegundos;
    }

    public void setMilisegundos(String milisegundos) {
        this.milisegundos = milisegundos;
    }
    
    
    public void milisegundos(){
        long tempoInicial = initTime.getTime();
        long tempoFinal = endTime.getTime();
        
        long resultado = tempoFinal - tempoInicial;
        this.milisegundos = Long.toString(resultado);
    }

    @Override
    public String toString() {
        return "CollectTimeInfo{" + "ips=" + ips + ", initTime=" + initTime + ", endTime=" + endTime + ", complete=" + complete + ", commit=" + commit + '}';
    }
   
}
