<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form action="generarMoraXLS" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Reporte de Mora</h1>
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
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Días atraso:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <s:textfield name="FecmoraIni" cssClass="form-control" type="text" required="true" style="text-transform: uppercase;" />
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <center>
                                                        <s:submit key="Generar" cssClass="btn btn-lg btn-primary"/>
                                                    </center>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
        </div>
    </body>
</html>