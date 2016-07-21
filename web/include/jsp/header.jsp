<%-- 
    Document   : header
    Created on : 21-07-2016, 12:55:13
    Author     : Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header-container">
    <div class="header-wrapper">
        <div id="header-toolbar">
            <ul class="toolbar toolbar-left">
                <li>
                    <a id="sidebar-toggle" data-state="open" href="#"><i class="material-icons">menu</i></a>
                </li>
            </ul>

            <!--
            <div id="searchbox">
                <span class="search-icon"><i class="material-icons">search</i></span>
                <input id="search-input" placeholder="Buscar" type="text" />
            </div>
            -->
            <ul class="toolbar toolbar-right">
                <li>
                    <a href="#" id="fullscreen-toggle" data-toggle="tooltip" data-placement="bottom" title="Toggle Fullscreen"><i class="material-icons">fullscreen</i></a>
                </li>
                <li id="user-profile" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <div class="avatar">

                        </div>
                        <div class="user">
                            <span class="username">Generadores</span>
                        </div>
                        <span class="expand-ico"><i class="material-icons">expand_more</i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#"><i class="material-icons">exit_to_app</i>Generador 1</a></li>
                        <li><a href="#"><i class="material-icons">exit_to_app</i>Generador 2</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="material-icons">exit_to_app</i>Generador 3</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="material-icons">exit_to_app</i>Generador 4</a></li>
                    </ul>
                </li><!-- /#user-profile -->
            </ul><!-- /.navbar-right -->					


        </div>
    </div><!-- /#header-toolbar -->
</header>
