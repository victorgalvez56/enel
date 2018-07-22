<%-- 
    Document   : cobranzaReporteRecuperacion
    Created on : 11/06/2018, 03:26:42 PM
    Author     : Yazid1997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">



            <div class="content-wrapper">
                <s:form action="pantallaPrincipal" role="form">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            Reporte de Pagos

                        </h1>

                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-primary">
                            <!--                        <div class="box-header with-border">
                                                        <h3 class="box-title">Aprobación por Comité</h3>
                                                    </div>-->
                            <div class="box-body">
                                
                                
                                <div class="col-xs-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Fecha Inicial:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <s:textfield name="cobranza.fecIni" cssClass="form-control" type="date"  />

                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label class="control-label">Fecha Final:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <s:textfield name="cobranza.fecFin" cssClass="form-control" type="date" />

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
                                    <s:submit key="Procesar" cssClass="btn btn-lg btn-primary"/>
                                    <s:submit key="Salir" cssClass="btn btn-lg btn-danger"/>
                                </center>
                            </div>
                        </div>


                    </section>
                    <!-- Modal -->
                    

                    <!-- /.content -->
                </s:form>
            </div>

            <!-- /.content-wrapper -->




        </div>

        <!-- ./wrapper -->


    </body>
</html>
