/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.model;

import java.sql.Timestamp;

/**
 *
 * @author alann
 */
public class DataTimeInfo extends DataInfo {
    
    private int typeTimeRecorded;
    private Timestamp timeRecord;
    
    public DataTimeInfo(){}  

    public int getTypeTimeRecorded() {
        return typeTimeRecorded;
    }

    public void setTypeTimeRecorded(int typeTimeRecorded) {
        this.typeTimeRecorded = typeTimeRecorded;
    }

    public Timestamp getTimeRecord() {
        return timeRecord;
    }

    public void setTimeRecord(Timestamp timeRecord) {
        this.timeRecord = timeRecord;
    }

    @Override
    public String toString() {
        return super.toString() + ", typeTimeRecorded=" + typeTimeRecorded + ", timeRecord=" + timeRecord + '}';
    }
    
}
