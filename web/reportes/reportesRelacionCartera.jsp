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
                        Relacion de Cartera

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

                                            <div class="nav-tabs-custom">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#generales" data-toggle="tab">Generales</a></li>
                                                    <li><a href="#detalle" data-toggle="tab">Detalle</a></li>
                                                </ul>
                                                <div class="tab-content">
                                                    <div class="active tab-pane" id="generales">
                                                        <div class="form-group">
                                                            <textarea class="form-control" rows="20" placeholder=""></textarea>
                                                        </div>
                                                    </div>

                                                    <div class="tab-pane" id="detalle">

                                                        <div class="col-md-3">
                                                            <label class="control-label">Vigente:</label>
                                                            <div class="form-group">
                                                                <input type="text" name="regular" class="form-control">
                                                                <input type="checkbox">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <label class="control-label">Refinanciado:</label>
                                                            <div class="form-group">
                                                                <input type="text" name="regular" class="form-control">
                                                                <input type="checkbox">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <label class="control-label">Vencido:</label>
                                                            <div class="form-group">
                                                                <input type="text" name="regular" class="form-control">
                                                                <input type="checkbox">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <label class="control-label">Judicial:</label>
                                                            <div class="form-group">
                                                                <input type="text" name="regular" class="form-control">
                                                                <input type="checkbox">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Código</th>
                                                                        <th>Nombre Negocio</th>
                                                                        <th>Moneda</th>
                                                                        <th>Monto</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th scope="row">1</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">2</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">3</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                            <button type="button" class="btn btn-default">Generar</button>
                                                            <button type="button" class="btn btn-default">Imprimir</button>
                                                            <button type="button" class="btn btn-default">Cancelar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.tab-content -->
                                            </div>
                                            <!-- /.nav-tabs-custom -->

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div style="float: right">
                                        <button type="button" class="btn btn-default">Salir</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                </section>
            </div>

</html>