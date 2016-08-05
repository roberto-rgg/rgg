<%-- 
    Document   : header_reportes
    Created on : 01-08-2016, 18:41:12
    Author     : Roberto
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="modelo.report.ServiceReportDataBase"%>
<%@page import="modelo.report.ReportFault"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="modelo.entites.FuelCell"%>
<%@page import="controller.ResumenController"%>
<%@page import="java.util.List"%>
<%@page import="modelo.entites.reports.SystemWarning"%>
<%@page import="modelo.report.ReportWarning"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    FuelCell celda = (FuelCell) request.getSession().getAttribute(ResumenController.PARAM_CELDA);
    ReportWarning service = new ReportWarning(celda);
    ReportFault serviceFault = new ReportFault(celda);

    int[] totalFaultByDay = serviceFault.countFaultLastDays(7);
    int totalFaults = serviceFault.countFaultsLastDays(7);

    int[] totalWarningsByDay = service.countWarningsLastDays(7);
    int totalWarnings = service.countWarnigsLastDays(7);

    ServiceReportDataBase s = new ServiceReportDataBase(celda);
    int ultimosArranques = s.countUltimosArranques(7);
    int ultArr1 = s.countUltimosArranques(6);
    int ultArr2 = s.countUltimosArranques(5);
    int ultArr3 = s.countUltimosArranques(4);
    int ultArr4 = s.countUltimosArranques(3);
    int ultArr5 = s.countUltimosArranques(2);
    int ultArr6 = s.countUltimosArranques(1);

    double potGen1 = s.potenciaGeneradaPorDia(1);
    double potGen2 = s.potenciaGeneradaPorDia(2);
    double potGen3 = s.potenciaGeneradaPorDia(3);
    double potGen4 = s.potenciaGeneradaPorDia(4);
    double potGen5 = s.potenciaGeneradaPorDia(5);
    double potGen6 = s.potenciaGeneradaPorDia(6);
    double potGen7 = s.potenciaGeneradaPorDia(7);

    double potenciaGenerada2 = (potGen1 + potGen2 + potGen3 + potGen4 + potGen5 + potGen6 + potGen7)/7;
    DecimalFormat format = new DecimalFormat("0.0");


%>

<div class="row">
    <div class="col-lg-3 col-sm-6">
        <div class="panel panel-default">
            <div class="panel-body no-padding">
                <div class="mini-card mini-card-danger">
                    <div class="mini-card-left">
                        <span>Fallas últimos 7 días</span>
                        <span class="badge badge-danger"><%= totalFaults%></span>
                    </div>
                    <div class="mini-card-right">
                        <div class="bemat-mini-chart bemat-mini-chart-danger">
                            <span class="peity-bar">
                                <%=totalFaultByDay[6]%>
                                ,<%=totalFaultByDay[5]%>
                                ,<%=totalFaultByDay[4]%>
                                ,<%=totalFaultByDay[3]%>
                                ,<%=totalFaultByDay[2]%>
                                ,<%=totalFaultByDay[1]%>
                                ,<%=totalFaultByDay[0]%>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-3 col-sm-6">
        <div class="panel panel-default">
            <div class="panel-body no-padding">
                <div class="mini-card mini-card-warning">
                    <div class="mini-card-left">
                        <span>Advertencias últimos 7 dias</span>
                        <span class="badge badge-warning"><%= totalWarnings%></span>
                    </div>
                    <div class="mini-card-right">
                        <div class="bemat-mini-chart bemat-mini-chart-warning">
                            <span class="peity-bar">
                                <%=totalWarningsByDay[6]%>
                                ,<%=totalWarningsByDay[5]%>
                                ,<%=totalWarningsByDay[4]%>
                                ,<%=totalWarningsByDay[3]%>
                                ,<%=totalWarningsByDay[2]%>
                                ,<%=totalWarningsByDay[1]%>
                                ,<%=totalWarningsByDay[0]%>
                            </span>
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
                        <span>Arranques últimos 7 días</span>
                        <span class="badge badge-success"><%= ultimosArranques%></span>
                    </div>
                    <div class="mini-card-right">
                        <div class="bemat-mini-chart bemat-mini-chart-success">
                            <span class="peity-line">
                                <%= ultimosArranques%>,
                                <%= ultArr1%>,
                                <%= ultArr2%>,
                                <%= ultArr3%>,
                                <%= ultArr4%>,
                                <%= ultArr5%>,
                                <%= ultArr6%>
                            </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="col-lg-3 col-sm-6">
        <div class="panel panel-default">
            <div class="panel-body no-padding">
                <div class="mini-card mini-card-primary">
                    <div class="mini-card-left">
                        <span>Potencia generada últimos 5 días</span>
                        <span class="badge badge-primary "><%= format.format(potenciaGenerada2) %></span>
                    </div>
                    <div class="mini-card-right">
                        <div class="bemat-mini-chart bemat-mini-chart-primary">
                            <span class="peity-line">
                                <%= potGen7 %>,
                                <%= potGen6 %>,
                                <%= potGen5 %>,
                                <%= potGen4 %>,
                                <%= potGen3 %>,
                                <%= potGen2 %>,
                                <%= potGen1 %>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>