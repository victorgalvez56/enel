<%-- 
    Document   : cobranzaProgramacionVisitas
    Created on : 08/06/2018, 11:19:30 AM
    Author     : Yazid1997
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form action="imprimirCartasCobranza" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Imprimir Cartas</h1>                  
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
                                                        <th>#</th>
                                                        <th>Codigo</th>
                                                        <th>Nombre</th>
                                                        <th>Direccion</th>
                                                        <th>Telefonos</th>
                                                        <th>Distrito</th>
                                                        <th>Saldo</th>
                                                        <th>Atraso</th>
                                                        <th>Moneda</th>
                                                        <th>Imprimir</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstAsignados">
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
                                                            <td data-th="#"><s:property value="numero"/></td>
                                                            <td data-th="Código"><s:property value="codCta"/></td>
                                                            <td data-th="Nombre"><s:property value="cliente.nomCom" /></td>
                                                            <td data-th="Direccion"><s:property value="cliente.direccion.direccion" /></td>
                                                            <td data-th="Telefonos"><s:property value="cliente.telefono" />/<s:property value="cliente.celular" /></td>
                                                            <td data-th="Distritos"><s:property value="cliente.direccion.distrito.nombre" /></td>
                                                            <td data-th="Saldo"><s:property value="salCap" /></td>
                                                            <td data-th="Saldo"><s:property value="diaAtr" /></td>
                                                            <td data-th="Moneda"><s:property value="moneda" /></td>
                                                            <td data-th="Imprimir">
                                                                <s:url id="imprimeURL" action="imprimirCartaCobranza">
                                                                    <s:param name="codigo" value="%{codigo}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{imprimeURL}">Imprimir</s:a></td>                                                            
                                                        </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <center>
                                            <s:submit key="Imprimir Todo" cssClass="btn btn-lg btn-success"/>
                                        </center>
                                    </div>
                                </div>

                            </div>





                        </div>



                    </section>

                    <!-- /.content -->
                </s:form>
            </div>

            <!-- /.content-wrapper -->




        </div>

        <!-- ./wrapper -->


    </body>
</html>
