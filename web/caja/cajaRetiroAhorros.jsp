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
                                <div><strong>¡Bienvenido(a)!</strong> <s:property value="mensaje"/> </div>
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
                <s:form action="cajaRetiroAhorros" role="form">
                    <section class="content-header">
                        <h1>
                            Retiro de Ahorros

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
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Cuenta:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <s:textfield name="cliente.nroCuenta" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield name="" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <s:textfield name="" cssClass="form-control"/>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-3 col-md-offset-5">
                                                        <div class="box box-primary box-solid">
                                                            <div class="box-body">
                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="checkbox">
                                                                            <label>
                                                                                <s:checkbox name=""/>
                                                                                Operación NO Presencial
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Cliente:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <%--<s:select name="" tabindex="1" listKey="" headerKey="1" multiple="true" cssClass="form-control" list="#@java.util.LinkedHashMap@{'01':'Opcion1','02':'Opcion2','03':'Opcion3'}"/>--%>
                                                            <s:select headerKey="-1" multiple="true" list="clientesCaja" name="tusClientesCaja" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">

                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Monto de Retiro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield type="number" name="" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: left">
                                            <s:submit value="F" cssClass="btn btn-default" />
                                        </div>
                                        <div style="float: right">
                                            <s:submit value="Aplicar" name="aplicar" cssClass="btn btn-default" />
                                            <s:submit value="Grabar" name="grabar" cssClass="btn btn-default" />
                                            <s:submit value="Cancelar" name="cancelar" cssClass="btn btn-default" />
                                            <input type="button" id="retiroCaja_buscar" name="buscar" value="Buscar" class="btn btn-default" data-toggle="modal" data-target="#busquedaRegistros">
                                            <%--<s:submit value="Buscar" name="buscar" cssClass="btn btn-default" />--%>
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
                                                                        <th>Nro. Cuenta</th>
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