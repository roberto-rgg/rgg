package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.dao.ConnectionDataBase.getConnection;
import modelo.dao.interfaces.SystemFaultDAO;
import modelo.entites.FuelCell;
import modelo.entites.reports.SystemFault;
import modelo.entites.reports.SystemWarning;
import modelo.report.UtilDateHelper;

/**
 *
 * @author Roberto
 */
public class SystemFaultImplDAO extends ConnectionDataBase implements SystemFaultDAO {

    @Override
    public boolean create(SystemFault systemFault) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemFault read(int id) {
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_fault_history WHERE id = ? ";
        SystemFault systemFault = null;
        try {
            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, id);
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                systemFault = new SystemFault();
                systemFault.setId(resultSet.getInt(1));
                systemFault.setFaultId(resultSet.getInt(2));
                systemFault.setFaultTime(resultSet.getDate(3));
                systemFault.setFaultDescription(resultSet.getString(4));
            }

        } catch (SQLException e) {
            Logger.getLogger(SystemFaultImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStement != null) {
                    preparedStement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return systemFault;

    }

    @Override
    public List<SystemFault> read(FuelCell celda) {
        
        List<SystemFault> faults = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_fault_history WHERE celda_id = ? ";
        SystemFault systemFault;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                systemFault = new SystemFault();
                systemFault.setId(resultSet.getInt(1));
                systemFault.setFaultId(resultSet.getInt(2));
                systemFault.setFaultTime(resultSet.getDate(3));
                systemFault.setFaultDescription(resultSet.getString(4));
                faults.add(systemFault);
            }

        } catch (SQLException e) {
            Logger.getLogger(SystemFaultImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStement != null) {
                    preparedStement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return faults;

    }

    @Override
    public List<SystemFault> read(FuelCell celda, Date from, Date to) {
        
        List<SystemFault> faults = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_fault_history WHERE celda_id = ? AND fault_time BETWEEN ? AND ?";
        SystemFault systemFault;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            preparedStement.setDate(2, UtilDateHelper.convertDate(from));
            preparedStement.setDate(3, UtilDateHelper.convertDate(to));
            resultSet = preparedStement.executeQuery();

            while (resultSet.next()) {
                systemFault = new SystemFault();
                systemFault.setId(resultSet.getInt(1));
                systemFault.setFaultId(resultSet.getInt(2));
                systemFault.setFaultTime(resultSet.getDate(3));
                systemFault.setFaultDescription(resultSet.getString(4));
                faults.add(systemFault);
            }

        } catch (SQLException e) {
            Logger.getLogger(SystemFaultImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStement != null) {
                    preparedStement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return faults;
    }

    @Override
    public List<SystemFault> read(FuelCell celda, Date day) {
        
        List<SystemFault> faults = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_fault_history WHERE celda_id = ? AND fault_time = ?";
        SystemFault systemFault;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            preparedStement.setDate(2, UtilDateHelper.convertDate(day));
            resultSet = preparedStement.executeQuery();

            while (resultSet.next()) {
                systemFault = new SystemFault();
                systemFault.setId(resultSet.getInt(1));
                systemFault.setFaultId(resultSet.getInt(2));
                systemFault.setFaultTime(resultSet.getDate(3));
                systemFault.setFaultDescription(resultSet.getString(4));
                faults.add(systemFault);
            }

        } catch (SQLException e) {
            Logger.getLogger(SystemFaultImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStement != null) {
                    preparedStement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return faults;

    }

    @Override
    public List<SystemFault> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
