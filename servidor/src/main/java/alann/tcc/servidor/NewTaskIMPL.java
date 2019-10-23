/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.dao.CollectDao;
import alann.tcc.shared.dao.ConnectionBd;
import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.model.Collect;
import alann.tcc.shared.model.TypeData;
import alann.tcc.shared.services.NewTask;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class NewTaskIMPL implements NewTask {

    private static List<String> listTask;

    private static boolean isExist(String idApp, String taskName, Connection con) {

        CollectDao dao = new CollectDao(con);
        listTask = dao.listar(idApp);
        if (!listTask.isEmpty()) {
            for (int k = 0; k < listTask.size(); k++) {
                if (listTask.get(k).compareTo(taskName) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void newCollect(String idApp, String idExecucao, String taskName) throws RemoteException {

        try {

            Connection con = ConnectionBd.getConnection();
            CollectDao dao = new CollectDao(con);

            if (!isExist(idApp, taskName, con)) {
                AppReference app = new AppReference();
                app.setId(idApp);
                Collect collect = new Collect();
                collect.setAppReference(app);
                collect.setId(idExecucao);
                collect.setTaskName(taskName);
                collect.setTypeData(TypeData.TaskCont);
                dao.cadastrar(collect);
                con.close();
                
            }
            
            else dao.setCont(idApp, taskName);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewTaskIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
