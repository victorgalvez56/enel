<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="modCLIBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onloadCli()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <s:if test="mensaje.length() != 0">
                                <div class="alert alert-success">
                                    <div><span class="glyphicon glyphicon-ok"></span><strong> ¡Correcto!</strong> <s:property value="mensaje"/> </div>
                                </div>
                            </s:if>
                            <s:if test="informacion.length() != 0">
                                <div class="alert alert-info">
                                    <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <span id="info"><s:property value="informacion"/></span> </div>
                                </div>
                            </s:if>
                            <s:if test="advertencia.length() != 0">
                                <div class="alert alert-warning">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ¡Advertencia!</strong> <s:property value="advertencia"/> </div>
                                </div>
                            </s:if>
                            <s:if test="error.length() != 0">
                                <div class="alert alert-danger">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span> <s:property value="error"/></div>
                                </div>
                            </s:if>
                        </div>
                    </div>
                </div>
                <!-- Content header -->
                <section class="content-header">
                    <h1>Mantenedor de Cliente</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <label class="control-label">FILTROS DE BÚSQUEDA:</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label class="control-label">Código Cliente:</label>
                                </div>
                                <div class="col-md-2">
                                    <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" />
                                </div>
                                <div class="col-md-2">
                                    <label class="control-label">Ape. Paterno:</label>
                                </div>
                                <div class="col-md-2">
                                    <s:textfield cssClass="form-control" id="tfsuministro" tabindex="2" name="cliente.sumini"/>
                                </div>
                                <div class="col-md-2">
                                    <label class="control-label">Departamento:</label>
                                </div>
                                <div class="col-md-2">
                                    <s:textfield cssClass="form-control" id="tfsuministro" tabindex="2" name="cliente.sumini"/>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>

        </div>
    </div>
</section>
</div>
</div>
</body>    
</html>