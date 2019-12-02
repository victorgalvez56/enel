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
                                                            <s:textfield type="text" cssClass="form-control" id="jnombEmpJ" tabindex="1" name="jnombEmpJ" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>     
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Nombre de la Empresa donde hizo el Aporte para Jubilación: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="jnombEmpA" tabindex="2" name="jnombEmpA" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Hace Cuanto es Jubilado: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="jhacecuaJ" tabindex="3" name="jhacecuaJ" style="text-transform: uppercase;" />
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
                                            <s:hidden name="codEvaluador"></s:hidden>
                                            <s:hidden name="puntVenta"></s:hidden>
                                            <s:hidden name="fecSolicitud"></s:hidden>
                                            <s:hidden name="cliente.TipDocCiv"></s:hidden>
                                            <s:hidden name="cliente.NroDocCiv"></s:hidden>
                                            <s:hidden name="ciudadExp"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.SegundoNo"></s:hidden>
                                            <s:hidden name="cliente.ApePat"></s:hidden>
                                            <s:hidden name="cliente.ApeMat"></s:hidden>
                                            <s:hidden name="nacionalidad"></s:hidden>
                                            <s:hidden name="cliente.FecNac"></s:hidden>
                                            <s:hidden name="ciudadNac"></s:hidden>
                                            <s:hidden name="paisNac"></s:hidden>
                                            <s:hidden name="cliente.sexo"></s:hidden>
                                            <s:hidden name="cliente.EstCiv"></s:hidden>
                                            <s:hidden name="cliente.NivIns"></s:hidden>
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="nperDepend"></s:hidden>
                                            <s:hidden name="cliente.Correo"></s:hidden>
                                            <s:hidden name="cliente.Telefono"></s:hidden>
                                                <!Cónyuge-->
                                            <s:hidden name="cprimerNomb"></s:hidden>
                                            <s:hidden name="csegundNomb"></s:hidden>
                                            <s:hidden name="cprimerApel"></s:hidden>
                                            <s:hidden name="csegundApel"></s:hidden>
                                            <s:hidden name="cempdondTrab"></s:hidden>
                                            <s:hidden name="cempCargo"></s:hidden>
                                            <s:hidden name="cempTelef"></s:hidden>
                                                <!Vivienda>
                                            <s:hidden name="vsuministro"></s:hidden>
                                            <s:hidden name="vtitularSum"></s:hidden>
                                            <s:hidden name="vrelacTitul"></s:hidden>
                                            <s:hidden name="vtipoVivien"></s:hidden>
                                            <s:hidden name="vhaceCVivea"></s:hidden>
                                            <s:hidden name="vdireccResi"></s:hidden>
                                            <s:hidden name="vdistVivien"></s:hidden>
                                            <s:hidden name="vprovVivien"></s:hidden>
                                            <s:hidden name="vdepaVivien"></s:hidden>
                                            <s:submit name="siguienteJub" value="Siguiente" tabindex="4"  id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
        $(document).on("keyup", 'input[type="text"]', function () {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ]+/ig, "");
            }
        })



        </script>

    </body>
</html>