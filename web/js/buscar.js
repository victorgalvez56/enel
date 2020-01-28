function onload() {

    var lon = document.getElementById("tfParamBusquedaCre").val;
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
        document.getElementById("tfNroDepend").removeAttribute("readonly");
        document.getElementById("tfTipoResi").removeAttribute("readonly");
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
    if (document.getElementById("estado").value === "CNB") {
        //document.getElementById("navCB").removeAttribute("class");
        //document.getElementById("navCNB").setAttribute("class", "active");
        document.getElementById("aCNB").click();
    }
}



window.onload = function () {

    var fechahoy = $("#fecSolic")

    var fecha = new Date(); //Fecha actual
    var mes = fecha.getMonth() + 1; //obteniendo mes
    var dia = fecha.getDate(); //obteniendo dia
    var ano = fecha.getFullYear(); //obteniendo año
    if (dia < 10)
        dia = '0' + dia; //agrega cero si el menor de 10
    if (mes < 10)
        mes = '0' + mes //agrega cero si el menor de 10
    fechahoy.val(ano + "-" + mes + "-" + dia)

}

$(document).on("keyup", 'input[type="text"]', function () {
    if (!/^[ a-z0-9áéíóúñü]*$/i.test(this.value)) {
        this.value = this.value.replace(/[^ a-z0-9áéíóúüñ]+/ig, "");
    }
})


var obj2 = $("#Tempresa")
obj2.val("Informal")
$(document).on("keyup", ".solCLI_independITipoaux", function () {
    var obj = $(".solCLI_independITipoaux")
    //0.Informal. 1.Formal
    if (obj.val().length <= 0) {
        obj2.val("Informal")
    } else {
        obj2.val("Formal")
    }
})


$("#Resultadoingresos").attr("readonly", "true");
$("#Resultadogastos").attr("readonly", "true");
$("#Resultadoactivos").attr("readonly", "true");
$("#Resultadopatrimonio").attr("readonly", "true");
var inputgast = $(".gastos")
var inputingr = $(".ingresos")
var resultgast = $("#Resultadogastos")
var resultingr = $("#Resultadoingresos")
var resultactv = $("#Resultadoactivos")
var resultpatr = $("#Resultadopatrimonio")
var resultaux1 = $("#ingr")
var resultaux2 = $("#gast")
var inputaux1 = $(".aux1")
var inputaux2 = $(".aux2")
$(document).on("keyup", ".ingresos", function () {
    var auxingr = 0
    var auxgast = 0
    inputgast.each(function (index, el) {
        auxgast = auxgast + Number($(el).val())
    })
    inputingr.each(function (index, el) {
        auxingr = auxingr + Number($(el).val())
    })
    if (!isNaN(auxingr)) {
        resultingr.val(auxingr)
        resultaux1.val(auxingr)
        resultactv.val(auxingr)
    }
    if (!isNaN(auxgast)) {
        resultgast.val(auxgast)
        resultaux2.val(auxgast)
        resultpatr.val(Number($(".aux1").val()) - Number($(".aux2").val()))
    }
    $("").val(resultingr)
    $("").val(resultgast)

})
$(document).on("keyup", ".gastos", function () {
    var auxgast = 0
    inputgast.each(function (index, el) {
        auxgast = auxgast + Number($(el).val())
    })
    if (!isNaN(auxgast)) {
        resultgast.val(auxgast)
        resultaux2.val(auxgast)
        resultpatr.val(Number($(".aux1").val()) - Number($(".aux2").val()))
    }
    $("").val(resultgast)
})