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
                <s:form id="formulario" action="frmSolFinan_Independiente" role="form">
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
                                                            <s:textfield cssClass="form-control" id="labIndependiente" tabindex="11" name="iLabor" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Hace cuanto es independiente: </label>
                                                            <s:textfield cssClass="form-control" id="haceIndependiente" tabindex="11" name="iHacecuantInd" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Tipo de Independiente: </label>
                                                            <s:textfield cssClass="form-control" id="tipIndependiente" tabindex="11" name="iTipodeInd" style="text-transform: uppercase;" />
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
                                                            <s:textfield cssClass="form-control tipoindep" id="nEmpresa" tabindex="11" name="fNombEmpr" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>RUC: </label>
                                                            <s:textfield cssClass="form-control tipoindep" id="rucEmpresa" tabindex="11" name="fRUCEmpr" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Cargo/Ocupación: </label>
                                                            <s:textfield cssClass="form-control tipoindep" id="cargEmpresa" tabindex="11" name="fCargo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección donde Labora: </label>
                                                            <s:textfield cssClass="form-control tipoindep" id="direcEmpresa" tabindex="11" name="fDirLabo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Distrito: </label>
                                                            <s:select name="fDisLabo" tabindex="10" cssClass="form-control tipoindep" id="provEmpresa" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Provincia: </label>
                                                            <s:select name="fProLabo" tabindex="10" cssClass="form-control tipoindep" id="provEmpresa" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Departamento: </label>
                                                            <s:select name="fDepLabo" tabindex="10" icssClass="form-control tipoindep" id="deparEmpresa" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Teléfono: </label>
                                                            <s:textfield type="number" cssClass="form-control tipoindep" id="tfEmpresa" tabindex="11" name="fTelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Anexo: </label>
                                                            <s:textfield cssClass="form-control tipoindep" id="anexEmpresa" tabindex="11" name="fAnexo" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <label>Correo Electrónico: </label>
                                                            <s:textfield type="text" cssClass="form-control tipoindep" id="corrEmpresa" tabindex="11" name="fCorreo" style="text-transform: uppercase;" />
                                                            <s:hidden cssClass="form-control Tempresa" id="Tempresa" tabindex="11" name="cliente.Sexo" style="text-transform: uppercase;" />

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
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:submit name="siguienteIndep" value="Siguiente" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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

        /*
         $("#labIndependiente").prop('required', true);
         $("#haceIndependiente").prop('required', true);
         $("#tipIndependiente").prop('required', true);
         */
        var obj2 = $("#Tempresa")
        obj2.val("Informal")
        $(document).on("keyup", ".tipoindep", function () {
            var obj = $(".tipoindep")
            //console.log(obj.val())
            console.log(obj2.val())
            //0.Informal. 1.Formal
            if (obj.val().length <= 0) {
                obj2.val("Informal")
                console.log(obj2.val())
            } else {
                obj2.val("Formal")
                console.log(obj2.val())
                /*
                 $("#nEmpresa").prop('required', true);
                 $("#rucEmpresa").prop('required', true);
                 $("#cargEmpresa").prop('required', true);
                 $("#direcEmpresa").prop('required', true);
                 $("#distrEmpresa").prop('required', true);
                 $("#tipIndependiente").prop('required', true);
                 $("#provEmpresa").prop('required', true);
                 $("#deparEmpresa").prop('required', true);
                 $("#tfEmpresa").prop('required', true);
                 $("#anexEmpresa").prop('required', true);
                 $("#corrEmpresa").prop('required', true);
                 */
            }
        })




        </script>

    </body>
</html>