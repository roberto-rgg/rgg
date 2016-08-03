/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.dao.interfaces.SystemWarningDAO;
import modelo.entites.reports.SystemWarning;

/**
 *
 * @author Roberto
 */
public class SystemWarningImplDAO extends ConnectionDataBase implements SystemWarningDAO{

    @Override
    public boolean create(SystemWarning systemWarning) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemWarning read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SystemWarning> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SystemWarning> readLastDays(int days) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
