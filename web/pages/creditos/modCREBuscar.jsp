<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal Buscar -->
        <div class="modal fade" id="modalBuscarCre" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2 class="modal-title">Buscar</h2>
                    </div>
                    <div class="modal-body">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <s:if test="infoModal.length() != 0">
                                        <div class="alert alert-info">
                                            <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <s:property value="infoModal"/> </div>
                                        </div>
                                    </s:if>
                                    <s:if test="adverModal.length() != 0">
                                        <div class="alert alert-warning">
                                            <div><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ¡Advertencia!</strong> <s:property value="adverModal"/> </div>
                                        </div>
                                    </s:if>
                                </div>
                            </div>
                        </div>
                        <div class="box-body">
                            <s:form role="form" id="fBuscar">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <s:textfield name="paramBusquedaCre" id="tfParamBusquedaCre" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <center>
                                            <s:submit value="Buscar por Nombre" name="buscarNombre" cssClass="btn btn-default btn-flat" />
                                            <s:submit value="Buscar por DNI" name="buscarDNI" cssClass="btn btn-default btn-flat" />
                                        </center>

                                    </div>
                                </div>
                            </s:form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Código</th>
                                        <th>Nombre</th>
                                        <th>Ver</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="lstClientes" status="rowStatus">
                                        <tr>
                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                            <td><s:property value="codCli" /></td>                                            
                                            <td><s:property value="nomCom" /></td>
                                            <td><s:submit type="button" onclick="return false;"  data-toggle="modal" data-target="#Creditos${codigo}" key="Ver" cssClass="btn btn-success btn-flat btn-md"/></td>
                                            <!-- Modal Créditos -->
                                    <div class="modal fade" id="Creditos${codigo}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <h2 class="modal-title" id="myModalLabel">Créditos</h2>
                                                </div>
                                                <div class="modal-body">
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
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-3">
                                                                <label>Crédito</label>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <label>Producto</label>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <label>Saldo</label>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <label>Moneda</label>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <label>Seleccionar</label>
                                                            </div>
                                                        </div>                                                                
                                                        <s:iterator value="lstCuentas" status="rowStatus">
                                                            <div class="row">
                                                                <div class="col-md-3"><s:property value="cuenta" /></div>
                                                                <div class="col-md-2"><s:property value="producto" /></div>
                                                                <div class="col-md-2"><s:property value="saldo" /></div>
                                                                <div class="col-md-2"><s:property value="moneda" /></div>
                                                                <div class="col-md-3"><button class="btn btn-primary btn-flat btn-md" type="button" onclick="pasarParamCre('<s:property value="cuenta"/>')">Seleccionar</button></div>
                                                            </div>                                                                
                                                        </s:iterator>
                                                    </div>                                
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>