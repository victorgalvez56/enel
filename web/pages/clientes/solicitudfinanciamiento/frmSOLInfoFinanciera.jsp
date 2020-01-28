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
                <s:form action="frmSOLInfoFinanciera" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - INFORMACIÓN FINANCIERA</h1>
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
                                                        <div class="form-group">
                                                            <label class="control-label">Ingresos mensuales del Solicitante</label>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="control-label">Gastos mensuales del Solicitante</label>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Sueldo básico:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number"  value="0" cssClass="form-control ingresos" id="sueldobasico" tabindex="1" name="solCLI_infofinanIngSueldoBasic" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Alquiler:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control gastos" id="elemento2" tabindex="6" name="solCLI_infofinanGasAlquiler" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Comisiones:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control ingresos" id="elemento3" tabindex="2" name="solCLI_infofinanIngComisiones" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Crédito de Vivienda:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control gastos" id="elemento4" tabindex="7" name="solCLI_infofinanGasCreditoViv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Honorarios:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control ingresos" id="elemento5" tabindex="3" name="solCLI_infofinanIngHonorarios" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Gastos Familiares:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control gastos" id="elemento6" tabindex="8" name="solCLI_infofinanGasFamiliar" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Alquileres:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control ingresos" id="elemento7" tabindex="4" name="solCLI_infofinanIngAlquileres" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tarjetas de Crédito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control gastos" id="elemento8" tabindex="9" name="solCLI_infofinanGasTarjetasCred" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Otros Ingresos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control ingresos" id="elemento9" tabindex="5" name="solCLI_infofinanIngOtros" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Otros Gastos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control gastos" id="elemento10" tabindex="10" name="solCLI_infofinanGasOtros" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Ingresos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control" id="Resultadoingresos"  name="solCLI_infofinanIngTotal" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total Gastos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control" id="Resultadogastos"  name="solCLI_infofinanGasTotal" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Activos:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control" id="Resultadoactivos" name="solCLI_infofinanGasTotalPat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Total de Patrimonio:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="number" value="0" cssClass="form-control" id="Resultadopatrimonio" name="solCLI_refepersonParentesco" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <s:hidden type="number" cssClass="aux1" id="ingr" tabindex="11" name="codEva" style="text-transform: uppercase;" />
                                                    <s:hidden  type="number" cssClass="aux2" id="gast" tabindex="11" name="codEva" style="text-transform: uppercase;" />

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


                                            <s:submit name="siguienteInfo" value="Siguiente" tabindex="10" id = "bSiguiente" cssClass="btn btn-primary btn-flat" />
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
        <script type="text/javascript" src="/enel/js/buscar.js"></script>

        <!-- iCheck -->
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>

    </body>
</html>