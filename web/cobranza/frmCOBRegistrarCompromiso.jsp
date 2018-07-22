<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="cargar()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form action="registraCompromiso" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Registro de Compromiso de Pago</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div class="glyphicon glyphicon-ok"></div>
                                                <div><s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div class="glyphicon glyphicon-info-sign"></div>
                                                <div><s:property value="informacion"/> </div>
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
                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <label class="control-label">Informacion del Crédito:</label>
                                            <br>
                                            <br>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Crédito</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.codCta" cssClass="form-control" readonly="false" id="tfCodigo"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Analista:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-7">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.nomAna" cssClass="form-control" readonly="true"/>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Saldo Capital:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.salCap" cssClass="form-control" type="number" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Moneda:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.moneda" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Atraso:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.diaAtr" cssClass="form-control" type="number" readonly="true"/>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Capital Atrasado:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.capAtr" cssClass="form-control" type="number" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Interes Atrasado:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.intAtr" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Mora:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.morAtr" cssClass="form-control" type="number" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Gasto Atrasado:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.gasAtr" cssClass="form-control" type="number" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Total Atrasado:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.monAtr" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Cuotas Atrasadas:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cuoAtr" cssClass="form-control" type="number" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <label class="control-label">Informacion del Cliente:</label>
                                            <br>
                                            <br>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Nombre</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.nombre" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Apellido Paterno</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.apePat" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Apellido Materno</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.apeMat" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Direccion</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-11">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.direccion.direccion" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Distrito</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.direccion.distrito.nombre" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.direccion.distrito.provincia.nombre" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.direccion.distrito.provincia.departamento.nombre" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Telefono:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.telefono" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Celular:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="credito.cliente.celular" cssClass="form-control" readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="col-md-1">
                                        <div class="form-group">
                                            <label class="control-label">Visita:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="cobranza.fecVis" cssClass="form-control" type="date" />
                                        </div>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="form-group">
                                            <label class="control-label">Resultado:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:select name="cobranza.tipo" tabindex="1" list="lstTipoCobranza" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                        </div>
                                    </div>                                            
                                    <div class="col-md-1">
                                        <div class="form-group">
                                            <label class="control-label">Compromiso:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="cobranza.fecCom" cssClass="form-control" type="date" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <label class="control-label">Detalle:</label>                                    
                                    <div class="form-group">
                                        <s:textarea label="Address" name="cobranza.glosa" cols="168" rows="5"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <center>
                                    <s:submit type="button" onclick="return false;"  data-toggle="modal" data-target="#detalle" key="Detalle" cssClass="btn btn-lg btn-success"/>
                                    <s:submit key="Aplicar" id="bAplicar" name="aplicar" cssClass="btn btn-lg btn-primary"/>
                                    <s:submit key="Grabar" name="grabar" cssClass="btn btn-lg btn-primary"/>
                                    <button type="button" class="btn btn-lg btn-primary" data-toggle="modal" data-target="#modalBuscar" id="bBuscar">Buscar</button>
                                </center>
                            </div>
                        </div>
                    </section>
                    <s:hidden name="credito.codigo"></s:hidden>
                        <!-- /.content -->
                </s:form>
            </div>
            <!-- /.content-wrapper -->
        </div>

        <!-- Modal Detalle-->
        <section>
            <div class="modal fade" id="detalle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title" id="myModalLabel">Detalle de Gestion de Mora</h3>
                        </div>
                        <div class="modal-body" id="id_editar">
                            <div class="col-xs-12">
                                <div class="box box-primary box-solid">
                                    <div class="box-body">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Fecha</th>
                                                    <th>Tipo</th>
                                                    <th>Compromiso</th>
                                                    <th>Detalle</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="lstDetalleCobranza">
                                                    <tr>                                                            
                                                        <td data-th="#"><s:property value="numero"/></td>
                                                        <td data-th="Fecha"><s:property value="fecVis"/></td>
                                                        <td data-th="Tipo"><s:property value="tipo" /></td>
                                                        <td data-th="Compromiso"><s:property value="fecCom" /></td>
                                                        <td data-th="Detalle"><s:property value="glosa" /></td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <s:submit type="button" onclick="return false;" data-dismiss="modal" key="Volver" cssClass="btn btn-lg btn-danger"/>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Modal Buscar Cliente -->
        <section>
            <div class="modal fade" id="modalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h2 class="modal-title" id="myModalLabel">Buscar Cliente</h2>
                        </div>
                        <div class="modal-body">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div class="glyphicon glyphicon-ok"></div>
                                                <div><s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div class="glyphicon glyphicon-info-sign"></div>
                                                <div><s:property value="informacion"/> </div>
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
                                    <s:form action="registraCompromiso" role="form">
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-8 col-md-offset-2">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <s:textfield name="busqueda" id="tfBusqueda" cssClass="form-control" required="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <center>
                                                        <s:submit value="Buscar por Nombre" name="buscarNombre" cssClass="btn btn-default" />
                                                        <s:submit value="Buscar por DNI" name="buscarDNI" cssClass="btn btn-default" />
                                                    </center>
                                                </div>
                                            </div>
                                        </div>
                                    </s:form>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>DNI/RUC</th>
                                                <th>Nombre</th>
                                                <th>Ver</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="lstClientes" status="rowStatus">
                                                <tr>
                                                    <th><s:property value="%{#rowStatus.count}" /></th>
                                                    <td><s:property value="nroDoc" /></td>
                                                    <td><s:property value="nomCom" /></td>
                                                    <td><s:submit type="button" onclick="return false;"  data-toggle="modal" data-target="#Creditos${codigo}" key="Ver" cssClass="btn btn-lg btn-success"/></td>
                                                </tr>
                                                <!-- Modal Créditos -->
                                            <div class="modal fade" id="Creditos${codigo}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h2 class="modal-title" id="myModalLabel">Créditos</h2>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="box-body">
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <s:if test="mensaje.length() != 0">
                                                                            <div class="alert alert-success">
                                                                                <div class="glyphicon glyphicon-ok"></div>
                                                                                <div><s:property value="mensaje"/> </div>
                                                                            </div>
                                                                        </s:if>
                                                                        <s:if test="informacion.length() != 0">
                                                                            <div class="alert alert-info">
                                                                                <div class="glyphicon glyphicon-info-sign"></div>
                                                                                <div><s:property value="informacion"/> </div>
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
                                                                    <div class="col-md-2">
                                                                        <label>Crédito</label>
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <label>Saldo</label>
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <label>Atraso</label>
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <label>Moneda</label>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <label>Seleccionar</label>
                                                                    </div>
                                                                </div>                                                                
                                                                <s:iterator value="lstCreditos" status="rowStatus">
                                                                    <div class="row">
                                                                        <div class="col-md-2"><s:property value="codCre" /></div>                                                                        
                                                                        <div class="col-md-2"><s:property value="salCap" /></div>
                                                                        <div class="col-md-2"><s:property value="diaAtr" /></div>
                                                                        <div class="col-md-2"><s:property value="moneda" /></div>
                                                                        <div class="col-md-4"><button class="btn btn-primary" type="button" onclick="pasarCodigo('<s:property value="codCre"/>')">Seleccionar</button></div>
                                                                    </div>                                                                
                                                                </s:iterator>
                                                            </div>                                
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </s:iterator>
                                        </tbody>
                                    </table>
                                </div>                                    
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>     
        <script>
            function cargar() {
                var buscar = document.getElementById("tfBusqueda").value;
                if (buscar.length > 0) {
                    document.getElementById("bBuscar").click();
                }
            }
            function pasarCodigo(codigo) {
                document.getElementById("tfCodigo").value = codigo;
                document.getElementById("bAplicar").click();
            }            
        </script>
    </body>
</html>