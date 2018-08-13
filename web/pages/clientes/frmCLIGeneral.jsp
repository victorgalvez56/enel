<%@ include file="/layout/banner.jsp" %> 
<%@ include file="/layout/menu.jsp" %> 
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">
        <script type="text/javascript" src="../../js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
        <script type="text/javascript">

            // function for report
            function inicializar() {
                $.getJSON("report.action", function (data) {
                    var tblData = "";
                    $.each(data.beanList, function () {
                        tblData += "<tr><td>" + this.uname + "</td>" +
                                "<td>" + this.uemail + "</td>" +
                                "<td>" + this.upass + "</td>" +
                                "<td>" + this.udeg + "</td>" +
                                "<td>" +
                                "<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>" +
                                "<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>" +
                                "</td></tr>";
                    });
                    $("#tbody").html(tblData);
                });
            }

            // function for report
            function report() {
                $.getJSON("report.action", function (data) {
                    var tblData = "";
                    $.each(data.beanList, function () {
                        tblData += "<tr><td>" + this.uname + "</td>" +
                                "<td>" + this.uemail + "</td>" +
                                "<td>" + this.upass + "</td>" +
                                "<td>" + this.udeg + "</td>" +
                                "<td>" +
                                "<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>" +
                                "<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>" +
                                "</td></tr>";
                    });
                    $("#tbody").html(tblData);
                });
            }

            // function for fetch old data in form
            function fetchOldRecord(that) {
                $("#uname").val($(that).parent().prev().prev().prev().prev().text());
                $("#uemail").val($(that).parent().prev().prev().prev().text());
                $("#upass").val("");
                $("#udeg").val($(that).parent().prev().text());
                $("#hiddenuemail").val($(that).parent().prev().prev().prev().text());
            }

            // function for update new records
            function updateNewRecord() {
                var newDataURL = "uname=" + $("#uname").val() + "&uemail=" + $("#uemail").val() + "&upass=" + $("#upass").val() +
                        "&udeg=" + $("#udeg").val() + "&hiddenuemail=" + $("#hiddenuemail").val();
                $.getJSON("updateuser.action", newDataURL, function (data) {
                    var ht = data.msg;
                    $("#resp").html(ht);
                });
            }

            // function for delete selected record
            function deleteUser(that) {
                var delDataURL = "uemail=" + $(that).parent().prev().prev().prev().text();
                $.getJSON("deleteuser.action", delDataURL, function (data) {
                    if (data.msg === "Delete Successful") {
                        alert(data.msg)
                        $(that).closest('tr').remove();
                    } else {
                        alert(data.msg)
                    }
                });
            }
        </script>
    </head>    
    <body class="hold-transition skin-blue sidebar-mini" onload="inicializar();">
        <!-- Site wrapper -->
        <div class="wrapper">            
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Mantenedor de Clientes</h1>
                </section>
                <section class="content">
                    <div class="box box-primary">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box box-primary box-solid">
                                        <div class="box-body">
                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>FILTROS DE BUSQUEDA:</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Codigo:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priCodCli" id="priCodCli" class="form-control input-sm" placeholder="Código de Cliente">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Ape. Paterno:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priApePat" id="priApePat" class="form-control input-sm" placeholder="Apellido Paterno">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Dapart.:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div id="priDivDepart" class="form-group">
                                                        <select></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Nro. suministro:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priNroSum" id="priApePat" class="form-control input-sm" placeholder="Nro de Suministro">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Ape. materno:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priApeMat" id="priApeMat" class="form-control input-sm" placeholder="Apellido Materno">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Prov.:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div id="priDivProvin" class="form-group">
                                                        <select></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Tipo documento:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div id="priDivTipDoc" class="form-group">
                                                        <select></select>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Nombre(s):</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priNombre" id="priNombre" class="form-control input-sm" placeholder="Nombres">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Dist.:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div id="priDivTipDoc" class="form-group">
                                                        <select></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Nro. doc.:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priNroDoc" id="priNombre" class="form-control input-sm" placeholder="Número de documento">
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Nro. Crédito:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <input type="text" name="priCodCta" id="priCodCta" class="form-control input-sm" placeholder="Número de crédito">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Fecha inicio:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield type="date" cssClass="form-control" id="codciv" name="" tabindex="12"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="form-group">
                                                        <label>Fecha fin:</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <s:textfield type="date" cssClass="form-control" id="tfCodCre" tabindex="13" name="" />
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <button onclick="" class="btn btn-info btn-block">Buscar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table">
                                        <thead style="font-size: small">
                                            <tr>
                                                <th>#</th>
                                                <th>Cod. cliente</th>
                                                <th>Nro. suministro</th>
                                                <th>Ape. paterno</th>
                                                <th>Ape. materno</th>
                                                <th>Nombres</th>
                                                <th>Tipo documento</th>
                                                <th>Nro. documento</th>
                                                <th>Fecha de registro</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbody">
                                        </tbody>
                                    </table><br>
                                </div>          
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <button onclick="" class="btn btn-info btn-block">Exportar</button>
                                </div>
                                <div class="col-md-2">
                                    <button onclick="" class="btn btn-info btn-block">Nuevo Cliente</button>
                                </div>
                                <div class="col-md-2">
                                    <button onclick="" class="btn btn-info btn-block">Actualizar Datos</button>
                                </div>
                                <div class="col-md-2">
                                    <button onclick="" class="btn btn-info btn-block">Posicion</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
<%@ include file="/layout/footer.jsp" %> 