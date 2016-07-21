/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entites;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class RuntimeData {

    private int id;
    private Date timeStamp;
    private int runtimeSystemState;
    private int runtimeSystemFault;
    private int runtimeSystemWarnnig;
    private boolean runtimeSystemDoorOpen;
    private int runtimeSystemNeedsPowerCycle;
    private boolean runtimeMainBoardConnected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getRuntimeSystemState() {
        return runtimeSystemState;
    }

    public void setRuntimeSystemState(int runtimeSystemState) {
        this.runtimeSystemState = runtimeSystemState;
    }

    public int getRuntimeSystemFault() {
        return runtimeSystemFault;
    }

    public void setRuntimeSystemFault(int runtimeSystemFault) {
        this.runtimeSystemFault = runtimeSystemFault;
    }

    public int getRuntimeSystemWarnnig() {
        return runtimeSystemWarnnig;
    }

    public void setRuntimeSystemWarnnig(int runtimeSystemWarnnig) {
        this.runtimeSystemWarnnig = runtimeSystemWarnnig;
    }

    public boolean isRuntimeSystemDoorOpen() {
        return runtimeSystemDoorOpen;
    }

    public void setRuntimeSystemDoorOpen(boolean runtimeSystemDoorOpen) {
        this.runtimeSystemDoorOpen = runtimeSystemDoorOpen;
    }

    public int getRuntimeSystemNeedsPowerCycle() {
        return runtimeSystemNeedsPowerCycle;
    }

    public void setRuntimeSystemNeedsPowerCycle(int runtimeSystemNeedsPowerCycle) {
        this.runtimeSystemNeedsPowerCycle = runtimeSystemNeedsPowerCycle;
    }

    public boolean isRuntimeMainBoardConnected() {
        return runtimeMainBoardConnected;
    }

    public void setRuntimeMainBoardConnected(boolean runtimeMainBoardConnected) {
        this.runtimeMainBoardConnected = runtimeMainBoardConnected;
    }
    
    
}
