<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="modCREBuscar.jsp" %>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Aprobacion de Desembolso</h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Nro. de Crédito:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Cliente:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Analista:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-11">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">DATOS APROBADOS</h3>
                                        </div>
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tasa Interés</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tasa Mora</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Garantias</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Monto Aprobado</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>F. Desembolso</label>
                                                        <input type="date" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Cuotas</label>
                                                        <input type="number" name="regular" class="form-control">
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
                                        <button type="button" class="btn btn-primary btn-flat" data-toggle="modal" data-target="#modalBuscarCre" id="bBuscar" onclick="frmNombre()">Buscar</button>
                                        <button type="button" class="btn btn-primary btn-flat">Revertir Aprobc.</button>
                                        <button type="button" class="btn btn-primary btn-flat">Aprobar</button>
                                        <button type="button" class="btn btn-primary btn-flat">Rechazar</button>
                                        <button type="button" class="btn btn-primary btn-flat">Plan de Pagos</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script>
            function frmNombre() {
                document.getElementById("fBuscar").setAttribute("action", "frmCREAprobacion");
            }
        </script>
    </body>
</html>