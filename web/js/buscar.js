function onload() {
    var lon = document.getElementById("tfParamBusqueda").value;
    if (lon.length > 0) {
        document.getElementById("bBuscar").click();
    }
}

function pasarParamCli(codigo) {
    document.getElementById("tfCodCli").value = codigo;
    document.getElementById("bAplicar").click();
}

function pasarDatosCli(codigo, nombre) {
    document.getElementById("tfCodCli").value = codigo;
    document.getElementById("tfNomCli").value = nombre;
}

function pasarParamCre(codigo) {
    document.getElementById("tfCodCre").value = codigo;
    document.getElementById("bAplicar").click();
}