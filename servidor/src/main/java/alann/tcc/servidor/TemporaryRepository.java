/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alann.tcc.servidor;

import alann.tcc.shared.model.Collect;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alann
 */

public class TemporaryRepository {

    private static LinkedBlockingQueue<Collect> LISTSENDCOLLECT = new LinkedBlockingQueue();

    public static Collect get() {

        Collect data = null;
        try {
            data = LISTSENDCOLLECT.take();
        } catch (InterruptedException ex) {
            Logger.getLogger(TemporaryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }

    public static void set(Collect data) {
        try {
            LISTSENDCOLLECT.put(data);
        } catch (InterruptedException ex) {
            Logger.getLogger(TemporaryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LinkedBlockingQueue<Collect> getLISTSENDCOLLECT() {
        return LISTSENDCOLLECT;
    }

}