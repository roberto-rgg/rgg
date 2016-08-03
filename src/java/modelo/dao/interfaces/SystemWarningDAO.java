/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.List;
import modelo.entites.reports.SystemWarning;

/**
 *
 * @author Roberto
 */
public interface SystemWarningDAO {

    public boolean create(SystemWarning systemWarning);
    public SystemWarning read(int id);
    public List<SystemWarning> read();
    public List<SystemWarning> readLastDays(int days);

}
