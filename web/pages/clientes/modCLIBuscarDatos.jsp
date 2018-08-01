<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal Buscar -->
        <div class="modal fade" id="modalBuscarCli" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                                                <s:textfield name="paramBusquedaCli" id="tfParamBusquedaCli" cssClass="form-control"/>
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
                                        <th>Seleccionar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="lstClientes" status="rowStatus">
                                        <tr>
                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                            <td><s:property value="codCli" /></td>                                            
                                            <td><s:property value="nomCom" /></td>
                                            <td><button class="btn btn-primary btn-flat btn-sm" type="button" onclick="pasarDatosCli('<s:property value="codCli"/>')">Seleccionar</button></td>
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