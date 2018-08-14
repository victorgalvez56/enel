<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal Buscar -->
        <div class="modal fade" id="modalRechazarSolici" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2 class="modal-title">Motivo:</h2>
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
                            <s:form role="form" id="fRechazar">
                            <div class="row">
                                <div class="col-md-3"></div>
                                <div class="col-md-9">
                                    <!--select credito.condic-->
                                    <label>Comentario:</label>
                                    <s:textfield cssClass="form-control" id="tfCondic" name="credito.condic" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12" align="right">
                                    <s:submit value="Aceptar" name="aceptar" cssClass="btn btn-default btn-flat" />
                                </div>
                            </div>
                            </s:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>