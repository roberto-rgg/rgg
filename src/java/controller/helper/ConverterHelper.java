package controller.helper;

import java.util.Date;

/**
 * Encargada de conversiones numericas y de formato con metodos de acceso
 * staticos.
 *
 * @author Roberto
 */
public class ConverterHelper {

    public static int integerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }

    public static double doubleValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Date dateValue(String value) {
        try {
            return new Date(Long.valueOf(value));
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean booleanValue(String value) {
        try {
            int one = Integer.parseInt(value);
            return one > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static double porcentValue(double cantidad, double total) {
        return ((cantidad / total) * 100);
    }

    public static double snmpDoubleBeginDec(String value, int presicion) {
        
        try {
            int entero = Integer.parseInt(value);
            if (entero == 0) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        char[] values = value.toCharArray();
        char[] newValues = new char[values.length + 1];
        int y = 0;
        for (int x = 0; x < newValues.length; x++) {
            if (x == presicion) {
                newValues[x] = '.';
                y--;
            } else {
                newValues[x] = values[y];
            }
            y++;
        }
        String val = String.valueOf(newValues);
        return Double.parseDouble(val);
    }
    
    public static double snmpDoubleFinalDec(String value, int presicion) {
        presicion++;
        try {
            int entero = Integer.parseInt(value);
            if (entero == 0) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        char[] values = value.toCharArray();
        char[] newValues = new char[values.length + 1];
        int y = 0;
        for (int x = 0; x < newValues.length; x++) {
            if (x == (newValues.length - presicion)) {
                newValues[x] = '.';
                y--;
            } else {
                newValues[x] = values[y];
            }
            y++;
        }
        String val = String.valueOf(newValues);
        return Double.parseDouble(val);
    }

    /**
     * Formatea variables String recibidas de snmp a tipo double, especificando
     * el punto flotante.
     *
     * @param value valor a formatear
     * @param position posicion hacia la derecha donde se necesita posicionar el
     * punto flotante en la variable
     * @return variable formateada
     */
    public static String formatSnmpDouble(String value, int position) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return "not double";
        }
        char[] values = value.toCharArray();
        char[] newValues = new char[values.length + 1];
        int y = 0;
        for (int x = 0; x < newValues.length; x++) {
            if (x == position) {
                newValues[x] = '.';
                y--;
            } else {
                newValues[x] = values[y];
            }
            y++;
        }
        return String.valueOf(newValues);
    }

}
