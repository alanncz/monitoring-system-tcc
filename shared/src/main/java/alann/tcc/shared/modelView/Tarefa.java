/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.modelView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class Tarefa {
    
    private String nome;
    private int qtda_execucao;
    private List<Execucao> listExecucoes;
    
    public Tarefa(){
        this.listExecucoes = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtda_execucao() {
        return qtda_execucao;
    }

    public void setQtda_execucao(int qtda_execucao) {
        this.qtda_execucao = qtda_execucao;
    }

    public List<Execucao> getListExecucoes() {
        return listExecucoes;
    }

    public void setListExecucoes(List<Execucao> listExecucoes) {
        this.listExecucoes = listExecucoes;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "nome=" + nome + ", qtda_execucao=" + qtda_execucao + ", listExecucoes=" + listExecucoes + '}';
    }
    
    
    
}
