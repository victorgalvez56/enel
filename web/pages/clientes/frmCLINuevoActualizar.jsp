<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="modCLIBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function fxConsulta() {
                document.getElementById("bGrabar").disabled = false;
                if (document.getElementById("tfSuministro").value === "1558234") {
                    document.getElementById("estado").innerHTML = 'HABILITADO';
                    document.getElementById("direccion").innerHTML = 'PEREZ 496';
                    document.getElementById("distrito").innerHTML = 'SANTA MARIA';
                    document.getElementById("provincia").innerHTML = 'HUAURA';
                    document.getElementById("departamento").innerHTML = 'LIMA';
                } else if (document.getElementById("tfSuministro").value === "1558235") {
                    document.getElementById("estado").innerHTML = 'HABILITADO';
                    document.getElementById("direccion").innerHTML = 'BARTOLOME PEREZ S/N';
                    document.getElementById("distrito").innerHTML = 'SANTA MARIA';
                    document.getElementById("provincia").innerHTML = 'HUAURA';
                    document.getElementById("departamento").innerHTML = 'LIMA';
                } else if (document.getElementById("tfSuministro").value === "1558237") {
                    document.getElementById("estado").innerHTML = 'HABILITADO';
                    document.getElementById("direccion").innerHTML = 'PERU 1778';
                    document.getElementById("distrito").innerHTML = 'SANTA MARIA';
                    document.getElementById("provincia").innerHTML = 'HUAURA';
                    document.getElementById("departamento").innerHTML = 'LIMA';
                } else if (document.getElementById("tfSuministro").value === "1558238") {
                    document.getElementById("estado").innerHTML = 'HABILITADO';
                    document.getElementById("direccion").innerHTML = 'PSJ PERU 280';
                    document.getElementById("distrito").innerHTML = 'SANTA MARIA';
                    document.getElementById("provincia").innerHTML = 'HUAURA';
                    document.getElementById("departamento").innerHTML = 'LIMA';
                } else if (document.getElementById("tfSuministro").value === "1558239") {
                    document.getElementById("estado").innerHTML = 'HABILITADO';
                    document.getElementById("direccion").innerHTML = 'PSJ PERU 280';
                    document.getElementById("distrito").innerHTML = 'SANTA MARIA';
                    document.getElementById("provincia").innerHTML = 'HUAURA';
                    document.getElementById("departamento").innerHTML = 'LIMA';
                } else {
                    document.getElementById("estado").innerHTML = '';
                    document.getElementById("direccion").innerHTML = '';
                    document.getElementById("distrito").innerHTML = '';
                    document.getElementById("provincia").innerHTML = '';
                    document.getElementById("departamento").innerHTML = '';
                    document.getElementById("bGrabar").disabled = true;
                }
            }
            
            function requeridos() {
                /*var suministro = $("#tfSuministro").val();
                var dataURL = "suministro=" + suministro;
                $.getJSON("desplegarDireccion.action", dataURL, function(data) {
                    var dir = data.direccion;
                    $("#departamento").html(dir);
                });*/
                document.getElementById("nombre").removeAttribute("required");
                document.getElementById("codciv").removeAttribute("required");
            }
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini" onload="habilitarCLINuevoActualizar()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <s:if test="mensaje.length() != 0 && mensaje != 'nuevo' && mensaje != 'actualizar'">
                                <div class="alert alert-success">
                                    <div><span class="glyphicon glyphicon-ok"></span><strong> ¡Correcto!</strong> <s:property value="mensaje"/> </div>
                                </div>
                            </s:if>
                            <s:if test="informacion.length() != 0">
                                <div class="alert alert-info">
                                    <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <span id="info"><s:property value="informacion"/></span> </div>
                                </div>
                            </s:if>
                            <s:if test="advertencia.length() != 0">
                                <div class="alert alert-warning">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ¡Advertencia!</strong> <s:property value="advertencia"/> </div>
                                </div>
                            </s:if>
                            <s:if test="error.length() != 0">
                                <div class="alert alert-danger">
                                    <div><span class="glyphicon glyphicon-exclamation-sign"></span> <s:property value="error"/></div>
                                </div>
                            </s:if>
                        </div>
                    </div>
                </div>
                <!-- Content header -->
                <section class="content-header">
                    <s:if test="mensaje ==  'nuevo'">
                        <h1>Nuevo Cliente</h1>
                    </s:if>
                    <s:if test="mensaje ==  'actualizar'">
                        <h1>Actualizar datos de Cliente</h1>
                    </s:if>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <sj:head jqueryui="true" jquerytheme="blitzer"  locale="es"/>                            
                            <s:form action="frmCLINuevoActualizar" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Código:</label>
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" readonly="true" style="text-transform: uppercase;" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Suministro:</label>
                                                            <div class="input-group">
                                                                <s:textfield cssClass="form-control" id="tfSuministro" tabindex="2" name="cliente.sumini" required="true" maxlength="7" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;" />
                                                                <span class="input-group-btn">
                                                                    <s:submit name="consultaSumi" id="bConsultaSumi" value="?" cssClass="btn btn-primary btn-flat" onclick="requeridos();"/>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Estado sum:</label>
                                                            <div class="form-group">
                                                                <s:if test="cliente.sumini.length() != 0">
                                                                    <span style="text-transform: uppercase;" id="spEstado"><s:property value="cliente.estado"/></span>
                                                                </s:if>
                                                                <s:else>
                                                                    <label id="estado"></label>
                                                                </s:else>                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ape paterno:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" id="apellido" name="cliente.apePat" tabindex="5" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ape. materno:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" id="apellidomat" name="cliente.apeMat" tabindex="6" style="text-transform: uppercase;" readonly="true" />              
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label class="control-label">Nombre(s):</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.nombre" id="nombre" tabindex="7" required="true" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>                                           
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nacimiento:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" type="date" id="fecnac" name="cliente.fecNac" tabindex="8" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Sexo:</label>
                                                            <s:select name="cliente.sexo" tabindex="9" id="sSexo" list="lstSexos" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de documento:</label>
                                                            <s:select name="cliente.tipDocCiv" tabindex="10" id="sTipoDoc" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. de documento:</label>
                                                            <div class="form-group">
                                                                <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="11" required="true" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                                                              
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Departamento:</label>
                                                            <div class=" form-group">
                                                                <s:if test="cliente.sumini.length() != 0">
                                                                    <span style="text-transform: uppercase;"><s:property value="cliente.direccion.distrito.provincia.departamento.nombre"/></span>
                                                                </s:if>
                                                                <s:else>
                                                                    <label id="departamento"></label>
                                                                </s:else>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Provincia:</label>
                                                            <div>
                                                                <s:if test="cliente.sumini.length() != 0">
                                                                    <span style="text-transform: uppercase;"><s:property value="cliente.direccion.distrito.provincia.nombre"/></span>
                                                                </s:if>
                                                                <s:else>
                                                                    <label id="provincia"></label>
                                                                </s:else>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Distrito:</label>
                                                            <div>
                                                                <s:if test="cliente.sumini.length() != 0">
                                                                    <span style="text-transform: uppercase;"><s:property value="cliente.direccion.distrito.nombre"/></span>
                                                                </s:if>
                                                                <s:else>                                                                
                                                                    <label id="distrito"></label>
                                                                </s:else>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-12">
                                                        <div class="form-group">
                                                            <label class="control-label">Dirección:</label>
                                                            <div>
                                                                <s:if test="cliente.sumini.length() != 0">
                                                                    <span style="text-transform: uppercase;" id="spDireccion"><s:property value="cliente.direccion.direccion"/></span>
                                                                </s:if>
                                                                <s:else>
                                                                    <label id="direccion"></label>
                                                                </s:else>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                                                                                
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono fijo:</label>
                                                            <div class=" form-group">
                                                                <s:textfield name="cliente.telefono" cssClass="form-control" id="tfTelFijo" tabindex="16" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Teléfono movil:</label>
                                                            <div class=" form-group">
                                                                <s:textfield name="cliente.celular" cssClass="form-control" id="tfTelMovil" tabindex="17" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. hijos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.hijos" id="tfNroHijos" tabindex="18" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. Dependientes:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="" id="tfNroDepend" tabindex="19" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <!--<div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Profesión:</label>
                                                            <s:select name="cliente.profesion.codigo" tabindex="18" id="sProfesion" list="lstProfesiones" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>                                                                    
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Grado de instrucción</label>
                                                            <s:select name="cliente.nivIns" tabindex="19" id="sInstruccion" list="lstNivIns" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>-->
                                                </div>
                                                <!--<div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de zona:</label>
                                                            <s:select name="cliente.direccion.tipoZona" tabindex="20" id="sTipoZona" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Correo:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.correo" id="tfCorreo" tabindex="21" style="text-transform: uppercase;" readonly="true"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Nro. hijos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.hijos" id="tfNroHijos" tabindex="22" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ingresos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.ingreso" id="tfIngresos" tabindex="23" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>-->
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Condición laboral:</label>
                                                            <select class="form-control" tabindex="20">
                                                                <option>Dependiente</option>
                                                                <option>Independiente</option>
                                                                <option>Jubilado</option>
                                                                <option>Ama de casa</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Profesión:</label>
                                                            <s:select name="cliente.profesion.codigo" tabindex="21" id="sProfesion" list="lstProfesiones" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>                                                                    
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Grado de instrucción</label>
                                                            <s:select name="cliente.nivIns" tabindex="22" id="sInstruccion" list="lstNivIns" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Ingresos:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.ingreso" id="tfIngresos" tabindex="23" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de zona:</label>
                                                            <s:select name="cliente.direccion.tipoZona" tabindex="24" id="sTipoZona" list="lstTipZon" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control" readonly="true" />
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tipo de vivienda:</label>
                                                            <select class="form-control" tabindex="25">
                                                                <option>Propia</option>
                                                                <option>Alquilada</option>
                                                                <option>Familiar</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Tiempo de residencia:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="" id="tfTipoResi" tabindex="26" style="text-transform: uppercase;" readonly="true" />
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Correo:</label>
                                                            <div class=" form-group">
                                                                <s:textfield cssClass="form-control" name="cliente.correo" id="tfCorreo" tabindex="27" style="text-transform: uppercase;" readonly="true"/>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <div class="form-group">
                                                            <label class="control-label">Estado civil:</label>
                                                            <select class="form-control" tabindex="28">
                                                                <option>Soltero</option>
                                                                <option>Casado</optio
                                                                <option>Viudo</option>
                                                                <option>Divorciado</option>
                                                                <option>Conviviente</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-12">
                                                        <br>
                                                        <label>DATOS DEL CONYUGE:</label>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Sexo:</label>
                                                            <select class="form-control" tabindex="29">
                                                                <option>Masculino</option>
                                                                <option>Femenino</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Grado instrucción:</label>
                                                            <select class="form-control" tabindex="30">
                                                                <option>Ninguna</option>
                                                                <option>Primaria</option>
                                                                <option>Secudaria</option>
                                                                <option>Técnica</option>
                                                                <option>Superior</option>
                                                            </select>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Condición laboral:</label>
                                                            <select class="form-control" tabindex="31">
                                                                <option>Dependiente</option>
                                                                <option>Independiente</option>
                                                                <option>Jubilado</option>
                                                                <option>Ama de casa</option>
                                                            </select>
                                                        </div>
                                                    </div> 
                                                </div>
                                                 <div class="col-xs-12">
                                                    <div class="col-xs-12">
                                                        <br>
                                                        <label>SEGMENTO DE CLIENTE:</label>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Seg. regulares:</label>
                                                            <select class="form-control" tabindex="32">
                                                                <option>Titular</option>
                                                                <option>Familiar</option>
                                                                <option>Inquilino</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Seg. comerciales:</label>
                                                            <select class="form-control" tabindex="33">
                                                                <option>Taxistas</option>
                                                                <option>Mil oficios</option>
                                                                <option>Emprendedores</option>
                                                            </select>
                                                        </div>
                                                    </div> 
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label class="control-label">Seg. otros:</label>
                                                            <select class="form-control" tabindex="34">
                                                                <option>Amas de casa</option>
                                                                <option>Empleadas del hogar</option>
                                                                <option>Jubilado, pensionista</option>
                                                                <option>Remesas</option>
                                                            </select>
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
                                            <s:submit name="nombre" value="Grabar" id="bGrabar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                                <s:hidden name="cliente.codigo"></s:hidden>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
