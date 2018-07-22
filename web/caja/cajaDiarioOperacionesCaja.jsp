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
                <s:form action="diarioOperacionesCaja" role="form">
                    <section class="content-header">
                        <h1>
                            Diario de Operaciones de Caja

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
                                    <div class="col-md-4 col-md-offset-4">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <center><label>Fecha de Proceso:</label></center>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-8 col-md-offset-2">
                                                        <div class="form-group">
                                                            <s:textfield type="date" name="" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <center>
                                                        <div class="form-group">
                                                            <s:select
                                                                headerKey="-1" headerValue="-- Seleccione --"
                                                                list="cajerosCaja"
                                                                name="tusCajerosCaja"
                                                                cssClass="form-control"/>
                                                        </div>
                                                    </center>
                                                </div>
                                                <div class="col-md-12">
                                                    <center>
                                                        <div class="checkbox">
                                                            <label>
                                                                <s:checkbox name=""/>
                                                                ¿Obviar Nulos?
                                                            </label>
                                                        </div>
                                                    </center>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <center>
                                            <s:submit value="Imprimir" name="imprimir" cssClass="btn btn-default" />

                                            <s:submit value="Salir" name="salir" cssClass="btn btn-default" />
                                        </center>

                                    </div>
                                </div>
                            </div>
                        </div>
                </div>



            </section>
        </s:form>
    </div>

</html>