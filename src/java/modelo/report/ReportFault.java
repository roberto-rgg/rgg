package modelo.report;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.dao.SystemFaultImplDAO;
import modelo.dao.SystemWarningImplDAO;
import modelo.dao.interfaces.SystemFaultDAO;
import modelo.entites.FuelCell;
import modelo.entites.reports.SystemFault;
import modelo.entites.reports.SystemWarning;

/**
 *
 * @author Roberto
 */
public class ReportFault {

    private List<SystemFault> faults;
    private SystemFaultDAO systemFaultSource;
    private FuelCell celda;

    public ReportFault() {
    }

    public ReportFault(FuelCell celda) {
        this.celda = celda;
    }

    /**
     * Cuenta las fallas ocurridas en los ultimos dias.
     *
     * @param cantDays los ultimos dias desde la actual fecha a consultar.
     * @return cantidad de fallas generadas.
     */
    public int countFaultsLastDays(int cantDays) {
        systemFaultSource = new SystemFaultImplDAO();
        Date from = UtilDateHelper.sustractDaysActualDate(cantDays);
        Date to = Calendar.getInstance().getTime();
        return systemFaultSource.read(celda, from, to).size();
    }

    /**
     * Cuenta las fallas por dias,
     * @param cantDays desde el ultio dia a consultar.
     * @return array de integer con las fallas por dias.
     */
    public int[] countFaultLastDays(int cantDays) {
        int[] faultDays = new int[cantDays];
        for (int x = 0; x < cantDays; x++) {
            faultDays[x] = systemWarningLastOnlyDay(celda, x).size();
        }
        return faultDays;
    }

    public void retrieveReportSystemFault(int days) {
        Date from = UtilDateHelper.sustractDaysActualDate(days);
        Date until = Calendar.getInstance().getTime();
        systemFaultSource = new SystemFaultImplDAO();
        faults = systemFaultSource.read(celda, from, until);
    }

    public List<SystemFault> systemFaultLastDays(FuelCell celda, int days) {
        Date from = UtilDateHelper.sustractDaysActualDate(days);
        Date to = Calendar.getInstance().getTime();
        systemFaultSource = new SystemFaultImplDAO();
        return systemFaultSource.read(celda, from, to);
    }

    public List<SystemFault> systemWarningLastOnlyDay(FuelCell celda, int lastDay) {
        systemFaultSource = new SystemFaultImplDAO();
        Date[] rang = UtilDateHelper.getRangoDate(lastDay);
        Date from = rang[0];
        Date to = rang[1];
        return systemFaultSource.read(celda, from, to);
    }

    public List<SystemFault> getFaults() {
        return faults;
    }

    public void setFaults(List<SystemFault> faults) {
        this.faults = faults;
    }

}
