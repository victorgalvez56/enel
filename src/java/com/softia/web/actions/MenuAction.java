package com.softia.web.actions;

import com.opensymphony.xwork2.ActionContext;
import com.softia.beans.CAutonomias;
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
import com.softia.models.Autonomia;
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
import com.softia.models.Menu;
import com.softia.models.Oficina;
import com.softia.models.Perfil;
import com.softia.models.Producto;
import com.softia.models.Profesion;
import com.softia.models.Provincia;
import com.softia.models.SubMenu;
import com.softia.models.Tabla;
import com.softia.models.TipoCliente;
import com.softia.models.Usuario;
import com.softia.utils.LibFunc;
import com.softia.web.beans.CReporte;
import com.softia.web.beans.CReportePDF;
import com.softia.web.beans.CReporteXls;
import com.softia.web.beans.CTab;
import com.softia.web.models.Tab;
import com.softia.web.beans.CVerificacion;
import com.softia.web.models.Verificacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
    private List<Tab> lstVerificacion;
    private List<Verificacion> lstVerifiPerfCB;
    private List<Verificacion> lstVerifiPerfCNB;
    private List<Verificacion> lstLineaCreCB;
    private List<Verificacion> lstLineaCreCNB;
    private List<Verificacion> lstPlazosCB;
    private List<Verificacion> lstPlazosCNB;
    private List<Verificacion> lstValorCuotaCB;
    private List<Verificacion> lstValorCuotaCNB;
    private Verificacion verificacion;
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
    private Autonomia autonomia;
    private List<Autonomia> lstAutonomias;
    private double minimo;
    private double maximo;
    private List<Menu> Menus;
    private List<SubMenu> SubMenus;
    private int titular;
    private int familiar;
    private int inquilino;
    private int taxistas;
    private int milOficios;
    private int emprendedores;
    private int amasCasa;
    private int empleadasHogar;
    private int jubiPen;
    private int remesas;
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    private double lineaTitular;
    private double lineaFamiliar;
    private double lineaInquilino;
    private double lineaTaxistas;
    private double lineaMilOficios;
    private double lineaEmprendedores;
    private double lineaAmasCasa;
    private double lineaEmpleadasHogar;
    private double lineaJubiPen;
    private double lineaRemesas;
    private double lineaX1;
    private double lineaX2;
    private double lineaX3;
    private double lineaX4;
    private int cuotasTitular;
    private int cuotasFamiliar;
    private int cuotasInquilino;
    private int cuotasTaxistas;
    private int cuotasMilOficios;
    private int cuotasEmprendedores;
    private int cuotasAmasCasa;
    private int cuotasEmpleadasHogar;
    private int cuotasJubiPen;
    private int cuotasRemesas;
    private int cuotasX1;
    private int cuotasX2;
    private int cuotasX3;
    private int cuotasX4;
    private double cuotaTitular;
    private double cuotaFamiliar;
    private double cuotaInquilino;
    private double cuotaTaxistas;
    private double cuotaMilOficios;
    private double cuotaEmprendedores;
    private double cuotaAmasCasa;
    private double cuotaEmpleadasHogar;
    private double cuotaJubiPen;
    private double cuotaRemesas;
    private double cuotaX1;
    private double cuotaX2;
    private double cuotaX3;
    private double cuotaX4;

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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        CUsuarios loUsuario = new CUsuarios();
        loUsuario.setUsuario(getUsuario());
        loUsuario.setUser(getUsuario().getCorreo());
        loUsuario.setPasswd(getUsuario().getPasswd());
/*        try {
            setDatos(loUsuario.mxCargarDatos());
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }*/
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

                setMenus(loUsuario.getLstMenus());
                setSubMenus(loUsuario.getLstSubMenus());

                getSession().put("menu", Menus);
                getSession().put("subMenu", SubMenus);

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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            } else if (request.getParameter("buscarSumini") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 3);
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
                        if (loCliente.getCliente().getDireccion().getDireccion() == null && loCliente.getCliente().getEstado() == null) {
                            setAdvertencia("El número de suministro indicado no existe, intente con otro.");
                        }
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
                            llOk = loCliente.mxCreditosRelacionados();
                            if (!llOk) {
                                setError(loCliente.getError());
                            } else {
                                setCliente(loCliente.getCliente());
                            }
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
            } else if (request.getParameter("buscarSumini") != null) {
                CClientes loCliente = new CClientes();
                loCliente.setUrl(getUrl());
                loCliente.setUser(user);
                loCliente.setPasswd(pass);
                try {
                    boolean llOk = loCliente.mxBuscar(getParamBusquedaCli(), 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
                        setMensaje("'" + loCreditos.getCredito().getCodCta() + "'" + " " + loCreditos.getMensaje());
                        setCredito(new Credito());
                        setCodigoVenta("");
                        setCodigoCanal(0);
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
                        setMensaje("'" + loCredito.getCredito().getCodCta() + "'" + " " + loCredito.getMensaje());
                        setCredito(new Credito());
                        setCodigoVenta("");
                        setCodigoCanal(0);
                        setLstCreditos(loCredito.getLstCreditos());
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
                    setEstado("grabada");
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
        } else if (request.getParameter("aprobarSol") != null) {
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
            return frmCREAprobacion();
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
                    setEstado("desistida");
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
                    setEstado("rechazada");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
                    setEstado("aprobada");
                }
                loCredito.mxPlanPagos();
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
                    setEstado("rechazada");
                }
                loCredito.mxPlanPagos();
            } catch (SQLException | ParseException loErr) {
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
                    setEstado("enviada");
                }
                loCredito.mxPlanPagos();
            } catch (SQLException | ParseException loErr) {
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
                        setEstado("aprobada");
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
                        setEstado("rechazada");
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
    
    public String frmCREMntRangoScore_RDC() {
        setResult("frmCREMntRangoScore_RDC");
        return getResult();
    }
    
    public String frmCREMntVerificacion_RDC() {
        setSession(ActionContext.getContext().getSession());
        CTab tab = new CTab();
        setLstVerificacion(tab.getLstVerificacion());
        CVerificacion verifiPerf = new CVerificacion();
        setLstVerifiPerfCB(verifiPerf.getLstVerifiPerfCB());
        setLstVerifiPerfCNB(verifiPerf.getLstVerifiPerfCNB());
        
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            /*Verificacion verifi = new Verificacion();
            verifi.setTitular(getTitular());
            verifi.setFamiliar(getFamiliar());
            verifi.setInquilino(getInquilino());
            verifi.setTaxistas(getTaxistas());
            verifi.setMilOficios(getMilOficios());
            verifi.setEmprendedores(getEmprendedores());
            verifi.setAmasCasa(getAmasCasa());
            verifi.setEmpleadasHogar(getEmpleadasHogar());
            verifi.setJubiPen(getJubiPen());
            verifi.setRemesas(getRemesas());
            verifi.setX1(getX1());
            verifi.setX2(getX2());
            verifi.setX3(getX3());
            verifi.setX4(getX4());
            getLstVerifiPerfCB().set(0, verifi);*/
            
            if (getSession().get("verificacionCB") != null) {
                setLstVerifiPerfCB((ArrayList<Verificacion>)getSession().get("verificacionCB"));
            }
            if (getSession().get("verificacionCNB") != null) {
                setLstVerifiPerfCNB((ArrayList<Verificacion>)getSession().get("verificacionCNB"));
            }
            
            codigo = getCodigo() - 1;
            getLstVerifiPerfCB().get(codigo).setTitular(getTitular());
            getLstVerifiPerfCB().get(codigo).setFamiliar(getFamiliar());
            getLstVerifiPerfCB().get(codigo).setInquilino(getInquilino());
            getLstVerifiPerfCB().get(codigo).setTaxistas(getTaxistas());
            getLstVerifiPerfCB().get(codigo).setMilOficios(getMilOficios());
            getLstVerifiPerfCB().get(codigo).setEmprendedores(getEmprendedores());
            getLstVerifiPerfCB().get(codigo).setAmasCasa(getAmasCasa());
            getLstVerifiPerfCB().get(codigo).setEmpleadasHogar(getEmpleadasHogar());
            getLstVerifiPerfCB().get(codigo).setJubiPen(getJubiPen());
            getLstVerifiPerfCB().get(codigo).setRemesas(getRemesas());
            getLstVerifiPerfCB().get(codigo).setX1(getX1());
            getLstVerifiPerfCB().get(codigo).setX2(getX2());
            getLstVerifiPerfCB().get(codigo).setX3(getX3());
            getLstVerifiPerfCB().get(codigo).setX4(getX4());
            
            getSession().put("verificacionCB", getLstVerifiPerfCB());
        } else if (request.getParameter("guardarCNB") != null) {
            if (getSession().get("verificacionCNB") != null) {
                setLstVerifiPerfCNB((ArrayList<Verificacion>)getSession().get("verificacionCNB"));
            }
            if (getSession().get("verificacionCB") != null) {
                setLstVerifiPerfCB((ArrayList<Verificacion>)getSession().get("verificacionCB"));
            }
            
            codigo = getCodigo() - 1;
            getLstVerifiPerfCNB().get(codigo).setTitular(getTitular());
            getLstVerifiPerfCNB().get(codigo).setFamiliar(getFamiliar());
            getLstVerifiPerfCNB().get(codigo).setInquilino(getInquilino());
            getLstVerifiPerfCNB().get(codigo).setTaxistas(getTaxistas());
            getLstVerifiPerfCNB().get(codigo).setMilOficios(getMilOficios());
            getLstVerifiPerfCNB().get(codigo).setEmprendedores(getEmprendedores());
            getLstVerifiPerfCNB().get(codigo).setAmasCasa(getAmasCasa());
            getLstVerifiPerfCNB().get(codigo).setEmpleadasHogar(getEmpleadasHogar());
            getLstVerifiPerfCNB().get(codigo).setJubiPen(getJubiPen());
            getLstVerifiPerfCNB().get(codigo).setRemesas(getRemesas());
            getLstVerifiPerfCNB().get(codigo).setX1(getX1());
            getLstVerifiPerfCNB().get(codigo).setX2(getX2());
            getLstVerifiPerfCNB().get(codigo).setX3(getX3());
            getLstVerifiPerfCNB().get(codigo).setX4(getX4());
            
            getSession().put("verificacionCNB", getLstVerifiPerfCNB());
        }
        setResult("frmCREMntVerificacion_RDC");
        return getResult();
    }
    
    public String frmCREMntLineaCredito_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion lineaCre = new CVerificacion();
        setLstLineaCreCB(lineaCre.getLstLineaCreCB());
        setLstLineaCreCNB(lineaCre.getLstLineaCreCNB());
        
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            if (getSession().get("lineaCreCB") != null) {
                setLstLineaCreCB((ArrayList<Verificacion>)getSession().get("lineaCreCB"));
            }
            if (getSession().get("lineaCreCNB") != null) {
                setLstLineaCreCNB((ArrayList<Verificacion>)getSession().get("lineaCreCNB"));
            }
            
            codigo = getCodigo() - 1;
            getLstLineaCreCB().get(codigo).setLineaTitular(getLineaTitular());
            getLstLineaCreCB().get(codigo).setLineaFamiliar(getLineaFamiliar());
            getLstLineaCreCB().get(codigo).setLineaInquilino(getLineaInquilino());
            getLstLineaCreCB().get(codigo).setLineaTaxistas(getLineaTaxistas());
            getLstLineaCreCB().get(codigo).setLineaMilOficios(getLineaMilOficios());
            getLstLineaCreCB().get(codigo).setLineaEmprendedores(getLineaEmprendedores());
            getLstLineaCreCB().get(codigo).setLineaAmasCasa(getLineaAmasCasa());
            getLstLineaCreCB().get(codigo).setLineaEmpleadasHogar(getLineaEmpleadasHogar());
            getLstLineaCreCB().get(codigo).setLineaJubiPen(getLineaJubiPen());
            getLstLineaCreCB().get(codigo).setLineaRemesas(getLineaRemesas());
            getLstLineaCreCB().get(codigo).setLineaX1(getLineaX1());
            getLstLineaCreCB().get(codigo).setLineaX2(getLineaX2());
            getLstLineaCreCB().get(codigo).setLineaX3(getLineaX3());
            getLstLineaCreCB().get(codigo).setLineaX4(getLineaX4());
            
            getSession().put("lineaCreCB", getLstLineaCreCB());
        } else if (request.getParameter("guardarCNB") != null) {
            if (getSession().get("lineaCreCNB") != null) {
                setLstLineaCreCNB((ArrayList<Verificacion>)getSession().get("lineaCreCNB"));
            }
            if (getSession().get("lineaCreCB") != null) {
                setLstLineaCreCB((ArrayList<Verificacion>)getSession().get("lineaCreCB"));
            }
            
            codigo = getCodigo() - 1;
            getLstLineaCreCNB().get(codigo).setLineaTitular(getLineaTitular());
            getLstLineaCreCNB().get(codigo).setLineaFamiliar(getLineaFamiliar());
            getLstLineaCreCNB().get(codigo).setLineaInquilino(getLineaInquilino());
            getLstLineaCreCNB().get(codigo).setLineaTaxistas(getLineaTaxistas());
            getLstLineaCreCNB().get(codigo).setLineaMilOficios(getLineaMilOficios());
            getLstLineaCreCNB().get(codigo).setLineaEmprendedores(getLineaEmprendedores());
            getLstLineaCreCNB().get(codigo).setLineaAmasCasa(getLineaAmasCasa());
            getLstLineaCreCNB().get(codigo).setLineaEmpleadasHogar(getLineaEmpleadasHogar());
            getLstLineaCreCNB().get(codigo).setLineaJubiPen(getLineaJubiPen());
            getLstLineaCreCNB().get(codigo).setLineaRemesas(getLineaRemesas());
            getLstLineaCreCNB().get(codigo).setLineaX1(getLineaX1());
            getLstLineaCreCNB().get(codigo).setLineaX2(getLineaX2());
            getLstLineaCreCNB().get(codigo).setLineaX3(getLineaX3());
            getLstLineaCreCNB().get(codigo).setLineaX4(getLineaX4());
            
            getSession().put("lineaCreCNB", getLstLineaCreCNB());
        }
        setResult("frmCREMntLineaCredito_RDC");
        return getResult();
    }
    
    public String frmCREMntPlazos_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion plazos = new CVerificacion();
        setLstPlazosCB(plazos.getLstPlazosCB());
        setLstPlazosCNB(plazos.getLstPlazosCNB());
        
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            if (getSession().get("plazosCB") != null) {
                setLstPlazosCB((ArrayList<Verificacion>)getSession().get("plazosCB"));
            }
            if (getSession().get("plazosCNB") != null) {
                setLstPlazosCNB((ArrayList<Verificacion>)getSession().get("plazosCNB"));
            }
            
            codigo = getCodigo() - 1;
            getLstPlazosCB().get(codigo).setCuotasTitular(getCuotasTitular());
            getLstPlazosCB().get(codigo).setCuotasFamiliar(getCuotasFamiliar());
            getLstPlazosCB().get(codigo).setCuotasInquilino(getCuotasInquilino());
            getLstPlazosCB().get(codigo).setCuotasTaxistas(getCuotasTaxistas());
            getLstPlazosCB().get(codigo).setCuotasMilOficios(getCuotasMilOficios());
            getLstPlazosCB().get(codigo).setCuotasEmprendedores(getCuotasEmprendedores());
            getLstPlazosCB().get(codigo).setCuotasAmasCasa(getCuotasAmasCasa());
            getLstPlazosCB().get(codigo).setCuotasEmpleadasHogar(getCuotasEmpleadasHogar());
            getLstPlazosCB().get(codigo).setCuotasJubiPen(getCuotasJubiPen());
            getLstPlazosCB().get(codigo).setCuotasRemesas(getCuotasRemesas());
            getLstPlazosCB().get(codigo).setCuotasX1(getCuotasX1());
            getLstPlazosCB().get(codigo).setCuotasX2(getCuotasX2());
            getLstPlazosCB().get(codigo).setCuotasX3(getCuotasX3());
            getLstPlazosCB().get(codigo).setCuotasX4(getCuotasX4());
            
            getSession().put("plazosCB", getLstPlazosCB());
        } else if (request.getParameter("guardarCNB") != null) {
            if (getSession().get("plazosCNB") != null) {
                setLstPlazosCNB((ArrayList<Verificacion>)getSession().get("plazosCNB"));
            }
            if (getSession().get("plazosCB") != null) {
                setLstPlazosCB((ArrayList<Verificacion>)getSession().get("plazosCB"));
            }
            
            codigo = getCodigo() - 1;
            getLstPlazosCNB().get(codigo).setCuotasTitular(getCuotasTitular());
            getLstPlazosCNB().get(codigo).setCuotasFamiliar(getCuotasFamiliar());
            getLstPlazosCNB().get(codigo).setCuotasInquilino(getCuotasInquilino());
            getLstPlazosCNB().get(codigo).setCuotasTaxistas(getCuotasTaxistas());
            getLstPlazosCNB().get(codigo).setCuotasMilOficios(getCuotasMilOficios());
            getLstPlazosCNB().get(codigo).setCuotasEmprendedores(getCuotasEmprendedores());
            getLstPlazosCNB().get(codigo).setCuotasAmasCasa(getCuotasAmasCasa());
            getLstPlazosCNB().get(codigo).setCuotasEmpleadasHogar(getCuotasEmpleadasHogar());
            getLstPlazosCNB().get(codigo).setCuotasJubiPen(getCuotasJubiPen());
            getLstPlazosCNB().get(codigo).setCuotasRemesas(getCuotasRemesas());
            getLstPlazosCNB().get(codigo).setCuotasX1(getCuotasX1());
            getLstPlazosCNB().get(codigo).setCuotasX2(getCuotasX2());
            getLstPlazosCNB().get(codigo).setCuotasX3(getCuotasX3());
            getLstPlazosCNB().get(codigo).setCuotasX4(getCuotasX4());
            
            getSession().put("plazosCNB", getLstPlazosCNB());
        }
        setResult("frmCREMntPlazos_RDC");
        return getResult();
    }
    
    public String frmCREValorCuotaCredito_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion valorCuota = new CVerificacion();
        setLstValorCuotaCB(valorCuota.getLstValorCuotaCB());
        setLstValorCuotaCNB(valorCuota.getLstValorCuotaCNB());
        
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            if (getSession().get("valorCuotaCB") != null) {
                setLstValorCuotaCB((ArrayList<Verificacion>)getSession().get("valorCuotaCB"));
            }
            if (getSession().get("valorCuotaCNB") != null) {
                setLstValorCuotaCNB((ArrayList<Verificacion>)getSession().get("valorCuotaCNB"));
            }
            
            codigo = getCodigo() - 1;
            getLstValorCuotaCB().get(codigo).setCuotaTitular(getCuotaTitular());
            getLstValorCuotaCB().get(codigo).setCuotaFamiliar(getCuotaFamiliar());
            getLstValorCuotaCB().get(codigo).setCuotaInquilino(getCuotaInquilino());
            getLstValorCuotaCB().get(codigo).setCuotaTaxistas(getCuotaTaxistas());
            getLstValorCuotaCB().get(codigo).setCuotaMilOficios(getCuotaMilOficios());
            getLstValorCuotaCB().get(codigo).setCuotaEmprendedores(getCuotaEmprendedores());
            getLstValorCuotaCB().get(codigo).setCuotaAmasCasa(getCuotaAmasCasa());
            getLstValorCuotaCB().get(codigo).setCuotaEmpleadasHogar(getCuotaEmpleadasHogar());
            getLstValorCuotaCB().get(codigo).setCuotaJubiPen(getCuotaJubiPen());
            getLstValorCuotaCB().get(codigo).setCuotaRemesas(getCuotaRemesas());
            getLstValorCuotaCB().get(codigo).setCuotaX1(getCuotaX1());
            getLstValorCuotaCB().get(codigo).setCuotaX2(getCuotaX2());
            getLstValorCuotaCB().get(codigo).setCuotaX3(getCuotaX3());
            getLstValorCuotaCB().get(codigo).setCuotaX4(getCuotaX4());
            
            getSession().put("valorCuotaCB", getLstValorCuotaCB());
        } else if (request.getParameter("guardarCNB") != null) {
            if (getSession().get("valorCuotaCNB") != null) {
                setLstValorCuotaCNB((ArrayList<Verificacion>)getSession().get("valorCuotaCNB"));
            }
            if (getSession().get("valorCuotaCB") != null) {
                setLstValorCuotaCB((ArrayList<Verificacion>)getSession().get("valorCuotaCB"));
            }
            
            codigo = getCodigo() - 1;
            getLstValorCuotaCNB().get(codigo).setCuotaTitular(getCuotaTitular());
            getLstValorCuotaCNB().get(codigo).setCuotaFamiliar(getCuotaFamiliar());
            getLstValorCuotaCNB().get(codigo).setCuotaInquilino(getCuotaInquilino());
            getLstValorCuotaCNB().get(codigo).setCuotaTaxistas(getCuotaTaxistas());
            getLstValorCuotaCNB().get(codigo).setCuotaMilOficios(getCuotaMilOficios());
            getLstValorCuotaCNB().get(codigo).setCuotaEmprendedores(getCuotaEmprendedores());
            getLstValorCuotaCNB().get(codigo).setCuotaAmasCasa(getCuotaAmasCasa());
            getLstValorCuotaCNB().get(codigo).setCuotaEmpleadasHogar(getCuotaEmpleadasHogar());
            getLstValorCuotaCNB().get(codigo).setCuotaJubiPen(getCuotaJubiPen());
            getLstValorCuotaCNB().get(codigo).setCuotaRemesas(getCuotaRemesas());
            getLstValorCuotaCNB().get(codigo).setCuotaX1(getCuotaX1());
            getLstValorCuotaCNB().get(codigo).setCuotaX2(getCuotaX2());
            getLstValorCuotaCNB().get(codigo).setCuotaX3(getCuotaX3());
            getLstValorCuotaCNB().get(codigo).setCuotaX4(getCuotaX4());
            
            getSession().put("valorCuotaCNB", getLstValorCuotaCNB());
        }
        setResult("frmCREValorCuotaCredito_RDC");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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

    public String frmADMOficinas() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmADMOficinas");
        try {
            CTabla loTabla = new CTabla();
            loTabla.setUrl(getUrl());
            loTabla.setUser(user);
            loTabla.setPasswd(pass);
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
                setResult("error");
            } else {
                CCanales loCanal = new CCanales();
                loCanal.setUrl(getUrl());
                loCanal.setUser(user);
                loCanal.setPasswd(pass);
                setLstCanales(loCanal.getLstCanales());
                if (getLstCanales() == null) {
                    setError(loCanal.getError());
                    setResult("error");
                } else {
                    COficinas loOficina = new COficinas();
                    loOficina.setUrl(getUrl());
                    loOficina.setUser(user);
                    loOficina.setPasswd(pass);
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
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmADMAutonomias() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmADMAutonomias");
        try {
            CTabla loTabla = new CTabla();
            loTabla.setUrl(getUrl());
            loTabla.setUser(user);
            loTabla.setPasswd(pass);
            setLstEstados(loTabla.getLstTabla(1));
            if (getLstEstados() == null) {
                setError(loTabla.getError());
                setResult("error");
            } else {
                CProductos loProd = new CProductos();
                loProd.setUrl(getUrl());
                loProd.setUser(user);
                loProd.setPasswd(pass);
                setLstProductos(loProd.getLstProductos());
                if (getLstProductos() == null) {
                    setError(loProd.getError());
                    setResult("error");
                } else {
                    CAutonomias loAutonomia = new CAutonomias();
                    loAutonomia.setUrl(getUrl());
                    loAutonomia.setUser(user);
                    loAutonomia.setPasswd(pass);
                    if (getAutonomia() != null) {
                        if (getAutonomia().getProducto().getCodigo() != 0) {
                            getAutonomia().setMoneda("1");
                            loAutonomia.setAutonomia(getAutonomia());
                            setLstAutonomias(loAutonomia.getLstAutonomias());
                            CPerfiles loPer = new CPerfiles();
                            loPer.setUrl(getUrl());
                            loPer.setUser(user);
                            loPer.setPasswd(pass);
                            setLstPerfiles(loPer.getLstPerfiles());
                            if (getLstPerfiles() == null) {
                                setError(loPer.getError());
                                setResult("error");
                            }
                        }
                    }
                    /*                    
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
                     */
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String actualizaAutonomia() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        CAutonomias loAutonomia = new CAutonomias();
        loAutonomia.setUrl(getUrl());
        loAutonomia.setUser(getSession().get("user").toString());
        loAutonomia.setPasswd(getSession().get("pass").toString());
        loAutonomia.setAutonomia(new Autonomia());
        loAutonomia.getAutonomia().setCodigo(getCodigo());
        loAutonomia.getAutonomia().setPerfil(new Perfil());
        loAutonomia.getAutonomia().getPerfil().setCodigo(getPerfil().getCodigo());
        loAutonomia.getAutonomia().setMinimo(getMinimo());
        loAutonomia.getAutonomia().setMaximo(getMaximo());
        loAutonomia.getAutonomia().setEstado(getEstado());
        try {
            boolean llOk = loAutonomia.mxActualizar();
            if (!llOk) {
                setError(loAutonomia.getError());
                return frmADMAutonomias();
            } else {
                setMensaje(loAutonomia.getMensaje());
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
        }
        return frmADMAutonomias();
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        if (request.getParameter("grabarAgencia") != null) {
            CCanales loCanales = new CCanales();
            loCanales.setUrl(getUrl());
            loCanales.setUser(user);
            loCanales.setPasswd(pass);
            /*try {<
                boolean llOk = loCanales.mxGrabar();
                if (!llOk) {
                    setError(loUsuario.getError());
                } else {
                    setUsuario(loUsuario.getUsuario());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }*/
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        } else if (request.getParameter("buscarSumini") != null) {
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
                boolean llOk = loCliente.mxBuscarCreditos(lcParam, 3);
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmREPCREMora");
        return getResult();
    }

    //SUBMODULO REPORTE CARTERA DE CREDITOS
    public String frmREPCRECartera() {
        setSession(ActionContext.getContext().getSession());
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmREPCRECartera");
        return getResult();
    }

    //SUBMODULO REPORTE CREDITOS OTORGADOS
    public String frmREPCREOtorgados() {
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        setResult("frmREPCREOtorgados");
        return getResult();
    }

    public String generarCreOtorgadoXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        CReporteXls loRep = new CReporteXls();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        CCreditos loCreditos = new CCreditos();
        loCreditos.setUrl(getUrl());
        loCreditos.setUser(user);
        loCreditos.setPasswd(pass);
        try {
            loCreditos.setFecIni(getFecIni());
            loCreditos.setFecFin(getFecFin());
            loCreditos.setCodigoCanal(getCodigoCanal());
            boolean llOk = loCreditos.mxGenerarReporteCreditosOtorgados();
            if (!llOk) {
                setError(loCreditos.getError());
            } else {
                llOk = loRep.mxGenerarCreOtorgadosXls(loCreditos.getLstCreditos());
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment; filename=\"CREDITOS_" + LibFunc.getFechaActual() + ".xls\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return frmREPCREOtorgados();
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmREPCREDesembolso");
        return getResult();
    }

    public String generarOPEDesembolsoXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmREPCREPago");
        return getResult();
    }

    public String generarOPEPagoXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
        setResult("frmREPCRESolicitud");
        return getResult();
    }

    public String generarSolicitudXLS() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
            Menus = new ArrayList<>();
            SubMenus = new ArrayList<>();
            Menus = (List<Menu>) getSession().get("menu");
            SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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
        Menus = new ArrayList<>();
        SubMenus = new ArrayList<>();
        Menus = (List<Menu>) getSession().get("menu");
        SubMenus = (List<SubMenu>) getSession().get("subMenu");
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

    public List<Menu> getMenus() {
        return Menus;
    }

    public void setMenus(List<Menu> Menus) {
        this.Menus = Menus;
    }

    public List<SubMenu> getSubMenus() {
        return SubMenus;
    }

    public void setSubMenus(List<SubMenu> SubMenus) {
        this.SubMenus = SubMenus;
    }

    /**
     * @return the autonomia
     */
    public Autonomia getAutonomia() {
        return autonomia;
    }

    /**
     * @param autonomia the autonomia to set
     */
    public void setAutonomia(Autonomia autonomia) {
        this.autonomia = autonomia;
    }

    /**
     * @return the lstAutonomias
     */
    public List<Autonomia> getLstAutonomias() {
        return lstAutonomias;
    }

    /**
     * @param lstAutonomias the lstAutonomias to set
     */
    public void setLstAutonomias(List<Autonomia> lstAutonomias) {
        this.lstAutonomias = lstAutonomias;
    }

    /**
     * @return the minimo
     */
    public double getMinimo() {
        return minimo;
    }

    /**
     * @param minimo the minimo to set
     */
    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    /**
     * @return the maximo
     */
    public double getMaximo() {
        return maximo;
    }

    /**
     * @param maximo the maximo to set
     */
    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }
    
    //AUX
    public List<Tab> getLstVerificacion() {
        return lstVerificacion;
    }

    public void setLstVerificacion(List<Tab> lstVerificacion) {
        this.lstVerificacion = lstVerificacion;
    }
    
    public Verificacion getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(Verificacion verificacion) {
        this.verificacion = verificacion;
    }
    
    public List<Verificacion> getLstVerifiPerfCB() {
        return lstVerifiPerfCB;
    }

    public void setLstVerifiPerfCB(List<Verificacion> lstVerifiPerfCB) {
        this.lstVerifiPerfCB = lstVerifiPerfCB;
    }

    public List<Verificacion> getLstVerifiPerfCNB() {
        return lstVerifiPerfCNB;
    }

    public void setLstVerifiPerfCNB(List<Verificacion> lstVerifiPerfCNB) {
        this.lstVerifiPerfCNB = lstVerifiPerfCNB;
    }
    
    public List<Verificacion> getLstLineaCreCB() {
        return lstLineaCreCB;
    }

    public void setLstLineaCreCB(List<Verificacion> lstLineaCreCB) {
        this.lstLineaCreCB = lstLineaCreCB;
    }

    public List<Verificacion> getLstLineaCreCNB() {
        return lstLineaCreCNB;
    }

    public void setLstLineaCreCNB(List<Verificacion> lstLineaCreCNB) {
        this.lstLineaCreCNB = lstLineaCreCNB;
    }
    
    public List<Verificacion> getLstPlazosCB() {
        return lstPlazosCB;
    }

    public void setLstPlazosCB(List<Verificacion> lstPlazosCB) {
        this.lstPlazosCB = lstPlazosCB;
    }

    public List<Verificacion> getLstPlazosCNB() {
        return lstPlazosCNB;
    }

    public void setLstPlazosCNB(List<Verificacion> lstPlazosCNB) {
        this.lstPlazosCNB = lstPlazosCNB;
    }
    
    public List<Verificacion> getLstValorCuotaCB() {
        return lstValorCuotaCB;
    }

    public void setLstValorCuotaCB(List<Verificacion> lstValorCuotaCB) {
        this.lstValorCuotaCB = lstValorCuotaCB;
    }

    public List<Verificacion> getLstValorCuotaCNB() {
        return lstValorCuotaCNB;
    }

    public void setLstValorCuotaCNB(List<Verificacion> lstValorCuotaCNB) {
        this.lstValorCuotaCNB = lstValorCuotaCNB;
    }
    
    public int getFamiliar() {
        return familiar;
    }

    public void setFamiliar(int familiar) {
        this.familiar = familiar;
    }

    public int getInquilino() {
        return inquilino;
    }

    public void setInquilino(int inquilino) {
        this.inquilino = inquilino;
    }

    public int getTaxistas() {
        return taxistas;
    }

    public void setTaxistas(int taxistas) {
        this.taxistas = taxistas;
    }

    public int getMilOficios() {
        return milOficios;
    }

    public void setMilOficios(int milOficios) {
        this.milOficios = milOficios;
    }

    public int getEmprendedores() {
        return emprendedores;
    }

    public void setEmprendedores(int emprendedores) {
        this.emprendedores = emprendedores;
    }

    public int getAmasCasa() {
        return amasCasa;
    }

    public void setAmasCasa(int amasCasa) {
        this.amasCasa = amasCasa;
    }

    public int getEmpleadasHogar() {
        return empleadasHogar;
    }

    public void setEmpleadasHogar(int empleadasHogar) {
        this.empleadasHogar = empleadasHogar;
    }

    public int getJubiPen() {
        return jubiPen;
    }

    public void setJubiPen(int jubiPen) {
        this.jubiPen = jubiPen;
    }

    public int getRemesas() {
        return remesas;
    }

    public void setRemesas(int remesas) {
        this.remesas = remesas;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }
    
    public double getLineaTitular() {
        return lineaTitular;
    }

    public void setLineaTitular(double lineaTitular) {
        this.lineaTitular = lineaTitular;
    }

    public double getLineaFamiliar() {
        return lineaFamiliar;
    }

    public void setLineaFamiliar(double lineaFamiliar) {
        this.lineaFamiliar = lineaFamiliar;
    }

    public double getLineaInquilino() {
        return lineaInquilino;
    }

    public void setLineaInquilino(double lineaInquilino) {
        this.lineaInquilino = lineaInquilino;
    }

    public double getLineaTaxistas() {
        return lineaTaxistas;
    }

    public void setLineaTaxistas(double lineaTaxistas) {
        this.lineaTaxistas = lineaTaxistas;
    }

    public double getLineaMilOficios() {
        return lineaMilOficios;
    }

    public void setLineaMilOficios(double lineaMilOficios) {
        this.lineaMilOficios = lineaMilOficios;
    }

    public double getLineaEmprendedores() {
        return lineaEmprendedores;
    }

    public void setLineaEmprendedores(double lineaEmprendedores) {
        this.lineaEmprendedores = lineaEmprendedores;
    }

    public double getLineaAmasCasa() {
        return lineaAmasCasa;
    }

    public void setLineaAmasCasa(double lineaAmasCasa) {
        this.lineaAmasCasa = lineaAmasCasa;
    }

    public double getLineaEmpleadasHogar() {
        return lineaEmpleadasHogar;
    }

    public void setLineaEmpleadasHogar(double lineaEmpleadasHogar) {
        this.lineaEmpleadasHogar = lineaEmpleadasHogar;
    }

    public double getLineaJubiPen() {
        return lineaJubiPen;
    }

    public void setLineaJubiPen(double lineaJubiPen) {
        this.lineaJubiPen = lineaJubiPen;
    }

    public double getLineaRemesas() {
        return lineaRemesas;
    }

    public void setLineaRemesas(double lineaRemesas) {
        this.lineaRemesas = lineaRemesas;
    }

    public double getLineaX1() {
        return lineaX1;
    }

    public void setLineaX1(double lineaX1) {
        this.lineaX1 = lineaX1;
    }

    public double getLineaX2() {
        return lineaX2;
    }

    public void setLineaX2(double lineaX2) {
        this.lineaX2 = lineaX2;
    }

    public double getLineaX3() {
        return lineaX3;
    }

    public void setLineaX3(double lineaX3) {
        this.lineaX3 = lineaX3;
    }

    public double getLineaX4() {
        return lineaX4;
    }

    public void setLineaX4(double lineaX4) {
        this.lineaX4 = lineaX4;
    }
    
    public int getCuotasTitular() {
        return cuotasTitular;
    }

    public void setCuotasTitular(int cuotasTitular) {
        this.cuotasTitular = cuotasTitular;
    }

    public int getCuotasFamiliar() {
        return cuotasFamiliar;
    }

    public void setCuotasFamiliar(int cuotasFamiliar) {
        this.cuotasFamiliar = cuotasFamiliar;
    }

    public int getCuotasInquilino() {
        return cuotasInquilino;
    }

    public void setCuotasInquilino(int cuotasInquilino) {
        this.cuotasInquilino = cuotasInquilino;
    }

    public int getCuotasTaxistas() {
        return cuotasTaxistas;
    }

    public void setCuotasTaxistas(int cuotasTaxistas) {
        this.cuotasTaxistas = cuotasTaxistas;
    }

    public int getCuotasMilOficios() {
        return cuotasMilOficios;
    }

    public void setCuotasMilOficios(int cuotasMilOficios) {
        this.cuotasMilOficios = cuotasMilOficios;
    }

    public int getCuotasEmprendedores() {
        return cuotasEmprendedores;
    }

    public void setCuotasEmprendedores(int cuotasEmprendedores) {
        this.cuotasEmprendedores = cuotasEmprendedores;
    }

    public int getCuotasAmasCasa() {
        return cuotasAmasCasa;
    }

    public void setCuotasAmasCasa(int cuotasAmasCasa) {
        this.cuotasAmasCasa = cuotasAmasCasa;
    }

    public int getCuotasEmpleadasHogar() {
        return cuotasEmpleadasHogar;
    }

    public void setCuotasEmpleadasHogar(int cuotasEmpleadasHogar) {
        this.cuotasEmpleadasHogar = cuotasEmpleadasHogar;
    }

    public int getCuotasJubiPen() {
        return cuotasJubiPen;
    }

    public void setCuotasJubiPen(int cuotasJubiPen) {
        this.cuotasJubiPen = cuotasJubiPen;
    }

    public int getCuotasRemesas() {
        return cuotasRemesas;
    }

    public void setCuotasRemesas(int cuotasRemesas) {
        this.cuotasRemesas = cuotasRemesas;
    }

    public int getCuotasX1() {
        return cuotasX1;
    }

    public void setCuotasX1(int cuotasX1) {
        this.cuotasX1 = cuotasX1;
    }

    public int getCuotasX2() {
        return cuotasX2;
    }

    public void setCuotasX2(int cuotasX2) {
        this.cuotasX2 = cuotasX2;
    }

    public int getCuotasX3() {
        return cuotasX3;
    }

    public void setCuotasX3(int cuotasX3) {
        this.cuotasX3 = cuotasX3;
    }

    public int getCuotasX4() {
        return cuotasX4;
    }

    public void setCuotasX4(int cuotasX4) {
        this.cuotasX4 = cuotasX4;
    }
    
    public double getCuotaTitular() {
        return cuotaTitular;
    }

    public void setCuotaTitular(double cuotaTitular) {
        this.cuotaTitular = cuotaTitular;
    }

    public double getCuotaFamiliar() {
        return cuotaFamiliar;
    }

    public void setCuotaFamiliar(double cuotaFamiliar) {
        this.cuotaFamiliar = cuotaFamiliar;
    }

    public double getCuotaInquilino() {
        return cuotaInquilino;
    }

    public void setCuotaInquilino(double cuotaInquilino) {
        this.cuotaInquilino = cuotaInquilino;
    }

    public double getCuotaTaxistas() {
        return cuotaTaxistas;
    }

    public void setCuotaTaxistas(double cuotaTaxistas) {
        this.cuotaTaxistas = cuotaTaxistas;
    }

    public double getCuotaMilOficios() {
        return cuotaMilOficios;
    }

    public void setCuotaMilOficios(double cuotaMilOficios) {
        this.cuotaMilOficios = cuotaMilOficios;
    }

    public double getCuotaEmprendedores() {
        return cuotaEmprendedores;
    }

    public void setCuotaEmprendedores(double cuotaEmprendedores) {
        this.cuotaEmprendedores = cuotaEmprendedores;
    }

    public double getCuotaAmasCasa() {
        return cuotaAmasCasa;
    }

    public void setCuotaAmasCasa(double cuotaAmasCasa) {
        this.cuotaAmasCasa = cuotaAmasCasa;
    }

    public double getCuotaEmpleadasHogar() {
        return cuotaEmpleadasHogar;
    }

    public void setCuotaEmpleadasHogar(double cuotaEmpleadasHogar) {
        this.cuotaEmpleadasHogar = cuotaEmpleadasHogar;
    }

    public double getCuotaJubiPen() {
        return cuotaJubiPen;
    }

    public void setCuotaJubiPen(double cuotaJubiPen) {
        this.cuotaJubiPen = cuotaJubiPen;
    }

    public double getCuotaRemesas() {
        return cuotaRemesas;
    }

    public void setCuotaRemesas(double cuotaRemesas) {
        this.cuotaRemesas = cuotaRemesas;
    }

    public double getCuotaX1() {
        return cuotaX1;
    }

    public void setCuotaX1(double cuotaX1) {
        this.cuotaX1 = cuotaX1;
    }

    public double getCuotaX2() {
        return cuotaX2;
    }

    public void setCuotaX2(double cuotaX2) {
        this.cuotaX2 = cuotaX2;
    }

    public double getCuotaX3() {
        return cuotaX3;
    }

    public void setCuotaX3(double cuotaX3) {
        this.cuotaX3 = cuotaX3;
    }

    public double getCuotaX4() {
        return cuotaX4;
    }

    public void setCuotaX4(double cuotaX4) {
        this.cuotaX4 = cuotaX4;
    }
}
