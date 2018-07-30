<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form action="IMPEstadoCuentaPDF" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Estado de Cuenta de Saldo</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
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

                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <div class="col-md-6 col-lg-offset-3">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label class="control-label">Nombre del Cliente:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-9">
                                                    <div class="form-group">
                                                        <s:textfield name="" cssClass="form-control" required="true" />
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
                                <center>
                                    <s:submit key="Procesar" cssClass="btn btn-lg btn-primary"/>
                                </center>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
        </div>
    </body>
</html>