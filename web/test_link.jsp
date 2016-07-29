<%-- 
    Document   : test_link
    Created on : 29-07-2016, 18:08:05
    Author     : Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getAttribute("nombre").toString();
            String apellido = request.getAttribute("apellido").toString();
        %>

        <h1>Hola : <%= nombre %> <%= apellido %> </h1>
    </body>
</html>
