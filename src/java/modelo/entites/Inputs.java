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
public class Inputs {
    
    private int id;
    private Date timeStamp;
    private double outputVoltage;
    private double outputsCurrent;
    private double tempCabinet;
    private double fuelLevel;
    private double remoteStart;

    public Inputs() {
    }

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

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public double getOutputsCurrent() {
        return outputsCurrent;
    }

    public void setOutputsCurrent(double outputsCurrent) {
        this.outputsCurrent = outputsCurrent;
    }

    public double getTempCabinet() {
        return tempCabinet;
    }

    public void setTempCabinet(double tempCabinet) {
        this.tempCabinet = tempCabinet;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getRemoteStart() {
        return remoteStart;
    }

    public void setRemoteStart(double remoteStart) {
        this.remoteStart = remoteStart;
    }
    
    
    
}
