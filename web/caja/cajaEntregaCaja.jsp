<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">



            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <s:if test="mensaje.length() != 0">
                            <div class="alert alert-success">
                                <div class="glyphicon glyphicon-ok"></div>
                                <div><strong>¡Correcto!</strong> <s:property value="mensaje"/> </div>
                            </div>
                        </s:if>
                        <s:if test="informacion.length() != 0">
                            <div class="alert alert-info">
                                <div class="glyphicon glyphicon-info-sign"></div>
                                <div><strong>Información</strong> <s:property value="informacion"/> </div>
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
                <s:form action="cajaEntregaCaja" role="form">
                    <section class="content-header">
                        <h1>
                            Entrega de Caja

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
                                    <div class="col-md-10 col-md-offset-1">
                                        <div class="box box-primary box-solid">
                                            <div class="box-body">
                                                <div class="col-md-6">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-header">
                                                            <h3 class="box-title">Soles</h3>
                                                        </div>
                                                        <div class="box-body">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 0.05</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos5" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos5t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 0.10</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos10" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos10t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 0.20</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos20" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos20t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 0.50</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos50" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.centimos50t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 1.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles1" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles1t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 2.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles2" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles2t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 5.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles5" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles5t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 10.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles10" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles10t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 20.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles20" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles20t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 50.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles50" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles50t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 100.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles100" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles100t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">S/ 200.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles200" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles200t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-header">
                                                            <h3 class="box-title">Dolares</h3>
                                                        </div>
                                                        <div class="box-body">
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 1.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares1" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares1t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 2.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares2" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares2t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 5.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares5" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares5t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 10.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares10" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares10t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 20.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares20" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares20t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 50.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares50" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares50t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">US$ 100.00</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares100" value="0" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares100t" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="box box-primary box-solid">
                                                        <div class="box-body">
                                                            <div class="col-md-3">
                                                                <label>&nbsp;</label>
                                                                <div class="form-group">
                                                                    <label class="control-label">Soles</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <label>&nbsp;</label>
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.soles" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <label>Diferencia:</label>
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.solest" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <div class="form-group">
                                                                    <label class="control-label">Dolares</label>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolares" cssClass="form-control"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <s:textfield name="caja.dolarest" cssClass="form-control"/>
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
                                        <center>
                                            <s:submit value="Pre-cuadre" name="precuadre" cssClass="btn btn-default" />
                                            <s:submit value="Cuadrar" name="cuadre" cssClass="btn btn-default" />
                                            <s:submit value="Salir" name="salir" cssClass="btn btn-default" />
                                        </center>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </section>
                </s:form>
            </div>

</html>