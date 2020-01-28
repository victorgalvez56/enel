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
                <s:form action="frmSOLReferenciaFamiliar" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - REFERENCIAS FAMILIARES</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">No deben vivir con el solicitante</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield cssClass="form-control" tabindex="1" name="solCLI_refefamiliPrimerNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield cssClass="form-control" tabindex="2" name="solCLI_refefamiliSegundoNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield cssClass="form-control"  tabindex="3" name="solCLI_refefamiliPrimerApel" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield cssClass="form-control"tabindex="4" name="solCLI_refefamiliSegundoApel" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección: </label>
                                                            <s:textfield cssClass="form-control"tabindex="5" name="solCLI_refefamiliDireccion" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito:  </label>
                                                            <s:select name="solCLI_refefamiliDistrito" tabindex="6"  list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="solCLI_refefamiliProvincia" tabindex="7"list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield cssClass="form-control" tabindex="8" name="solCLI_refefamiliEstado" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono </label>
                                                            <s:textfield type="number" cssClass="form-control" tabindex="9" name="solCLI_refefamiliTelefono" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Celular:  </label>
                                                            <s:textfield type="number" cssClass="form-control" tabindex="10" name="solCLI_refefamiliCelular" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Parentesco:  </label>
                                                            <s:textfield cssClass="form-control" tabindex="11" name="solCLI_refefamiliParentesco" style="text-transform: uppercase;" />
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

                                            <s:submit name="siguienteFamil" value="Siguiente" tabindex="12" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
        <script type="text/javascript" src="/enel/js/buscar.js"></script>


    </body>
</html>