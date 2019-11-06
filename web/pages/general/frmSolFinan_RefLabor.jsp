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
                <s:form action="frmSolFinan_RefLabor" role="form">
                    <section class="content-header">
                        <h1>Solicitud Persona Natural Crédito ENEL X - REFERENCIAS LABORALES</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-header with-border">
                                                <h3 class="box-title">En caso de ser Independiente</h3>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Nombre del Cliente: </label>
                                                            <s:textfield cssClass="form-control rf" id="nCliente" tabindex="11" name="rLCNombre" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Actividad:  </label>
                                                            <s:textfield cssClass="form-control" id="actCliente" tabindex="11" name="rLCActividad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="tfCliente" tabindex="11" name="rLCTelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección del Cliente:  </label>
                                                            <s:textfield cssClass="form-control" id="dirCliente" tabindex="11" name="rLCDireClient" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito: </label>
                                                            <s:select name="rLCDistrito" tabindex="10" id="distCliente" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="rLCProvincia" tabindex="10" id="provCliente" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield cssClass="form-control" id="estCliente" tabindex="11" name="rLCEstado" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Nombre del proveedor: </label>
                                                            <s:textfield cssClass="form-control" id="nProveedor" tabindex="11" name="rLPNombre" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Actividad:  </label>
                                                            <s:textfield cssClass="form-control" id="nProveedor" tabindex="11" name="rLPActividad" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Teléfono:  </label>
                                                            <s:textfield type="number" cssClass="form-control" id="tfProveedor" tabindex="11" name="rLPTelef" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Dirección del Proveedor: </label>
                                                            <s:textfield cssClass="form-control" id="dirProveedor" tabindex="11" name="rLPDire" style="text-transform: uppercase;" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Distrito: </label>
                                                            <s:select name="rLPDistrito" tabindex="10" id="distProveedor" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Provincia:  </label>
                                                            <s:select name="rLPProvincia" tabindex="10" id="provProveedor" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />    
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Estado:  </label>
                                                            <s:textfield cssClass="form-control" id="estProveedor" tabindex="11" name="rLPEstado" style="text-transform: uppercase;" />
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
                                            <s:hidden name="CodEvaluador"></s:hidden>
                                            <s:hidden name="PuntVenta"></s:hidden>
                                            <s:hidden name="FecSolicitud"></s:hidden>
                                            <s:hidden name="cliente.TipDocCiv"></s:hidden>
                                            <s:hidden name="cliente.NroDocCiv"></s:hidden>
                                            <s:hidden name="CiudadExp"></s:hidden>
                                            <s:hidden name="cliente.nombre"></s:hidden>
                                            <s:hidden name="cliente.SegundoNo"></s:hidden>
                                            <s:hidden name="cliente.ApePat"></s:hidden>
                                            <s:hidden name="cliente.ApeMat"></s:hidden>
                                            <s:hidden name="Nacionalidad"></s:hidden>
                                            <s:hidden name="cliente.FecNac"></s:hidden>
                                            <s:hidden name="CiudadNac"></s:hidden>
                                            <s:hidden name="PaisNac"></s:hidden>
                                            <s:hidden name="cliente.sexo"></s:hidden>
                                            <s:hidden name="cliente.EstCiv"></s:hidden>
                                            <s:hidden name="cliente.NivIns"></s:hidden>
                                            <s:hidden name="cliente.DesOcu"></s:hidden>
                                            <s:hidden name="NperDepend"></s:hidden>
                                            <s:hidden name="cliente.Correo"></s:hidden>
                                            <s:hidden name="cliente.Telefono"></s:hidden>
                                                <!Cónyuge-->
                                            <s:hidden name="cPrimerNomb"></s:hidden>
                                            <s:hidden name="cSegundNomb"></s:hidden>
                                            <s:hidden name="cPrimerApel"></s:hidden>
                                            <s:hidden name="cSegundApel"></s:hidden>
                                            <s:hidden name="cEmpdondTrab"></s:hidden>
                                            <s:hidden name="cEmpCargo"></s:hidden>
                                            <s:hidden name="cEmpTelef"></s:hidden>
                                                <!Vivienda>
                                            <s:hidden name="vSuministro"></s:hidden>
                                            <s:hidden name="vTitularSum"></s:hidden>
                                            <s:hidden name="vRelacTitul"></s:hidden>
                                            <s:hidden name="vTipoVivien"></s:hidden>
                                            <s:hidden name="vHaceCVivea"></s:hidden>
                                            <s:hidden name="vDireccResi"></s:hidden>
                                            <s:hidden name="vDistVivien"></s:hidden>
                                            <s:hidden name="vProvVivien"></s:hidden>
                                            <s:hidden name="vDepaVivien"></s:hidden>
                                                <!Empleado-->
                                            <s:hidden name="eNombreEmpr"></s:hidden>
                                            <s:hidden name="eRUCEmpr"></s:hidden>
                                            <s:hidden name="eActivdEmpr"></s:hidden>
                                            <s:hidden name="eDirEmpr"></s:hidden>
                                            <s:hidden name="eDepEmpr"></s:hidden>
                                            <s:hidden name="eDisEmpr"></s:hidden>
                                            <s:hidden name="eProvEmpr"></s:hidden>
                                                <!Independiente-->
                                            <s:hidden name="iLabor"></s:hidden>
                                            <s:hidden name="iHacecuantInd"></s:hidden>
                                            <s:hidden name="iTipodeInd"></s:hidden>
                                            <s:hidden name="fNombEmpr"></s:hidden>
                                            <s:hidden name="fRUCEmpr"></s:hidden>
                                            <s:hidden name="fCargo"></s:hidden>
                                            <s:hidden name="fDirLabo"></s:hidden> 
                                            <s:hidden name="fDisLabo"></s:hidden>
                                            <s:hidden name="fProLabo"></s:hidden>
                                            <s:hidden name="fDepLabo"></s:hidden>
                                            <s:hidden name="fTelef"></s:hidden>
                                            <s:hidden name="fAnexo"></s:hidden>
                                                <!Jubilado-->
                                            <s:hidden name="jNombEmpJ"></s:hidden>
                                            <s:hidden name="jNombEmpA"></s:hidden>
                                            <s:hidden name="jHacecuaJ"></s:hidden>  
                                            <s:hidden name="TipoIndep"></s:hidden>
                                                <!Información Financiera-->
                                            <s:hidden name="iSueldBas"></s:hidden>
                                            <s:hidden name="gAlquiler"></s:hidden>
                                            <s:hidden name="iComisiones"></s:hidden>
                                            <s:hidden name="gCreditoViv"></s:hidden>
                                            <s:hidden name="iHonorarios"></s:hidden>
                                            <s:hidden name="gGastosFamil"></s:hidden>
                                            <s:hidden name="iAlquileres"></s:hidden> 
                                            <s:hidden name="gTarjetasCred"></s:hidden>
                                            <s:hidden name="iOtrosIngres"></s:hidden>
                                            <s:hidden name="gOtrosGas"></s:hidden>
                                            <s:hidden name="iTotalIng"></s:hidden>
                                            <s:hidden name="gTotalGas"></s:hidden>
                                            <s:hidden name="iTotalAct"></s:hidden>
                                            <s:hidden name="gTotalPat"></s:hidden>  
                                                <!Ref Personales-->
                                            <s:hidden name="rPPrimerNomb"></s:hidden>
                                            <s:hidden name="rPSegundoNomb"></s:hidden>
                                            <s:hidden name="rPPrimerApell"></s:hidden>
                                            <s:hidden name="rPSegundoApell"></s:hidden>      
                                            <s:hidden name="rPDirec"></s:hidden>
                                            <s:hidden name="rPDistr"></s:hidden>
                                            <s:hidden name="rPProvi"></s:hidden>
                                            <s:hidden name="rPEstad"></s:hidden>      
                                            <s:hidden name="rPTelef"></s:hidden>
                                            <s:hidden name="rPCelul"></s:hidden>
                                            <s:hidden name="rPParen"></s:hidden>   
                                                <!Ref Familiares-->
                                            <s:hidden name="rFPrimerNomb"></s:hidden>
                                            <s:hidden name="rFSegundoNomb"></s:hidden>
                                            <s:hidden name="rFPrimerApell"></s:hidden>
                                            <s:hidden name="rFSegundoApell"></s:hidden>      
                                            <s:hidden name="rFDirec"></s:hidden>
                                            <s:hidden name="rFDistr"></s:hidden>
                                            <s:hidden name="rFProvi"></s:hidden>
                                            <s:hidden name="rFEstad"></s:hidden>      
                                            <s:hidden name="rFTelef"></s:hidden>
                                            <s:hidden name="rFCelul"></s:hidden>
                                            <s:hidden name="rFParen"></s:hidden>   


                                            <s:submit name="siguienteLabor" value="Siguiente" id = "bAplicar" cssClass="btn btn-primary btn-flat" />
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
         $("#nCliente").prop('required', true);
         $("#actCliente").prop('required', true);
         $("#tfCliente").prop('required', true);
         $("#dirCliente").prop('required', true);
         $("#distCliente").prop('required', true);
         $("#provCliente").prop('required', true);
         $("#estCliente").prop('required', true);
         
         $("#nProveedor").prop('required', true);
         $("#actProveedor").prop('required', true);
         $("#tfProveedor").prop('required', true);
         $("#dirProveedor").prop('required', true);
         $("#distProveedor").prop('required', true);
         $("#provProveedor").prop('required', true);
         $("#estProveedor").prop('required', true);
         */
        </script>

    </body>
</html>