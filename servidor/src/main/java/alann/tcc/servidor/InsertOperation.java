/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.dao.CollectDao;
import alann.tcc.shared.dao.CollectMemoryInfoDao;
import alann.tcc.shared.dao.CollectSizePacketInfoDao;
import alann.tcc.shared.dao.CollectThreadInfoDao;
import alann.tcc.shared.dao.CollectTimeInfoDao;
import alann.tcc.shared.dao.ConnectionBd;
import alann.tcc.shared.dao.Dao;
import alann.tcc.shared.dao.IdsDao;
import alann.tcc.shared.model.Collect;
import alann.tcc.shared.model.TypeData;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class InsertOperation implements Runnable {

    @Override
    public void run() {

        Connection con = null;
        try {
            con = ConnectionBd.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InsertOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true) {
            
            Collect collect = TemporaryRepository.get();
            IdsDao idsDao = new IdsDao(con);
            idsDao.cadastrar(collect);
            
            if (collect.getTypeData() == TypeData.TaskCont) {
                Dao dao = new CollectDao(con);
                dao.cadastrar(collect);
                
            } else if (collect.getTypeData() == TypeData.TaskMemory) {
                Dao dao = new CollectMemoryInfoDao(con);
                dao.cadastrar(collect);
                
            } else if (collect.getTypeData() == TypeData.TaskSizePacket) {
                Dao dao = new CollectSizePacketInfoDao(con);
                dao.cadastrar(collect);
                
            } else if (collect.getTypeData() == TypeData.TaskThread) {
                Dao dao = new CollectThreadInfoDao(con);
                dao.cadastrar(collect);
                
            } else if (collect.getTypeData() == TypeData.TaskTime) {
                Dao dao = new CollectTimeInfoDao(con);
                dao.cadastrar(collect);
            }
        }

    }

}
