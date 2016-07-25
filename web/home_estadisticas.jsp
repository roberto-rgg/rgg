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
                                Estadísticas y reportes.
                                <span class="page-header_subtitle">Bienvenido a Ballard Control</span>
                            </h1>
                        </div>
                    </section>
                    <h1>Estadisticas y reportes</h1>
                </section><!-- /#right-content -->
            </section><!-- /#right-content-wrapper -->

        </div>

        <!--javascripts necesarios para la plantilla y sus funcionalidades -->
        <%@include file="include/html/full-js.html" %>

    </body>
</html>
