
package snmp;

import modelo.entites.FuelCell;
import modelo.entites.Nodo;

/**
 *
 * @author Roberto
 */
public class SnmpDataSource {
    
    private FuelCell celda;
    private SnmpCommunication com;
    
    public FuelCell findCelda(Nodo nodo){
        
        return null;
    }
    

    public void buildCelda(Nodo nodo){
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
        
    }

    public SnmpDataSource(Nodo nodo) {
        this.celda = new FuelCell();
        
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
        
        //buildCelda(nodo);
    }
   
    
    public FuelCell getCelda() {
        return celda;
    }

    public void setCelda(FuelCell celda) {
        this.celda = celda;
    }
    
    
    
    
}
