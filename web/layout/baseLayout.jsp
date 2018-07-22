<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
                <meta content="width=device-width, initial-scale=1" name="viewport"/>
                <title><tiles:insertAttribute name="title" ignore="true" /></title>
                <link href="../css/bootstrap.min.css" rel="stylesheet"/>
                <link href="../css/font-awesome.min.css" rel="stylesheet"/>
                <link href="../css/estilo.css" rel="stylesheet"/>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

                <script src="../js/bootstrap.min.js"></script>

                <link rel="stylesheet" type="text/css" href="../css/main.css"/>
                <script src="../js/main.js"></script>-->
        <!-- jQuery 3 -->
        <script src="../../bower_components/jquery/dist/jquery.min.js"></script>
        <script src="../../js/script.js"></script>
    </head>

    <body>
        <tiles:insertAttribute name="banner" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />

    </body>
</html>