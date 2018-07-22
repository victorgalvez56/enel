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
                <s:form action="cajaCuadreCajero" role="form">
                    <section class="content-header">
                        <h1>
                            Cuadre de Cajero

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
                                                    <center>
                                                        <div class="form-group">
                                                            <s:select name="usuario.codigo" tabindex="1" list="lstCajeros" listKey="codigo" listValue="nombres" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                            <%--<s:select headerKey="-1" headerValue="-- Seleccione --"  list="cajero.cnList" name="country" label="Country"  cssClass="form-control"/>--%>
                                                            <%--<s:select name="cajero" label="" list="lstCajeros" cssClass="form-control"/>--%>


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
                                            <s:submit value="Aplicar" name="aplicar" cssClass="btn btn-default" />
                                            <s:submit value="Salir" name="salir" cssClass="btn btn-default" />
                                        </center>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </s:form>
        </div>

</html>