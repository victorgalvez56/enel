<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FinanSOFT v3.0 | SOFTIA.COM</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="/enel/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="/enel/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="/enel/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/enel/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="/enel/plugins/iCheck/square/blue.css">
        <link rel="stylesheet" type="text/css" href="/enel/css/main.css"/>
        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <link rel="icon" type="image/png" href="/enel/img/logo_horizontal_azul3.png" />
    </head>
    <body class="hold-transition login-page" style="
          background: url(/enel/img/fondo.jpg) no-repeat center center fixed;
          -webkit-background-size: cover;
          -moz-background-size: cover;
          -o-background-size: cover;
          /* background-size: cover; */
          min-height: 100%;
          width: 100%;
          height: auto;
          position: fixed;
          top: 0;
          left: 0;">
        <div class="login-box" style="margin: 10% auto;">
            <div class="login-logo" style="background: #fff; margin-bottom: 0px; color: #fff;
                 background-color: #ffffffcf;">
                <img style="padding-top: 20px; width: 90%;" src="/enel/img/logo_horizontal_azul2.png">
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body" style="background: #ffffffcf;">
                <strong><p class="login-box-msg">INICIO DE SESIÓN</p></strong>
                <s:if test="error.length() != 0">
                    <div class="alert alert-danger">
                        <div><span class="glyphicon glyphicon-exclamation-sign"></span> <s:property value="error"/></div>
                    </div>
                </s:if>
                <s:if test="mensaje.length() != 0">
                    <div class="alert alert-success">
                        <div><span class="glyphicon glyphicon-ok"></span><strong> ¡Éxito!</strong><s:property value="nomUsu"/> <s:property value="mensaje"/></div>
                    </div>
                </s:if>
                <div id="form-olvidado">
                    <s:form action="autenticar" role="form">
                        <div class="form-group has-feedback">
                            <s:textfield cssClass="form-control" id="email" name="usuario.correo" required="true" placeholder="Correo electrónico"/>
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <s:password cssClass="form-control" id="password" name="usuario.passwd" required="true" placeholder="Contraseña"/>
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="row">
                            <div class="col-xs-4"></div>
                            <div class="col-xs-4">
                                <s:submit key="boton.ingresar" cssClass="btn btn-primary btn-block btn-flat"/>
                            </div>
                            <div class="col-xs-4"></div>
                        </div>
                        <div class="row">
                            <span class='text-center'>¿Olvidó su contraseña? Ingresa<a href="#" id="olvidado" class="text-sm"> Aquí</a></span>
                        </div>
                    </s:form>
                </div>
                <div style="display: none;" id="form-olvidado">
                    <h4 class="">Recuperar contraseña</h4>
                    <s:form action="reiniciarClave" role="form" id="login-recordar">
                        <fieldset>
                            <span class="help-block">Escriba el correo electrónico que usó para registrarse.<br>Le enviaremos una nueva contraseña.</span>
                            <div class="form-group input-group" style="padding-top:20px">
                                <span class="input-group-addon">@</span>
                                <s:textfield cssClass="form-control" name="usuario.correo" required="true" placeholder="Correo electrónico"/>
                            </div>
                            <div class="row">
                                <div class="form-group" style="padding-top:20px">
                                    <div class="col-md-12">
                                        <s:submit key="boton.continuar" cssClass="btn btn-primary btn-block" id="btn-olvidado"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <p class="text-center "><a href="#" id="acceso" class="text-sm">Iniciar sesión</a></p>
                                    </div>
                                </div>										
                            </div>
                        </fieldset>
                    </s:form>                    
                </div>                
            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->
        <!-- jQuery 3 -->
        <script src="/enel/bower_components/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="/enel/js/script.js"></script>        
        <script type="text/javascript" src="/enel/js/main.js"></script>
        <!-- iCheck -->
        <script src="/enel/plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>