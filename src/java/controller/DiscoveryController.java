
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
import modelo.entites.Celda;
import modelo.entites.Nodo;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "SnmpController", urlPatterns = {"/SnmpController"})
public class DiscoveryController extends HttpServlet {

    private String pathDispatcher;
    public static final String ID_NODO = "id_nodo";

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
        Nodo nodo = null;
        String id_nodo = request.getParameter(ID_NODO);
        if (id_nodo != null) {
            NodoDAO dao = new NodoImplDAO();
            nodo = dao.read(Integer.parseInt(id_nodo));
            
        }

        pathDispatcher = "home.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(pathDispatcher);
        rd.forward(request, response);
        System.out.println("nombre del nodo :" + nodo.getDescripcion());

    }

    public Celda getCelda(Nodo nodo){
        return null;
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
