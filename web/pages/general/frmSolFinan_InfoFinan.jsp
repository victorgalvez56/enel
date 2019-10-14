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
                                                            <s:textfield type="number"  cssClass="form-control ingresos" id="elemento1" tabindex="11" name="iSueldBas" style="text-transform: uppercase;" />
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
                                                            <s:textfield type="number" cssClass="form-control gastos" id="elemento4" tabindex="11" name="gCréditoViv" style="text-transform: uppercase;" />
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
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="cliente.Sexo"></s:hidden>
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
        resultgast.val(0)
        resultingr.val(0)
        resultactv.val(0)
        resultpatr.val(0)
        resultaux1.val(0)
        resultaux2.val(0)
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
        /*----------------------------------------------*/
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