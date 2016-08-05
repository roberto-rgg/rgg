/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.dao.interfaces.SystemWarningDAO;
import modelo.entites.FuelCell;
import modelo.entites.reports.SystemWarning;
import modelo.report.UtilDateHelper;

/**
 *
 * @author Roberto
 */
public class SystemWarningImplDAO extends ConnectionDataBase implements SystemWarningDAO {

    @Override
    public boolean create(SystemWarning systemWarning) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SystemWarning read(int id) {

        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history WHERE id = ? ";
        SystemWarning systemWarning = null;
        try {
            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, id);
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return systemWarning;
    }

    @Override
    public List<SystemWarning> read(FuelCell celda) {
        List<SystemWarning> warnings = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history WHERE celda_id = ? ";
        SystemWarning systemWarning;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
                warnings.add(systemWarning);
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return warnings;
    }

    @Override
    public List<SystemWarning> read() {
        List<SystemWarning> warnings = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history";
        SystemWarning systemWarning;

        try {

            preparedStement = conn.prepareStatement(sql);
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
                warnings.add(systemWarning);
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return warnings;
    }

    @Override
    public List<SystemWarning> read(FuelCell celda, Date from, Date to) {

        List<SystemWarning> warnings = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history WHERE celda_id = ? AND warning_time BETWEEN ? AND ?";
        SystemWarning systemWarning;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            preparedStement.setDate(2, UtilDateHelper.convertDate(from));
            preparedStement.setDate(3, UtilDateHelper.convertDate(to));
            resultSet = preparedStement.executeQuery();

            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
                warnings.add(systemWarning);
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return warnings;
    }

    @Override
    public List<SystemWarning> read(FuelCell celda, Date day) {

        List<SystemWarning> warnings = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history WHERE celda_id = ? AND warning_time = ?";
        SystemWarning systemWarning;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, celda.getId());
            preparedStement.setDate(2, UtilDateHelper.convertDate(day));
            resultSet = preparedStement.executeQuery();

            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
                warnings.add(systemWarning);
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return warnings;
    }

    @Override
    public List<SystemWarning> readLastDays(int days) {

        List<SystemWarning> warnings = new ArrayList();
        Connection conn = getConnection();

        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM system_warning_history WHERE warning_time >= DATE_SUB(CURDATE(), INTERVAL ? DAY)";
        SystemWarning systemWarning;

        try {

            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, days);
            resultSet = preparedStement.executeQuery();

            while (resultSet.next()) {
                systemWarning = new SystemWarning();
                systemWarning.setId(resultSet.getInt(1));
                systemWarning.setWarningId(resultSet.getInt(2));
                systemWarning.setWarningTime(resultSet.getDate(3));
                systemWarning.setWarningDescription(resultSet.getString(4));
                warnings.add(systemWarning);
            }

        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
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
        return warnings;
    }

}
