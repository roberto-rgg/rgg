<%-- 
    Document   : home
    Created on : 20-07-2016, 16:58:12
    Author     : Roberto
--%>

<%@page import="modelo.entites.Usuario"%>
<%@page import="controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->

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


                    <table class="table table-condensed" >
                        <thead>
                            <tr>
                                <th>nombre variable OID</th>
                                <th>valor</th>
                                <th>descripcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>SYSTEM_PART_NUMBER </td>
                                <td>${celda.systemPartNumber}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> SYSTEM_SERIAL </td>
                                <td>${celda.systemSerial}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> GPS_LATITUDE</td>
                                <td>${celda.gpsLatitude}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> GPS_LONGITUDE</td>
                                <td>${celda.gpsLongitud}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>GMT_OFFSET_HOURS </td>
                                <td>${celda.gmtOffsetHours}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> GMT_OFFSET_QUARTER_HOURS</td>
                                <td>${celda.gmtOffsetQuarter}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> SYSTEM_TIME_LOCAL </td>
                                <td>${celda.systemTimeLocal}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> SYSTEM_STATE_DESC </td>
                                <td>${celda.systemStateDesc}</td>
                                <td></td>
                            </tr>
                        </tbody>

                    </table>


                    <section class="page-content">

                        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-body no-padding">
                                        <div class="mini-card mini-card-primary">
                                            <div class="mini-card-left">
                                                <span>Alarmas Activas ultimos 5 dias</span>
                                                <h2>1</h2>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-primary">
                                                    <span class="peity-line">0,0,1,0,0</span>
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
                                                <span>Actividad ultimos 5 dias</span>
                                                <h2>3</h2>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-success">
                                                    <span class="peity-bar">0,6,0,6,6</span>
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
                                                <span>Login ultimos 5 dias</span>
                                                <h2>10</h2>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-info">
                                                    <span class="peity-line">2,0,1,4,1,0</span>
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
                                                <span>Baterias detectadas</span>
                                                <h2>1</h2>
                                            </div>
                                            <div class="mini-card-right">
                                                <div class="bemat-mini-chart bemat-mini-chart-danger">
                                                    <span class="peity-bar">0,0,1,0</span>
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
                                            Caracteristicas											<span class="label label-primary pull-right">Online</span>
                                        </header>

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Comprobar</a></li>
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
                                                                                        <p>ElectraGen V1.0</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Tiempo Online</h3>
                                                                                        <p>00:00:00:00</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Modelo</h3>
                                                                                        <p>ME-4.5kW-48V-03-J</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Ubicación</h3>
                                                                                        <p>Santiago, Chile</p>
                                                                                    </div>
                                                                                </li>
                                                                            </ul></td>
                                                                        <td><ul class="list">
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Servicios</h3>
                                                                                        <p>Servicio 1</p>
                                                                                        <p>Servicio 2</p>
                                                                                        <p>Servicio 3</p>
                                                                                        <p>Servicio 4</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Numbero IF</h3>
                                                                                        <p>00:00:00:00:00</p>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="list-item list-2-line">
                                                                                    <div class="list-item-text layout-column">
                                                                                        <h3>Dirección RED</h3>
                                                                                        <p>IP 127.0.0.1</p>
                                                                                        <p>Mask 255.2555.255.0</p>
                                                                                        <p>Gateway 127.0.0.1</p>
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
                                                                <h4 class="no-margin-top margin-bottom-2">Voltage Output: <span class="pull-right">220,547</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="determinate" data-type="primary" data-value="30"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper margin-vertical-4">
                                                                <h4 class="no-margin-top margin-bottom-2">Amperage Output: <span class="pull-right">20,421</span></h4>
                                                                <div class="linear-progress-demo " data-toggle="linear-progress" data-mode="indeterminate" data-type="primary" data-value="57"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <div class="stat-wrapper">
                                                                <h4 class="no-margin-top margin-bottom-2">Power: <span class="pull-right">278 Watts</span></h4>
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
                                                        <div class="micro-stats_title flex padding-horizontal-2">Power</div>
                                                        <div class="micro-stats_icons"><span class="label label-danger"><i class="material-icons">trending_up</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="87" data-type="warning" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Temperatura </div>
                                                        <div class="micro-stats_icons"><span class="label label-warning"><i class="material-icons">report_problem</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="25" data-type="success" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Filtro</div>
                                                        <div class="micro-stats_icons"><span class="label label-success"><i class="material-icons">trending_down</i></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="micro-stats layout layout-row layout-align-center margin-top-3">
                                                        <div class="micro-chart-1" data-toggle="simple-pie-chart" data-percent="57" data-type="primary" data-size="45" data-line-width="3"></div>
                                                        <div class="micro-stats_title flex padding-horizontal-2">Mantenimiento</div>
                                                        <div class="micro-stats_icons"><span class="label label-primary"><i class="material-icons">trending_up</i></span></div>
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

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Refresh</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-body no-top-padding">
                                        <div class="layout layout-align-center-vertical">
                                            <div class="bemat-pie-chart" data-toggle="simple-pie-chart" data-percent="89" data-type="primary"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <header>Bateria</header>

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Refresh</a></li>
                                                </ul>
                                            </div>
                                        </div>
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
                                        <header>Tanque Externo</header>

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Refresh</a></li>
                                                </ul>
                                            </div>
                                        </div>
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
                                        <header>Voltaje Actual</header>

                                        <div class="panel-heading-tools">
                                            <div class="btn-group">
                                                <a class="btn btn-icon-toggle panel-tools-menu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="material-icons">more_vert</i></a>
                                                <ul class="dropdown-menu dropdown-menu-right">
                                                    <li><a href="#">Refresh</a></li>
                                                </ul>
                                            </div>
                                        </div>
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
