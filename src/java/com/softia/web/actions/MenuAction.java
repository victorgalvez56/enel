package com.softia.web.actions;

import com.opensymphony.xwork2.ActionContext;
import com.softia.beans.CClientes;
import com.softia.beans.CCobranza;
import com.softia.beans.CCondiciones;
import com.softia.beans.CConfigCobranza;
import com.softia.beans.CCreditos;
import com.softia.beans.CDestinos;
import com.softia.beans.COficinas;
import com.softia.beans.CProductos;
import com.softia.beans.CProfesiones;
import com.softia.beans.CTabla;
import com.softia.beans.CUsuarios;
import com.softia.models.Cliente;
import com.softia.models.Cobranza;
import com.softia.models.Condicion;
import com.softia.models.ConfigCobranza;
import com.softia.models.Credito;
import com.softia.models.Destino;
import com.softia.models.Direccion;
import com.softia.models.Distrito;
import com.softia.models.Oficina;
import com.softia.models.Producto;
import com.softia.models.Profesion;
import com.softia.models.Tabla;
import com.softia.models.TipoCliente;
import com.softia.models.Usuario;
import com.softia.utils.LibFunc;
import com.softia.web.beans.CReporte;
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
    private List<Tabla> lstEstados;
    private List<Tabla> lstSexos;
    private List<Tabla> lstTipDocCiv;
    private List<Tabla> lstNivIns;
    private List<Tabla> lstTipZon;
    private List<Profesion> lstProfesiones;
    private int depart;
    private int provin;
    private String paramBusqueda;
    
    private List<TipoCliente> lstTiposCliente;
    
    private List<Tabla> lstTipoCobranza;
    private List<Tabla> lstTipoOrden;
    private List<Oficina> lstOficinas;
    private List<Destino> lstDestinos;
    private List<Condicion> lstCondiciones;
    private List<Producto> lstProductos;
    private List<Usuario> lstGestoresCobranza;
    private List<Credito> lstAsignados;
    private List<Cobranza> lstCobranza;
    private List<Cobranza> lstDetalleCobranza;
    private List<Cliente> lstClientes;
    private Oficina oficina;
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

    //MODULO CREDITO
    //SUBMODULO CREDITO SOLICITUD
    public String frmCRESolicitud() {
        /* setlstOficina(new ArrayList<>());
        getlstOficina().add("Oficina Principal");
        getlstOficina().add("Oficina Secundaria");*/
        setResult("frmCRESolicitud");
        return getResult();
    }

    //SUBMODULO CREDITO APROBACION DEESEMBOLSO
    public String frmCREAprobacion() {
        /* setlstOficina(new ArrayList<>());
        getlstOficina().add("Oficina Principal");
        getlstOficina().add("Oficina Secundaria");*/
        setResult("frmCREAprobacion");
        return getResult();
    }

    //SUBMODULO CREDITO IMPRESION DE DOCUMENTOS
    public String frmCREDocumentos() {
        /* setlstOficina(new ArrayList<>());
        getlstOficina().add("Oficina Principal");
        getlstOficina().add("Oficina Secundaria");*/
        setResult("frmCREDocumentos");
        return getResult();
    }

    //SUBMODULO CREDITO IMPRESION DE DOCUMENTOS
    public String frmCAJDesembolso() {
        /* setlstOficina(new ArrayList<>());
        getlstOficina().add("Oficina Principal");
        getlstOficina().add("Oficina Secundaria");*/
        setResult("frmCAJDesembolso");
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCAJPago() {
        /* setlstOficina(new ArrayList<>());
        getlstOficina().add("Oficina Principal");
        getlstOficina().add("Oficina Secundaria");*/
        setResult("frmCAJPago");
        return getResult();
    }
    
    public String frmREPCREMora() {
        setResult("frmREPCREMora");
        return getResult();
    }
    
    public String frmREPCRECartera() {
        setResult("frmREPCRECartera");
        return getResult();
    }
    
    public String imprimirPDF() {
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        CReporte loRep = new CReporte();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.evFinanciera(); //mxGenerarReporte
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
                response.setHeader("Content-Disposition", "attachment; filename=\"PRUEBAcliente_" + LibFunc.getFechaActual() + ".pdf\"");
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
        if (!validaSession()) {
            return "login";
        }
        setSession(ActionContext.getContext().getSession());
        CReporte loRep = new CReporte();
        loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            boolean llOk = loRep.mxGenerarReporteXls();
            if (!llOk) {
                setError(loRep.getError());
            } else {
                File file = new File(loRep.getRutaReporte());
                byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                FileUtils.writeByteArrayToFile(file, archivo);
                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentLength(archivo.length);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"PRUEBA_" + LibFunc.getFechaActual() + ".xls\"");
                ServletOutputStream out = response.getOutputStream();
                out.write(archivo);
                out.flush();
            }
        } catch (SQLException | IOException | ParseException loErr) {
            setError(loErr.getMessage());
        }
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
    
    public String frmCLIMantenimiento() {
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
            } else if (request.getParameter("grabar") != null) {
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
                        setCliente(loCliente.getCliente());
                        setMensaje(loCliente.getMensaje());
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
                    boolean llOk = loCliente.mxBuscar(getParamBusqueda(), 2);
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        setLstClientes(loCliente.getLstClientes());
                    }
                } catch (SQLException loErr) {
                    setError(loErr.getMessage());
                }
            } else if (request.getParameter("buscarDNI") != null) {
                //buscarDNI();

            } else if (request.getParameter("cancelar") != null) {
                //cliente = new Cliente();

            } else if (request.getParameter("nuevo") != null) {
                setCliente(new Cliente());
                getCliente().setCodCli("");
                getCliente().setDireccion(new Direccion());
                getCliente().getDireccion().setDistrito(new Distrito(1, "AREQUIPA", "040101"));
                setInformacion("Listo para cliente nuevo");
            }
            setResult("frmCLIMantenimiento");
        }
        setDepart(1);
        setProvin(1);
        return getResult();
    }
    
    public String frmCLIPosicion() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("aplicar") != null) {
            //aplicarCLIMantenimiento();

        } else if (request.getParameter("grabar") != null) {
            //grabarCLIMantenimiento();

        } else if (request.getParameter("buscarNombre") != null) {
            //buscarNombre();

        } else if (request.getParameter("buscarDNI") != null) {
            //buscarDNI();

        } else if (request.getParameter("cancelar") != null) {
            //cliente = new Cliente();

        } else if (request.getParameter("nuevo") != null) {
            //cliente = new Cliente();
            setInformacion("Listo para solicitud nueva");
        }
        setResult("frmCLIPosicion");
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
     * @return the paramBusqueda
     */
    public String getParamBusqueda() {
        return paramBusqueda;
    }

    /**
     * @param paramBusqueda the paramBusqueda to set
     */
    public void setParamBusqueda(String paramBusqueda) {
        this.paramBusqueda = paramBusqueda;
    }
    
}
