<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
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
                <s:form action="cajaDepositos" role="form">
                    <section class="content-header">
                        <h1>
                            Depósitos

                        </h1>

                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <!--                        <div class="box-header with-border">
                                                        <h3 class="box-title">Aprobación por Comité</h3>
                                                    </div>-->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">

                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="control-label">Cuenta:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="cliente.nroCuenta" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="" cssClass="form-control"/>
                                                    </div>
                                                </div>


                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="control-label">Cliente:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield name="cliente.titular" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <s:textfield name="" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header">
                                                <h3 class="box-title">Monto a Depositar</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label class="control-label">Monto de Depósito:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <s:textfield type="number" name="monto" cssClass="form-control"/>
                                                    </div>
                                                </div>

                                                <div class="col-md-4">
                                                    <div class="checkbox">
                                                        <label>
                                                            <s:checkbox name=""/>
                                                            Monto con IFT
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit value="Aplicar" name="aplicar" cssClass="btn btn-default" />
                                            <s:submit value="Grabar" name="grabar" cssClass="btn btn-default" />
                                            <s:submit value="Cancelar" name="cancelar" cssClass="btn btn-default" />
                                            <input type="button" id="retiroCaja_buscar" name="buscar" value="Buscar" class="btn btn-default" data-toggle="modal" data-target="#busquedaRegistros">
                                            <%--<s:submit value="Buscar" cssClass="btn btn-default"/>--%>
                                            <s:submit value="Salir" name="salir" cssClass="btn btn-default" />
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
                                                <div class="col-md-2">
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
                                                </div>
                                                <table class="table table-bordered">
                                                    <tbody><tr>
                                                            <th style="width: 10px">#</th>
                                                            <th style="width: 150px">Nro. Documento</th>
                                                            <th>Cliente</th>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
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