package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.dao.ConnectionDataBase.getConnection;
import modelo.dao.interfaces.FuelCellDAO;
import modelo.entites.FuelCell;
import modelo.entites.Nodo;

/**
 *
 * @author Roberto
 */
public class FuelCellImplDAO extends ConnectionDataBase implements FuelCellDAO {

    @Override
    public FuelCell read(int id) {
        Connection conn = getConnection();
        PreparedStatement preparedStement = null;
        ResultSet rs = null;
        String sql = 
                "SELECT \n"
                + "c.id,\n"
                + "c.system_part_number,\n"
                + "c.system_serial,\n"
                + "c.sys_describ,\n"
                + "c.sys_name,\n"
                + "c.sysy_location,\n"
                + "c.gps_latitude,\n"
                + "c.gps_longitud,\n"
                + "c.stack_numbers,\n"
                + "c.system_time_gmt,\n"
                + "c.gmt_offset_hours,\n"
                + "c.gmt_offset_quarter_hours,\n"
                + "c.system_time_local,\n"              
                + "m.nombre,\n"
                + "m.descripcion,\n"
                + "m.power_rating,\n"
                + "m.nominal_voltage,\n"
                + "m.fuel_consumption,\n"
                + "m.standby_power_comsum_average,\n"
                + "m.stanby_consum_power_peek\n"
                + "FROM modelo m, celda c\n"
                + "WHERE c.modelo_id = m.id "
                + "AND c.id = ?;";
        FuelCell celda = null;
        try {
            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, id);
            rs = preparedStement.executeQuery();
            while (rs.next()) {
                celda = new FuelCell();
                celda.setId(rs.getInt(1));
                celda.setSystemPartNumber(rs.getString(2));
                celda.setSystemSerial(rs.getString(3));
                celda.setSysDescrib(rs.getString(4));
                celda.setSysName(rs.getString(5));
                celda.setSysLocation(rs.getString(6));
                celda.setGpsLatitude(rs.getInt(7));
                celda.setGpsLongitud(rs.getInt(8));
                celda.setStackNumber(rs.getInt(9));
                celda.setSystemtimeGmt(rs.getLong(10));
                celda.setGmtOffsethours(rs.getInt(11));
                celda.setGmtOffsetQuarterHours(rs.getInt(12));
                celda.setSystemTimelocal(rs.getLong(13));
                celda.setModelo(rs.getString(14));
                celda.setDescripcionModelo(rs.getString(15));
                celda.setPowerRating(rs.getDouble(16));
                celda.setNominalVoltage(rs.getDouble(17));
                celda.setFuelConsumption(rs.getDouble(18));
                celda.setStandByPowerConsumAverage(rs.getDouble(19));
                celda.setStandByConsumPowerPeek(rs.getDouble(20));
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

                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return celda;

    }

    @Override
    public FuelCell read(Nodo nodo) {
        Connection conn = getConnection();
        PreparedStatement preparedStement = null;
        ResultSet rs = null;
        String sql = 
                "SELECT \n"
                + "c.id,\n"
                + "c.system_part_number,\n"
                + "c.system_serial,\n"
                + "c.sys_describ,\n"
                + "c.sys_name,\n"
                + "c.sysy_location,\n"
                + "c.gps_latitude,\n"
                + "c.gps_longitud,\n"
                + "c.stack_numbers,\n"
                + "c.system_time_gmt,\n"
                + "c.gmt_offset_hours,\n"
                + "c.gmt_offset_quarter_hours,\n"
                + "c.system_time_local,\n"              
                + "m.nombre,\n"
                + "m.descripcion,\n"
                + "m.power_rating,\n"
                + "m.nominal_voltage,\n"
                + "m.fuel_consumption,\n"
                + "m.standby_power_comsum_average,\n"
                + "m.stanby_consum_power_peek\n"
                + "FROM modelo m, celda c\n"
                + "WHERE c.modelo_id = m.id "
                + "AND c.nodo_id = ?;";
        FuelCell celda = null;
        try {
            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, 2);
            rs = preparedStement.executeQuery();
            while (rs.next()) {
                celda = new FuelCell();
                celda.setId(rs.getInt(1));
                celda.setSystemPartNumber(rs.getString(2));
                celda.setSystemSerial(rs.getString(3));
                celda.setSysDescrib(rs.getString(4));
                celda.setSysName(rs.getString(5));
                celda.setSysLocation(rs.getString(6));
                celda.setGpsLatitude(rs.getInt(7));
                celda.setGpsLongitud(rs.getInt(8));
                celda.setStackNumber(rs.getInt(9));
                celda.setSystemtimeGmt(rs.getLong(10));
                celda.setGmtOffsethours(rs.getInt(11));
                celda.setGmtOffsetQuarterHours(rs.getInt(12));
                celda.setSystemTimelocal(rs.getLong(13));
                celda.setModelo(rs.getString(14));
                celda.setDescripcionModelo(rs.getString(15));
                celda.setPowerRating(rs.getDouble(16));
                celda.setNominalVoltage(rs.getDouble(17));
                celda.setFuelConsumption(rs.getDouble(18));
                celda.setStandByPowerConsumAverage(rs.getDouble(19));
                celda.setStandByConsumPowerPeek(rs.getDouble(20));
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

                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return celda;
    }

}
