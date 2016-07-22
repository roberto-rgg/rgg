package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.NodoImplDAO;
import modelo.dao.interfaces.NodoDAO;
import modelo.entites.FuelCell;
import modelo.entites.ReportFuelCell;
import modelo.entites.Nodo;
import snmp.SnmpDataSource;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "CeldaController", urlPatterns = {"/CeldaController"})
public class CeldaController extends HttpServlet {

    private String pathDispatcher;
    private int idNodo;
    private int home;
    private FuelCell celda;
    public static final String PARAM_NODO = "id_nodo";
    public static final String PARAM_HOME = "id_home";
    public static final int MAIN = 1;
    public static final int ESTADISTICAS = 2;
    public static final int PARAMETROS = 3;
    public static final int ALARMAS = 4;

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
        }

        if (request.getParameter(PARAM_NODO) != null && request.getParameter(PARAM_HOME) != null) {
            idNodo = Integer.parseInt(request.getParameter(PARAM_NODO));
            home = Integer.parseInt(request.getParameter(PARAM_HOME));
            request.getSession().setAttribute(PARAM_NODO, idNodo);
            NodoDAO dao = new NodoImplDAO();
            SnmpDataSource source = new SnmpDataSource(dao.read(idNodo));
            celda = source.getCelda();

            request.getSession().setAttribute("celda", celda);
            pathDispatcher = "home.jsp";

        }

        RequestDispatcher rd = request.getRequestDispatcher(pathDispatcher);
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
