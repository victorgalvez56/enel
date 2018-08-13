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
                            <s:if test="mensaje.length() != 0 && mensaje != 'nuevo' && mensaje != 'actualizar'">
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
                    <s:if test="mensaje ==  'nuevo'">
                        <h1>Nuevo Cliente</h1>
                    </s:if>
                    <s:if test="mensaje ==  'actualizar'">
                        <h1>Actualizar datos de Cliente</h1>
                    </s:if>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <sj:head jqueryui="true" jquerytheme="blitzer"  locale="es"/>                            
                            <s:form action="frmCLINuevoActualizar" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Código:</label>
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" readonly="true" />
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
                                                            <label class="control-label">Estado sum:</label>
                                                            <div class="form-group">
                                                                <s:select name="cliente.estado" tabindex="3" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Sector:</label>
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="" tabindex="4" name=""/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ape paterno:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" id="apellido" name="cliente.apePat" tabindex="5"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ape. materno:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" id="apellidomat" name="cliente.apeMat" tabindex="6"/>              
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label class="control-label">Nombre(s):</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.nombre" id="nombre" tabindex="7"/>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>                                           
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nacimiento:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" type="date" id="fecnac" name="cliente.fecNac" tabindex="8"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Sexo:</label>
                                                            <s:select name="cliente.sexo" tabindex="9" list="lstSexos" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de documento:</label>
                                                            <s:select name="cliente.tipDocCiv" tabindex="10" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. de documento:</label>
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="11"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                                                              
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Departamento:</label>
                                                            <div class=" form-group">
                                                                <s:url id="remoteurl" action="json" namespace="/"/>
                                                                <sj:select href="%{remoteurl}" id="depart" tabindex="12" onChangeTopics="reloadsecondlist" name="depart"
                                                                           list="departMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                                           headerKey="-1" headerValue="--Seleccione Departamento--" cssClass="form-control"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Provincia:</label>
                                                            <div class=" form-group">
                                                                <s:url id="remoteurl" action="json" namespace="/"/>
                                                                <sj:select href="%{remoteurl}" id="provinID" tabindex="13" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                                                           reloadTopics="reloadsecondlist" name="provin" 
                                                                           list="provinMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                                           headerKey="-1" headerValue="--Seleccione Provincia--" cssClass="form-control"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Distrito:</label>
                                                            <div class=" form-group">
                                                                <s:url id="remoteurl" action="json" namespace="/"/>
                                                                <sj:select href="%{remoteurl}" formIds="formSelectReload" tabindex="14" reloadTopics="reloadThirdlist"
                                                                           name="cliente.direccion.distrito.codigo" list="distriList" emptyOption="false"
                                                                           listKey="codigo" listValue="nombre"
                                                                           headerKey="-1" headerValue="--Seleccione Distrito--" cssClass="form-control"/><br>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-12">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección:</label>
                                                            <div class=" form-group">
                                                                <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" tabindex="15"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                                                                
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono fijo:</label>
                                                            <div class=" form-group">
                                                                <s:textfield name="cliente.telefono" cssClass="form-control" id="direccion" tabindex="16"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono movil:</label>
                                                            <div class=" form-group">
                                                                <s:textfield name="cliente.celular" cssClass="form-control" id="direccion" tabindex="17"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Profesión:</label>
                                                            <s:select name="cliente.profesion.codigo" tabindex="18" list="lstProfesiones" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>                                                                    
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Grado de instrucción</label>
                                                            <s:select name="cliente.nivIns" tabindex="19" list="lstNivIns" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de zona:</label>
                                                            <s:select name="cliente.direccion.tipoZona" tabindex="20" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Correo:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.correo" id="nombre" tabindex="21"/>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. hijos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.hijos" id="nombre" tabindex="22"/>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ingresos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.ingreso" id="nombre" tabindex="23"/>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit name="grabar" value="Grabar" cssClass="btn btn-primary btn-flat" />
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