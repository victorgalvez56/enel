<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form action="registraVisita" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Registro de Visita</h1>
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
                                                        <s:if test="credito.codCta.length() != 0">
                                                            <s:textfield name="credito.codCta" cssClass="form-control" readonly="true"/>
                                                        </s:if>
                                                        <s:else>
                                                            <s:textfield name="credito.codCta" cssClass="form-control" readonly="false"/>
                                                        </s:else>
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
                                    <s:submit key="Grabar" cssClass="btn btn-lg btn-primary"/>
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
        <!-- ./wrapper -->
        <!-- Modal -->
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

    </body>
</html>
