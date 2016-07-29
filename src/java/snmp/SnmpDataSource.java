package snmp;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entites.FuelCell;
import modelo.entites.Nodo;

/**
 * Clase encargada de traer la información desde SnmpCommunication.
 * @author Roberto
 */
public class SnmpDataSource {

    private FuelCell celda;
    private SnmpCommunication com;
    private SnmpCommunication.SnmpCustomResponse respuestaSnmp;
    private List<SnmpObject> snmpObjects;

    public SnmpDataSource() {
    }

    public SnmpDataSource(List<SnmpObject> snmpObjects) {
        this.snmpObjects = snmpObjects;
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
    
    /**
     * Metodo de prueba no trae ningun dato real.
     * @return 
     */
    public String retrieveSnmpValueTEST(String oid) {
        return "valor de prueba";
    }
    
    public String retriveSnmpValue(String oid){
        try {
             respuestaSnmp = com.sendGetProccess(oid);
             snmpObjects = respuestaSnmp.getSnmpvariables();
        } catch (IOException ex) {
            Logger.getLogger(SnmpDataSource.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return respuestaSnmp.getVariable().toString();
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
    public void buildCelda(Nodo nodo) {
        this.celda = new FuelCell();
/**
        celda.setInputsFuelLevel(10.2);
        celda.setInputsOutputVoltage(48.9);
        celda.setInputsOututsCurrent(5.5);
        celda.setInputsRemoteStart(23);
        celda.setInputsTempCabinet(40);

        celda.setColdWeatherkitPresent(23);
        celda.setFloatVoltage(34.9);
        celda.setId(1);
        celda.setLimitHeaters500w(450);
        celda.setLowFuelLevelSetpoint(15);
        celda.setMaintenceHour(200);
        celda.setMaxBatteryCurrent(2.3);
        celda.setStartVoltageFirstStack(30);
        celda.setStartVoltageSecondStack(36);
        celda.setTimeBetweenFilterMaint(10.6);
        celda.setRuntimeMainBoardConnected(true);
        celda.setRuntimeSystemDoorOpen(false);
        celda.setRuntimeSystemFault(2);
        celda.setRuntimeSystemNeedsPowerCycle(30);
        celda.setRuntimeSystemState(5);
        celda.setRuntimeSystemWarnnig(3);

        celda.setGrossPower(23);
        celda.setLowFuel(false);
        celda.setNetKilowattHour(2300);
        celda.setOutOfFuel(false);
        celda.setOutputCurrrent(2.3);
        celda.setOutputVoltage(52);
        celda.setStackFaulted(true);
        celda.setSystemFaulted(false);
        celda.setSystemOnline(true);
        celda.setSystemStateDesc("Descripcion ejemplo");
        celda.setTotalSystemCycles(20);
        celda.setTotalSystemRuntime(230.4);

        celda.setSystemNetKilowattHours(23.8);
        celda.setSystemNumPowerDemands(30);
        celda.setSystemTimeUntilFilterMaint(10.2);
        celda.setSystemTotalSystemCycles(20);
        celda.setTotalSystemRuntime(20.3);

        celda.setGmtOffsetHours(23);
        celda.setGmtOffsetQuarter(3);
        celda.setGpsLatitude("-33333333333");
        celda.setGpsLongitud("-34322222");
        celda.setId(1);
        celda.setSystemPartNumber("serial ballard");
        celda.setSystemPartNumber("partn number");
        celda.setSystemSerial("233444-serial");
        celda.setSystemTimeLocal(4);
        celda.setNodo(nodo);
**/
    }

    public SnmpDataSource(Nodo nodo) {
        this.celda = new FuelCell();
/**
        this.celda = new FuelCell();

        celda.setInputsFuelLevel(10.2);
        celda.setInputsOutputVoltage(48.9);
        celda.setInputsOututsCurrent(5.5);
        celda.setInputsRemoteStart(23);
        celda.setInputsTempCabinet(40);

        celda.setColdWeatherkitPresent(23);
        celda.setFloatVoltage(34.9);
        celda.setId(1);
        celda.setLimitHeaters500w(450);
        celda.setLowFuelLevelSetpoint(15);
        celda.setMaintenceHour(200);
        celda.setMaxBatteryCurrent(2.3);
        celda.setStartVoltageFirstStack(30);
        celda.setStartVoltageSecondStack(36);
        celda.setTimeBetweenFilterMaint(10.6);
        celda.setRuntimeMainBoardConnected(true);
        celda.setRuntimeSystemDoorOpen(false);
        celda.setRuntimeSystemFault(2);
        celda.setRuntimeSystemNeedsPowerCycle(30);
        celda.setRuntimeSystemState(5);
        celda.setRuntimeSystemWarnnig(3);

        celda.setGrossPower(23);
        celda.setLowFuel(false);
        celda.setNetKilowattHour(2300);
        celda.setOutOfFuel(false);
        celda.setOutputCurrrent(2.3);
        celda.setOutputVoltage(52);
        celda.setStackFaulted(true);
        celda.setSystemFaulted(false);
        celda.setSystemOnline(true);
        celda.setSystemStateDesc("Descripcion ejemplo");
        celda.setTotalSystemCycles(20);
        celda.setTotalSystemRuntime(230.4);

        celda.setSystemNetKilowattHours(23.8);
        celda.setSystemNumPowerDemands(30);
        celda.setSystemTimeUntilFilterMaint(10.2);
        celda.setSystemTotalSystemCycles(20);
        celda.setTotalSystemRuntime(20.3);

        celda.setGmtOffsetHours(23);
        celda.setGmtOffsetQuarter(3);
        celda.setGpsLatitude("-33333333333");
        celda.setGpsLongitud("-34322222");
        celda.setId(1);
        celda.setSystemPartNumber("serial ballard");
        celda.setSystemPartNumber("partn number");
        celda.setSystemSerial("233444-serial");
        celda.setSystemTimeLocal(4);
        celda.setNodo(nodo);
**/
        //buildCelda(nodo);
    }
    
    public static String valueOid(int id){
        for(EnumFuelCell e : EnumFuelCell.values()) {
            if(e.getId()==id){
                return e.getOid();
            }
        }
        return null;
    }

    public FuelCell getCelda() {
        this.celda = new FuelCell();
        
        celda.setFuelConsumption(1.1);
        celda.setNominalVoltage(24);
        celda.setPowerRating(2.5);
        celda.setStandByConsumPowerPeek(1000);
        celda.setStandByPowerConsumAverage(275);
        celda.setSysDescrib("Sistema celda descripcion");
        celda.setSysLocation("cerro los placeres");
        celda.setSysName("rgg");
        celda.setGpsLatitude(-333333333);
        celda.setGpsLongitud(34322222);
        celda.setId(1);
        celda.setSystemPartNumber("serial ballard");
        celda.setSystemPartNumber("partn number");
        celda.setSystemSerial("233444-serial");
        return celda;
    }

    public void setCelda(FuelCell celda) {
        this.celda = celda;
    }

    public List<SnmpObject> getSnmpObjects() {
        return snmpObjects;
    }

    public void setSnmpObjects(List<SnmpObject> snmpObjects) {
        this.snmpObjects = snmpObjects;
    }

}
