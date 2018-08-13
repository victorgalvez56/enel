<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCRERechazarSolici.jsp" %>
<%@include file="../clientes/modCLIBuscarDatos.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Solicitud</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCRESolicitud" role="form">

                                <div class="row">
                                    <div class="col-lg-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div><span class="glyphicon glyphicon-ok"></span><strong> Mensaje: </strong> <s:property value="mensaje"/> </div>
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
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Solicitud:</label>
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="1" name="credito.codCta" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Tipo Doc.</label>
=======
                                                            <label>Tipo Doc.:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:select name="cliente.tipDocCiv" tabindex="2" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                        <div class="form-group">
                                                            <label>Nro.Doc</label>
                                                            <s:textfield cssClass="form-control" id="tfNroDoc" tabindex="3" name="cliente.nroDocCiv" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
=======
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Nombre</label>
=======
                                                            <label>Nro.Doc:</label>
                                                            <s:textfield cssClass="form-control" id="tfNroDoc" tabindex="3" name="cliente.nroDocCiv" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">
                                                            <label>Nombre completo:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:textfield cssClass="form-control" id="tfNomCli" tabindex="4" name="credito.cliente.nomCom" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header">
                                                <h3 class="box-title">Datos Solicitud:</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Monto Solicitado</label>
=======
                                                            <label>Monto Solicitado:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:textfield cssClass="form-control" id="tfMonto" tabindex="5" name="credito.capSol" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Producto</label>
=======
                                                            <label>Producto:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:select name="credito.producto.codigo" tabindex="6" list="lstProductos" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Nro Cuotas</label>
=======
                                                            <label>Nro Cuotas:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:textfield cssClass="form-control" id="tfCuotas" tabindex="7" name="credito.cuotas" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
<<<<<<< HEAD (d7c055b) - Mantenedor de clientes
                                                            <label>Fecha vencimiento</label>
                                                            <s:textfield cssClass="form-control" id="tfDia" tabindex="9" name="credito.diaPag" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3"></div>
                                                    <div class="col-md-3"></div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Monto Cuota</label>
=======
                                                            <label>Fecha vencimiento:</label>
                                                            <s:textfield cssClass="form-control" id="tfDia" tabindex="9" name="credito.diaPag" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3"></div>
                                                    <div class="col-md-3"></div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Monto Cuota:</label>
>>>>>>> origin/master (0bddad1) - buscar cliente
                                                            <s:textfield cssClass="form-control" id="tfMontoCuota" tabindex="8" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit name="grabar" value="Grabar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="actualizar" value="Actualizar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalRechazarSolici" id="">Rechazar</button>
                                            <s:submit name="desistir" value="Desistir" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                                <s:hidden name="credito.codigo"></s:hidden>
                                <s:hidden name="credito.cliente.apePat"></s:hidden>
                                <s:hidden name="credito.cliente.apeMat"></s:hidden>
                                <s:hidden name="credito.cliente.nombre"></s:hidden>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
