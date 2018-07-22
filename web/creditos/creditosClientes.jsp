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
                        Clientes

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
                                            <div class="col-md-8">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Codigo:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <label class="control-label">Clase de persona:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <select class="form-control" id="">
                                                            <option>PERSONA NATURAL CON NEGOCIO</option>
                                                            <option>PERSONA NATURAL SIN NEGOCIO</option>

                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4">


                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label class="control-label">Score LAFT:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-7">
                                                    <div class="form-group">
                                                        <input type="text" name="regular" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label class="control-label">Calificación LAFT:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-7">
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
                                        <div class="box-body">
                                            <div class="nav-tabs-custom" style="box-shadow: 0 0px 0px rgba(0,0,0,0);">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#identidad_pn" data-toggle="tab">Identidad(PN)</a></li>
                                                    <li><a href="#identidad_pj" data-toggle="tab">Identidad(PJ)</a></li>
                                                    <li><a href="#domicilio" data-toggle="tab">Domicilio</a></li>
                                                    <li><a href="#estado_civil" data-toggle="tab">Estado Civil</a></li>
                                                    <li><a href="#fuentes_ingreso" data-toggle="tab">Fuentes de Ingreso</a></li>
                                                </ul>
                                                <div class="tab-content">
                                                    <div class="active tab-pane" id="identidad_pn">
                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Apellido Materno</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Apellido Paterno</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label>Nombres</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Nacionalidad</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Pais de Nacimiento</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Departamento de Nacimiento</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Pais de Residencia</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Profesion</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Nivel de Estudio</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Nacimiento</label>
                                                                    <input type="date" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Edad</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label>Sexo</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Tipo de Documento Civil</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Nro. Documento Civil</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Tipo Documento Tributario</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label>Nro. Documento Tributario</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>


                                                        </div>

                                                        <div class="col-md-9">

                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Relacion con la Institución</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Carga Familiar</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Nro. de Pasaporte</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>


                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Nombre de Trabajador</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Cód. Interno de Trabajador</label>
                                                                    <input type="text" name="regular" class="form-control">
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

                                                        <div class="col-md-3">
                                                            <div class="col-md-12">
                                                                <div class="box box-primary box-solid">
                                                                    <div class="box-body">
                                                                        <div class="form-group">
                                                                            <label>Tipo de Cliente</label>
                                                                            <div class="radio">
                                                                                <label>
                                                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                    Independiente
                                                                                </label>
                                                                            </div>
                                                                            <div class="radio">
                                                                                <label>
                                                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                    Dependiente
                                                                                </label>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <div class="col-md-4">
                                                            <div class="col-md-12">


                                                                <div class="form-group">
                                                                    <div class="col-md-12">
                                                                        <div class="checkbox">
                                                                            <label>
                                                                                <input type="checkbox">
                                                                                Es accionista
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="col-md-2">
                                                                        <div class="form-group">
                                                                            <label class="control-label">PEP:</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <div class="form-group">
                                                                            <div class="radio" style="margin-top: 0px;">
                                                                                <label>
                                                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                    Si
                                                                                </label>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <div class="form-group">
                                                                            <div class="radio" style="margin-top: 0px;">
                                                                                <label>
                                                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                    No
                                                                                </label>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-8">

                                                            <div class="col-md-7">
                                                                <div class="form-group">
                                                                    <label>Actividad Ecónomica</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <button type="button" class="btn btn-default"><i class="fa fa-search"></i></button>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Inicio Act.</label>
                                                                    <input type="date" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>



                                                    </div>
                                                    <!-- /.tab-pane -->
                                                    <div class="tab-pane" id="identidad_pj">

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Tipo Empresa:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Tipo de Persona Juridica:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Razón Social:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Siglas:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Fecha de Inscripción:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="date" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Zona Registral:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>


                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Doc. Tributario:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>


                                                        <div class="col-md-10" style="padding-left: 0px; padding-right: 185px;">
                                                            <div class="col-md-12">
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Ind. Nacionalidad:</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <select class="form-control" id="">
                                                                            <option>-</option>
                                                                        </select>
                                                                    </div>
                                                                </div>

                                                                <div class="col-md-5">
                                                                    <div class="form-group">
                                                                        <select class="form-control" id="">
                                                                            <option>-</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-12">
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Departamento:</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <select class="form-control" id="">
                                                                            <option>-</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-12">
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Representante Legal: DNI:</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <input type="text" name="regular" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-12">
                                                                <div class="col-md-3">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Nombres:</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-9">
                                                                    <div class="form-group">
                                                                        <input type="text" name="regular" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="col-md-12">
                                                                <button type="button" class="btn btn-block btn-default">Accionistas</button>

                                                                <button type="button" class="btn btn-block btn-default" >Directorio</button>

                                                                <button type="button" class="btn btn-block btn-default" >Ger. y Ejecutivos</button>
                                                            </div>

                                                        </div>

                                                    </div>
                                                    <!-- /.tab-pane -->

                                                    <div class="tab-pane" id="domicilio">

                                                        <div class="col-md-12">
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Tipo de Identificación</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>



                                                        <div class="col-md-12">
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Tipo de Via</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Zona</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label>Tipo de Inmueble</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>



                                                        <div class="col-md-12">


                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Nro.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Cmte.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Etapa</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Zona</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Sec.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Mzna.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Lote</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Bloque</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Interior</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Piso</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Dpto.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Psto.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>




                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Mod.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>Stand.</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label>Tipo Domicilio</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label>Tipo Construcción</label>
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Teléfono fijo :</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Télefono Celular :</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Nro. de Medidor :</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <div class="col-md-12">
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <label>Direccíon:</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="col-md-12">
                                                                <div class="form-group">
                                                                    <label>Direccíon Actualizada:</label>
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Email:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-10">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <button type="button" class="btn btn-default"><i class="fa fa-book"></i></button>
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Referencia:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-11">
                                                                <div class="form-group">
                                                                    <input type="text" name="regular" class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Tiempo de Residencia:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Años:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label class="control-label">Meses:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>


                                                    </div>
                                                    <!-- /.tab-pane -->
                                                    <div class="tab-pane" id="estado_civil">
                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">Estado Civil (CC):</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">Estado Civil (Reniec):</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <select class="form-control" id="">
                                                                        <option>-</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">Apellido Casada:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">Número de Ficha:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label"></label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="checkbox">
                                                                    <label>
                                                                        <input type="checkbox">
                                                                        ¿Registrar Cónyuge?
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <label class="control-label">Datos del Cónyuge:</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <input type="number" name="regular" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <button type="button" class="btn btn-block btn-default">Seleccionar</button>
                                                            </div>
                                                            <div class="col-md-2">
                                                                <button type="button" class="btn btn-block btn-default">Mostrar Detalles</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="col-md-12">
                                                                <a class="btn btn-app" style="float: right">
                                                                    <i class="fa fa-user"></i> Agregar Aval
                                                                </a>
                                                            </div>
                                                        </div>



                                                    </div>
                                                    <!-- /.tab-pane -->
                                                    <div class="tab-pane" id="fuentes_ingreso">
                                                        <div class="col-md-12">
                                                            <div class="col-md-1">
                                                                <div class="form-group">
                                                                    <label>&nbsp;</label>
                                                                    <button type="button" class="btn btn-default">Nuevo</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="box box-primary box-solid">
                                                                <div class="box-body">
                                                                    <table class="table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>#</th>
                                                                                <th>Código</th>
                                                                                <th>Nombre del Negocio</th>
                                                                                <th>Relación</th>
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
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>


                                                    </div>
                                                    <!-- /.tab-pane -->
                                                </div>
                                                <!-- /.tab-content -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">

                                <div class="col-md-12">

                                    <div style="float: right">
                                        <button type="button" class="btn btn-default"><i class="fa fa-print"></i></button>
                                        <button type="button" class="btn btn-default">Grabar</button>
                                        <button type="button" class="btn btn-default">Aplicar</button>
                                        <button type="button" class="btn btn-default">Nuevo</button>
                                        <button type="button" class="btn btn-default">Editar</button>
                                        <button type="button" class="btn btn-default">Deposito</button>
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