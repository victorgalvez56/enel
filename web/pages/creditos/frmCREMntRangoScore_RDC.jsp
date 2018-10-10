<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <s:if test="mensaje.length() != 0">
                                <div class="alert alert-success">
                                    <div><span class="glyphicon glyphicon-ok"></span><strong> ¡Correcto!</strong> <s:property value="mensaje"/> </div>
                                </div>
                            </s:if>
                            <s:if test="informacion.length() != 0">
                                <div class="alert alert-info">
                                    <div><span class="glyphicon glyphicon-info-sign"></span><<strong> Información</strong> <s:property value="informacion"/> </div>
                                </div>
                            </s:if>
                            <s:if test="advertencia.length() != 0">
                                <div class="alert alert-warning">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ¡Advertencia!</strong> <s:property value="advertencia"/> </div>
                                </div>
                            </s:if>
                            <s:if test="error.length() != 0">
                                <div class="alert alert-danger">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span> <s:property value="error"/></div>
                                </div>
                            </s:if>
                        </div>
                    </div>
                </div>
                <%--<s:form action="frmCREMntRangoScore" role="form">--%>
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Mantenimiento de Rango - Score</h1>
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
                                                    <div class="nav-tabs-custom">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active"><a href="#bancarizados" data-toggle="tab">Clientes Bancarizados</a></li>
                                                            <li><a  href="#noBancarizados" data-toggle="tab">Clientes no Bancarizados</a></li>
                                                        </ul>
                                                        <div class="tab-content">
                                                            <div class="active tab-pane" id="bancarizados">
                                                                <div class="box-body">
                                                                    <div class="col-md-8 col-md-offset-2">
                                                                        <div class="table-responsive">
                                                                            <table class="table" id="tablaCB">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>Perfil</th>
                                                                                        <th>Puntaje mínimo</th>
                                                                                        <th>Puntaje máximo</th>
                                                                                        <th>Guardar</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody id="tBodyCB">
                                                                                    <s:iterator value="lstRangosCB" status="rowStatus">
                                                                                        <s:if test="true">
                                                                                            <tr style="text-transform: uppercase;" id="paraClonar">
                                                                                        </s:if>
                                                                                            <s:form action="frmCREMntRangoScore_RDC" role="form">
                                                                                                <td><s:textfield name="nombre" cssClass="form-control" /></td>
                                                                                                <td><s:textfield name="minimo" cssClass="form-control" /></td>
                                                                                                <td><s:textfield name="maximo" cssClass="form-control" /></td>
                                                                                                <td data-th="Guardar">
                                                                                                    <%--<s:hidden name="codigo" value="%{codigo}" />--%>
                                                                                                    <s:hidden name="codigo" value="%{#rowStatus.count}" />
                                                                                                    <s:submit name="guardarCB" value="Guardar" cssClass="btn btn-primary btn-sm btn-flat" />
                                                                                                </td>
                                                                                            </s:form>
                                                                                        </tr>
                                                                                    </s:iterator>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-12">
                                                                        <div style="float: right">
                                                                            <s:form action="frmCREMntRangoScore_RDC" role="form">
                                                                                <s:submit value="Nuevo" name="nuevoCB" cssClass="btn btn-primary btn-flat" />
                                                                            </s:form>
                                                                            <!--<button class="btn btn-primary btn-flat" onclick="nuevoCB()">Nuevo</button>-->
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="tab-pane" id="noBancarizados">
                                                                <div class="box-body">
                                                                    <div class="col-md-8 col-md-offset-2">
                                                                        <div class="table-responsive">
                                                                            <table class="table">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>Perfil</th>
                                                                                        <th>Puntaje mínimo</th>
                                                                                        <th>Puntaje máximo</th>
                                                                                        <th>Guardar</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <s:iterator value="lstRangosCNB" status="rowStatus">
                                                                                        <s:if test="true">
                                                                                            <tr style="text-transform: uppercase;">
                                                                                        </s:if>
                                                                                            <s:form action="frmCREMntRangoScore_RDC" role="form">
                                                                                                <td><s:textfield name="nombre" cssClass="form-control" /></td>
                                                                                                <td><s:textfield name="minimo" cssClass="form-control" /></td>
                                                                                                <td><s:textfield name="maximo" cssClass="form-control" /></td>
                                                                                                <td data-th="Guardar">
                                                                                                    <%--<s:hidden name="codigo" value="%{codigo}" />--%>
                                                                                                    <s:hidden name="codigo" value="%{#rowStatus.count}" />
                                                                                                    <s:submit name="guardarCNB" value="Guardar" cssClass="btn btn-primary btn-sm btn-flat" />
                                                                                                </td>
                                                                                            </s:form>
                                                                                        </tr>
                                                                                    </s:iterator>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-12">
                                                                        <div style="float: right">
                                                                            <s:form action="frmCREMntRangoScore_RDC" role="form">
                                                                                <s:submit value="Nuevo" name="nuevoCNB" cssClass="btn btn-primary btn-flat" />
                                                                            </s:form>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
<!--                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit value="Nuevo" name="" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>-->
                            </div>
                        </div>
                    </section>
                <%--</s:form>--%>
            </div>
        </div>
    </body>
    <script>
        function nuevoCB() {
            var row = document.getElementById("paraClonar");
            var tBody = document.getElementById("tBodyCB");
            var clone = row.cloneNode(true);
            tBody.appendChild(clone);
        }
        
        function nueoCNB() {
            
        }
    </script>
</html>
