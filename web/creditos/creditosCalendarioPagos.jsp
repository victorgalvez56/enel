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
                    <h1>
                        Calendario de Pagos

                    </h1>

                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="box box-primary">
                        <!--                        <div class="box-header with-border">
                                                    <h3 class="box-title">Aprobación por Comité</h3>
                                                </div>-->
                        <div class="box-body">



                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Nro. de Crédito</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>&nbsp;</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-7">
                                                    <div class="form-group">
                                                        <label>&nbsp;</label>
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
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Línea de Producto</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Descripción de Línea</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tasa de Interés</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Monto Aprobado</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label>Moneda</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Fecha Solicitud</label>
                                                        <input type="date" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tasa I.T.F.</label>
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
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Fec. Desembolso</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label>Tipo de Cuota</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Nro. Cuotas</label>
                                                        <input type="number" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-header with-border">
                                                            <h3 class="box-title">Tipo de Periodo</h3>
                                                        </div>
                                                        <div class="box-body">
                                                            <div class="checkbox" style="margin-top: 0px;">
                                                                <label>
                                                                    <input type="checkbox">
                                                                    Plazo Fijo
                                                                </label>
                                                            </div>
                                                            <div class="checkbox" style="margin-top: 0px;">
                                                                <label>
                                                                    <input type="checkbox">
                                                                    Fecha Fija
                                                                </label>
                                                            </div>
                                                            <div class="checkbox" style="margin-top: 0px;">
                                                                <label>
                                                                    <input type="checkbox">
                                                                    Fechas Fijas
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-10">

                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Fec. Desembolso</label>
                                                            <input type="number" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Tipo de Cuota</label>
                                                            <select class="form-control" id="">
                                                                <option>-</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Desgravamen</label>
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Seg. Siniestro</label>
                                                            <input type="text" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">

                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="form-group">
                                                            <label>Periodos de Gracia</label>
                                                            <input type="number" name="regular" class="form-control">
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


                                        <button type="button" class="btn btn-default">Fechas</button>
                                        <button type="button" class="btn btn-default">Ver</button>
                                        <button type="button" class="btn btn-default">Inicializar</button>
                                        <button type="button" class="btn btn-default">Aplicar</button>
                                        <button type="button" class="btn btn-default">Grabar</button>
                                        <button type="button" class="btn btn-default">Cancelar</button>
                                        <button type="button" class="btn btn-default">Buscar</button>
                                        <button type="button" class="btn btn-default">Salir</button>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>



                </section>
            </div>

</html>