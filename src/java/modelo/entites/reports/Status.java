/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entites.reports;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class Status {

    private int id;
    private Date timeStamp;
    private String SystemStateDesc;
    private boolean systemOnline;
    private boolean systemFaulted;
    private boolean stackFaulted;
    private boolean lowFuel;
    private boolean outOfFuel;
    private int totalSystemCycles;
    private double totalSystemRuntime;
    private double netKilowattHour;
    private double outputVoltage;
    private double outputCurrrent;
    private double grossPower;

    public Status() {
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

    public String getSystemStateDesc() {
        return SystemStateDesc;
    }

    public void setSystemStateDesc(String SystemStateDesc) {
        this.SystemStateDesc = SystemStateDesc;
    }

    public boolean isSystemOnline() {
        return systemOnline;
    }

    public void setSystemOnline(boolean systemOnline) {
        this.systemOnline = systemOnline;
    }

    public boolean isSystemFaulted() {
        return systemFaulted;
    }

    public void setSystemFaulted(boolean systemFaulted) {
        this.systemFaulted = systemFaulted;
    }

    public boolean isStackFaulted() {
        return stackFaulted;
    }

    public void setStackFaulted(boolean stackFaulted) {
        this.stackFaulted = stackFaulted;
    }

    public boolean isLowFuel() {
        return lowFuel;
    }

    public void setLowFuel(boolean lowFuel) {
        this.lowFuel = lowFuel;
    }

    public boolean isOutOfFuel() {
        return outOfFuel;
    }

    public void setOutOfFuel(boolean outOfFuel) {
        this.outOfFuel = outOfFuel;
    }

    public int getTotalSystemCycles() {
        return totalSystemCycles;
    }

    public void setTotalSystemCycles(int totalSystemCycles) {
        this.totalSystemCycles = totalSystemCycles;
    }

    public double getTotalSystemRuntime() {
        return totalSystemRuntime;
    }

    public void setTotalSystemRuntime(double totalSystemRuntime) {
        this.totalSystemRuntime = totalSystemRuntime;
    }

    public double getNetKilowattHour() {
        return netKilowattHour;
    }

    public void setNetKilowattHour(double netKilowattHour) {
        this.netKilowattHour = netKilowattHour;
    }

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public double getOutputCurrrent() {
        return outputCurrrent;
    }

    public void setOutputCurrrent(double outputCurrrent) {
        this.outputCurrrent = outputCurrrent;
    }

    public double getGrossPower() {
        return grossPower;
    }

    public void setGrossPower(double grossPower) {
        this.grossPower = grossPower;
    }

}
