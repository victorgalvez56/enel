<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal Buscar -->
        <div class="modal fade" id="modalAsignarVenta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2 class="modal-title">Asignar Venta</h2>
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
                            <s:form role="form" id="fAsignar">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Crédito</label>
                                                <s:textfield name="credito.codCta" id="tfCodCre" cssClass="form-control" required="true" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Canales</label>
                                                <s:textfield id="tfCanales" cssClass="form-control" required="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Venta</label>
                                                <s:textfield name="codigoVenta" id="tfCodigoVenta" cssClass="form-control" required="true"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <center>
                                            <s:submit value="Asignar" name="asignar" cssClass="btn btn-default btn-flat" />
                                        </center>
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