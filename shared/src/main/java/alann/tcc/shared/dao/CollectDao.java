/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import static alann.tcc.shared.dao.ConnectionBd.getConnection;
import alann.tcc.shared.model.Collect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class CollectDao implements Dao<Collect> {

    private Connection con;

    public CollectDao(Connection con) {
        this.con = con;
    }
    
    public void setCont(String idApp, String taskName) throws SQLException{
        
        String sql1 = "select * from app" + idApp + " where tarefa =?";
        
        int qtda_execucao;
        try (PreparedStatement stmt1 = con.prepareStatement(sql1)) {
            stmt1.setString(1, taskName);
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            qtda_execucao = rs.getInt("qtda_execucao");
        }
        qtda_execucao ++;
        
        String sql2 = "update app" + idApp + " set qtda_execucao = ? where tarefa = ?";
        
        try (PreparedStatement stmt2 = con.prepareStatement(sql2)) {
            stmt2.setInt(1, qtda_execucao);
            stmt2.setString(2, taskName);
            stmt2.executeUpdate();
        }
        
    }

    @Override
    public boolean cadastrar(Collect objeto) {

        String referenceTabble = "app" + objeto.getAppReference().getId();

        try {

            String sql = "insert into " + referenceTabble + " (tarefa,qtda_execucao) values (?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, objeto.getTaskName());
            stmt.setInt(2, 1);
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
    public Collect buscar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Collect> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<String> listar(String idApp){
        
        List<String> tarefas = new ArrayList();

        try {
            
            String sql = "select * from app" + idApp;
            
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                tarefas.add(rs.getString("tarefa"));
            }
            stmt.close();
            con.close();
            return tarefas;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
        
    }

}
