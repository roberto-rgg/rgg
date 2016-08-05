<%-- 
    Document   : home
    Created on : 18-07-2016, 11:34:33
    Author     : Roberto
--%>

<%@page import="snmp.Discovery"%>
<%@page import="controller.ResumenController"%>
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

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/rgg/discovery.js"></script>

        <title>Discovery Nodos</title>
    </head>
    <body>
        <%
            if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
                request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        %>

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
                    <th>Conectando</th>
                    <th>Estado Conexión</th>
                    <th>Detalles</th>
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

                    <td> 

                        <script>

                            discovery("<%= n.getIp()%>", "<%= n.getId()%>");

                        </script>

                        <div class="progress" style="width: 200px;">
                            <div id="bar_nodo_<%= n.getId()%>" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                <span id="bar_text_nodo_<%= n.getId()%>" >Estableciendo Conexión</span>
                            </div>
                        </div>

                    </td>
                    <td>
                        <div id="status_nodo_<%= n.getId()%>" style="width: 300px;" >En Espera de Respuesta</div>
                    </td>
                    <td>
                        <form action="/BallardWeb/Resumen" method="POST" >
                            <input type="hidden" value="<%= n.getId()%>" name="<%= ResumenController.PARAM_NODO%>">
                            <input id="modo_nodo_<%= n.getId()%>" type="hidden" name="<%= ResumenController.PARAM_MODO%>">

                            <button id="btn_nodo_<%= n.getId()%>" type="submit" class="btn btn-primary" disabled="disabled" style="width: 200px;" onclick="load_home()" >Detalles Nodo</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    }
                %>

            </tbody>
        </table>
       
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top: 300px;">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">En Espera de Resumen</h4>
                    </div>
                    <div class="modal-body">
                        <div class="progress">
                            <div id="bar_loading" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                <span >Estableciendo Conexión</span>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
