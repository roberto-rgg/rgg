package modelo.report;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.dao.SystemWarningImplDAO;
import modelo.dao.interfaces.SystemWarningDAO;
import modelo.entites.FuelCell;
import modelo.entites.reports.SystemWarning;

/**
 *
 * @author Roberto
 */
public class ReportWarning {

    private List<SystemWarning> warnings;
    private SystemWarningDAO systemWarningSource;
    private FuelCell celda;

    public ReportWarning() {
    }

    public ReportWarning(FuelCell celda) {
        this.celda = celda;
    }

    /**
     * Cuenta las advertencias ocurridasen los ultimos dias.
     *
     * @param cantDays los ultimos dias desde la actual fecha a consultar.
     * @return cantidad de advertencias generadas.
     */
    public int countWarnigsLastDays(int cantDays) {
        systemWarningSource = new SystemWarningImplDAO();
        Date from = UtilDateHelper.sustractDaysActualDate(cantDays);
        Date to = Calendar.getInstance().getTime();
        return systemWarningSource.read(celda, from, to).size();
    }

    /**
     * Cuenta las advertencias por dias,
     * @param cantDays desde el ultio dia a caonsultar.
     * @return array de integer con los warnings por dias.
     */
    public int[] countWarningsLastDays(int cantDays) {
        int[] warningdays = new int[cantDays];
        for (int x = 0; x < cantDays; x++) {
            warningdays[x] = systemWarningLastOnlyDay(celda, x).size();
        }
        return warningdays;
    }

    public void retrieveReportSystemWarning(int days) {
        Date from = UtilDateHelper.sustractDaysActualDate(days);
        Date until = Calendar.getInstance().getTime();
        systemWarningSource = new SystemWarningImplDAO();
        warnings = systemWarningSource.read(celda, from, until);
    }

    public List<SystemWarning> systemWarningLastDays(FuelCell celda, int days) {
        Date from = UtilDateHelper.sustractDaysActualDate(days);
        Date to = Calendar.getInstance().getTime();
        systemWarningSource = new SystemWarningImplDAO();
        return systemWarningSource.read(celda, from, to);
    }

    public List<SystemWarning> systemWarningLastOnlyDay(FuelCell celda, int lastDay) {
        systemWarningSource = new SystemWarningImplDAO();
        Date[] rang = UtilDateHelper.getRangoDate(lastDay);
        Date from = rang[0];
        Date to = rang[1];
        return systemWarningSource.read(celda, from, to);
    }

    public List<SystemWarning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<SystemWarning> warnings) {
        this.warnings = warnings;
    }

}
