/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import alann.tcc.shared.model.User;
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
public class UserDao implements Dao<User> {

    public UserDao() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return ConnectionBd.getConnection();
    }
    
    public User login(String email, String senha){
        User usuario = buscar(email);
        if (usuario != null){
            if (usuario.getSenha().equals(senha)) return usuario;
        }
        return null;
    }

    @Override
    public boolean cadastrar(User objeto) {
        try {
            String sql = "insert into usuario (nome,email,senha) values (?,?,?)";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmail());
            stmt.setString(3, objeto.getSenha());
            stmt.execute();
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
            String sql = "delete from usuario where email=?";
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
    public User buscar(String pesquisa) {

        try {
            String sql = "select * from usuario where email=?";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pesquisa);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            User usuario = new User();
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setId(rs.getInt("id"));

            stmt.close();
            con.close();
            return usuario;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public User buscar(int id_usuario) {

        User usuario = new User();
        try {
            String sql = "select * from usuario where id=?";
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_usuario);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setId(rs.getInt("id"));

            stmt.close();
            con.close();
            return usuario;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        }
    }

    @Override
    public List<User> listar() {

        List<User> usuarios = new ArrayList<>();

        try {
            String sql = "select * from usuario";

            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User usuario = new User();
                usuario.setEmail(rs.getString("email"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setId(rs.getInt("id"));

                usuarios.add(usuario);
            }
            stmt.close();
            con.close();
            return usuarios;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return usuarios;
        }
    }

}
