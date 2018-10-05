<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
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
                                    <div><span class="glyphicon glyphicon-info-sign"></span><<strong> Información</strong> <s:property value="informacion"/> </div>
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
                <s:form action="frmCREMntRangoScore" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Mantenimiento de Rango - Score</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="nav-tabs-custom">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active"><a href="#bancarizados" data-toggle="tab">Clientes Bancarizados</a></li>
                                                            <li><a  href="#noBancarizados" data-toggle="tab">Clientes no Bancarizados</a></li>
                                                        </ul>
                                                        <div class="tab-content">
                                                            <div class="active tab-pane" id="bancarizados">
                                                                <div class="box-body">
                                                                    <table class="table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>#</th>
                                                                                <th>Perfil</th>
                                                                                <th>Puntaje mínimo</th>
                                                                                <th>Puntaje máximo</th>
                                                                                <th>Seleccionar</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <s:iterator value="" status="rowStatus">
                                                                                <tr style="text-transform: uppercase;">
                                                                                    <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><center><input type="checkbox" onclick="cliSeleccionado('<s:property value="codCli"/>')"></center></td>
                                                                                </tr>
                                                                            </s:iterator>
                                                                        </tbody>
                                                                    </table><br>
                                                                </div>
                                                            </div>
                                                            <div class="tab-pane" id="noBancarizados">
                                                                <div class="box-body">
                                                                    <table class="table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>#</th>
                                                                                <th>Perfil</th>
                                                                                <th>Puntaje mínimo</th>
                                                                                <th>Puntaje máximo</th>
                                                                                <th>Seleccionar</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <s:iterator value="" status="rowStatus">
                                                                                <tr style="text-transform: uppercase;">
                                                                                    <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><s:property value="" /></td>
                                                                                    <td><center><input type="checkbox" onclick="cliSeleccionado('<s:property value="codCli"/>')"></center></td>
                                                                                </tr>
                                                                            </s:iterator>
                                                                        </tbody>
                                                                    </table><br>
                                                                </div>
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
                                            <s:submit value="Grabar" name="" cssClass="btn btn-primary btn-flat" />
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
