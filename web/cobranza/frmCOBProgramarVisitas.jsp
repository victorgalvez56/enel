<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function cargarAsignados() {
                document.frmPrincipal.action = 'frmCobProgramarVisitas';
                document.frmPrincipal.submit();
            }
        </script>
    </head>    
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <s:form name="frmPrincipal" action="reporteVisitas" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>Programacion de Visitas</h1>                  
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
                                                <s:if test="rutaReporte.length() != 0">
                                                    Descargar e imprimir <a href="<s:property value="rutaReporte"/>" target="_blank"> Carta de Cobranza</a>
                                                </s:if>
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
                                <div class="col-xs-12">
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="control-label">Priorización:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <s:select 
                                                name="tipoOrden" 
                                                tabindex="1" 
                                                list="lstTipoOrden" 
                                                listKey="codigo" 
                                                listValue="descripcion" 
                                                headerKey="0" 
                                                headerValue="-- Seleccione --" 
                                                cssClass="form-control"
                                                onchange="cargarAsignados();"/>
                                        </div>
                                    </div>
                                </div>                                
                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Codigo</th>
                                                        <th>Nombre</th>
                                                        <th>Direccion</th>
                                                        <th>Telefonos</th>
                                                        <th>Distrito</th>
                                                        <th>Saldo</th>
                                                        <th>Atraso</th>
                                                        <th>Moneda</th>
                                                        <th>Programar</th>
                                                        <th>Ver</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:iterator value="lstAsignados">
                                                        <s:if test="%{estado.substring(0, 1).indexOf('A') > -1}">
                                                            <tr>                                                            
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('B') > -1}">
                                                            <tr style="background: #00E466">
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('C') > -1}">
                                                            <tr style="background: #FF0">
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('D') > -1}">
                                                            <tr style="background: #D81B60">
                                                            </s:if>
                                                            <s:if test="%{estado.substring(0, 1).indexOf('Z') > -1}">
                                                            <tr style="background: #0B93D5">
                                                            </s:if>
                                                            <td data-th="#"><s:property value="numero"/></td>
                                                            <td data-th="Código"><s:property value="codCta"/></td>
                                                            <td data-th="Nombre"><s:property value="cliente.nomCom" /></td>
                                                            <td data-th="Direccion"><s:property value="cliente.direccion.direccion" /></td>
                                                            <td data-th="Telefonos"><s:property value="cliente.telefono" /></td>
                                                            <td data-th="Distritos"><s:property value="cliente.direccion.distrito.nombre" /></td>
                                                            <td data-th="Saldo"><s:property value="salCap" /></td>
                                                            <td data-th="Saldo"><s:property value="diaAtr" /></td>
                                                            <td data-th="Moneda"><s:property value="moneda" /></td>
                                                            <td data-th="Programar">
                                                                <s:url id="programarURL" action="programarVisitaCobranza">
                                                                    <s:param name="codigo" value="%{codigo}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{programarURL}">Programar</s:a></td>                                                            
                                                            <td data-th="Ver"><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#Datos${codigo}">Ver</button></td>
                                                        </tr>
                                                    <!-- Modal -->
                                                <div class="modal fade" id="Datos${codigo}" role="dialog">
                                                    <div class="modal-dialog">
                                                        <!-- Modal content-->
                                                        <div class="modal-content">
                                                            <s:form role="form">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                    <h4 class="modal-title">Información Cobranza </h4>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <h3>Datos de Crédito</h3>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Código:</label>
                                                                            <s:property value="codCta"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Saldo:</label>
                                                                            <s:property value="salCap"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Moneda:</label>
                                                                            <s:property value="moneda"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label for="usr">Analista:</label>
                                                                            <s:property value="nomAna"/>                                                                                
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Atraso:</label>
                                                                            <s:property value="diaAtr"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">F. Visita:</label>
                                                                            <s:property value="fecVis"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">F. Compromiso:</label>
                                                                            <s:property value="fecCom"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Cuotas Pagadas:</label>
                                                                            <s:property value="cuoPag"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Cuotas atrasadas:</label>
                                                                            <s:property value="cuoAtr"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Prioridad:</label>
                                                                            <s:property value="priori"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Cap. Atrasado:</label>
                                                                            <s:property value="capAtr"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Int. Atrasado:</label>
                                                                            <s:property value="intAtr"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Mor. Atrasada:</label>
                                                                            <s:property value="morAtr"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Gas. Atrasado:</label>
                                                                            <s:property value="gasAtr"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Mon. Atrasado:</label>
                                                                            <s:property value="monAtr"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Condicion:</label>
                                                                            <s:property value="condic"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Provision:</label>
                                                                            <s:property value="provis"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Prov. Acelerada:</label>
                                                                            <s:property value="proAce"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Calificación:</label>
                                                                            <s:property value="califi"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label for="usr">Producto:</label>
                                                                            <s:property value="produc"/>                                                                                
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <h3>Datos de Cliente</h3>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-6">
                                                                            <label for="usr">Apellido Paterno:</label>
                                                                            <s:property value="cliente.apePat"/>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <label for="usr">Apellido Materno:</label>
                                                                            <s:property value="cliente.apeMat"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label for="usr">Nombre:</label>
                                                                            <s:property value="cliente.nombre"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label for="usr">Dirección</label>
                                                                            <s:property value="cliente.direccion.direccion"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-12">
                                                                            <label for="usr">Distrito</label>
                                                                            <s:property value="cliente.direccion.distrito.nombre"/> - <s:property value="cliente.direccion.distrito.provincia.nombre"/> - <s:property value="cliente.direccion.distrito.provincia.departamento.nombre"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Correo:</label>
                                                                            <s:property value="cliente.correo"/>                                                                                
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Teléfono:</label>
                                                                            <s:property value="cliente.telefono"/>
                                                                        </div>
                                                                        <div class="col-md-4">
                                                                            <label for="usr">Celular:</label>
                                                                            <s:property value="cliente.celular"/>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <div class="col-md-12">
                                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                                                    </div>
                                                                </div>
                                                            </s:form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Modal end -->                                                        
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <center>
                                            <s:submit key="Reporte" cssClass="btn btn-lg btn-success"/>
                                        </center>
                                    </div>
                                </div>

                            </div>





                        </div>



                    </section>

                    <!-- /.content -->
                </s:form>
            </div>

            <!-- /.content-wrapper -->




        </div>

        <!-- ./wrapper -->


    </body>
</html>
