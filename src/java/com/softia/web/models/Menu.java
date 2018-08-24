package com.softia.web.models;

public class Menu {
    private String menuClientes;
    private String menuCreditos;
    private String menuUsuarios;
    private String menuReportes;
    
    private String menuEvaluador;
    private String menuBackOffice;
    private String menuSupervisor;
    
    public String getMenuEvaluador() {
        menuEvaluador = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCLIMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Clientes</a></li>\n" +
"                        <li><a href=\"/enel/frmCLIPosicion.action\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n" +
"                    </ul>\n" +
"                </li>"  +
                "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-credit-card\"></i> <span>Créditos</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmSOLMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Solicitudes</a></li>\n" +
"                        <li><a href=\"/enel/frmCREMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Créditos</a></li>\n" +
"                        <li><a href=\"/enel/frmCREDocumentos.action\"><i class=\"fa fa-circle-o\"></i> Impresión de Documentos</a></li>\n" +
"                        <li><a href=\"/enel/frmCREMovimientos.action\"><i class=\"fa fa-circle-o\"></i> Movimientos</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuEvaluador;
    }

    public void setMenuEvaluador(String menuEvaluador) {
        this.menuEvaluador = menuEvaluador;
    }
    
    public String getMenuBackOffice() {
        menuBackOffice = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCLIPosicion.action\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n" +
"                    </ul>\n" +
"                </li>"  +
                "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-credit-card\"></i> <span>Créditos</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCREMovimientos.action\"><i class=\"fa fa-circle-o\"></i> Movimientos</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuBackOffice;
    }

    public void setMenuBackOffice(String menuBackOffice) {
        this.menuBackOffice = menuBackOffice;
    }
    
    public String getMenuSupervisor() {
        menuSupervisor = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCLIPosicion.action\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n" +
"                    </ul>\n" +
"                </li>"  +
                "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-credit-card\"></i> <span>Créditos</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCREMntAprobacion.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Aprobaciones</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuSupervisor;
    }

    public void setMenuSupervisor(String menuSupervisor) {
        this.menuSupervisor = menuSupervisor;
    }
    
    //MENU COMPLETO
    public String getMenuClientes() {
        menuClientes = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmCLIPosicion.action\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuClientes;
    }

    public void setMenuClientes(String menuClientes) {
        this.menuClientes = menuClientes;
    }

    public String getMenuCreditos() {
        menuCreditos = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-credit-card\"></i> <span>Créditos</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmSOLMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Solicitudes</a></li>\n" +
"                        <li><a href=\"/enel/frmCREMntAprobacion.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Aprobaciones</a></li>\n" +
"                        <li><a href=\"/enel/frmCREMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Créditos</a></li>\n" +
"                        <li><a href=\"/enel/frmCREDocumentos.action\"><i class=\"fa fa-circle-o\"></i> Impresión de Documentos</a></li>\n" +
"                        <li><a href=\"/enel/frmCREMovimientos.action\"><i class=\"fa fa-circle-o\"></i> Movimientos</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuCreditos;
    }

    public void setMenuCreditos(String menuCreditos) {
        this.menuCreditos = menuCreditos;
    }

    public String getMenuUsuarios() {
        menuUsuarios = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-user\"></i> <span>Usuarios</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmADMUsuarios.action\"><i class=\"fa fa-circle-o\"></i> Administrador de Usuarios</a></li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuUsuarios;
    }

    public void setMenuUsuarios(String menuUsuarios) {
        this.menuUsuarios = menuUsuarios;
    }

    public String getMenuReportes() {
        menuReportes = "<li class=\"treeview\">\n" +
"                    <a href=\"#\">\n" +
"                        <i class=\"fa fa-archive\"></i> <span>Reportes</span>\n" +
"                        <span class=\"pull-right-container\">\n" +
"                            <i class=\"fa fa-angle-left pull-right\"></i>\n" +
"                        </span>\n" +
"                    </a>\n" +
"                    <ul class=\"treeview-menu\">\n" +
"                        <li><a href=\"/enel/frmREPCRECartera.action\"><i class=\"fa fa-circle-o\"></i> Cartera de Créditos</a></li>\n" +
"                        <li><a href=\"/enel/frmREPCREMora.action\"><i class=\"fa fa-circle-o\"></i> Mora</a></li>\n" +
"                        <li class=\"treeview\">\n" +
"                            <a href=\"#\">\n" +
"                                <i class=\"fa fa-circle-o\"></i> <span>Operaciones</span>\n" +
"                                <span class=\"pull-right-container\">\n" +
"                                    <i class=\"fa fa-angle-down\"></i>\n" +
"                                </span>\n" +
"                            </a>\n" +
"                            <ul class=\"treeview-menu\">\n" +
"                                <li><a href=\"/enel/frmREPCRESolicitud.action\"><i class=\"fa fa-circle-o\"></i> Solicitudes</a></li>\n" +
"                                <li><a href=\"/enel/frmREPCREDesembolso.action\"><i class=\"fa fa-circle-o\"></i> Desembolsos</a></li>\n" +
"                                <li><a href=\"/enel/frmREPCREPago.action\"><i class=\"fa fa-circle-o\"></i> Cobranzas</a></li>\n" +
"                            </ul>\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                </li>";
        return menuReportes;
    }

    public void setMenuReportes(String menuReportes) {
        this.menuReportes = menuReportes;
    }
}
