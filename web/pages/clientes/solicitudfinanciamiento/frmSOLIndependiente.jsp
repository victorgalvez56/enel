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
                <s:form id="formulario" action="frmSOLIndependiente" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - INDEPENDIENTE</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">SI ES INDEPENDIENTE POR FAVOR DILIGENCIE ESTE ESPACIO</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Describa específicamente la labor que realiza como independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="1" name="solCLI_independILabor" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Hace cuanto es independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="2" name="solCLI_independITiempoViv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Tipo de Independiente: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="3" name="solCLI_independITipo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>En caso de tener constituida una empresa favor diligenciar este espacio: </label>
                                                    </div>
                                                </div>
                                            </div>        
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Nombre de la Empresa(Si aplica): </label>
                                                            <s:textfield type="text" cssClass="form-control solCLI_independITipoaux" tabindex="4" name="solCLI_independFEmpresaNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>RUC: </label>
                                                            <s:textfield type="text" cssClass="form-control solCLI_independITipoaux" tabindex="5" name="solCLI_independFEmpresaRuc" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Cargo/Ocupación: </label>
                                                            <s:textfield type="text" cssClass="form-control solCLI_independITipoaux"  tabindex="6" name="solCLI_independFCargo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección donde Labora: </label>
                                                            <s:textfield type="text" cssClass="form-control solCLI_independITipoaux" name="solCLI_independFLaboraDire" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Distrito: </label>
                                                            <s:select name="solCLI_independFLaboraDist" tabindex="8" cssClass="form-control solCLI_independITipoaux" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Provincia: </label>
                                                            <s:select name="solCLI_independFLaboraProv" tabindex="9" cssClass="form-control solCLI_independITipoaux" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Departamento: </label>
                                                            <s:select name="solCLI_independFLaboraDepa" tabindex="10" icssClass="form-control solCLI_independITipoaux"  list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Teléfono: </label>
                                                            <s:textfield type="number" cssClass="form-control solCLI_independITipoaux" tabindex="11" name="solCLI_independFTelefono" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Anexo: </label>
                                                            <s:textfield type="text" cssClass="form-control solCLI_independITipoaux" tabindex="12" name="solCLI_independFAnexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico: </label>
                                                            <s:textfield type="email" cssClass="form-control tipoindep"  tabindex="13" name="solCLI_independFCorreo" style="text-transform: uppercase;" />
                                                            <s:hidden cssClass="form-control Tempresa" id="Tempresa"  name="solCLI_independITipoaux" style="text-transform: uppercase;" />

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
                                            <s:submit name="siguienteIndep" value="Siguiente" tabindex="14"  id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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