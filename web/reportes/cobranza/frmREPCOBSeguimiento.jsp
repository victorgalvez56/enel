<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Seguimiento de Cobranza</h1>                  
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div class="glyphicon glyphicon-ok"></div>
                                                <div><s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div class="glyphicon glyphicon-info-sign"></div>
                                                <div><s:property value="informacion"/> </div>
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
                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Gestor</th>
                                                        <th>Asignados</th>
                                                        <th>Programados</th>
                                                        <th>Visitados</th>
                                                        <th>Compromisos</th>
                                                        <th>Cumplidos</th>
                                                        <th>Saldo Asignados</th>
                                                        <th>Saldo Programados</th>
                                                        <th>Saldo Visitados</th>
                                                        <th>Saldo Compromiso</th>
                                                        <th>Saldo Cumplimiento</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstCobranza">
                                                        <s:if test="%{estado.substring(0, 1).indexOf('A') > -1}">
                                                            <tr>                                                            
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('B') > -1}">
                                                            <tr style="background: #00E466">
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('C') > -1}">
                                                            <tr style="background: #FF0">
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('D') > -1}">
                                                            <tr style="background: #D81B60">
                                                            </s:if>
                                                            <td data-th="Gestor"><s:property value="nomAna"/></td>
                                                            <td data-th="Asignados"><s:property value="nroAsi"/></td>
                                                            <td data-th="Programados"><s:property value="nroPro" /></td>
                                                            <td data-th="Visitados"><s:property value="nroVis" /></td>
                                                            <td data-th="Compromisos"><s:property value="nroCom" /></td>
                                                            <td data-th="Cumplidos"><s:property value="nroCum" /></td>
                                                            <td data-th="Saldo Asignados"><s:property value="salAsi"/></td>
                                                            <td data-th="Saldo Programados"><s:property value="salPro" /></td>
                                                            <td data-th="Saldo Visitados"><s:property value="salVis" /></td>
                                                            <td data-th="Saldo Compromisos"><s:property value="salCom" /></td>
                                                            <td data-th="Saldo Cumplidos"><s:property value="salCum" /></td>
                                                        </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>