<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
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

                <s:form action="frmSolFinan_DocEmple" enctype="multipart/form-data" method="post">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - DOCUMENTOS EMPLEADO</h1>
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
                                                        <label class="control-label">Subir último recibo de luz:</label>

                                                        <s:file name="archivoEmpleadoRecibo" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Copia de DNI:</label>

                                                        <s:file name="archivoEmpleadoCopiaDNI" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <label class="control-label">Boletas de nómina de los últimos tres meses:</label>
                                                        <s:file name="archivoEmpleadobol1" cssClass="form-control"/>
                                                        <s:file name="archivoEmpleadobol2" cssClass="form-control"/>
                                                        <s:file name="archivoEmpleadobol3" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Si tiene ingresos adicionales por alquileres incluir copia del contrato de arrendamiento:</label>
                                                        <s:file name="archivoEmpleadoingadic" cssClass="form-control"/>
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
                                                <!Empleado-->
                                            <s:hidden name="eNombreEmpr"></s:hidden>
                                            <s:hidden name="eRUCEmpr"></s:hidden>
                                            <s:hidden name="eActivdEmpr"></s:hidden>
                                            <s:hidden name="eDirEmpr"></s:hidden>
                                            <s:hidden name="eDepEmpr"></s:hidden>
                                            <s:hidden name="eDisEmpr"></s:hidden>
                                            <s:hidden name="eProvEmpr"></s:hidden>
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
                                                <!Ref Familiares-->
                                            <s:hidden name="rFPrimerNomb"></s:hidden>
                                            <s:hidden name="rFSegundoNomb"></s:hidden>
                                            <s:hidden name="rFPrimerApell"></s:hidden>
                                            <s:hidden name="rFSegundoApell"></s:hidden>      
                                            <s:hidden name="rFDirec"></s:hidden>
                                            <s:hidden name="rFDistr"></s:hidden>
                                            <s:hidden name="rFProvi"></s:hidden>
                                            <s:hidden name="rFEstad"></s:hidden>      
                                            <s:hidden name="rFTelef"></s:hidden>
                                            <s:hidden name="rFCelul"></s:hidden>
                                            <s:hidden name="rFParen"></s:hidden> 
                                                <!Ref Laborales-->
                                            <s:hidden name="rLCNombre"></s:hidden>
                                            <s:hidden name="rLCActividad"></s:hidden>
                                            <s:hidden name="rLCTelef"></s:hidden>
                                            <s:hidden name="rLCDireClient"></s:hidden>      
                                            <s:hidden name="rLCDistrito"></s:hidden>
                                            <s:hidden name="rLCProvincia"></s:hidden>
                                            <s:hidden name="rLCEstado"></s:hidden>
                                            <s:hidden name="rLPNombre"></s:hidden>      
                                            <s:hidden name="rLPActividad"></s:hidden>
                                            <s:hidden name="rLPTelef"></s:hidden>
                                            <s:hidden name="rLPDire"></s:hidden> 
                                            <s:hidden name="rLPDistrito"></s:hidden>
                                            <s:hidden name="rLPProvincia"></s:hidden>
                                            <s:hidden name="rLPEstado"></s:hidden> 



                                            <s:submit name="reporte" value="Guardar" id = "bReporte" cssClass="btn btn-primary btn-flat" />
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
        $("#Resultadoingresos").attr("disabled", "true");
        $("#Resultadogastos").attr("disabled", "true");
        $("#Resultadoactivos").attr("disabled", "true");
        $("#Resultadopatrimonio").attr("disabled", "true");



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










        </script>

    </body>
</html>