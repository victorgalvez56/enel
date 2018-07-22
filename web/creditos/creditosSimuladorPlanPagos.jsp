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
                        Simulador de Plan de Pagos

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
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label>Nombre de Cliente</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>&nbsp;</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Moneda</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-6">

                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Tipo Cuota</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Tipo Periodo</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>Tasa Interés</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Monto</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <label>F. Desembolso</label>
                                                    <div class="form-group">
                                                        <input type="date" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Cuotas</label>
                                                    <div class="form-group">
                                                        <input type="number" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <label>Pago Fijo</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="col-md-4">
                                                    <label>Día</label>
                                                    <div class="form-group">
                                                        <input type="number" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <label>D. Gracia</label>
                                                    <div class="form-group">
                                                        <input type="number" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <label>Seg. Desg.</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="box box-primary box-solid">
                                                    <div class="box-header with-border">
                                                        <h3 class="box-title">Seguro de Siniestro</h3>
                                                    </div>

                                                    <div class="box-body">
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <input type="text" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox">
                                                                Aplicar al Desembolso
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>F. Nacimiento</label>
                                                    <div class="form-group">
                                                        <input type="date" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <label>Clase de Persona</label>
                                                    <div class="form-group">
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
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
                                        <a class="btn btn-app"> Fechas</a>
                                        <a class="btn btn-app"> P</a>
                                        <a class="btn btn-app"><i class="fa fa-folder"></i> Plan</a>
                                        <a class="btn btn-app"><i class="fa fa-times"></i> Cancelar</a>
                                        <a class="btn btn-app"><i class="fa fa-search"></i> Ayuda</a>
                                        <a class="btn btn-app"><i class="fa fa-sign-out"></i> Salir</a>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>



                </section>
            </div>

</html>