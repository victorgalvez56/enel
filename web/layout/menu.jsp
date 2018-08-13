<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <li><a href="<s:url action="pantallaPrincipal"/>"><i class="fa fa-dashboard"></i>  <span>Pantalla Principal</span></a></li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i> <span>Clientes</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
<<<<<<< HEAD
                        <li><a href="../clientes/frmCLIGeneral.jsp"><i class="fa fa-circle-o"></i> Mantenedor de Clientes CGP</a></li>
=======
>>>>>>> origin/master
                        <li><a href="<s:url action="frmCLIMantenedor"/>"><i class="fa fa-circle-o"></i> Mantenedor de Clientes</a></li>
                        <li><a href="<s:url action="frmCLIPosicion"/>"><i class="fa fa-circle-o"></i> Posición de Cliente</a></li>
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
<<<<<<< HEAD
=======
                        <li><a href="<s:url action="frmCREMantenedor"/>"><i class="fa fa-circle-o"></i> Mantenedor de Créditos</a></li>
>>>>>>> origin/master
                        <li><a href="<s:url action="frmCRESolicitud"/>"><i class="fa fa-circle-o"></i> Nueva Solicitud</a></li>
                        <li><a href="<s:url action="frmCREAnularSolicitud"/>"><i class="fa fa-circle-o"></i> Anular Solicitud</a></li>
                        <li><a href="<s:url action="frmCREAprobacion"/>"><i class="fa fa-circle-o"></i> Aprobación de Solicitud</a></li>
                        <li><a href="<s:url action="frmCREMntAprobacion"/>"><i class="fa fa-circle-o"></i> Mantenedor de Aprobaciones</a></li>
                        <li><a href="<s:url action="frmCREDocumentos"/>"><i class="fa fa-circle-o"></i> Documentos</a></li>
                        <li><a href="<s:url action="frmCREMovimientos"/>"><i class="fa fa-circle-o"></i> Movimientos</a></li>
                        <li><a href="<s:url action="frmREPCREWorkflow"/>"><i class="fa fa-circle-o"></i> WORKFLOW</a></li>
                        <li><a href="<s:url action="frmADMUsuarios"/>"><i class="fa fa-circle-o"></i> Mantenedor de Usuarios</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-dollar"></i> <span>Caja</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<s:url action="frmCAJDesembolso"/>"><i class="fa fa-circle-o"></i> Desembolso</a></li>
                        <li><a href="<s:url action="frmCAJPago"/>"><i class="fa fa-circle-o"></i> Cobranza</a></li>
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
                </li>
            </ul>
        </section>
    </aside>
</html>
