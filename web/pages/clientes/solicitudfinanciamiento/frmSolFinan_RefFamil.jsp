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
                                                            <s:textfield cssClass="form-control" id="rfpNomb" tabindex="1" name="rFPrimerNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="rfsNomb" tabindex="2" name="rFSegundoNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="rfpApell" tabindex="3" name="rFPrimerApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="rfsApell" tabindex="4" name="rFSegundoApell" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección: </label>
                                                            <s:textfield cssClass="form-control" id="rfDirec" tabindex="5" name="rFDirec" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito:  </label>
                                                            <s:select name="rFDistr" tabindex="6" id="rfDistr" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="rFProvi" tabindex="7" id="rfProv" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield cssClass="form-control" id="rfEstad" tabindex="8" name="rFEstad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono </label>
                                                            <s:textfield type="number" cssClass="form-control" id="rfTelef" tabindex="9" name="rFTelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Celular:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="rfCelul" tabindex="10" name="rFCelul" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Parentesco:  </label>
                                                            <s:textfield cssClass="form-control" id="rfParent" tabindex="11" name="rFParen" style="text-transform: uppercase;" />
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
                                                <!Empleado-->
                                            <s:hidden name="eNombreEmpr"></s:hidden>
                                            <s:hidden name="eRUCEmpr"></s:hidden>
                                            <s:hidden name="eActivdEmpr"></s:hidden>
                                            <s:hidden name="eDirEmpr"></s:hidden>
                                            <s:hidden name="eDepEmpr"></s:hidden>
                                            <s:hidden name="eDisEmpr"></s:hidden>
                                            <s:hidden name="eProvEmpr"></s:hidden>
                                                <!Independiente-->
                                            <s:hidden name="iLabor"></s:hidden>
                                            <s:hidden name="iHacecuantInd"></s:hidden>
                                            <s:hidden name="iTipodeInd"></s:hidden>
                                            <s:hidden name="fNombEmpr"></s:hidden>
                                            <s:hidden name="fRUCEmpr"></s:hidden>
                                            <s:hidden name="fCargo"></s:hidden>
                                            <s:hidden name="fDirLabo"></s:hidden> 
                                            <s:hidden name="fDisLabo"></s:hidden>
                                            <s:hidden name="fProLabo"></s:hidden>
                                            <s:hidden name="fDepLabo"></s:hidden>
                                            <s:hidden name="fTelef"></s:hidden>
                                            <s:hidden name="fAnexo"></s:hidden>
                                                <!Jubilado-->
                                            <s:hidden name="jNombEmpJ"></s:hidden>
                                            <s:hidden name="jNombEmpA"></s:hidden>
                                            <s:hidden name="jHacecuaJ"></s:hidden>  
                                            <s:hidden name="TipoIndep"></s:hidden>
                                                <!Información Financiera-->
                                            <s:hidden name="iSueldBas"></s:hidden>
                                            <s:hidden name="gAlquiler"></s:hidden>
                                            <s:hidden name="iComisiones"></s:hidden>
                                            <s:hidden name="gCreditoViv"></s:hidden>
                                            <s:hidden name="iHonorarios"></s:hidden>
                                            <s:hidden name="gGastosFamil"></s:hidden>
                                            <s:hidden name="iAlquileres"></s:hidden> 
                                            <s:hidden name="gTarjetasCred"></s:hidden>
                                            <s:hidden name="iOtrosIngres"></s:hidden>
                                            <s:hidden name="gOtrosGas"></s:hidden>
                                            <s:hidden name="iTotalIng"></s:hidden>
                                            <s:hidden name="gTotalGas"></s:hidden>
                                            <s:hidden name="iTotalAct"></s:hidden>
                                            <s:hidden name="gTotalPat"></s:hidden>  
                                                <!Ref Personales-->
                                            <s:hidden name="rPPrimerNomb"></s:hidden>
                                            <s:hidden name="rPSegundoNomb"></s:hidden>
                                            <s:hidden name="rPPrimerApell"></s:hidden>
                                            <s:hidden name="rPSegundoApell"></s:hidden>      
                                            <s:hidden name="rPDirec"></s:hidden>
                                            <s:hidden name="rPDistr"></s:hidden>
                                            <s:hidden name="rPProvi"></s:hidden>
                                            <s:hidden name="rPEstad"></s:hidden>      
                                            <s:hidden name="rPTelef"></s:hidden>
                                            <s:hidden name="rPCelul"></s:hidden>
                                            <s:hidden name="rPParen"></s:hidden>      


                                            <s:submit name="siguienteFamil" value="Siguiente" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
        $('#rfpNomb').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfsNomb').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfpApell').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfsApell').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });

        $('#rfDirec').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfEstad').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfTelef').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });
        $('#rfCelul').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });

        $('#rfParent').on('input', function (e) {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ@.]+/ig, "");
            }
        });

        </script>

    </body>
</html>