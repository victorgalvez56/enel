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
                <s:form id="formulario" action="frmSolFinan_Independiente" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - INDEPENDIENTE</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">SI ES INDEPENDIENTE POR FAVOR DILIGENCIE ESTE ESPACIO</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Describa específicamente la labor que realiza como independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="ilabor" tabindex="1" name="ilabor" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Hace cuanto es independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="ihacecuantInd" tabindex="2" name="ihacecuantInd" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Tipo de Independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="itipodeInd" tabindex="3" name="itipodeInd" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>En caso de tener constituida una empresa favor diligenciar este espacio: </label>
                                                    </div>
                                                </div>
                                            </div>        
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Nombre de la Empresa(Si aplica): </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="fnombEmpr" tabindex="4" name="fnombEmpr" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>RUC: </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="frucEmpr" tabindex="5" name="frucEmpr" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Cargo/Ocupación: </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="fcargo" tabindex="6" name="fcargo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección donde Labora: </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="fdirLabo" tabindex="7" name="fdirLabo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Distrito: </label>
                                                            <s:select name="fdisLabo" tabindex="8" cssClass="form-control tipoindep" id="fdisLabo" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Provincia: </label>
                                                            <s:select name="fproLabo" tabindex="9" cssClass="form-control tipoindep" id="fproLabo" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Departamento: </label>
                                                            <s:select name="fdepLabo" tabindex="10" icssClass="form-control tipoindep" id="fdepLabo" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Teléfono: </label>
                                                            <s:textfield type="number" cssClass="form-control tipoindep" id="ftelef" tabindex="11" name="ftelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Anexo: </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="fanexo" tabindex="12" name="fanexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico: </label>
                                                            <s:textfield type="email" cssClass="form-control tipoindep" id="fcorreo" tabindex="13" name="fcorreo" style="text-transform: uppercase;" />
                                                            <s:hidden cssClass="form-control Tempresa" id="Tempresa"  name="tipoIndep" style="text-transform: uppercase;" />

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
                                            <s:submit name="siguienteIndep" value="Siguiente" tabindex="14"  id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
         $("#labIndependiente").prop('required', true);
         $("#haceIndependiente").prop('required', true);
         $("#tipIndependiente").prop('required', true);
         */
        var obj2 = $("#Tempresa")
        obj2.val("Informal")
        $(document).on("keyup", ".tipoindep", function () {
            var obj = $(".tipoindep")
            //0.Informal. 1.Formal
            if (obj.val().length <= 0) {
                obj2.val("Informal")
            } else {
                obj2.val("Formal")
            }
        })

        </script>

    </body>
</html>