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
public class DataSizePacketCollect implements Serializable {
    
    private String ip;
    private int dataInput;   //entrada de dados  
    private int dataOutput;  //saida de dados
    
    public DataSizePacketCollect(){}

    public DataSizePacketCollect(String ip, int dataInput, int dataOutput) {
        this.ip = ip;
        this.dataInput = dataInput;
        this.dataOutput = dataOutput;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDataInput() {
        return dataInput;
    }

    public void setDataInput(int dataInput) {
        this.dataInput = dataInput;
    }

    public int getDataOutput() {
        return dataOutput;
    }

    public void setDataOutput(int dataOutput) {
        this.dataOutput = dataOutput;
    }

    @Override
    public String toString() {
        return "DataSizePacketCollect{" + "ip=" + ip + ", dataInput=" + dataInput + ", dataOutput=" + dataOutput + '}';
    }
    
}
