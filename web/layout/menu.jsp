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
                        <li><a href="<s:url action="frmCLIMantenimiento"/>"><i class="fa fa-circle-o"></i> Mantenimiento</a></li>
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
                        <li><a href="<s:url action="frmCRESolicitud"/>"><i class="fa fa-circle-o"></i> Solicitud</a></li>
                        <li><a href="<s:url action="frmCREAprobacion"/>"><i class="fa fa-circle-o"></i> Aprobación</a></li>
                        <li><a href="<s:url action="frmCREDocumentos"/>"><i class="fa fa-circle-o"></i> Documentos</a></li>
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
                        <li><a href="<s:url action="frmCAJPago"/>"><i class="fa fa-circle-o"></i> Pago</a></li>
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
                        <li><a href="<s:url action="frmREPCRECartera"/>"><i class="fa fa-circle-o"></i> Reporte Cartera</a></li>
                        <li><a href="<s:url action="frmREPCREMora_"/>"><i class="fa fa-circle-o"></i> Reporte Mora</a></li>
                        <li><a href="<s:url action="frmREPCREMora"/>"><i class="fa fa-circle-o"></i> PDF</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>
</html>