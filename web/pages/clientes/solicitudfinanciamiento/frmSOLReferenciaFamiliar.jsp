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
                <s:form action="frmSolFinan_RefFamil" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - REFERENCIAS FAMILIARES</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">No deben vivir con el solicitante</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield cssClass="form-control" id="rfprimerNomb" tabindex="1" name="rfprimerNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="rfsegundoNomb" tabindex="2" name="rfsegundoNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="rfprimerApell" tabindex="3" name="rfprimerApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="rfsegundoApell" tabindex="4" name="rfsegundoApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección: </label>
                                                            <s:textfield cssClass="form-control" id="rfdirec" tabindex="5" name="rfdirec" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito:  </label>
                                                            <s:select name="rfdistr" tabindex="6" id="rfdistr" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="rfprovi" tabindex="7" id="rfprovi" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield cssClass="form-control" id="rfestad" tabindex="8" name="rfestad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono </label>
                                                            <s:textfield type="number" cssClass="form-control" id="rftelef" tabindex="9" name="rftelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Celular:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="rfcelul" tabindex="10" name="rfcelul" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Parentesco:  </label>
                                                            <s:textfield cssClass="form-control" id="rfparen" tabindex="11" name="rfparen" style="text-transform: uppercase;" />
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
                                                <!Empleado-->
                                            <s:hidden name="enombreEmpr"></s:hidden>
                                            <s:hidden name="erUCEmpr"></s:hidden>
                                            <s:hidden name="eactivdEmpr"></s:hidden>
                                            <s:hidden name="edirEmpr"></s:hidden>
                                            <s:hidden name="edepEmpr"></s:hidden>
                                            <s:hidden name="edisEmpr"></s:hidden>
                                            <s:hidden name="eprovEmpr"></s:hidden>
                                                <!Independiente-->
                                            <s:hidden name="ilabor"></s:hidden>
                                            <s:hidden name="ihacecuantInd"></s:hidden>
                                            <s:hidden name="itipodeInd"></s:hidden>
                                            <s:hidden name="fnombEmpr"></s:hidden>
                                            <s:hidden name="frucEmpr"></s:hidden>
                                            <s:hidden name="fcargo"></s:hidden>
                                            <s:hidden name="fdirLabo"></s:hidden> 
                                            <s:hidden name="fdisLabo"></s:hidden>
                                            <s:hidden name="fproLabo"></s:hidden>
                                            <s:hidden name="fdepLabo"></s:hidden>
                                            <s:hidden name="ftelef"></s:hidden>
                                            <s:hidden name="fanexo"></s:hidden>
                                                <!Jubilado-->
                                            <s:hidden name="jnombEmpJ"></s:hidden>
                                            <s:hidden name="jnombEmpA"></s:hidden>
                                            <s:hidden name="jhacecuaJ"></s:hidden>  
                                            <s:hidden name="tipoIndep"></s:hidden>
                                                <!Información Financiera-->
                                            <s:hidden name="isueldBas"></s:hidden>
                                            <s:hidden name="galquiler"></s:hidden>
                                            <s:hidden name="icomisiones"></s:hidden>
                                            <s:hidden name="gcreditoViv"></s:hidden>
                                            <s:hidden name="ihonorarios"></s:hidden>
                                            <s:hidden name="ggastosFamil"></s:hidden>
                                            <s:hidden name="ialquileres"></s:hidden> 
                                            <s:hidden name="gtarjetasCred"></s:hidden>
                                            <s:hidden name="iotrosIngres"></s:hidden>
                                            <s:hidden name="gotrosGas"></s:hidden>
                                            <s:hidden name="itotalIng"></s:hidden>
                                            <s:hidden name="gtotalGas"></s:hidden>
                                            <s:hidden name="itotalAct"></s:hidden>
                                            <s:hidden name="gtotalPat"></s:hidden>  
                                                <!Ref Personales-->
                                            <s:hidden name="rpprimerNomb"></s:hidden>
                                            <s:hidden name="rpsegundoNomb"></s:hidden>
                                            <s:hidden name="rpprimerApell"></s:hidden>
                                            <s:hidden name="rpsegundoApell"></s:hidden>      
                                            <s:hidden name="rpdirec"></s:hidden>
                                            <s:hidden name="rpdistr"></s:hidden>
                                            <s:hidden name="rpprovi"></s:hidden>
                                            <s:hidden name="rpestad"></s:hidden>      
                                            <s:hidden name="rptelef"></s:hidden>
                                            <s:hidden name="rpcelul"></s:hidden>
                                            <s:hidden name="rpparen"></s:hidden>      


                                            <s:submit name="siguienteFamil" value="Siguiente" tabindex="12" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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