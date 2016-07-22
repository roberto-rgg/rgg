<%-- 
    Document   : menu_lateral
    Created on : 21-07-2016, 12:00:04
    Author     : Roberto
--%>

<%@page import="controller.LoginController"%>
<%@page import="modelo.entites.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute(LoginController.USUARIO);
%>

<aside id="left-content" data-toggle="open" data-default="open" data-size="">
    <header class="header-container">
        <div class="header-wrapper">
            <div id="header-brand">
                <div class="logo padding-left-2">
                    <img src="img/logo.png" width="35%"><img src="img/ballard.png" width="35%">
                </div>
            </div>
        </div>
    </header>
    <div id="sidebar-wrapper">
        <!-- Datos del Usuario -->
        <div id="userbox">
            <div id="useravatar">
                <div class="avatar-thumbnail">
                    <img src="img/avatar.png" class="img-circle"/>
                </div>
            </div>

            <div id="userinfo">
                <div class="btn-group">
                    <button type="button" class="btn btn-default-bright btn-flat dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= usuario.getCorreo() %>
                        <i class="material-icons">arrow_drop_down</i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="material-icons">person</i>Perfil</a></li>
                        <li><a href="#"><i class="material-icons">settings</i>Ajustes</a></li>
                        <li class="divider"></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="material-icons">exit_to_app</i> Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </div> <!-- END: #userbox -->

        <!-- ACA VAN LOS LINKS A LOS DISTINTOS TIPOS DE CONTENIDO CENTRAL -->
        <nav id="sidebar">
            <ul>
                <li>
                    <a href="home.jsp" >
                        <span class="menu-item-ico"><i class="material-icons">dashboard</i></span>
                        <span class="menu-item-name">Página Principal</span>
                    </a>
                </li>
                <li>
                    <a href="home_alarmas.jsp">
                        <span class="menu-item-ico"><i class="material-icons">extension</i></span>
                        <span class="menu-item-name">Alarmas</span>
                    </a>

                </li>
                <li>
                    <a href="home_estadisticas.jsp">
                        <span class="menu-item-ico"><i class="material-icons">format_align_left</i></span>
                        <span class="menu-item-name">Estadisticas</span>
                    </a>
                </li>
                <li>
                    <a href="home_configuracion.jsp">
                        <span class="menu-item-ico"><i class="material-icons">view_compact</i></span>
                        <span class="menu-item-name">Configuración</span>
                    </a>

                </li>
                <li class="nav-main-heading">
                    <span class="sidebar-mini-hide">Añadir/Quitar</span>
                </li>
                <li>
                    <a href="">
                        <span class="menu-item-ico"><i class="material-icons">insert_drive_file</i></span>
                        <span class="menu-item-name">Generador</span>
                    </a>

                </li>
                <li>
                    <a href="page-calendar.html" class="btn-ripple">
                        <span class="menu-item-ico"><i class="material-icons">event</i></span>
                        <span class="menu-item-name">Alarmas</span>
                    </a>
                </li>
                <li>
                    <a href="page-charts.html" class="btn-ripple">
                        <span class="menu-item-ico"><i class="material-icons">insert_chart</i></span>
                        <span class="menu-item-name">Correos de Alarma</span>
                    </a>

                </li>



            </ul>
        </nav><!-- END: nav#sidebar -->	
    </div>
</aside>
