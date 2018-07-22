<%-- 
    Document   : cobranzaSeguimientoCobranza
    Created on : 08/06/2018, 01:44:37 PM
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
                        Seguimiento de Cobranza
     
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
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Asesores de Negocio</th>
                                                            <th>Programadas</th>
                                                            <th>Visitados</th>
                                                            <th>Monto Comprom.</th>
                                                            <th>M. Recuperado</th>
                                                            <th>Asignados</th>
                                                            

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>7.00</td>
                                                            <td>2.00</td>
                                                            <td>3,400.00</td>
                                                            <td>1,000.00</td>
                                                            <td>20.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">2</th>
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>8.00</td>
                                                            <td>1.00</td>
                                                            <td>4,400.00</td>
                                                            <td>2,000.00</td>
                                                            <td>25.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">3</th>
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>7.00</td>
                                                            <td>2.00</td>
                                                            <td>3,400.00</td>
                                                            <td>1,000.00</td>
                                                            <td>20.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">4</th>
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>8.00</td>
                                                            <td>1.00</td>
                                                            <td>4,400.00</td>
                                                            <td>2,000.00</td>
                                                            <td>25.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">5</th>
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>7.00</td>
                                                            <td>2.00</td>
                                                            <td>3,400.00</td>
                                                            <td>1,000.00</td>
                                                            <td>20.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">6</th>
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>8.00</td>
                                                            <td>1.00</td>
                                                            <td>4,400.00</td>
                                                            <td>2,000.00</td>
                                                            <td>25.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">7</th>
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>7.00</td>
                                                            <td>2.00</td>
                                                            <td>3,400.00</td>
                                                            <td>1,000.00</td>
                                                            <td>20.00</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">8</th>
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>8.00</td>
                                                            <td>1.00</td>
                                                            <td>4,400.00</td>
                                                            <td>2,000.00</td>
                                                            <td>25.00</td>
                                                        </tr>
                                                        
                                                        
                                                        
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <s:submit key="Excel" cssClass="btn btn-lg btn-success"/>
                                        <s:submit key="Salir" cssClass="btn btn-lg btn-danger"/>
                                    </center>
                                </div>
                            </div>
                           
                        </div>
                            
                            
                            
                               
                        
                    </div>
                    
                            

                </section>
                            
                <!-- /.content -->
            </s:form>
            </div>
            
            <!-- /.content-wrapper -->




        </div>
                                                        
        <!-- ./wrapper -->


    </body>
</html>
