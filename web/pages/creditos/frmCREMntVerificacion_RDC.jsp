<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini" onload="bancarizadoNo()">
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
                                    <div><span class="glyphicon glyphicon-info-sign"></span><<strong> Información</strong> <s:property value="informacion"/> </div>
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
                <%--<s:form action="frmCREMntVerificacion" role="form">--%>
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Mantenimiento de Verificación</h1>
                    </section>
                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <s:hidden name="estado" id="estado" />
                                        <div class="nav-tabs-custom">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#bancarizados" data-toggle="tab">Clientes Bancarizados</a></li>
                                                <li><a href="#noBancarizados" data-toggle="tab" id="aCNB">Clientes no Bancarizados</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div class="active tab-pane" id="bancarizados">
                                                    <div class="box-body">
                                                        <div class="table-responsive">
                                                            <table class="table table-condensed">
                                                                <thead>
                                                                    <tr>
                                                                        <th colspan="16"><center>Segmento de Clientes</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th></th>
                                                                        <th colspan="3" class="active"><center>Regulares</center></th>
                                                                        <th colspan="3"><center>Comerciales</center></th>
                                                                        <th colspan="4" class="active"><center>Otros</center></th>
                                                                        <th colspan="4"><center>Comodines</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Perfil</th>
                                                                        <th class="active">Titular</th>
                                                                        <th class="active">Familiar</th>
                                                                        <th class="active">Inquilino</th>
                                                                        <th>Taxistas</th>
                                                                        <th>Mil oficios</th>
                                                                        <th>Emprendedores</th>
                                                                        <th class="active">Amas de casa</th>
                                                                        <th class="active">Empleadas del hogar</th>
                                                                        <th class="active">Jubilado, pensionista</th>
                                                                        <th class="active">Remesas</th>
                                                                        <th>X1</th>
                                                                        <th>X2</th>
                                                                        <th>X3</th>
                                                                        <th>X4</th>
                                                                        <th>Guardar</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="lstVerifiPerfCB" status="rowStatus">
                                                                        <s:if test="true">
                                                                            <tr style="text-transform: uppercase;">
                                                                        </s:if>
                                                                            <s:form action="frmCREMntVerificacion_RDC" role="form">
                                                                                <td width="100" nowrap data-th="Perfil"><s:property value="perfil" /></td>
                                                                                <td width="120" nowrap data-th="Titular"><s:select name="titular" tabindex="1" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Familiar"><s:select name="familiar" tabindex="2" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Inquilino"><s:select name="inquilino" tabindex="3" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Taxistas"><s:select name="taxista" tabindex="4" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Mil oficios"><s:select name="milOficio" tabindex="5" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Emprendedores"><s:select name="emprendedor" tabindex="6" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Amas de casa"><s:select name="ama" tabindex="7" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Empleadas del hogar"><s:select name="empleada" tabindex="8" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Jubilado, pensionista"><s:select name="jubilado" tabindex="9" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Remesas"><s:select name="remesa" tabindex="10" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X1"><s:select name="x1" tabindex="11" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X2"><s:select name="x2" tabindex="12" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X3"><s:select name="x3" tabindex="13" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X4"><s:select name="x4" tabindex="14" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td data-th="Guardar">
                                                                                    <%--<s:hidden name="codigo" value="%{codigo}" />--%>
                                                                                    <s:hidden name="codigo" value="%{#rowStatus.count}" />
                                                                                    <s:submit name="guardarCB" value="Guardar" cssClass="btn btn-primary btn-sm btn-flat" />
                                                                                </td>
                                                                            </s:form>
                                                                        </tr>
                                                                    </s:iterator>
                                                                </tbody>
                                                            </table><br>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="noBancarizados">
                                                    <div class="box-body">
                                                        <div class="table-responsive">
                                                            <table class="table table-condensed">
                                                                <thead>
                                                                    <tr>
                                                                        <th colspan="16"><center>Segmento de Clientes</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th></th>
                                                                        <th colspan="3" class="active"><center>Regulares</center></th>
                                                                        <th colspan="3"><center>Comerciales</center></th>
                                                                        <th colspan="4" class="active"><center>Otros</center></th>
                                                                        <th colspan="4"><center>Comodines</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Perfil</th>
                                                                        <th class="active">Titular</th>
                                                                        <th class="active">Familiar</th>
                                                                        <th class="active">Inquilino</th>
                                                                        <th>Taxistas</th>
                                                                        <th>Mil oficios</th>
                                                                        <th>Emprendedores</th>
                                                                        <th class="active">Amas de casa</th>
                                                                        <th class="active">Empleadas del hogar</th>
                                                                        <th class="active">Jubilado, pensionista</th>
                                                                        <th class="active">Remesas</th>
                                                                        <th>X1</th>
                                                                        <th>X2</th>
                                                                        <th>X3</th>
                                                                        <th>X4</th>
                                                                        <th>Guardar</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="lstVerifiPerfCNB" status="rowStatus">
                                                                        <s:if test="true">
                                                                            <tr style="text-transform: uppercase;">
                                                                        </s:if>
                                                                            <s:form action="frmCREMntVerificacion_RDC" role="form">
                                                                                <td width="100" nowrap data-th="Perfil"><s:property value="perfil" /></td>
                                                                                <td width="120" nowrap data-th="Titular"><s:select name="titular" tabindex="1" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Familiar"><s:select name="familiar" tabindex="2" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Inquilino"><s:select name="inquilino" tabindex="3" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Taxistas"><s:select name="taxista" tabindex="4" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Mil oficios"><s:select name="milOficio" tabindex="5" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Emprendedores"><s:select name="emprendedor" tabindex="6" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Amas de casa"><s:select name="ama" tabindex="7" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Empleadas del hogar"><s:select name="empleada" tabindex="8" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Jubilado, pensionista"><s:select name="jubilado" tabindex="9" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="Remesas"><s:select name="remesa" tabindex="10" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X1"><s:select name="x1" tabindex="11" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X2"><s:select name="x2" tabindex="12" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X3"><s:select name="x3" tabindex="13" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td width="120" nowrap data-th="X4"><s:select name="x4" tabindex="14" list="lstVerificacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="---" cssClass="form-control input-sm"/></td>
                                                                                <td data-th="Guardar">
                                                                                    <%--<s:hidden name="codigo" value="%{codigo}" />--%>
                                                                                    <s:hidden name="codigo" value="%{#rowStatus.count}" />
                                                                                    <s:submit name="guardarCNB" value="Guardar" cssClass="btn btn-primary btn-sm btn-flat" />
                                                                                </td>
                                                                            </s:form>
                                                                        </tr>
                                                                    </s:iterator>
                                                                </tbody>
                                                            </table><br>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                <%--</s:form>--%>
            </div>
        </div>
    </body>
</html>
