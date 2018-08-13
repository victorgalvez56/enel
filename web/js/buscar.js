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