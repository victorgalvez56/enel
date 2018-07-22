<%-- 
    Document   : cobranzaRegistroVisitas
    Created on : 08/06/2018, 12:58:37 PM
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
                <s:form action="cobranzaGestionMora" role="form">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Registro de Visitas
     
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
                                                            <th>Codigo</th>
                                                            <th>Hora</th>
                                                            <th>Nombre</th>
                                                            <th>Direccion</th>
                                                            <th>Telefonos</th>
                                                            <th>Emp./Neg</th>
                                                            <th>Situacion</th>
                                                            <th>Fuente</th>
                                                            <th>Producto</th>
                                                            <th>Visito</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">1</th>
                                                            <td>01</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>Calle las moras nro. 200</td>
                                                            <td>05445126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">2</th>
                                                            <td>02</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>Calle Jorge Chavez 615</td>
                                                            <td>054232126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th scope="row">3</th>
                                                            <td>03</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>Calle las moras nro. 200</td>
                                                            <td>05445126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">4</th>
                                                            <td>04</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>Calle Jorge Chavez 615</td>
                                                            <td>054232126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th scope="row">5</th>
                                                            <td>05</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>Calle las moras nro. 200</td>
                                                            <td>05445126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">6</th>
                                                            <td>06</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>Calle Jorge Chavez 615</td>
                                                            <td>054232126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th scope="row">7</th>
                                                            <td>07</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Carlos Eduardo Galdos Paredes</td>
                                                            <td>Calle las moras nro. 200</td>
                                                            <td>05445126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">8</th>
                                                            <td>08</td>
                                                            <td>11:34</td>                                                        
                                                            <td>Yazid Nuñez Sanchez</td>
                                                            <td>Calle Jorge Chavez 615</td>
                                                            <td>054232126</td>
                                                            <td>SOFTIA.COM</td>
                                                            <td><s:select name="cobranza.situacion" tabindex="1" list="lstSituacion" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.fuente" tabindex="1" list="lstFuente" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:select name="cobranza.producto" tabindex="1" list="lstProducto" listKey="codigo" listValue="descripcion" headerKey="0" headerValue="-- Seleccione --" cssClass="form-control"/></td>
                                                            <td><s:checkbox name="cobranza.visito" /></td>
                                                        </tr>
                                                        
                                                        
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div style="float: left">
                                    <u><s:submit key="N" cssClass="btn btn-lg"/></u>
                                        <s:submit key="E" cssClass="btn btn-lg"/>
                                        <button type="submit" name="grabar" class="btn btn-lg btn-file btn-default" disabled="">G</button>
                                        <button type="submit" name="grabar" class="btn btn-lg btn-file btn-default" disabled="">D</button>
                                    </div>
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

