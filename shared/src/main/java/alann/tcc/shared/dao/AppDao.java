/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */
public class AppDao implements Dao<AppReference> {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return ConnectionBd.getConnection();
    }

    @Override
    public boolean cadastrar(AppReference objeto) {
        try {
            String sql = "insert into app (id,nome,id_usuario) values (?,?,?)";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getUsuario().getId());
            stmt.execute();
            createTable(objeto.getId());
            stmt.close();
            con.close();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean remover(String pesquisa) {
        try {
            String sql = "delete from app where id=?";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.execute();
            stmt.close();
            con.close();
            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public AppReference buscar(String pesquisa) {

        AppReference app = new AppReference();
        try {
            String sql = "select * from App where id=?";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pesquisa);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            UserDao daoUsuario = new UserDao();
            User usuario = (User) daoUsuario.buscar(rs.getInt("id_usuario"));

            app.setNome(rs.getString("nome"));
            app.setId(rs.getString("id"));
            app.setUsuario(usuario);

            stmt.close();
            con.close();
            return app;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return app;
        }
    }

    @Override
    public List<AppReference> listar() {

        List<AppReference> apps = new ArrayList<>();

        try {
            String sql = "select * from app";

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                UserDao daoUsuario = new UserDao();
                User usuario = (User) daoUsuario.buscar(rs.getInt("id_usuario"));

                AppReference app = new AppReference();
                app.setNome(rs.getString("nome"));
                app.setId(rs.getString("id"));
                app.setUsuario(usuario);

                apps.add(app);
            }
            stmt.close();
            con.close();
            return apps;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return apps;
        }
    }

    public List<AppReference> listar(int idUser) {

        List<AppReference> apps = new ArrayList<>();

        try {
            String sql = "select * from app where id_usuario=?";

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUser);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Dao daoUsuario = new UserDao();
                User usuario = (User) daoUsuario.buscar(rs.getString("id_usuario"));

                AppReference app = new AppReference();
                app.setNome(rs.getString("nome"));
                app.setId(rs.getString("id"));
                app.setUsuario(usuario);

                apps.add(app);
            }
            stmt.close();
            con.close();
            return apps;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return apps;
        }
    }

    private void createTable(String idApp) throws ClassNotFoundException, SQLException {

        Statement stmt;
        

        String query0 = "create table app" + idApp    //tabela referente a execucao de uma tarefa
                + "(tarefa varchar PRIMARY KEY,"
                + "qtda_execucao integer) ";
        
        String query1 = "create table ids" + idApp    //tabela referente aos ids de execucao
                + "(id varchar PRIMARY KEY,"
                + "tarefa varchar)         ";

        String query2 = "create table th" + idApp    //tabela de dados relacionados a threads de uma execucao de uma tarefa
                + "(id varchar,              "
                + "tarefa varchar,           "
                + "data varchar,           "
                + "ip varchar,               "
                + "init_threads integer,     "
                + "end_threads integer,      "
                + "instance_threads integer) ";   
        
        String query3 = "create table me" + idApp    //tabela de dados relacionados a memoria de uma execucao de uma tarefa
                + "(id varchar,           "
                + "tarefa varchar,           "
                + "data varchar,           "
                + "ip varchar,        "
                + "init_memory varchar,  "
                + "end_memory varchar)  ";

        
        String query4 = "create table sp" + idApp   //tabela de dados relacionados a tamanho de pacotes de uma execucao de uma tarefa
                + "(id varchar,           "
                + "tarefa varchar,           "
                + "data varchar,           "
                + "ip varchar, "
                + "data_input integer, "
                + "data_output integer) ";
        
        String query5 = "create table ti" + idApp   //tabela de dados relacionados a tempo de uma execucao de uma tarefa
                + "(id varchar,           "
                + "tarefa varchar,           "
                + "data varchar,           "
                + "init_ip varchar, "
                + "end_ip varchar, "
                + "init_time varchar, "
                + "end_time varchar) ";
        
        int cont = 0;
        
        List<String> listBD = new ArrayList();
        listBD.add(cont, query0);
        listBD.add(cont + 1, query1);
        listBD.add(cont + 2, query2);
        listBD.add(cont + 3, query3);
        listBD.add(cont + 4, query4);
        listBD.add(cont + 5, query5);
        
        String fk1 = "ALTER TABLE th" +idApp + " ADD CONSTRAINT fk_app FOREIGN KEY (tarefa) REFERENCES app" + idApp + " (tarefa) ON DELETE CASCADE;";
        String fk2 = "ALTER TABLE me" +idApp + " ADD CONSTRAINT fk_app FOREIGN KEY (tarefa) REFERENCES app" + idApp + " (tarefa) ON DELETE CASCADE;";
        String fk3 = "ALTER TABLE sp" +idApp + " ADD CONSTRAINT fk_app FOREIGN KEY (tarefa) REFERENCES app" + idApp + " (tarefa) ON DELETE CASCADE;";
        String fk4 = "ALTER TABLE ti" +idApp + " ADD CONSTRAINT fk_app FOREIGN KEY (tarefa) REFERENCES app" + idApp + " (tarefa) ON DELETE CASCADE;";
        String fk5 = "ALTER TABLE ids" +idApp + " ADD CONSTRAINT fk_app FOREIGN KEY (tarefa) REFERENCES app" + idApp + " (tarefa) ON DELETE CASCADE;";
        
        listBD.add(cont + 6, fk1);
        listBD.add(cont + 7, fk2);
        listBD.add(cont + 8, fk3);
        listBD.add(cont + 9, fk4);

        try (Connection con = getConnection()) {
            
            stmt = con.createStatement();
            for(int k = 0; k < listBD.size(); k++){
                stmt.executeUpdate(listBD.get(k));
            }
            stmt.close();
        }
    }

}
