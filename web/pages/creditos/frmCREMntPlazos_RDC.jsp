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
                <%--<s:form action="frmCREMntPlazos_RDC" role="form">--%>
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Mantenimiento de Plazos</h1>
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
                                                <li class="active" id="navCB"><a href="#bancarizados" data-toggle="tab">Clientes Bancarizados</a></li>
                                                <li id="navCNB"><a  href="#noBancarizados" data-toggle="tab">Clientes no Bancarizados</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div class="active tab-pane" id="bancarizados">
                                                    <div class="box-body">
                                                        <div class="table-responsive">
                                                            <table class="table table-condensed">
                                                                <thead>
                                                                    <tr>
                                                                        <th colspan="16"><center>Plazo de Préstamo</center></th>
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
                                                                    <s:iterator value="lstPlazosCB" status="rowStatus">
                                                                        <s:if test="true">
                                                                            <tr style="text-transform: uppercase;">
                                                                        </s:if>
                                                                            <s:form action="frmCREMntPlazos_RDC" role="form">
                                                                                <td width="100" nowrap data-th="Perfil"><s:property value="perfil" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasTitular" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasFamiliar" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasInquilino" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasTaxista" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasMilOficio" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasEmprendedor" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasAma" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasEmpleada" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasJubilado" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasRemesa" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX1" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX2" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX3" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX4" cssClass="form-control input-sm" /></td>
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
                                                                        <th colspan="16"><center>Plazo de Préstamo</center></th>
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
                                                                    <s:iterator value="lstPlazosCNB" status="rowStatus">
                                                                        <s:if test="true">
                                                                            <tr style="text-transform: uppercase;">
                                                                        </s:if>
                                                                            <s:form action="frmCREMntPlazos_RDC" role="form">
                                                                                <td width="100" nowrap data-th="Perfil"><s:property value="perfil" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasTitular" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasFamiliar" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasInquilino" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasTaxista" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasMilOficio" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasEmprendedor" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasAma" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasEmpleada" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasJubilado" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasRemesa" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX1" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX2" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX3" cssClass="form-control input-sm" /></td>
                                                                                <td width="120" nowrap><s:textfield name="cuotasX4" cssClass="form-control input-sm" /></td>
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
                                
                                <!--Modal Verficación-->
                                <div class="modal fade" id="modalVerificacion" tabindex="-1" role="dialog">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h3 class="modal-title">Verficación</h3>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-md-12" style="background-color:#ECF0F5;"><label>REGULARES</label></div>
                                                    <div class="col-md-12" style="padding-left: 0; padding-right: 0; background-color:#ECF0F5;">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Titular:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Familiar:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Inquilino:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12"><label>COMERCIALES</label></div>
                                                    <div class="col-md-12" style="padding-left: 0; padding-right: 0;">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Taxistas:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Mil oficios:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Otros:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12" style="background-color:#ECF0F5;"><label>OTROS</label></div>
                                                    <div class="col-md-12" style="padding-left: 0; padding-right: 0; background-color:#ECF0F5;">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Amas de casa:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Empleadas del hogar:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Jubilado, pensionista:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>Remesas:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12"><label>COMODINES</label></div>
                                                    <div class="col-md-12" style="padding-left: 0; padding-right: 0;">
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>X1:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>X2:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>X3:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="form-group">
                                                                <label>X4:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <select class="form-control">
                                                                    <option>SI</option>
                                                                    <option>NO</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div style="float: right">
                                                            <s:submit value="Aceptar" name="agregarProducto" cssClass="btn btn-success btn-flat btn-sm" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal-dialog -->
                                </div><!-- /.modal -->
                                
<!--                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="float: right">
                                            <s:submit value="Grabar" name="" cssClass="btn btn-primary btn-flat" />
                                        </div>
                                    </div>
                                </div>-->
                            </div>
                        </div>
                    </section>
                <%--</s:form>--%>
            </div>
        </div>
    </body>
</html>