<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    //commit    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
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
                <s:form action="frmSolicitudFinanciamiento" role="form">


                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X</h1>
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
                                                        <div class="form-group">
                                                            <label>Código Evaluador </label>
                                                            <s:textfield type="text" cssClass="form-control" id="CodEvaluador" tabindex="11" name="CodEvaluador" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Punto de Venta  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="PuntVenta" tabindex="11" name="PuntVenta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Fecha de Solicitud  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="FecSolicitud" tabindex="11" name="FecSolicitud" style="text-transform: uppercase;" />
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
                                                <h3 class="box-title">Datos Personales del Solicitante</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Documento de Identidad: </label>
                                                            <s:select name="cliente.TipDocCiv" tabindex="10" id="TipDocCiv" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número documento:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="NroDocCiv" tabindex="11" name="cliente.NroDocCiv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Expedición:  </label>
                                                            <s:select name="CiudadExp" tabindex="10" id="CiudadExp" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield cssClass="form-control" id="PriNomb" tabindex="11" name="cliente.nombre" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield cssClass="form-control" id="SegNomb" tabindex="11" name="cliente.SegundoNo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="ApePat" tabindex="11" name="cliente.ApePat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield cssClass="form-control" id="ApeMat" tabindex="11" name="cliente.ApeMat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Nacionalidad:  </label>
                                                            <s:textfield cssClass="form-control" id="sNacion" tabindex="11" name="Nacionalidad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Fecha de Nacimiento:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="FecNac" tabindex="11" name="cliente.FecNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Nacimiento:  </label>
                                                            <s:textfield cssClass="form-control" id="CiudadNac" tabindex="11" name="CiudadNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>País de Nacimiento:  </label>
                                                            <s:textfield cssClass="form-control" id="PaisNac" tabindex="11" name="PaisNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Género:  </label>
                                                            <s:textfield cssClass="form-control" id="Sexo" tabindex="11" name="cliente.sexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estado Civil:  </label>
                                                            <s:select name="cliente.EstCiv" tabindex="10" id="EstadoCiv" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estudios:  </label>
                                                            <s:textfield cssClass="form-control" id="sEstudios" tabindex="11" name="cliente.NivIns" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ocupación:  </label>
                                                            <s:select name="cliente.DesOcu" tabindex="10" id="slistOcupa" list="lstTipoOrden" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Número de personas que dependen económicamente del solicitante:  </label>
                                                            <s:textfield min="0" type="number" cssClass="form-control" id="NPersonas" tabindex="11" name="NperDepend" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico:  </label>
                                                            <s:textfield type="email" cssClass="form-control" id="sCorreo" tabindex="11" name="cliente.Correo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número de teléfono:  </label>
                                                            <s:textfield min="0" type="number" cssClass="form-control" id="NumTel" tabindex="11" name="cliente.Telefono" style="text-transform: uppercase;" />
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
                                            <s:submit name="siguienteSolc" value="Siguiente" id = "bSiguiente" cssClass="btn btn-primary btn-flat" />

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

        <script>
        var fechahoy = $("#FecSolicitud")
        n = new Date();
        y = n.getFullYear();
        m = n.getMonth() + 1;
        d = n.getDate();

        fechahoy.val(d + "/" + m + "/" + y)
        /*
        $("#FecSolicitud").attr("readonly", "true");
        $("#PriNomb").attr("readonly", "true");
        $("#SegNomb").attr("readonly", "true");
        $("#ApePat").attr("readonly", "true");
        $("#ApeMat").attr("readonly", "true");
        $("#Nacionalidad").attr("readonly", "true");
        $("#FecNac").attr("readonly", "true");
        $("#CiudaNac").attr("readonly", "true");
        $("#PaisNac").attr("readonly", "true");
        $("#Sexo").attr("readonly", "true");
        $("#sNacion").attr("readonly", "true");
        $("#CiudadNac").attr("readonly", "true");
        $("#sEstudios").attr("readonly", "true");
        */
        </script>

    </body>
</html>