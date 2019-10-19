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
                <s:form action="frmSolFinan_DocIndpF" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - DOCUMENTOS INDEPENDIENTE FORMAL</h1>
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

                                                        <input type="file" name="recibodeluz">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Copia de DNI:</label>

                                                        <input type="file" name="copiadni">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>               
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <label class="control-label">Copia de RUC:</label>
                                                        <input type="file" name="recibodeluz">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Extractos bancarios de los últimos tres meses:</label>
                                                        <input type="file" name="copiadni">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <label class="control-label">Extracto de la AFP:</label>
                                                        <input type="file" name="afp">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Si tienes ingresos adicionales por alquileres incluir copia del contrado de arrendamiento:</label>
                                                        <input type="file" name="contratoarren">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
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