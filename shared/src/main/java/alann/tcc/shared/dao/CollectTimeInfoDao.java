/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.CollectTimeInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class CollectTimeInfoDao implements Dao<CollectTimeInfo> {
    
    private Connection con;
    
    public CollectTimeInfoDao(Connection con){
        this.con = con;
    }

    @Override
    public boolean cadastrar(CollectTimeInfo objeto) {
        
        String referenceTabble = "ti" + objeto.getAppReference().getId();

        try {

            String sql = "insert into " + referenceTabble + " (id,init_ip,end_ip,init_time,end_time,tarefa,data) values (?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, objeto.getId());
            stmt.setString(2, objeto.getIps().get(0));
            stmt.setString(3, objeto.getIps().get(1));
            stmt.setString(4, objeto.getInitTime().toString());
            stmt.setString(5, objeto.getEndTime().toString());
            stmt.setString(6, objeto.getTaskName());
            stmt.setString(7, objeto.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(CollectDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
        
    }

    @Override
    public boolean remover(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CollectTimeInfo buscar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CollectTimeInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
