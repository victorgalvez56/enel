package com.softia.web.actions;

import com.opensymphony.xwork2.ActionContext;
import com.softia.beans.CCanales;
import com.softia.beans.CClientes;
import com.softia.beans.CCobranza;
import com.softia.beans.CCondiciones;
import com.softia.beans.CConfigCobranza;
import com.softia.beans.CCreditos;
import com.softia.beans.CDestinos;
import com.softia.beans.COficinas;
import com.softia.beans.CPerfiles;
import com.softia.beans.CProductos;
import com.softia.beans.CProfesiones;
import com.softia.beans.CTabla;
import com.softia.beans.CUsuarios;
import com.softia.models.Canal;
import com.softia.models.Cliente;
import com.softia.models.Cuenta;
import com.softia.models.Cobranza;
import com.softia.models.Condicion;
import com.softia.models.ConfigCobranza;
import com.softia.models.Credito;
import com.softia.models.Departamento;
import com.softia.models.Destino;
import com.softia.models.Direccion;
import com.softia.models.Distrito;
import com.softia.models.Log;
import com.softia.models.Oficina;
import com.softia.models.Perfil;
import com.softia.models.Producto;
import com.softia.models.Profesion;
import com.softia.models.Provincia;
import com.softia.models.Tabla;
import com.softia.models.TipoCliente;
import com.softia.models.Usuario;
import com.softia.web.models.Menu;
import com.softia.utils.LibFunc;
import com.softia.web.beans.CReporte;
import com.softia.web.beans.CReportePDF;
import com.softia.web.beans.CReporteXls;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cgp
 */
public class MenuAction extends BaseAction {

    private Usuario usuario;
    private String result;
    private Cliente cliente;
    private Cuenta cuenta;
    private List<Tabla> lstEstados;
    private List<Tabla> lstSexos;
    private List<Tabla> lstTipDocCiv;
    private List<Tabla> lstNivIns;
    private List<Tabla> lstTipZon;
    private List<Profesion> lstProfesiones;
    private int depart;
    private int provin;
    private String paramBusquedaCre;
    private String paramBusquedaCli;
    private String comentario;

    private List<TipoCliente> lstTiposCliente;

    private List<Tabla> lstTipoCobranza;
    private List<Tabla> lstTipoOrden;
    private List<Oficina> lstOficinas;
    private List<Perfil> lstPerfiles;
    private List<Destino> lstDestinos;
    private List<Condicion> lstCondiciones;
    private List<Producto> lstProductos;
    private List<Usuario> lstGestoresCobranza;
    private List<Credito> lstAsignados;
    private List<Cobranza> lstCobranza;
    private List<Cobranza> lstDetalleCobranza;
    private List<Cliente> lstClientes;
    private List<Credito> lstCreditos;
    private List<Usuario> lstUsuarios;
    private Oficina oficina;
    private Perfil perfil;
    private Condicion condicion;
    private Producto producto;
    private String accion;
    private File archivoUsuarios;
    private String archivoUsuariosFileName;
    private File archivoClientes;
    private String archivoClientesFileName;
    private File archivoCreditos;
    private String archivoCreditosFileName;
    private ConfigCobranza configCobranza;
    private int codigo;
    private String rutaReporte;
    private Credito credito;
    private Cobranza cobranza;
    private String tipoOrden;
    private String busqueda;
    private String datos;
    private List<String> lstOficina;
    private java.sql.Date FecmoraIni;
    private java.sql.Date FecmoraFin;

    private String codCta;
    private String fecIni;
    private String fecFin;
    private List<Log> lstLog;
    private String codigoVenta;
    private String suministro;
    private String direccion;
    private String distrito;
    private String provincia;
    private String estado;
    private List<Canal> lstCanales;
    private int codigoCanal;
    private String resultadoENEL;
    private String resultadoSENTINEL;
    private String fecha;

    private Menu menu;
    private String menuCompleto = "";
    private String menuClientes ="";
    private String menuCreditos = "";
    private String menuUsuarios = "";
    private String menuReportes = "";
/*
    private String menuClientes = "<li class=\"treeview\">\n"
            + "                    <a href=\"#\">\n"
            + "                        <i class=\"fa fa-copyright\"></i> <span>Clientes</span>\n"
            + "                        <span class=\"pull-right-container\">\n"
            + "                            <i class=\"fa fa-angle-left pull-right\"></i>\n"
            + "                        </span>\n"
            + "                    </a>\n"
            + "                    <ul class=\"treeview-menu\">\n"
            + "                        <li><a href=\"/enel/frmCLIMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Clientes</a></li>\n"
            + "                        <li><a href=\"/enel/frmCLIPosicion.action\"><i class=\"fa fa-circle-o\"></i> Créditos por Cliente</a></li>\n"
            + "                    </ul>\n"
            + "                </li>";
    private String menuCreditos = "<li class=\"treeview\">\n"
            + "                    <a href=\"#\">\n"
            + "                        <i class=\"fa fa-credit-card\"></i> <span>Créditos</span>\n"
            + "                        <span class=\"pull-right-container\">\n"
            + "                            <i class=\"fa fa-angle-left pull-right\"></i>\n"
            + "                        </span>\n"
            + "                    </a>\n"
            + "                    <ul class=\"treeview-menu\">\n"
            + "                        <li><a href=\"/enel/frmSOLMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Solicitudes</a></li>\n"
            + "                        <li><a href=\"/enel/frmCREMntAprobacion.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Aprobaciones</a></li>\n"
            + "                        <li><a href=\"/enel/frmCREMantenedor.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Créditos</a></li>\n"
            + "                        <li><a href=\"/enel/frmCREDocumentos.action\"><i class=\"fa fa-circle-o\"></i> Impresión de Documentos</a></li>\n"
            + "                        <li><a href=\"/enel/frmCREMovimientos.action\"><i class=\"fa fa-circle-o\"></i> Movimientos</a></li>\n"
            + "                    </ul>\n"
            + "                </li>";
    private String menuUsuarios = "<li class=\"treeview\">\n"
            + "                    <a href=\"#\">\n"
            + "                        <i class=\"fa fa-user\"></i> <span>Usuarios</span>\n"
            + "                        <span class=\"pull-right-container\">\n"
            + "                            <i class=\"fa fa-angle-left pull-right\"></i>\n"
            + "                        </span>\n"
            + "                    </a>\n"
            + "                    <ul class=\"treeview-menu\">\n"
            + "                        <li><a href=\"/enel/frmADMUsuarios.action\"><i class=\"fa fa-circle-o\"></i> Mantenedor de Usuarios</a></li>\n"
            + "                    </ul>\n"
            + "                </li>";
    private String menuReportes = "<li class=\"treeview\">\n"
            + "                    <a href=\"#\">\n"
            + "                        <i class=\"fa fa-archive\"></i> <span>Reportes</span>\n"
            + "                        <span class=\"pull-right-container\">\n"
            + "                            <i class=\"fa fa-angle-left pull-right\"></i>\n"
            + "                        </span>\n"
            + "                    </a>\n"
            + "                    <ul class=\"treeview-menu\">\n"
            + "                        <li><a href=\"/enel/frmREPCRECartera.action\"><i class=\"fa fa-circle-o\"></i> Cartera de Créditos</a></li>\n"
            + "                        <li><a href=\"/enel/frmREPCREMora.action\"><i class=\"fa fa-circle-o\"></i> Mora</a></li>\n"
            + "                        <li class=\"treeview\">\n"
            + "                            <a href=\"#\">\n"
            + "                                <i class=\"fa fa-circle-o\"></i> <span>Operaciones</span>\n"
            + "                                <span class=\"pull-right-container\">\n"
            + "                                    <i class=\"fa fa-angle-down\"></i>\n"
            + "                                </span>\n"
            + "                            </a>\n"
            + "                            <ul class=\"treeview-menu\">\n"
            + "                                <li><a href=\"/enel/frmREPCRESolicitud.action\"><i class=\"fa fa-circle-o\"></i> Solicitudes</a></li>\n"
            + "                                <li><a href=\"/enel/frmREPCREDesembolso.action\"><i class=\"fa fa-circle-o\"></i> Desembolsos</a></li>\n"
            + "                                <li><a href=\"/enel/frmREPCREPago.action\"><i class=\"fa fa-circle-o\"></i> Cobranzas</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                    </ul>\n"
            + "                </li>";
*/
    public String login() {
        setResult("login");
        return getResult();
    }

    public String pantallaPrincipal() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("bienvenido");
        setUsuario(new Usuario(1, "", ""));
        getUsuario().setCorreo(getSession().get("user").toString());
        getUsuario().setPasswd(getSession().get("pass").toString());
        CUsuarios loUsuario = new CUsuarios();
        loUsuario.setUsuario(getUsuario());
        loUsuario.setUser(getUsuario().getCorreo());
        loUsuario.setPasswd(getUsuario().getPasswd());
        try {
            setDatos(loUsuario.mxCargarDatos());
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }

    public String autenticar() {
        CUsuarios loUsuario = new CUsuarios();
        loUsuario.setUsuario(getUsuario());
        loUsuario.setUrl(getUrl());
        try {
            if (loUsuario.mxLogin()) {
                setSession(ActionContext.getContext().getSession());
                getSession().put("user", loUsuario.getUsuario().getCorreo());
                getSession().put("pass", loUsuario.getUsuario().getPasswd());
//                loUsuario.getUsuario().setEstado("1");
//                getSession().put("permission", loUsuario.getUsuario().getEstado());
                setMensaje(loUsuario.getMensaje());
                setResult("bienvenido");
            } else {
                setError(loUsuario.getError());
                setResult("login");
            }
        } catch (SQLException loErr) {
            setMensaje("");
            setError(loErr.getMessage());
            setResult("login");
        }
        return getResult();
    }

    public String frmCLIMantenedor() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
            } else {
                setLstSexos(loTabla.getLstTabla(3));
                if (getLstSexos() == null) {
                    setError(loTabla.getError());
                } else {
                    setLstTipDocCiv(loTabla.getLstTabla(4));
                    if (getLstTipDocCiv() == null) {
                        setError(loTabla.getError());
                    } else {
                        CProfesiones loProfesion = new CProfesiones();
                        loProfesion.setUrl(getUrl());
                        loProfesion.setUser(user);
                        loProfesion.setPasswd(pass);
                        setLstProfesiones(loProfesion.getLstProfesiones());
                        if (getLstProfesiones() == null) {
                            setError(loProfesion.getError());
                        } else {
                            setLstNivIns(loTabla.getLstTabla(5));
                            if (getLstNivIns() == null) {
                                setError(loTabla.getError());
                            } else {
                                setLstTipZon(loTabla.getLstTabla(6));
                                if (getLstTipZon() == null) {
                                    setError(loTabla.getError());
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscar") != null) {
                CClientes loCliente = new CClientes();
                getCliente().setDireccion(new Direccion());
                getCliente().getDireccion().setDistrito(new Distrito());
                getCliente().getDireccion().getDistrito().setProvincia(new Provincia());
                getCliente().getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    loCliente.setCodCta(getCodCta());
                    loCliente.setFecIni(getFecIni());
                    loCliente.setFecFin(getFecFin());
                    boolean llOk = loCliente.mxFiltrar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                setCliente(new Cliente());
                setMensaje("nuevo");
                return frmCLINuevoActualizar();
            } else if (request.getParameter("actualizar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
                setMensaje("actualizar");
                return frmCLINuevoActualizar();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CClientes loCliente = new CClientes();
                    getCliente().setDireccion(new Direccion());
                    getCliente().getDireccion().setDistrito(new Distrito());
                    getCliente().getDireccion().getDistrito().setProvincia(new Provincia());
                    getCliente().getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
                    loCliente.setCliente(getCliente());
                    loCliente.setUrl(getUrl());
                    loCliente.setUser(user);
                    loCliente.setPasswd(pass);
                    //BUSQUEDA
                    loCliente.setCodCta(getCodCta());
                    loCliente.setFecIni(getFecIni());
                    loCliente.setFecFin(getFecFin());
                    boolean llOk = loCliente.mxFiltrar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                        if (!(loRep.mxGenerarMntClientes(loCliente.getLstClientes()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"MantenedorCLI_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("posicion") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCLIPosicion();
            }
            setResult("frmCLIMantenedor");
        }
        return getResult();
    }

    public String frmSOLMantenedor() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
            } else {
                setLstSexos(loTabla.getLstTabla(3));
                if (getLstSexos() == null) {
                    setError(loTabla.getError());
                } else {
                    setLstTipDocCiv(loTabla.getLstTabla(4));
                    if (getLstTipDocCiv() == null) {
                        setError(loTabla.getError());
                    } else {
                        CProfesiones loProfesion = new CProfesiones();
                        loProfesion.setUrl(getUrl());
                        loProfesion.setUser(user);
                        loProfesion.setPasswd(pass);
                        setLstProfesiones(loProfesion.getLstProfesiones());
                        if (getLstProfesiones() == null) {
                            setError(loProfesion.getError());
                        } else {
                            setLstNivIns(loTabla.getLstTabla(5));
                            if (getLstNivIns() == null) {
                                setError(loTabla.getError());
                            } else {
                                setLstTipZon(loTabla.getLstTabla(6));
                                if (getLstTipZon() == null) {
                                    setError(loTabla.getError());
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    loCreditos.setFecIni(getFecIni());
                    loCreditos.setFecFin(getFecFin());
                    boolean llOk = loCreditos.mxFiltrar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                setCredito(new Credito());
                setMensaje("nuevo");
                return frmCRESolicitud();
            } else if (request.getParameter("aprobacion") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        llOk = loCredito.mxPlanPagos();
                        if (!llOk) {
                            setError(loCredito.getError());
                        } else {
                            setCredito(loCredito.getCredito());
                        }
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREAprobacion();
            } else if (request.getParameter("imprimir") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREDocumentos();
            } else if (request.getParameter("actualizar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxAplicar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREAnularSolicitud();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CCreditos loCreditos = new CCreditos();
                    loCreditos.setCredito(getCredito());
                    loCreditos.setUrl(getUrl());
                    loCreditos.setUser(user);
                    loCreditos.setPasswd(pass);
                    loCreditos.setFecIni(getFecIni());
                    loCreditos.setFecFin(getFecFin());
                    boolean llOk = loCreditos.mxFiltrar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        if (!(loRep.mxGenerarMntSoliciXls(loCreditos.getLstCreditos()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"Mantenedor_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("workflow") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxWorkFlow();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstLog(loCreditos.getLstLog());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmREPCREWorkflow();
            }
            setResult("frmSOLMantenedor");
        }
        return getResult();
    }

    public String frmCLINuevoActualizar() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
            } else {
                setLstSexos(loTabla.getLstTabla(3));
                if (getLstSexos() == null) {
                    setError(loTabla.getError());
                } else {
                    setLstTipDocCiv(loTabla.getLstTabla(4));
                    if (getLstTipDocCiv() == null) {
                        setError(loTabla.getError());
                    } else {
                        CProfesiones loProfesion = new CProfesiones();
                        loProfesion.setUrl(getUrl());
                        loProfesion.setUser(user);
                        loProfesion.setPasswd(pass);
                        setLstProfesiones(loProfesion.getLstProfesiones());
                        if (getLstProfesiones() == null) {
                            setError(loProfesion.getError());
                        } else {
                            setLstNivIns(loTabla.getLstTabla(5));
                            if (getLstNivIns() == null) {
                                setError(loTabla.getError());
                            } else {
                                setLstTipZon(loTabla.getLstTabla(6));
                                if (getLstTipZon() == null) {
                                    setError(loTabla.getError());
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nombre") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxGrabar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        return frmCRESolicitud();
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscarNombre") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 2);
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscarDNI") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 1);
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("consultaSumi") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxConsultaSuministro();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            }
            setResult("frmCLINuevoActualizar");
        }
        return getResult();
    }

    public String frmCLIPosicion() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        llOk = loCliente.mxCreditos();
                        if (!llOk) {
                            setError(loCliente.getError());
                        } else {
                            setCliente(loCliente.getCliente());
                        }
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscarNombre") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 2);
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscarDNI") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 1);
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("cancelar") != null) {
                cliente = new Cliente();
                cliente.setNombre("");
                cliente.setApePat("");
                cliente.setApeMat("");
            } else if (request.getParameter("reporte") != null) {
                CReportePDF loRep = new CReportePDF();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    loRep.setCliente(getCliente());
                    loRep.setUrl(getUrl());
                    loRep.setUser(user);
                    loRep.setPasswd(pass);
                    boolean llOk = loRep.mxPosicionCliente();
                    if (!llOk) {
                        setError(loRep.getError());
                    } else {
                        File file = new File(loRep.getRutaReporte());
                        byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                        FileUtils.writeByteArrayToFile(file, archivo);
                        HttpServletResponse response = ServletActionContext.getResponse();
                        response.setContentLength(archivo.length);
                        response.setContentType("application/pdf");
                        response.setHeader("Content-Disposition", "attachment; filename=\"posicionCliente_" + getCliente().getCodCli() + ".pdf\"");
                        ServletOutputStream out = response.getOutputStream();
                        out.write(archivo);
                        out.flush();
                    }
                } catch (IOException | SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("ver") != null) {
                String verCod = request.getParameter("ver"); 
                Credito cred = new Credito();
                cred.setCodCta(verCod);
                CCreditos loCredito = new CCreditos();
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                loCredito.setCredito(cred);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREMovimientos();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CClientes loCliente = new CClientes();
                    loCliente.setUrl(getUrl());
                    loCliente.setUser(user);
                    loCliente.setPasswd(pass);
                    loCliente.setCliente(getCliente());
                    boolean llOk = loCliente.mxCreditos();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        if (!(loRep.mxGenerarCliPosicion(loCliente.getCliente()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"PosicionCLI_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            }
            setResult("frmCLIPosicion");
        }
        return getResult();
    }

    public String frmCREMantenedor() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstTipDocCiv(loTabla.getLstTabla(4));
            if (getLstTipDocCiv() == null) {
                setError(loTabla.getError());
            } else {
                CCanales loCanal = new CCanales();
                loCanal.setUrl(getUrl());
                loCanal.setUser(user);
                loCanal.setPasswd(pass);
                setLstCanales(loCanal.getLstCanales());
                if (getLstCanales() == null) {
                    setError(loCanal.getError());
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxFiltrarAprobados();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("asignar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    loCreditos.setIp(getIp());
                    loCreditos.setCodigoVenta(getCodigoVenta());
                    loCreditos.setCodigoCanal(getCodigoCanal());
                    boolean llOk = loCreditos.mxAsignarVenta();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setMensaje(loCreditos.getMensaje());
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                setCredito(new Credito());
                setMensaje("nuevo");
                return frmCRESolicitud();
            } else if (request.getParameter("aprobar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxAprobar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("rechazar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxRechazar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("imprimir") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREDocumentos();
            } else if (request.getParameter("actualizar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxAplicar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREAnularSolicitud();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CCreditos loCreditos = new CCreditos();
                    loCreditos.setCredito(getCredito());
                    loCreditos.setUrl(getUrl());
                    loCreditos.setUser(user);
                    loCreditos.setPasswd(pass);
                    //setLstCreditos(loCreditos.getLstCreditos());
                    boolean llOk = loCreditos.mxFiltrarAprobados();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        if (!(loRep.mxGenerarMntCreditosXls(loCreditos.getLstCreditos()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"MantenedorCRE_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            }
            setResult("frmCREMantenedor");
        }
        return getResult();
    }

    public String frmCREDocumentos() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREDocumentos");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("nombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            loCliente.setCliente(getCredito().getCliente());
            try {
                boolean llOk = loCliente.mxAplicar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    getCredito().setCliente(loCliente.getCliente());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("solicitud") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxEvaluacionFinanciera();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"solicitud_" + getCredito().getCliente().getCodCli() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("calendarioPagos") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxCalendarioPagos();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"calendarioPagos_" + getCredito().getCodCta() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("planPagos") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxPlanPagos();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"planPagos_" + getCredito().getCodCta() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    public String frmCRESolicitud() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            //productos de credito
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            } else {
                CTabla loTabla = new CTabla();
                loTabla.setUrl(getUrl());
                loTabla.setUser(user);
                loTabla.setPasswd(pass);
                setLstTipDocCiv(loTabla.getLstTabla(4));
                if (getLstTipDocCiv() == null) {
                    setError(loTabla.getError());
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCRESolicitud");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("grabar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            getCredito().getCliente().setCodCli(getCliente().getCodCli());
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxGrabar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            loCliente.setCliente(getCliente());
            try {
                boolean llOk = loCliente.mxAplicar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setCliente(loCliente.getCliente());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("nombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            loCliente.setCliente(getCliente());
            try {
                boolean llOk = loCliente.mxAplicar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setCredito(new Credito());
                    getCredito().setDiaPag(loCliente.getDiaPag());
                    setCliente(loCliente.getCliente());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //ANULAR SOLICITUD
    public String frmCREAnularSolicitud() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            //productos de credito
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            } else {
                CTabla loTabla = new CTabla();
                loTabla.setUrl(getUrl());
                loTabla.setUser(user);
                loTabla.setPasswd(pass);
                setLstTipDocCiv(loTabla.getLstTabla(4));
                if (getLstTipDocCiv() == null) {
                    setError(loTabla.getError());
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREAnularSolicitud");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("aceptar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxRechazar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("desistir") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxDesistir();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("rechazar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxRechazar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //SUBMODULO CREDITO APROBACION DESEMBOLSO
    public String frmCREAprobacion() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREAprobacion");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    llOk = loCredito.mxPlanPagos();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("evaluar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    llOk = loCredito.mxPlanPagos();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                        llOk = loCredito.mxEvaluar();
                        if (llOk) {
                            setResultadoENEL(loCredito.getResultadoENEL());
                            setResultadoSENTINEL(loCredito.getResultadoSENTINEL());
                            setFecha(LibFunc.getFechaActual());
                            setComentario("");
                        } else {
                            setError(loCredito.getError());
                        }
                    }
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("revertir") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            loCredito.setComentario(getComentario());
            try {
                boolean llOk = loCredito.mxRevertir();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aprobar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            loCredito.setComentario(getComentario());
            try {
                boolean llOk = loCredito.mxAprobar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("rechazar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxRechazar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("enviar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxEnviar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //SUBMODULO REPORTE MORA
    public String frmCREMntAprobacion() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            //productos de credito
            setLstTipDocCiv(loTabla.getLstTabla(4));
            if (getLstTipDocCiv() == null) {
                setError(loTabla.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxFiltrarEnviados();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                setCredito(new Credito());
                setMensaje("nuevo");
                return frmCRESolicitud();
            } else if (request.getParameter("aprobar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxAprobar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("rechazar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxRechazar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("imprimir") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREDocumentos();
            } else if (request.getParameter("actualizar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxAplicar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREAnularSolicitud();
            } else if (request.getParameter("exportar") != null) {
                setCliente(new Cliente());
                return ("frmCLINuevoActualizar");
            } else if (request.getParameter("workflow") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxWorkFlow();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstLog(loCreditos.getLstLog());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmREPCREWorkflow();
            }
            setResult("frmCREMntAprobacion");
        }
        return getResult();
    }

    //WORKFLOW 
    public String frmREPCREWorkflow() {
        setResult("frmREPCREWorkflow");
        return getResult();
    }

    //MANTENIMIENTO USUARIOS
    public String frmADMUsuarios() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstTipDocCiv(loTabla.getLstTabla(4));
            if (getLstTipDocCiv() == null) {
                setError(loTabla.getError());
            } else {
                setLstEstados(loTabla.getLstTabla(1));
                if (getLstEstados() == null) {
                    setError(loTabla.getError());
                } else {
                    COficinas loOficina = new COficinas();
                    loOficina.setUrl(getUrl());
                    loOficina.setUser(getSession().get("user").toString());
                    loOficina.setPasswd(getSession().get("pass").toString());
                    setLstOficinas(loOficina.getLstOficinas());
                    if (getLstOficinas() == null) {
                        setResult("error");
                        setError(loOficina.getError());
                    } else {
                        CPerfiles loPerfil = new CPerfiles();
                        loPerfil.setUrl(getUrl());
                        loPerfil.setUser(getSession().get("user").toString());
                        loPerfil.setPasswd(getSession().get("pass").toString());
                        setLstPerfiles(loPerfil.getLstPerfiles());
                        if (getLstPerfiles() == null) {
                            setResult("error");
                            setError(loPerfil.getError());
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("buscar") != null) {
                CUsuarios loUsuario = new CUsuarios();
                loUsuario.setUrl(getUrl());
                loUsuario.setUser(user);
                loUsuario.setPasswd(pass);
                loUsuario.setUsuario(getUsuario());
                try {
                    loUsuario.setFecIni(getFecIni());
                    loUsuario.setFecFin(getFecFin());
                    boolean llOk = loUsuario.mxFiltrar();
                    if (!llOk) {
                        setError(loUsuario.getError());
                    } else {
                        setUsuario(loUsuario.getUsuario());
                        setLstUsuarios(loUsuario.getLstUsuarios());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                getUsuario().setCodUsu("");
                return frmADMNuevoUsuario();
            } else if (request.getParameter("editar") != null) {
                CUsuarios loUsuario = new CUsuarios();
                loUsuario.setUrl(getUrl());
                loUsuario.setUser(user);
                loUsuario.setPasswd(pass);
                loUsuario.setUsuario(getUsuario());
                try {
                    boolean llOk = loUsuario.mxAplicar();
                    if (!llOk) {
                        setError(loUsuario.getError());
                    } else {
                        setUsuario(loUsuario.getUsuario());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
                return frmADMNuevoUsuario();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CUsuarios loUsuario = new CUsuarios();
                    loUsuario.setUrl(getUrl());
                    loUsuario.setUser(user);
                    loUsuario.setPasswd(pass);
                    loUsuario.setUsuario(getUsuario());
                    //setLstCreditos(loCreditos.getLstCreditos());
                    loUsuario.setFecIni(getFecIni());
                    loUsuario.setFecFin(getFecFin());
                    boolean llOk = loUsuario.mxFiltrar();
                    if (!llOk) {
                        setError(loUsuario.getError());
                    } else {
                        setUsuario(loUsuario.getUsuario());
                        if (!(loRep.mxGenerarADMUsuario(loUsuario.getLstUsuarios()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"MantenedorUSU_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            }
            setResult("frmADMUsuarios");
        }
        return getResult();
    }

    /*
    if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            setLstTipDocCiv(loTabla.getLstTabla(4));
            if (getLstTipDocCiv() == null) {
                setError(loTabla.getError());
            } else {
                CCanales loCanal = new CCanales();
                loCanal.setUrl(getUrl());
                loCanal.setUser(user);
                loCanal.setPasswd(pass);
                setLstCanales(loCanal.getLstCanales());
                if (getLstCanales() == null) {
                    setError(loCanal.getError());                    
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            if (request.getParameter("aplicar") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setCliente(getCliente());
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxAplicar();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxFiltrarAprobados();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("asignar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    loCreditos.setIp(getIp());
                    loCreditos.setCodigoVenta(getCodigoVenta());
                    loCreditos.setCodigoCanal(getCodigoCanal());
                    boolean llOk = loCreditos.mxAsignarVenta();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setMensaje(loCreditos.getMensaje());
                        setCredito(loCreditos.getCredito());
                        setLstCreditos(loCreditos.getLstCreditos());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("nuevo") != null) {
                setCredito(new Credito());
                setMensaje("nuevo");
                return frmCRESolicitud();
            } else if (request.getParameter("aprobar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxAprobar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("rechazar") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    loCredito.setComentario(getComentario());
                    boolean llOk = loCredito.mxRechazar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setMensaje(loCredito.getMensaje());
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("imprimir") != null) {
                CCreditos loCredito = new CCreditos();
                loCredito.setCredito(getCredito());
                loCredito.setUrl(getUrl());
                loCredito.setUser(user);
                loCredito.setPasswd(pass);
                try {
                    boolean llOk = loCredito.mxAplicar();
                    if (!llOk) {
                        setError(loCredito.getError());
                    } else {
                        setCredito(loCredito.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREDocumentos();
            } else if (request.getParameter("actualizar") != null) {
                CCreditos loCreditos = new CCreditos();
                loCreditos.setCredito(getCredito());
                loCreditos.setUrl(getUrl());
                loCreditos.setUser(user);
                loCreditos.setPasswd(pass);
                try {
                    boolean llOk = loCreditos.mxAplicar();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                    }
                } catch (SQLException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
                return frmCREAnularSolicitud();
            } else if (request.getParameter("exportar") != null) {
                setSession(ActionContext.getContext().getSession());
                CReporteXls loRep = new CReporteXls();
                loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
                try {
                    CCreditos loCreditos = new CCreditos();
                    loCreditos.setCredito(getCredito());
                    loCreditos.setUrl(getUrl());
                    loCreditos.setUser(user);
                    loCreditos.setPasswd(pass);
                    //setLstCreditos(loCreditos.getLstCreditos());
                    boolean llOk = loCreditos.mxFiltrarAprobados();
                    if (!llOk) {
                        setError(loCreditos.getError());
                    } else {
                        setCredito(loCreditos.getCredito());
                        if (!(loRep.mxGenerarMntCreditosXls(loCreditos.getLstCreditos()))) {
                            setError(loRep.getError());
                        } else {
                            File file = new File(loRep.getRutaReporte());
                            byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                            FileUtils.writeByteArrayToFile(file, archivo);
                            HttpServletResponse response = ServletActionContext.getResponse();
                            response.setContentLength(archivo.length);
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "attachment; filename=\"MantenedorCRE_" + LibFunc.getFechaActual() + ".xls\"");
                            ServletOutputStream out = response.getOutputStream();
                            out.write(archivo);
                            out.flush();
                        }
                    }
                } catch (SQLException | IOException | ParseException loErr) {
                    setError(loErr.getMessage());
                }
            }
            setResult("frmCREMantenedor");
        }
     */
    //MANTENEDOR DE USUARIOS NUEVO
    public String frmADMNuevoUsuario() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CTabla loTabla = new CTabla();
        loTabla.setUrl(getUrl());
        loTabla.setUser(user);
        loTabla.setPasswd(pass);
        try {
            //productos de credito
            setLstTipDocCiv(loTabla.getLstTabla(4));
            if (getLstTipDocCiv() == null) {
                setError(loTabla.getError());
            } else {
                setLstEstados(loTabla.getLstTabla(1));
                if (getLstEstados() == null) {
                    setError(loTabla.getError());
                } else {
                    COficinas loOficina = new COficinas();
                    loOficina.setUrl(getUrl());
                    loOficina.setUser(getSession().get("user").toString());
                    loOficina.setPasswd(getSession().get("pass").toString());
                    setLstOficinas(loOficina.getLstOficinas());
                    if (getLstOficinas() == null) {
                        setResult("error");
                        setError(loOficina.getError());
                    } else {
                        CPerfiles loPerfil = new CPerfiles();
                        loPerfil.setUrl(getUrl());
                        loPerfil.setUser(getSession().get("user").toString());
                        loPerfil.setPasswd(getSession().get("pass").toString());
                        setLstPerfiles(loPerfil.getLstPerfiles());
                        if (getLstPerfiles() == null) {
                            setResult("error");
                            setError(loPerfil.getError());
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmADMNuevoUsuario");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("grabar") != null) {
            CUsuarios loUsuario = new CUsuarios();
            loUsuario.setUrl(getUrl());
            loUsuario.setUser(user);
            loUsuario.setPasswd(pass);
            loUsuario.setUsuario(getUsuario());
            try {
                boolean llOk = loUsuario.mxGrabar();
                if (!llOk) {
                    setError(loUsuario.getError());
                } else {
                    setUsuario(loUsuario.getUsuario());
                    setMensaje(loUsuario.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
            setResult("frmADMNuevoUsuario");
        }
        return getResult();
    }

    //SUBMODULO CREDITO IMPRESION DE DOCUMENTOS
    public String frmADMNevoUsuario() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREDocumentos");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("nombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            loCliente.setCliente(getCredito().getCliente());
            try {
                boolean llOk = loCliente.mxAplicar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    getCredito().setCliente(loCliente.getCliente());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("solicitud") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxEvaluacionFinanciera();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"solicitud_" + getCredito().getCliente().getCodCli() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("contrato") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxContratoFinanciamiento();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"contratoFinanciamiento_" + getCredito().getCliente().getCodCli() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("autorizacion") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxAutorizacionCobranza();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"autorizacionCobranza_" + getCredito().getCliente().getCodCli() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("pagare") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxPagareIncompleto();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"pagareIncompleto_" + getCredito().getCliente().getCodCli() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("calendarioPagos") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxCalendarioPagos();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"calendarioPagos_" + getCredito().getCodCta() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    public String frmCREMovimientos() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREMovimientos");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("nombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            loCliente.setCliente(getCredito().getCliente());
            try {
                boolean llOk = loCliente.mxAplicar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    getCredito().setCliente(loCliente.getCliente());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("kardex") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxKardex();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"detallePagos_" + getCredito().getCodCta() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("estadoCuenta") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCredito(getCredito());
                loRep.setUrl(getUrl());
                loRep.setUser(user);
                loRep.setPasswd(pass);
                boolean llOk = loRep.mxEstadoCuenta();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"detalleCuotas_" + getCredito().getCodCta() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("workflow") != null) {
            CCreditos loCreditos = new CCreditos();
            loCreditos.setCredito(getCredito());
            loCreditos.setUrl(getUrl());
            loCreditos.setUser(user);
            loCreditos.setPasswd(pass);
            try {
                boolean llOk = loCreditos.mxWorkFlow();
                if (!llOk) {
                    setError(loCreditos.getError());
                } else {
                    setCredito(loCreditos.getCredito());
                    setLstLog(loCreditos.getLstLog());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
            return frmREPCREWorkflow();
        }
        return getResult();
    }

    public String verCredito() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCREMovimientos");
        }
        CCreditos loCredito = new CCreditos();
        loCredito.setUrl(getUrl());
        loCredito.setUser(user);
        loCredito.setPasswd(pass);
        setCredito(new Credito());
        getCredito().setCodCta(getCodCta());
        loCredito.setCredito(getCredito());
        try {
            boolean llOk = loCredito.mxAplicar();
            if (!llOk) {
                setError(loCredito.getError());
            } else {
                setCredito(loCredito.getCredito());
            }
        } catch (SQLException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }

    //SUBMODULO CREDITO CAJA DESEMBOLSO
    public String frmCAJDesembolso() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCAJDesembolso");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    loCredito.getCredito().setNeto(loCredito.getCredito().getCapSol() - loCredito.getCredito().getInteres() - loCredito.getCredito().getOtros());
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("grabar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setIp(getIp());
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxDesembolsar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCAJPago() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        menuCompleto = getSession().get("menuCompleto").toString();
        CProductos loPro = new CProductos();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        try {
            setLstProductos(loPro.getLstProductos());
            if (getLstProductos() == null) {
                setError(loPro.getError());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            setResult("frmCAJPago");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("buscarNombre") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 2);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("buscarDNI") != null) {
            CClientes loCliente = new CClientes();
            loCliente.setUrl(getUrl());
            loCliente.setUser(user);
            loCliente.setPasswd(pass);
            try {
                String lcParam = "";
                if (!LibFunc.fxEmpty(getParamBusquedaCre())) {
                    lcParam = getParamBusquedaCre();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                } else if (!LibFunc.fxEmpty(getParamBusquedaCli())) {
                    lcParam = getParamBusquedaCli();
                }
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 1);
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setLstClientes(loCliente.getLstClientes());
                }
            } catch (SQLException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("aplicar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAplicar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(loCredito.getCredito());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("grabar") != null) {
            //mxPago
        }
        return getResult();
    }

    //SUBMODULO REPORTE MORA
    public String frmREPCREMora() {
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmREPCREMora");
        return getResult();
    }

    //SUBMODULO REPORTE CARTERA DE CREDITOS
    public String frmREPCRECartera() {
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmREPCRECartera");
        return getResult();
    }

    //PDF
    public String repCLICalendarioPagos() {
        setResult("repCLICalendarioPagos");
        return getResult();
    }

    public String generarCarteraXLS() {
        if (!validaSession()) {
            return "login";
        }/*
        setSession(ActionContext.getContext().getSession());
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxGenerarReporteCarteraXls();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"CARTERA_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }*/
        return frmREPCRECartera();
    }

    //SUBMODULO REPORTE DESEMBOLSOS
    public String frmREPCREDesembolso() {
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmREPCREDesembolso");
        return getResult();
    }

    public String generarOPEDesembolsoXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxgenerarOPEDesembolsoXLS();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"OPE_DES_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCRECartera();
    }

    //SUBMODULO REPORTE PAGOS-COBRANZAS
    public String frmREPCREPago() {
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmREPCREPago");
        return getResult();
    }

    public String generarOPEPagoXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxgenerarOPEPagoXLS();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"OPE_PAG_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCRECartera();
    }

    //SUBMODULO REPORTE SOLICITUDES
    public String frmREPCRESolicitud() {
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmREPCRESolicitud");
        return getResult();
    }

    public String generarSolicitudXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxgenerarSolicitudXLS();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"OPE_SOL_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCRECartera();
    }

    public String generarMoraXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxGenerarReporteMoraXls();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"MORA" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCREMora();
    }

    public String imprimirPDF() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CReporte loRep = new CReporte();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxGenerarReporte();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                //las FileUtils de Apache son dependencia de Struts 2
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"PRUEBA_" + LibFunc.getFechaActual() + ".pdf\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (IOException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCREMora();
    }

    public String generarXLS() {
        /*if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxGenerarReporteCarteraXls();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"CARTERA_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }*/

        return frmREPCRECartera();
    }

    public String frmSisMntOficinas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmSISMntOficinas");
        try {
            CTabla loTabla = new CTabla();
            loTabla.setUser(getSession().get("user").toString());
            loTabla.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
                setResult("error");
            } else {
                COficinas loOficina = new COficinas();
                loOficina.setUser(getSession().get("user").toString());
                loOficina.setPasswd(getSession().get("pass").toString());
                if (ActionContext.getContext().getParameters().get("boton.nuevo") != null) {
                    setOficina(new Oficina());
                    setInformacion("Ingrese Información y presione GRABAR");
                } else {
                    if (ActionContext.getContext().getParameters().get("boton.grabar") != null) {
                        loOficina.setOficina(getOficina());
                        boolean llOk = loOficina.mxGrabar();
                        if (llOk) {
                            setMensaje(loOficina.getMensaje());
                        } else {
                            setError(loOficina.getError());
                        }
                    } else {
                        if (ActionContext.getContext().getParameters().get("boton.buscar") != null) {
                            loOficina.setOficina(getOficina());
                            setLstOficinas(loOficina.mxBuscar());
                        } else {
                            if (ActionContext.getContext().getParameters().get("boton.aplicar") != null
                                    || ActionContext.getContext().getParameters().get("oficina.codOfi") != null) {
                                loOficina.setOficina(getOficina());
                                boolean llOk = loOficina.mxAplicar();
                                if (llOk) {
                                    setOficina(loOficina.getOficina());
                                } else {
                                    setError(loOficina.getError());
                                }
                            }
                        }
                    }
                }
                if (ActionContext.getContext().getParameters().get("boton.buscar") == null) {
                    setLstOficinas(loOficina.getLstOficinas());
                    if (getLstOficinas() == null) {
                        setError(loOficina.getError());
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmCreMntCondiciones() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCREMntCondiciones");
        try {
            CTabla loTabla = new CTabla();
            loTabla.setUser(getSession().get("user").toString());
            loTabla.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
                setResult("error");
            } else {
                CCondiciones loCondicion = new CCondiciones();
                loCondicion.setUser(getSession().get("user").toString());
                loCondicion.setPasswd(getSession().get("pass").toString());
                if (ActionContext.getContext().getParameters().get("boton.nuevo") != null) {
                    setCondicion(new Condicion());
                    setInformacion("Ingrese Información y presione GRABAR");
                } else {
                    if (ActionContext.getContext().getParameters().get("boton.grabar") != null) {
                        loCondicion.setCondicion(getCondicion());
                        boolean llOk = loCondicion.mxGrabar();
                        if (llOk) {
                            setMensaje(loCondicion.getMensaje());
                        } else {
                            setError(loCondicion.getError());
                        }
                    } else {
                        if (ActionContext.getContext().getParameters().get("boton.buscar") != null) {
                            loCondicion.setCondicion(getCondicion());
                            setLstCondiciones(loCondicion.mxBuscar());
                        } else {
                            if (ActionContext.getContext().getParameters().get("boton.aplicar") != null
                                    || ActionContext.getContext().getParameters().get("condicion.codCon") != null) {
                                loCondicion.setCondicion(getCondicion());
                                boolean llOk = loCondicion.mxAplicar();
                                if (llOk) {
                                    setCondicion(loCondicion.getCondicion());
                                } else {
                                    setError(loCondicion.getError());
                                }
                            }
                        }
                    }
                }
                if (ActionContext.getContext().getParameters().get("boton.buscar") == null) {
                    setLstCondiciones(loCondicion.getLstCondiciones());
                    if (getLstCondiciones() == null) {
                        setError(loCondicion.getError());
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmCreMntProductos() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCREMntProductos");
        try {
            CTabla loTabla = new CTabla();
            loTabla.setUser(getSession().get("user").toString());
            loTabla.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
                setResult("error");
            } else {
                CProductos loProducto = new CProductos();
                loProducto.setUser(getSession().get("user").toString());
                loProducto.setPasswd(getSession().get("pass").toString());
                if (ActionContext.getContext().getParameters().get("boton.nuevo") != null) {
                    setProducto(new Producto());
                    setInformacion("Ingrese Información y presione GRABAR");
                } else {
                    if (ActionContext.getContext().getParameters().get("boton.grabar") != null) {
                        loProducto.setProducto(getProducto());
                        boolean llOk = loProducto.mxGrabar();
                        if (llOk) {
                            setMensaje(loProducto.getMensaje());
                        } else {
                            setError(loProducto.getError());
                        }
                    } else {
                        if (ActionContext.getContext().getParameters().get("boton.buscar") != null) {
                            loProducto.setProducto(getProducto());
                            setLstProductos(loProducto.mxBuscar());
                        } else {
                            if (ActionContext.getContext().getParameters().get("boton.aplicar") != null
                                    || ActionContext.getContext().getParameters().get("producto.codPrd") != null) {
                                loProducto.setProducto(getProducto());
                                boolean llOk = loProducto.mxAplicar();
                                if (llOk) {
                                    setProducto(loProducto.getProducto());
                                } else {
                                    setError(loProducto.getError());
                                }
                            }
                        }
                    }
                }
                if (ActionContext.getContext().getParameters().get("boton.buscar") == null) {
                    setLstProductos(loProducto.getLstProductos());
                    if (getLstProductos() == null) {
                        setError(loProducto.getError());
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmSisCargarUsuarios() {
        setResult("frmSISCargarUsuarios");
        return getResult();
    }

    public String frmCliCargarClientes() {
        setResult("frmCLICargarClientes");
        return getResult();
    }

    public String frmCreCargarCreditos() {
        setResult("frmCRECargarCreditos");
        return getResult();
    }

    public String frmCobAsignar() {
        setResult("frmCOBAsignar");
        return getResult();
    }

    public String frmCobVerCredito() {
        setResult("frmCOBVerCredito");
        return getResult();
    }

    public String frmRepCobCompromisosPago() {
        setResult("frmREPCOBCompromisosPago");
        return getResult();
    }

    public String frmRepCobSeguimientoCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmREPCOBSeguimiento");
        CCobranza loCobranza = new CCobranza();
        try {
            loCobranza.setUser(getSession().get("user").toString());
            loCobranza.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            boolean llOk = loCobranza.mxSeguimiento();
            if (!llOk) {
                setError(loCobranza.getError());
                setResult("error");
            } else {
                setLstCobranza(loCobranza.getLstCobranza());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmEstCobEstados() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmESTCOBEstados");
        CCobranza loCobranza = new CCobranza();
        //try {
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        menuCompleto = getSession().get("menuCompleto").toString();
        setDatos(loCobranza.mxDatosEstado());
        /*} catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }*/
        return getResult();
    }

    public String frmEstCobResultados() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmESTCOBResultados");
        CCobranza loCobranza = new CCobranza();
        //try {
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        menuCompleto = getSession().get("menuCompleto").toString();
        setDatos(loCobranza.mxDatosHistoricos());
        /*} catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }*/
        return getResult();
    }

    public String frmEstCobOficinas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmESTCOBOficinas");
        CCobranza loCobranza = new CCobranza();
        //try {
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        menuCompleto = getSession().get("menuCompleto").toString();
        setDatos(loCobranza.mxDatosOficinas());
        /*} catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }*/
        return getResult();
    }

    public String frmEstCobPagos() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmESTCOBPagos");
        CCobranza loCobranza = new CCobranza();
        //try {
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        menuCompleto = getSession().get("menuCompleto").toString();
        setDatos(loCobranza.mxDatosRecuperacion());
        /*} catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }*/
        return getResult();
    }

    public String frmRepCobRecuperacion() {
        setResult("frmREPCOBRecuperacion");
        return getResult();
    }

    public String frmCobProgramarVisitas() {
        try {
            if (!validaSession()) {
                LibFunc.mxLog("Session inválida");
                return "login";
            } else {
                LibFunc.mxLog("Session vàlida");
            }
        } catch (IOException loErr) {
            setError(loErr.getMessage());
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCOBProgramarVisitas");
        CCobranza loCobranza = new CCobranza();
        try {
            loCobranza.setUser(getSession().get("user").toString());
            loCobranza.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            loCobranza.setTipoOrden(getTipoOrden());
            boolean llOk = loCobranza.mxAsignados();
            if (!llOk) {
                setError(loCobranza.getError());
                setResult("error");
            } else {
                setLstAsignados(loCobranza.getLstAsignados());
                setLstTipoOrden(new ArrayList<>());
                Tabla tabla = new Tabla();
                tabla.setCodigo("01");
                tabla.setDescripcion("Saldo");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("02");
                tabla.setDescripcion("Atraso");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("03");
                tabla.setDescripcion("Condicion");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("04");
                tabla.setDescripcion("Provision");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("05");
                tabla.setDescripcion("Alineamiento Interno");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("06");
                tabla.setDescripcion("Alineamiento Externo");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("07");
                tabla.setDescripcion("Sobreendeudamiento");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("08");
                tabla.setDescripcion("Provision Acelerada");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("09");
                tabla.setDescripcion("Producto");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("10");
                tabla.setDescripcion("Producto SBS");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("11");
                tabla.setDescripcion("Cuotas pagadas");
                getLstTipoOrden().add(tabla);
                tabla = new Tabla();
                tabla.setCodigo("12");
                tabla.setDescripcion("Priorizacion");
                getLstTipoOrden().add(tabla);
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmCobRegistrarLlamadas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCOBRegistrarLlamadas");
        CCobranza loCobranza = new CCobranza();
        try {
            loCobranza.setUser(getSession().get("user").toString());
            loCobranza.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            loCobranza.setTipoOrden(getTipoOrden());
            boolean llOk = loCobranza.mxLlamadas();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                CTabla loTabla = new CTabla();
                loTabla.setUser(getSession().get("user").toString());
                loTabla.setPasswd(getSession().get("pass").toString());
                setLstTipoCobranza(loTabla.getLstTabla(3, "T"));
                if (getLstTipoCobranza() == null) {
                    setResult("error");
                    setError(loTabla.getError());
                } else {
                    setLstAsignados(loCobranza.getLstAsignados());
                    setLstTipoOrden(new ArrayList<>());
                    Tabla tabla = new Tabla();
                    tabla.setCodigo("01");
                    tabla.setDescripcion("Saldo");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("02");
                    tabla.setDescripcion("Atraso");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("03");
                    tabla.setDescripcion("Condicion");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("04");
                    tabla.setDescripcion("Provision");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("05");
                    tabla.setDescripcion("Alineamiento Interno");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("06");
                    tabla.setDescripcion("Alineamiento Externo");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("07");
                    tabla.setDescripcion("Sobreendeudamiento");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("08");
                    tabla.setDescripcion("Provision Acelerada");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("09");
                    tabla.setDescripcion("Producto");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("10");
                    tabla.setDescripcion("Producto SBS");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("11");
                    tabla.setDescripcion("Cuotas pagadas");
                    getLstTipoOrden().add(tabla);
                    tabla = new Tabla();
                    tabla.setCodigo("12");
                    tabla.setDescripcion("Priorizacion");
                    getLstTipoOrden().add(tabla);
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmCobRegistrarVisitas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCOBRegistrarVisitas");
        CCobranza loCobranza = new CCobranza();
        try {
            loCobranza.setUser(getSession().get("user").toString());
            loCobranza.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            boolean llOk = loCobranza.mxProgramados();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                setLstAsignados(loCobranza.getLstAsignados());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }

    public String frmCobImprimeCartas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        setResult("frmCOBImprimeCartas");
        CCobranza loCobranza = new CCobranza();
        try {
            loCobranza.setUser(getSession().get("user").toString());
            loCobranza.setPasswd(getSession().get("pass").toString());
            menuCompleto = getSession().get("menuCompleto").toString();
            boolean llOk = loCobranza.mxProgramados();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                setLstAsignados(loCobranza.getLstAsignados());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmCobParametrizar() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        setResult("frmCOBParametrizar");
        CUsuarios loUsuario = new CUsuarios();
        try {
            loUsuario.setUser(getSession().get("user").toString());
            loUsuario.setPasswd(getSession().get("pass").toString());
            loUsuario.mxGestoresCobranza();
            setLstGestoresCobranza(loUsuario.getLstGestoresCobranza());
            if (getLstGestoresCobranza() == null) {
                setResult("error");
                setError(loUsuario.getError());
            } else {
                COficinas loOficina = new COficinas();
                loOficina.setUser(getSession().get("user").toString());
                loOficina.setPasswd(getSession().get("pass").toString());
                setLstOficinas(loOficina.getLstOficinas());
                if (getLstOficinas() == null) {
                    setResult("error");
                    setError(loOficina.getError());
                } else {
                    CDestinos loDestino = new CDestinos();
                    loDestino.setUser(getSession().get("user").toString());
                    loDestino.setPasswd(getSession().get("pass").toString());
                    setLstDestinos(loDestino.getLstDestinos());
                    if (getLstDestinos() == null) {
                        setResult("error");
                        setError(loDestino.getError());
                    } else {
                        CCondiciones loCondicion = new CCondiciones();
                        loCondicion.setUser(getSession().get("user").toString());
                        loCondicion.setPasswd(getSession().get("pass").toString());
                        setLstCondiciones(loCondicion.getLstCondiciones());
                        if (getLstCondiciones() == null) {
                            setResult("error");
                            setError(loCondicion.getError());
                        } else {
                            CProductos loProducto = new CProductos();
                            loProducto.setUser(getSession().get("user").toString());
                            loProducto.setPasswd(getSession().get("pass").toString());
                            setLstProductos(loProducto.getLstProductos());
                            if (getLstProductos() == null) {
                                setResult("error");
                                setError(loProducto.getError());
                            } else {
                                if (getConfigCobranza() == null) {
                                    setConfigCobranza(new ConfigCobranza());
                                    getConfigCobranza().setUsuario(new Usuario(1, "", ""));
                                }
                                CConfigCobranza loConfig = new CConfigCobranza();
                                loConfig.setUser(getSession().get("user").toString());
                                loConfig.setPasswd(getSession().get("pass").toString());
                                loConfig.setConfiguracion(getConfigCobranza());
                                loConfig.mxAplicar();
                                setConfigCobranza(loConfig.getConfiguracion());
                            }
                        }
                    }
                }
            }
        } catch (SQLException loErr) {
            setResult("error");
            setError(loErr.getMessage());
        }
        return getResult();
    }

    public String frmRegistrarVisitaCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setResult("frmCOBRegistrarVisitas");
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        try {
            boolean llOk = loCobranza.mxConsultar();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                CTabla loTabla = new CTabla();
                loTabla.setUser(getSession().get("user").toString());
                loTabla.setPasswd(getSession().get("pass").toString());
                setLstTipoCobranza(loTabla.getLstTabla(3, "C"));
                if (getLstTipoCobranza() == null) {
                    setError(loTabla.getError());
                } else {
                    setMensaje(loCobranza.getMensaje());
                    setResult("frmCOBRegistrarVisita");
                    setCredito(loCobranza.getCredito());
                    setLstDetalleCobranza(loCobranza.getLstCobranza());
                }
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }

    public String frmCobRegistrarCompromiso() {
        if (!validaSession()) {
            return "login";
        }
        setResult("frmCOBRegistrarCompromiso");
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        try {
            boolean llOk = loCobranza.mxConsultar();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                CTabla loTabla = new CTabla();
                loTabla.setUser(getSession().get("user").toString());
                loTabla.setPasswd(getSession().get("pass").toString());
                setLstTipoCobranza(loTabla.getLstTabla(3));
                if (getLstTipoCobranza() == null) {
                    setError(loTabla.getError());
                } else {
                    setMensaje(loCobranza.getMensaje());
                    setResult("frmCOBRegistrarCompromiso");
                    setCredito(loCobranza.getCredito());
                    setLstDetalleCobranza(loCobranza.getLstCobranza());
                }
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }

    public String programarVisitaCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        try {
            boolean llOk = loCobranza.mxProgramar();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                setMensaje(loCobranza.getMensaje());
                setRutaReporte(loCobranza.getRutaReporte());
                /*
                File file = new File("/ftia/files/cartas/" + loCobranza.getCodCre() + "_COB.pdf");
                byte[] result = null;
                result = IOUtils.toByteArray(new FileInputStream(file));
                        //las FileUtils de Apache son dependencia de Struts 2
                FileUtils.writeByteArrayToFile(file, result);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(result.length);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + loCobranza.getCodCre() + "_COB.pdf\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(result);
                out.flush();
                 */
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobProgramarVisitas();
    }

    public String registraVisita() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        getCobranza().setCredito(new Credito());
        getCobranza().getCredito().setCodigo(getCredito().getCodigo());
        loCobranza.setCobranza(getCobranza());
        try {
            boolean llOk = loCobranza.mxRegistrar();
            if (!llOk) {
                setError(loCobranza.getError());
                setCodigo(getCredito().getCodigo());
                return frmRegistrarVisitaCobranza();
            } else {
                setMensaje(loCobranza.getMensaje());
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobRegistrarVisitas();
    }

    /*
    public String registraCompromiso() {
        if (!validaSession()) {
            return "login";
        }
        setResult("frmCOBRegistrarCompromiso");
        setSession(ActionContext.getContext().getSession());
        CTabla loTabla = new CTabla();
        loTabla.setUser(getSession().get("user").toString());
        loTabla.setPasswd(getSession().get("pass").toString());
        try {
            setLstTipoCobranza(loTabla.getLstTabla(3));
            if (getLstTipoCobranza() == null) {
                setError(loTabla.getError());
            } else {
                if (ServletActionContext.getRequest().getParameter("buscarNombre") != null) {
                    CClientes loCliente = new CClientes();
                    loCliente.setUser(getSession().get("user").toString());
                    loCliente.setPasswd(getSession().get("pass").toString());
                    boolean llOk = loCliente.mxBuscar(getBusqueda(), 2);
                    if (llOk) {
                        setLstClientes(loCliente.getLstClientes());
                    } else {
                        setError(loCliente.getError());
                    }
                } else if (ServletActionContext.getRequest().getParameter("buscarDNI") != null) {
                    CClientes loCliente = new CClientes();
                    boolean llOk = loCliente.mxBuscar(getBusqueda(), 1);
                    if (llOk) {
                        setLstClientes(loCliente.getLstClientes());
                    } else {
                        setError(loCliente.getError());
                    }
                } else if (ServletActionContext.getRequest().getParameter("aplicar") != null) {
                    CCobranza loCobranza = new CCobranza();
                    loCobranza.setUser(getSession().get("user").toString());
                    loCobranza.setPasswd(getSession().get("pass").toString());
                    loCobranza.setCredito(getCredito());
                    boolean llOk = loCobranza.mxConsultar();
                    if (!llOk) {
                        setError(loCobranza.getError());
                    } else {
                        setMensaje(loCobranza.getMensaje());
                        setCredito(loCobranza.getCredito());
                        setLstDetalleCobranza(loCobranza.getLstCobranza());
                    }
                } else if (ServletActionContext.getRequest().getParameter("grabar") != null) {
                    CCobranza loCobranza = new CCobranza();
                    loCobranza.setUser(getSession().get("user").toString());
                    loCobranza.setPasswd(getSession().get("pass").toString());
                    getCobranza().setCredito(new Credito());
                    getCobranza().getCredito().setCodigo(getCredito().getCodigo());
                    loCobranza.setCobranza(getCobranza());
                    boolean llOk = loCobranza.mxRegistrar();
                    if (!llOk) {
                        setError(loCobranza.getError());
                        setCodigo(getCredito().getCodigo());
                    } else {
                        setMensaje(loCobranza.getMensaje());
                        loCobranza.setCredito(getCredito());
                        llOk = loCobranza.mxConsultar();
                        if (!llOk) {
                            setError(loCobranza.getError());
                        } else {
                            setCredito(loCobranza.getCredito());
                            setLstDetalleCobranza(loCobranza.getLstCobranza());
                        }
                    }
                } else {
                }
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return getResult();
    }
     */
    public String registraLlamada() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        getCobranza().setCredito(new Credito());
        getCobranza().getCredito().setCodigo(getCredito().getCodigo());
        getCobranza().setFecVis(LibFunc.getFechaActual());
        loCobranza.setCobranza(getCobranza());
        try {
            boolean llOk = loCobranza.mxRegistrar();
            setCobranza(null);
            if (!llOk) {
                setError(loCobranza.getError());
                setCodigo(getCredito().getCodigo());
            } else {
                setMensaje(loCobranza.getMensaje());
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobRegistrarLlamadas();
    }

    public String imprimirCartaCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        try {
            boolean llOk = loCobranza.mxGenerarCarta();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                File file = new File("/ftia/files/cartas/" + loCobranza.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                //las FileUtils de Apache son dependencia de Struts 2
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + loCobranza.getCodCre() + "_COB.pdf\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobImprimeCartas();
    }

    public String imprimirCartasCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loCobranza.mxGenerarCartas();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                File file = new File(loCobranza.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                //las FileUtils de Apache son dependencia de Struts 2
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"CARTAS_" + LibFunc.getFechaActual() + ".pdf\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobImprimeCartas();
    }

    public String reporteVisitas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        try {
            boolean llOk = loCobranza.mxReporteVisitas();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
//                setMensaje(loCobranza.getMensaje());
//                setRutaReporte(loCobranza.getRutaReporte());
                File file = new File(loCobranza.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                //las FileUtils de Apache son dependencia de Struts 2
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"REPVIS_" + LibFunc.getFechaActual() + ".pdf\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobProgramarVisitas();
    }

    public String reporteCompromisosPago() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        loCobranza.setCobranza(getCobranza());
        try {
            boolean llOk;
            if (ActionContext.getContext().getParameters().get("Excel") != null) {
                llOk = loCobranza.mxReporteCompromisosXls();
            } else {
                llOk = loCobranza.mxReporteCompromisos();
            }
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                File file = new File(loCobranza.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                if (ActionContext.getContext().getParameters().get("Excel") != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment; filename=\"REPCOM_" + LibFunc.getFechaActual() + ".xls\"");
                } else {
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"REPCOM_" + LibFunc.getFechaActual() + ".pdf\"");
                }
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmRepCobCompromisosPago();
    }

    public String reporteRecuperacion() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        loCobranza.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        loCobranza.setCodigo(getCodigo());
        loCobranza.setCobranza(getCobranza());
        try {
            boolean llOk;
            if (ActionContext.getContext().getParameters().get("Excel") != null) {
                llOk = loCobranza.mxReporteRecuperacionXls();
            } else {
                llOk = loCobranza.mxReporteRecuperacion();
            }
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                File file = new File(loCobranza.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                if (ActionContext.getContext().getParameters().get("Excel") != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment; filename=\"REPREC_" + LibFunc.getFechaActual() + ".xls\"");
                } else {
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"REPREC_" + LibFunc.getFechaActual() + ".pdf\"");
                }
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmRepCobRecuperacion();
    }

    public String cargarUsuarios() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        if (LibFunc.fxEmpty(getArchivoUsuariosFileName())) {
            setError("Debe seleccionar archivo de usuarios");
        }
        if (LibFunc.fxEmpty(getError())) {
            CUsuarios loUsuario = new CUsuarios();
            loUsuario.setUser(getSession().get("user").toString());
            loUsuario.setPasswd(getSession().get("pass").toString());
            loUsuario.setArchivo(getArchivoUsuarios());
            loUsuario.setArchivoFileName(getArchivoUsuariosFileName());
            try {
                boolean llOk = loUsuario.mxCargar();
                if (!llOk) {
                    setError(loUsuario.getError());
                } else {
                    setMensaje(loUsuario.getMensaje());
                }
            } catch (IOException | SQLException loErr) {
                setError(loErr.getMessage());
            }
        }
        return frmSisCargarUsuarios();
    }

    public String cargarClientes() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        if (LibFunc.fxEmpty(getArchivoClientesFileName())) {
            setError("Debe seleccionar archivo de clientes");
        }
        if (LibFunc.fxEmpty(getError())) {
            CClientes loCliente = new CClientes();
            loCliente.setUser(getSession().get("user").toString());
            loCliente.setPasswd(getSession().get("pass").toString());
            loCliente.setArchivo(getArchivoClientes());
            loCliente.setArchivoFileName(getArchivoClientesFileName());
            try {
                boolean llOk = loCliente.mxCargar();
                if (!llOk) {
                    setError(loCliente.getError());
                } else {
                    setMensaje(loCliente.getMensaje());
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return frmCliCargarClientes();
    }

    public String cargarCreditos() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        if (LibFunc.fxEmpty(getArchivoCreditosFileName())) {
            setError("Debe seleccionar archivo de créditos");
        }
        if (LibFunc.fxEmpty(getError())) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUser(getSession().get("user").toString());
            loCredito.setPasswd(getSession().get("pass").toString());
            loCredito.setArchivo(getArchivoCreditos());
            loCredito.setArchivoFileName(getArchivoCreditosFileName());
            try {
                boolean llOk = loCredito.mxCargar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (IOException | SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return frmCreCargarCreditos();
    }

    public String parametrizaCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CConfigCobranza loConfiguracion = new CConfigCobranza();
        loConfiguracion.setUser(getSession().get("user").toString());
        loConfiguracion.setPasswd(getSession().get("pass").toString());
        loConfiguracion.setConfiguracion(getConfigCobranza());
        try {
            boolean llOk = loConfiguracion.mxGrabar();
            if (!llOk) {
                setError(loConfiguracion.getError());
            }
        } catch (SQLException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobParametrizar();
    }

    public String asignaCobranza() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        menuCompleto = getSession().get("menuCompleto").toString();
        CCobranza loCobranza = new CCobranza();
        loCobranza.setUser(getSession().get("user").toString());
        loCobranza.setPasswd(getSession().get("pass").toString());
        try {
            boolean llOk = loCobranza.mxAsignar();
            if (!llOk) {
                setError(loCobranza.getError());
            } else {
                setMensaje(loCobranza.getMensaje());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        return frmCobAsignar();
    }

    public String desplegarDireccion() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();

        Cliente sumi = new Cliente();
        sumi.setSumini(getSuministro());
        sumi.setDireccion(new Direccion());
        sumi.getDireccion().setDistrito(new Distrito());
        sumi.getDireccion().getDistrito().setProvincia(new Provincia());
        sumi.getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
        CClientes loClientes = new CClientes();
        loClientes.setCliente(sumi);
        loClientes.setUrl(getUrl());
        loClientes.setUser(user);
        loClientes.setPasswd(pass);
        try {
            boolean llOk = loClientes.mxConsultaSuministro();
            if (!llOk) {
                setError(loClientes.getError());
            } else {
                String direccion;
                direccion = loClientes.getCliente().getDireccion().getDireccion();

                //getCliente().getDireccion().setDireccion(loClientes.getCliente().getDireccion().getDireccion());
                /*setDireccion(loClientes.getCliente().getDireccion().getDireccion());
                setDistrito(loClientes.getCliente().getDireccion().getDistrito().getNombre());
                setProvincia(loClientes.getCliente().getDireccion().getDistrito().getProvincia().getNombre());
                setEstado(loClientes.getCliente().getEstado());*/
            }
        } catch (SQLException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return "DIRECCION";
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the lstEstados
     */
    public List<Tabla> getLstEstados() {
        return lstEstados;
    }

    /**
     * @param lstEstados the lstEstados to set
     */
    public void setLstEstados(List<Tabla> lstEstados) {
        this.lstEstados = lstEstados;
    }

    /**
     * @return the oficina
     */
    public Oficina getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    /**
     * @return the lstOficinas
     */
    public List<Oficina> getLstOficinas() {
        return lstOficinas;
    }

    /**
     * @param lstOficinas the lstOficinas to set
     */
    public void setLstOficinas(List<Oficina> lstOficinas) {
        this.lstOficinas = lstOficinas;
    }

    /**
     * @return the Perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param Perfil the Perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the lstPerfil
     */
    public List<Perfil> getLstPerfiles() {
        return lstPerfiles;
    }

    /**
     * @param lstPerfil the lstPerfil to set
     */
    public void setLstPerfiles(List<Perfil> lstPerfiles) {
        this.lstPerfiles = lstPerfiles;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the condicion
     */
    public Condicion getCondicion() {
        return condicion;
    }

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    /**
     * @return the lstCondiciones
     */
    public List<Condicion> getLstCondiciones() {
        return lstCondiciones;
    }

    /**
     * @param lstCondiciones the lstCondiciones to set
     */
    public void setLstCondiciones(List<Condicion> lstCondiciones) {
        this.lstCondiciones = lstCondiciones;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the lstProductos
     */
    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    /**
     * @param lstProductos the lstProductos to set
     */
    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    /**
     * @return the archivoUsuarios
     */
    public File getArchivoUsuarios() {
        return archivoUsuarios;
    }

    /**
     * @param archivoUsuarios the archivoUsuarios to set
     */
    public void setArchivoUsuarios(File archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

    /**
     * @return the archivoUsuariosFileName
     */
    public String getArchivoUsuariosFileName() {
        return archivoUsuariosFileName;
    }

    /**
     * @param archivoUsuariosFileName the archivoUsuariosFileName to set
     */
    public void setArchivoUsuariosFileName(String archivoUsuariosFileName) {
        this.archivoUsuariosFileName = archivoUsuariosFileName;
    }

    /**
     * @return the archivoCreditos
     */
    public File getArchivoCreditos() {
        return archivoCreditos;
    }

    /**
     * @param archivoCreditos the archivoCreditos to set
     */
    public void setArchivoCreditos(File archivoCreditos) {
        this.archivoCreditos = archivoCreditos;
    }

    /**
     * @return the archivoCreditosFileName
     */
    public String getArchivoCreditosFileName() {
        return archivoCreditosFileName;
    }

    /**
     * @param archivoCreditosFileName the archivoCreditosFileName to set
     */
    public void setArchivoCreditosFileName(String archivoCreditosFileName) {
        this.archivoCreditosFileName = archivoCreditosFileName;
    }

    /**
     * @return the archivoClientes
     */
    public File getArchivoClientes() {
        return archivoClientes;
    }

    /**
     * @param archivoClientes the archivoClientes to set
     */
    public void setArchivoClientes(File archivoClientes) {
        this.archivoClientes = archivoClientes;
    }

    /**
     * @return the archivoClientesFileName
     */
    public String getArchivoClientesFileName() {
        return archivoClientesFileName;
    }

    /**
     * @param archivoClientesFileName the archivoClientesFileName to set
     */
    public void setArchivoClientesFileName(String archivoClientesFileName) {
        this.archivoClientesFileName = archivoClientesFileName;
    }

    /**
     * @return the lstGestoresCobranza
     */
    public List<Usuario> getLstGestoresCobranza() {
        return lstGestoresCobranza;
    }

    /**
     * @param lstGestoresCobranza the lstGestoresCobranza to set
     */
    public void setLstGestoresCobranza(List<Usuario> lstGestoresCobranza) {
        this.lstGestoresCobranza = lstGestoresCobranza;
    }

    /**
     * @return the lstDestinos
     */
    public List<Destino> getLstDestinos() {
        return lstDestinos;
    }

    /**
     * @param lstDestinos the lstDestinos to set
     */
    public void setLstDestinos(List<Destino> lstDestinos) {
        this.lstDestinos = lstDestinos;
    }

    /**
     * @return the configCobranza
     */
    public ConfigCobranza getConfigCobranza() {
        return configCobranza;
    }

    /**
     * @param configCobranza the configCobranza to set
     */
    public void setConfigCobranza(ConfigCobranza configCobranza) {
        this.configCobranza = configCobranza;
    }

    /**
     * @return the lstAsignados
     */
    public List<Credito> getLstAsignados() {
        return lstAsignados;
    }

    /**
     * @param lstAsignados the lstAsignados to set
     */
    public void setLstAsignados(List<Credito> lstAsignados) {
        this.lstAsignados = lstAsignados;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the rutaReporte
     */
    public String getRutaReporte() {
        return rutaReporte;
    }

    /**
     * @param rutaReporte the rutaReporte to set
     */
    public void setRutaReporte(String rutaReporte) {
        this.rutaReporte = rutaReporte;
    }

    /**
     * @return the lstTipoCobranza
     */
    public List<Tabla> getLstTipoCobranza() {
        return lstTipoCobranza;
    }

    /**
     * @param lstTipoCobranza the lstTipoCobranza to set
     */
    public void setLstTipoCobranza(List<Tabla> lstTipoCobranza) {
        this.lstTipoCobranza = lstTipoCobranza;
    }

    /**
     * @return the credito
     */
    public Credito getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    /**
     * @return the cobranza
     */
    public Cobranza getCobranza() {
        return cobranza;
    }

    /**
     * @param cobranza the cobranza to set
     */
    public void setCobranza(Cobranza cobranza) {
        this.cobranza = cobranza;
    }

    /**
     * @return the lstDetalleCobranza
     */
    public List<Cobranza> getLstDetalleCobranza() {
        return lstDetalleCobranza;
    }

    /**
     * @param lstDetalleCobranza the lstDetalleCobranza to set
     */
    public void setLstDetalleCobranza(List<Cobranza> lstDetalleCobranza) {
        this.lstDetalleCobranza = lstDetalleCobranza;
    }

    /**
     * @return the lstTipoOrden
     */
    public List<Tabla> getLstTipoOrden() {
        return lstTipoOrden;
    }

    /**
     * @param lstTipoOrden the lstTipoOrden to set
     */
    public void setLstTipoOrden(List<Tabla> lstTipoOrden) {
        this.lstTipoOrden = lstTipoOrden;
    }

    /**
     * @return the tipoOrden
     */
    public String getTipoOrden() {
        return tipoOrden;
    }

    /**
     * @param tipoOrden the tipoOrden to set
     */
    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    /**
     * @return the lstCobranza
     */
    public List<Cobranza> getLstCobranza() {
        return lstCobranza;
    }

    /**
     * @param lstCobranza the lstCobranza to set
     */
    public void setLstCobranza(List<Cobranza> lstCobranza) {
        this.lstCobranza = lstCobranza;
    }

    /**
     * @return the lstClientes
     */
    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    /**
     * @param lstClientes the lstClientes to set
     */
    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    /**
     * @return the busqueda
     */
    public String getBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * @return the datos
     */
    public String getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the lstTiposCliente
     */
    public List<TipoCliente> getLstTiposCliente() {
        return lstTiposCliente;
    }

    /**
     * @param lstTiposCliente the lstTiposCliente to set
     */
    public void setLstTiposCliente(List<TipoCliente> lstTiposCliente) {
        this.lstTiposCliente = lstTiposCliente;
    }

    /**
     * @return the lstSexos
     */
    public List<Tabla> getLstSexos() {
        return lstSexos;
    }

    /**
     * @param lstSexos the lstSexos to set
     */
    public void setLstSexos(List<Tabla> lstSexos) {
        this.lstSexos = lstSexos;
    }

    /**
     * @return the lstTipDocCiv
     */
    public List<Tabla> getLstTipDocCiv() {
        return lstTipDocCiv;
    }

    /**
     * @param lstTipDocCiv the lstTipDocCiv to set
     */
    public void setLstTipDocCiv(List<Tabla> lstTipDocCiv) {
        this.lstTipDocCiv = lstTipDocCiv;
    }

    /**
     * @return the depart
     */
    public int getDepart() {
        return depart;
    }

    /**
     * @param depart the depart to set
     */
    public void setDepart(int depart) {
        this.depart = depart;
    }

    /**
     * @return the provin
     */
    public int getProvin() {
        return provin;
    }

    /**
     * @param provin the provin to set
     */
    public void setProvin(int provin) {
        this.provin = provin;
    }

    /**
     * @return the lstProfesiones
     */
    public List<Profesion> getLstProfesiones() {
        return lstProfesiones;
    }

    /**
     * @param lstProfesiones the lstProfesiones to set
     */
    public void setLstProfesiones(List<Profesion> lstProfesiones) {
        this.lstProfesiones = lstProfesiones;
    }

    /**
     * @return the lstNivIns
     */
    public List<Tabla> getLstNivIns() {
        return lstNivIns;
    }

    /**
     * @param lstNivIns the lstNivEst to set
     */
    public void setLstNivIns(List<Tabla> lstNivIns) {
        this.lstNivIns = lstNivIns;
    }

    /**
     * @return the lstTipZon
     */
    public List<Tabla> getLstTipZon() {
        return lstTipZon;
    }

    /**
     * @param lstTipZon the lstTipZon to set
     */
    public void setLstTipZon(List<Tabla> lstTipZon) {
        this.lstTipZon = lstTipZon;
    }

    /**
     * @return the paramBusquedaCre
     */
    public String getParamBusquedaCre() {
        return paramBusquedaCre;
    }

    /**
     * @param paramBusquedaCre the paramBusquedaCre to set
     */
    public void setParamBusquedaCre(String paramBusquedaCre) {
        this.paramBusquedaCre = paramBusquedaCre;
    }

    /**
     * @return the paramBusquedaCli
     */
    public String getParamBusquedaCli() {
        return paramBusquedaCli;
    }

    /**
     * @param paramBusquedaCli the paramBusquedaCli to set
     */
    public void setParamBusquedaCli(String paramBusquedaCli) {
        this.paramBusquedaCli = paramBusquedaCli;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the cliente
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the codCta
     */
    public String getCodCta() {
        return codCta;
    }

    /**
     * @param codCta the codCta to set
     */
    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    /**
     * @return the fecIni
     */
    public String getFecIni() {
        return fecIni;
    }

    /**
     * @param fecIni the fecIni to set
     */
    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    /**
     * @return the fecFin
     */
    public String getFecFin() {
        return fecFin;
    }

    /**
     * @param fecFin the fecFin to set
     */
    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    /**
     * @return the lstCreditos
     */
    public List<Credito> getLstCreditos() {
        return lstCreditos;
    }

    /**
     * @param lstCreditos the lstCreditos to set
     */
    public void setLstCreditos(List<Credito> lstCreditos) {
        this.lstCreditos = lstCreditos;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return the lstLog
     */
    public List<Log> getLstLog() {
        return lstLog;
    }

    /**
     * @param lstLog the lstLog to set
     */
    public void setLstLog(List<Log> lstLog) {
        this.lstLog = lstLog;
    }

    /**
     * @return the codigoVenta
     */
    public String getCodigoVenta() {
        return codigoVenta;
    }

    /**
     * @param codigoVenta the codigoVenta to set
     */
    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    /**
     * @return the suministro
     */
    public String getSuministro() {
        return suministro;
    }

    /**
     * @param suministro the suministro to set
     */
    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the lstCanales
     */
    public List<Canal> getLstCanales() {
        return lstCanales;
    }

    /**
     * @param lstCanales the lstCanales to set
     */
    public void setLstCanales(List<Canal> lstCanales) {
        this.lstCanales = lstCanales;
    }

    /**
     * @return the codigoCanal
     */
    public int getCodigoCanal() {
        return codigoCanal;
    }

    /**
     * @param codigoCanal the codigoCanal to set
     */
    public void setCodigoCanal(int codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    /**
     * @return the resultadoENEL
     */
    public String getResultadoENEL() {
        return resultadoENEL;
    }

    /**
     * @param resultadoENEL the resultadoENEL to set
     */
    public void setResultadoENEL(String resultadoENEL) {
        this.resultadoENEL = resultadoENEL;
    }

    /**
     * @return the resultadoSENTINEL
     */
    public String getResultadoSENTINEL() {
        return resultadoSENTINEL;
    }

    /**
     * @param resultadoSENTINEL the resultadoSENTINEL to set
     */
    public void setResultadoSENTINEL(String resultadoSENTINEL) {
        this.resultadoSENTINEL = resultadoSENTINEL;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMenuCompleto() {
        return menuCompleto;
    }

    public void setMenuCompleto(String menuCompleto) {
        this.menuCompleto = menuCompleto;
    }
}
