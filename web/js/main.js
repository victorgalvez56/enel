/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Completa campos de responsable de pago
function completarDatosRP(){
    if (eval(document.getElementById("penEst").checked) === true){
        document.getElementById("apePatApo").value = document.getElementById("apePatEst").value;
        document.getElementById("apeMatApo").value = document.getElementById("apeMatEst").value;
        document.getElementById("apeCasApo").value = document.getElementById("apeCasEst").value;
        document.getElementById("nombreApo").value = document.getElementById("nombreEst").value;
        document.getElementById("tipDocApo").value = document.getElementById("tipDocEst").value;
        document.getElementById("nroDocApo").value = document.getElementById("nroDocEst").value;
        document.getElementById("estCivApo").value = document.getElementById("estCivEst").value;
        document.getElementById("correoApo").value = document.getElementById("correoEst").value;
        document.getElementById("faceboApo").value = document.getElementById("faceboEst").value;
        document.getElementById("twitteApo").value = document.getElementById("twitteEst").value;
        document.getElementById("telFijApo").value = document.getElementById("telFijEst").value;
        document.getElementById("telCelApo").value = document.getElementById("telCelEst").value;
        document.getElementById("telRpmApo").value = document.getElementById("telRpmEst").value;
        document.getElementById("telRpcApo").value = document.getElementById("telRpcEst").value;
        document.getElementById("telOtrApo").value = document.getElementById("telOtrEst").value;

        document.getElementById("apePatConApo").value = document.getElementById("apePatCon").value;
        document.getElementById("apeMatConApo").value = document.getElementById("apeMatCon").value;
        document.getElementById("apeCasConApo").value = document.getElementById("apeCasCon").value;
        document.getElementById("nombreConApo").value = document.getElementById("nombreCon").value;
        document.getElementById("tipDocConApo").value = document.getElementById("tipDocCon").value;
        document.getElementById("nroDocConApo").value = document.getElementById("nroDocCon").value;
        document.getElementById("correoConApo").value = document.getElementById("correoCon").value;
        document.getElementById("faceboConApo").value = document.getElementById("faceboCon").value;
        document.getElementById("twitteConApo").value = document.getElementById("twitteCon").value;
        document.getElementById("telFijConApo").value = document.getElementById("telFijCon").value;
        document.getElementById("telCelConApo").value = document.getElementById("telCelCon").value;
        document.getElementById("telRpmConApo").value = document.getElementById("telRpmCon").value;
        document.getElementById("telRpcConApo").value = document.getElementById("telRpcCon").value;
        document.getElementById("telOtrConApo").value = document.getElementById("telOtrCon").value;
        
    }
}

function primerCiclo(){
    if (document.getElementById("cicloActual").value === document.getElementById("cicloIngreso").value){
        document.getElementById("priCic").style.display = "block";
        document.getElementById("otrCic").style.display = "none";
    } else {
        document.getElementById("priCic").style.display = "none";
        document.getElementById("otrCic").style.display = "block";
    }
}

function buscaCliente(){
    window.location = "consultaCliente.action?nroDoc=" + document.getElementById("nroDoc").value + "&tipDoc=" + document.getElementById("tipDoc").value;
}