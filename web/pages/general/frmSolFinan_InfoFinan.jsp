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
                <s:form action="frmSolFinan_InfoFinan" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - INFORMACIÓN FINANCIERA</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="control-label">Ingresos mensuales del Solicitante</label>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="control-label">Gastos mensuales del Solicitante</label>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Sueldo básico:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number"  cssClass="form-control ingresos" id="sueldobasico" tabindex="11" name="iSueldBas" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Alquiler:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento2" tabindex="11" name="gAlquiler" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Comisiones:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control ingresos" id="elemento3" tabindex="11" name="iComisiones" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Crédito de Vivienda:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento4" tabindex="11" name="gCreditoViv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Honorarios:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control ingresos" id="elemento5" tabindex="11" name="iHonorarios" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Gastos Familiares:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento6" tabindex="11" name="gGastosFamil" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Alquileres:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control ingresos" id="elemento7" tabindex="11" name="iAlquileres" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tarjetas de Crédito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento8" tabindex="11" name="gTarjetasCred" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Otros Ingresos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control ingresos" id="elemento9" tabindex="11" name="iOtrosIngres" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Otros Gastos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento10" tabindex="11" name="gOtrosGas" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Ingresos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control" id="Resultadoingresos" tabindex="11" name="iTotalIng" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total Gastos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control" id="Resultadogastos" tabindex="11" name="gTotalGas" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Activos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control" id="Resultadoactivos" tabindex="11" name="iTotalAct" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Patrimonio:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" cssClass="form-control" id="Resultadopatrimonio" tabindex="11" name="gTotalPat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <s:hidden type="number" cssClass="aux1" id="ingr" tabindex="11" name="codEva" style="text-transform: uppercase;" />
                                                    <s:hidden  type="number" cssClass="aux2" id="gast" tabindex="11" name="codEva" style="text-transform: uppercase;" />

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


                                            <s:submit name="siguienteInfo" value="Siguiente" id = "bSiguiente" cssClass="btn btn-primary btn-flat" />
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


        /* Operaciones de Ingresos mensuales y Gastos mensuales   */
        $("#Resultadoingresos").attr("readonly", "true");
        $("#Resultadogastos").attr("readonly", "true");
        $("#Resultadoactivos").attr("readonly", "true");
        $("#Resultadopatrimonio").attr("readonly", "true");
        var inputgast = $(".gastos")
        var inputingr = $(".ingresos")
        var resultgast = $("#Resultadogastos")
        var resultingr = $("#Resultadoingresos")
        var resultactv = $("#Resultadoactivos")
        var resultpatr = $("#Resultadopatrimonio")
        var resultaux1 = $("#ingr")
        var resultaux2 = $("#gast")
        var inputaux1 = $(".aux1")
        var inputaux2 = $(".aux2")
        $(document).on("keyup", ".ingresos", function () {
            var auxingr = 0
            inputingr.each(function (index, el) {
                auxingr = auxingr + Number($(el).val())
                console.log(auxingr)
            })
            if (!isNaN(auxingr)) {
                resultingr.val(auxingr)
                resultaux1.val(auxingr)
                resultactv.val(auxingr)
            }
            console.log(auxingr)
            $("").val(resultingr)
        })
        $(document).on("keyup", ".gastos", function () {
            var auxgast = 0
            inputgast.each(function (index, el) {
                auxgast = auxgast + Number($(el).val())
                console.log(auxgast)
            })
            if (!isNaN(auxgast)) {
                resultgast.val(auxgast)
                resultaux2.val(auxgast)
                resultpatr.val(Number($(".aux1").val()) - Number($(".aux2").val()))
                console.log(Number($(".aux1").val()) - Number($(".aux2").val()))
            }
            $("").val(resultgast)
        })

        /*
         $("#elemento1").prop('required', true);
         $("#elemento2").prop('required', true);
         $("#elemento3").prop('required', true);
         $("#elemento4").prop('required', true);
         $("#elemento5").prop('required', true);
         $("#elemento6").prop('required', true);
         $("#elemento7").prop('required', true);
         $("#elemento8").prop('required', true);
         $("#elemento9").prop('required', true);
         $("#elemento10").prop('required', true);
         */



        </script>

    </body>
</html>