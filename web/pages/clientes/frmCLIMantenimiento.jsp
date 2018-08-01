<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
                    <h1>Mantenimiento de Cliente</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <sj:head jqueryui="true" jquerytheme="blitzer"  locale="es"/>                            
                            <s:form action="frmCLIMantenimiento" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="control-label">Código:</label>
                                                <div class="form-group">
                                                    <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="control-label">Suministro:</label>
                                                <div class="form-group">
                                                    <s:textfield cssClass="form-control" id="tfsuministro" tabindex="2" name="cliente.sumini"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="control-label">Estado:</label>
                                                <div class="form-group">
                                                    <s:select name="cliente.estado" tabindex="3" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Primer Apellido:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" id="apellido" name="cliente.apePat" tabindex="4"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Segundo Apellido:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" id="apellidomat" name="cliente.apeMat" tabindex="5"/>              
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-6">
                                            <div class="form-group">
                                                <label class="control-label">Nombres:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" name="cliente.nombre" id="nombre" tabindex="6"/>
                                                </div>
                                            </div>
                                        </div> 
                                    </div>
                                </div>
                                <div class="row">                                                
                                    <div class="col-xs-12">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Nacimiento:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" type="date" id="fecnac" name="cliente.fecNac" tabindex="7"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Sexo:</label>
                                                <s:select name="cliente.sexo" tabindex="8" list="lstSexos" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Tipo de Documento:</label>
                                                <s:select name="cliente.tipDocCiv" tabindex="9" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Nro. Documento Civil:</label>
                                                <div class="form-group">
                                                    <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="10"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">                                                                                                
                                    <div class="col-xs-12">
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label">Departamento:</label>
                                                <div class=" form-group">
                                                    <s:url id="remoteurl" action="json" namespace="/"/>
                                                    <sj:select href="%{remoteurl}" id="depart" tabindex="11" onChangeTopics="reloadsecondlist" name="depart"
                                                               list="departMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                               headerKey="-1" headerValue="*--Seleccione Departamento--*" cssClass="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label">Provincia:</label>
                                                <div class=" form-group">
                                                    <s:url id="remoteurl" action="json" namespace="/"/>
                                                    <sj:select href="%{remoteurl}" id="provinID" tabindex="12" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                                               reloadTopics="reloadsecondlist" name="provin" 
                                                               list="provinMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                               headerKey="-1" headerValue="*--Seleccione Provincia--*" cssClass="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label">Distrito:</label>
                                                <div class=" form-group">
                                                    <s:url id="remoteurl" action="json" namespace="/"/>
                                                    <sj:select href="%{remoteurl}" formIds="formSelectReload" tabindex="13" reloadTopics="reloadThirdlist"
                                                               name="cliente.direccion.distrito.codigo" list="distriList" emptyOption="false"
                                                               listKey="codigo" listValue="nombre"
                                                               headerKey="-1" headerValue="*--Seleccione Distrito--*" cssClass="form-control"/><br>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>        
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <label class="control-label">Direccion:</label>
                                                <div class=" form-group">
                                                    <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" tabindex="14"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">                                                                                                
                                    <div class="col-xs-12">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Teléfono:</label>
                                                <div class=" form-group">
                                                    <s:textfield name="cliente.telefono" cssClass="form-control" id="direccion" tabindex="15"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Movil:</label>
                                                <div class=" form-group">
                                                    <s:textfield name="cliente.celular" cssClass="form-control" id="direccion" tabindex="16"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Profesion:</label>
                                                <s:select name="cliente.profesion.codigo" tabindex="17" list="lstProfesiones" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                            </div>                                                                    
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Nivel de Instrucción</label>
                                                <s:select name="cliente.nivIns" tabindex="18" list="lstNivIns" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">                                                                                                    
                                    <div class="col-xs-12">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Tipo de Zona</label>
                                                <s:select name="cliente.direccion.tipoZona" tabindex="19" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Correo:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" name="cliente.correo" id="nombre" tabindex="20"/>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Hijos:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" name="cliente.hijos" id="nombre" tabindex="21"/>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label class="control-label">Ingreso:</label>
                                                <div class=" form-group">
                                                    <s:textfield cssClass="form-control" name="cliente.ingreso" id="nombre" tabindex="22"/>
                                                </div>
                                            </div>
                                        </div> 
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-md-12">
                                            <div style="float: right">
                                                <s:submit name="nuevo" value="Nuevo" cssClass="btn btn-primary btn-flat" />
                                                <s:submit name="aplicar" id="bAplicar" value="Aplicar" cssClass="btn btn-primary btn-flat" />
                                                <s:submit name="grabar" value="Grabar" cssClass="btn btn-primary btn-flat" />
                                                <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCli" id="bBuscarCli">Buscar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <s:hidden name="cliente.codigo"></s:hidden>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>