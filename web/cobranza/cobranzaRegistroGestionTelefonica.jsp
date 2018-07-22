<%-- 
    Document   : cobranzaRegistroGestionTelefonica
    Created on : 11/06/2018, 04:05:16 PM
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
                <s:form action="bienvenido" role="form">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Gestion de Callcenter
     
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
                                                            <th>Codigo Credito</th>
                                                            <th>Apellidos y Nombres</th>
                                                            <th>Distrito</th>
                                                            <th>Dias Atraso</th>
                                                            <th>Opciones Mora</th>
                                                            <th>Compromiso</th>
                                                            <th>Glosa</th>
                                                            
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>01123215</td>
                                                            <td>Galdos Paredes, Carlos Eduardo </td>
                                                            <td>/98523549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">2</th>
                                                            <td>01178945</td>
                                                            <td>Nuñez Sanchez, Yazid Akbar</td>
                                                            <td>/98577549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">3</th>
                                                            <td>01123215</td>
                                                            <td>Galdos Paredes, Carlos Eduardo </td>
                                                            <td>/98523549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">4</th>
                                                            <td>01178945</td>
                                                            <td>Nuñez Sanchez, Yazid Akbar</td>
                                                            <td>/98577549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">5</th>
                                                            <td>01123215</td>
                                                            <td>Galdos Paredes, Carlos Eduardo </td>
                                                            <td>/98523549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">6</th>
                                                            <td>01178945</td>
                                                            <td>Nuñez Sanchez, Yazid Akbar</td>
                                                            <td>/98577549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">7</th>
                                                            <td>01123215</td>
                                                            <td>Galdos Paredes, Carlos Eduardo </td>
                                                            <td>/98523549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">8</th>
                                                            <td>01178945</td>
                                                            <td>Nuñez Sanchez, Yazid Akbar</td>
                                                            <td>/98577549</td>
                                                            <td>0.00</td>
                                                            <td><s:select name="cobranza.opcMora" tabindex="1" list="lstOpcMora" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td>---</td>
                                                            <td></td>
                                                        </tr>
                                                        
                                                        
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <center>
                                        <s:submit key="Grabar Seccion" cssClass="btn btn-lg btn-primary"/>
                                        <s:submit key="Generar Excel" cssClass="btn btn-lg btn-success"/>
                                        <s:submit key="Salir" cssClass="btn btn-lg btn-danger"/>
                                    </center>
                                </div>
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

