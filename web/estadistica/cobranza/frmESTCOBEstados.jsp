<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="ch" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="js/canvasjs.min.js"></script>
        <script type="text/javascript">
            window.onload = function () {
                var options = {
                    title: {
                        text: "Estado de Cobranza"
                    },
                    data: [{
                            type: "pie",
                            startAngle: 45,
                            showInLegend: "true",
                            legendText: "{label}",
                            indexLabel: "{label} ({y})",
                            yValueFormatString: "#,##0.#" % "",
                            dataPoints: [
                                {label: "Asignados", y: 36},
                                {label: "Programados", y: 31},
                                {label: "No Visitado", y: 7},
                                {label: "Visitar Urgente", y: 7},
                                {label: "Compromiso", y: 6},
                                {label: "Recuperado", y: 10}
                            ]
                        }]
                };
                $("#chartContainer").CanvasJSChart(options);
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Estadísticas Estado</h1>
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
                            <div class="row">
                                <center>
                                    <div id="chartContainer"></div>
                                </center>
                            </div>
                            <s:hidden id="datos" name="datos"></s:hidden>
                        </div>
                </section>
            </div>
        </div>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>                        
    </body>
</html>