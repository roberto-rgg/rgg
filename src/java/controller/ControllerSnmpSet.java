/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entites.FuelCell;
import org.snmp4j.mp.SnmpConstants;
import snmp.SnmpCommunication;
import snmp.SnmpDataSource;

/**
 *
 * @author Roberto
 */
@WebServlet(name = "ControllerSnmpSet", urlPatterns = {"/SnmpSet"})
public class ControllerSnmpSet extends HttpServlet {

    public static final String PARAM_PARAMETRO = "param_parametro";
    public static final String PARAM_TIPO = "param_tipo";
    public static final int TIPO_BOOLEAN = 1;
    public static final int TIPO_DOUBLE = 2;
    public static final int TIPO_INT = 3;
    public static final int TIPO_STRING = 4;

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

        SnmpDataSource snmp = null; 

        //String p = request.getParameter("options");
        String p2 = request.getParameter("param_string");
        //String p3 = request.getParameter("param_number");
        FuelCell celda = (FuelCell) request.getSession().getAttribute(ResumenController.PARAM_CELDA);

        if (celda != null) {
            if (p2 != null) {
                snmp = new  SnmpDataSource(celda.getNodo().getIp(), celda.getNodo().getPuerto());
                String  r = snmp.sendSetStringParam(FuelCell.SET_SYS_NAME, p2);
                System.out.println("respuesta:" + r);
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("Resumen");
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
