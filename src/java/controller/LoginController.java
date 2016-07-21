
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.UsuarioImplDAO;
import modelo.dao.interfaces.UsuarioDAO;
import modelo.entites.Usuario;

/**
 * Servlet encargado de controlar la atenticación de usuarios.
 * @author Roberto
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private String pathDispatcher;
    public static final String ERROR_MENSAJE = "mensaje";
    public static final String USUARIO = "usuario";
    
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

        String nombre = request.getParameter("input_correo");
        String clave = request.getParameter("input_clave");

        Usuario usuario = login(nombre, clave);

        if (usuario != null) {
            request.getSession().setAttribute(USUARIO, usuario);
            pathDispatcher = "discovery.jsp";
        } else {
            request.setAttribute(ERROR_MENSAJE, "Usuario o contraseña Equivocada");
            pathDispatcher = "index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(pathDispatcher);
        rd.forward(request, response);

    }

    /**
     * Devuelve el usuario correspondiente al nombre y clave entregada.
     *
     * @param nombre
     * @param clave
     * @return usuario existente, null si no existe el usuario.
     */
    private Usuario login(String nombre, String clave) {
        UsuarioDAO dao = new UsuarioImplDAO();
        List<Usuario> usuarios = dao.read();
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.getClave().equals(clave) && usuario.getCorreo().equals(nombre)) {
                    return usuario;
                }
            }
        }
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
        return "Servlet encargado de validar el ingreso de usuarios al sistema.";
    }// </editor-fold>

}
