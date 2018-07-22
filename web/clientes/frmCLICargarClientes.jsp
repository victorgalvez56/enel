<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Cargar Clientes</h1>
                </section>
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
                                <div class="col-md-6">
                                    <s:form action="cargarClientes" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">

                                            <s:text name='Archivo de usuarios (.csv)'/>:<s:file name="archivoClientes" accept="text/csv" cssClass="form-control"/>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <s:submit key="Cargar" cssClass="btn btn-primary btn-block btn-flat"/>
                                            </div>
                                        </div>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>