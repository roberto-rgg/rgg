package snmp;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entites.FuelCell;
import modelo.entites.Nodo;
import org.snmp4j.mp.SnmpConstants;

/**
 * Clase encargada de traer la información desde SnmpCommunication.
 * @author Roberto
 */
public class SnmpDataSource {

    private FuelCell celda;
    private SnmpCommunication com;
    private String ipAddress;
    private int port;
    private SnmpCommunication.SnmpCustomResponse respuestaSnmp;
    private List<SnmpObject> snmpObjects;

    public SnmpDataSource() {
        
    }

    public SnmpDataSource(String ipAddress, int port) {
        com = new SnmpCommunication("public", "public1", SnmpConstants.version2c, ipAddress, port);
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public SnmpDataSource(List<SnmpObject> snmpObjects) {
        this.snmpObjects = snmpObjects;
    }
    
    public boolean isOnline(){
        Discovery d = new Discovery();
       // return d.nodoIsOnline(ipAddress);
       return true;
    }
    
    public boolean retrieveSnmpData() {
        try {
             respuestaSnmp = com.sendGetBashProccess(snmpObjects);
             snmpObjects = respuestaSnmp.getSnmpvariables();
        } catch (IOException ex) {
            Logger.getLogger(SnmpDataSource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return respuestaSnmp.isErrorResponse();
    }
    
    public String retrieveSnmpValue(String oid){
       
        if(oid.equals(FuelCell.TEST_VALUE_STRING)) {
            return FuelCell.TEST_VALUE_STRING;
        }
        if(oid.equals(FuelCell.TEST_VALUE_DOUBLE)) {
            return FuelCell.TEST_VALUE_DOUBLE;
        }
        if(oid.equals(FuelCell.TEST_VALUE_INT)) {
            return FuelCell.TEST_VALUE_INT;
        }
        try {
             respuestaSnmp = com.sendGetProccess(oid);
             snmpObjects = respuestaSnmp.getSnmpvariables();
        } catch (IOException ex) {
            Logger.getLogger(SnmpDataSource.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        if(respuestaSnmp.getVariable()==null) {
            return "valor nulo desde fuente snmp";
        }
        return respuestaSnmp.getVariable().toString();
    }
    
    public String retrieveSnmpValue(int oid){
       return "no implenetado";
    }
    
    public int retriveIntegerValue(String oid){
        try {
             respuestaSnmp = com.sendGetProccess(oid);
             snmpObjects = respuestaSnmp.getSnmpvariables();
        } catch (IOException ex) {
            Logger.getLogger(SnmpDataSource.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return -1;
    }

    public String getSnmpValue(int id) {
        for(SnmpObject o : snmpObjects) {
            if(o.getId()==id) {
                return o.getValor();
            }
        }
        return null;
    }
    
    public String getSnmpValue(String oid) {
        for(SnmpObject o : snmpObjects) {
            if(o.getOid().equals(oid)) {
                return o.getValor();
            }
        }
        return null;
    }
    
   
    public static String valueOid(int id){
        for(EnumFuelCell e : EnumFuelCell.values()) {
            if(e.getId()==id){
                return e.getOid();
            }
        }
        return null;
    }

  

    public List<SnmpObject> getSnmpObjects() {
        return snmpObjects;
    }

    public void setSnmpObjects(List<SnmpObject> snmpObjects) {
        this.snmpObjects = snmpObjects;
    }

}
