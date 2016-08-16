<%-- 
    Document   : param_setter
    Created on : 01-08-2016, 13:13:31
    Author     : Roberto
--%>

<%@page import="controller.helper.ConverterHelper"%>
<%@page import="controller.ControllerSnmpSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String parametro = request.getParameter(ControllerSnmpSet.PARAM_PARAMETRO);
    String id = request.getParameter("param_id");
    int tipoParametro = ConverterHelper.integerValue(request.getParameter(ControllerSnmpSet.PARAM_TIPO));


%>

<button type="button" class="btn btn-raised btn-info" data-toggle="modal"  data-target="#modal_param_<%=id%>">Configurar</button>

<div style="display: none;" id="modal_param_<%=id%>" class="modal fade">
    <div style="transform: scale(0.146667); opacity: 0; top: 425.3px; left: 348px;" class="modal-dialog">
        <div class="modal-content">
            <form class="form" action="/BallardWeb/SnmpSet" method="POST" >
                <div class="modal-header">
                    <h4 class="modal-title">Configuracion Parametro</h4>
                </div>
                <div class="modal-body">


                    <p>Administrar Nuevo valor del parametro</p>
                    <% if (tipoParametro == ControllerSnmpSet.TIPO_BOOLEAN) {    %>
                    <% boolean toggle = Boolean.parseBoolean(parametro);  %>
                    <div class="btn-group" data-toggle="buttons">

                        <% if (toggle) { %>
                        <label class="btn btn-primary active">
                            <input type="radio" name="options" id="option1" autocomplete="off" checked value="on" >ON
                        </label>
                        <label class="btn btn-primary">
                            <input type="radio" name="options" id="option2" value="off" autocomplete="off">OFF
                        </label>
                        <% } else { %>
                        <label class="btn btn-primary">
                            <input type="radio" name="options" id="option1" autocomplete="off" value="on" >ON
                        </label>
                        <label class="btn btn-primary active">
                            <input type="radio" name="options" id="option2" value="off" checked="true"  autocomplete="off">OFF
                        </label>
                        <% } %>
                    </div>

                    <%     } else if (tipoParametro == ControllerSnmpSet.TIPO_STRING) {%>

                    <div class="form-group">
                        <input type="text" required="true" name="param_string" class="form-control" id="regular1" value="<%= parametro%>" >
                        <label for="regular1">Valor</label>
                    </div>
                    <% } else if (tipoParametro == ControllerSnmpSet.TIPO_INT) {%>

                    <div class="form-group">
                        <input type="number" required="true" name="param_number" class="form-control" id="regular1" value="<%= parametro%>" >
                        <label for="regular1">Valor</label>
                    </div>

                    <% }%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-flat btn-ripple materialRipple-light materialRipple-btn" data-dismiss="modal">Cancelar<div class="materialRipple-md-ripple-container"></div></button>
                    <button type="submit" class="btn btn-primary btn-flat btn-ripple materialRipple-light materialRipple-btn">Aceptar<div class="materialRipple-md-ripple-container"></div></button>
                </div>
            </form>
        </div>
    </div>
</div>
