<%-- 
    Document   : index
    Created on : 18-07-2016, 15:17:45
    Author     : Roberto
--%>

<%@page import="snmp.Discovery"%>
<%@page import="modelo.report.ServiceReportDataBase"%>
<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style-main.css" rel="stylesheet">
        <!-- etiqueta head para home -->
        <%@include file="include/html/head-home.html" %>
        <title>Inicio</title>
    </head>
    <%
        
        %>
    <body id="page-authentication" class="container-fluid" >

        <div id="authentication-box" class="authentication-style1">
            <div class="authentication-box-wrapper">
                <div class="panel panel-default">
                    <div class="panel-body no-padding">

                        <div class="authentication-header">
                            <div class="logo-box logo-box-primary-light padding-top-5">
                                <img src="img/logo.png" width="100%" style="margin-top:0px;">
                            </div>
                            <span style=" z-index: 0;">Ingrese con su cuenta</span>
                        </div>

                        <div class="authentication-body">
                            <%                        String mensaje = "";
                                if (request.getAttribute(LoginController.ERROR_MENSAJE) != null) {
                                    mensaje = request.getAttribute(LoginController.ERROR_MENSAJE).toString();
                            %>
                            <div class="alert alert-danger" role="alert" style="margin-top: 20px;">
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <span class="sr-only">Error:</span>
                                <%= mensaje %>
                            </div>
                            <%  }%>

                            <form class="form" role="form" action="/BallardWeb/Login" method="POST">
                                <div class="form-group floating-label">
                                    <input type="text" class="form-control" id="input_usuario" name="input_correo">
                                    <label for="input_usuario">Correo Electrónico</label>
                                </div>
                                <div class="form-group floating-label">
                                    <input type="password" class="form-control" id="input_clave" name="input_clave">
                                    <label for="input_clave">Contraseña</label>
                                </div>

                                <button type="submit" class="btn btn-info btn-raised btn-block">Ingresar</button>
                                <div class="authentication-body-footer margin-top-5">

                                    <div class="text-right">
                                        <a href="#">Olvido su contraseña?</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                </div>
            </div>

        </div>

        <!--javascripts necesarios para la plantilla y sus funcionalidades -->
        <%@include file="include/html/full-js.html" %>


    </body>
</html>
