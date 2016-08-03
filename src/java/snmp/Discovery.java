/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snmp;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * Clase encargada de realizar el discovery de los nodos.
 *
 * @author Roberto
 */
public class Discovery {

    private InetAddress ping;

    public boolean nodoIsOnline(String ip) {
        boolean online = false;
        try {
            ping = InetAddress.getByName(ip);
            if (ping.isReachable(5000)) {
                online = true;
            } 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return online;
    }
}
