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
                        Aprobación por Comité

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
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label class="control-label">Número de Solicitud:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <button type="button" class="btn btn-default">Consultar</button>
                                                    </div>
                                                </div>



                                            </div>
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label for="oficina">Oficina:</label>
                                                        <input type="text" name="regular" class="form-control" id="oficina">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Asesor:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Promotor:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Garantias:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Relac. Garant/Deuda:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">


                                                <div class="col-md-6">
                                                    <div class="form-group" style="margin-right:4px;">
                                                        <label>Nombre del Cliente:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Nombre del Conyugue:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tipo de Credito:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Producto:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Monto Solicitado:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Moneda:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Plazo:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tipo:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tasa:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Fecha de Pago:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Promedio Días de Mora:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Calificación SBS:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Número de Entidades:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label>Tiene Avales:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Actividad:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Deuda Total en S/.:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Monto de Desembolso:</label>
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="box box-primary">
                                                        <div class="box-body">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Codigo</th>
                                                                        <th>Nombre</th>
                                                                        <th>Numero Doc.</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th scope="row">1</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">2</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th scope="row">3</th>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                            <button type="button" class="btn btn-default">Combinaciones Posibles</button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-8">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Consulta Evaluación</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Consulta Avales</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Consulta Garantias</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Consulta Pasivos</button>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Opinión de Riesgos</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Consulta RCC</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Comentarios</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group">
                                                                <button type="button" class="btn btn-default">Mod. Condiciones</button>
                                                            </div>
                                                        </div>


                                                        <div class="col-md-12">
                                                            <div class="form-group">
                                                                <p>Comentario:</p>
                                                                <textarea rows="4" style="width: 100%"></textarea>
                                                            </div>
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
                                        <button type="button" class="btn btn-default">Obs.</button>
                                        <button type="button" class="btn btn-default">Aprobar</button>
                                        <button type="button" class="btn btn-default">Anular Aprobación</button>
                                        <button type="button" class="btn btn-default">Rechazar</button>
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