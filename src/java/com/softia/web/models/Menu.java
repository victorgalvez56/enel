package com.softia.web.models;

public class Menu {
    private String menuClientes;
    private String menuCreditos;
    private String menuUsuarios;
    private String menuReportes;
    
    public String getMenuClientes() {
        menuClientes = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"<s:url action=\"frmCLIMantenedor\"/>\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Clientes</a></li>\n" +
"                        <li><a href=\"<s:url action=\"frmCLIPosicion\"/>\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuClientes;
    }

    public void setMenuClientes(String menuClientes) {
        this.menuClientes = menuClientes;
    }

    public String getMenuCreditos() {
        return menuCreditos;
    }

    public void setMenuCreditos(String menuCreditos) {
        this.menuCreditos = menuCreditos;
    }

    public String getMenuUsuarios() {
        return menuUsuarios;
    }

    public void setMenuUsuarios(String menuUsuarios) {
        this.menuUsuarios = menuUsuarios;
    }

    public String getMenuReportes() {
        return menuReportes;
    }

    public void setMenuReportes(String menuReportes) {
        this.menuReportes = menuReportes;
    }
}
