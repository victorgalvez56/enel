<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- jQuery 3 -->
        <script src="/enel/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="/enel/js/script.js"></script>
    </head>

    <body>
        <tiles:insertAttribute name="banner" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />

    </body>
</html>