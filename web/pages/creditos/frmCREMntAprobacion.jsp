<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Mantenedor de Aprobaciones de Desembolso Pendientes</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCREMntAprobacion" role="form">                            
                                <div class="row">
                                    <div class="col-lg-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div><span class="glyphicon glyphicon-ok"></span><strong> Mensaje:</strong> <s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <s:property value="informacion"/> </div>
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

                                <div class="row">                                
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro.Solicitud</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCta" tabindex="1" name="credito.codCta" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo Doc.</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="credito.cliente.tipDocCiv" tabindex="2" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">                                                        
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro.Doc</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNroDoc" tabindex="3" name="credito.cliente.nroDocCiv" />
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
                                                                    <tr>
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
                                                <div class="col-md-12">
                                                    <div class="col-md-12">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Comentarios</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-11">
                                                            <div class="form-group">
                                                                <s:textarea cssClass="form-control" id="tfComent" tabindex="4" name="comentario"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                                                <s:hidden name="credito.codigo"></s:hidden>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <!--<button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre">Buscar</button>-->
                                            <s:submit name="buscar" value="Buscar" id = "bBuscar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="aprobar" value="Aprobar" id = "bAprobar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="rechazar" value="Rechazar" id = "bRechazar" cssClass="btn btn-primary btn-flat" />
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
        function creSeleccionado(codigo) {
            document.getElementById("tfCodCta").value = codigo;
            //document.getElementById("tfCodCli").removeAttribute("name");
        }
    </script>    
</html>