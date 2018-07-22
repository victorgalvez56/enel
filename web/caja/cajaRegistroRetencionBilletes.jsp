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
                <s:form action="cajaRegistroRetencionBilletes" role="form">
                    <section class="content-header">
                        <h1>
                            Registro de Retención de Billetes

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
                                            <div class="box-header">
                                                <h3 class="box-title">Datos del Cliente</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Titular</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <div class="form-group">
                                                            <s:textfield name="cliente.titular" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Telefono:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" name="cliente.telefono" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <s:textfield name="cliente.direccion" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Doc. de Identidad</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield id="nroDoc" name="cliente.nroDoc" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <s:submit value="Buscar" name="buscar" cssClass="btn btn-default" />
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
                                                <h3 class="box-title">Registro de Retención</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-6">
                                                    <div class="col-md-12">
                                                        <div class="box box-primary box-solid">
                                                            <div class="box-body">
                                                                <table class="table">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Denominación</th>
                                                                            <th>Serie y Numero</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <s:iterator value="lstSolicitudesOpinionRiesgo">
                                                                            <tr>
                                                                                <td data-th="Denominación"><s:property value="100"/>100</td>
                                                                                <td data-th="Serie y Numero"><s:property value="054110551616" /></td>
                                                                            </tr>
                                                                        </s:iterator>
                                                                        <tr>
                                                                            <td data-th="Denominación"><s:property value="100"/></td>
                                                                            <td data-th="Serie y Numero"><s:property value="054110551616" /></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>

                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <s:submit value="Nuevo" cssClass="btn btn-default" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <s:submit value="Eliminar" cssClass="btn btn-default" />
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="col-md-12">
                                                            <div class="form-group">
                                                                <label>Cómo y donde obtubo los billetes</label>
                                                                <s:textarea cssClass="form-control" name="" rows="5"/>
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

                                            <s:submit value="Nuevo" name="nuevo" cssClass="btn btn-default" />
                                            <s:submit value="Cancelar" name="cancelar" cssClass="btn btn-default" />
                                            <s:submit value="Grabar" name="grabar" cssClass="btn btn-default" />
                                            <s:submit value="Salir" name="salir" cssClass="btn btn-default" />
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>



                    </section>
                </s:form>
            </div>

</html>