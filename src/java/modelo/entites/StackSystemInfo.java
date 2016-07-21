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
public class StackSystemInfo {
    
    private int id;
    private Date timeStamp;
    private int stackNumber;
    private int SystemstackCycles;
    private double systemStackRuntime;
    private String faultDescription;

    public StackSystemInfo() {
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

    public int getStackNumber() {
        return stackNumber;
    }

    public void setStackNumber(int stackNumber) {
        this.stackNumber = stackNumber;
    }

    public int getSystemstackCycles() {
        return SystemstackCycles;
    }

    public void setSystemstackCycles(int SystemstackCycles) {
        this.SystemstackCycles = SystemstackCycles;
    }

    public double getSystemStackRuntime() {
        return systemStackRuntime;
    }

    public void setSystemStackRuntime(double systemStackRuntime) {
        this.systemStackRuntime = systemStackRuntime;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }
    
}
