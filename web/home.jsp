<%-- 
    Document   : home
    Created on : 20-07-2016, 16:58:12
    Author     : Roberto
--%>

<%@page import="controller.ResumenController"%>
<%@page import="modelo.entites.FuelCell"%>
<%@page import="modelo.entites.Usuario"%>
<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <%! private FuelCell celda;%>

    <%
        if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        celda = (FuelCell) request.getSession().getAttribute(ResumenController.PARAM_CELDA);

        String tiempoOnline = request.getAttribute(ResumenController.PARAM_TIEMPO_ONLINE).toString();
        String totalCiclos = request.getAttribute(ResumenController.PARAM_TOTAL_CICLOS).toString();

        String totalCiclosStack1 = request.getAttribute(ResumenController.PARAM_TOTAL_CICLOS_ST_1).toString();
        String totalCiclosStack2 = request.getAttribute(ResumenController.PARAM_TOTAL_CICLOS_ST_2).toString();
        String estadoActual = request.getAttribute(ResumenController.PARAM_ESTADO_ACTUAL).toString();
        String warning384 = request.getAttribute(ResumenController.PARAM_WARN_384).toString();
        String warning385 = request.getAttribute(ResumenController.PARAM_WARN_385).toString();
        String warning386 = request.getAttribute(ResumenController.PARAM_WARN_386).toString();
        String warning387 = request.getAttribute(ResumenController.PARAM_WARN_387).toString();
        boolean systemfaulted = (boolean) request.getAttribute(ResumenController.PARAM_SYSTEM_FAULTED);
        boolean sdCardPresent = (boolean) request.getAttribute(ResumenController.PARAM_SDCARD_PRESENT);

        String voltageOutput = request.getAttribute(ResumenController.PARAM_VOLT_OUT).toString();
        String voltageOutputPercent = request.getAttribute(ResumenController.PARAM_VOLT_OUT_PERCT).toString();

        String amperageoutput = request.getAttribute(ResumenController.PARAM_AMP_OUT).toString();
        String amperageOutputPercent = request.getAttribute(ResumenController.PARAM_VOLT_OUT_PERCT).toString();

        String potenciaOutput = request.getAttribute(ResumenController.PARAM_POTENCIA_OUT).toString();
        String potenciaOutputPercent = request.getAttribute(ResumenController.PARAM_POTENCIA_OUT_PERCT).toString();

        String tempReformador = request.getAttribute(ResumenController.PARAM_TEMP_REFORMER).toString();
        String tempReformadorPercent = request.getAttribute(ResumenController.PARAM_TEMP_REFORMER_PERCT).toString();

        String tempMembrana = request.getAttribute(ResumenController.PARAM_TEMP_MEMBRANA).toString();
        String tempMembranaPercent = request.getAttribute(ResumenController.PARAM_TEMP_MEMBRANA_PERCT).toString();

        String diasDesdeUltimoArranque = request.getAttribute(ResumenController.PARAM_DIAS_ULTIMO_ARRANQUE).toString();

        String combustible = request.getAttribute(ResumenController.PARAM_COMBUSTIBLE).toString();
        String combustiblePercent = request.getAttribute(ResumenController.PARAM_COMBUSTIBLE_PERCT).toString();

        String consumo = request.getAttribute(ResumenController.PARAM_CONSUMO).toString();
        String consumoPercent = request.getAttribute(ResumenController.PARAM_CONSUMO_PERCT).toString();

        String potenciaGenerada = request.getAttribute(ResumenController.PARAM_POTENCIA_GENERADA).toString();
        String potenciaGeneradaPercent = request.getAttribute(ResumenController.PARAM_POTENCIA_GENERADA_PERCT).toString();

        String diasParaMantencion = request.getAttribute(ResumenController.PARAM_DIAS_TO_MANTENANCE).toString();

    %>

    <!-- etiqueta head para home -->
    <%@include file="include/html/head-home.html" %>

    <body class="dark-sidebar dark-header-brand container-fluid">
        <div id="page-wrapper">

            <!-- SECCION MENU LATERAL -->
            <%@include file="include/jsp/menu_lateral.jsp" %>

            <section id="right-content">

                <!-- SECCION HEADER -->
                <%@include file="include/jsp/header.jsp" %>

                <section id="right-content-wrapper">

                    <section class="page-header alternative-header">
                        <div class="page-header_title">

                            <h1>
                                Principal.
                                <span class="page-header_subtitle">Bienvenido</span>
                            </h1>
                        </div>
                    </section>

                    <section class="page-content">
                        <!-- SECCION ESTADISTICAS -->
                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-primary">
                                            <div class="mini-card-left">
                                                <span>Fallas últimos 7 días</span>
                                                <span class="badge badge-warning">4</span>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-primary">
                                                    <span class="peity-line">1,2,0,0,1,0,0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-success">
                                            <div class="mini-card-left">
                                                <span>Advertencias últimos 7 dias</span>
                                                <span class="badge badge-warning">7</span>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-success">
                                                    <span class="peity-bar">1,2,0,3,0,1,0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-info">
                                            <div class="mini-card-left">
                                                <span>Arranques últimos 7 días</span>
                                                <span class="badge badge-warning">6</span>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-info">
                                                    <span class="peity-line">1,4,1,0</span>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-danger">
                                            <div class="mini-card-left">
                                                <span>Potencia generada últimos 5 días</span>
                                                <span class="badge badge-warning ">4</span>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-danger">
                                                    <span class="peity-bar">0,0,1,0,3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <!-- SECCION RESUMEN -->
                        <h1>Caracteristicas</h1>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>
                                            <%  if (!systemfaulted) { %>
                                            <span class="label label-success pull-right " style="margin: 10px;padding: 10px;">Sin Falla</span>
                                            <%    } else { %>
                                            <span class="label label-danger pull-right " style="margin: 10px;padding: 10px;">En Falla</span>
                                            <% }
                                                if (sdCardPresent) {   %>
                                            <span class="label label-success pull-right " style="margin: 10px;padding: 10px;">Tarjeta SD presente</span>
                                            <%  } else {  %>
                                            <span class="label label-danger pull-right " style="margin: 10px;padding: 10px;">Sin Tarjeta de Memoria</span>
                                            <% }%>
                                        </header>

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Actualizar Información</a></li>
                                                </ul>
                                            </div>
                                        </div> 
                                    </div>
                                    <div class="panel-body">
                                        <div class="statistics">
                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div id="chart">
                                                                <!--<svg class="height-5"></svg>-->

                                                                <table width="0" border="0">
                                                                    <tr>
                                                                        <td> <img src="img/generador.jpg" height="100%"></td>
                                                                        <td><ul class="list">
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Descripción</h3>
                                                                                        <p><%= celda.getSysDescrib()%></p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Tiempo Online</h3>
                                                                                        <p><%= tiempoOnline%></p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Modelo</h3>
                                                                                        <p><%= celda.getModelo()%></p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Ubicación</h3>
                                                                                        <p><%= celda.getSysLocation()%></p>
                                                                                    </div>
                                                                                </li>
                                                                            </ul></td>
                                                                        <td>
                                                                            <ul class="list">
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Ciclos Celda</h3>
                                                                                        <p>Total: <%= totalCiclos%></p>
                                                                                        <h3>Ciclos Stack</h3>
                                                                                        <p>Stack 1: <%= totalCiclosStack1%> </p>
                                                                                        <p>Stack 2: <%= totalCiclosStack2%> </p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Estado Actual</h3>
                                                                                        <p><%= estadoActual%></p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Últimas 4 Advertencias</h3>
                                                                                        <p><%= warning384%></p>
                                                                                        <p><%= warning385%></p>
                                                                                        <p><%= warning386%></p>
                                                                                        <p><%= warning387%></p>
                                                                                    </div>

                                                                            </ul></td>
                                                                    </tr>
                                                                </table>


                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-lg-4">
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper">
                                                                <h4 class="no-margin-top margin-bottom-2">Voltage Salida: <%= voltageOutput%> V<span class="pull-right">0 V , <%= celda.getNominalVoltage()%> V </span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="<%= voltageOutputPercent%>"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper margin-vertical-4">
                                                                <h4 class="no-margin-top margin-bottom-2">Corriente Salida: <%= amperageoutput%> A<span class="pull-right">20 A,<%= FuelCell.MAX_AMP%> A</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="<%= amperageOutputPercent%>"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper">
                                                                <h4 class="no-margin-top margin-bottom-2">Potencia: <%= potenciaOutput%> kW <span class="pull-right"><%= celda.getPowerRating()%> kW</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="<%= potenciaOutputPercent%>"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                            <div class="row">
                                                <div class="col-lg-3 col-sm-6">
                                                    <header><h3>Temperatura Reformador 0° ~ 460°</h3></header>
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="<%= tempReformadorPercent%>" data-type="danger" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Temperatura: <%= tempReformador%> °</div>
                                                        <div class="micro-stats_icons"><span class="label label-danger"><i class="material-icons">trending_up</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <header><h3>Temperatura membrana 0° ~ 400°</h3></header>
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">    

                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="<%= tempMembranaPercent%>" data-type="warning" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Temperatura: <%= tempMembrana%> °</div>
                                                        <div class="micro-stats_icons"><span class="label label-warning"><i class="material-icons">report_problem</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <header><h3>Días desde el último arranque</h3></header>
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="" data-type="success" data-size="45" data-line-width="3">

                                                        </div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Días: <%= diasDesdeUltimoArranque%></div>
                                                        <div class="micro-stats_icons"><span class="label label-success"><i class="material-icons">trending_up</i></span></div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- SECCION INDICADORES -->
                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>
                                            Combustible 0 ~225 lts<br/>
                                            Total en Estanque: <%= combustible%> Lt
                                        </header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="<%= combustiblePercent%>" data-type="primary"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>
                                            Consumo 0 ~ <%= celda.getStandByConsumPowerPeek()%> W<br/>
                                            Total: <%= consumo%> W
                                        </header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="<%= consumoPercent%>" data-type="success"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>
                                            Potencia Generada: 0 ~ 5000 W <br/>
                                            potencia: <%= potenciaGenerada%>
                                        </header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="<%= potenciaGeneradaPercent%>" data-type="info"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Días faltante para la mantención: <%= diasParaMantencion%></header>

                                    </div>
                                    <div class="panel-body no-top-padding" style="height: 176px;">
                                        <div class="layout layout-align-center-vertical">
                                            <h1><%= diasParaMantencion%></h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>

                    </section><!-- /#page-content -->


                </section><!-- /#right-content -->
            </section><!-- /#right-content-wrapper -->

        </div>

        <!--javascripts necesarios para la plantilla y sus funcionalidades -->
        <%@include file="include/html/full-js.html" %>

    </body>
</html>
