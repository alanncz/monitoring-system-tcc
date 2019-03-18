/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.shared.modelView;

import alann.tcc.shared.dao.ConnectionBd;
import alann.tcc.shared.model.CollectMemoryInfo;
import alann.tcc.shared.model.CollectSizePacketInfo;
import alann.tcc.shared.model.CollectThreadInfo;
import alann.tcc.shared.model.CollectTimeInfo;
import alann.tcc.shared.model.DataMemoryCollect;
import alann.tcc.shared.model.DataSizePacketCollect;
import alann.tcc.shared.model.DataThreadCollect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alann
 */
public class TarefaDao {

    private Connection con;

    public TarefaDao() throws ClassNotFoundException, SQLException {
        this.con = ConnectionBd.getConnection();
    }

    public List<Tarefa> listarTarefas(String idApp) throws SQLException {

        String sql = "select * from app" + idApp;

        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Tarefa> tarefas = new ArrayList();

        while (rs.next()) {

            Tarefa tarefa = new Tarefa();
            tarefa.setNome(rs.getString("tarefa"));
            tarefa.setQtda_execucao(rs.getInt("qtda_execucao"));

            String sql1 = "select * from ids" + idApp + " where tarefa=?";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, rs.getString("tarefa"));
            ResultSet rs1 = stmt1.executeQuery();
            
            while (rs1.next()) {
                Execucao execucao = new Execucao();
                execucao.setId(rs1.getString("id"));
                execucao.setCollectMemoryInfo(getCollectMemoryInfo(execucao, idApp));
                execucao.setCollectThreadInfo(getCollectThreadInfo(execucao, idApp));
                execucao.settCollectSizePacketInfo(getCollectSizePacketInfo(execucao, idApp));
                execucao.setCollectTimeInfo(getCollectTimeInfo(execucao, idApp));

                tarefa.getListExecucoes().add(execucao);
            }
            
            tarefas.add(tarefa);

        }

        return tarefas;
    }

    private CollectMemoryInfo getCollectMemoryInfo(Execucao execucao, String idApp) throws SQLException {

        String sql = "select * from me" + idApp + " where id=?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, execucao.getId());

        ResultSet rs = stmt.executeQuery();

        CollectMemoryInfo cmi = new CollectMemoryInfo();

        while (rs.next()) {
            DataMemoryCollect dmc = new DataMemoryCollect();
            dmc.setIp(rs.getString("ip"));
            dmc.setEndMemory(Long.parseLong(rs.getString("end_memory")));
            dmc.setInitMemory(Long.parseLong(rs.getString("init_memory")));
            dmc.memoryUsada();
            cmi.getCollections().add(dmc);
        }

        return cmi;
    }

    private CollectThreadInfo getCollectThreadInfo(Execucao execucao, String idApp) throws SQLException {

        String sql = "select * from th" + idApp + " where id=?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, execucao.getId());

        ResultSet rs = stmt.executeQuery();

        CollectThreadInfo cti = new CollectThreadInfo();

        while (rs.next()) {
            DataThreadCollect dtc = new DataThreadCollect();
            dtc.setIp(rs.getString("ip"));
            dtc.setEndThreads(rs.getInt("end_threads"));
            dtc.setInitThreads(rs.getInt("init_threads"));
            dtc.setInstanceThreads(rs.getInt("instance_threads"));
            cti.getCollections().add(dtc);
        }

        return cti;
    }

    private CollectSizePacketInfo getCollectSizePacketInfo(Execucao execucao, String idApp) throws SQLException {

        String sql = "select * from sp" + idApp + " where id=?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, execucao.getId());

        ResultSet rs = stmt.executeQuery();

        CollectSizePacketInfo cspi = new CollectSizePacketInfo();

        while (rs.next()) {
            DataSizePacketCollect dspc = new DataSizePacketCollect();
            dspc.setIp(rs.getString("ip"));
            dspc.setDataInput(rs.getInt("data_input"));
            dspc.setDataOutput(rs.getInt("data_output"));
            cspi.getCollections().add(dspc);
        }

        return cspi;
    }

    private CollectTimeInfo getCollectTimeInfo(Execucao execucao, String idApp) throws SQLException {

        String sql = "select * from ti" + idApp + " where id=?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, execucao.getId());

        ResultSet rs = stmt.executeQuery();

        CollectTimeInfo cti = new CollectTimeInfo();

        rs.next();
        cti.setInitTime(Timestamp.valueOf(rs.getString("init_time")));
        cti.setEndTime(Timestamp.valueOf(rs.getString("end_time")));

        cti.getIps().add(rs.getString("init_ip"));
        cti.getIps().add(rs.getString("end_ip"));
        cti.milisegundos();

        return cti;
    }

}
