
package snmp;

import java.util.Date;
import modelo.entites.Celda;
import modelo.entites.Inputs;
import modelo.entites.Nodo;
import modelo.entites.Parametros;
import modelo.entites.RuntimeData;
import modelo.entites.StackFault;
import modelo.entites.StackSystemInfo;
import modelo.entites.Status;
import modelo.entites.SystemFault;
import modelo.entites.SystemInfo;
import modelo.entites.SystemWarning;

/**
 *
 * @author Roberto
 */
public class SnmpDataSource {
    
    private Celda celda;

    private void buildCelda(Nodo nodo){
        celda = new Celda();
        Inputs input = new Inputs();
        Parametros parametros = new Parametros();
        RuntimeData runtimeData = new RuntimeData();
        StackFault stackFault = new StackFault();
        StackSystemInfo stackSystemInfo = new StackSystemInfo();
        Status status = new Status();
        SystemFault systemfault = new SystemFault();
        SystemInfo systemInfo = new SystemInfo();
        SystemWarning systemWarning = new SystemWarning();
        
        input.setId(1);
        input.setFuelLevel(10.2);
        input.setOutputVoltage(48.9);
        input.setOutputsCurrent(5.5);
        input.setRemoteStart(23);
        input.setTempCabinet(40);
        input.setTimeStamp(new Date());
        celda.setInputs(input);
        parametros.setColdWeatherkitPresent(23);
        parametros.setFloatVoltage(34.9);
        parametros.setId(1);
        parametros.setLimitHeaters500w(450);
        parametros.setLowFuelLevelSetpoint(15);
        parametros.setMaintenceHour(200);
        parametros.setMaxBatteryCurrent(2.3);
        parametros.setStartVoltageFirstStack(30);
        parametros.setStartVoltageSecondStack(36);
        parametros.setTimeBetweenFilterMaint(10.6);
        parametros.setTimeStamp(new Date());
        celda.setParametros(parametros);
        runtimeData.setId(1);
        runtimeData.setRuntimeMainBoardConnected(true);
        runtimeData.setRuntimeSystemDoorOpen(false);
        runtimeData.setRuntimeSystemFault(2);
        runtimeData.setRuntimeSystemNeedsPowerCycle(30);
        runtimeData.setRuntimeSystemState(5);
        runtimeData.setRuntimeSystemWarnnig(3);
        runtimeData.setTimeStamp(new Date());
        celda.setRuntimeData(runtimeData);
        stackFault.setFaultDescription("intermitente");
        stackFault.setFaultId(1);
        stackFault.setFaultTime(new Date());
        stackFault.setId(1);
        stackFault.setStacknumber(1);
        celda.setStackFault(stackFault);
        stackSystemInfo.setFaultDescription("falla ejemplo");
        stackSystemInfo.setId(1);
        stackSystemInfo.setStackNumber(2);
        stackSystemInfo.setSystemStackRuntime(2.2);
        stackSystemInfo.setSystemstackCycles(34);
        stackSystemInfo.setTimeStamp(new Date());
        celda.setSystemInfo(systemInfo);
        status.setGrossPower(23);
        status.setId(1);
        status.setLowFuel(false);
        status.setNetKilowattHour(2300);
        status.setOutOfFuel(false);
        status.setOutputCurrrent(2.3);
        status.setOutputVoltage(52);
        status.setStackFaulted(true);
        status.setSystemFaulted(false);
        status.setSystemOnline(true);
        status.setSystemStateDesc("Descripcion ejemplo");
        status.setTimeStamp(new Date());
        status.setTotalSystemCycles(20);
        status.setTotalSystemRuntime(230.4);
        celda.setStatus(status);
        systemfault.setFaultDescription("systema falla ejemplo");
        systemfault.setFaultId(2);
        systemfault.setFaultTime(new Date());
        systemfault.setId(1);
        celda.setSystemFault(systemfault);
        systemInfo.setId(1);
        systemInfo.setNetKilowattHours(23.4);
        systemInfo.setNumPowerDemands(30);
        systemInfo.setTimeStamp(new Date());
        systemInfo.setTimeUntilFilterMaint(10.2);
        systemInfo.setTotalSystemCycles(20);
        systemInfo.setTotalSystemRuntime(20.3);
        celda.setSystemInfo(systemInfo);
        systemWarning.setId(1);
        systemWarning.setWarningDescription("advertencia ejemplo");
        systemWarning.setWarningId(4);
        systemWarning.setWarningTime(new Date());
        celda.setSystemWaring(systemWarning);
        
        celda.setGmtOffsetHours(23);
        celda.setGmtOffsetQuarter(3);
        celda.setGpsLatitude("-33333333333");
        celda.setGpsLongitud("-34322222");
        celda.setId(1);
        celda.setSystemPartNumber("serial ballard");
        celda.setSystemPartNumber("partn number");
        celda.setSystemSerial("233444-serial");
        celda.setSystemTimeLocal(4);
        
    }

    public SnmpDataSource(Nodo nodo) {
        buildCelda(nodo);
    }
   
    
    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    
}
