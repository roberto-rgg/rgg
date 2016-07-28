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
public class Parametros {
    
    private int id;
    private Date timeStamp;
    private int limitHeaters500w;
    private int coldWeatherkitPresent;
    private double lowFuelLevelSetpoint;
    private double startVoltageFirstStack;
    private double startVoltageSecondStack;
    private double floatVoltage;
    private double timeBetweenFilterMaint;
    private double maxBatteryCurrent;
    private int maintenceHour;

    public Parametros() {
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

    public int getLimitHeaters500w() {
        return limitHeaters500w;
    }

    public void setLimitHeaters500w(int limitHeaters500w) {
        this.limitHeaters500w = limitHeaters500w;
    }

    public int getColdWeatherkitPresent() {
        return coldWeatherkitPresent;
    }

    public void setColdWeatherkitPresent(int coldWeatherkitPresent) {
        this.coldWeatherkitPresent = coldWeatherkitPresent;
    }

    public double getLowFuelLevelSetpoint() {
        return lowFuelLevelSetpoint;
    }

    public void setLowFuelLevelSetpoint(double lowFuelLevelSetpoint) {
        this.lowFuelLevelSetpoint = lowFuelLevelSetpoint;
    }

    public double getStartVoltageFirstStack() {
        return startVoltageFirstStack;
    }

    public void setStartVoltageFirstStack(double startVoltageFirstStack) {
        this.startVoltageFirstStack = startVoltageFirstStack;
    }

    public double getStartVoltageSecondStack() {
        return startVoltageSecondStack;
    }

    public void setStartVoltageSecondStack(double startVoltageSecondStack) {
        this.startVoltageSecondStack = startVoltageSecondStack;
    }

    public double getFloatVoltage() {
        return floatVoltage;
    }

    public void setFloatVoltage(double floatVoltage) {
        this.floatVoltage = floatVoltage;
    }

    public double getTimeBetweenFilterMaint() {
        return timeBetweenFilterMaint;
    }

    public void setTimeBetweenFilterMaint(double timeBetweenFilterMaint) {
        this.timeBetweenFilterMaint = timeBetweenFilterMaint;
    }

    public double getMaxBatteryCurrent() {
        return maxBatteryCurrent;
    }

    public void setMaxBatteryCurrent(double maxBatteryCurrent) {
        this.maxBatteryCurrent = maxBatteryCurrent;
    }

    public int getMaintenceHour() {
        return maintenceHour;
    }

    public void setMaintenceHour(int maintenceHour) {
        this.maintenceHour = maintenceHour;
    }

    
}
