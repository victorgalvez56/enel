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
                        Solicitud

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
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Oficina</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>

                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Código de Cliente</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>&nbsp</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>Tipo de Crédito</label>
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
                                        <div class="box-header">
                                            <h3 class="box-title">Datos Solicitados</h3>
                                        </div>
                                        <div class="box-body">

                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <div class="checkbox" style="margin-top: 0px;">
                                                            <label>
                                                                <input type="checkbox">
                                                                Ampliación
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label class="control-label">Nro. de Crédito:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <div class="checkbox" style="margin-top: 0px;">
                                                            <label>
                                                                <input type="checkbox">
                                                                Es accionista
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Monto Solicitado</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Tipo de Crédito</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Modalidad</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Destino Crédito</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Tipo de Producto</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Servicio</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Convenio</label>
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Tasa de Interés</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <label>Tasa de Mora</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <label>Seguro de Siniestro</label>
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Monto Sugerido</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <label>Número Cuotas</label>
                                                    <div class="form-group">
                                                        <input type="number" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <label>Seguro Desgravamen</label>
                                                    <div class="form-group">
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <label>Calculo de Seguro Desgravamen</label>
                                                    <div class="form-group">
                                                        <select class="form-control" id="">
                                                            <option>-</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12" style="padding-right: 0px; padding-left: 0px;">
                                                <div class="col-md-8">
                                                    <div class="col-md-4">
                                                        <label>Tipo de Periodo</label>
                                                        <div class="form-group">
                                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="" checked="">
                                                            Plazo Fijo
                                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="" checked="">
                                                            Fecha Fija
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <label>Plazo</label>
                                                        <div class="form-group">
                                                            <input type="number" name="regular" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <label>Periodos de Gracia</label>
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
                            </div>
                            <div class="row">

                                <div class="col-md-12">

                                    <div style="float: right">
                                        <button type="button" class="btn btn-default">Aplicar</button>
                                        <button type="button" class="btn btn-default">Editar</button>
                                        <button type="button" class="btn btn-default">Desistir</button>

                                        <button type="button" class="btn btn-default">Nuevo</button>
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