<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCREBuscar.jsp" %>
<%@include file="modCREPlanPagos.jsp" %>
<%@include file="modCRERechazarSolici.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Aprobacion de Crédito</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCREAprobacion" role="form">                            
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
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="1" name="credito.codCta" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Código Cliente</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="2" name="credito.cliente.codCli" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1" align="right">
                                                        <div class="form-group">
                                                            <label class="control-label">Nombre</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" style="text-transform: uppercase;" id="tfNomCli" tabindex="3" name="credito.cliente.nomCom" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label class="control-label">Analista</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-11">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfNomAna" tabindex="4" name="credito.nomAna" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <button type="button" class="btn btn-primary btn-flat" onclick="fecha_actual()">Evaluar Score</button>
                                                        <s:submit name="evaluar" value="Evaluar Score" id = "bEvaluar"  cssClass="btn btn-primary btn-flat"  style="display: none;"/>
                                                    </div>
                                                    <div class="col-md-1" align="right">
                                                        <div class="form-group">
                                                            <label class="control-label">Resultado ENEL</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfResultadoENEL" tabindex="5" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1" align="right">
                                                        <div class="form-group">
                                                            <label class="control-label">Resultado SENTINEL</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfResultadoSENTINEL" tabindex="5" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group" align="right">
                                                            <label class="control-label">Fecha Evaluación</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfFechaEvaluacion" tabindex="6" readonly="true"/>
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
                                            <div class="box-header with-border">
                                                <h3 class="box-title">DATOS APROBADOS</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label class="control-label">Monto Solicitado</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfMonSol" tabindex="7" name="credito.capSol" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. de Cuotas Solicitada</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfMonSol" tabindex="8" name="credito.cuotas" readonly="true"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Monto Cuota Solicitada</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfMonCuo" tabindex="9" name="credito.cuota" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Monto Cuota Aprobada</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfMonApr" tabindex="10" name="credito.cuotaAprobada" onblur="boton_habilitado()" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">        
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Producto</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield name="credito.producto.nombre" tabindex="11"  cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>                                                        
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Comentarios</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <div class="form-group">
                                                            <s:textarea cssClass="form-control" style="text-transform: uppercase;" id="tfComent" tabindex="12" name="comentario" />
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
                                            <!--<button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscarCre">Buscar</button>-->
                                            <s:submit name="aplicar" value="Aplicar" cssClass="btn btn-primary btn-flat" style="display: none;"/>
                                            <s:submit name="enviar" value="Enviar para Aprobación" id = "bEnviar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="aprobar" value="Aprobar" id = "bAprobar" onclick="campo_requerido()" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="rechazar" value="Rechazar" id = "bRechazar" cssClass="btn btn-primary btn-flat" />
                                            <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalPlanPagos" id="bBuscarCre">Generar Plan de Pagos</button>
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
        <script>
            $(document).ready(function () {
                document.getElementById("tfComent").required = true;
                boton_habilitado();
            });
            function boton_habilitado(){
                var monto = Number(document.getElementById("tfMonSol").value);
                var MonApr = Number(document.getElementById("tfMonApr").value);
                var MonCuo = Number(document.getElementById("tfMonCuo").value);
                if (monto <= 2000){
                    if(MonCuo <= MonApr){
                        document.getElementById("bEnviar").disabled = true;
                        document.getElementById("bAprobar").disabled = false; 
                    } else{
                       document.getElementById("bAprobar").disabled = true;
                       document.getElementById("bEnviar").disabled = false;
                    }
                }else{
                    document.getElementById("bEnviar").disabled = true;
                    document.getElementById("bAprobar").disabled = false;
                }
            }
    
            function frmRechazarSolici() {
                document.getElementById("fRechazar").setAttribute("action", "frmCREAprobacion");
            }
            
            function fecha_actual(){
                var f = new Date();
                $("#tfFechaEvaluacion").val(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
                $("#tfResultadoENEL").val("APROBADO");
                $("#tfResultadoSENTINEL").val("APROBADO");
            }
            function campo_requerido(){
                document.getElementById("tfComent").required = false;
                $("#tfComent").val("*");
            }
        </script>
    </body>
</html>