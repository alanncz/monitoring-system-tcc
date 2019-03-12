/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

/**
 *
 * @author alann
 */
public class DataSizePacketInfo extends DataInfo {
    
    private int commit;
    private int dataInput;   //entrada de dados  
    private int dataOutput;  //saida de dados
    
    public DataSizePacketInfo(){
        this.commit = 2;
    }

    public DataSizePacketInfo(int dataInput, int dataOutput) {
        this.dataInput = dataInput;
        this.dataOutput = dataOutput;
        this.commit = 2;
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

    public int getCommit() {
        return commit;
    }

    public void setCommit(int commit) {
        this.commit = commit;
    }

    @Override
    public String toString() {
        return "DataSizePacketInfo{" + "commit=" + commit + ", dataInput=" + dataInput + ", dataOutput=" + dataOutput + '}';
    }
    
    
}
