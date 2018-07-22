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
                    animationEnabled: true,
                    theme: "light2",
                    title: {
                        text: "Asignado vs Visitado vs Recuperado"
                    },
                    axisX: {
                        valueFormatString: "DD MMM"
                    },
                    axisY: {
                        title: "Número de Clientes",
                        suffix: "",
                        minimum: 0
                    },
                    toolTip: {
                        shared: true
                    },
                    legend: {
                        cursor: "pointer",
                        verticalAlign: "bottom",
                        horizontalAlign: "left",
                        dockInsidePlotArea: true,
                        itemclick: toogleDataSeries
                    },
                    data: [{
                            type: "line",
                            showInLegend: true,
                            name: "Asignado",
                            markerType: "square",
                            xValueFormatString: "MMM, YYYY",
                            color: "#F08080",
                            yValueFormatString: "#,##0",
                            dataPoints: [
                                {x: new Date(2017, 10, 1), y: 93},
                                {x: new Date(2017, 11, 1), y: 99},
                                {x: new Date(2018, 0, 1), y: 95},
                                {x: new Date(2018, 1, 1), y: 100},
                                {x: new Date(2018, 2, 1), y: 101},
                                {x: new Date(2018, 3, 2), y: 95},
                                {x: new Date(2018, 4, 1), y: 93},
                                {x: new Date(2018, 5, 1), y: 96},
                                {x: new Date(2018, 6, 1), y: 84}
                            ]
                        },
                        {
                            type: "line",
                            showInLegend: true,
                            name: "Visitados",
                            lineDashType: "dash",
                            yValueFormatString: "#,##0",
                            dataPoints: [
                                {x: new Date(2017, 10, 1), y: 60},
                                {x: new Date(2017, 11, 1), y: 57},
                                {x: new Date(2018, 0, 1), y: 51},
                                {x: new Date(2018, 1, 1), y: 56},
                                {x: new Date(2018, 2, 1), y: 54},
                                {x: new Date(2018, 3, 1), y: 55},
                                {x: new Date(2018, 4, 1), y: 54},
                                {x: new Date(2018, 5, 1), y: 69},
                                {x: new Date(2018, 6, 1), y: 65}
                            ]
                        },
                        {
                            type: "line",
                            showInLegend: true,
                            name: "Recuperado",
                            lineDashType: "dash",
                            yValueFormatString: "#,##0",
                            dataPoints: [
                                {x: new Date(2017, 10, 1), y: 10},
                                {x: new Date(2017, 11, 1), y: 17},
                                {x: new Date(2018, 0, 1), y: 11},
                                {x: new Date(2018, 1, 1), y: 15},
                                {x: new Date(2018, 2, 1), y: 14},
                                {x: new Date(2018, 3, 1), y: 16},
                                {x: new Date(2018, 4, 1), y: 12},
                                {x: new Date(2018, 5, 1), y: 19},
                                {x: new Date(2018, 6, 1), y: 20}
                            ]
                        }]
                };
                $("#chartContainer").CanvasJSChart(options);

                function toogleDataSeries(e) {
                    if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                        e.dataSeries.visible = false;
                    } else {
                        e.dataSeries.visible = true;
                    }
                    e.chart.render();
                }
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Estadísticas Cobranza</h1>
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