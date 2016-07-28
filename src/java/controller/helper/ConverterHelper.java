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
    
    public static Date dateValue(String value){
        try{
            return new Date(Long.valueOf(value));
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean booleanValue(String value){
        try{
            int one = Integer.parseInt(value);
            return one > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static double porcentValue(double cantidad,double total){
        return ((cantidad/total)*100);
    }
    
    
}
