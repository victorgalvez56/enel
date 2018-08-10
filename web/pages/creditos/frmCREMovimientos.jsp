<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCREBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
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
                                    <div><span class="glyphicon glyphicon-info-sign"></span><<strong> Información</strong> <s:property value="informacion"/> </div>
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
                    <h1>Consulta de Movimientos</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCREMovimientos" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Crédito:</label>
                                                            <s:textfield cssClass="form-control" name="credito.codCta" id="tfCodCre" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Código de Cliente:</label>
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="2" name="credito.cliente.codCli" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Nombre:</label>
                                                            <s:textfield cssClass="form-control" id="tfNomCli" tabindex="3" name="credito.cliente.nomCom" readonly="true"/><br>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Fecha:</label>
                                                            <s:textfield type="date" cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Tipo de Crédito:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Moneda:</label>
                                                            <s:textfield cssClass="form-control" name="credito.moneda" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Tasa:</label>
                                                            <s:textfield cssClass="form-control" name="credito.tasa" readonly="true" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Clasificación:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Modalidad:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Situación:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Abogado:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Analista:</label>
                                                            <s:textfield cssClass="form-control" name="credito.nomAna" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Convenio:</label>
                                                            <s:textfield cssClass="form-control" name="" readonly="true" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:hidden name="credito.codigo"></s:hidden>
                                        <s:submit name="aplicar" value="Aplicar" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
                                        <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre" >Buscar</button>
                                        
                                        <div style="float: right">
                                            <s:submit name="kardex" value="Kardex" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="estadoCuenta" value="Estado de Cuenta" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script>
            function frmNombre() {
                document.getElementById("fBuscar").setAttribute("action", "frmCREMovimientos");
            }
        </script>
    </body>
</html>