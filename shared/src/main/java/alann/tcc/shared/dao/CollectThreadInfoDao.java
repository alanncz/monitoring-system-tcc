/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.CollectThreadInfo;
import alann.tcc.shared.model.DataThreadCollect;
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
public class CollectThreadInfoDao implements Dao<CollectThreadInfo> {

    private Connection con;

    public CollectThreadInfoDao(Connection con) {
        this.con = con;
    }

    @Override
    public boolean cadastrar(CollectThreadInfo objeto) {

        String referenceTabble = "th" + objeto.getAppReference().getId();

        try {
            
            String sql = "insert into " + referenceTabble + " (id,ip,init_threads,end_threads,instance_threads,tarefa,data) values (?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            List<DataThreadCollect> lista = objeto.getCollections();
            
            for (int k = 0; k < lista.size(); k++) {
                stmt.setString(1, objeto.getId());
                stmt.setString(2, lista.get(k).getIp());
                stmt.setInt(3, lista.get(k).getInitThreads());
                stmt.setInt(4, lista.get(k).getEndThreads());
                stmt.setInt(5, lista.get(k).getInstanceThreads());
                stmt.setString(6, objeto.getTaskName());
                stmt.setString(7, objeto.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                stmt.execute();
            }
            
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean remover(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CollectThreadInfo buscar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CollectThreadInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
