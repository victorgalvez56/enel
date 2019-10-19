<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <s:if test="mensaje.length() != 0">
                            <div class="alert alert-success">
                                <div class="glyphicon glyphicon-ok"></div>
                                <div><strong>¡Correcto!</strong> <s:property value="mensaje"/> </div>
                            </div>
                        </s:if>
                        <s:if test="informacion.length() != 0">
                            <div class="alert alert-info">
                                <div class="glyphicon glyphicon-info-sign"></div>
                                <div><strong>Información</strong> <s:property value="informacion"/> </div>
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
                <s:form action="frmSolFinan_RefPerso" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - REFERENCIAS PERSONALES</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">No deben trabajar con el solicitante</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield cssClass="form-control" id="Pnombre" tabindex="11" name="rPPrimerNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="Snombre" tabindex="11" name="rPSegundoNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="Papellido" tabindex="11" name="rPPrimerApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="Sapellido" tabindex="11" name="rPSegundoApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección: </label>
                                                            <s:textfield cssClass="form-control" id="Direc" tabindex="11" name="rPDirec" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito:  </label>
                                                            <s:select name="rPDistr" tabindex="10" id="Distr" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="rPProvi" tabindex="10" id="Provinc" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="Telef" tabindex="11" name="rPEstad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono </label>
                                                            <s:textfield type="number" cssClass="form-control" id="Telef" tabindex="11" name="rPTelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Celular:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="Celular" tabindex="11" name="rPCelul" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Parentesco:  </label>
                                                            <s:textfield cssClass="form-control" id="Parent" tabindex="11" name="rPParen" style="text-transform: uppercase;" />
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
                                            <s:hidden  cssClass="tipoin" id="tipoindeform" tabindex="11" name="codEva" style="text-transform: uppercase;" />
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="cliente.Sexo"></s:hidden>
                                            <s:submit name="siguientePerso" value="Siguiente" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
        </div>
        <script src="/enel/bower_components/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="/enel/js/script.js"></script>        
        <script type="text/javascript" src="/enel/js/main.js"></script>
        <!-- iCheck -->
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>
        <script>
            /*
        $("#Pnombre").prop('required', true);
        $("#Snombre").prop('required', true);
        $("#Papellido").prop('required', true);
        $("#Sapellido").prop('required', true);
        $("#Direc").prop('required', true);
        $("#Distr").prop('required', true);
        $("#Provinc").prop('required', true);
        $("#Distr").prop('required', true);
        $("#Pronv").prop('required', true);
        $("#Depar").prop('required', true);
        $("#Estad").prop('required', true);
        $("#Telef").prop('required', true);
        $("#Celular").prop('required', true);
        $("#Parent").prop('required', true);
        */
        </script>

    </body>
</html>