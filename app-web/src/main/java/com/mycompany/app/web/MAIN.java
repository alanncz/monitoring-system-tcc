/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.web;

import alann.tcc.shared.modelView.Tarefa;
import alann.tcc.shared.modelView.TarefaDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alann
 */
public class MAIN {
    
    public static void main(String [] args) throws ClassNotFoundException, SQLException{
        
        String idApp = "3da5b14ec5e34f3ca8a8319dfe9702ff";
        
        TarefaDao dao = new TarefaDao();
        
        System.out.println("CHEGOU AQUI DOIDO");
        
        ArrayList<Tarefa> lista = (ArrayList) dao.listarTarefas(idApp);
        System.out.println(lista.size());
        
        
    }
    
}
