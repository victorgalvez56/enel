<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCLIBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onload()">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <s:if test="mensaje.length() != 0">
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
                    <h1>Mantenimiento de Cliente</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <s:form action="frmCLIMantenimiento" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <label class="control-label">Código:</label>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <s:textfield cssClass="form-control" id="tfcodigo" tabindex="1" name="cliente.codigo" />
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                            <label class="control-label">Clase de Persona:</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <select class="form-control">
                                                    <option>1</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                            <div class="nav-tabs-custom">
                                                <ul class="nav nav-tabs">
                                                    <li class="active" readonly="yes"><a id="tabPN" href="#datos" data-toggle="tab">Datos</a></li>
                                                    <li><a href="#direccion" data-toggle="tab">Dirección</a></li>
                                                    <li><a href="#telefonos" data-toggle="tab">Telefonos</a></li>
                                                </ul>
                                                <div class="tab-content">
                                                    <div class="active tab-pane" id="datos">
                                                        <div class="box-body">
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Primer Apellido:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield cssClass="form-control" id="apellido" name="clientePN.apePat" />
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nacionalidad:</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Segundo Apellido:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield cssClass="form-control" id="apellidomat" name="clientePN.apeMat" />              
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="control-label">Pais de Nacimiento:</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-6">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nombres:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield cssClass="form-control" name="clientePN.nombre" id="nombre"  />
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="control-label">Email:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield cssClass="form-control" name="clientePN.nombre" id="nombre"  />
                                                                        </div>
                                                                    </div>
                                                                </div> 
                                                            </div>
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Profesion:</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>                                                                    
                                                                </div>
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nivel de Estudios</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-6" style="padding-left: 0px; padding-right: 0px;">
                                                                    <div class="col-xs-6" >
                                                                        <div class="form-group">
                                                                            <label class="control-label">Nacimiento:</label>
                                                                            <div class=" form-group">
                                                                            <s:textfield cssClass="form-control" type="date" id="fecnac" name="clientePN.fecNac"/>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-xs-3">
                                                                        <div class="form-group">
                                                                            <label class="control-label">Edad:</label>
                                                                            <div class=" form-group">
                                                                             <s:textfield cssClass="form-control" type="number" id="edad" name="clientePN.edad"/> 
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-xs-3">
                                                                        <div class="form-group">
                                                                            <label class="control-label">Sexo:</label>
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-6">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Tipo de Documento Civil:</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-6">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nro. Documento Civil:</label>
                                                                        <div class="form-group">
                                                                          <s:textfield cssClass="form-control" id="codciv" name="clientePN.nroDocCiv"/>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Tipo de Documento Tributario:</label>
                                                                        <select class="form-control">
                                                                            <option>1</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nro. Documento Tributario:</label>
                                                                        <div class=" form-group">
                                                                          <s:textfield cssClass="form-control" type="number" id="nroDocTri" name="clientePN.nroDocTri"/>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div class="box box-primary box-solid">
                                                                        <div class="box-header">
                                                                            <h5 class="box-title">Conyuge</h5>
                                                                        </div>
                                                                        <div class="box-body">
                                                                            <div class="col-xs-6">
                                                                                <div class="form-group">
                                                                                    <label class="control-label">Tipo de Documento:</label>
                                                                                    <select class="form-control">
                                                                                        <option>1</option>
                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-xs-6">
                                                                                <div class="form-group">
                                                                                    <label class="control-label">Nro. Documento:</label>
                                                                                    <div class="form-group">
                                                                                      <s:textfield cssClass="form-control" id="codciv" name="clientePN.nroDocCiv"/>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div style="float: right">
                                                                        <s:submit name="grabar" value="Grabar" cssClass="btn btn-default" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane" id="direccion">
                                                        <div class="box-body">
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div class="box box-primary box-solid">
                                                                        <div class="box-body">
                                                                            <table class="table">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>#</th>
                                                                                        <th>Departamento</th>
                                                                                        <th>Provincia</th>
                                                                                        <th>Distrito</th>
                                                                                        <th>Dirección</th>
                                                                                        <th>Acción</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <s:iterator value="" status="rowStatus">
                                                                                        <tr>
                                                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                            <td><s:property value="numeroCredito" /></td>
                                                                                            <td><s:property value="numSolicitud" /></td>
                                                                                            <td><s:property value="montoSo" /></td>
                                                                                            <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                        </tr>
                                                                                    </s:iterator>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Departamento:</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Provincia:</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Distrito:</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-2">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Tipo Domicilio:</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-2">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Tipo Construccion:</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-6">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Direccion:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-6">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Referencia:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div style="float: right">
                                                                        <s:submit name="grabar" value="Grabar" cssClass="btn btn-default" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane" id="telefonos">
                                                        <div class="box-body">
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div class="box box-primary box-solid">
                                                                        <div class="box-body">
                                                                            <table class="table">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>#</th>
                                                                                        <th>Teléfono</th>
                                                                                        <th>Movil</th>
                                                                                        <th>Acción</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <s:iterator value="" status="rowStatus">
                                                                                        <tr>
                                                                                            <th><s:property value="%{#rowStatus.count}" /></th>
                                                                                            <td><s:property value="numeroCredito" /></td>
                                                                                            <td><s:property value="numSolicitud" /></td>
                                                                                            <td><button class="btn btn-primary" type="button" onclick="pasarParametro('<s:property value="numSolicitud"/>')">Seleccionar</button></td>
                                                                                        </tr>
                                                                                    </s:iterator>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-12">
                                                                <div class="col-xs-5">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Teléfono:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-5">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Movil:</label>
                                                                        <div class=" form-group">
                                                                            <s:textfield name="cliente.direccion.direccion" cssClass="form-control" id="direccion" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-xs-2">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Operador</label>
                                                                        <div class=" form-group">
                                                                            <select class="form-control">
                                                                                <option>1</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="col-md-12">
                                                                    <div style="float: right">
                                                                        <s:submit name="grabar" value="Grabar" cssClass="btn btn-default" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
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
                                            <s:submit name="nuevo" value="Nuevo" cssClass="btn btn-default" />
                                            <s:submit name="aplicar" value="Aplicar" cssClass="btn btn-default" />
                                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalBuscar" id="bBuscar" onclick="frmNombre()">Buscar</button>
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
            function frmNombre() {
                document.getElementById("fBuscar").setAttribute("action", "frmCLIMantenimiento");
            }
        </script>
    </body>
</html>