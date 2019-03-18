/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alann
 */
public class ConnectionBd {

    private static final String USER = "postgres";
    private static final String SENHA = "ala91494924";
    private static final String URL = "jdbc:postgresql://localhost:5432/bd-servidor";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(URL, USER, SENHA);
        return con;
    }
    
    

}
