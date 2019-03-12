/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.DataMemoryCollect;
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
public class CollectMemoryInfoDao implements Dao<CollectMemoryInfo> {
    
    private Connection con;
    
    public CollectMemoryInfoDao(Connection con){
        this.con = con;
    }

    @Override
    public boolean cadastrar(CollectMemoryInfo objeto) {
        
        String referenceTabble = "me" + objeto.getAppReference().getId();

        try {
            
            String sql = "insert into " + referenceTabble + " (id,ip,init_memory,end_memory,tarefa,data) values (?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            List<DataMemoryCollect> lista = objeto.getCollections();
            
            for (int k = 0; k < lista.size(); k++) {
                
                String initMemory = String.valueOf(lista.get(k).getInitMemory());
                String endMemory = String.valueOf(lista.get(k).getEndMemory());
                
                stmt.setString(1, objeto.getId());
                stmt.setString(2, lista.get(k).getIp());
                stmt.setString(3, initMemory);
                stmt.setString(4, endMemory);
                stmt.setString(5, objeto.getTaskName());
                stmt.setString(6, objeto.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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
    public CollectMemoryInfo buscar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CollectMemoryInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
