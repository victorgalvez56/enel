<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="../creditos/modCREBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
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
                <s:form action="frmCAJPago" role="form">
                    <section class="content-header">
                        <h1>Pago</h1>
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
                                                            <label class="control-label">Crédito:</label>
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
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNombre" tabindex="3" name="credito.cliente.nomCom" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="codciv" name="credito.cliente.nroDocCiv"  tabindex="4" readonly="true"/>
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
                                                <h3 class="box-title">Saldo del Crédito</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Capital:</label>
                                                            <s:textfield cssClass="form-control" id="tfCapital" tabindex="5" name="credito.salCap" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Interés:</label>
                                                            <s:textfield id="tfInteres" tabindex="6" name="credito.interes" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Mora:</label>
                                                            <s:textfield id="tfMora" tabindex="6" name="credito.morAtr" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Comisiones:</label>
                                                            <s:textfield id="tfComisiones" tabindex="7" name="credito.comision" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Total:</label>
                                                            <s:textfield id="tfTotal" tabindex="8" name="credito.monTot" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Cuota:</label>
                                                            <s:textfield id="tfCuota" tabindex="9" name="credito.cuoAct" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Atraso:</label>
                                                            <s:textfield id="tfMora" tabindex="10" name="credito.diaAtr" cssClass="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Cuota Ref.:</label>
                                                            <s:textfield id="tfCuotaRef" tabindex="11" name="credito.cuota" cssClass="form-control" readonly="true"/>
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
                                                <h3 class="box-title">Deuda Pendiente</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="box-body">
                                                    <div class="col-md-6">
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label class="control-label">Capital:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-10">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" tabindex="12" id="tfCapitalPendiente" name="credito.capAtr" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label class="control-label">Interés:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-10">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="13" cssClass="form-control" name="credito.intAtr" id="tfInteresPendiente" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <!--<div class="col-md-2">
                                                            <div class="form-group">
                                                                <label class="control-label">Mora:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-10">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="14" id="tfMoraPendiente" cssClass="form-control" readonly="true"/>
                                                            </div>
                                                        </div>-->

                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label class="control-label">Gastos:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-10">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="15" name="credito.gasAtr" id="tfGastoPendiente" cssClass="form-control" readonly="true"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">I.T.F.:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="16" name="credito.ITF" id="tfITF" cssClass="form-control" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">Deuda Neta:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="17" cssClass="form-control" id="tfPendienteNeto" name="credito.monAtr" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">Monto de Pago:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="18" cssClass="form-control" name="credito.monPag" />
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
                                            <s:submit name="aplicar" value="Aplicar" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit value="Grabar" name="grabar" cssClass="btn btn-primary btn-flat" />
                                            <input type="button" id="retiroCaja_buscar" name="buscar" value="Consultar" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#busquedaRegistros">
                                            <s:submit value="Cancelar" name="cancelar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre" >Buscar</button>
                                        </div>

                                    </div>
                                </div>
                                <div class="modal fade" id="busquedaRegistros" style="display: none;">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">×</span></button>
                                                <h4 class="modal-title">Busqueda</h4>
                                            </div>
                                            <div class="modal-body">
                                                <!--                                                <div class="col-md-2">
                                                                                                    <div class="form-group">
                                                                                                        <label class="control-label">Nro. Documento:</label>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="col-md-4">
                                                                                                    <div class="form-group">
                                                <s:textfield name="cliente.nroDoc" cssClass="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="control-label">Nombre:</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <s:textfield name="cliente.titular" cssClass="form-control"/>
                                            </div>
                                        </div>-->
                                                <!--                                                <table class="table table-bordered">
                                                                                                    <tbody><tr>
                                                                                                            <th style="width: 10px">#</th>
                                                                                                            <th style="width: 150px">Nro. Cuenta</th>
                                                                                                            <th>Cliente</th>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td></td>
                                                                                                            <td></td>
                                                                                                            <td></td>
                                                                                                        </tr>
                                                                                                    </tbody>
                                                                                                </table>-->
                                                <table class="table table-bordered"><tr><td>
                                                            <table id="example" class="display" cellspacing="0" width="100%">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Nro. Credito</th>
                                                                        <th>Cliente</th>
                                                                    </tr>
                                                                </thead>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
</html>