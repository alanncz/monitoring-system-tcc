/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.CollectSizePacketInfo;
import alann.tcc.shared.model.DataSizePacketCollect;
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
public class CollectSizePacketInfoDao implements Dao<CollectSizePacketInfo> {
    
    private Connection con;
    
    public CollectSizePacketInfoDao(Connection con){
        this.con = con;
    }
    
    @Override
    public boolean cadastrar(CollectSizePacketInfo objeto) {
        
        String referenceTabble = "sp" + objeto.getAppReference().getId();

        try {
            
            String sql = "insert into " + referenceTabble + " (id,ip,data_input,data_output,tarefa,data) values (?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            List<DataSizePacketCollect> lista = objeto.getCollections();
            
            for (int k = 0; k < lista.size(); k++) {
                
                int outPut = lista.get(k).getDataOutput();
                int inPut = lista.get(k).getDataInput();
                
                stmt.setString(1, objeto.getId());
                stmt.setString(2, lista.get(k).getIp());
                stmt.setInt(3, inPut);
                stmt.setInt(4, outPut);
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
    public CollectSizePacketInfo buscar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CollectSizePacketInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
