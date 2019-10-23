/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.dao.AppDao;
import alann.tcc.shared.dao.Dao;
import alann.tcc.shared.model.AppReference;
import alann.tcc.shared.services.ConfigurationService;

/**
 *
 * @author alann
 */
public class ConfigurationServiceIMPL implements ConfigurationService {

    @Override
    public AppReference getAppReference(String idApp) {
        Dao appDao = new AppDao();
        AppReference app = (AppReference) appDao.buscar(idApp);
        return app;
    }
    
}
