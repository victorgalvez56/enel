/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function onload() {
    var lon = document.getElementById("tfParamBusqueda").value;
    if (lon.length > 0) {
        document.getElementById("bBuscar").click();
    }
    if (info.innerHTML == "Listo para solicitud nueva"){
        habilitar();
    }
}

function pasarParam(numeroCredito) {
    document.getElementById("tfNumeroCredito").value = numeroCredito;
    document.getElementById("bAplicar").click();
}


