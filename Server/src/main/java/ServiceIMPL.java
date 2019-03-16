
import alann.tcc.api.MonitoringServicesMemory;
import alann.tcc.api.MonitoringServicesSizePacket;
import alann.tcc.api.MonitoringServicesThread;
import alann.tcc.api.MonitoringServicesTime;
import alann.tcc.api.RegistryId;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alann
 */
public class ServiceIMPL implements Service {

    private static ArrayList<Pessoa> pessoas = new ArrayList();
    private static ArrayList<List> listas = new ArrayList();
    private static ArrayList<String> lixo = new ArrayList();
    

    public ServiceIMPL() {
    }

    @Override
    public void newPessoa(RegistryId rid, Pessoa pessoa) throws RemoteException {

        try {

            MonitoringServicesTime.endTime(rid);
            MonitoringServicesMemory.initMemory(rid);
            MonitoringServicesThread.initQtdaThread(rid);

            Pessoa p = new Pessoa();
            p.setNome(pessoa.getNome());
            p.setIdade(pessoa.getIdade());
            pessoas.add(p);

            MonitoringServicesSizePacket.dataInput(rid, pessoa, true, true);
            MonitoringServicesMemory.endMemory(rid, true);
            MonitoringServicesThread.endQtdaThread(rid, true);

            System.out.println("chegou aqui");
            String nome = pessoa.getNome();
            System.out.println(nome);

        } catch (IOException ex) {
            Logger.getLogger(ServiceIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<Integer> numerosPrimos(RegistryId rid, Integer numero) throws RemoteException {

        try {

            MonitoringServicesTime.endTime(rid);
            MonitoringServicesMemory.initMemory(rid);
            MonitoringServicesSizePacket.dataInput(rid, numero, false , false);
            MonitoringServicesThread.initQtdaThread(rid);

            ArrayList<Integer> lista = new ArrayList();
            for (int i = 2; i <= numero; i++) {
                if (isPrimo(i)) {
                    lista.add(i);
                }
            }
            
            memory(numero);

            listas.add(lista);
            
            MonitoringServicesSizePacket.dataOutPut(rid, lista, false, false);
            MonitoringServicesMemory.endMemory(rid, false);
            MonitoringServicesThread.endQtdaThread(rid, true);
            
            return lista;

        } catch (UnknownHostException ex) {
            Logger.getLogger(ServiceIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

    public static boolean isPrimo(int valor) {
        for (int j = 2; j < valor; j++) {
            if (valor % j == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void memory(Integer numero) {
        while (numero != 0) {
           lixo.add(new String("Kabum"));
           numero --;
        }
    }

}
