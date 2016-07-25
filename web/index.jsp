<%-- 
    Document   : index
    Created on : 18-07-2016, 15:17:45
    Author     : Roberto
--%>

<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style-main.css" rel="stylesheet">
        <title>Inicio</title>
    </head>
    <body>
        
        <div class="panel panel-default" style="margin-top: 50px;width: 40%;margin-left: 50px;">
            <div class="panel-body">
                <div class="panel-heading">
                    <h3 class="panel-title">Iniciar Sesión</h3>
                </div>
                <div class="panel-body">
                    <form method="POST" action="/BallardWeb/LoginController" >
                        <div class="form-group">
                            <label for="input_usuario">Correo Electrónico</label>
                            <input id="input_usuario" required="true" type="email" class="form-control"  name="input_correo" placeholder="Usuario">
                        </div>
                        <div class="form-group">
                            <label for="input_clave">Contraseña</label>
                            <input id="input_clave" required="true" type="password" class="form-control"  name="input_clave" placeholder="Contraseña">
                        </div>

                        <button type="submit" class="btn btn-sm btn-primary">Ingresar Sistema</button>

                    </form>

                    <%                        
                        String mensaje = "";
                        if (request.getAttribute(LoginController.ERROR_MENSAJE) != null) {
                            mensaje = request.getAttribute(LoginController.ERROR_MENSAJE).toString();
                    %>
                    <div class="alert alert-danger" role="alert" style="margin-top: 20px;">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        <%= mensaje %>
                    </div>
                    <%  }%>

                </div>
            </div>
        </div>



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
