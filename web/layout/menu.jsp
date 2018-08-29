<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <li><a href="<s:url action="pantallaPrincipal"/>"><i class="fa fa-dashboard"></i>  <span>Pantalla Principal</span></a></li>
                <s:iterator value="Menus" id="menu">
                    <li class="treeview">
                        <a href="#">
                            <i class="fa <s:property value="icono"/>"></i> <span><s:property value="nombre"/></span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu">
                            <s:iterator value="SubMenus" id="subMenu">
                                <s:if test="%{#menu.codPadre == #subMenu.codHijo}">
                                    <li><a href="/enel/<s:property value="action" />"><i class="fa fa-circle-o"></i> <s:property value="nombre" /></a></li>
                                </s:if>
                            </s:iterator>
                        </ul>
                    </li>
                </s:iterator>
                <!--
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-copyright"></i> <span>Clientes</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<s:url action="frmCLIMantenedor"/>"><i class="fa fa-circle-o"></i> Mantenedor de Clientes</a></li>
                        <li><a href="<s:url action="frmCLIPosicion"/>"><i class="fa fa-circle-o"></i> Créditos por Cliente</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-credit-card"></i> <span>Créditos</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<s:url action="frmSOLMantenedor"/>"><i class="fa fa-circle-o"></i> Mantenedor de Solicitudes</a></li>
                        <li><a href="<s:url action="frmCREMntAprobacion"/>"><i class="fa fa-circle-o"></i> Mantenedor de Aprobaciones</a></li>
                        <li><a href="<s:url action="frmCREMantenedor"/>"><i class="fa fa-circle-o"></i> Mantenedor de Créditos</a></li>
                        <li><a href="<s:url action="frmCREDocumentos"/>"><i class="fa fa-circle-o"></i> Impresión de Documentos</a></li>
                        <li><a href="<s:url action="frmCREMovimientos"/>"><i class="fa fa-circle-o"></i> Movimientos</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i> <span>Usuarios</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<s:url action="frmADMUsuarios"/>"><i class="fa fa-circle-o"></i> Administrador de Usuarios</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-archive"></i> <span>Reportes</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<s:url action="frmREPCRECartera"/>"><i class="fa fa-circle-o"></i> Cartera de Créditos</a></li>
                        <li><a href="<s:url action="frmREPCREMora"/>"><i class="fa fa-circle-o"></i> Mora</a></li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-circle-o"></i> <span>Operaciones</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<s:url action="frmREPCRESolicitud"/>"><i class="fa fa-circle-o"></i> Solicitudes</a></li>
                                <li><a href="<s:url action="frmREPCREDesembolso"/>"><i class="fa fa-circle-o"></i> Desembolsos</a></li>
                                <li><a href="<s:url action="frmREPCREPago"/>"><i class="fa fa-circle-o"></i> Cobranzas</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>-->
            </ul>
        </section>
    </aside>
</html>
