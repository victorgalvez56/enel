<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<<<<<<< HEAD
<%@include file="modCLIBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onloadCli()">
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
                    <h1>Mantenedor de Clientes</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <sj:head jqueryui="true" jquerytheme="blitzer"  locale="es"/>
                            <s:form action="frmCLIMantenedor" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>FILTROS DE BUSQUEDA:</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Cod. cliente:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ape. paterno:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="apellido" name="cliente.apePat" tabindex="2"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Dpto:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" id="depart" tabindex="3" onChangeTopics="reloadsecondlist" name="depart"
                                                               list="departMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                               headerKey="-1" headerValue="--Seleccione Departamento--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. suministro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfsuministro" tabindex="4" name="cliente.sumini"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ape. materno:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="apellidomat" name="cliente.apeMat" tabindex="5"/>   
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Prov.:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" id="provinID" tabindex="6" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                                                       reloadTopics="reloadsecondlist" name="provin" 
                                                                       list="provinMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                                       headerKey="-1" headerValue="--Seleccione Provincia--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:select name="cliente.tipDocCiv" tabindex="7" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nombre(s):</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" name="cliente.nombre" id="nombre" tabindex="8"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Dist.:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" formIds="formSelectReload" tabindex="9" reloadTopics="reloadThirdlist"
                                                                       name="cliente.direccion.distrito.codigo" list="distriList" emptyOption="false"
                                                                       listKey="codigo" listValue="nombre"
                                                                       headerKey="-1" headerValue="--Seleccione Distrito--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="10"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. Crédito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>FECHA DE REGISTRO:</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha inicio:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="date" cssClass="form-control" id="codciv" name="" tabindex="12"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha fin:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="date" cssClass="form-control" id="tfCodCre" tabindex="13" name="" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Cod. cliente</th>
                                                    <th>Nro. suministro</th>
                                                    <th>Ape. paterno</th>
                                                    <th>Ape. materno</th>
                                                    <th>Nombres</th>
                                                    <th>Tipo documento</th>
                                                    <th>Nro. documento</th>
                                                    <th>Fecha de registro</th>
                                                    <th>Seleccionar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="cliente.lstCuentas" status="rowStatus">
                                                    <tr>
                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                        <td><s:property value="cuenta" /></td>
                                                        <td><s:property value="producto" /></td>
                                                        <td><s:property value="moneda" /></td>
                                                        <td><s:property value="saldo" /></td>
                                                        <td><s:property value="cuota" /></td>
                                                        <td><s:property value="plazo" /></td>
                                                        <td><s:property value="pdm" /></td>
                                                        <td><s:submit name="ver" value="Ver" cssClass="btn btn-success btn-flat btn-sm" /></td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table><br>
                                    </div>          
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="cliente.codigo"></s:hidden>
                                            <s:submit name="exportar" value="Exportar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="nuevo" value="Nuevo cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="actualizar" value="Actualizar datos de cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="" value="Posicion de cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="" value="Buscar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
=======
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="onloadCli()">
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
                    <h1>Mantenedor de Clientes</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <sj:head jqueryui="true" jquerytheme="blitzer"  locale="es"/>
                            <s:form action="frmCLIMantenedor" role="form">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>FILTROS DE BUSQUEDA:</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Cod. cliente:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCli" tabindex="1" name="cliente.codCli" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ape. paterno:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="apellido" name="cliente.apePat" tabindex="2"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Dpto:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" id="depart" tabindex="3" onChangeTopics="reloadsecondlist" name="depart"
                                                               list="departMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                               headerKey="-1" headerValue="--Seleccione Departamento--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. suministro:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfsuministro" tabindex="4" name="cliente.sumini"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Ape. materno:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="apellidomat" name="cliente.apeMat" tabindex="5"/>   
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Prov.:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" id="provinID" tabindex="6" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                                                       reloadTopics="reloadsecondlist" name="provin" 
                                                                       list="provinMap" listKey="myKey" listValue="myValue" emptyOption="false"
                                                                       headerKey="-1" headerValue="--Seleccione Provincia--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Tipo documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:select name="cliente.tipDocCiv" tabindex="7" list="lstTipDocCiv" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nombre(s):</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" name="cliente.nombre" id="nombre" tabindex="8"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Dist.:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:url id="remoteurl" action="json" namespace="/"/>
                                                            <sj:select href="%{remoteurl}" formIds="formSelectReload" tabindex="9" reloadTopics="reloadThirdlist"
                                                                       name="cliente.direccion.distrito.codigo" list="distriList" emptyOption="false"
                                                                       listKey="codigo" listValue="nombre"
                                                                       headerKey="-1" headerValue="--Seleccione Distrito--" cssClass="form-control"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. documento:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="codciv" name="cliente.nroDocCiv" tabindex="10"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Nro. Crédito:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield cssClass="form-control" id="tfCodCre" tabindex="11" name="" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>FECHA DE REGISTRO:</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha inicio:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="date" cssClass="form-control" id="" name="" tabindex="12"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="form-group">
                                                            <label>Fecha fin:</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <s:textfield type="date" cssClass="form-control" id="" tabindex="13" name="" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Cod. cliente</th>
                                                    <th>Nro. suministro</th>
                                                    <th>Ape. paterno</th>
                                                    <th>Ape. materno</th>
                                                    <th>Nombre(s)</th>
                                                    <th>Tipo documento</th>
                                                    <th>Nro. documento</th>
                                                    <th>Fecha de registro</th>
                                                    <th>Seleccionar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="lstClientes" status="rowStatus">
                                                    <tr>
                                                        <th><s:property value="%{#rowStatus.count}" /></th>
                                                        <td><s:property value="codCli" /></td>
                                                        <td><s:property value="sumini" /></td>
                                                        <td><s:property value="apePat" /></td>
                                                        <td><s:property value="apeMat" /></td>
                                                        <td><s:property value="nombre" /></td>
                                                        <td><s:property value="tipDocCiv" /></td>
                                                        <td><s:property value="nroDocCiv" /></td>
                                                        <td><s:property value="registro" /></td>
                                                        <!--<td><s:checkbox name="cliente.codCli" fieldValue="true" value="codCli" /></td>-->
                                                        <td><center><input type="checkbox" onclick="cliSeleccionado('<s:property value="codCli"/>')"></center></td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table><br>
                                    </div>          
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:hidden name="cliente.codCli" id="codCli"></s:hidden>
                                            <s:hidden name="cliente.codigo"></s:hidden>
                                            <s:submit name="exportar" value="Exportar" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="nuevo" value="Nuevo cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="actualizar" value="Actualizar datos de cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="posicion" value="Posicion de cliente" cssClass="btn btn-primary btn-flat" />
                                            <s:submit name="" value="Buscar" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
    <script>
        function cliSeleccionado(codigo) {
            document.getElementById("codCli").value = codigo;
            document.getElementById("tfCodCli").removeAttribute("name"); 
        }
    </script>
>>>>>>> origin/master
</html>
