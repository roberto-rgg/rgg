/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helper.ConverterHelper;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entites.FuelCell;
import modelo.entites.Nodo;
import snmp.SnmpDataSource;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "ControllerUtilidades", urlPatterns = {"/Utilidades"})
public class ControllerUtilidades extends HttpServlet {

    private FuelCell celda;
    private SnmpDataSource snmp;

    public static final String SYS_NAME = "187";
    public static final String SYS_LOCATION = "188";
    public static final String GPS_LATITUDE = "3";
    public static final String GPS_LONGITUDE = "4";
    public static final String SYSTEM_TIME_GMT = "17";
    public static final String SYSTEM_TIME_LOCAL = "20";

    public static final String PARAMS_LIMIT_HEATERS_TO_500W = "98";
    public static final String PARAMS_COLD_WEATHER_KIT_PRESENT = "99";
    public static final String PARAMS_SYSTEM_SOAKED = "100";
    public static final String PARAMS_LOW_FUEL_LEVEL_SETPOINT = "101";
    public static final String PARAMS_START_VOLTAGE_FIRST_STACK = "102";
    public static final String PARAMS_START_VOLTAGE_SECOND_STACK = "103";
    public static final String PARAMS_FLOAT_VOLTAGE = "104";
    public static final String PARAMS_TIME_BETWEEN_FILTER_MAINT = "105";
    public static final String PARAMS_MAX_BATTERY_CURRENT = "106";
    public static final String PARAMS_MAINTENANCE_HOUR = "107";
    public static final String PARAMS_4MA_BATTERY_CURRENT = "108";
    public static final String PARAMS_20MA_BATTERY_CURRENT = "109";
    public static final String PARAMS_DAYS_BETWEEN_DIAGS = "110";
    public static final String PARAMS_DAYS_SINCE_LAST_SYSTEM_ONLINE = "111";
    public static final String PARAMS_DAYS_BETWEEN_DOSING_STARTS = "112";
    public static final String PARAMS_FPM_V25 = "113";
    public static final String PARAMS_LCD_V25 = "114";
    public static final String PARAMS_LOW_PRESSURE_SYSTEM = "115";
    public static final String PARAMS_MAINTENANCE_HOUR_2 = "116";
    public static final String PARAMS_EXTERNAL_FUEL_SENSOR = "117";
    public static final String PARAMS_EXTERNAL_FUEL_SENSOR_EMPTY = "118";
    public static final String PARAMS_EXTERNAL_FUEL_SENSOR_FULL = "119";

    public static final String START = "1000";
    public static final String STOP = "1001";
    public static final String ACK_FAULT = "1002";
    public static final String SELF_DIAGNOSTICS = "1003";
    public static final String RESET_MAINT_TIMER = "1004";

    public static final String LCD_BUTTON_UP = "1005";
    public static final String LCD_BUTTON_DOWN = "1006";
    public static final String LCD_BUTTON_LEFT = "1007";
    public static final String LCD_BUTTON_RIGHT = "1008";
    public static final String LCD_BUTTON_ENTER = "1009";
    public static final String LCD_BUTTON_BACK = "1010";
    public static final String LCD_BUTTON_MENU = "1011";
    public static final String REBOOT_LCD = "1012";
    public static final String LCD_PASSWORD = "1013";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd;

        if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }
        celda = (FuelCell) request.getSession().getAttribute(ResumenController.PARAM_CELDA);
        Nodo n = celda.getNodo();
        snmp = new SnmpDataSource(n.getIp(),n.getPuerto());

        
        String sysName = snmp.retrieveSnmpValue(FuelCell.SYS_NAME);
        request.setAttribute(SYS_NAME, sysName);
        
        String sysLocation = snmp.retrieveSnmpValue(FuelCell.SYS_LOCATION);
        request.setAttribute(SYS_LOCATION, sysLocation);
        
        boolean limitHeatersto500 = ConverterHelper.booleanValue("1");
        request.setAttribute(PARAMS_LIMIT_HEATERS_TO_500W, limitHeatersto500);

        boolean coldWeatherKitPresent = ConverterHelper.booleanValue("0");
        request.setAttribute(PARAMS_COLD_WEATHER_KIT_PRESENT, coldWeatherKitPresent);

        double lowFuelLevelSetPoint = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_LOW_FUEL_LEVEL_SETPOINT, lowFuelLevelSetPoint);

        double startVoltageFirstStack = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_START_VOLTAGE_FIRST_STACK, startVoltageFirstStack);

        double startVoltageSecondStack = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_START_VOLTAGE_SECOND_STACK, startVoltageSecondStack);

        double floatVoltage = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_FLOAT_VOLTAGE, floatVoltage);

        int maintenanceHour = ConverterHelper.integerValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_MAINTENANCE_HOUR, maintenanceHour);

        double daysBetweendiags = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_DAYS_BETWEEN_DIAGS, daysBetweendiags);

        int maintenanceHour2 = ConverterHelper.integerValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_MAINTENANCE_HOUR_2, maintenanceHour2);

        boolean externalFuelSensor = ConverterHelper.booleanValue("0");
        request.setAttribute(PARAMS_EXTERNAL_FUEL_SENSOR, externalFuelSensor);

        double extenalFuelSensorEmpty = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_EXTERNAL_FUEL_SENSOR_EMPTY, extenalFuelSensorEmpty);

        double extenalFuelSensorFull = ConverterHelper.doubleValue(snmp.retrieveSnmpValue(FuelCell.TEST_VALUE_DOUBLE));
        request.setAttribute(PARAMS_EXTERNAL_FUEL_SENSOR_FULL, extenalFuelSensorFull);

        rd = request.getRequestDispatcher("home_utilidades.jsp");
        rd.forward(request, response);

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
