<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Mantenedor de Usuarios</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmADMNuevoUsuario" role="form">

                                <div class="row">
                                    <div class="col-lg-12">
                                        <s:if test="mensaje.length() != 0">
                                            <div class="alert alert-success">
                                                <div><span class="glyphicon glyphicon-ok"></span><strong> Mensaje: </strong> <s:property value="mensaje"/> </div>
                                            </div>
                                        </s:if>
                                        <s:if test="informacion.length() != 0">
                                            <div class="alert alert-info">
                                                <div><span class="glyphicon glyphicon-info-sign"></span><strong> Información</strong> <s:property value="informacion"/> </div>
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
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Cod.Usuario</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="1" readonly="true" name="usuario.codUsu" id="tfCodUsu" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Login</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="2" name="usuario.correo" id="tfcorreo"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo Doc.</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="usuario.tiDoCi" tabindex="3" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ap.Paterno</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="4" name="usuario.apePat" id="tfApePat" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. Doc.</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="5" name="usuario.nuDoCi" id="tfNuDoCi" style="text-transform: uppercase;" maxLength="15"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ap.Materno</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="6" name="usuario.apeMat" id="tfApeMat" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nombre</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="7" name="usuario.nombre" id="tfNombre" style="text-transform: uppercase;"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Agencia</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="usuario.oficina.codigo" id="sOficina" tabindex="7" list="lstOficinas" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
<!--                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <button type="button" class="btn btn-success btn-flat form-control" data-toggle="modal" data-target="#modalMntAgencias" id="bMntAgencias">Ver</button>
                                                        </div>
                                                    </div>-->
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Perfil</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="usuario.perfil.codigo" id="sPerfil" tabindex="9" list="lstPerfiles" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Estado</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="usuario.estado" id="sEstado" tabindex="10" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <s:if test="usuario.codUsu.length() == 0">
                                                    <div class="col-md-12">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Clave</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <s:password cssClass="form-control" tabindex="11" name="usuario.passwd" id="tfContraseña"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </s:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                                        
                                <!-- Modal Buscar -->
                                <div class="modal fade" id="modalMntAgencias" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h2 class="modal-title">Mantenimiento de Agencias</h2>
                                            </div>
                                            <div class="modal-body">
                                                <div class="box-body">
                                                    <div class="col-md-6">
                                                        <table class="table">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th>Código</th>
                                                                    <th>Descripción</th>
                                                                    <th>Modificar</th>
                                                                    <th>Quitar</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <s:iterator value="lstOficinas" status="rowStatus">
                                                                    <tr>
                                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                                        <td><s:property value="nombre" /></td>
                                                                        <td><button class="btn btn-primary btn-flat btn-sm" type="button" onclick="pasarParamCan('<s:property value="codigo"/>', '<s:property value="nombre"/>')">Modificar</button></td>
                                                                        <td><button class="btn btn-danger btn-flat btn-sm" type="button" onclick="pasarParamCan('<s:property value=""/>')">Quitar</button></td>
                                                                    </tr>
                                                                </s:iterator>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <s:form  role="form">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label>AGENCIA</label><br>
                                                                    <label>Código:</label>
                                                                    <s:textfield name="canal.codigo" id="tfCodCanal" cssClass="form-control" style="text-transform: uppercase;" readonly="true"/>
                                                                </div>
                                                            </div>
                                                             <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <label>Descripción:</label>
                                                                    <s:textfield name="canal.nombre" id="tfNomCanal" cssClass="form-control" style="text-transform: uppercase;"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div style="float: right">
                                                                    <button class="btn btn-primary" onclick="limpiar()">Cancelar</button>
                                                                    <s:submit value="Grabar" name="grabarAgencia" cssClass="btn btn-primary btn-flat" />
                                                                </div>
                                                            </div>
                                                        </s:form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="usuario.codigo"></s:hidden>
                                            <s:submit name="grabar" id="bGrabar" value="Grabar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script>
            /*$(document).ready(function () {
                document.getElementById("tfComent").required = true;
                boton_habilitado();
                deshabilitarBotones();
            });*/
            function pasarParamCan(codigo, nombre) {
                document.getElementById("tfCodCanal").value = codigo;
                document.getElementById("tfNomCanal").value = nombre;
            }
            
            function limpiar() {
                document.getElementById("tfCodCanal").value = "";
                document.getElementById("tfNomCanal").value = "";
            }
        </script>
    </body>
</html>