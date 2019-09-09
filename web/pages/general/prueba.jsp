<%-- 
    Document   : prueba
    Created on : 01-sep-2019, 16:53:48
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <h1>Hello World!</h1>
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <s:if test="mensaje.length() != 0">
                            <div class="alert alert-success">
                                <div class="glyphicon glyphicon-ok"></div>
                                <div><strong>¡Correcto!</strong> <s:property value="mensaje"/> </div>
                            </div>
                        </s:if>
                        <s:if test="informacion.length() != 0">
                            <div class="alert alert-info">
                                <div class="glyphicon glyphicon-info-sign"></div>
                                <div><strong>Información</strong> <s:property value="informacion"/> </div>
                            </div>
                        </s:if>
                        <s:if test="advertencia.length() != 0">
                            <div class="alert alert-warning">
                                <div class="glyphicon glyphicon-exclamation-sign"></div>
                                <div><strong>¡Advertencia!</strong> <s:property value="advertencia"/> </div>
                            </div>
                        </s:if>
                        <s:if test="error.length() != 0">
                            <div class="alert alert-danger">
                                <div class="glyphicon glyphicon-exclamation-sign"></div>
                                <div><s:property value="error"/></div>
                            </div>
                        </s:if>
                    </div>
                </div>
                <s:form action="frmSolicitudFinanciamiento" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Código Evaluador</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Punto de Venta</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Fecha de Solicitud</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">Datos Personales del Solicitante</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Documento de Identidad: </label>
                                                            <s:select name="cliente.tipDocCiv" tabindex="10" id="sTipoDoc" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número &emsp; documento:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de &emsp; Expedición:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer &emsp; &emsp; &emsp;Nombre: </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo &emsp; &emsp;Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer  &emsp; &emsp; &emsp;Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo &emsp; &emsp;Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>&emsp; &emsp;&emsp; &emsp;Nacionalidad:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Fecha de &emsp;Nacimiento:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Nacimiento:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>País de &emsp;&emsp;Nacimiento:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Género:  </label>
                                                            <s:select name="cliente.tipDocCiv" tabindex="10" id="sTipoDoc" list="lstSexos" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estado Civil:  </label>
                                                            <s:select name="cliente.estCiv" tabindex="10" id="sTipoDoc" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estudios:  </label>
                                                            <s:select name="cliente.tipDocCiv" tabindex="10" id="sTipoDoc" list="lstNivIns" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ocupación:  </label>
                                                            <s:select name="cliente.TipDocTri" tabindex="10" id="sTipoDoc" list="lstTipoOrden" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Número de personas que dependen económicamente del solicitante:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo&emsp;&emsp; Electrónico:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número de &emsp;&emsp;teléfono:  </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="codCta" style="text-transform: uppercase;" />
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
                                            <s:submit name="siguiente" value="Siguiente" id = "bSiguiente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="empleado" value="Empleado" id = "bEmpleado" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="independiente" value="Independiente" id = "bIndependiente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="jubilado" value="Jubilado" id = "bJubilado" cssClass="btn btn-primary btn-flat" />

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
        </div>
    </body>
</html>
