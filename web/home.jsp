<%-- 
    Document   : home
    Created on : 20-07-2016, 16:58:12
    Author     : Roberto
--%>

<%@page import="controller.helper.ConverterHelper"%>
<%@page import="snmp.SnmpDataSource"%>
<%@page import="snmp.SnmpCommunication"%>
<%@page import="modelo.entites.FuelCell"%>
<%@page import="snmp.SnmpOID"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="snmp.SnmpObject"%>
<%@page import="modelo.entites.Usuario"%>
<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <%!
        private FuelCell celda;
        private String descripcion;
        private String tiempoOnline;
        private String modelo;
        private String ubicacion;
        private String totalCiclos;
        private String totalCiclosStack1;
        private String totalCiclosStack2;
        private String estadoActual;
        private String warning384;
        private String warning385;
        private String warning386;
        private String warning387;
        private boolean systemfaulted;
        private boolean sdCardPresent;
        private SnmpCommunication snmpCom;

    %>

    <%

        if (request.getSession().getAttribute(LoginController.USUARIO) == null) {
            request.setAttribute(LoginController.ERROR_MENSAJE, "Sesion ha Expirado");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }
        
        snmpCom = new SnmpCommunication(null, null, 2, null, 1);
        SnmpDataSource source = new SnmpDataSource();
        celda = source.getCelda();
        descripcion = source.retrieveSnmpValueTEST(FuelCell.SYS_DESCR);
        tiempoOnline = source.retrieveSnmpValueTEST(FuelCell.SYS_LOCATION);
       
        double combustible = ConverterHelper.doubleValue("110");
        combustible = ((combustible/225)*100);

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

                    <section class="page-header alternative-header">
                        <div class="page-header_title">

                            <h1>
                                Principal.
                                <span class="page-header_subtitle">Bienvenido</span>
                            </h1>
                        </div>
                    </section>



                    <section class="page-content">

                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-primary">
                                            <div class="mini-card-left">
                                                <span>Fallas últimos 7 días</span>
                                                <h2>#FALLAS</h2>
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
                                                <h2>#ADVERTENCIAS</h2>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-success">
                                                    <span class="peity-bar">1,5,0,6,0,6,6</span>
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
                                                <h2>#ARRANQUES</h2>
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
                                                <h2>#POTENCIA</h2>
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

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>
                                            Caracteristicas											
                                            <span class="label label-success pull-right " style="margin: 10px;padding: 10px;">En Falla</span>
                                            <span class="label label-success pull-right " style="margin: 10px;padding: 10px;">Tarjeta SD presente</span>
                                            <span class="label label-danger pull-right " style="margin: 10px;padding: 10px;">Online</span>
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
                                                                                        <p><%= descripcion %></p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Tiempo Online</h3>
                                                                                        <p>#VARIABLE_70</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Modelo</h3>
                                                                                        <p>#DATA_BASE</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Ubicación</h3>
                                                                                        <p>Santiago, Chile</p>
                                                                                    </div>
                                                                                </li>
                                                                            </ul></td>
                                                                        <td>
                                                                            <ul class="list">
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Ciclos Celda</h3>
                                                                                        <p>Total:</p>
                                                                                        <h3>Ciclos Stack</h3>
                                                                                        <p>Stack 1</p>
                                                                                        <p>Stack 2</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Estado Actual</h3>
                                                                                        <p>#VARIABLE_5</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Últimas 4 Advertencias</h3>
                                                                                        <p>#warning_1</p>
                                                                                        <p>#warning_2</p>
                                                                                        <p>#warning_3</p>
                                                                                        <p>#warning_4</p>
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
                                                                <h4 class="no-margin-top margin-bottom-2">Voltage Salida: <span class="pull-right">220,547</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="30"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper margin-vertical-4">
                                                                <h4 class="no-margin-top margin-bottom-2">Corriente Salida: <span class="pull-right">20,421</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="indeterminate" data-type="primary" data-value="57"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper">
                                                                <h4 class="no-margin-top margin-bottom-2">Potencia: <span class="pull-right">278 Watts</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="75"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                            <div class="row">
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="52" data-type="danger" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Temperatura Reformador</div>
                                                        <div class="micro-stats_icons"><span class="label label-danger"><i class="material-icons">trending_up</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="87" data-type="warning" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Temperatura Membrana</div>
                                                        <div class="micro-stats_icons"><span class="label label-warning"><i class="material-icons">report_problem</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="25" data-type="success" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Días último funcionamiento</div>
                                                        <div class="micro-stats_icons"><span class="label label-success"><i class="material-icons">trending_down</i></span></div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Combustible</header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="<%= combustible %>" data-type="primary"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Consumo</header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="73" data-type="success"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Potencia Generada</header>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="100" data-type="info"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Días faltante para la mantención</header>

                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart-live-update" data-toggle="simple-pie-chart" data-percent="37" data-type="primary"></div>
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
