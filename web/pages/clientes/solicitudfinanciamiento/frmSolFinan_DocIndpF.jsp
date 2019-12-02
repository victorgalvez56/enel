<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <s:if test="mensaje.length() != 0">
                            <div class="alert alert-success">
                                <div class="glyphicon glyphicon-ok"></div>
                                <div><strong>¡Correcto!</strong> <s:property value="mensaje"/> </div>
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
                <s:form action="frmSolFinan_DocIndpF" enctype="multipart/form-data" method="post">

                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - DOCUMENTOS INDEPENDIENTE FORMAL</h1>
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
                                                    <div class="col-md-6">
                                                        <label class="control-label">Subir último recibo de luz:</label>

                                                        <s:file name="archivoIFRecibLuz" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Copia de DNI:</label>

                                                        <s:file name="archivoIFCopiaDni" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>               
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <label class="control-label">Copia de RUC:</label>
                                                        <s:file name="archivoIFCopiaRuc" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Extractos bancarios de los últimos tres meses:</label>
                                                        <s:file name="archivoIFExtracb1" cssClass="form-control"/>
                                                        <s:file name="archivoIFExtracb2" cssClass="form-control"/>
                                                        <s:file name="archivoIFExtracb3" cssClass="form-control"/>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <label class="control-label">Extracto de la AFP:</label>
                                                        <s:file name="archivoIFExtracafp" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="control-label">Si tienes ingresos adicionales por alquileres incluir copia del contrado de arrendamiento:</label>
                                                        <s:file name="archivoIFIngadic" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="codEvaluador"></s:hidden>
                                            <s:hidden name="puntVenta"></s:hidden>
                                            <s:hidden name="fecSolicitud"></s:hidden>
                                            <s:hidden name="cliente.TipDocCiv"></s:hidden>
                                            <s:hidden name="cliente.NroDocCiv"></s:hidden>
                                            <s:hidden name="ciudadExp"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.SegundoNo"></s:hidden>
                                            <s:hidden name="cliente.ApePat"></s:hidden>
                                            <s:hidden name="cliente.ApeMat"></s:hidden>
                                            <s:hidden name="nacionalidad"></s:hidden>
                                            <s:hidden name="cliente.FecNac"></s:hidden>
                                            <s:hidden name="ciudadNac"></s:hidden>
                                            <s:hidden name="paisNac"></s:hidden>
                                            <s:hidden name="cliente.sexo"></s:hidden>
                                            <s:hidden name="cliente.EstCiv"></s:hidden>
                                            <s:hidden name="cliente.NivIns"></s:hidden>
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="nperDepend"></s:hidden>
                                            <s:hidden name="cliente.Correo"></s:hidden>
                                            <s:hidden name="cliente.Telefono"></s:hidden>
                                                <!Cónyuge-->
                                            <s:hidden name="cprimerNomb"></s:hidden>
                                            <s:hidden name="csegundNomb"></s:hidden>
                                            <s:hidden name="cprimerApel"></s:hidden>
                                            <s:hidden name="csegundApel"></s:hidden>
                                            <s:hidden name="cempdondTrab"></s:hidden>
                                            <s:hidden name="cempCargo"></s:hidden>
                                            <s:hidden name="cempTelef"></s:hidden>
                                                <!Vivienda>
                                            <s:hidden name="vsuministro"></s:hidden>
                                            <s:hidden name="vtitularSum"></s:hidden>
                                            <s:hidden name="vrelacTitul"></s:hidden>
                                            <s:hidden name="vtipoVivien"></s:hidden>
                                            <s:hidden name="vhaceCVivea"></s:hidden>
                                            <s:hidden name="vdireccResi"></s:hidden>
                                            <s:hidden name="vdistVivien"></s:hidden>
                                            <s:hidden name="vprovVivien"></s:hidden>
                                            <s:hidden name="vdepaVivien"></s:hidden>
                                                <!Empleado-->
                                            <s:hidden name="enombreEmpr"></s:hidden>
                                            <s:hidden name="erUCEmpr"></s:hidden>
                                            <s:hidden name="eactivdEmpr"></s:hidden>
                                            <s:hidden name="edirEmpr"></s:hidden>
                                            <s:hidden name="edepEmpr"></s:hidden>
                                            <s:hidden name="edisEmpr"></s:hidden>
                                            <s:hidden name="eprovEmpr"></s:hidden>
                                                <!Independiente-->
                                            <s:hidden name="ilabor"></s:hidden>
                                            <s:hidden name="ihacecuantInd"></s:hidden>
                                            <s:hidden name="itipodeInd"></s:hidden>
                                            <s:hidden name="fnombEmpr"></s:hidden>
                                            <s:hidden name="frucEmpr"></s:hidden>
                                            <s:hidden name="fcargo"></s:hidden>
                                            <s:hidden name="fdirLabo"></s:hidden> 
                                            <s:hidden name="fdisLabo"></s:hidden>
                                            <s:hidden name="fproLabo"></s:hidden>
                                            <s:hidden name="fdepLabo"></s:hidden>
                                            <s:hidden name="ftelef"></s:hidden>
                                            <s:hidden name="fanexo"></s:hidden>
                                                <!Jubilado-->
                                            <s:hidden name="jnombEmpJ"></s:hidden>
                                            <s:hidden name="jnombEmpA"></s:hidden>
                                            <s:hidden name="jhacecuaJ"></s:hidden>  
                                            <s:hidden name="tipoIndep"></s:hidden>
                                                <!Información Financiera-->
                                            <s:hidden name="isueldBas"></s:hidden>
                                            <s:hidden name="galquiler"></s:hidden>
                                            <s:hidden name="icomisiones"></s:hidden>
                                            <s:hidden name="gcreditoViv"></s:hidden>
                                            <s:hidden name="ihonorarios"></s:hidden>
                                            <s:hidden name="ggastosFamil"></s:hidden>
                                            <s:hidden name="ialquileres"></s:hidden> 
                                            <s:hidden name="gtarjetasCred"></s:hidden>
                                            <s:hidden name="iotrosIngres"></s:hidden>
                                            <s:hidden name="gotrosGas"></s:hidden>
                                            <s:hidden name="itotalIng"></s:hidden>
                                            <s:hidden name="gtotalGas"></s:hidden>
                                            <s:hidden name="itotalAct"></s:hidden>
                                            <s:hidden name="gtotalPat"></s:hidden>  
                                                <!Ref Personales-->
                                            <s:hidden name="rpprimerNomb"></s:hidden>
                                            <s:hidden name="rpsegundoNomb"></s:hidden>
                                            <s:hidden name="rpprimerApell"></s:hidden>
                                            <s:hidden name="rpsegundoApell"></s:hidden>      
                                            <s:hidden name="rpdirec"></s:hidden>
                                            <s:hidden name="rpdistr"></s:hidden>
                                            <s:hidden name="rpprovi"></s:hidden>
                                            <s:hidden name="rpestad"></s:hidden>      
                                            <s:hidden name="rptelef"></s:hidden>
                                            <s:hidden name="rpcelul"></s:hidden>
                                            <s:hidden name="rpparen"></s:hidden>      
                                                <!Ref Familiares-->
                                            <s:hidden name="rfprimerNomb"></s:hidden>
                                            <s:hidden name="rfsegundoNomb"></s:hidden>
                                            <s:hidden name="rfprimerApell"></s:hidden>
                                            <s:hidden name="rfsegundoApell"></s:hidden>      
                                            <s:hidden name="rfdirec"></s:hidden>
                                            <s:hidden name="rfdistr"></s:hidden>
                                            <s:hidden name="rfprovi"></s:hidden>
                                            <s:hidden name="rfestad"></s:hidden>      
                                            <s:hidden name="rftelef"></s:hidden>
                                            <s:hidden name="rfcelul"></s:hidden>
                                            <s:hidden name="rfparen"></s:hidden> 
                                                <!Ref Laborales-->
                                            <s:hidden name="rlcNombre"></s:hidden>
                                            <s:hidden name="rlcActividad"></s:hidden>
                                            <s:hidden name="rlcTelef"></s:hidden>
                                            <s:hidden name="rlcDireClient"></s:hidden>      
                                            <s:hidden name="rlcDistrito"></s:hidden>
                                            <s:hidden name="rlcProvincia"></s:hidden>
                                            <s:hidden name="rlcEstado"></s:hidden>
                                            <s:hidden name="rlpNombre"></s:hidden>      
                                            <s:hidden name="rlpActividad"></s:hidden>
                                            <s:hidden name="rlpTelef"></s:hidden>
                                            <s:hidden name="rlpDire"></s:hidden> 
                                            <s:hidden name="rlpDistrito"></s:hidden>
                                            <s:hidden name="rlpProvincia"></s:hidden>
                                            <s:hidden name="rlpEstado"></s:hidden> 
                                            <s:submit name="reporte" value="Guardar" id = "bReporte" cssClass="btn btn-primary btn-flat" />
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </s:form>
            </div>
        </div>
        <script src="/enel/bower_components/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="/enel/js/script.js"></script>        
        <script type="text/javascript" src="/enel/js/main.js"></script>
        <!-- iCheck -->
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>

    </body>
</html>