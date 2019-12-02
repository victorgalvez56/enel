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
                                                            <s:textfield type="text" cssClass="form-control" id="codEval" tabindex="1" name="codEvaluador" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Punto de Venta  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="pntVent" tabindex="2" name="puntVenta" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Fecha de Solicitud  </label>
                                                            <s:textfield type="date" cssClass="form-control" id="fecSolic" tabindex="3" name="fecSolicitud" style="text-transform: uppercase;" />
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
                                                            <s:select name="cliente.TipDocCiv" tabindex="4" id="tipoDoc" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número documento:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="nroDoc" tabindex="5" name="cliente.NroDocCiv" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Expedición:  </label>
                                                            <s:select name="CiudadExp" tabindex="6" id="ciudExp" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Nombre: </label>
                                                            <s:textfield type="text" cssClass="form-control" id="primNomb" tabindex="7" name="cliente.nombre" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Nombre:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="segundoNo" tabindex="8" name="cliente.SegundoNo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Primer Apellido:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="apePat" tabindex="9" name="cliente.ApePat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Segundo Apellido:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="apellMat" tabindex="10" name="cliente.ApeMat" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Nacionalidad:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="nacioCli" tabindex="11" name="Nacionalidad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Fecha de Nacimiento:  </label>
                                                            <s:textfield type="date"cssClass="form-control" id="fnacCli" tabindex="12" name="cliente.FecNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ciudad de Nacimiento:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="cnacCli" tabindex="13" name="CiudadNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>País de Nacimiento:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="paisnacCli" tabindex="14" name="PaisNac" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Género:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="sexCli" tabindex="15" name="cliente.sexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estado Civil:  </label>
                                                            <s:select name="cliente.EstCiv" tabindex="16" id="estadoCiv" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Estudios:  </label>
                                                            <s:textfield type="text" cssClass="form-control" id="estudiosCli" tabindex="17" name="cliente.NivIns" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Ocupación:  </label>
                                                            <s:select name="cliente.DesOcu" tabindex="18" id="desOcu" list="lstTipoOrden" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-4">
                                                        <div class="form-group">
                                                            <label>Número de personas que dependen económicamente del solicitante:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="numPersonas" tabindex="19" name="NperDepend" min="0" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico:  </label>
                                                            <s:textfield type="email" cssClass="form-control" id="correoCli" tabindex="20" name="cliente.Correo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Número de teléfono:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="telefCli" tabindex="21" name="cliente.Telefono" min="0" style="text-transform: uppercase;" />
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
        <!-- iCheck -->
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>
        <script>

//Solicitud de Procedimiento

        window.onload = function () {

            var fechahoy = $("#fecSolic")

            var fecha = new Date(); //Fecha actual
            var mes = fecha.getMonth() + 1; //obteniendo mes
            var dia = fecha.getDate(); //obteniendo dia
            var ano = fecha.getFullYear(); //obteniendo año
            if (dia < 10)
                dia = '0' + dia; //agrega cero si el menor de 10
            if (mes < 10)
                mes = '0' + mes //agrega cero si el menor de 10
            fechahoy.val(ano + "-" + mes + "-" + dia)

        }

        $(document).on("keyup", 'input[type="text"]', function () {
            if (!/^[ a-z0-9áéíóúüñ]*$/i.test(this.value)) {
                this.value = this.value.replace(/[^ a-z0-9áéíóúüñ]+/ig, "");
            }
        })

        </script>

    </body>
</html>