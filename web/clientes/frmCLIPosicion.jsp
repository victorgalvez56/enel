<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCLIBuscar.jsp" %>
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
                                    <div class="col-md-10">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Código de Cliente</label>
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">
                                                            <label>&nbsp;</label>
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>&nbsp;</label>
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">

                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Actividad:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Celular:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección del Negocio:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Distrito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="text" name="regular" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="text" name="regular" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <button type="button" class="btn btn-default form-control">Evaluación</button>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <button type="button" class="btn btn-default form-control">Datos del Cliente</button>
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
                                                        <li class="active"><a href="#cuentas_pasivas" data-toggle="tab">Ctas. Pasivas</a></li>
                                                        <li><a href="#creditos" data-toggle="tab">Créditos</a></li>
                                                        <li><a href="#garantias" data-toggle="tab">Garantías</a></li>
                                                        <li><a href="#rcc_sbs" data-toggle="tab">RCC - SBS</a></li>
                                                    </ul>
                                                    <div class="tab-content">
                                                        <div class="active tab-pane" id="cuentas_pasivas">
                                                            <div class="col-md-12">
                                                                <div class="box box-primary box-solid">
                                                                    <div class="box-body">
                                                                        <table class="table">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>#</th>
                                                                                    <th>Nro. de Cuenta</th>
                                                                                    <th>Producto</th>
                                                                                    <th>Tipo</th>
                                                                                    <th>Moneda</th>
                                                                                    <th>Saldo</th>
                                                                                    <th>Interés</th>
                                                                                    <th>Situación</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <s:iterator value="" status="rowStatus">
                                                                                    <tr>
                                                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                        <td><s:property value="numeroCredito" /></td>
                                                                                        <td><s:property value="numSolicitud" /></td>
                                                                                        <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                    </tr>
                                                                                </s:iterator>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /.tab-pane -->
                                                        <div class="tab-pane" id="creditos">
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
                                                                                    <th>C. Venc. Situación</th>
                                                                                    <th>Garantias</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <s:iterator value="" status="rowStatus">
                                                                                    <tr>
                                                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                        <td><s:property value="numeroCredito" /></td>
                                                                                        <td><s:property value="numSolicitud" /></td>
                                                                                        <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                    </tr>
                                                                                </s:iterator>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /.tab-pane -->
                                                        <div class="tab-pane" id="garantias">
                                                            <div class="col-md-12">
                                                                <div class="box box-primary box-solid">
                                                                    <div class="box-body">
                                                                        <table class="table">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>#</th>
                                                                                    <th>Tipo</th>
                                                                                    <th>Cód. Garantía</th>
                                                                                    <th>Moneda</th>
                                                                                    <th>Valor Tas.</th>
                                                                                    <th>Monto Grav.</th>
                                                                                    <th>Estado</th>
                                                                                    <th>Fecha Insc.</th>
                                                                                    <th>Fecha Nue. Tas</th>
                                                                                    <th>Cre. Garantía</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <s:iterator value="" status="rowStatus">
                                                                                    <tr>
                                                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                        <td><s:property value="numeroCredito" /></td>
                                                                                        <td><s:property value="numSolicitud" /></td>
                                                                                        <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                    </tr>
                                                                                </s:iterator>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane" id="rcc_sbs">
                                                            <div class="col-md-12">
                                                                <div class="box box-primary box-solid">
                                                                    <div class="box-body">
                                                                        <table class="table">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>#</th>
                                                                                    <th>Fecha</th>
                                                                                    <th>% Normal</th>
                                                                                    <th>% CPP</th>
                                                                                    <th>% Defic.</th>
                                                                                    <th>% Dudoso</th>
                                                                                    <th>% Pérdida</th>
                                                                                    <th>Calif.</th>
                                                                                    <th># Inst.</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <s:iterator value="" status="rowStatus">
                                                                                    <tr>
                                                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                        <td><s:property value="numeroCredito" /></td>
                                                                                        <td><s:property value="numSolicitud" /></td>
                                                                                        <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                    </tr>
                                                                                </s:iterator>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
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
                                            <s:submit name="aplicar" value="Aplicar" cssClass="btn btn-default" />
                                            <s:submit name="cancelar" value="Cancelar" cssClass="btn btn-default" />
                                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalBuscar" id="bBuscar" onclick="frmNombre()">Buscar</button>
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
                document.getElementById("fBuscar").setAttribute("action", "frmCLIPosicion");
            }
        </script>
    </body>
</html>
