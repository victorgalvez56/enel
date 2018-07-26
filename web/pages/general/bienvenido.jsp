<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="ch" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="../../js/canvasjs.min.js"></script>
        <script type="text/javascript">
            window.onload = function () {
                var obj = JSON.parse(document.getElementById("datos").value);
                var chart = new CanvasJS.Chart("chartContainer", {
                    data: [
                        {
                            type: "pie",
                            indexLabelFontFamily: "Garamond",
                            indexLabelFontSize: 13,
                            indexLabel: "{label} S/.{y}",
                            showInLegend: true,
                            toolTipContent: "{legendText} S/. {y}",
                            dataPoints: obj
                        }
                    ]
                });

                chart.render();
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Pantalla Principal</h1>
                </section>
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <s:if test="mensaje.length() != 0">
                                        <div class="alert alert-success">
                                            <div class="glyphicon glyphicon-ok"></div>
                                            <div><strong>¡Bienvenido(a)!</strong> <s:property value="mensaje"/> </div>
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
                            <div class="col-lg-12">
                                <center>
                                    <div id="chartContainer" style="height: 500px; width: 50%;"></div>
                                </center>
                            </div>
                            <s:hidden id="datos" name="datos"></s:hidden>
                        </div>
                </section>
            </div>
        </div>
    </body>
</html>