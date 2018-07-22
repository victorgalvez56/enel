<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function cargarConfCobranza() {
                document.frmPrincipal.action = 'frmCobParametrizar';
                document.frmPrincipal.submit();
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form name="frmPrincipal" action="parametrizaCobranza" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Parametrizar Asignacion de Cartera</h1>                  
                    </section>
                    <!-- Main content -->
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
                                </div>
                                <div class="col-xs-12">
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="control-label">Gestor:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <s:select 
                                                name="configCobranza.usuario.codigo" 
                                                tabindex="1" 
                                                list="lstGestoresCobranza" 
                                                listKey="codigo" 
                                                listValue="nombre" 
                                                headerKey="0" 
                                                headerValue="-- Seleccione --" 
                                                cssClass="form-control"
                                                onchange="cargarConfCobranza();"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="control-label">Oficinas:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">                                    
                                            <s:select 
                                                name="configCobranza.lstCodOfi"
                                                multiple="true"
                                                list="lstOficinas"
                                                listKey="codigo" 
                                                listValue="nombre"
                                                value="configCobranza.lstCodOfi" 
                                                cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-8">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Fecha Min.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.fecMin" cssClass="form-control" type="date" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Fecha Max.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.fecMax" cssClass="form-control" type="date" />
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Desembolso Min.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.desMin" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Desembolso Max.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.desMax" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Saldo Min.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.salMin" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Saldo Max.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.salMax" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Plazo Min. (dias):</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.plaMin" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Plazo Max. (dias):</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.plaMax" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Atraso Mín.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.atrMin" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="control-label">Atraso Max.:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <s:textfield name="configCobranza.atrMax" cssClass="form-control" type="number" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <br><br>
                                </div>                            
                                <div class="col-xs-3">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">Destino de Credito:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">                                    
                                            <s:select 
                                                name="configCobranza.lstCodDes"
                                                multiple="true"
                                                list="lstDestinos"
                                                listKey="codigo" 
                                                listValue="nombre"
                                                value="configCobranza.lstCodDes" 
                                                cssClass="form-control"/>
                                        </div>

                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">Condicion:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">                                    
                                            <s:select 
                                                name="configCobranza.lstCodCon"
                                                multiple="true"
                                                list="lstCondiciones"
                                                listKey="codigo" 
                                                listValue="nombre"
                                                value="configCobranza.lstCodCon" 
                                                cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label">Productos:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">                                    
                                            <s:select 
                                                name="configCobranza.lstCodPro"
                                                multiple="true"
                                                list="lstProductos"
                                                listKey="codigo" 
                                                listValue="nombre"
                                                value="configCobranza.lstCodPro" 
                                                cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div style="float: right">
                                    <s:submit key="Grabar" cssClass="btn btn-lg btn-primary"/>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- /.content -->
                </s:form>
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>