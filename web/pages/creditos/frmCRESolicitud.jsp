<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="../clientes/modCLIBuscarDatos.jsp" %>
<%@include file="modCREBuscar.jsp" %>
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
                                                            <s:textfield cssClass="form-control" id="tfCodCre" name="credito.codCta" readonly="true" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Tipo Doc.:</label>
                                                            <s:select name="cliente.tipDocCiv" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" disabled="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Nombre</label>
                                                            <label>Nro.Doc:</label>
                                                            <s:textfield cssClass="form-control" id="tfNroDoc" name="cliente.nroDocCiv" readonly="true" style="text-transform: uppercase;" maxLength="15"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="form-group">
                                                            <label>Nombre completo:</label>
                                                            <s:textfield cssClass="form-control" style="text-transform: uppercase;" id="tfNomCli" name="cliente.nomCom" readonly="true"/>
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
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Monto Solicitado:</label>
                                                            <s:textfield cssClass="form-control" id="tfMonto" tabindex="1" name="credito.capSol" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Producto:</label>
                                                            <s:select name="credito.producto.codigo" tabindex="2" list="lstProductos" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Nro Cuotas:</label>
                                                            <s:textfield cssClass="form-control" id="tfCuotas" tabindex="3" name="credito.cuotas" onblur="calcula_montoCuota()" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Monto Cuota:</label>
                                                            <s:textfield cssClass="form-control" id="tfMontoCuota" name="credito.cuota" onclick="calcula_montoCuota()" readonly="true" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Dia Pago:</label>
                                                            <s:textfield cssClass="form-control" id="tfDia" tabindex="4" name="credito.diaPag" readonly="true" style="text-transform: uppercase;"/>
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
                                            <s:hidden name="credito.codigo"></s:hidden>
                                            <s:hidden name="cliente.apePat"></s:hidden>
                                            <s:hidden name="cliente.apeMat"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="credito.cliente.codigo"></s:hidden>
                                            <s:hidden name="cliente.codCli" id="tfCodCli" ></s:hidden>
                                            <s:hidden name="estado" id ="estado"></s:hidden>
                                                <!--<button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCli" id="bBuscarCli" hidden="true">Nuevo</button>-->
                                            <s:submit name="grabar" value="Grabar" cssClass="btn btn-primary btn-flat" display="none"/>
                                            <s:submit name="aprobarSol" value="Siguiente" id="bSiguiente" cssClass="btn btn-primary btn-flat"/>
                                            <s:submit name="aplicar" value="Aplicar" id = "bAplicar" cssClass="btn btn-primary btn-flat" style="display: none;"/>
                                            <s:submit name="nombre" value="Nombre" id="bNombre" cssClass="btn btn-primary btn-flat" style="display: none;"/>
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            if (document.getElementById('tfNroDoc').value == '') {
                                $("#modalBuscarCli").modal("show");
                            }
                            frmNombre();
                            botonDeshabilitado();
                        });

                        function calcula_montoCuota() {
                            var CapSol = document.getElementById('tfMonto').value;
                            var Cuotas = document.getElementById('tfCuotas').value;
                            if (Cuotas == '') {
                                $("#tfCuotas").val(0);
                            } else {
                                var MonCuo = CapSol / Cuotas;
                                var num= Math.round(MonCuo * 100) / 100;
                                $("#tfMontoCuota").val(num);
                            }
                        }

                        function frmNombre() {
                            document.getElementById("fBuscar").setAttribute("action", "frmCRESolicitud");
                        }
                        
                        function botonDeshabilitado() {
                            if (document.getElementById("estado").value === "grabada") {
                                document.getElementById("bSiguiente").disabled = false;
                            } else {
                                document.getElementById("bSiguiente").disabled = true;
                            }
                        }
                    </script>
                </section>
            </div>
        </div>

    </body>
</html>
