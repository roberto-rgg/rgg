
package snmp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public void buildCelda(Nodo nodo){
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
        List<StackFault> stfList = new ArrayList<>();
        stfList.add(stackFault);
        celda.setStackFault(stfList);
        
    }

    public SnmpDataSource() {
       
    }
   
    
    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    
}
