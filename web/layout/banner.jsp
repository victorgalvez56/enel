<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Softia - CORE FINANCIERO</title>
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
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="/enel/dist/css/skins/_all-skins.min.css">

        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <!-- jQuery 3 -->
        <script src="/enel/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="/enel/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="/enel/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="/enel/bower_components/fastclick/lib/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="/enel/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="/enel/js/buscar.js"></script>
        <script>
            $(function() {
                var url = window.location.href.substr(window.location.href.lastIndexOf("/") + 1);
                $('.tree li').removeClass('active');
                $('[href$="' + url + '"]').parent().addClass("active");
                $('.treeview').removeClass('menu-open');
                $('[href$="' + url + '"]').closest('li.treeview').addClass("treeview active");
            });
        </script>


    </head>

    <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo" style="background-color: #ffffff;">
            <span class="logo-mini"><img style="    width: 95%;    " src="/enel/img/logo_horizontal_azul3.png"></span>

            <span class="logo-lg"><img style="    width: 160px;    " src="/enel/img/logo_horizontal_azul2.png"></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success"><s:property value="nroMensajes"/></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">Tienes <s:property value="nroMensajes"/> mensajes</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <s:iterator value="lstMensajes" id="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/mail.jpg" class="img-circle" alt="User Image">
                                                </div>                                            
                                                <h4>
                                                    <s:property value="titulo"/>
                                                </h4>
                                                <p><s:property value="detalle"/></p>
                                            </a>
                                        </li>
                                        <!-- end message -->
                                    </s:iterator>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">Mirar todos los mensajes</a></li>
                        </ul>
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning"><s:property value="nroNotificaciones"/></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">Tienes <s:property value="nroNotificaciones"/> notificaciones</li>
                                <s:iterator value="lstNotificaciones" id="menu">
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-exclamation-triangle text-aqua"></i> <s:property value="detalle"/>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </s:iterator>
                            <li class="footer"><a href="#">Ver todo</a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger"><s:property value="nroRecordatorios"/></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">Tienes <s:property value="nroRecordatorios"/> recordatorios</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <s:iterator value="lstRecordatorios" id="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Revisar pagos
                                                </h3>
                                            </a>
                                        </li>
                                        <!-- end task item -->
                                    </s:iterator>
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">Ver todas las advertencias</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="img/user.png" class="user-image" alt="User Image">
                            <span class="hidden-xs"><s:property value="perfil"/></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="img/user.png" class="img-circle" alt="User Image">

                                <p>
                                    <s:property value="perfil"/>
                                    <small><s:property value="correo"/></small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Perfil</a>
                                </div>
                                <div class="pull-right">
                                    <a href="login" class="btn btn-default btn-flat">Cerrar Sesion</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
</html>
