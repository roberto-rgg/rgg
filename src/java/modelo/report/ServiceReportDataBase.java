package modelo.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.ConnectionDataBase;
import static modelo.dao.ConnectionDataBase.getConnection;
import modelo.entites.FuelCell;

/**
 *
 * @author Roberto
 */
public class ServiceReportDataBase extends ConnectionDataBase {

    private FuelCell celda;

    public ServiceReportDataBase(FuelCell celda) {
        this.celda = celda;
    }

    public ServiceReportDataBase() {
    }

    /**
     * Muestra los ultimos arranques en los dias especificados.
     *
     * @param days
     * @return
     */
    public int countUltimosArranques(int days) {
        Connection conn = getConnection();
        int resultado = 0;
        int arranqueMax = 0;
        int arranqueMin = 0;

        Statement stement = null;
        ResultSet resultSet = null;
        String sql = "select max(system_total_system_cycles)-(select max(system_total_system_cycles) from historico_system_info WHERE time_stamp <= DATE_SUB(CURDATE(), INTERVAL " + days + " DAY)) as arranque from historico_system_info WHERE time_stamp >= DATE_SUB(CURDATE(), INTERVAL " + days + " DAY) AND celda_id = " + celda.getId() + ";";
        String queryMaxPotencia = "select max(system_total_system_cycles) as max_valor from historico_system_info WHERE time_stamp >= DATE_SUB(CURDATE(), INTERVAL " + days + " DAY)";
        String queryMinPotencia = "select max(system_total_system_cycles) as min_valor from historico_system_info WHERE time_stamp <= DATE_SUB(CURDATE(), INTERVAL " + days + " DAY)";
        try {
            
            stement = conn.createStatement();
            resultSet = stement.executeQuery(sql);
            
            while (resultSet.next()) {
                resultado = resultSet.getInt("arranque");
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ServiceReportDataBase.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stement != null) {
                    stement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Muestra la maxima potencia generada opor el dia especificado.
     *
     * @param days Dias atras a consultar.
     * @return potencia generada ese dia.
     */
    public double potenciaGeneradaPorDia(int days) {
        Connection conn = getConnection();
        double resultado = 0;

        Statement stement = null;
        ResultSet resultSet = null;
        String queryPotencia = "select max(gross_power) as power from historico_status WHERE time_stamp = DATE_SUB(CURDATE(), INTERVAL " + days + " DAY);";

        try {
            stement = conn.createStatement();
            resultSet = stement.executeQuery(queryPotencia);

            while (resultSet.next()) {
                resultado = resultSet.getDouble("power");
            }

        } catch (SQLException e) {
            Logger.getLogger(ServiceReportDataBase.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stement != null) {
                    stement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

}
