package controller;

import controller.helper.ConverterHelper;
import controller.helper.FormatSnmpHelper;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.FuelCellImplDAO;
import modelo.dao.NodoImplDAO;
import modelo.dao.interfaces.FuelCellDAO;
import modelo.dao.interfaces.NodoDAO;
import modelo.entites.FuelCell;
import modelo.entites.Nodo;
import modelo.entites.Usuario;
import snmp.SnmpDataSource;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "CeldaController", urlPatterns = {"/Resumen"})
public class ResumenController extends HttpServlet {

    public static final String PARAM_NODO = "id_nodo";
    public static final String PARAM_CELDA = "celda";
    public static final String PARAM_MODO = "modo";

    public static final String PARAM_SYS_DESC = "sys_desc";
    public static final String PARAM_SYS_LOCATION = "sys_location";

    public static final String PARAM_TIEMPO_ONLINE = "1";
    public static final String PARAM_MODELO = "2";
    public static final String PARAM_UBICACION = "3";
    public static final String PARAM_TOTAL_CICLOS = "4";
    public static final String PARAM_TOTAL_CICLOS_ST_1 = "5";
    public static final String PARAM_TOTAL_CICLOS_ST_2 = "6";
    public static final String PARAM_ESTADO_ACTUAL = "7";
    public static final String PARAM_WARN_384 = "8";
    public static final String PARAM_WARN_386 = "9";
    public static final String PARAM_WARN_385 = "10";
    public static final String PARAM_WARN_387 = "11";
    public static final String PARAM_SYSTEM_FAULTED = "12";
    public static final String PARAM_SDCARD_PRESENT = "13";

    public static final String PARAM_VOLT_OUT = "14";
    public static final String PARAM_VOLT_OUT_PERCT = "15";

    public static final String PARAM_AMP_OUT = "16";
    public static final String PARAM_AMP_OUT_PERCT = "17";

    public static final String PARAM_POTENCIA_OUT = "18";
    public static final String PARAM_POTENCIA_OUT_PERCT = "19";

    public static final String PARAM_TEMP_REFORMER = "20";
    public static final String PARAM_TEMP_REFORMER_PERCT = "21";

    public static final String PARAM_TEMP_MEMBRANA = "22";
    public static final String PARAM_TEMP_MEMBRANA_PERCT = "23";
    public static final String PARAM_ULTM_FUNCIONANDO = "24";

    public static final String PARAM_DIAS_ULTIMO_ARRANQUE = "24.5";

    public static final String PARAM_COMBUSTIBLE = "25";
    public static final String PARAM_COMBUSTIBLE_PERCT = "26";

    public static final String PARAM_CONSUMO = "27";
    public static final String PARAM_CONSUMO_PERCT = "28";

    public static final String PARAM_POTENCIA_GENERADA = "29";
    public static final String PARAM_POTENCIA_GENERADA_PERCT = "30";
    public static final String PARAM_DIAS_TO_MANTENANCE = "31";

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

        Usuario usuario = (Usuario) request.getSession().getAttribute(LoginController.USUARIO);
        int idNodo;
        FuelCell celda;
        SnmpDataSource source;
        String doubleValue;
        
        if (usuario == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        celda = (FuelCell) request.getSession().getAttribute(PARAM_CELDA);

        if (celda == null) {
            String paramNodo = request.getParameter(PARAM_NODO);
            if (paramNodo != null) {
                NodoDAO daoNodo = new NodoImplDAO();
                idNodo = Integer.parseInt(paramNodo);
                Nodo nodo = daoNodo.read(idNodo);
                FuelCellDAO daoFuelCell = new FuelCellImplDAO();
                celda = daoFuelCell.read(nodo.getId());
                celda.setNodo(nodo);
                request.getSession().setAttribute(PARAM_CELDA, celda);

            }
        }

        source = new SnmpDataSource(celda.getNodo().getIp(), celda.getNodo().getPuerto());

        String modo = request.getParameter(PARAM_MODO);
        if (modo != null) {
            usuario.setModoResumen(modo);
            if (modo.equals("offline")) {
                request.getRequestDispatcher("home_reportes.jsp").forward(request, response);
                return;
            }
        }

        /** descomentar cuando la celda este en linea con ambiente de desarrollo
        if (!source.isOnline()) {
            request.getRequestDispatcher("discovery.jsp").forward(request, response);
            return;
        }
**/
        String sysDesc = source.retrieveSnmpValue(FuelCell.SYS_DESCR);
        request.setAttribute(PARAM_SYS_DESC, sysDesc);

        String sysLocation = source.retrieveSnmpValue(FuelCell.SYS_LOCATION);
        request.setAttribute(PARAM_SYS_LOCATION, sysLocation);

        String tiempoOnline = source.retrieveSnmpValue(FuelCell.SYSTEM_TOTAL_SYSTEM_RUNTIME);
        tiempoOnline = ConverterHelper.formatSnmpDouble(tiempoOnline, 1);
        request.setAttribute(PARAM_TIEMPO_ONLINE, tiempoOnline);

        String totalCiclos = source.retrieveSnmpValue(FuelCell.SYSTEM_TOTAL_SYSTEM_CYCLES);
        request.setAttribute(PARAM_TOTAL_CICLOS, totalCiclos);

        String totalCiclosStack1 = source.retrieveSnmpValue(FuelCell.SYSTEM_STACK_1_CYCLES);
        request.setAttribute(PARAM_TOTAL_CICLOS_ST_1, totalCiclosStack1);

        String totalCiclosStack2 = source.retrieveSnmpValue(FuelCell.SYSTEM_STACK_2_CYCLES);
        request.setAttribute(PARAM_TOTAL_CICLOS_ST_2, totalCiclosStack2);

        String estadoActual = source.retrieveSnmpValue(FuelCell.SYSTEM_STATE_DESC);
        request.setAttribute(PARAM_ESTADO_ACTUAL, estadoActual);

        String warning384 = source.retrieveSnmpValue(FuelCell.WARNING_DESCRIPTION_VAL_384);
        request.setAttribute(PARAM_WARN_384, warning384);

        String warning385 = source.retrieveSnmpValue(FuelCell.WARNING_DESCRIPTION_VAL_385);
        request.setAttribute(PARAM_WARN_385, warning385);

        String warning386 = source.retrieveSnmpValue(FuelCell.WARNING_DESCRIPTION_VAL_386);
        request.setAttribute(PARAM_WARN_386, warning386);

        String warning387 = source.retrieveSnmpValue(FuelCell.WARNING_DESCRIPTION_VAL_387);
        request.setAttribute(PARAM_WARN_387, warning387);

        boolean systemfaulted = ConverterHelper.booleanValue(source.retrieveSnmpValue(FuelCell.SYSTEM_FAULTED));
        request.setAttribute(PARAM_SYSTEM_FAULTED, systemfaulted);

        boolean sdCardPresent = ConverterHelper.booleanValue(source.retrieveSnmpValue(FuelCell.SD_CARD_PRESENT));
        request.setAttribute(PARAM_SDCARD_PRESENT, sdCardPresent);

        double voltageOutput = ConverterHelper.snmpDoubleBeginDec(source.retrieveSnmpValue(FuelCell.OUTPUT_VOLTAGE),2);   
        double voltageOutputPercent = ConverterHelper.porcentValue(voltageOutput, celda.getNominalVoltage());
        request.setAttribute(PARAM_VOLT_OUT, voltageOutput);
        request.setAttribute(PARAM_VOLT_OUT_PERCT, voltageOutputPercent);

        double amperageoutput = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.OUTPUT_CURRENT),1);
        double amperageOutputPercent = ConverterHelper.porcentValue(amperageoutput, FuelCell.MAX_AMP);
        request.setAttribute(PARAM_AMP_OUT, amperageoutput);
        request.setAttribute(PARAM_AMP_OUT_PERCT, amperageOutputPercent);

        double potenciaOutput = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.GROSS_POWER),2);
        double potenciaOutputPercent = ConverterHelper.porcentValue(potenciaOutput, celda.getPowerRating());
        request.setAttribute(PARAM_POTENCIA_OUT, potenciaOutput);
        request.setAttribute(PARAM_POTENCIA_OUT_PERCT, potenciaOutputPercent);

        double tempReformador = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.INPUTS_TEMP_REFORMER_BOTTOM),2);
        double tempReformadorPercent = ConverterHelper.porcentValue(tempReformador, FuelCell.MAX_TEMP_REFORMER);
        request.setAttribute(PARAM_TEMP_REFORMER, tempReformador);
        request.setAttribute(PARAM_TEMP_REFORMER_PERCT, tempReformadorPercent);

        double tempMembrana = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.INPUTS_TEMP_MEMBRANE),2);
        double tempMembranaPercent = ConverterHelper.porcentValue(tempMembrana, FuelCell.MAX_TEMP_MEMBRANA);
        request.setAttribute(PARAM_TEMP_MEMBRANA, tempMembrana);
        request.setAttribute(PARAM_TEMP_MEMBRANA_PERCT, tempMembranaPercent);

        double combustible = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.INPUTS_FUEL_LEVEL),2);
        double combustiblePercent = ConverterHelper.porcentValue(combustible, FuelCell.TAN_SIZE);
        request.setAttribute(PARAM_COMBUSTIBLE, combustible);
        request.setAttribute(PARAM_COMBUSTIBLE_PERCT, combustiblePercent);

        double consumo = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.GROSS_POWER),2);
        double consumoPercent = ConverterHelper.porcentValue(consumo, celda.getStandByConsumPowerPeek());
        request.setAttribute(PARAM_CONSUMO, consumo);
        request.setAttribute(PARAM_CONSUMO_PERCT, consumoPercent);

        double potenciaGenerada = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.CALCULATED_GROSS_POWER),2);
        double potenciaGeneradaPercent = ConverterHelper.porcentValue(potenciaGenerada, 5000);
        request.setAttribute(PARAM_POTENCIA_GENERADA, potenciaGenerada);
        request.setAttribute(PARAM_POTENCIA_GENERADA_PERCT, potenciaGeneradaPercent);

        double diasParaMantencion = ConverterHelper.snmpDoubleFinalDec(source.retrieveSnmpValue(FuelCell.SYSTEM_TIME_UNTIL_FILTER_MAINT),2);
        request.setAttribute(PARAM_DIAS_TO_MANTENANCE, diasParaMantencion);

        String diasUltimoArranque = source.retrieveSnmpValue(FuelCell.PARAMS_DAYS_SINCE_LAST_SYSTEM_ONLINE);
        request.setAttribute(PARAM_DIAS_ULTIMO_ARRANQUE, diasUltimoArranque);

        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
