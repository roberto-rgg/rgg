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
public class StackFault {

    private int id;
    private int stacknumber;
    private int faultId;
    private Date faultTime;
    private String faultDescription;

    public StackFault() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStacknumber() {
        return stacknumber;
    }

    public void setStacknumber(int stacknumber) {
        this.stacknumber = stacknumber;
    }

    public int getFaultId() {
        return faultId;
    }

    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    public Date getFaultTime() {
        return faultTime;
    }

    public void setFaultTime(Date faultTime) {
        this.faultTime = faultTime;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

}
