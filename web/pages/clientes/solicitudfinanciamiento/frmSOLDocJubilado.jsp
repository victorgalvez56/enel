<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
                <s:form action="frmSOLDocJubilado" enctype="multipart/form-data" method="post">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - DOCUMENTOS JUBILADO</h1>
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
                                                    <div class="col-md-4">
                                                        <label class="control-label">Subir último recibo de luz:</label>

                                                        <s:file name="archivoSolFinan_JubiladoRecibo" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <label class="control-label">Copia de DNI:</label>

                                                        <s:file name="archivoSolFinan_JubiladoCopiaDni" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <label class="control-label">Tres últimas boletas de pago de la mesada pensional:</label>
                                                        <s:file name="archivoSolFinan_JubiladoBoleta1" cssClass="form-control"/>
                                                        <s:file name="archivoSolFinan_JubiladoBoleta2" cssClass="form-control"/>
                                                        <s:file name="archivoSolFinan_JubiladoBoleta3" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <label class="control-label">Extractos bancarios de los últimos 3 meses:</label>
                                                        <s:file name="archivoSolFinan_JubiladoExtracBanc1" cssClass="form-control"/>
                                                        <s:file name="archivoSolFinan_JubiladoExtracBanc2" cssClass="form-control"/>
                                                        <s:file name="archivoSolFinan_JubiladoExtracBanc3" cssClass="form-control"/>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <label class="control-label">Si tiene ingresos adicionales por alquileres incluir copia del contrato de arrendamiento:</label>
                                                        <s:file name="archivoSolFinan_JubiladoCopiaArrendamiento" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="solCLIcodEvaluador"></s:hidden>
                                            <s:hidden name="solCLIpuntVenta"></s:hidden>
                                            <s:hidden name="solCLIfecSolicitud"></s:hidden>
                                            <s:hidden name="cliente.TipDocCiv"></s:hidden>
                                            <s:hidden name="cliente.NroDocCiv"></s:hidden>
                                            <s:hidden name="solCLIciudadExp"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.SegundoNo"></s:hidden>
                                            <s:hidden name="cliente.ApePat"></s:hidden>
                                            <s:hidden name="cliente.ApeMat"></s:hidden>
                                            <s:hidden name="solCLInacionalidad"></s:hidden>
                                            <s:hidden name="cliente.FecNac"></s:hidden>
                                            <s:hidden name="solCLIciudadNac"></s:hidden>
                                            <s:hidden name="solCLIpaisNac"></s:hidden>
                                            <s:hidden name="cliente.sexo"></s:hidden>
                                            <s:hidden name="cliente.EstCiv"></s:hidden>
                                            <s:hidden name="cliente.NivIns"></s:hidden>
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="solCLInperDepend"></s:hidden>
                                            <s:hidden name="cliente.Correo"></s:hidden>
                                            <s:hidden name="cliente.Telefono"></s:hidden>
                                                <!Cónyuge-->
                                            <s:hidden name="solCLI_conyugPrimerNomb"></s:hidden>
                                            <s:hidden name="solCLI_conyugSegundoNomb"></s:hidden>
                                            <s:hidden name="solCLI_conyugPrimerApel"></s:hidden>
                                            <s:hidden name="solCLI_conyugSegundoApel"></s:hidden>
                                            <s:hidden name="solCLI_conyugEmpresaTrab"></s:hidden>
                                            <s:hidden name="solCLI_conyugEmpresaCarg"></s:hidden>
                                            <s:hidden name="solCLI_conyugEmpresaTele"></s:hidden>
                                                <!Vivienda>
                                            <s:hidden name="solCLI_vivienSuministro"></s:hidden>
                                            <s:hidden name="solCLI_vivienTitularSuminis"></s:hidden>
                                            <s:hidden name="solCLI_vivienRelacionTitu"></s:hidden>
                                            <s:hidden name="solCLI_vivienTipo"></s:hidden>
                                            <s:hidden name="solCLI_vivienTiempo"></s:hidden>
                                            <s:hidden name="solCLI_vivienDireccion"></s:hidden>
                                            <s:hidden name="solCLI_vivienDistrito"></s:hidden>
                                            <s:hidden name="solCLI_vivienProvincia"></s:hidden>
                                            <s:hidden name="solCLI_vivienDepartamento"></s:hidden>
                                                <!Empleado-->
                                            <s:hidden name="solCLI_empleadEmpresaNomb"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaRuc"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaActi"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaDire"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaDepa"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaDist"></s:hidden>
                                            <s:hidden name="solCLI_empleadEmpresaProv"></s:hidden>
                                                <!Independiente-->
                                            <s:hidden name="solCLI_independILabor"></s:hidden>
                                            <s:hidden name="solCLI_independITiempoViv"></s:hidden>
                                            <s:hidden name="solCLI_independITipo"></s:hidden>
                                            <s:hidden name="solCLI_independFEmpresaNomb"></s:hidden>
                                            <s:hidden name="solCLI_independFEmpresaRuc"></s:hidden>
                                            <s:hidden name="solCLI_independFCargo"></s:hidden>
                                            <s:hidden name="solCLI_independFLaboraDire"></s:hidden> 
                                            <s:hidden name="solCLI_independFLaboraDist"></s:hidden>
                                            <s:hidden name="solCLI_independFLaboraProv"></s:hidden>
                                            <s:hidden name="solCLI_independFLaboraDepa"></s:hidden>
                                            <s:hidden name="solCLI_independFTelefono"></s:hidden>
                                            <s:hidden name="solCLI_independFAnexo"></s:hidden>
                                            <s:hidden name="solCLI_independFCorreo"></s:hidden>
                                                <!Jubilado-->
                                            <s:hidden name="solCLI_jubilEmpresaNombJubi"></s:hidden>
                                            <s:hidden name="solCLI_jubilEmpresaNombApor"></s:hidden>
                                            <s:hidden name="solCLI_jubilEmpresaTiempo"></s:hidden>  
                                            <s:hidden name="solCLI_independITipoaux"></s:hidden>
                                                <!Información Financiera-->
                                            <s:hidden name="solCLI_infofinanIngSueldoBasic"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngComisiones"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngHonorarios"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngAlquileres"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngOtros"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngTotal"></s:hidden>
                                            <s:hidden name="solCLI_infofinanIngTotalAct"></s:hidden> 
                                            <s:hidden name="solCLI_infofinanGasAlquiler"></s:hidden>
                                            <s:hidden name="solCLI_infofinanGasCreditoViv"></s:hidden>
                                            <s:hidden name="solCLI_infofinanGasFamiliar"></s:hidden>
                                            <s:hidden name="solCLI_infofinanGasTarjetasCred"></s:hidden>
                                            <s:hidden name="solCLI_infofinanGasOtros"></s:hidden>
                                            <s:hidden name="solCLI_infofinanGasTotal"></s:hidden>
                                            <s:hidden name=""></s:hidden>  
                                                <!Ref Personales-->
                                            <s:hidden name="solCLI_refepersonPrimerNomb"></s:hidden>
                                            <s:hidden name="solCLI_refepersonSegundoNomb"></s:hidden>
                                            <s:hidden name="solCLI_refepersonPrimerApel"></s:hidden>
                                            <s:hidden name="solCLI_refepersonSegundoApel"></s:hidden>      
                                            <s:hidden name="solCLI_refepersonDireccion"></s:hidden>
                                            <s:hidden name="solCLI_refepersonDistrito"></s:hidden>
                                            <s:hidden name="solCLI_refepersonProvincia"></s:hidden>
                                            <s:hidden name="solCLI_refepersonEstado"></s:hidden>      
                                            <s:hidden name="solCLI_refepersonTelefono"></s:hidden>
                                            <s:hidden name="solCLI_refepersonCelular"></s:hidden>
                                            <s:hidden name="solCLI_refepersonParentesco"></s:hidden>      
                                                <!Ref Familiares-->
                                            <s:hidden name="solCLI_refefamiliPrimerNomb"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliSegundoNomb"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliPrimerApel"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliSegundoApel"></s:hidden>      
                                            <s:hidden name="solCLI_refefamiliDireccion"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliDistrito"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliProvincia"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliEstado"></s:hidden>      
                                            <s:hidden name="solCLI_refefamiliTelefono"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliCelular"></s:hidden>
                                            <s:hidden name="solCLI_refefamiliParentesco"></s:hidden>   
                                                <!Ref Laborales-->
                                            <s:hidden name="solCLI_refelabocliNombre"></s:hidden>
                                            <s:hidden name="solCLI_refelabocliActividad"></s:hidden>
                                            <s:hidden name="solCLI_refelabocliTelefono"></s:hidden>
                                            <s:hidden name="solCLI_refelabocliDireccion"></s:hidden>      
                                            <s:hidden name="solCLI_refelabocliDistrito"></s:hidden>
                                            <s:hidden name="solCLI_refelabocliProvincia"></s:hidden>
                                            <s:hidden name="solCLI_refelabocliEstado"></s:hidden>
                                            <s:hidden name="solCLI_refelaboproNombre"></s:hidden>      
                                            <s:hidden name="solCLI_refelaboproActividad"></s:hidden>
                                            <s:hidden name="solCLI_refelaboproTelefono"></s:hidden>
                                            <s:hidden name="solCLI_refelaboproDireccion"></s:hidden> 
                                            <s:hidden name="solCLI_refelaboproDistrito"></s:hidden>
                                            <s:hidden name="solCLI_refelaboproProvincia"></s:hidden>
                                            <s:hidden name="solCLI_refelaboproEstado"></s:hidden> 
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
        <script type="text/javascript" src="/enel/js/buscar.js"></script>
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>
    </body>
</html>