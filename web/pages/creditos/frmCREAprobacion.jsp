<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCREBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Aprobacion de Desembolso</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCREAprobacion" role="form">                            
                                <div class="row">
                                    <div class="col-lg-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div class="glyphicon glyphicon-ok"></div>
                                                <div><strong>Mensaje: </strong> <s:property value="mensaje"/> </div>
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

                                <div class="row">                                
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. de Crédito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="1" name="credito.codCta" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Cliente:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="2" name="credito.cliente.codCli" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNomCli" tabindex="3" name="credito.cliente.nomCom" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Analista:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNomAna" tabindex="4" name="credito.nomAna" readonly="true"/>
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
                                                <h3 class="box-title">DATOS APROBADOS</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Monto Solicitado</label>
                                                            <s:textfield cssClass="form-control" id="tfMonSol" tabindex="5" name="credito.capSol" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Cuotas</label>
                                                            <s:textfield cssClass="form-control" id="tfMonSol" tabindex="5" name="credito.cuotas" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Monto Cuota</label>
                                                            <s:textfield cssClass="form-control" id="tfMonSol" tabindex="5" name="credito.cuota" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Producto</label>
                                                            <s:select name="credito.producto.codigo" tabindex="6" list="lstProductos" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>                                                        
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <label>Comentario</label>
                                                            <s:textarea cssClass="form-control" id="tfComent" tabindex="7" name="comentario"/>
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
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre">Buscar</button>
                                            <s:submit name="aplicar" value="Aplicar" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="revertir" value="Revertir Aprobac." id = "bRevertir" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="aprobar" value="Aprobar" id = "bAprobar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat">Plan de Pagos</button>
                                        </div>
                                    </div>
                                </div>
                                <s:hidden name="credito.codigo"></s:hidden>
                            </s:form>                                                    
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>