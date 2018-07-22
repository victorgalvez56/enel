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
                var limit = 12;    //increase number of dataPoints by increasing the limit
                var y = 100;
                var data = [];
                var dataSeries = {type: "line"};
                var dataPoints = [];
                dataPoints.push({
                    x: 1,
                    y: 12500
                });
                dataPoints.push({
                    x: 2,
                    y: 13400
                });
                dataPoints.push({
                    x: 3,
                    y: 5800
                });
                dataPoints.push({
                    x: 4,
                    y: 6700
                });
                dataPoints.push({
                    x: 5,
                    y: 8900
                });
                dataPoints.push({
                    x: 6,
                    y: 7500
                });
                dataPoints.push({
                    x: 7,
                    y: 12300
                });
                dataPoints.push({
                    x: 8,
                    y: 12000
                });
                dataPoints.push({
                    x: 9,
                    y: 10900
                });
                dataPoints.push({
                    x: 10,
                    y: 13900
                });
                dataPoints.push({
                    x: 11,
                    y: 9800
                });
                dataPoints.push({
                    x: 12,
                    y: 12300
                });
                dataSeries.dataPoints = dataPoints;
                data.push(dataSeries);

//Better to construct options first and then pass it as a parameter
                var options = {
                    zoomEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: "Recuperación"
                    },
                    axisY: {
                        includeZero: false
                    },
                    data: data  // random data
                };

                $("#chartContainer").CanvasJSChart(options);
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Estadísticas</h1>
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