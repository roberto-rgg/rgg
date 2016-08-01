<%-- 
    Document   : home
    Created on : 20-07-2016, 16:58:12
    Author     : Roberto
--%>

<%@page import="controller.ControllerSnmpSet"%>
<%@page import="controller.ControllerUtilidades"%>
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
        String sysName = request.getAttribute(ControllerUtilidades.SYS_NAME).toString();

        String sysLocation = request.getAttribute(ControllerUtilidades.SYS_LOCATION).toString();

        boolean limitHeatersto500 = (boolean) request.getAttribute(ControllerUtilidades.PARAMS_LIMIT_HEATERS_TO_500W);

        boolean coldWeatherKitPresent = (boolean) request.getAttribute(ControllerUtilidades.PARAMS_COLD_WEATHER_KIT_PRESENT);

        double lowFuelLevelSetPoint = (double) request.getAttribute(ControllerUtilidades.PARAMS_LOW_FUEL_LEVEL_SETPOINT);

        double startVoltageFirstStack = (double) request.getAttribute(ControllerUtilidades.PARAMS_START_VOLTAGE_FIRST_STACK);

        double startVoltageSecondStack = (double) request.getAttribute(ControllerUtilidades.PARAMS_START_VOLTAGE_SECOND_STACK);

        double floatVoltage = (double) request.getAttribute(ControllerUtilidades.PARAMS_FLOAT_VOLTAGE);

        int maintenanceHour = (int) request.getAttribute(ControllerUtilidades.PARAMS_MAINTENANCE_HOUR);

        double daysBetweendiags = (double) request.getAttribute(ControllerUtilidades.PARAMS_DAYS_BETWEEN_DIAGS);

        int maintenanceHour2 = (int) request.getAttribute(ControllerUtilidades.PARAMS_MAINTENANCE_HOUR_2);

        boolean externalFuelSensor = (boolean) request.getAttribute(ControllerUtilidades.PARAMS_EXTERNAL_FUEL_SENSOR);

        double extenalFuelSensorEmpty = (double) request.getAttribute(ControllerUtilidades.PARAMS_EXTERNAL_FUEL_SENSOR_EMPTY);

        double extenalFuelSensorFull = (double) request.getAttribute(ControllerUtilidades.PARAMS_EXTERNAL_FUEL_SENSOR_FULL);

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
                                Utilidades.
                                <span class="page-header_subtitle">Bienvenido</span>
                            </h1>
                        </div>
                    </section>
                    <section class="page-content">
                        <h1>Utilidades</h1>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>

                                        </header>
                                        <table class="table" style="margin: 30px;">
                                            <thead>
                                                <tr>
                                                    <th>id</th>
                                                    <th>Parámetro</th>
                                                    <th>Estado Actual</th>
                                                    <th>Acciones</th>                                                   
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th>1</th>
                                                    <th>Nombre Sistema</th>
                                                    <th><%= sysName%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= sysName%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="187" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>1</th>
                                                    <th>Ubicación del Sistema</th>
                                                    <th><%= sysLocation%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= sysLocation%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="188" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>1</th>
                                                    <th>limit heaters to 500w</th>
                                                    <th>
                                                        <% if (limitHeatersto500) { %>
                                                        Habilitado
                                                        <% } else {  %>
                                                        No Habilitado
                                                        <% }%>
                                                    </th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= limitHeatersto500%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_BOOLEAN%>" />
                                                            <jsp:param name="param_id" value="1" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>2</th>
                                                    <th>Cold Weather Kit Present</th>
                                                    <th>
                                                        <% if (coldWeatherKitPresent) { %>
                                                        Habilitado
                                                        <% } else {  %>
                                                        No Habilitado
                                                        <% }%>
                                                    </th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= coldWeatherKitPresent%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_BOOLEAN%>" />
                                                            <jsp:param name="param_id" value="2" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>4</th>
                                                    <th>Low Fuel Level SetPoint</th>
                                                    <th><%= lowFuelLevelSetPoint%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= lowFuelLevelSetPoint%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="3" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>5</th>
                                                    <th>Start Voltage First Stack</th>
                                                    <th><%= startVoltageFirstStack%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= startVoltageFirstStack%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="5" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>6</th>
                                                    <th>Start Voltage Second Stack</th>
                                                    <th><%= startVoltageSecondStack%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= startVoltageSecondStack%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="6" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>7</th>
                                                    <th>Float Voltage</th>
                                                    <th><%= floatVoltage%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= floatVoltage%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="7" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>10</th>
                                                    <th>Maintenance hour</th>
                                                    <th><%= maintenanceHour%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= maintenanceHour%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="10" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>

                                                <tr>
                                                    <th>13</th>
                                                    <th>Days Between Diags</th>
                                                    <th><%= daysBetweendiags%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= daysBetweendiags%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="13" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>19</th>
                                                    <th>Maitenance Hour</th>
                                                    <th><%= maintenanceHour2%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= maintenanceHour2%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="19" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>20</th>
                                                    <th>External Fuel Sensor</th>
                                                    <th>
                                                        <% if (externalFuelSensor) { %>
                                                        No Habilitado
                                                        <% } else {  %>
                                                        No Habilitado
                                                        <% }%>
                                                    </th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= externalFuelSensor%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_BOOLEAN%>" />
                                                            <jsp:param name="param_id" value="20" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>21</th>
                                                    <th>External Fuel Empty</th>
                                                    <th><%= extenalFuelSensorEmpty%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= extenalFuelSensorEmpty%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="21" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>22</th>
                                                    <th>External Fuel Sensor Full</th>
                                                    <th><%= extenalFuelSensorFull%></th>
                                                    <th>
                                                        <jsp:include page="/include/jsp/param_setter.jsp" flush="true" >
                                                            <jsp:param name="param_parametro" value="<%= extenalFuelSensorFull%>" />
                                                            <jsp:param name="param_tipo" value="<%= ControllerSnmpSet.TIPO_STRING%>" />
                                                            <jsp:param name="param_id" value="22" />
                                                        </jsp:include>
                                                    </th>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </section>


                </section><!-- /#right-content -->
            </section><!-- /#right-content-wrapper -->

        </div>

        <!--javascripts necesarios para la plantilla y sus funcionalidades -->
        <%@include file="include/html/full-js.html" %>

    </body>
</html>
