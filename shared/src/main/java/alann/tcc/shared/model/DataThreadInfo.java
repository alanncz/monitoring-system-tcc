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
public class DataThreadInfo extends DataInfo {
    
    private int initQtdaThread;
    private int endQtdaThread;
    private int qtdaThreadInstance;

    public DataThreadInfo() {}

    public int getInitQtdaThread() {
        return initQtdaThread;
    }

    public void setInitQtdaThread(int initQtdaThread) {
        this.initQtdaThread = initQtdaThread;
    }

    public int getEndQtdaThread() {
        return endQtdaThread;
    }

    public void setEndQtdaThread(int endQtdaThread) {
        this.endQtdaThread = endQtdaThread;
    }

    public int getQtdaThreadInstance() {
        return qtdaThreadInstance;
    }

    public void setQtdaThreadInstance(int qtdaThreadInstance) {
        this.qtdaThreadInstance = qtdaThreadInstance;
    }

    @Override
    public String toString() {
        return "DataThreadInfo{" + "initQtdaThread=" + initQtdaThread + ", endQtdaThread=" + endQtdaThread + ", qtdaThreadInstance=" + qtdaThreadInstance + '}';
    }
    
    
    
    
    
    

   
    
}
