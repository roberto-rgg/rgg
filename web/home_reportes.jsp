<%-- 
    Document   : home
    Created on : 20-07-2016, 16:58:12
    Author     : Roberto
--%>

<%@page import="modelo.entites.Usuario"%>
<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <%
        if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    %>

    <!-- etiqueta head para home -->
    <%@include file="include/html/head-home.html" %>

    <body class="dark-sidebar dark-header-brand container-fluid">
        <div id="page-wrapper">

            <!-- menu lateral izquierdo -->
            <%@include file="include/jsp/menu_lateral.jsp" %>

            <section id="right-content">

                <%@include file="include/jsp/header.jsp" %>

                <section id="right-content-wrapper">
                    <!-- cabezera contenido central -->
                    <section class="page-header alternative-header">
                        <div class="page-header_title">

                            <h1>
                                Reportes 
                                <span class="page-header_subtitle">Bienvenido</span>


                            </h1>
                        </div>
                    </section>
                    <h1 style="margin: 30px;" > Reportes </h1>
                    
                    <section class="page-content">
                        <%@include file="/include/jsp/header_reportes.jsp" %>
                    </section>
                    
                </section><!-- /#right-content -->
            </section><!-- /#right-content-wrapper -->

        </div>

        <!--javascripts necesarios para la plantilla y sus funcionalidades -->
        <%@include file="include/html/full-js.html" %>

        <!-- Modal -->
        <div class="modal fade" id="modal_discovery_2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top: 300px;">
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
