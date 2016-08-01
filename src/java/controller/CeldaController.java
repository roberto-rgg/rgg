package controller;

import controller.helper.ConverterHelper;
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
import snmp.SnmpDataSource;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "CeldaController", urlPatterns = {"/Resumen"})
public class CeldaController extends HttpServlet {

    private String pathDispatcher;
    private int idNodo;
    private FuelCell celda;
    private SnmpDataSource source;

    public static final String PARAM_NODO = "id_nodo";
    public static final String PARAM_CELDA = "celda";
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

        if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }

        if (request.getParameter(PARAM_NODO) != null) {
            idNodo = Integer.parseInt(request.getParameter(PARAM_NODO));

            request.getSession().setAttribute(PARAM_NODO, idNodo);
            //leer nodo
            NodoDAO daoNodo = new NodoImplDAO();
            Nodo nodo = daoNodo.read(idNodo);
            //leer celda
            FuelCellDAO daoFuelCell = new FuelCellImplDAO();
            celda = daoFuelCell.read(nodo.getId());
            celda.setNodo(nodo);
            request.getSession().setAttribute(PARAM_CELDA, celda);
            pathDispatcher = "home.jsp";

        }

        RequestDispatcher rd = request.getRequestDispatcher(pathDispatcher);
        rd.forward(request, response);

    }

    public void loadSnmpData(HttpServletRequest request) {
        source = new SnmpDataSource();

        int tiempoOnline = ConverterHelper.integerValue(source.retrieveSnmpValue(FuelCell.TEST_VALUE_INT));
        request.setAttribute(PARAM_TIEMPO_ONLINE, tiempoOnline);

        int totalCiclos = ConverterHelper.integerValue(source.retrieveSnmpValue(FuelCell.TEST_VALUE_INT));
        request.setAttribute(PARAM_TOTAL_CICLOS, totalCiclos);

        int totalCiclosStack1 = ConverterHelper.integerValue(source.retrieveSnmpValue(FuelCell.TEST_VALUE_INT));
        request.setAttribute(PARAM_TOTAL_CICLOS_ST_1, totalCiclosStack1);

        int totalCiclosStack2 = ConverterHelper.integerValue(source.retrieveSnmpValue(FuelCell.TEST_VALUE_INT));
        request.setAttribute(PARAM_TOTAL_CICLOS_ST_2, totalCiclosStack2);

        String estadoActual = source.retrieveSnmpValue(FuelCell.TEST_VALUE_STRING);
        request.setAttribute(PARAM_ESTADO_ACTUAL, estadoActual);
        
        String warning384 = source.retrieveSnmpValue(FuelCell.TEST_VALUE_STRING);
        String warning385 = source.retrieveSnmpValue(FuelCell.TEST_VALUE_STRING);
        String warning386 = source.retrieveSnmpValue(FuelCell.TEST_VALUE_STRING);
        String warning387 = source.retrieveSnmpValue(FuelCell.TEST_VALUE_STRING);
        boolean systemfaulted = false;
        boolean sdCardPresent = false;
        double voltageOutput = 20;
        double voltageOutputPercent = ConverterHelper.porcentValue(voltageOutput, celda.getNominalVoltage());
        double amperageoutput = 89;
        double amperageOutputPercent = ConverterHelper.porcentValue(amperageoutput, FuelCell.MAX_AMP);
        double potenciaOutput = 3.8;
        double potenciaOutputPercent = ConverterHelper.porcentValue(potenciaOutput, celda.getPowerRating());

        double tempReformador = 380;
        double tempReformadorPercent = ConverterHelper.porcentValue(tempReformador, FuelCell.MAX_TEMP_REFORMER);
        double tempMembrana = 350;
        double tempMembranaPercent = ConverterHelper.porcentValue(tempMembrana, FuelCell.MAX_TEMP_MEMBRANA);

        double combustible = 120;
        double combustiblePercent = ConverterHelper.porcentValue(combustible, FuelCell.TAN_SIZE);
        double consumo = 890;
        double consumoPercent = ConverterHelper.porcentValue(consumo, celda.getStandByConsumPowerPeek());
        double potenciaGenerada = 4800;
        double potenciaGeneradaPercent = ConverterHelper.porcentValue(potenciaGenerada, 5000);

        double diasParaMantencion = ConverterHelper.porcentValue(67, 80);

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
