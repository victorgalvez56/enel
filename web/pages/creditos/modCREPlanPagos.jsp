<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal Buscar -->
        <div class="modal fade" id="modalPlanPagos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2 class="modal-title">Plan de Pagos</h2>
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
                            <div class="row">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Fecha</th>
                                            <th>Tipo</th>
                                            <th>Capital</th>
                                            <th>Interes</th>
                                            <th>Cuota</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="credito.planPagos" status="rowStatus">
                                            <tr style="text-transform: uppercase;">
                                                <th><s:property value="numero" /></th>
                                                <td><s:property value="fecha" /></td>                                            
                                                <td><s:property value="tipo" /></td>
                                                <td><s:property value="capital" /></td>
                                                <td><s:property value="interes" /></td>
                                                <td><s:property value="cuota" /></td>                                            
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>