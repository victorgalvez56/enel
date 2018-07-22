<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <s:if test="error.length() != 0">
            <div class="alert alert-danger">
                <div class="glyphicon glyphicon-exclamation-sign"></div>
                <div><s:property value="error"/></div>
            </div>
        </s:if>
        <s:if test="mensaje.length() != 0">
            <div class="alert alert-success">
                <div class="glyphicon glyphicon-ok"></div>
                <div><strong>¡Éxito!</strong> <s:property value="mensaje"/></div>
            </div>
        </s:if>
        <h3><s:text name="solicitudes.cabecera"/></h3>
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th>Código</th>
                    <th>Documento</th>
                    <th>Nombre</th>
                    <th>Fecha Solicitud</th>
                    <th>Monto</th>
                    <th>Ver</th>
                    <th>Rechazar</th>
                    <th>Desistir</th>
                    <th>Modificar</th>
                </tr>
                <s:iterator value="lstSolicitudes">
                    <s:if test="%{scoring.substring(0, 2).indexOf('1') > -1}">
                        <tr style="background-color: #5cb85c">
                            <td data-th="Código"><s:property value="codigo"/></td>
                            <td data-th="Documento"><s:property value="cliente.nroDoc" /></td>
                            <td data-th="Nombre"><s:property value="cliente.nomCom" /></td>
                            <td data-th="Fecha Solicitud"><s:property value="fecSol" /></td>
                            <td data-th="Monto"><s:property value="monSol" /></td>
                            <td data-th="Ver">
                                <s:url id="verURL" action="verSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Ver</s:a>
                                </td>
                                <td data-th="Rechazar">
                                <s:url id="verURL" action="rechazarSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Rechazar</s:a>
                                </td>
                                <td data-th="Desistir">
                                <s:url id="verURL" action="desistirSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Desistir</s:a>
                                </td>
                                <td data-th="Modificar">
                                <s:url id="verURL" action="modificarSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Modificar</s:a>
                                </td>
                            </tr>
                    </s:if>
                    <s:else>
                        <tr>
                            <td data-th="Código"><s:property value="codigo"/></td>
                            <td data-th="Documento"><s:property value="cliente.nroDoc" /></td>
                            <td data-th="Nombre"><s:property value="cliente.nomCom" /></td>
                            <td data-th="Fecha Solicitud"><s:property value="fecSol" /></td>
                            <td data-th="Monto"><s:property value="monSol" /></td>
                            <td data-th="Ver">
                                <s:url id="verURL" action="verSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Ver</s:a>
                                </td>
                                <td data-th="Rechazar">
                                <s:url id="verURL" action="rechazarSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Rechazar</s:a>
                                </td>
                                <td data-th="Desistir">
                                <s:url id="verURL" action="desistirSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Desistir</s:a>
                                </td>
                                <td data-th="Modificar">
                                <s:url id="verURL" action="modificarSolicitud">
                                    <s:param name="codSol" value="%{codigo}"></s:param>
                                </s:url>
                                <s:a href="%{verURL}">Modificar</s:a>
                                </td>
                            </tr>
                    </s:else>
                </s:iterator>
            </table>
        </div>
    </body>
</html>