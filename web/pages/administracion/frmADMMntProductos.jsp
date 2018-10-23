<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Mantenimiento de Productos</h1>
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
                                    <s:form action="frmADMMntProductos" role="form">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label">Código:</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <s:textfield name="" cssClass="form-control" tabindex="1"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label">Nombre:</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <s:textfield name="" cssClass="form-control" tabindex="2"/>
                                            </div>
                                        </div>
                                        <s:hidden name=""/>
                                        <div class="row">
                                            <div class="col-md-3">
                                                <s:submit key="boton.nuevo" cssClass="btn btn-primary btn-block btn-flat"/>
                                            </div>
                                            <div class="col-md-3">
                                                <s:submit key="boton.aplicar" cssClass="btn btn-primary btn-block btn-flat"/>
                                            </div>
                                            <div class="col-md-3">
                                                <s:submit key="boton.grabar" cssClass="btn btn-primary btn-block btn-flat"/>
                                            </div>
                                            <div class="col-md-3">
                                                <s:submit key="boton.buscar" cssClass="btn btn-primary btn-block btn-flat"/>
                                            </div>
                                        </div>
                                    </s:form>
                                </div>
                                <div class="table-responsive col-md-6">
                                    <table class="table">
                                        <tr>
                                            <th>#</th>
                                            <th>Código</th>
                                            <th>Producto</th>
                                            <th>Porcentaje (%)</th>
                                            <th>Modificar</th>
                                        </tr>
                                        <s:iterator value="lstProducts" status="rowStatus">
                                            <tr>
                                                <th data-th="#"><s:property value="%{#rowStatus.count}"/></th>
                                                <td data-th="Código"><s:property value="codigo"/></td>
                                                <td data-th="Nombre"><s:property value="producto" /></td>
                                                <td data-th="Estado"><s:property value="porcentaje" /></td>
                                                <td data-th="Modificar">
                                                    <s:url id="verURL" action="frmADMMntProducts">
                                                        <s:param name="oficina.codOfi" value="%{codOfi}"></s:param>
                                                    </s:url>
                                                    <s:a href="%{verURL}">Modificar</s:a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
