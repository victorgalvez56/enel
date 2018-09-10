<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>WORKFLOW</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmREPCREWorkFlow" role="form">                            
                                <div class="row">
                                    <div class="col-lg-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div><span class="glyphicon glyphicon-ok"></span><strong> Mensaje:</strong> <s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <s:property value="informacion"/> </div>
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

                                <div class="row">                                
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Solicitud</label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="1" name="credito.codCta" readonly="true" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Código de Cliente:</label>
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="2" name="credito.cliente.codCli" readonly="true" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Nombre:</label>
                                                            <s:textfield cssClass="form-control" style="text-transform: uppercase;" id="tfNomCli" tabindex="3" name="credito.cliente.nomCom" readonly="true"/><br>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">                                                        
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>Proceso</th>
                                                                <th>Fecha de Proceso</th>
                                                                <th>Hora</th>
                                                                <th>Usuario</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <s:iterator value="lstLog" status="rowStatus">
                                                                <tr style="text-transform: uppercase;">
                                                                    <th><s:property value="%{#rowStatus.count}" /></th>
                                                                    <td><s:property value="operacion" /></td>
                                                                    <td><s:property value="fecha" /></td>
                                                                    <td><s:property value="hora" /></td>
                                                                    <td><s:property value="usuario" /></td>
                                                                </tr>
                                                            </s:iterator>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </s:form>                                                    
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>