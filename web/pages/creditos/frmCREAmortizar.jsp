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
                <s:form action="frmCREAmortizar" role="form">
                    <section class="content-header">
                        <h1>Amortización</h1>
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
                                                <h3 class="box-title">Datos Amortización</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="box-body">
                                                    <div class="col-md-12">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Pago:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" tabindex="12" id="tfPago" name="credito.monAmo" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Cuotas:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="13" cssClass="form-control" name="credito.cuoAmo" id="tfCuotas" readonly="true"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Capital:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" name="credito.capAmo" tabindex="12" id="tfCapitalAmortizado" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Interes:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="13" cssClass="form-control" name="credito.intAmo" id="tfInteresAmortizado" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Gasto:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="13" cssClass="form-control" name="credito.gasAmo" id="tfGastosAmortizado" readonly="true"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label class="control-label">Nuevo Capital:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:textfield tabindex="13" cssClass="form-control" name="credito.nueCap" id="tfNuevoCapital" readonly="true"/>
                                                                <s:hidden name="credito.codigo"></s:hidden>
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
                                        <label>PLAN DE PAGOS:</label>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nro. cuota</th>
                                                    <th>Tipo</th>
                                                    <th>Fecha</th>
                                                    <th>Capital</th>
                                                    <th>Interes</th>
                                                    <th>Gastos</th>
                                                    <th>Cuota</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="credito.planPagos" status="rowStatus">
                                                    <tr style="text-transform: uppercase;">
                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                        <td><s:property value="numero" /></td>
                                                        <td><s:property value="tipo" /></td>
                                                        <td><s:property value="fecha" /></td>
                                                        <td><s:property value="capital" /></td>
                                                        <td><s:property value="interes" /></td>
                                                        <td><s:property value="gastos" /></td>
                                                        <td><s:property value="cuota" /></td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>                
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit value="Grabar" name="grabar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit value="Cancelar" name="cancelar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre" >Buscar</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
</html>