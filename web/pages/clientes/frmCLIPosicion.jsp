<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCLIBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onloadCli()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <s:if test="mensaje.length() != 0">
                                <div class="alert alert-success">
                                    <div><span class="glyphicon glyphicon-ok"></span><strong> ¡Correcto!</strong> <s:property value="mensaje"/> </div>
                                </div>
                            </s:if>
                            <s:if test="informacion.length() != 0">
                                <div class="alert alert-info">
                                    <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <span id="info"><s:property value="informacion"/></span> </div>
                                </div>
                            </s:if>
                            <s:if test="advertencia.length() != 0">
                                <div class="alert alert-warning">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ¡Advertencia!</strong> <s:property value="advertencia"/> </div>
                                </div>
                            </s:if>
                            <s:if test="error.length() != 0">
                                <div class="alert alert-danger">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span> <s:property value="error"/></div>
                                </div>
                            </s:if>
                        </div>
                    </div>
                </div>
                <!-- Content header -->
                <section class="content-header">
                    <h1>Posición de Cliente</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCLIPosicion" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Código de Cliente</label>
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-9">
                                                        <div class="form-group">
                                                            <label>Nombre</label>
                                                            <s:textfield cssClass="form-control" id="tfNombre" tabindex="1" name="cliente.nomCom" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Suministro</label>
                                                            <s:textfield cssClass="form-control" id="tfSuministro" tabindex="1" name="cliente.sumini" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado</label>
                                                            <s:select name="cliente.estado" tabindex="3" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia</label>
                                                            <s:textfield cssClass="form-control" id="tfProvincia" tabindex="1" name="cliente.distrito.provincia.nombre" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito</label>
                                                            <s:textfield cssClass="form-control" id="tfDistrito" tabindex="1" name="cliente.distrito.nombre" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfDireccion" tabindex="1" name="cliente.direccion.direccion" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfTelefono" tabindex="1" name="cliente.telefono" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Celular:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCelular" tabindex="1" name="cliente.celular" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Correo:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCorreo" tabindex="1" name="cliente.correo" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="box box-primary box-solid">
                                                <div class="box-body">
                                                    <div class="nav-tabs-custom" style="box-shadow: 0 0px 0px rgba(0,0,0,0);">
                                                        <ul class="nav nav-tabs">
                                                            <li><a href="#creditos" data-toggle="tab">Créditos</a></li>
                                                        </ul>
                                                        <div class="tab-content">
                                                            <!-- /.tab-pane -->
                                                            <div class="active tab-pane" id="creditos">
                                                                <div class="col-md-12">
                                                                    <div class="box box-primary box-solid">
                                                                        <div class="box-body">
                                                                            <table class="table">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>#</th>
                                                                                        <th>Cuenta</th>
                                                                                        <th>Producto</th>
                                                                                        <th>Moneda</th>
                                                                                        <th>Saldo</th>
                                                                                        <th>Cuota</th>
                                                                                        <th>Plazo</th>
                                                                                        <th>PDM</th>
                                                                                        <th>Ver</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <s:iterator value="cliente.lstCuentas" status="rowStatus">
                                                                                        <tr>
                                                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                            <td><s:property value="cuenta" /></td>
                                                                                            <td><s:property value="producto" /></td>
                                                                                            <td><s:property value="moneda" /></td>
                                                                                            <td><s:property value="saldo" /></td>
                                                                                            <td><s:property value="cuota" /></td>
                                                                                            <td><s:property value="plazo" /></td>
                                                                                            <td><s:property value="pdm" /></td>
                                                                                            <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Ver</button></td>
                                                                                        </tr>
                                                                                    </s:iterator>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- /.tab-pane -->
                                                        </div>
                                                        <!-- /.tab-content -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div style="float: right">
                                                <s:hidden name="cliente.codigo"></s:hidden>
                                                <s:submit name="aplicar" value="Aplicar" id="bAplicar" cssClass="btn btn-primary btn-flat" />
                                                <s:submit name="cancelar" value="Cancelar" cssClass="btn btn-primary btn-flat" />
                                                <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCli" id="bBuscarCli">Buscar</button>
                                                <s:submit name="reporte" value="Reporte" id="bReporte" cssClass="btn btn-primary btn-flat" />
                                            </div>
                                        </div>
                                    </div>
                                </s:form>      
                            </div>
                        </div>
                </section>
            </div>
        </div>
    </body>
</html>
