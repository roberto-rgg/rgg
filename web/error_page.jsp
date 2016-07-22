<%-- 
    Document   : error_page
    Created on : 22-07-2016, 13:53:15
    Author     : Roberto
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Error</title>
    </head>
    <body>
        <h1>Un Error ha Ocurrido</h1>
        <%= exception.toString()%>
        <%
            out.println("<!--");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            out.print(sw);
            sw.close();
            pw.close();
            out.println("-->");
        %>

    </body>
</html>
