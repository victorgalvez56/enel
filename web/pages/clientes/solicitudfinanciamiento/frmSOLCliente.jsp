<%@ page language="java" contentType="text/html; charset=UTF-8"
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
                <s:form action="frmSOLCliente" role="form">


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
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="1" name="solCLIcodEvaluador" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Punto de Venta  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="2" name="solCLIpuntVenta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Fecha de Solicitud  </label>
                                                            <s:textfield type="date" cssClass="form-control"tabindex="3" name="solCLIfecSolicitud" style="text-transform: uppercase;" />
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
                                                            <s:select name="cliente.TipDocCiv" tabindex="4"  list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número documento:  </label>
                                                            <s:textfield type="number" cssClass="form-control"  tabindex="5" name="cliente.NroDocCiv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Expedición:  </label>
                                                            <s:select name="solCLIciudadExp" tabindex="6" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="7" name="cliente.nombre" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="8" name="cliente.SegundoNo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="9" name="cliente.ApePat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="10" name="cliente.ApeMat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Nacionalidad:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="11" name="solCLInacionalidad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Fecha de Nacimiento:  </label>
                                                            <s:textfield type="date"cssClass="form-control"  tabindex="12" name="cliente.FecNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Nacimiento:  </label>
                                                            <s:textfield type="text" cssClass="form-control" tabindex="13" name="solCLIciudadNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>País de Nacimiento:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="14" name="solCLIpaisNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Género:  </label>
                                                            <s:textfield type="text" cssClass="form-control"  tabindex="15" name="cliente.sexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estado Civil:  </label>
                                                            <s:select name="cliente.EstCiv" tabindex="16" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estudios:  </label>
                                                            <s:textfield type="text" cssClass="form-control" tabindex="17" name="cliente.NivIns" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ocupación:  </label>
                                                            <s:select name="cliente.DesOcu" tabindex="18"  list="lstTipoOrden" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Número de personas que dependen económicamente del solicitante:  </label>
                                                            <s:textfield type="number" cssClass="form-control"  tabindex="19" name="solCLInperDepend" min="0" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico:  </label>
                                                            <s:textfield type="email" cssClass="form-control" tabindex="20" name="cliente.Correo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número de teléfono:  </label>
                                                            <s:textfield type="number" cssClass="form-control" tabindex="21" name="cliente.Telefono" min="0" style="text-transform: uppercase;" />
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
                                            <s:submit name="siguienteSolc" value="Siguiente"  tabindex="22" id = "bSiguiente" cssClass="btn btn-primary btn-flat" />
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