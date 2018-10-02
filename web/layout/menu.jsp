<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <li><a href="<s:url action="pantallaPrincipal"/>"><i class="fa fa-dashboard"></i>  <span>Pantalla Principal</span></a></li>
                <s:iterator value="Menus" id="menu">
                    <li class="treeview">
                        <a href="#">
                            <i class="fa <s:property value="icono"/>"></i> <span><s:property value="nombre"/></span>
                            <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                        </a>
                        <ul class="treeview-menu">
                            <s:iterator value="SubMenus" id="subMenu">
                                <s:if test="%{#menu.codigo == #subMenu.menu}">
                                    <li><a href="/enel/<s:property value="action" />"><i class="fa fa-circle-o"></i> <s:property value="nombre" /></a></li>
                                </s:if>
                            </s:iterator>
                        </ul>
                    </li>
                </s:iterator>
            </ul>
        </section>
    </aside>
</html>
