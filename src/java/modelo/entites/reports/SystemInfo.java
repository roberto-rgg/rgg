
package modelo.entites.reports;

import java.util.Date;

/**
 *
 * @author Roberto
 */
public class SystemInfo {
    private int id;
    private Date timeStamp;
    private int totalSystemCycles;
    private double totalSystemRuntime;
    private double timeUntilFilterMaint;
    private double netKilowattHours;
    private int numPowerDemands;

    public SystemInfo() {
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

    public double getTimeUntilFilterMaint() {
        return timeUntilFilterMaint;
    }

    public void setTimeUntilFilterMaint(double timeUntilFilterMaint) {
        this.timeUntilFilterMaint = timeUntilFilterMaint;
    }

    public double getNetKilowattHours() {
        return netKilowattHours;
    }

    public void setNetKilowattHours(double netKilowattHours) {
        this.netKilowattHours = netKilowattHours;
    }

    public int getNumPowerDemands() {
        return numPowerDemands;
    }

    public void setNumPowerDemands(int numPowerDemands) {
        this.numPowerDemands = numPowerDemands;
    }
    
}
