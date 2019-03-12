/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.web;

import alann.tcc.shared.dao.AppDao;
import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.model.User;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alann
 */
public class LoadingProfile {

    public static void loadingProfile(HttpSession session, User usuario) {

        AppDao dao = new AppDao();
        List<AppReference> list = dao.listar(usuario.getId());

        session.setAttribute("tamanhoListApps", usuario.getId());
        session.setAttribute("id", usuario.getId());
        session.setAttribute("nome", usuario.getNome());
        session.setAttribute("email", usuario.getEmail());
        session.setAttribute("apps", list);

    }

    public static void updateListApps(HttpSession session, User usuario) {
        AppDao dao = new AppDao();
        List<AppReference> list = dao.listar(usuario.getId());
        session.setAttribute("apps", list);
    }

}
