package modelo.report;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Roberto
 */
public class UtilDateHelper {

    /**
     * Convierte java.util.Date a java.sql.Date
     *
     * @param utilDate fecha a convertir
     * @return
     */
    public static java.sql.Date convertDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

    /**
     * Sustrae una cantidad de dias a la fecha actual.
     *
     * @param days
     * @return
     */
    public static Date sustractDaysActualDate(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -days);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date[] getRangoDate(int days) {

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();

        from.add(Calendar.DAY_OF_MONTH, -days);
        from.set(Calendar.HOUR_OF_DAY, 0);
        from.set(Calendar.MINUTE, 0);
        from.set(Calendar.SECOND, 0);
        from.set(Calendar.MILLISECOND, 0);

        to.add(Calendar.DAY_OF_MONTH, -days);
        to.set(Calendar.HOUR_OF_DAY, 23);
        to.set(Calendar.MINUTE, 59);
        to.set(Calendar.SECOND, 59);
        to.set(Calendar.MILLISECOND, 999);

        Date[] rang = new Date[]{from.getTime(), to.getTime()};
        return rang;

    }

    public static Date[] getRangoDate(Date date) {

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();

        from.setTime(date);
        from.set(Calendar.HOUR_OF_DAY, 0);
        from.set(Calendar.MINUTE, 0);
        from.set(Calendar.SECOND, 0);
        from.set(Calendar.MILLISECOND, 0);

        to.setTime(date);
        to.set(Calendar.HOUR_OF_DAY, 23);
        to.set(Calendar.MINUTE, 59);
        to.set(Calendar.SECOND, 59);
        to.set(Calendar.MILLISECOND, 999);

        Date[] rang = new Date[]{from.getTime(), to.getTime()};
        return rang;

    }
}
