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

        <%@include file="/include/html/head-home.html" %>
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>-->
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="js/rgg/discovery.js" type="text/javascript"></script>
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
        <jsp:useBean id="usuario" scope="session" class="modelo.entites.Usuario" ></jsp:useBean>


            <section class="page-header alternative-header">
                <div class="page-header_title">
                    <h1>
                        Página de Discovery.
                        <span class="page-header_subtitle">Bienvenido: ${usuario.correo}</span>      

                </h1>

            </div>
        </section>

        <form method="POST" action="/BallardWeb/Logout" >
            <button type="submit" class="btn btn-primary"  >Cerrar Sesión</button>
        </form>
        <div class="panel panel-info panel-discovery"> 
            <div class="panel-heading"> 
                <h3 class="panel-title panel-title-nodos">Nodos Registrados</h3> 
            </div> 
            <div class="panel-body"> 
                <table class="table table-striped table-discovery" >
                    <thead >
                        <tr>
                            <th ><h2 class="text-success">id</h2></th>
                            <th><h2 class="text-success">Descripción</h2></th>
                            <th><h2 class="text-success">Conectando</h2></th>
                            <th><h2 class="text-success">Estado Conexión</h2></th>
                            <th><h2 class="text-success">Detalles</h2></th>
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
                            <td> 
                                <script>

                                    discovery("<%= n.getIp()%>", "<%= n.getId()%>");

                                </script>

                                <div class="progress progress-bar-nodo" >
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

                                    <button id="btn_nodo_<%= n.getId()%>" type="submit" class="btn btn-primary" disabled="disabled" data-toggle="modal" data-target="#modal_discovery"  style="width: 200px;"  >Detalles Nodo</button>
                                </form>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>

                    </tbody>
                </table>

                <div class="panel-footer panel-success"> 
                    <h3 class="panel-title panel-title-nodos text-success">

                    </h3> 
                </div>
            </div> 


            <!-- Modal -->
            <div class="modal fade"  id="modal_discovery" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">En Espera de Resumen</h4>
                        </div>
                        <div class="modal-body">
                            <div class="progress">
                                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                    <span >Estableciendo Conexión</span>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="/include/html/full-js.html" %>

    </body>
</html>
