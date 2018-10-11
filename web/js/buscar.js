function onload() {
    var lon = document.getElementById("tfParamBusquedaCre").value;
    if (lon.length > 0) {
        document.getElementById("bBuscarCre").click();
    } else {
        if (document.getElementById("tfParamBusquedaCli")) {
            var lon = document.getElementById("tfParamBusquedaCli").value;
            if (lon.length > 0) {
                document.getElementById("bBuscarCli").click();
            }
        }
    }
}

function onloadCli() {
    var lon = document.getElementById("tfParamBusquedaCli").value;
    if (lon.length > 0) {
        document.getElementById("bBuscarCli").click();
    }
}

function pasarParamCli(codigo) {
    document.getElementById("tfParamBusquedaCli").value = '';
    document.getElementById("tfCodCli").value = codigo;
    document.getElementById("bAplicar").click();
}

function pasarDatosCli(codigo) {
    document.getElementById("tfParamBusquedaCre").value = '';
    document.getElementById("tfParamBusquedaCli").value = '';
    document.getElementById("tfCodCli").value = codigo;
    document.getElementById("bNombre").click();
}

function pasarParamCre(codigo) {
    document.getElementById("tfParamBusquedaCre").value = '';
    document.getElementById("tfCodCre").value = codigo;
    document.getElementById("bAplicar").click();
}

function habilitarCLINuevoActualizar() {
    if (document.getElementById("spEstado").value !== "" || document.getElementById("spDireccion").value !== "") {
        document.getElementById("apellido").removeAttribute("readonly");
        document.getElementById("apellidomat").removeAttribute("readonly");
        document.getElementById("nombre").removeAttribute("readonly");
        document.getElementById("fecnac").removeAttribute("readonly");
        document.getElementById("sSexo").removeAttribute("readonly");
        document.getElementById("sTipoDoc").removeAttribute("readonly");
        document.getElementById("codciv").removeAttribute("readonly");
        document.getElementById("tfTelFijo").removeAttribute("readonly");
        document.getElementById("tfTelMovil").removeAttribute("readonly");
        document.getElementById("sProfesion").removeAttribute("readonly");
        document.getElementById("sInstruccion").removeAttribute("readonly");
        document.getElementById("sTipoZona").removeAttribute("readonly");
        document.getElementById("tfCorreo").removeAttribute("readonly");
        document.getElementById("tfNroHijos").removeAttribute("readonly");
        document.getElementById("tfIngresos").removeAttribute("readonly");
    }
}

function resultadoEva() {
    var rptaEnel = document.getElementById("tfResultadoENEL").value;
    var rptaSentinel = document.getElementById("tfResultadoSENTINEL").value;
    if (rptaEnel === "" || rptaSentinel === "") {
        document.getElementById("tfResultadoEva").setAttribute("value", "");
        document.getElementById("bDetalleEva").disabled = true;
    } else {
        if (rptaEnel !== "APROBADO" || rptaSentinel !== "APROBADO") {
            document.getElementById("tfResultadoEva").setAttribute("value", "DESAPROBADO"); 
        } else {
            document.getElementById("tfResultadoEva").setAttribute("value", "APROBADO"); 
        }
    }
}

function bancarizadoNo() {
    if(document.getElementById("estado").value === "CNB" ) {
        document.getElementById("navCB").removeAttribute("class");
        document.getElementById("navCNB").setAttribute("class", "active");
    }
}