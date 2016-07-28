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
public class SystemWarning {

    private int id;
    private int warningId;
    private Date warningTime;
    private String warningDescription;

    public SystemWarning() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarningId() {
        return warningId;
    }

    public void setWarningId(int warningId) {
        this.warningId = warningId;
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }

    public String getWarningDescription() {
        return warningDescription;
    }

    public void setWarningDescription(String warningDescription) {
        this.warningDescription = warningDescription;
    }
    
}
