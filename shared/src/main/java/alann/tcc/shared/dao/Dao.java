/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.dao;

import java.util.List;

/**
 *
 * @author alann
 * @param <T>
 */
public interface Dao <T> {
    
    public boolean cadastrar(T objeto);
    public boolean remover(String pesquisa);
    public T buscar(String pesquisa);
    public List<T> listar();
    
}
