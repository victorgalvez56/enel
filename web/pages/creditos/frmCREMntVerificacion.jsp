<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
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
                <s:form action="frmCREMntVerificacion" role="form">
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
                                        <div class="nav-tabs-custom">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#bancarizados" data-toggle="tab">Clientes Bancarizados</a></li>
                                                <li><a  href="#noBancarizados" data-toggle="tab">Clientes no Bancarizados</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div class="active tab-pane" id="bancarizados">
                                                    <div class="box-body">
                                                        <div class="table-responsive">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th></th>
                                                                        <th colspan="3" class="active"><center>Regulares</center></th>
                                                                        <th colspan="3"><center>Comerciales</center></th>
                                                                        <th colspan="4" class="active"><center>Otros</center></th>
                                                                        <th colspan="4"><center>Comodines</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Perfil</th>
                                                                        <th>Titular</th>
                                                                        <th>Familiar</th>
                                                                        <th>Inquilino</th>
                                                                        <th>Taxistas</th>
                                                                        <th>Mil oficios</th>
                                                                        <th>Emprendedores</th>
                                                                        <th>Amas de casa</th>
                                                                        <th>Empleadas del hogar</th>
                                                                        <th>Jubilado, pensionista</th>
                                                                        <th>Remesas</th>
                                                                        <th>X1</th>
                                                                        <th>X2</th>
                                                                        <th>X3</th>
                                                                        <th>X4</th>
                                                                        <th>Guardar</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="" status="rowStatus">
                                                                        <tr style="text-transform: uppercase;">
                                                                            <td width="100" nowrap><s:property value="%{#rowStatus.count}" /></th>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td width="85" nowrap><s:property value="" /></td>
                                                                            <td><s:submit name="" value="Guardar" cssClass="btn btn-primary btn-flat btn-sm" /></td>
                                                                        </tr>
                                                                    </s:iterator>
                                                                    <tr>
                                                                        <td width="100" nowrap>Perfil 1</td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td width="85" nowrap><select class="form-control"><option>SI</option><option>NO</option></select></td>
                                                                        <td><s:submit name="" value="Guardar" cssClass="btn btn-primary btn-flat btn-sm" /></td>
                                                                        <td><button type="button" class="btn btn-primary btn-sm btn-flat" data-toggle="modal" data-target="#modalVerificacion" id="bBuscarCre">Ver</button></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table><br>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="noBancarizados">
                                                    <div class="box-body">
                                                        <div class="table-responsive">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th></th>
                                                                        <th colspan="3" class="active"><center>Regulares</center></th>
                                                                        <th colspan="3"><center>Comerciales</center></th>
                                                                        <th colspan="4" class="active"><center>Otros</center></th>
                                                                        <th colspan="4"><center>Comodines</center></th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Perfil</th>
                                                                        <th>Titular</th>
                                                                        <th>Familiar</th>
                                                                        <th>Inquilino</th>
                                                                        <th>Taxistas</th>
                                                                        <th>Mil oficios</th>
                                                                        <th>Emprendedores</th>
                                                                        <th>Amas de casa</th>
                                                                        <th>Empleadas del hogar</th>
                                                                        <th>Jubilado, pensionista</th>
                                                                        <th>Remesas</th>
                                                                        <th>X1</th>
                                                                        <th>X2</th>
                                                                        <th>X3</th>
                                                                        <th>X4</th>
                                                                        <th>Ver</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="" status="rowStatus">
                                                                        <tr style="text-transform: uppercase;">
                                                                            <th contenteditable="true"><s:property value="%{#rowStatus.count}" /></th>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td contenteditable="true"><s:property value="" /></td>
                                                                            <td><s:submit name="" value="Guardar" cssClass="btn btn-primary btn-flat btn-sm" /></td>
                                                                        </tr>
                                                                    </s:iterator>
                                                                    <tr>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td>1000000.0</td>
                                                                        <td><button type="button" class="btn btn-primary btn-sm btn-flat" data-toggle="modal" data-target="#modalVerificacion" id="bBuscarCre">Ver</button></td>
                                                                    </tr>
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
                </s:form>
            </div>
        </div>
    </body>
</html>
