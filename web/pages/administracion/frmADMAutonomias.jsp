<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function cargarAutonomias() {
                document.frmPrincipal.action = 'frmADMAutonomias';
                document.frmPrincipal.submit();
            }
        </script>
    </head>    
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Mantenimiento de Autonomías</h1>                  
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <s:if test="mensaje.length() != 0">
                                        <div class="alert alert-success">
                                            <div class="glyphicon glyphicon-ok"></div>
                                            <div><s:property value="mensaje"/> </div>
                                        </div>
                                    </s:if>
                                    <s:if test="informacion.length() != 0">
                                        <div class="alert alert-info">
                                            <div class="glyphicon glyphicon-info-sign"></div>
                                            <div><s:property value="informacion"/> </div>
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
                            <s:form name="frmPrincipal" role="form">
                                <div class="col-xs-12">
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="control-label">Producto:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <s:select 
                                                name="autonomia.producto.codigo" 
                                                tabindex="1" 
                                                list="lstProductos" 
                                                listKey="codigo" 
                                                listValue="nombre" 
                                                headerKey="0" 
                                                headerValue="-- Seleccione --" 
                                                cssClass="form-control"
                                                onchange="cargarAutonomias();"/>
                                        </div>
                                    </div>
                                </div>                                
                                <div class="col-xs-12">
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="control-label">Canal:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <s:select 
                                                name="autonomia.canal.codigo" 
                                                tabindex="1" 
                                                list="lstCanales" 
                                                listKey="codigo" 
                                                listValue="nombre" 
                                                headerKey="0" 
                                                headerValue="-- Seleccione --" 
                                                cssClass="form-control"
                                                onchange="cargarAutonomias();"/>
                                        </div>
                                    </div>
                                </div>                                
                            </s:form>
                            <div class="col-xs-12">
                                <div class="box box-primary box-solid">
                                    <div class="box-body">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Código</th>
                                                        <th>Perfil</th>
                                                        <th>Minimo</th>
                                                        <th>Maximo</th>
                                                        <th>Estado</th>
                                                        <th>Actualizar</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstAutonomias">
                                                        <tr>                                                            
                                                            <s:form action="actualizaAutonomia" role="form">
                                                                <td data-th="Código"><s:property value="codigo"/></td>
                                                                <td data-th="Perfil"><s:select name="perfil.codigo" tabindex="1" list="lstPerfiles" listKey="codigo" listValue="nombre" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                                <td data-th="Minimo"><s:textfield name="minimo" cssClass="form-control" /></td>
                                                                <td data-th="Maximo"><s:textfield name="maximo" cssClass="form-control" /></td>
                                                                <td data-th="Resultado"><s:select name="estado" tabindex="1" list="lstEstados" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                                <td data-th="Actualizar">
                                                                    <s:hidden name="codigo" value="%{codigo}"></s:hidden>
                                                                    <s:hidden name="autonomia.producto.codigo" value="%{autonomia.producto.codigo}"></s:hidden>
                                                                    <s:hidden name="autonomia.canal.codigo" value="%{autonomia.canal.codigo}"></s:hidden>
                                                                    <s:submit key="Actualizar" cssClass="btn btn-info btn-sm"/>
                                                                </td>                                                            
                                                                <!-- /.content -->
                                                            </s:form>
                                                        </tr>                                                     
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- ./wrapper -->
    </body>
</html>
