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
                    <h1>Créditos por cliente</h1>
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
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. de suministro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfsuministro" tabindex="2" name="cliente.sumini" readonly="true" style="text-transform: uppercase;" maxlength="7" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo de documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" name="cliente.tipDocCiv" tabindex="4" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="5" readonly="true" maxlength="15" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nombre completo:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNombre" tabindex="6" name="cliente.nomCom" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Estado suministro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="7" name="cliente.estado" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Provincia:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfProvincia" tabindex="8" name="cliente.direccion.distrito.provincia.nombre" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Distrito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfDistrito" tabindex="9" name="cliente.direccion.distrito.nombre" readonly="true" style="text-transform: uppercase;" />
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
                                                            <s:textfield cssClass="form-control" id="tfDireccion" tabindex="10" name="cliente.direccion.direccion" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono fijo:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfTelefono" tabindex="11" name="cliente.telefono" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono movil:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCelular" tabindex="12" name="cliente.celular" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Correo:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCorreo" tabindex="13" name="cliente.correo" readonly="true" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>CRÉDITOS:</label>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Nro. cuenta</th>
                                                        <th>Producto</th>
                                                        <th>Moneda</th>
                                                        <th>Desembolso</th>
                                                        <th>Pagos</th>
                                                        <th>Saldo</th>
                                                        <th>Monto cuota</th>
                                                        <th>Monto vencido</th>
                                                        <th>Cuotas</th>
                                                        <th>Estado</th>
                                                        <!--<th>Condición</th>-->
                                                        <th>Canal</th>
                                                        <th>Venta</th>
                                                        <th>Ver</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="cliente.lstCuentas" status="rowStatus">
                                                        <tr style="text-transform: uppercase;">
                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                            <td><s:property value="cuenta" /></td>
                                                            <td><s:property value="producto" /></td>
                                                            <td><s:property value="moneda" /></td>
                                                            <td><s:property value="capDes" /></td>
                                                            <td><s:property value="capPag" /></td>
                                                            <td><s:property value="saldo" /></td>
                                                            <td><s:property value="cuota" /></td>
                                                            <td><s:property value="capVen" /></td>
                                                            <td><s:property value="cuotas" /></td>
                                                            <td><s:property value="estado" /></td>
                                                            <!--<td><s:property value="condicion" /></td>-->
                                                            <td><s:property value="canal" /></td>
                                                            <td><s:property value="venta" /></td>
                                                            <td>
                                                                <s:url id="verURL" action="verCredito">
                                                                    <s:param name="codCta" value="%{cuenta}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{verURL}">Ver</s:a>
                                                                </td>
                                                            </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>   
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>CRÉDITOS RELACIONADOS:</label>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Nro. cuenta</th>
                                                        <th>Producto</th>
                                                        <th>Moneda</th>
                                                        <th>Desembolso</th>
                                                        <th>Pagos</th>
                                                        <th>Saldo</th>
                                                        <th>Monto cuota</th>
                                                        <th>Monto vencido</th>
                                                        <th>Cuotas</th>
                                                        <th>Estado</th>
                                                        <!--<th>Condición</th>-->
                                                        <th>Canal</th>
                                                        <th>Venta</th>
                                                        <th>Ver</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="cliente.lstCuentasRelacionadas" status="rowStatus">
                                                        <tr style="text-transform: uppercase;">
                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                            <td><s:property value="cuenta" /></td>
                                                            <td><s:property value="producto" /></td>
                                                            <td><s:property value="moneda" /></td>
                                                            <td><s:property value="capDes" /></td>
                                                            <td><s:property value="capPag" /></td>
                                                            <td><s:property value="saldo" /></td>
                                                            <td><s:property value="cuota" /></td>
                                                            <td><s:property value="capVen" /></td>
                                                            <td><s:property value="cuotas" /></td>
                                                            <td><s:property value="estado" /></td>
                                                            <!--<td><s:property value="condicion" /></td>-->
                                                            <td><s:property value="canal" /></td>
                                                            <td><s:property value="venta" /></td>
                                                            <td>
                                                                <s:url id="verURL" action="verCredito">
                                                                    <s:param name="codCta" value="%{cuenta}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{verURL}">Ver</s:a>
                                                            </td>
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="cliente.codigo"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.apePat"></s:hidden>
                                            <s:hidden name="cliente.apeMat"></s:hidden>
                                            <s:hidden name="cliente.codCli" id="tfCodCli" ></s:hidden>
                                                <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCli" id="bBuscarCli" onclick="frmNombre()">Buscar</button>
                                            <s:submit name="reporte" value="Reporte" id="bReporte" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="exportar" value="Exportar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="aplicar" value="Aplicar" id = "bAplicar" cssClass="btn btn-primary btn-flat" style='display:none;' />
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
    <script>
        function frmNombre() {
            document.getElementById("fBuscar").setAttribute("action", "frmCLIPosicion");
        }
    </script>
</html>
