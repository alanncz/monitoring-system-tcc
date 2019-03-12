/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.Collect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class IdsDao {

    private Connection con;

    public IdsDao(Connection con) {
        this.con = con;
    }

    public boolean cadastrar(Collect objeto)  {

        String referenceTabble = "ids" + objeto.getAppReference().getId();

        if (isId(referenceTabble, objeto.getId())) {

            try {

                String sql = "insert into " + referenceTabble + " (id,tarefa) values (?,?)";

                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setString(1, objeto.getId());
                stmt.setString(2, objeto.getTaskName());
                stmt.execute();
                stmt.close();

            } catch (SQLException ex) {
                Logger.getLogger(CollectDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;

    }

    private boolean isId(String id, String idCollect) {

        try {
            
            String sql = "select * from " + id + " where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, idCollect);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(IdsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
