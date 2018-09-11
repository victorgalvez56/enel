<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCREAsignarVenta.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onloadCli()">
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
                                    <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <span id="info"><s:property value="informacion"/></span> </div>
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
                <!-- Content header -->
                <section class="content-header">
                    <h1>Mantenedor de Créditos</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCREMantenedor" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>FILTROS DE BUSQUEDA:</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. solicitud:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCta" tabindex="1" name="credito.codCta" style="text-transform: uppercase;" onchange="verCambio()" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. suministro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfSumini" tabindex="2" name="credito.cliente.sumini" maxLength="7" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Cod. cliente:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="3" name="credito.cliente.codCli" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:select name="credito.cliente.tipDocCiv" tabindex="7" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="codciv" name="credito.cliente.nroDocCiv" tabindex="4" maxLength="15" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nro. Solicitud</th>
                                                    <th>Cod. Cliente</th>
                                                    <th>Suministro</th>
                                                    <th>Ape. Paterno</th>
                                                    <th>Ape. Materno</th>
                                                    <th>Nombre(s)</th>
                                                    <th>Tipo documento</th>
                                                    <th>Nro. documento</th>
                                                    <th>Fecha de solicitud</th>
                                                    <th>Seleccionar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="lstCreditos" status="rowStatus">
                                                    <tr style="text-transform: uppercase;">
                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                        <td><s:property value="codCta" /></td>
                                                        <td><s:property value="cliente.codCli" /></td>
                                                        <td><s:property value="cliente.sumini" /></td>
                                                        <td><s:property value="cliente.apePat" /></td>
                                                        <td><s:property value="cliente.apeMat" /></td>
                                                        <td><s:property value="cliente.nombre" /></td>
                                                        <td><s:property value="cliente.tipDocCiv" /></td>
                                                        <td><s:property value="cliente.nroDocCiv" /></td>
                                                        <td><s:property value="fecSol" /></td>
                                                        <td><center><input type="checkbox" onclick="creSeleccionado('<s:property value="codCta"/>')"></center></td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table><br>
                                    </div>          
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="credito.codigo"></s:hidden>
                                            <s:submit name="buscar" value="Buscar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalAsignarVenta" id="bAsignar">Asignar # de venta</button>
                                            <s:submit name="rechazar" value="Rechazar" id="bRechazar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="exportar" value="Exportar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
           botonHabilitado(); 
        });
        
        function creSeleccionado(codigo) {
            document.getElementById("tfCodCta").value = codigo;
            document.getElementById("tfCodCre").value = codigo;
            //document.getElementById("tfCodCli").removeAttribute("name");
            botonHabilitado();
        }
        
        function botonHabilitado() {
            CodCre = document.getElementById("tfCodCre").value;
            if (CodCre === "") {
                document.getElementById("bRechazar").disabled = true;
                document.getElementById("bAsignar").disabled = true;
            } else {
                document.getElementById("bRechazar").disabled = false;
                document.getElementById("bAsignar").disabled = false;
            }
        }
        
        function verCambio() {
            CodCta = document.getElementById("tfCodCta").value;
            CodCre = document.getElementById("tfCodCre").value;
            if (CodCta === "") {
                document.getElementById("bRechazar").disabled = true;
            } else if (CodCta !== "" && CodCre !== "") {
                document.getElementById("bRechazar").disabled = false;
            }
        }
    </script>    
</html>
