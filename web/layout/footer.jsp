<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    Date dNow = new Date();
    SimpleDateFormat ft
            = new SimpleDateFormat("yyyy");
    String currentDate = ft.format(dNow);
%>
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 3.0.0
    </div>
    <strong>Copyright &copy; <%=currentDate%> <a href="#">Softia</a>.</strong> Todos los derechos reservados.
</footer>