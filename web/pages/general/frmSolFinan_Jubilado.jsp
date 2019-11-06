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
                <s:form action="frmSolFinan_Jubilado" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - JUBILADO</h1> 
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">SI ES JUBILADO POR FAVOR DILIGENCIE ESTE ESPACIO</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Nombre de la Empresa en la cual se Jubiló: </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="jNombEmpJ" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>     
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Nombre de la Empresa donde hizo el Aporte para Jubilación: </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="jNombEmpA" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Hace Cuanto es Jubilado: </label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="jHacecuaJ" style="text-transform: uppercase;" />
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
                                            <s:hidden name="CodEvaluador"></s:hidden>
                                            <s:hidden name="PuntVenta"></s:hidden>
                                            <s:hidden name="FecSolicitud"></s:hidden>
                                            <s:hidden name="cliente.TipDocCiv"></s:hidden>
                                            <s:hidden name="cliente.NroDocCiv"></s:hidden>
                                            <s:hidden name="CiudadExp"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.SegundoNo"></s:hidden>
                                            <s:hidden name="cliente.ApePat"></s:hidden>
                                            <s:hidden name="cliente.ApeMat"></s:hidden>
                                            <s:hidden name="Nacionalidad"></s:hidden>
                                            <s:hidden name="cliente.FecNac"></s:hidden>
                                            <s:hidden name="CiudadNac"></s:hidden>
                                            <s:hidden name="PaisNac"></s:hidden>
                                            <s:hidden name="cliente.sexo"></s:hidden>
                                            <s:hidden name="cliente.EstCiv"></s:hidden>
                                            <s:hidden name="cliente.NivIns"></s:hidden>
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="NperDepend"></s:hidden>
                                            <s:hidden name="cliente.Correo"></s:hidden>
                                            <s:hidden name="cliente.Telefono"></s:hidden>
                                                <!Cónyuge-->
                                            <s:hidden name="cPrimerNomb"></s:hidden>
                                            <s:hidden name="cSegundNomb"></s:hidden>
                                            <s:hidden name="cPrimerApel"></s:hidden>
                                            <s:hidden name="cSegundApel"></s:hidden>
                                            <s:hidden name="cEmpdondTrab"></s:hidden>
                                            <s:hidden name="cEmpCargo"></s:hidden>
                                            <s:hidden name="cEmpTelef"></s:hidden>
                                                <!Vivienda>
                                            <s:hidden name="vSuministro"></s:hidden>
                                            <s:hidden name="vTitularSum"></s:hidden>
                                            <s:hidden name="vRelacTitul"></s:hidden>
                                            <s:hidden name="vTipoVivien"></s:hidden>
                                            <s:hidden name="vHaceCVivea"></s:hidden>
                                            <s:hidden name="vDireccResi"></s:hidden>
                                            <s:hidden name="vDistVivien"></s:hidden>
                                            <s:hidden name="vProvVivien"></s:hidden>
                                            <s:hidden name="vDepaVivien"></s:hidden>
                                            <s:submit name="siguienteJub" value="Siguiente" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
        $("#CodEv").prop('required', true);
        $("#PuntVen").prop('required', true);
        $("#FechaSol").prop('required', true);
        $("#sEstudios").prop('required', true);





        </script>

    </body>
</html>