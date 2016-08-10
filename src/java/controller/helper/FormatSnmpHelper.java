package controller.helper;

/**
 * Formateador SNMP variables.
 *
 * @author Roberto
 */
public class FormatSnmpHelper {

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

    public static String formatSnmpDoublet(String value,int precisition) {
        precisition++;
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return "not double";
        }
        char[] values = value.toCharArray();
        char[] newValues = new char[values.length + 1];
         int y = 0;
        for (int x = 0; x < newValues.length; x++) {
            if (x == (newValues.length - precisition)) {
                newValues[x] = '.';
                y--;
            } else {
                newValues[x]=values[y];
            }
            y++;   
        }
        return String.valueOf(newValues);
    }

    public static String formatSnmpDouble(String value) {
        int position = 2;
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return "not double";
        }
        char[] values = value.toCharArray();
        char[] newValues = new char[values.length + 1];
        int y = 0;
        for (int x = newValues.length; x > 0; x--) {
            
        }
        return String.valueOf(newValues);
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
    public static double snmpDouble(String value, int position) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
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
        String val = String.valueOf(newValues);
        return Double.parseDouble(val);
    }
}
