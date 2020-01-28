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
                <s:form action="frmSOLConyugue" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - CÓNYUGE</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">Datos del Cónyuge</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="1" name="solCLI_conyugPrimerNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div> 
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="2" name="solCLI_conyugSegundoNomb" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Primero Apellido: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="3" name="solCLI_conyugPrimerApel" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="4" name="solCLI_conyugSegundoApel" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Empresa donde trabaja: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="5" name="solCLI_conyugEmpresaTrab" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>          
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Cargo: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="6" name="solCLI_conyugEmpresaCarg" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono: </label>
                                                            <s:textfield type="number" cssClass="form-control"  tabindex="7" name="solCLI_conyugEmpresaTele" style="text-transform: uppercase;" />
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
                                            <s:submit name="siguienteConyu" value="Siguiente" id = "bsiguiente" cssClass="btn btn-primary btn-flat" tabindex="8" />
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