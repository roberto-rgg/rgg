/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entites;

import java.util.List;

/**
 *
 * @author Roberto
 */
public class Celda {
    
    private int id;
    private Nodo nodo;
    private String systemPartNumber;
    private String systemSerial;
    private String gpsLatitude;
    private String gpsLongitud;
    private int gmtOffsetHours;
    private int gmtOffsetQuarter;
    private int systemTimeLocal;
    private List<StackSystemInfo> stacks;
    private Status status;
    private SystemInfo systemInfo;
    private RuntimeData runtimeData;
    private Inputs inputs;
    private Parametros parametros;
    private SystemFault systemFault;
    private SystemWarning systemWaring;
    private StackFault stackFault;

    public Celda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public String getSystemPartNumber() {
        return systemPartNumber;
    }

    public void setSystemPartNumber(String systemPartNumber) {
        this.systemPartNumber = systemPartNumber;
    }

    public String getSystemSerial() {
        return systemSerial;
    }

    public void setSystemSerial(String systemSerial) {
        this.systemSerial = systemSerial;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitud() {
        return gpsLongitud;
    }

    public void setGpsLongitud(String gpsLongitud) {
        this.gpsLongitud = gpsLongitud;
    }

    public int getGmtOffsetHours() {
        return gmtOffsetHours;
    }

    public void setGmtOffsetHours(int gmtOffsetHours) {
        this.gmtOffsetHours = gmtOffsetHours;
    }

    public int getGmtOffsetQuarter() {
        return gmtOffsetQuarter;
    }

    public void setGmtOffsetQuarter(int gmtOffsetQuarter) {
        this.gmtOffsetQuarter = gmtOffsetQuarter;
    }

    public int getSystemTimeLocal() {
        return systemTimeLocal;
    }

    public void setSystemTimeLocal(int systemTimeLocal) {
        this.systemTimeLocal = systemTimeLocal;
    }

    public List<StackSystemInfo> getStacks() {
        return stacks;
    }

    public void setStacks(List<StackSystemInfo> stacks) {
        this.stacks = stacks;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    public RuntimeData getRuntimeData() {
        return runtimeData;
    }

    public void setRuntimeData(RuntimeData runtimeData) {
        this.runtimeData = runtimeData;
    }

    public Inputs getInputs() {
        return inputs;
    }

    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }

    public SystemFault getSystemFault() {
        return systemFault;
    }

    public void setSystemFault(SystemFault systemFault) {
        this.systemFault = systemFault;
    }

    public SystemWarning getSystemWaring() {
        return systemWaring;
    }

    public void setSystemWaring(SystemWarning systemWaring) {
        this.systemWaring = systemWaring;
    }

    public StackFault getStackFault() {
        return stackFault;
    }

    public void setStackFault(StackFault stackFault) {
        this.stackFault = stackFault;
    }

    
}
