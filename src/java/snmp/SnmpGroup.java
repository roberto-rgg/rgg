/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snmp;

/**
 *
 * @author Roberto
 */
public class SnmpGroup {

    private SnmpObject[] snmpObjects;

    public SnmpGroup() {
    }

    public SnmpGroup(SnmpObject[] snmpObjects) {
        this.snmpObjects = snmpObjects;
    }

    public int size(){
        return snmpObjects.length;
    }
    
    public SnmpObject[] getSnmpObjects() {
        return snmpObjects;
    }

    public void setSnmpObjects(SnmpObject[] snmpObjects) {
        this.snmpObjects = snmpObjects;
    }

}
