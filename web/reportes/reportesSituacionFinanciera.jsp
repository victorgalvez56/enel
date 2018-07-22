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
                        Situación Financiera

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
                                                <div class="col-md-10">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 10px">#</th>
                                                                <th style="width: 10px">Concepto</th>
                                                                <th style="width: 20px">MN</th>
                                                                <th style="width: 20px">ME</th>
                                                                <th style="width: 20px">TOTAL MN</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <th scope="row" >1</th>
                                                                <td>00000000000000000000</td>
                                                                <td>00000000000000000000</td>
                                                                <td>00000000000000000000</td>
                                                                <td>00000000000000000000</td>
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
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-10">
                                                    <div class="form-group">
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <label class="control-label">Saldos Encajados:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-10">
                                                    <div class="form-group">
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <label class="control-label">Capital de Trabajo Disponible:</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <input type="number" name="regular" class="form-control">
                                                            </div>
                                                        </div>

                                                    </div>

                                                </div>
                                                <div class="col-md-2">
                                                    <button type="button" class="btn btn-default">Consultar Encaje</button>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-11">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-body">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>CAPTACIONES</th>
                                                                        <th colspan="3">SALDO</th>
                                                                        <th colspan="3">CUENTAS</th>
                                                                        <th colspan="3">INTERES</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Producto</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total MN</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th scope="row" >1</th>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">2</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
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
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <br>
                                                    <br>
                                                    <a class="btn btn-app">
                                                        <i class="fa fa-file-excel-o"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <div class="col-md-11">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-body">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>CAPTACIONES</th>
                                                                        <th colspan="3">SALDO</th>
                                                                        <th colspan="3">CUENTAS</th>
                                                                        <th colspan="3">INTERES</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Producto</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total MN</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total</th>
                                                                        <th>MN</th>
                                                                        <th>ME</th>
                                                                        <th>Total</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th scope="row" >1</th>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                        <td>000000</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">2</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
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
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <br>
                                                    <br>
                                                    <a class="btn btn-app">
                                                        <i class="fa fa-file-excel-o"></i>
                                                    </a>
                                                </div>
                                            </div>
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
            </div>



        </section>
    </div>

</html>