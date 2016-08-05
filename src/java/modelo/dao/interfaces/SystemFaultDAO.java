/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.Date;
import java.util.List;
import modelo.entites.FuelCell;
import modelo.entites.reports.SystemFault;
import modelo.entites.reports.SystemWarning;

/**
 *
 * @author Roberto
 */
public interface SystemFaultDAO {
    
    public boolean create(SystemFault systemFault);

    public SystemFault read(int id);

    public List<SystemFault> read(FuelCell celda);

    public List<SystemFault> read(FuelCell celda,Date from,Date to);
    
    public List<SystemFault> read(FuelCell celda,Date day);
    
    public List<SystemFault> read();

}
