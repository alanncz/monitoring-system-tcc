/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.web;

import alann.tcc.shared.model.User;
import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.dao.AppDao;
import alann.tcc.shared.dao.Dao;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alann
 */
@WebServlet(name = "/CadastroApp")
public class CadastroApp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UUID uuid = UUID.randomUUID();
        String strUuid = uuid.toString().replace("-", "");

        String nomeApp = request.getParameter("nomeApp");

        System.out.println(strUuid);
        System.out.println(nomeApp);

        HttpSession session = request.getSession();
        
        int id_usuario = (int) session.getAttribute("id");
        String nome_usuario = (String) session.getAttribute("nome");
        String email_usuario = (String) session.getAttribute("email");

        User usuario = new User();
        usuario.setId(id_usuario);
        usuario.setNome(nome_usuario);
        usuario.setEmail(email_usuario);
        
        AppReference app = new AppReference();
        app.setId(strUuid);
        app.setNome(nomeApp);
        app.setUsuario(usuario);

        Dao dao = new AppDao();
        dao.cadastrar(app);
        LoadingProfile.updateListApps(session, usuario);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
