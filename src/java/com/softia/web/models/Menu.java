package com.softia.web.models;

public class Menu {
    
    private String menuClientes;
    private String menuCreditos;
    private String menuUsuarios;
    private String menuReportes;
    
    private String nombre;
    private String codPadre;
    private String codHijo;
    private String icono;
    private String action;
    
    private String codigo;
    
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
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(String codPadre) {
        this.codPadre = codPadre;
    }

    public String getCodHijo() {
        return codHijo;
    }

    public void setCodHijo(String codHijo) {
        this.codHijo = codHijo;
    }
    
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
