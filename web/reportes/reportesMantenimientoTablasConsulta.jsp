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
                        Mantenimiento de Tablas de Consulta

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
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <select multiple="" class="form-control" style="height: 250px">
                                                        <option>option 1</option>
                                                        <option>option 2</option>
                                                        <option>option 3</option>
                                                        <option>option 4</option>
                                                        <option>option 5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="box box-primary box-solid">
                                                    <div class="box-body">
                                                        <div class="col-md-12">
                                                            <div class="col-md-6">
                                                                <label class="control-label">Código</label>
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="control-label">Máscara</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <label class="control-label">Descripción</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <label class="control-label">Tabla y Campo</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <button type="button" class="btn btn-default">Nueva</button>
                                                <button type="button" class="btn btn-default">Modificar</button>
                                                <button type="button" class="btn btn-default">Grabar</button>
                                                <button type="button" class="btn btn-default">Cancelar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <div class="col-md-6">


                                                <div class="form-group">
                                                    <select multiple="" class="form-control" style="height: 350px">
                                                        <option>option 1</option>
                                                        <option>option 2</option>
                                                        <option>option 3</option>
                                                        <option>option 4</option>
                                                        <option>option 5</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="box box-primary box-solid">
                                                    <div class="box-body">
                                                        <div class="col-md-12">
                                                            <div class="col-md-4">
                                                                <label class="control-label">Código</label>
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <label class="control-label">Orden</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <label class="control-label">Código SBS</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <label class="control-label">Descripción Larga</label>
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label class="control-label">Descripción Corta</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-8">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <label>Estructura</label>
                                                                    <select multiple="" class="form-control">
                                                                        <option>option 1</option>
                                                                        <option>option 2</option>
                                                                        <option>option 3</option>
                                                                        <option>option 4</option>
                                                                        <option>option 5</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <button type="button" class="btn btn-default">Nuevo</button>
                                                <button type="button" class="btn btn-default">Modificar</button>
                                                <button type="button" class="btn btn-default">Eliminar</button>
                                                <button type="button" class="btn btn-default">Grabar</button>
                                                <button type="button" class="btn btn-default">Cancelar</button>
                                                <button type="button" class="btn btn-default pull-right">Salir</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>



                </section>
            </div>

</html>