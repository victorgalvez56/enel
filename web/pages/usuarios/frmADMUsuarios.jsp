<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
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
                            <s:form action="frmADMUsuarios" role="form">

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
                                                            <label>Código de Usuario</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="1" name="usuario.codUsu" id="tfCodUsu"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Estado</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" style="text-transform: uppercase;" tabindex="2" name="usuario.estado" id="tfEstado"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha Inicio</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="3" name="fecIni" type="date"/>
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
                                                            <s:textfield cssClass="form-control" tabindex="4" name="usuario.correo" id="tfCorreo"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo Doc.</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:select name="usuario.tiDoCi" tabindex="5" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha Fin</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="6" name="fecFin" type="date"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-12">
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
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro.Doc</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" tabindex="8" name="usuario.nuDoCi" id="tfNuDoCi"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-12">
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
                                                <div class="col-lg-12">
                                                    <table class="table">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Cod.Usuario</th>
                                                            <th>Login</th>
                                                            <th>Ap.Paterno</th>
                                                            <th>Ap.Materno</th>
                                                            <th>Nombre</th>
                                                            <th>Agencia</th>
                                                            <th>Perfil</th>
                                                            <th>Estado</th>
                                                            <th>Tipo Doc.</th>
                                                            <th>Nro.Doc.</th>
                                                            <th>Fec.Crea</th>
                                                            <th>Usua.Crea</th>
                                                            <th>Seleccionar</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <s:iterator value="lstUsuarios" status="rowStatus">
                                                        <tr>
                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                            <td><s:property value="codUsu" /></td>
                                                            <td><s:property value="correo" /></td>
                                                            <td><s:property value="apePat" /></td>
                                                            <td><s:property value="apeMat" /></td>
                                                            <td><s:property value="nombre" /></td>
                                                            <td><s:property value="oficina.nombre" /></td>
                                                            <td><s:property value="perfil.nombre" /></td>
                                                            <td><s:property value="estado" /></td>
                                                            <td><s:property value="tiDoCi" /></td>
                                                            <td><s:property value="nuDoCi" /></td>
                                                            <td><s:property value="fecReg" /></td>
                                                            <td><s:property value="usuReg" /></td>
                                                            <td><center><input type="checkbox" onclick="creSeleccionado('<s:property value="codUsu"/>')"></center></td>
                                                        </tr>
                                                        </s:iterator>
                                                        </tbody>
                                                    </table>        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            
                                            <s:submit name="buscar" value="Buscar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="nuevo" value="Nuevo Usuario" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="editar" value="Editar Usuario" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="exportar" value="Exportar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                    <script>
                        function creSeleccionado(codUsu) {
                            document.getElementById("tfCodusu").value = codUsu;
                        }
                    </script>   
                </section>
            </div>
        </div>
    </body>
</html>