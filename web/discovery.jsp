<%-- 
    Document   : home
    Created on : 18-07-2016, 11:34:33
    Author     : Roberto
--%>

<%@page import="snmp.Discovery"%>
<%@page import="controller.CeldaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.LoginController"%>
<%@page import="modelo.entites.Usuario"%>
<%@page import="modelo.entites.Nodo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.interfaces.NodoDAO"%>
<%@page import="modelo.dao.NodoImplDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style-main.css" rel="stylesheet">
        <title>Discovery Nodos</title>
    </head>
    <body>
        <jsp:useBean id="usuario" scope="session" class="modelo.entites.Usuario"></jsp:useBean>
            <div class="alert alert-info" role="alert" style="margin: 30px"> 
                <strong>Bienvenido :</strong> ${usuario.correo}
            <br> 

        </div>




        <table class="table table-condensed table-striped" style="margin: 30px;">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descripción</th>
                    <th>Dirección IP</th>
                    <th>Puerto</th>
                    <th>Estado</th>
                    <th>Online</th>
                    <th>Ver Detalles</th>
                </tr>
            </thead>
            <tbody>
                <%

                    if (request.getSession().getAttribute(LoginController.USUARIO) != null) {
                        NodoDAO dao = new NodoImplDAO();
                        List<Nodo> nodos = dao.read(usuario);

                        for (Nodo n : nodos) {

                %>
                <tr>
                    <td><%= n.getId()%></td>
                    <td><%= n.getDescripcion()%></td>
                    <td><%= n.getIp()%></td>
                    <td><%= n.getPuerto()%></td>
                    <td><%= n.getEstado()%></td>
                    <td>
                        <%
                            Discovery d = new Discovery();
                            if (d.nodoIsOnline(n.getIp())) {  %>
                        <i class="icon-black icon-ok-circle" />
                        En Linea
                        <% } else {%>
                        <i class="icon-black icon-remove-circle" />
                        Desconectado
                        <% } %>
                    </td>

                    <td> 
                        <%
                            if (d.nodoIsOnline(n.getIp())) {
                        %>
                        <form action="/BallardWeb/Resumen" method="POST" >
                            <input type="hidden" value="<%= n.getId()%>" name="<%= CeldaController.PARAM_NODO%>">
                            <button class="btn btn-info" type="submit"   >
                                Detalles
                            </button>
                        </form>
                        <% } else {%>
                        <button class="btn btn-danger disabled"  type="submit" >
                            Detalles
                        </button>
                        <% } %>
                    </td>
                </tr>
                <%
                        }
                    }
                %>

            </tbody>
        </table>



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
