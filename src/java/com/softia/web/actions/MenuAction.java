package com.softia.web.actions;

import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.logging.Logger;
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
import com.softia.web.beans.CRango;
import com.softia.web.models.Rango;
import com.softia.web.beans.CProduct;
import com.softia.web.models.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private List<Tabla> lstTipProf;

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
    private List<Rango> lstRangosCB;
    private List<Rango> lstRangosCNB;
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
    private File archivoClientes1;
    private String archivoClientesFileName1;
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
    private String nombre;
    private double minimo;
    private double maximo;
    private List<Menu> Menus;
    private List<SubMenu> SubMenus;
    private int titular;
    private int familiar;
    private int inquilino;
    private int taxista;
    private int milOficio;
    private int emprendedor;
    private int ama;
    private int empleada;
    private int jubilado;
    private int remesa;
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    private double lineaTitular;
    private double lineaFamiliar;
    private double lineaInquilino;
    private double lineaTaxista;
    private double lineaMilOficio;
    private double lineaEmprendedor;
    private double lineaAma;
    private double lineaEmpleada;
    private double lineaJubilado;
    private double lineaRemesa;
    private double lineaX1;
    private double lineaX2;
    private double lineaX3;
    private double lineaX4;
    private int cuotasTitular;
    private int cuotasFamiliar;
    private int cuotasInquilino;
    private int cuotasTaxista;
    private int cuotasMilOficio;
    private int cuotasEmprendedor;
    private int cuotasAma;
    private int cuotasEmpleada;
    private int cuotasJubilado;
    private int cuotasRemesa;
    private int cuotasX1;
    private int cuotasX2;
    private int cuotasX3;
    private int cuotasX4;
    private double cuotaTitular;
    private double cuotaFamiliar;
    private double cuotaInquilino;
    private double cuotaTaxista;
    private double cuotaMilOficio;
    private double cuotaEmprendedor;
    private double cuotaAma;
    private double cuotaEmpleada;
    private double cuotaJubilado;
    private double cuotaRemesa;
    private double cuotaX1;
    private double cuotaX2;
    private double cuotaX3;
    private double cuotaX4;
    private List<Product> lstProducts;
    private Product product;

    private String solCLIcodEvaluador;
    private String solCLIpuntVenta;
    private String solCLIfecSolicitud;
//Datos Solicitante Financiero
    private String solCLIciudadExp;
    private String solCLInacionalidad;
    private String solCLIciudadNac;
    private String solCLIpaisNac;
    private String solCLInperDepend;
//Datos Cónyuge
    private String solCLI_conyugPrimerNomb;
    private String solCLI_conyugSegundoNomb;
    private String solCLI_conyugPrimerApel;
    private String solCLI_conyugSegundoApel;
    private String solCLI_conyugEmpresaTrab;
    private String solCLI_conyugEmpresaCarg;
    private String solCLI_conyugEmpresaTele;
//Datos Vivienda
    private String solCLI_vivienSuministro;
    private String solCLI_vivienTitularSuminis;
    private String solCLI_vivienRelacionTitu;
    private String solCLI_vivienTipo;
    private String solCLI_vivienTiempo;
    private String solCLI_vivienDireccion;
    private String solCLI_vivienDistrito;
    private String solCLI_vivienProvincia;
    private String solCLI_vivienDepartamento;

//Datos Empleado
    private String solCLI_empleadEmpresaNomb;
    private String solCLI_empleadEmpresaRuc;
    private String solCLI_empleadEmpresaActi;
    private String solCLI_empleadEmpresaDire;
    private String solCLI_empleadEmpresaDepa;
    private String solCLI_empleadEmpresaDist;
    private String solCLI_empleadEmpresaProv;
//Datos Independiente Informal
    private String solCLI_independILabor;
    private String solCLI_independITiempoViv;
    private String solCLI_independITipo;
    private String solCLI_independITipoaux;
//Datos Independiente Formal;   
    private String solCLI_independFEmpresaNomb;
    private String solCLI_independFEmpresaRuc;
    private String solCLI_independFCargo;
    private String solCLI_independFLaboraDire;
    private String solCLI_independFLaboraDist;
    private String solCLI_independFLaboraProv;
    private String solCLI_independFLaboraDepa;
    private String solCLI_independFTelefono;
    private String solCLI_independFAnexo;
    private String solCLI_independFCorreo;
//Datos Jubilado
    private String solCLI_jubilEmpresaNombJubi;
    private String solCLI_jubilEmpresaNombApor;
    private String solCLI_jubilEmpresaTiempo;
//Datos Información Financiera-Ingresos
    private double solCLI_infofinanIngSueldoBasic;
    private double solCLI_infofinanIngComisiones;
    private double solCLI_infofinanIngHonorarios;
    private double solCLI_infofinanIngAlquileres;
    private double solCLI_infofinanIngOtros;
    private double solCLI_infofinanIngTotal;
    private double solCLI_infofinanIngTotalAct;
//Datos Información Financiera-Gastos
    private double solCLI_infofinanGasAlquiler;
    private double solCLI_infofinanGasCreditoViv;
    private double solCLI_infofinanGasFamiliar;
    private double solCLI_infofinanGasTarjetasCred;
    private double solCLI_infofinanGasOtros;
    private double solCLI_infofinanGasTotal;
    private double solCLI_infofinanGasTotalPat;
//Datos Referencias Personales
    private String solCLI_refepersonPrimerNomb;
    private String solCLI_refepersonSegundoNomb;
    private String solCLI_refepersonPrimerApel;
    private String solCLI_refepersonSegundoApel;
    private String solCLI_refepersonDireccion;
    private String solCLI_refepersonDistrito;
    private String solCLI_refepersonProvincia;
    private String solCLI_refepersonEstado;
    private String solCLI_refepersonTelefono;
    private String solCLI_refepersonCelular;
    private String solCLI_refepersonParentesco;
//Datos Referencias Familiares
    private String solCLI_refefamiliPrimerNomb;
    private String solCLI_refefamiliSegundoNomb;
    private String solCLI_refefamiliPrimerApel;
    private String solCLI_refefamiliSegundoApel;
    private String solCLI_refefamiliDireccion;
    private String solCLI_refefamiliDistrito;
    private String solCLI_refefamiliProvincia;
    private String solCLI_refefamiliEstado;
    private String solCLI_refefamiliTelefono;
    private String solCLI_refefamiliCelular;
    private String solCLI_refefamiliParentesco;

//Datos Referencias Laborales
    private String solCLI_refelabocliNombre;
    private String solCLI_refelabocliActividad;
    private String solCLI_refelabocliTelefono;
    private String solCLI_refelabocliDireccion;
    private String solCLI_refelabocliDistrito;
    private String solCLI_refelabocliProvincia;
    private String solCLI_refelabocliEstado;
    private String solCLI_refelaboproNombre;
    private String solCLI_refelaboproActividad;
    private String solCLI_refelaboproTelefono;
    private String solCLI_refelaboproDireccion;
    private String solCLI_refelaboproDistrito;
    private String solCLI_refelaboproProvincia;
    private String solCLI_refelaboproEstado;

    //Documentos Empleado
    private File archivoSolFinan_EmpleadoRecibo;
    private String archivoSolFinan_EmpleadoReciboFileName;

    private File archivoSolFinan_EmpleadoCopiaDni;
    private String archivoSolFinan_EmpleadoCopiaDniFileName;

    private File archivoSolFinan_EmpleadoBoleta1;
    private String archivoSolFinan_EmpleadoBoleta1FileName;

    private File archivoSolFinan_EmpleadoBoleta2;
    private String archivoSolFinan_EmpleadoBoleta2FileName;

    private File archivoSolFinan_EmpleadoBoleta3;
    private String archivoSolFinan_EmpleadoBoleta3FileName;

    private File archivoSolFinan_EmpleadoCopiaArrendamiento;
    private String archivoSolFinan_EmpleadoCopiaArrendamientoFileName;

    //Documentos Independiente Formal
    private File archivoSolFinan_IndependienteFReciboLuz;
    private String archivoSolFinan_IndependienteFReciboLuzFileName;

    private File archivoSolFinan_IndependienteFCopiaDni;
    private String archivoSolFinan_IndependienteFCopiaDniFileName;

    private File archivoSolFinan_IndependienteFCopiaRuc;
    private String archivoSolFinan_IndependienteFCopiaRucFileName;

    private File archivoSolFinan_IndependienteFExtracBanc1;
    private String archivoSolFinan_IndependienteFExtracBanc1FileName;

    private File archivoSolFinan_IndependienteFExtracBanc2;
    private String archivoSolFinan_IndependienteFExtracBanc2FileName;

    private File archivoSolFinan_IndependienteFExtracBanc3;
    private String archivoSolFinan_IndependienteFExtracBanc3FileName;

    private File archivoSolFinan_IndependienteFCopiaArrendamiento;
    private String archivoSolFinan_IndependienteFCopiaArrendamientoFileName;

    private File archivoSolFinan_IndependienteFExtracAfp;
    private String archivoSolFinan_IndependienteFExtracAfpFileName;

    //Documentos Independiente Informal
    private File archivoSolFinan_IndependienteIReciboLuz;
    private String archivoSolFinan_IndependienteIReciboLuzFileName;

    private File archivoSolFinan_IndependienteICertificadoProveedor1;
    private String archivoSolFinan_IndependienteICertificadoProveedor1FileName;

    private File archivoSolFinan_IndependienteICopiaDni;
    private String archivoSolFinan_IndependienteICopiaDniFileName;

    private File archivoSolFinan_IndependienteICertificadoProveedor2;
    private String archivoSolFinan_IndependienteICertificadoProveedor2FileName;

    private File archivoSolFinan_IndependienteIFactura1;
    private String archivoSolFinan_IndependienteIFactura1FileName;

    private File archivoSolFinan_IndependienteIFactura2;
    private String archivoSolFinan_IndependienteIFactura2FileName;

    private File archivoSolFinan_IndependienteICertificadoExp1;
    private String archivoSolFinan_IndependienteICertificadoExp1FileName;

    private File archivoSolFinan_IndependienteICertificadoExp2;
    private String archivoSolFinan_IndependienteICertificadoExp2FileName;

    private File archivoSolFinan_IndependienteIExtracAfp;
    private String archivoSolFinan_IndependienteIExtracAfpFileName;

    private File archivoSolFinan_IndependienteICopiaArrendamiento;
    private String archivoSolFinan_IndependienteICopiaArrendamientoFileName;

    //Documentos Jubilado
    private File archivoSolFinan_JubiladoRecibo;
    private String archivoSolFinan_JubiladoReciboFileName;

    private File archivoSolFinan_JubiladoCopiaDni;
    private String archivoSolFinan_JubiladoCopiaDniFileName;

    private File archivoSolFinan_JubiladoBoleta1;
    private String archivoSolFinan_JubiladoBoleta1FileName;

    private File archivoSolFinan_JubiladoBoleta2;
    private String archivoSolFinan_JubiladoBoleta2FileName;

    private File archivoSolFinan_JubiladoBoleta3;
    private String archivoSolFinan_JubiladoBoleta3FileName;

    private File archivoSolFinan_JubiladoExtracBanc1;
    private String archivoSolFinan_JubiladoExtracBanc1FileName;

    private File archivoSolFinan_JubiladoExtracBanc2;
    private String archivoSolFinan_JubiladoExtracBanc2FileName;

    private File archivoSolFinan_JubiladoExtracBanc3;
    private String archivoSolFinan_JubiladoExtracBanc3FileName;

    private File archivoSolFinan_JubiladoCopiaArrendamiento;
    private String archivoSolFinan_JubiladoCopiaArrendamientoFileName;

    public String frmSOLCliente() {

        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);

        setLstTipDocCiv(new ArrayList<Tabla>());
        Tabla tipodoc = new Tabla();
        tipodoc.setCodigo("1");
        tipodoc.setDescripcion("DNI");
        getLstTipDocCiv().add(tipodoc);
        tipodoc = new Tabla();
        tipodoc.setCodigo("2");
        tipodoc.setDescripcion("CE");
        getLstTipDocCiv().add(tipodoc);

        setLstSexos(new ArrayList<Tabla>());
        Tabla sexo = new Tabla();
        sexo.setCodigo("1");
        sexo.setDescripcion("FEMENINO");
        getLstSexos().add(sexo);
        sexo = new Tabla();
        sexo.setCodigo("2");
        sexo.setDescripcion("MASCULINO");
        getLstSexos().add(sexo);

        setLstNivIns(new ArrayList<Tabla>());
        Tabla nivelest = new Tabla();
        nivelest.setCodigo("1");
        nivelest.setDescripcion("PRIMARIA");
        getLstNivIns().add(nivelest);
        nivelest = new Tabla();
        nivelest.setCodigo("2");
        nivelest.setDescripcion("SECUNDARIA");
        getLstNivIns().add(nivelest);
        nivelest = new Tabla();
        nivelest.setCodigo("3");
        nivelest.setDescripcion("SUPERIOR");
        getLstNivIns().add(nivelest);

        setLstTipoOrden(new ArrayList<Tabla>());
        Tabla tipo = new Tabla();
        tipo.setCodigo("E");
        tipo.setDescripcion("EMPLEADO");
        getLstTipoOrden().add(tipo);
        tipo = new Tabla();
        tipo.setCodigo("I");
        tipo.setDescripcion("INDEPENDIENTE");
        getLstTipoOrden().add(tipo);
        tipo = new Tabla();
        tipo.setCodigo("P");
        tipo.setDescripcion("PENSIONADO");
        getLstTipoOrden().add(tipo);

        //Estado civil
        setLstEstados(new ArrayList<Tabla>());
        Tabla estado = new Tabla();
        estado.setCodigo("1");
        estado.setDescripcion("SOLTERO");
        getLstEstados().add(estado);
        estado = new Tabla();
        estado.setCodigo("2");
        estado.setDescripcion("CASADO");
        getLstEstados().add(estado);
        estado = new Tabla();
        estado.setCodigo("3");
        estado.setDescripcion("DIVORCIADO");
        getLstEstados().add(estado);
        estado = new Tabla();
        estado.setCodigo("4");
        estado.setDescripcion("VIUDO");
        getLstEstados().add(estado);
        estado = new Tabla();
        estado.setCodigo("5");
        estado.setDescripcion("CONVIVIENTE");
        getLstEstados().add(estado);

        setResult("frmSOLCliente");
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            try {
                if (getSolCLIcodEvaluador().equals("")) {
                    setError("Por favor llenar el campo Código Evaluador");
                } else {
                    if (getSolCLIpuntVenta().equals("")) {
                        setError("Por favor llenar el campo Punto de Venta");
                    } else {
                        if (getSolCLIfecSolicitud().equals("")) {
                            setError("No se cargó la Fecha");
                        } else {
                            if (getCliente().getTipDocCiv().equals("0")) {
                                setError("Seleccionar un Tipo de Documento");
                            } else {
                                if (getCliente().getNroDocCiv().equals("")) {
                                    setError("Por favor llenar el campo Número de Doc Civil");
                                } else {
                                    if (getSolCLIciudadExp().equals("0")) {
                                        setError("Seleccionar una Ciudad de Expedición");
                                    } else {
                                        if (getCliente().getNombre().equals("")) {
                                            setError("Por favor llenar el campo Nombre");
                                        } else {
                                            if (getCliente().getApePat().equals("")) {
                                                setError("Por favor llenar el campo Apellido Paterno");
                                            } else {
                                                if (getCliente().getApeMat().equals("")) {
                                                    setError("Por favor llenar el campo Apellido Materno");
                                                } else {
                                                    if (getSolCLInacionalidad().equals("")) {
                                                        setError("Por favor llenar el campo Nacionalidad");
                                                    } else {
                                                        if (getCliente().getFecNac().equals("")) {
                                                            setError("Por favor llenar el campo Fecha de Nacimiento");
                                                        } else {
                                                            if (getSolCLIciudadNac().equals("")) {
                                                                setError("Por favor llenar el campo Ciudad de Nacimiento");
                                                            } else {
                                                                if (getSolCLIpaisNac().equals("")) {
                                                                    setError("Por favor llenar el campo País de Nacimiento");
                                                                } else {
                                                                    if (getCliente().getSexo().equals("")) {
                                                                        setError("Por favor llenar el campo Género");
                                                                    } else {
                                                                        if (getCliente().getDesOcu().equals("0")) {
                                                                            setError("Por favor llenar el campo Ocupación");
                                                                        } else {
                                                                            if (getSolCLInperDepend().equals("")) {
                                                                                setError("Por favor llenar el campo Número de personas que dependen económicamente del Solicitante");
                                                                            } else {
                                                                                if (getCliente().getNivIns().equals("")) {
                                                                                    setError("Por favor llenar el campo Estudios");
                                                                                } else {
                                                                                    if (getCliente().getCorreo().equals("")) {
                                                                                        setError("Por favor llenar el campo Correo Electrónico");
                                                                                    } else {
                                                                                        if (getCliente().getTelefono().equals("")) {
                                                                                            setError("Por favor llenar el campo Teléfono");
                                                                                        } else {
                                                                                            if (!getCliente().getEstCiv().equals("0") && !getCliente().getDesOcu().equals("0")) {
                                                                                                HttpServletRequest request = ServletActionContext.getRequest();
                                                                                                if (request.getParameter("siguienteSolc") != null) {
                                                                                                    if (getCliente().getEstCiv().equals("2") || getCliente().getEstCiv().equals("5")) {
                                                                                                        return frmSOLConyugue();
                                                                                                    } else {
                                                                                                        return frmSOLVivienda();

                                                                                                    }
                                                                                                } else {
                                                                                                    setResult("frmSOLCliente");

                                                                                                }
                                                                                            } else {
                                                                                                setError("Seleccionar Estado Civil");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getResult();
    }

    public String frmSOLConyugue() {
        setResult("frmSOLConyugue");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_conyugPrimerNomb().equals("")) {
                    setError("Por favor llenar el campo Primer Nombre");
                } else {
                    if (getSolCLI_conyugSegundoNomb().equals("")) {
                        setError("Por favor llenar el campo Segundo Nombre");
                    } else {
                        if (getSolCLI_conyugPrimerApel().equals("")) {
                            setError("Por favor llenar el campo Primer Apellido");
                        } else {
                            if (getSolCLI_conyugSegundoApel().equals("")) {
                                setError("Por favor llenar el campo Segundo Apellido");
                            } else {
                                if (getSolCLI_conyugEmpresaTrab().equals("")) {
                                    setError("Por favor llenar el campo Empresa donde Trabaja");
                                } else {
                                    if (getSolCLI_conyugEmpresaCarg().equals("")) {
                                        setError("Por favor llenar el campo Cargo");
                                    } else {
                                        if (getSolCLI_conyugEmpresaTele().equals("")) {
                                            setError("Por favor llenar el campo Teléfono");
                                        } else {
                                            HttpServletRequest request = ServletActionContext.getRequest();
                                            if (request.getParameter("siguienteConyu") != null) {
                                                return frmSOLVivienda();
                                            } else {
                                                setResult("frmSOLConyugue");

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLVivienda() {
        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);
        setResult("frmSOLVivienda");
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_vivienSuministro().equals("")) {
                    setError("Por favor llenar el campo Número de Suministro");
                } else {
                    if (getSolCLI_vivienTitularSuminis().equals("")) {
                        setError("Por favor llenar el campo Titular de Suministro");
                    } else {
                        if (getSolCLI_vivienRelacionTitu().equals("")) {
                            setError("Por favor llenar el campo Relación con el titular");
                        } else {
                            if (getSolCLI_vivienTipo().equals("")) {
                                setError("Por favor llenar el campo Tipo de Vivienda");
                            } else {
                                if (getSolCLI_vivienTiempo().equals("")) {
                                    setError("Por favor llenar el campo Hace cuanto vive ahí");
                                } else {
                                    if (getSolCLI_vivienDireccion().equals("")) {
                                        setError("Por favor llenar el campo Dirección de Residencia");
                                    } else {
                                        if (getSolCLI_vivienDistrito().equals("0")) {
                                            setError("Por favor seleccionar Distrito");
                                        } else {
                                            if (getSolCLI_vivienProvincia().equals("0")) {
                                                setError("Por favor seleccionar Provincia");
                                            } else {
                                                if (getSolCLI_vivienDepartamento().equals("0")) {
                                                    setError("Por favor seleccionar Departamento");
                                                } else {
                                                    HttpServletRequest request = ServletActionContext.getRequest();
                                                    if (request.getParameter("siguienteViviend") != null) {
                                                        if (getCliente().getDesOcu().equals("E")) {
                                                            return frmSOLEmpleado();
                                                        } else if (getCliente().getDesOcu().equals("I")) {
                                                            return frmSOLIndependiente();
                                                        } else if (getCliente().getDesOcu().equals("P")) {
                                                            return frmSOLJubilado();
                                                        }
                                                    } else {
                                                        setResult("frmSOLVivienda");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLEmpleado() {
        if (!validaSession()) {
            return "login";
        }

        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);

        setResult("frmSOLEmpleado");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_empleadEmpresaNomb().equals("")) {
                    setError("Por favor llenar el campo Nombre de la Empresa");
                } else {
                    if (getSolCLI_empleadEmpresaRuc().equals("")) {
                        setError("Por favor llenar el campo Ruc de la Empresa");
                    } else {
                        if (getSolCLI_empleadEmpresaActi().equals("")) {
                            setError("Por favor llenar el campo Actividad de la Empresa");
                        } else {
                            if (getSolCLI_empleadEmpresaDire().equals("")) {
                                setError("Por favor llenar el campo Dirección de la Empresa");
                            } else {
                                if (getSolCLI_empleadEmpresaDepa().equals("0")) {
                                    setError("Por favor llenar el campo Departamento");
                                } else {
                                    if (getSolCLI_empleadEmpresaDist().equals("0")) {
                                        setError("Por favor llenar el campo Distrito");
                                    } else {
                                        if (getSolCLI_empleadEmpresaProv().equals("0")) {
                                            setError("Por favor seleccionar Provincia");
                                        } else {
                                            HttpServletRequest request = ServletActionContext.getRequest();
                                            if (request.getParameter("siguienteEmp") != null) {
                                                return frmSOLInfoFinanciera();
                                            } else {
                                                setResult("frmSOLEmpleado");

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLIndependiente() {
        if (!validaSession()) {
            return "login";
        }
        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);

        setResult("frmSOLIndependiente");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_independILabor().equals("")) {
                    setError("Por favor llenar el primer campo");
                } else {
                    if (getSolCLI_independITiempoViv().equals("")) {
                        setError("Por favor llenar el segundo campo");
                    } else {
                        if (getSolCLI_independITipo().equals("")) {
                            setError("Por favor llenar el tercer campo");
                        } else {
                            if (!getSolCLI_independFEmpresaNomb().equals("")) {
                                if (getSolCLI_independFEmpresaNomb().equals("")) {
                                    setError("Por favor llenar el campo Nombre de la Empresa");
                                } else {
                                    if (getSolCLI_independFEmpresaRuc().equals("")) {
                                        setError("Por favor llenar el campo RUC");
                                    } else {
                                        if (getSolCLI_independFCargo().equals("")) {
                                            setError("Por favor llenar el campo Cargo");
                                        } else {
                                            if (getSolCLI_independFLaboraDire().equals("")) {
                                                setError("Por favor llenar el campo Dirección");
                                            } else {
                                                if (getSolCLI_independFLaboraDist().equals("0")) {
                                                    setError("Por favor llenar el campo Distrito");
                                                } else {
                                                    if (getSolCLI_independFLaboraProv().equals("0")) {
                                                        setError("Por favor seleccionar una Provincia");
                                                    } else {
                                                        if (getSolCLI_independFLaboraDepa().equals("0")) {
                                                            setError("Por favor seleccionar un Departamento");
                                                        } else {
                                                            if (getSolCLI_independFTelefono().equals("")) {
                                                                setError("Por favor llenar el campo Teléfono");
                                                            } else {
                                                                if (getSolCLI_independFAnexo().equals("")) {
                                                                    setError("Por favor llenar el campo Anexo");
                                                                } else {
                                                                    if (getSolCLI_independFCorreo().equals("")) {
                                                                        setError("Por favor llenar el campo Correo Electrónico");
                                                                    } else {
                                                                        HttpServletRequest request = ServletActionContext.getRequest();
                                                                        if (request.getParameter("siguienteIndep") != null) {
                                                                            return frmSOLInfoFinanciera();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                HttpServletRequest request = ServletActionContext.getRequest();
                                if (request.getParameter("siguienteIndep") != null) {
                                    return frmSOLInfoFinanciera();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }

        return getResult();
    }

    public String frmSOLJubilado() {
        if (!validaSession()) {
            return "login";
        }
        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);
        setResult("frmSOLJubilado");
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_jubilEmpresaNombJubi().equals("")) {
                    setError("Por favor llenar el Primer campo");
                } else {
                    if (getSolCLI_jubilEmpresaNombApor().equals("")) {
                        setError("Por favor llenar el Segundo campo");
                    } else {
                        if (getSolCLI_jubilEmpresaTiempo().equals("")) {
                            setError("Por favor llenar el Tercer campo");
                        } else {
                            HttpServletRequest request = ServletActionContext.getRequest();
                            if (request.getParameter("siguienteJub") != null) {
                                return frmSOLInfoFinanciera();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

        }

        return getResult();

    }

    public String frmSOLInfoFinanciera() {
        if (!validaSession()) {
            return "login";
        }
        setResult("frmSOLInfoFinanciera");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_infofinanIngSueldoBasic() < 0) {
                    setError("Por favor llenar el campo Sueldo Básico");
                } else {
                    if (getSolCLI_infofinanIngComisiones() < 0) {
                        setError("Por favor llenar el campo Comisiones");
                    } else {
                        if (getSolCLI_infofinanIngHonorarios() < 0) {
                            setError("Por favor llenar el campo Honorarios");
                        } else {
                            if (getSolCLI_infofinanIngAlquileres() < 0) {
                                setError("Por favor llenar el campo Alquileres");
                            } else {
                                if (getSolCLI_infofinanIngOtros() < 0) {
                                    setError("Por favor llenar el campo Otros Ingresos");
                                } else {
                                    if (getSolCLI_infofinanIngTotal() < 0) {
                                        setError("Por favor llenar el campo Total de Ingresos");
                                    } else {
                                        if (getSolCLI_infofinanIngTotalAct() < 0) {
                                            setError("Por favor llenar el campo Total de Activos");
                                        } else {
                                            if (getSolCLI_infofinanGasAlquiler() < 0) {
                                                setError("Por favor llenar el campo Alquiler");
                                            } else {
                                                if (getSolCLI_infofinanGasCreditoViv() < 0) {
                                                    setError("Por favor llenar el campo Crédito de Vivienda ");
                                                } else {
                                                    if (getSolCLI_infofinanGasFamiliar() < 0) {
                                                        setError("Por favor llenar el campo Gastos Familiares");
                                                    } else {
                                                        if (getSolCLI_infofinanGasTarjetasCred() < 0) {
                                                            setError("Por favor llenar el campo Tarjetas de Crédito");
                                                        } else {
                                                            if (getSolCLI_infofinanGasOtros() < 0) {
                                                                setError("Por favor llenar el campo Otros Gastos");
                                                            } else {
                                                                if (getSolCLI_infofinanGasTotal() < 0) {
                                                                    setError("Por favor llenar el campo Total de Gastos");
                                                                } else {
                                                                    if (getSolCLI_infofinanGasTotalPat() < 0) {
                                                                        setError("Por favor llenar el campo Total de Patrimonio");
                                                                    } else {
                                                                        HttpServletRequest request = ServletActionContext.getRequest();
                                                                        if (request.getParameter("siguienteInfo") != null) {
                                                                            return frmSOLReferenciaPersonales();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLReferenciaFamiliar() {
        if (!validaSession()) {
            return "login";
        }

        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);

        setResult("frmSOLReferenciaFamiliar");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_refepersonPrimerNomb().equals("")) {
                    setError("Por favor llenar el campo Primer Nombre");
                } else {
                    if (getSolCLI_refepersonSegundoNomb().equals("")) {
                        setError("Por favor llenar el campo Segundo Nombre");
                    } else {
                        if (getSolCLI_refepersonPrimerApel().equals("")) {
                            setError("Por favor llenar el campo Primer Apellido");
                        } else {
                            if (getSolCLI_refepersonSegundoApel().equals("")) {
                                setError("Por favor llenar el campo Segundo Apellido");
                            } else {
                                if (getSolCLI_refepersonDireccion().equals("")) {
                                    setError("Por favor llenar una Dirección");
                                } else {
                                    if (getSolCLI_refepersonDistrito().equals("0")) {
                                        setError("Por favor Seleccionar un Distrito ");
                                    } else {
                                        if (getSolCLI_refepersonProvincia().equals("0")) {
                                            setError("Por favor Seleccionar un Provincia  ");
                                        } else {
                                            if (getSolCLI_refepersonEstado().equals("")) {
                                                setError("Por favor llenar el campo Estado");
                                            } else {
                                                if (getSolCLI_refepersonTelefono().equals("")) {
                                                    setError("Por favor llenar el campo Teléfono");
                                                } else {
                                                    if (getSolCLI_refepersonCelular().equals("")) {
                                                        setError("Por favor llenar el campo Celular");
                                                    } else {
                                                        if (getSolCLI_refepersonParentesco().equals("")) {
                                                            setError("Por favor llenar el campo Parentesco");
                                                        } else {
                                                            HttpServletRequest request = ServletActionContext.getRequest();
                                                            if (request.getParameter("siguienteFamil") != null) {
                                                                return frmSOLReferenciaLaborales();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLReferenciaLaborales() {
        if (!validaSession()) {
            return "login";
        }
        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);

        setResult("frmSOLReferenciaLaborales");

        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_refelabocliNombre().equals("")) {
                    setError("Por favor llenar el campo Nombre del Cliente");
                } else {
                    if (getSolCLI_refelabocliActividad().equals("")) {
                        setError("Por favor llenar el campo Actividad del Cliente");
                    } else {
                        if (getSolCLI_refelabocliTelefono().equals("")) {
                            setError("Por favor llenar el campo Teléfono del Cliente");
                        } else {
                            if (getSolCLI_refelabocliDireccion().equals("")) {
                                setError("Por favor llenar el campo Dirección del Cliente");
                            } else {
                                if (getSolCLI_refelabocliDistrito().equals("0")) {
                                    setError("Por favor Seleccionar un Distrito");
                                } else {
                                    if (getSolCLI_refelabocliProvincia().equals("0")) {
                                        setError("Por favor Seleccionar una Provincia ");
                                    } else {
                                        if (getSolCLI_refelabocliEstado().equals("")) {
                                            setError("Por favor llenar el campo Estado del Cliente");
                                        } else {
                                            if (getSolCLI_refelaboproNombre().equals("")) {
                                                setError("Por favor llenar el campo Nombre del Proveedor");
                                            } else {
                                                if (getSolCLI_refelaboproActividad().equals("")) {
                                                    setError("Por favor llenar el campo Actividad del Proveedor");
                                                } else {
                                                    if (getSolCLI_refelaboproTelefono().equals("")) {
                                                        setError("Por favor llenar el campo Teléfono del Proveedor");
                                                    } else {
                                                        if (getSolCLI_refelaboproDireccion().equals("")) {
                                                            setError("Por favor llenar el campo Dirección del Proveedor");
                                                        } else {
                                                            if (getSolCLI_refelaboproDistrito().equals("0")) {
                                                                setError("Por favor Seleccionar una Distrito ");
                                                            } else {
                                                                if (getSolCLI_refelaboproProvincia().equals("0")) {
                                                                    setError("Por favor Seleccionar una Provincia ");
                                                                } else {
                                                                    if (getSolCLI_refelaboproEstado().equals("")) {
                                                                        setError("Por favor llenar el campo Estado del Proveedor");
                                                                    } else {
                                                                        HttpServletRequest request = ServletActionContext.getRequest();
                                                                        if (request.getParameter("siguienteLabor") != null) {
                                                                            if (getCliente().getDesOcu().equals("E")) {
                                                                                return frmSOLDocEmpleado();
                                                                            } else if (getCliente().getDesOcu().equals("I")) {
                                                                                if (getSolCLI_independITipoaux().equals("Formal")) {
                                                                                    return frmSOLDocIndependienteFormal();
                                                                                } else {
                                                                                    return frmSOLDocIndependienteInformal();
                                                                                }
                                                                            } else if (getCliente().getDesOcu().equals("P")) {
                                                                                return frmSOLDocJubilado();
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return getResult();
    }

    public String frmSOLReferenciaPersonales() {
        if (!validaSession()) {
            return "login";
        }
        setLstTipZon(new ArrayList<Tabla>());
        Tabla zona = new Tabla();
        zona.setCodigo("1");
        zona.setDescripcion("Arequipa");
        getLstTipZon().add(zona);
        zona = new Tabla();
        zona.setCodigo("2");
        zona.setDescripcion("Lima");
        getLstTipZon().add(zona);
        setResult("frmSOLReferenciaPersonales");
        if (!LibFunc.fxEmpty(getError())) {
            setResult("error");
        } else {
            //VALIDACIONES DE CAMPOS
            try {
                if (getSolCLI_refepersonPrimerNomb().equals("")) {
                    setError("Por favor llenar el campo Primer Nombre");
                } else {
                    if (getSolCLI_refepersonSegundoNomb().equals("")) {
                        setError("Por favor llenar el campo Segundo Nombre");
                    } else {
                        if (getSolCLI_refepersonPrimerApel().equals("")) {
                            setError("Por favor llenar el campo Primer Apellido");
                        } else {
                            if (getSolCLI_refepersonSegundoApel().equals("")) {
                                setError("Por favor llenar el campo Segundo Apellido");
                            } else {
                                if (getSolCLI_refepersonDireccion().equals("")) {
                                    setError("Por favor llenar una Dirección");
                                } else {
                                    if (getSolCLI_refepersonDistrito().equals("0")) {
                                        setError("Por favor Seleccionar un Distrito ");
                                    } else {
                                        if (getSolCLI_refepersonProvincia().equals("0")) {
                                            setError("Por favor Seleccionar un Provincia  ");
                                        } else {
                                            if (getSolCLI_refepersonEstado().equals("")) {
                                                setError("Por favor llenar el campo Estado");
                                            } else {
                                                if (getSolCLI_refepersonTelefono().equals("")) {
                                                    setError("Por favor llenar el campo Teléfono");
                                                } else {
                                                    if (getSolCLI_refepersonCelular().equals("")) {
                                                        setError("Por favor llenar el campo Celular");
                                                    } else {
                                                        if (getSolCLI_refepersonParentesco().equals("")) {
                                                            setError("Por favor llenar el campo Parentesco");
                                                        } else {
                                                            HttpServletRequest request = ServletActionContext.getRequest();
                                                            if (request.getParameter("siguientePerso") != null) {
                                                                return frmSOLReferenciaFamiliar();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

        }

        return getResult();

    }

    public String frmSOLDocEmpleado() throws IOException {
        if (!validaSession()) {
            return "login";
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("reporte") != null) {

            CReportePDF loRep = new CReportePDF();
            try {

                loRep.setCliente(getCliente());
                //Solicitud de Financiamiento
                loRep.setSolCLIcodEvaluador(getSolCLIcodEvaluador());
                loRep.setSolCLIpuntVenta(getSolCLIpuntVenta());
                loRep.setSolCLIfecSolicitud(getSolCLIfecSolicitud());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLInacionalidad(getSolCLInacionalidad());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLIpaisNac(getSolCLIpaisNac());
                loRep.setSolCLInperDepend(getSolCLInperDepend());
                //Cónyuge
                loRep.setSolCLI_conyugPrimerNomb(getSolCLI_conyugPrimerNomb());
                loRep.setSolCLI_conyugSegundoNomb(getSolCLI_conyugSegundoNomb());
                loRep.setSolCLI_conyugPrimerApel(getSolCLI_conyugPrimerApel());
                loRep.setSolCLI_conyugSegundoApel(getSolCLI_conyugSegundoApel());
                loRep.setSolCLI_conyugEmpresaTrab(getSolCLI_conyugEmpresaTrab());
                loRep.setSolCLI_conyugEmpresaCarg(getSolCLI_conyugEmpresaCarg());
                loRep.setSolCLI_conyugEmpresaTele(getSolCLI_conyugEmpresaTele());
                //Vivienda
                loRep.setSolCLI_vivienSuministro(getSolCLI_vivienSuministro());
                loRep.setSolCLI_vivienTitularSuminis(getSolCLI_vivienTitularSuminis());
                loRep.setSolCLI_vivienRelacionTitu(getSolCLI_vivienRelacionTitu());
                loRep.setSolCLI_vivienTipo(getSolCLI_vivienTipo());
                loRep.setSolCLI_vivienTiempo(getSolCLI_vivienTiempo());
                loRep.setSolCLI_vivienDireccion(getSolCLI_vivienDireccion());
                loRep.setSolCLI_vivienDistrito(getSolCLI_vivienDistrito());
                loRep.setSolCLI_vivienProvincia(getSolCLI_vivienProvincia());
                loRep.setSolCLI_vivienDepartamento(getSolCLI_vivienDepartamento());
                //Empleado
                loRep.setSolCLI_empleadEmpresaNomb(getSolCLI_empleadEmpresaNomb());
                loRep.setSolCLI_empleadEmpresaRuc(getSolCLI_empleadEmpresaRuc());
                loRep.setSolCLI_empleadEmpresaActi(getSolCLI_empleadEmpresaActi());
                loRep.setSolCLI_empleadEmpresaDire(getSolCLI_empleadEmpresaDire());
                loRep.setSolCLI_empleadEmpresaDepa(getSolCLI_empleadEmpresaDepa());
                loRep.setSolCLI_empleadEmpresaDist(getSolCLI_empleadEmpresaDist());
                loRep.setSolCLI_empleadEmpresaProv(getSolCLI_empleadEmpresaProv());
                //Datos Información Financiera-Ingresos
                loRep.setSolCLI_infofinanIngSueldoBasic(getSolCLI_infofinanIngSueldoBasic());
                loRep.setSolCLI_infofinanIngComisiones(getSolCLI_infofinanIngComisiones());
                loRep.setSolCLI_infofinanIngHonorarios(getSolCLI_infofinanIngHonorarios());
                loRep.setSolCLI_infofinanIngAlquileres(getSolCLI_infofinanIngAlquileres());
                loRep.setSolCLI_infofinanIngOtros(getSolCLI_infofinanIngOtros());
                loRep.setSolCLI_infofinanIngTotal(getSolCLI_infofinanIngTotal());
                loRep.setSolCLI_infofinanIngTotalAct(getSolCLI_infofinanIngTotalAct());
                //Datos Información Financiera-Gastos
                loRep.setSolCLI_infofinanGasAlquiler(getSolCLI_infofinanGasAlquiler());
                loRep.setSolCLI_infofinanGasCreditoViv(getSolCLI_infofinanGasCreditoViv());
                loRep.setSolCLI_infofinanGasFamiliar(getSolCLI_infofinanGasFamiliar());
                loRep.setSolCLI_infofinanGasTarjetasCred(getSolCLI_infofinanGasTarjetasCred());
                loRep.setSolCLI_infofinanGasOtros(getSolCLI_infofinanGasOtros());
                loRep.setSolCLI_infofinanGasTotal(getSolCLI_infofinanGasTotal());
                loRep.setSolCLI_infofinanGasTotalPat(getSolCLI_infofinanGasTotalPat());
                //Datos Referencias Personales
                loRep.setSolCLI_refepersonPrimerNomb(getSolCLI_refepersonPrimerNomb());
                loRep.setSolCLI_refepersonSegundoNomb(getSolCLI_refepersonSegundoNomb());
                loRep.setSolCLI_refepersonPrimerApel(getSolCLI_refepersonPrimerApel());
                loRep.setSolCLI_refepersonSegundoApel(getSolCLI_refepersonSegundoApel());
                loRep.setSolCLI_refepersonDireccion(getSolCLI_refepersonDireccion());
                loRep.setSolCLI_refepersonDistrito(getSolCLI_refepersonDistrito());
                loRep.setSolCLI_refepersonProvincia(getSolCLI_refepersonProvincia());
                loRep.setSolCLI_refepersonEstado(getSolCLI_refepersonEstado());
                loRep.setSolCLI_refepersonTelefono(getSolCLI_refepersonTelefono());
                loRep.setSolCLI_refepersonCelular(getSolCLI_refepersonCelular());
                loRep.setSolCLI_refepersonParentesco(getSolCLI_refepersonParentesco());

                File filerecibo = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoReciboFileName() + "_" + getCliente().getNombre());
                byte[] archivorecibo = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoRecibo()));
                FileUtils.writeByteArrayToFile(filerecibo, archivorecibo);

                File filecopiadni = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoCopiaDniFileName() + "_" + getCliente().getNombre());
                byte[] archivocopiadni = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoCopiaDni()));
                FileUtils.writeByteArrayToFile(filecopiadni, archivocopiadni);

                File filebol1 = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoBoleta1FileName() + "_" + getCliente().getNombre());
                byte[] archivofile1 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoBoleta1()));
                FileUtils.writeByteArrayToFile(filebol1, archivofile1);

                File filebol2 = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoBoleta2FileName() + "_" + getCliente().getNombre());
                byte[] archivofile2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoBoleta2()));
                FileUtils.writeByteArrayToFile(filebol2, archivofile2);

                File filebol3 = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoBoleta3FileName());
                byte[] archivofile3 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoBoleta3()));
                FileUtils.writeByteArrayToFile(filebol3, archivofile3);

                File fileingadic = new File("/ftia/files/cartas/Empleados/" + getArchivoSolFinan_EmpleadoCopiaArrendamientoFileName());
                byte[] archivoingadic = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_EmpleadoCopiaArrendamiento()));
                FileUtils.writeByteArrayToFile(fileingadic, archivoingadic);

                boolean llOk = loRep.mxSolicitudCliente();

                if (!llOk) {
                    setError(loRep.getError());
                } else {

                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"SolicitudFinanciamiento" + "_" + getCliente().getNombre() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();

                }
            } catch (IOException | SQLException loErr) {
                setError(loErr.getMessage());
            }
        } 
        setResult("frmSOLDocEmpleado");
        return getResult();
    }

    public String frmSOLDocIndependienteFormal() {
        if (!validaSession()) {
            return "login";
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("reporte") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCliente(getCliente());
                //Solicitud de Financiamiento
                loRep.setSolCLIcodEvaluador(getSolCLIcodEvaluador());
                loRep.setSolCLIpuntVenta(getSolCLIpuntVenta());
                loRep.setSolCLIfecSolicitud(getSolCLIfecSolicitud());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLInacionalidad(getSolCLInacionalidad());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLIpaisNac(getSolCLIpaisNac());
                loRep.setSolCLInperDepend(getSolCLInperDepend());
                //Cónyuge
                loRep.setSolCLI_conyugPrimerNomb(getSolCLI_conyugPrimerNomb());
                loRep.setSolCLI_conyugSegundoNomb(getSolCLI_conyugSegundoNomb());
                loRep.setSolCLI_conyugPrimerApel(getSolCLI_conyugPrimerApel());
                loRep.setSolCLI_conyugSegundoApel(getSolCLI_conyugSegundoApel());
                loRep.setSolCLI_conyugEmpresaTrab(getSolCLI_conyugEmpresaTrab());
                loRep.setSolCLI_conyugEmpresaCarg(getSolCLI_conyugEmpresaCarg());
                loRep.setSolCLI_conyugEmpresaTele(getSolCLI_conyugEmpresaTele());
                //Vivienda
                loRep.setSolCLI_vivienSuministro(getSolCLI_vivienSuministro());
                loRep.setSolCLI_vivienTitularSuminis(getSolCLI_vivienTitularSuminis());
                loRep.setSolCLI_vivienRelacionTitu(getSolCLI_vivienRelacionTitu());
                loRep.setSolCLI_vivienTipo(getSolCLI_vivienTipo());
                loRep.setSolCLI_vivienTiempo(getSolCLI_vivienTiempo());
                loRep.setSolCLI_vivienDireccion(getSolCLI_vivienDireccion());
                loRep.setSolCLI_vivienDistrito(getSolCLI_vivienDistrito());
                loRep.setSolCLI_vivienProvincia(getSolCLI_vivienProvincia());
                loRep.setSolCLI_vivienDepartamento(getSolCLI_vivienDepartamento());
                //FORMAL INDEPENDIENTE
                loRep.setSolCLI_independILabor(getSolCLI_independILabor());
                loRep.setSolCLI_independITiempoViv(getSolCLI_independITiempoViv());
                loRep.setSolCLI_independITipo(getSolCLI_independITipo());

                loRep.setSolCLI_independFEmpresaNomb(getSolCLI_independFEmpresaNomb());
                loRep.setSolCLI_independFEmpresaRuc(getSolCLI_independFEmpresaRuc());
                loRep.setSolCLI_independFCargo(getSolCLI_independFCargo());
                loRep.setSolCLI_independFLaboraDire(getSolCLI_independFLaboraDire());
                loRep.setSolCLI_independFLaboraDist(getSolCLI_independFLaboraDist());
                loRep.setSolCLI_independFLaboraProv(getSolCLI_independFLaboraProv());
                loRep.setSolCLI_independFLaboraDepa(getSolCLI_independFLaboraDepa());
                loRep.setSolCLI_independFTelefono(getSolCLI_independFTelefono());
                loRep.setSolCLI_independFAnexo(getSolCLI_independFAnexo());
                //Datos Información Financiera-Ingresos
                loRep.setSolCLI_infofinanIngSueldoBasic(getSolCLI_infofinanIngSueldoBasic());
                loRep.setSolCLI_infofinanIngComisiones(getSolCLI_infofinanIngComisiones());
                loRep.setSolCLI_infofinanIngHonorarios(getSolCLI_infofinanIngHonorarios());
                loRep.setSolCLI_infofinanIngAlquileres(getSolCLI_infofinanIngAlquileres());
                loRep.setSolCLI_infofinanIngOtros(getSolCLI_infofinanIngOtros());
                loRep.setSolCLI_infofinanIngTotal(getSolCLI_infofinanIngTotal());
                loRep.setSolCLI_infofinanIngTotalAct(getSolCLI_infofinanIngTotalAct());
                //Datos Información Financiera-Gastos
                loRep.setSolCLI_infofinanGasAlquiler(getSolCLI_infofinanGasAlquiler());
                loRep.setSolCLI_infofinanGasCreditoViv(getSolCLI_infofinanGasCreditoViv());
                loRep.setSolCLI_infofinanGasFamiliar(getSolCLI_infofinanGasFamiliar());
                loRep.setSolCLI_infofinanGasTarjetasCred(getSolCLI_infofinanGasTarjetasCred());
                loRep.setSolCLI_infofinanGasOtros(getSolCLI_infofinanGasOtros());
                loRep.setSolCLI_infofinanGasTotal(getSolCLI_infofinanGasTotal());
                loRep.setSolCLI_infofinanGasTotalPat(getSolCLI_infofinanGasTotalPat());
                //Datos Referencias Personales
                loRep.setSolCLI_refepersonPrimerNomb(getSolCLI_refepersonPrimerNomb());
                loRep.setSolCLI_refepersonSegundoNomb(getSolCLI_refepersonSegundoNomb());
                loRep.setSolCLI_refepersonPrimerApel(getSolCLI_refepersonPrimerApel());
                loRep.setSolCLI_refepersonSegundoApel(getSolCLI_refepersonSegundoApel());
                loRep.setSolCLI_refepersonDireccion(getSolCLI_refepersonDireccion());
                loRep.setSolCLI_refepersonDistrito(getSolCLI_refepersonDistrito());
                loRep.setSolCLI_refepersonProvincia(getSolCLI_refepersonProvincia());
                loRep.setSolCLI_refepersonEstado(getSolCLI_refepersonEstado());
                loRep.setSolCLI_refepersonTelefono(getSolCLI_refepersonTelefono());
                loRep.setSolCLI_refepersonCelular(getSolCLI_refepersonCelular());
                loRep.setSolCLI_refepersonParentesco(getSolCLI_refepersonParentesco());
                loRep.setCliente(getCliente());

                File filerecibo = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFReciboLuzFileName() + "_" + getCliente().getNombre());
                byte[] archivorecibo = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFReciboLuz()));
                FileUtils.writeByteArrayToFile(filerecibo, archivorecibo);

                File filecopiadni = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFCopiaDniFileName() + "_" + getCliente().getNombre());
                byte[] archivocopiadni = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFCopiaDni()));
                FileUtils.writeByteArrayToFile(filecopiadni, archivocopiadni);

                File filebol1 = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFCopiaRucFileName() + "_" + getCliente().getNombre());
                byte[] archivofile1 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFCopiaRuc()));
                FileUtils.writeByteArrayToFile(filebol1, archivofile1);

                File filebol2 = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFExtracBanc1FileName() + "_" + getCliente().getNombre());
                byte[] archivofile2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFExtracBanc1()));
                FileUtils.writeByteArrayToFile(filebol2, archivofile2);
                File filebol4 = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFExtracBanc2FileName() + "_" + getCliente().getNombre());
                byte[] archivofile4 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFExtracBanc2()));
                FileUtils.writeByteArrayToFile(filebol4, archivofile4);
                File filebol5 = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFExtracBanc3FileName() + "_" + getCliente().getNombre());
                byte[] archivofile5 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFExtracBanc3()));
                FileUtils.writeByteArrayToFile(filebol5, archivofile5);

                File filebol3 = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFExtracAfpFileName() + "_" + getCliente().getNombre());
                byte[] archivofile3 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFExtracAfp()));
                FileUtils.writeByteArrayToFile(filebol3, archivofile3);

                File fileingadic = new File("/ftia/files/cartas/IndependienteFormal/" + getArchivoSolFinan_IndependienteFCopiaArrendamientoFileName() + "_" + getCliente().getNombre());
                byte[] archivoingadic = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteFCopiaArrendamiento()));
                FileUtils.writeByteArrayToFile(fileingadic, archivoingadic);

                boolean llOk = loRep.mxSolicitudCliente();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"SolicitudFinanciamiento" + "_" + getCliente().getNombre() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException loErr) {
                setError(loErr.getMessage());
            }
        }

        setResult("frmSOLDocIndependienteFormal");
        return getResult();
    }

    public String frmSOLDocIndependienteInformal() {
        if (!validaSession()) {
            return "login";
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("reporte") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCliente(getCliente());
                //Solicitud de Financiamiento
                loRep.setSolCLIcodEvaluador(getSolCLIcodEvaluador());
                loRep.setSolCLIpuntVenta(getSolCLIpuntVenta());
                loRep.setSolCLIfecSolicitud(getSolCLIfecSolicitud());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLInacionalidad(getSolCLInacionalidad());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLIpaisNac(getSolCLIpaisNac());
                loRep.setSolCLInperDepend(getSolCLInperDepend());
                //Cónyuge
                loRep.setSolCLI_conyugPrimerNomb(getSolCLI_conyugPrimerNomb());
                loRep.setSolCLI_conyugSegundoNomb(getSolCLI_conyugSegundoNomb());
                loRep.setSolCLI_conyugPrimerApel(getSolCLI_conyugPrimerApel());
                loRep.setSolCLI_conyugSegundoApel(getSolCLI_conyugSegundoApel());
                loRep.setSolCLI_conyugEmpresaTrab(getSolCLI_conyugEmpresaTrab());
                loRep.setSolCLI_conyugEmpresaCarg(getSolCLI_conyugEmpresaCarg());
                loRep.setSolCLI_conyugEmpresaTele(getSolCLI_conyugEmpresaTele());
                //Vivienda
                loRep.setSolCLI_vivienSuministro(getSolCLI_vivienSuministro());
                loRep.setSolCLI_vivienTitularSuminis(getSolCLI_vivienTitularSuminis());
                loRep.setSolCLI_vivienRelacionTitu(getSolCLI_vivienRelacionTitu());
                loRep.setSolCLI_vivienTipo(getSolCLI_vivienTipo());
                loRep.setSolCLI_vivienTiempo(getSolCLI_vivienTiempo());
                loRep.setSolCLI_vivienDireccion(getSolCLI_vivienDireccion());
                loRep.setSolCLI_vivienDistrito(getSolCLI_vivienDistrito());
                loRep.setSolCLI_vivienProvincia(getSolCLI_vivienProvincia());
                loRep.setSolCLI_vivienDepartamento(getSolCLI_vivienDepartamento());
                //FORMAL INDEPENDIENTE
                loRep.setSolCLI_independILabor(getSolCLI_independILabor());
                loRep.setSolCLI_independITiempoViv(getSolCLI_independITiempoViv());
                loRep.setSolCLI_independITipo(getSolCLI_independITipo());
                //Datos Información Financiera-Ingresos
                loRep.setSolCLI_infofinanIngSueldoBasic(getSolCLI_infofinanIngSueldoBasic());
                loRep.setSolCLI_infofinanIngComisiones(getSolCLI_infofinanIngComisiones());
                loRep.setSolCLI_infofinanIngHonorarios(getSolCLI_infofinanIngHonorarios());
                loRep.setSolCLI_infofinanIngAlquileres(getSolCLI_infofinanIngAlquileres());
                loRep.setSolCLI_infofinanIngOtros(getSolCLI_infofinanIngOtros());
                loRep.setSolCLI_infofinanIngTotal(getSolCLI_infofinanIngTotal());
                loRep.setSolCLI_infofinanIngTotalAct(getSolCLI_infofinanIngTotalAct());
                //Datos Información Financiera-Gastos
                loRep.setSolCLI_infofinanGasAlquiler(getSolCLI_infofinanGasAlquiler());
                loRep.setSolCLI_infofinanGasCreditoViv(getSolCLI_infofinanGasCreditoViv());
                loRep.setSolCLI_infofinanGasFamiliar(getSolCLI_infofinanGasFamiliar());
                loRep.setSolCLI_infofinanGasTarjetasCred(getSolCLI_infofinanGasTarjetasCred());
                loRep.setSolCLI_infofinanGasOtros(getSolCLI_infofinanGasOtros());
                loRep.setSolCLI_infofinanGasTotal(getSolCLI_infofinanGasTotal());
                loRep.setSolCLI_infofinanGasTotalPat(getSolCLI_infofinanGasTotalPat());
                //Datos Referencias Personales
                loRep.setSolCLI_refepersonPrimerNomb(getSolCLI_refepersonPrimerNomb());
                loRep.setSolCLI_refepersonSegundoNomb(getSolCLI_refepersonSegundoNomb());
                loRep.setSolCLI_refepersonPrimerApel(getSolCLI_refepersonPrimerApel());
                loRep.setSolCLI_refepersonSegundoApel(getSolCLI_refepersonSegundoApel());
                loRep.setSolCLI_refepersonDireccion(getSolCLI_refepersonDireccion());
                loRep.setSolCLI_refepersonDistrito(getSolCLI_refepersonDistrito());
                loRep.setSolCLI_refepersonProvincia(getSolCLI_refepersonProvincia());
                loRep.setSolCLI_refepersonEstado(getSolCLI_refepersonEstado());
                loRep.setSolCLI_refepersonTelefono(getSolCLI_refepersonTelefono());
                loRep.setSolCLI_refepersonCelular(getSolCLI_refepersonCelular());
                loRep.setSolCLI_refepersonParentesco(getSolCLI_refepersonParentesco());
                loRep.setCliente(getCliente());

                File filerecibo = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteIReciboLuzFileName() + "_" + getCliente().getNombre());
                byte[] archivorecibo = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteIReciboLuz()));
                FileUtils.writeByteArrayToFile(filerecibo, archivorecibo);

                File filecopiadni = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICopiaDniFileName() + "_" + getCliente().getNombre());
                byte[] archivocopiadni = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICopiaDni()));
                FileUtils.writeByteArrayToFile(filecopiadni, archivocopiadni);

                File filebol1 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICertificadoProveedor1FileName() + "_" + getCliente().getNombre());
                byte[] archivofile1 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICertificadoProveedor1()));
                FileUtils.writeByteArrayToFile(filebol1, archivofile1);

                File filebol2 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICertificadoProveedor2FileName() + "_" + getCliente().getNombre());
                byte[] archivofile2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICertificadoProveedor2()));
                FileUtils.writeByteArrayToFile(filebol2, archivofile2);

                File filebol3 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteIFactura1FileName() + "_" + getCliente().getNombre());
                byte[] archivofile3 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteIFactura1()));
                FileUtils.writeByteArrayToFile(filebol3, archivofile3);

                File fileingadic = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteIFactura2FileName() + "_" + getCliente().getNombre());
                byte[] archivoingadic = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteIFactura2()));
                FileUtils.writeByteArrayToFile(fileingadic, archivoingadic);

                File filebol4 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICertificadoExp1FileName() + "_" + getCliente().getNombre());
                byte[] archivofile4 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICertificadoExp1()));
                FileUtils.writeByteArrayToFile(filebol4, archivofile4);

                File fileingadic2 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICertificadoExp2FileName() + "_" + getCliente().getNombre());
                byte[] archivoingadic2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICertificadoExp2()));
                FileUtils.writeByteArrayToFile(fileingadic2, archivoingadic2);

                File filebol5 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteIExtracAfpFileName() + "_" + getCliente().getNombre());
                byte[] archivofile5 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteIExtracAfp()));
                FileUtils.writeByteArrayToFile(filebol5, archivofile5);

                File fileingadic3 = new File("/ftia/files/cartas/IndependienteNFormal/" + getArchivoSolFinan_IndependienteICopiaArrendamientoFileName() + "_" + getCliente().getNombre());
                byte[] archivoingadic3 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_IndependienteICopiaArrendamiento()));
                FileUtils.writeByteArrayToFile(fileingadic3, archivoingadic3);

                boolean llOk = loRep.mxSolicitudCliente();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"SolicitudFinanciamiento" + "_" + getCliente().getNombre() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException loErr) {
                setError(loErr.getMessage());
            }
        }

        setResult("frmSOLDocIndependienteInformal");
        return getResult();
    }

    public String frmSOLDocJubilado() {
        if (!validaSession()) {
            return "login";
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("reporte") != null) {
            CReportePDF loRep = new CReportePDF();
            loRep.setPthFil(ServletActionContext.getServletContext().getRealPath("/"));
            try {
                loRep.setCliente(getCliente());
                //Solicitud de Financiamiento
                loRep.setSolCLIcodEvaluador(getSolCLIcodEvaluador());
                loRep.setSolCLIpuntVenta(getSolCLIpuntVenta());
                loRep.setSolCLIfecSolicitud(getSolCLIfecSolicitud());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLInacionalidad(getSolCLInacionalidad());
                loRep.setSolCLIciudadExp(getSolCLIciudadExp());
                loRep.setSolCLIpaisNac(getSolCLIpaisNac());
                loRep.setSolCLInperDepend(getSolCLInperDepend());
                //Cónyuge
                loRep.setSolCLI_conyugPrimerNomb(getSolCLI_conyugPrimerNomb());
                loRep.setSolCLI_conyugSegundoNomb(getSolCLI_conyugSegundoNomb());
                loRep.setSolCLI_conyugPrimerApel(getSolCLI_conyugPrimerApel());
                loRep.setSolCLI_conyugSegundoApel(getSolCLI_conyugSegundoApel());
                loRep.setSolCLI_conyugEmpresaTrab(getSolCLI_conyugEmpresaTrab());
                loRep.setSolCLI_conyugEmpresaCarg(getSolCLI_conyugEmpresaCarg());
                loRep.setSolCLI_conyugEmpresaTele(getSolCLI_conyugEmpresaTele());
                //Vivienda
                loRep.setSolCLI_vivienSuministro(getSolCLI_vivienSuministro());
                loRep.setSolCLI_vivienTitularSuminis(getSolCLI_vivienTitularSuminis());
                loRep.setSolCLI_vivienRelacionTitu(getSolCLI_vivienRelacionTitu());
                loRep.setSolCLI_vivienTipo(getSolCLI_vivienTipo());
                loRep.setSolCLI_vivienTiempo(getSolCLI_vivienTiempo());
                loRep.setSolCLI_vivienDireccion(getSolCLI_vivienDireccion());
                loRep.setSolCLI_vivienDistrito(getSolCLI_vivienDistrito());
                loRep.setSolCLI_vivienProvincia(getSolCLI_vivienProvincia());
                loRep.setSolCLI_vivienDepartamento(getSolCLI_vivienDepartamento());
                //JUBILADO
                loRep.setSolCLI_jubilEmpresaNombJubi(getSolCLI_jubilEmpresaNombJubi());
                loRep.setSolCLI_jubilEmpresaNombApor(getSolCLI_jubilEmpresaNombApor());
                loRep.setSolCLI_jubilEmpresaTiempo(getSolCLI_jubilEmpresaTiempo());
                //Datos Información Financiera-Ingresos
                loRep.setSolCLI_infofinanIngSueldoBasic(getSolCLI_infofinanIngSueldoBasic());
                loRep.setSolCLI_infofinanIngComisiones(getSolCLI_infofinanIngComisiones());
                loRep.setSolCLI_infofinanIngHonorarios(getSolCLI_infofinanIngHonorarios());
                loRep.setSolCLI_infofinanIngAlquileres(getSolCLI_infofinanIngAlquileres());
                loRep.setSolCLI_infofinanIngOtros(getSolCLI_infofinanIngOtros());
                loRep.setSolCLI_infofinanIngTotal(getSolCLI_infofinanIngTotal());
                loRep.setSolCLI_infofinanIngTotalAct(getSolCLI_infofinanIngTotalAct());
                //Datos Información Financiera-Gastos
                loRep.setSolCLI_infofinanGasAlquiler(getSolCLI_infofinanGasAlquiler());
                loRep.setSolCLI_infofinanGasCreditoViv(getSolCLI_infofinanGasCreditoViv());
                loRep.setSolCLI_infofinanGasCreditoViv(getSolCLI_infofinanGasFamiliar());
                loRep.setSolCLI_infofinanGasTarjetasCred(getSolCLI_infofinanGasTarjetasCred());
                loRep.setSolCLI_infofinanGasOtros(getSolCLI_infofinanGasOtros());
                loRep.setSolCLI_infofinanGasTotal(getSolCLI_infofinanGasTotal());
                loRep.setSolCLI_infofinanGasTotalPat(getSolCLI_infofinanGasTotalPat());
                //Datos Referencias Personales
                loRep.setSolCLI_refepersonPrimerNomb(getSolCLI_refepersonPrimerNomb());
                loRep.setSolCLI_refepersonSegundoNomb(getSolCLI_refepersonSegundoNomb());
                loRep.setSolCLI_refepersonPrimerApel(getSolCLI_refepersonPrimerApel());
                loRep.setSolCLI_refepersonSegundoApel(getSolCLI_refepersonSegundoApel());
                loRep.setSolCLI_refepersonDireccion(getSolCLI_refepersonDireccion());
                loRep.setSolCLI_refepersonDistrito(getSolCLI_refepersonDistrito());
                loRep.setSolCLI_refepersonProvincia(getSolCLI_refepersonProvincia());
                loRep.setSolCLI_refepersonEstado(getSolCLI_refepersonEstado());
                loRep.setSolCLI_refepersonTelefono(getSolCLI_refepersonTelefono());
                loRep.setSolCLI_refepersonCelular(getSolCLI_refepersonCelular());
                loRep.setSolCLI_refepersonParentesco(getSolCLI_refepersonParentesco());
                loRep.setCliente(getCliente());

                File filerecibo = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoReciboFileName());
                byte[] archivorecibo = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoRecibo()));
                FileUtils.writeByteArrayToFile(filerecibo, archivorecibo);

                File filecopiadni = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoCopiaDniFileName());
                byte[] archivocopiadni = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoCopiaDni()));
                FileUtils.writeByteArrayToFile(filecopiadni, archivocopiadni);

                File filebol1 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoBoleta1FileName());
                byte[] archivofile1 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoBoleta1()));
                FileUtils.writeByteArrayToFile(filebol1, archivofile1);

                File filebol2 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoBoleta2FileName());
                byte[] archivofile2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoBoleta2()));
                FileUtils.writeByteArrayToFile(filebol2, archivofile2);

                File filebol3 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoBoleta3FileName());
                byte[] archivofile3 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoBoleta3()));
                FileUtils.writeByteArrayToFile(filebol3, archivofile3);

                File fileingadic = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoExtracBanc1FileName());
                byte[] archivoingadic = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoExtracBanc1()));
                FileUtils.writeByteArrayToFile(fileingadic, archivoingadic);

                File filebol4 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoExtracBanc2FileName());
                byte[] archivofile4 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoExtracBanc2()));
                FileUtils.writeByteArrayToFile(filebol4, archivofile4);

                File fileingadic2 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoExtracBanc3FileName());
                byte[] archivoingadic2 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoExtracBanc3()));
                FileUtils.writeByteArrayToFile(fileingadic2, archivoingadic2);

                File filebol5 = new File("/ftia/files/cartas/Jubilado/" + getArchivoSolFinan_JubiladoCopiaArrendamientoFileName());
                byte[] archivofile5 = IOUtils.toByteArray(new FileInputStream(getArchivoSolFinan_JubiladoCopiaArrendamiento()));
                FileUtils.writeByteArrayToFile(filebol5, archivofile5);

                boolean llOk = loRep.mxSolicitudCliente();
                if (!llOk) {
                    setError(loRep.getError());
                } else {
                    File file = new File(loRep.getRutaReporte());
                    byte[] archivo = IOUtils.toByteArray(new FileInputStream(file));
                    FileUtils.writeByteArrayToFile(file, archivo);
                    HttpServletResponse response = ServletActionContext.getResponse();
                    response.setContentLength(archivo.length);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment; filename=\"SolicitudFinanciamiento" + "_" + getCliente().getNombre() + ".pdf\"");
                    ServletOutputStream out = response.getOutputStream();
                    out.write(archivo);
                    out.flush();
                }
            } catch (IOException | SQLException loErr) {
                setError(loErr.getMessage());
            }
        }

        setResult("frmSOLDocJubilado");
        return getResult();
    }

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
        setSession(ActionContext.getContext().getSession());
        getSession().put("user", loUsuario.getUsuario().getCorreo());
        getSession().put("pass", loUsuario.getUsuario().getPasswd());
        setMenus(loUsuario.getLstMenus());
        setSubMenus(loUsuario.getLstSubMenus());

        getSession().put("menu", Menus);
        getSession().put("subMenu", SubMenus);

        setMensaje(loUsuario.getMensaje());

        setResult("bienvenido");
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
                        loCliente.getCliente().setFecNac(formateador(loCliente.getCliente().getFecNac(), 2));
                        setCliente(loCliente.getCliente());
                    }
                } catch (SQLException | ParseException loErr) {
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
                        for (int i = 0; i < loCreditos.getLstLog().size(); i++) {
                        }
                        //Formateo de fecha
                        /*SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                         for(int i=0; i<loCreditos.getLstLog().size(); i++){
                         String fechaString = formateador.format(loCreditos.getLstLog().get(i).getFecha());
                         java.util.Date fechaDate = formateador.parse(fechaString);
                            
                         java.sql.Date fechaSQL = new java.sql.Date(fechaDate.getTime()); 
                         //loCreditos.getLstLog().get(i).setFecha(java.sql.Date.valueOf(formateador.format(loCreditos.getLstLog().get(i).getFecha())));
                         loCreditos.getLstLog().get(i).setFecha(fechaSQL);
                            
                         }
                         setLstLog(loCreditos.getLstLog());*/
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
                    loCliente.getCliente().setFecNac(formateador(loCliente.getCliente().getFecNac(), 1));
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
                    loCliente.getCliente().setFecNac(formateador(loCliente.getCliente().getFecNac(), 1));
                    boolean llOk = loCliente.mxConsultaSuministro();
                    if (!llOk) {
                        setError(loCliente.getError());
                    } else {
                        loCliente.getCliente().setFecNac(formateador(loCliente.getCliente().getFecNac(), 2));
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

    public String formateador(String fecha, int opcion) throws ParseException {
        String fec = "";
        if (fecha != null) {
            if (opcion == 1) {
                DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formateador.parse(fecha);

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fec = formatter.format(date);
            } else if (opcion == 2) {
                DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formateador.parse(fecha);

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                fec = formatter.format(date);
            }

        }
        return fec;
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
        setSession(ActionContext.getContext().getSession());
        CRango rangos = new CRango();
        if (getSession().get("rangosCB") == null) {
            setLstRangosCB(rangos.getLstRangosCB());
        } else {
            setLstRangosCB((ArrayList<Rango>) getSession().get("rangosCB"));
        }

        if (getSession().get("rangosCNB") == null) {
            setLstRangosCNB(rangos.getLstRangosCNB());
        } else {
            setLstRangosCNB((ArrayList<Rango>) getSession().get("rangosCNB"));
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            /*if (getSession().get("rangosCB") != null) {
             setLstRangosCB((ArrayList<Rango>) getSession().get("rangosCB"));
             }
             if (getSession().get("rangosCNB") != null) {
             setLstRangosCNB((ArrayList<Rango>) getSession().get("rangosCNB"));
             }*/
            codigo = getCodigo() - 1;
            getLstRangosCB().get(codigo).setNombre(getNombre());
            getLstRangosCB().get(codigo).setMinimo(getMinimo());
            getLstRangosCB().get(codigo).setMaximo(getMaximo());

            getSession().put("rangosCB", getLstRangosCB());
        } else if (request.getParameter("guardarCNB") != null) {
            codigo = getCodigo() - 1;
            getLstRangosCNB().get(codigo).setNombre(getNombre());
            getLstRangosCNB().get(codigo).setMinimo(getMinimo());
            getLstRangosCNB().get(codigo).setMaximo(getMaximo());

            getSession().put("rangosCNB", getLstRangosCNB());
            setEstado("CNB");
        } else if (request.getParameter("nuevoCB") != null) {
            getLstRangosCB().add(new Rango());
            getSession().put("rangosCB", getLstRangosCB());
        } else if (request.getParameter("nuevoCNB") != null) {
            getLstRangosCNB().add(new Rango());
            getSession().put("rangosCNB", getLstRangosCNB());
            setEstado("CNB");
        } else if (request.getParameter("quitarCB") != null) {
            codigo = getCodigo() - 1;
            getLstRangosCB().remove(codigo);
            getSession().put("rangosCNB", getLstRangosCNB());
        } else if (request.getParameter("quitarCNB") != null) {
            codigo = getCodigo() - 1;
            getLstRangosCNB().remove(codigo);
            getSession().put("rangosCNB", getLstRangosCNB());
            setEstado("CNB");
        }
        setResult("frmCREMntRangoScore_RDC");
        return getResult();
    }

    public String frmCREMntVerificacion_RDC() {
        setSession(ActionContext.getContext().getSession());
        CTab tab = new CTab();
        setLstVerificacion(tab.getLstVerificacion());
        CVerificacion verifiPerf = new CVerificacion();
        if (getSession().get("verificacionCB") == null) {
            setLstVerifiPerfCB(verifiPerf.getLstVerifiPerfCB());
        } else {
            setLstVerifiPerfCB((ArrayList<Verificacion>) getSession().get("verificacionCB"));
        }

        if (getSession().get("verificacionCNB") == null) {
            setLstVerifiPerfCNB(verifiPerf.getLstVerifiPerfCNB());
        } else {
            setLstVerifiPerfCNB((ArrayList<Verificacion>) getSession().get("verificacionCNB"));
        }

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

 /*if (getSession().get("verificacionCB") != null) {
             setLstVerifiPerfCB((ArrayList<Verificacion>) getSession().get("verificacionCB"));
             }
             if (getSession().get("verificacionCNB") != null) {
             setLstVerifiPerfCNB((ArrayList<Verificacion>) getSession().get("verificacionCNB"));
             }*/
            codigo = getCodigo() - 1;
            getLstVerifiPerfCB().get(codigo).setTitular(getTitular());
            getLstVerifiPerfCB().get(codigo).setFamiliar(getFamiliar());
            getLstVerifiPerfCB().get(codigo).setInquilino(getInquilino());
            getLstVerifiPerfCB().get(codigo).setTaxista(getTaxista());
            getLstVerifiPerfCB().get(codigo).setMilOficio(getMilOficio());
            getLstVerifiPerfCB().get(codigo).setEmprendedor(getEmprendedor());
            getLstVerifiPerfCB().get(codigo).setAma(getAma());
            getLstVerifiPerfCB().get(codigo).setEmpleada(getEmpleada());
            getLstVerifiPerfCB().get(codigo).setJubilado(getJubilado());
            getLstVerifiPerfCB().get(codigo).setRemesa(getRemesa());
            getLstVerifiPerfCB().get(codigo).setX1(getX1());
            getLstVerifiPerfCB().get(codigo).setX2(getX2());
            getLstVerifiPerfCB().get(codigo).setX3(getX3());
            getLstVerifiPerfCB().get(codigo).setX4(getX4());

            getSession().put("verificacionCB", getLstVerifiPerfCB());
        } else if (request.getParameter("guardarCNB") != null) {
            codigo = getCodigo() - 1;
            getLstVerifiPerfCNB().get(codigo).setTitular(getTitular());
            getLstVerifiPerfCNB().get(codigo).setFamiliar(getFamiliar());
            getLstVerifiPerfCNB().get(codigo).setInquilino(getInquilino());
            getLstVerifiPerfCNB().get(codigo).setTaxista(getTaxista());
            getLstVerifiPerfCNB().get(codigo).setMilOficio(getMilOficio());
            getLstVerifiPerfCNB().get(codigo).setEmprendedor(getEmprendedor());
            getLstVerifiPerfCNB().get(codigo).setAma(getAma());
            getLstVerifiPerfCNB().get(codigo).setEmpleada(getEmpleada());
            getLstVerifiPerfCNB().get(codigo).setJubilado(getJubilado());
            getLstVerifiPerfCNB().get(codigo).setRemesa(getRemesa());
            getLstVerifiPerfCNB().get(codigo).setX1(getX1());
            getLstVerifiPerfCNB().get(codigo).setX2(getX2());
            getLstVerifiPerfCNB().get(codigo).setX3(getX3());
            getLstVerifiPerfCNB().get(codigo).setX4(getX4());
            getSession().put("verificacionCNB", getLstVerifiPerfCNB());
            setEstado("CNB");
        }
        setResult("frmCREMntVerificacion_RDC");
        return getResult();
    }

    public String frmCREMntLineaCredito_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion lineaCre = new CVerificacion();
        if (getSession().get("lineaCreCB") == null) {
            setLstLineaCreCB(lineaCre.getLstLineaCreCB());
        } else {
            setLstLineaCreCB((ArrayList<Verificacion>) getSession().get("lineaCreCB"));
        }

        if (getSession().get("lineaCreCNB") == null) {
            setLstLineaCreCNB(lineaCre.getLstLineaCreCNB());
        } else {
            setLstLineaCreCNB((ArrayList<Verificacion>) getSession().get("lineaCreCNB"));
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            /*if (getSession().get("lineaCreCB") != null) {
             setLstLineaCreCB((ArrayList<Verificacion>) getSession().get("lineaCreCB"));
             }
             if (getSession().get("lineaCreCNB") != null) {
             setLstLineaCreCNB((ArrayList<Verificacion>) getSession().get("lineaCreCNB"));
             }*/

            codigo = getCodigo() - 1;
            getLstLineaCreCB().get(codigo).setLineaTitular(getLineaTitular());
            getLstLineaCreCB().get(codigo).setLineaFamiliar(getLineaFamiliar());
            getLstLineaCreCB().get(codigo).setLineaInquilino(getLineaInquilino());
            getLstLineaCreCB().get(codigo).setLineaTaxista(getLineaTaxista());
            getLstLineaCreCB().get(codigo).setLineaMilOficio(getLineaMilOficio());
            getLstLineaCreCB().get(codigo).setLineaEmprendedor(getLineaEmprendedor());
            getLstLineaCreCB().get(codigo).setLineaAma(getLineaAma());
            getLstLineaCreCB().get(codigo).setLineaEmpleada(getLineaEmpleada());
            getLstLineaCreCB().get(codigo).setLineaJubilado(getLineaJubilado());
            getLstLineaCreCB().get(codigo).setLineaRemesa(getLineaRemesa());
            getLstLineaCreCB().get(codigo).setLineaX1(getLineaX1());
            getLstLineaCreCB().get(codigo).setLineaX2(getLineaX2());
            getLstLineaCreCB().get(codigo).setLineaX3(getLineaX3());
            getLstLineaCreCB().get(codigo).setLineaX4(getLineaX4());

            getSession().put("lineaCreCB", getLstLineaCreCB());
        } else if (request.getParameter("guardarCNB") != null) {
            codigo = getCodigo() - 1;
            getLstLineaCreCNB().get(codigo).setLineaTitular(getLineaTitular());
            getLstLineaCreCNB().get(codigo).setLineaFamiliar(getLineaFamiliar());
            getLstLineaCreCNB().get(codigo).setLineaInquilino(getLineaInquilino());
            getLstLineaCreCNB().get(codigo).setLineaTaxista(getLineaTaxista());
            getLstLineaCreCNB().get(codigo).setLineaMilOficio(getLineaMilOficio());
            getLstLineaCreCNB().get(codigo).setLineaEmprendedor(getLineaEmprendedor());
            getLstLineaCreCNB().get(codigo).setLineaAma(getLineaAma());
            getLstLineaCreCNB().get(codigo).setLineaEmpleada(getLineaEmpleada());
            getLstLineaCreCNB().get(codigo).setLineaJubilado(getLineaJubilado());
            getLstLineaCreCNB().get(codigo).setLineaRemesa(getLineaRemesa());
            getLstLineaCreCNB().get(codigo).setLineaX1(getLineaX1());
            getLstLineaCreCNB().get(codigo).setLineaX2(getLineaX2());
            getLstLineaCreCNB().get(codigo).setLineaX3(getLineaX3());
            getLstLineaCreCNB().get(codigo).setLineaX4(getLineaX4());
            getSession().put("lineaCreCNB", getLstLineaCreCNB());
            setEstado("CNB");
        }
        setResult("frmCREMntLineaCredito_RDC");
        return getResult();
    }

    public String frmCREMntPlazos_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion plazos = new CVerificacion();
        if (getSession().get("plazosCB") == null) {
            setLstPlazosCB(plazos.getLstPlazosCB());
        } else {
            setLstPlazosCB((ArrayList<Verificacion>) getSession().get("plazosCB"));
        }

        if (getSession().get("plazosCNB") != null) {
            setLstPlazosCNB(plazos.getLstPlazosCNB());
        } else {
            setLstPlazosCNB((ArrayList<Verificacion>) getSession().get("plazosCNB"));
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("guardarCB") != null) {
            /*if (getSession().get("plazosCB") != null) {
             setLstPlazosCB((ArrayList<Verificacion>)getSession().get("plazosCB"));
             }
             if (getSession().get("plazosCNB") != null) {
             setLstPlazosCNB((ArrayList<Verificacion>)getSession().get("plazosCNB"));
             }*/

            codigo = getCodigo() - 1;
            getLstPlazosCB().get(codigo).setCuotasTitular(getCuotasTitular());
            getLstPlazosCB().get(codigo).setCuotasFamiliar(getCuotasFamiliar());
            getLstPlazosCB().get(codigo).setCuotasInquilino(getCuotasInquilino());
            getLstPlazosCB().get(codigo).setCuotasTaxista(getCuotasTaxista());
            getLstPlazosCB().get(codigo).setCuotasMilOficio(getCuotasMilOficio());
            getLstPlazosCB().get(codigo).setCuotasEmprendedor(getCuotasEmprendedor());
            getLstPlazosCB().get(codigo).setCuotasAma(getCuotasAma());
            getLstPlazosCB().get(codigo).setCuotasEmpleada(getCuotasEmpleada());
            getLstPlazosCB().get(codigo).setCuotasJubilado(getCuotasJubilado());
            getLstPlazosCB().get(codigo).setCuotasRemesa(getCuotasRemesa());
            getLstPlazosCB().get(codigo).setCuotasX1(getCuotasX1());
            getLstPlazosCB().get(codigo).setCuotasX2(getCuotasX2());
            getLstPlazosCB().get(codigo).setCuotasX3(getCuotasX3());
            getLstPlazosCB().get(codigo).setCuotasX4(getCuotasX4());

            getSession().put("plazosCB", getLstPlazosCB());
        } else if (request.getParameter("guardarCNB") != null) {
            codigo = getCodigo() - 1;
            getLstPlazosCNB().get(codigo).setCuotasTitular(getCuotasTitular());
            getLstPlazosCNB().get(codigo).setCuotasFamiliar(getCuotasFamiliar());
            getLstPlazosCNB().get(codigo).setCuotasInquilino(getCuotasInquilino());
            getLstPlazosCNB().get(codigo).setCuotasTaxista(getCuotasTaxista());
            getLstPlazosCNB().get(codigo).setCuotasMilOficio(getCuotasMilOficio());
            getLstPlazosCNB().get(codigo).setCuotasEmprendedor(getCuotasEmprendedor());
            getLstPlazosCNB().get(codigo).setCuotasAma(getCuotasAma());
            getLstPlazosCNB().get(codigo).setCuotasEmpleada(getCuotasEmpleada());
            getLstPlazosCNB().get(codigo).setCuotasJubilado(getCuotasJubilado());
            getLstPlazosCNB().get(codigo).setCuotasRemesa(getCuotasRemesa());
            getLstPlazosCNB().get(codigo).setCuotasX1(getCuotasX1());
            getLstPlazosCNB().get(codigo).setCuotasX2(getCuotasX2());
            getLstPlazosCNB().get(codigo).setCuotasX3(getCuotasX3());
            getLstPlazosCNB().get(codigo).setCuotasX4(getCuotasX4());
            getSession().put("plazosCNB", getLstPlazosCNB());
            setEstado("CNB");
        }
        setResult("frmCREMntPlazos_RDC");
        return getResult();
    }

    public String frmCREValorCuotaCredito_RDC() {
        setSession(ActionContext.getContext().getSession());
        CVerificacion valorCuota = new CVerificacion();
        setLstValorCuotaCB(valorCuota.getLstValorCuotaCB());
        setLstValorCuotaCNB(valorCuota.getLstValorCuotaCNB());

        //CALCULO
        double tea = 47.64;
        if (getSession().get("lineaCreCB") != null && getSession().get("plazosCB") != null) {
            setLstLineaCreCB((ArrayList<Verificacion>) getSession().get("lineaCreCB"));
            setLstPlazosCB((ArrayList<Verificacion>) getSession().get("plazosCB"));

            for (int x = 0; x < getLstValorCuotaCB().size(); x++) {
                getLstValorCuotaCB().get(x).setCuotaTitular(calcularCuota(getLstLineaCreCB().get(x).getLineaTitular(), getLstPlazosCB().get(x).getCuotasTitular(), tea));
                getLstValorCuotaCB().get(x).setCuotaFamiliar(calcularCuota(getLstLineaCreCB().get(x).getLineaFamiliar(), getLstPlazosCB().get(x).getCuotasFamiliar(), tea));
                getLstValorCuotaCB().get(x).setCuotaInquilino(calcularCuota(getLstLineaCreCB().get(x).getLineaInquilino(), getLstPlazosCB().get(x).getCuotasInquilino(), tea));
                getLstValorCuotaCB().get(x).setCuotaTaxista(calcularCuota(getLstLineaCreCB().get(x).getLineaTaxista(), getLstPlazosCB().get(x).getCuotasTaxista(), tea));
                getLstValorCuotaCB().get(x).setCuotaMilOficio(calcularCuota(getLstLineaCreCB().get(x).getLineaMilOficio(), getLstPlazosCB().get(x).getCuotasMilOficio(), tea));
                getLstValorCuotaCB().get(x).setCuotaEmprendedor(calcularCuota(getLstLineaCreCB().get(x).getLineaEmprendedor(), getLstPlazosCB().get(x).getCuotasEmprendedor(), tea));
                getLstValorCuotaCB().get(x).setCuotaAma(calcularCuota(getLstLineaCreCB().get(x).getLineaAma(), getLstPlazosCB().get(x).getCuotasAma(), tea));
                getLstValorCuotaCB().get(x).setCuotaEmpleada(calcularCuota(getLstLineaCreCB().get(x).getLineaEmpleada(), getLstPlazosCB().get(x).getCuotasEmpleada(), tea));
                getLstValorCuotaCB().get(x).setCuotaJubilado(calcularCuota(getLstLineaCreCB().get(x).getLineaJubilado(), getLstPlazosCB().get(x).getCuotasJubilado(), tea));
                getLstValorCuotaCB().get(x).setCuotaRemesa(calcularCuota(getLstLineaCreCB().get(x).getLineaRemesa(), getLstPlazosCB().get(x).getCuotasRemesa(), tea));
                getLstValorCuotaCB().get(x).setCuotaX1(calcularCuota(getLstLineaCreCB().get(x).getLineaX1(), getLstPlazosCB().get(x).getCuotasX1(), tea));
                getLstValorCuotaCB().get(x).setCuotaX2(calcularCuota(getLstLineaCreCB().get(x).getLineaX2(), getLstPlazosCB().get(x).getCuotasX2(), tea));
                getLstValorCuotaCB().get(x).setCuotaX3(calcularCuota(getLstLineaCreCB().get(x).getLineaX3(), getLstPlazosCB().get(x).getCuotasX3(), tea));
                getLstValorCuotaCB().get(x).setCuotaX4(calcularCuota(getLstLineaCreCB().get(x).getLineaX4(), getLstPlazosCB().get(x).getCuotasX4(), tea));
            }
        }
        if (getSession().get("lineaCreCNB") != null && getSession().get("plazosCNB") != null) {
            setLstLineaCreCNB((ArrayList<Verificacion>) getSession().get("lineaCreCNB"));
            setLstPlazosCNB((ArrayList<Verificacion>) getSession().get("plazosCNB"));

            for (int x = 0; x < getLstValorCuotaCNB().size(); x++) {
                getLstValorCuotaCNB().get(x).setCuotaTitular(calcularCuota(getLstLineaCreCNB().get(x).getLineaTitular(), getLstPlazosCNB().get(x).getCuotasTitular(), tea));
                getLstValorCuotaCNB().get(x).setCuotaFamiliar(calcularCuota(getLstLineaCreCNB().get(x).getLineaFamiliar(), getLstPlazosCNB().get(x).getCuotasFamiliar(), tea));
                getLstValorCuotaCNB().get(x).setCuotaInquilino(calcularCuota(getLstLineaCreCNB().get(x).getLineaInquilino(), getLstPlazosCNB().get(x).getCuotasInquilino(), tea));
                getLstValorCuotaCNB().get(x).setCuotaTaxista(calcularCuota(getLstLineaCreCNB().get(x).getLineaTaxista(), getLstPlazosCNB().get(x).getCuotasTaxista(), tea));
                getLstValorCuotaCNB().get(x).setCuotaMilOficio(calcularCuota(getLstLineaCreCNB().get(x).getLineaMilOficio(), getLstPlazosCNB().get(x).getCuotasMilOficio(), tea));
                getLstValorCuotaCNB().get(x).setCuotaEmprendedor(calcularCuota(getLstLineaCreCNB().get(x).getLineaEmprendedor(), getLstPlazosCNB().get(x).getCuotasEmprendedor(), tea));
                getLstValorCuotaCNB().get(x).setCuotaAma(calcularCuota(getLstLineaCreCNB().get(x).getLineaAma(), getLstPlazosCNB().get(x).getCuotasAma(), tea));
                getLstValorCuotaCNB().get(x).setCuotaEmpleada(calcularCuota(getLstLineaCreCNB().get(x).getLineaEmpleada(), getLstPlazosCNB().get(x).getCuotasEmpleada(), tea));
                getLstValorCuotaCNB().get(x).setCuotaJubilado(calcularCuota(getLstLineaCreCNB().get(x).getLineaJubilado(), getLstPlazosCNB().get(x).getCuotasJubilado(), tea));
                getLstValorCuotaCNB().get(x).setCuotaRemesa(calcularCuota(getLstLineaCreCNB().get(x).getLineaRemesa(), getLstPlazosCNB().get(x).getCuotasRemesa(), tea));
                getLstValorCuotaCNB().get(x).setCuotaX1(calcularCuota(getLstLineaCreCNB().get(x).getLineaX1(), getLstPlazosCNB().get(x).getCuotasX1(), tea));
                getLstValorCuotaCNB().get(x).setCuotaX2(calcularCuota(getLstLineaCreCNB().get(x).getLineaX2(), getLstPlazosCNB().get(x).getCuotasX2(), tea));
                getLstValorCuotaCNB().get(x).setCuotaX3(calcularCuota(getLstLineaCreCNB().get(x).getLineaX3(), getLstPlazosCNB().get(x).getCuotasX3(), tea));
                getLstValorCuotaCNB().get(x).setCuotaX4(calcularCuota(getLstLineaCreCNB().get(x).getLineaX4(), getLstPlazosCNB().get(x).getCuotasX4(), tea));
            }
        }
        /*HttpServletRequest request = ServletActionContext.getRequest();
         if (request.getParameter("guardarCB") != null) {
            
         codigo = getCodigo() - 1;
         getLstValorCuotaCB().get(codigo).setCuotaTitular(getCuotaTitular());
         getLstValorCuotaCB().get(codigo).setCuotaFamiliar(getCuotaFamiliar());
         getLstValorCuotaCB().get(codigo).setCuotaInquilino(getCuotaInquilino());
         getLstValorCuotaCB().get(codigo).setCuotaTaxista(getCuotaTaxistas());
         getLstValorCuotaCB().get(codigo).setCuotaMilOficio(getCuotaMilOficios());
         getLstValorCuotaCB().get(codigo).setCuotaEmprendedor(getCuotaEmprendedores());
         getLstValorCuotaCB().get(codigo).setCuotaAma(getCuotaAmasCasa());
         getLstValorCuotaCB().get(codigo).setCuotaEmpleada(getCuotaEmpleadasHogar());
         getLstValorCuotaCB().get(codigo).setCuotaJubilado(getCuotaJubiPen());
         getLstValorCuotaCB().get(codigo).setCuotaRemesa(getCuotaRemesas());
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
         getLstValorCuotaCNB().get(codigo).setCuotaTaxista(getCuotaTaxistas());
         getLstValorCuotaCNB().get(codigo).setCuotaMilOficio(getCuotaMilOficios());
         getLstValorCuotaCNB().get(codigo).setCuotaEmprendedor(getCuotaEmprendedores());
         getLstValorCuotaCNB().get(codigo).setCuotaAma(getCuotaAmasCasa());
         getLstValorCuotaCNB().get(codigo).setCuotaEmpleada(getCuotaEmpleadasHogar());
         getLstValorCuotaCNB().get(codigo).setCuotaJubilado(getCuotaJubiPen());
         getLstValorCuotaCNB().get(codigo).setCuotaRemesa(getCuotaRemesas());
         getLstValorCuotaCNB().get(codigo).setCuotaX1(getCuotaX1());
         getLstValorCuotaCNB().get(codigo).setCuotaX2(getCuotaX2());
         getLstValorCuotaCNB().get(codigo).setCuotaX3(getCuotaX3());
         getLstValorCuotaCNB().get(codigo).setCuotaX4(getCuotaX4());
            
         getSession().put("valorCuotaCNB", getLstValorCuotaCNB());
         }*/
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

    public String perfil() {
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
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("grabar") != null) {
            CUsuarios loUsuario = new CUsuarios();
            loUsuario.setUrl(getUrl());
            loUsuario.setUser(user);
            loUsuario.setPasswd(pass);
            loUsuario.setUsuario(getUsuario());
            try {
                boolean llOk = loUsuario.mxActualizarPassword();
                if (!llOk) {
                    setError(loUsuario.getError());
                } else {
                    setMensaje(loUsuario.getMensaje());
                    setResult("login");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else {
            setUsuario(new Usuario());
            getUsuario().setCorreo(user);
            setResult("perfil");
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
                    CCanales loCanal = new CCanales();
                    loCanal.setUrl(getUrl());
                    loCanal.setUser(user);
                    loCanal.setPasswd(pass);
                    setLstCanales(loCanal.getLstCanales());
                    if (getLstCanales() == null) {
                        setError(loCanal.getError());
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
                    }
                }
            }
        } catch (SQLException loErr) {
            setError(loErr.getMessage());
            setResult("error");
        }
        return getResult();
    }

    public String frmADMMntProductos() {
        CProduct products = new CProduct();
        setLstProducts(products.getLstProducts());
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
        setResult("frmADMMntProductos");
        /*try {
         CProduct loProduct = new CProduct();
         loProduct.setUrl(getUrl());
         loProduct.setUser(user);
         loProduct.setPasswd(pass);*/

        if (ActionContext.getContext().getParameters().get("boton.nuevo") != null) {
            setProduct(new Product());
            setInformacion("Ingrese información y presione GRABAR");
        } else {
            if (ActionContext.getContext().getParameters().get("boton.grabar") != null) {
                /*loOficina.setOficina(getOficina());
                 boolean llOk = loOficina.mxGrabar();
                 if (llOk) {
                 setMensaje(loOficina.getMensaje());
                 } else {
                 setError(loOficina.getError());
                 }*/
                setProduct(getProduct());
                setMensaje("Información grabada correctamente");
            } else {
                if (ActionContext.getContext().getParameters().get("boton.buscar") != null) {
                    /*loOficina.setOficina(getOficina());
                     setLstOficinas(loOficina.mxBuscar());*/
                } else {
                    if (ActionContext.getContext().getParameters().get("boton.aplicar") != null
                            || ActionContext.getContext().getParameters().get("product.cod") != null) {
                        /*loOficina.setOficina(getOficina());
                         boolean llOk = loOficina.mxAplicar();
                         if (llOk) {
                         setOficina(loOficina.getOficina());
                         } else {
                         setError(loOficina.getError());
                         }*/
                    }
                }
            }
        }
        if (ActionContext.getContext().getParameters().get("boton.buscar") == null) {
            //setLstOficinas(loOficina.getLstOficinas());
            if (getLstOficinas() == null) {
                //setError(loOficina.getError());
            }
        }
        /*} catch (SQLException loErr) {
         setError(loErr.getMessage());
         setResult("error");
         }*/
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
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                loCredito.setIp(getIp());
                boolean llOk = loCredito.mxPagar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setCredito(new Credito());
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("cancelar") != null) {
            setCredito(new Credito());
        }
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCREAmortizacion() {
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
            setResult("frmCREAmortizacion");
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
        } else if (request.getParameter("simular") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxVerAmortizacion();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCREAmortizar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("cancelar") != null) {
            setCredito(new Credito());
        }
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCREReestructuracion() {
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
            setResult("frmCREReestructuracion");
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
        } else if (request.getParameter("simular") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxVerReestructuracion();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCREReestructurar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("cancelar") != null) {
            setCredito(new Credito());
        }
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCRERefinanciacion() {
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
            setResult("frmCRERefinanciacion");
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
        } else if (request.getParameter("simular") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxVerRefinanciacion();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCRERefinanciar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("cancelar") != null) {
            setCredito(new Credito());
        }
        return getResult();
    }

    //SUBMODULO CREDITO COBRANZA
    public String frmCRECancelacion() {
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
            setResult("frmCRECancelacion");
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
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxCancelar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        } else if (request.getParameter("cancelar") != null) {
            setCredito(new Credito());
        }
        return getResult();
    }

    //SUBMODULO REPORTE MORA
    public String frmCREAmortizar() {
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
        setResult("frmCREAmortizar");
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("grabar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxAmortizar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCREAmortizar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //SUBMODULO REPORTE MORA
    public String frmCREReestructurar() {
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
        setResult("frmCREReestructurar");
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("grabar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxReestructurar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCREReestructurar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
        }
        return getResult();
    }

    //SUBMODULO REPORTE MORA
    public String frmCRERefinanciar() {
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
        setResult("frmCRERefinanciar");
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("grabar") != null) {
            CCreditos loCredito = new CCreditos();
            loCredito.setUrl(getUrl());
            loCredito.setUser(user);
            loCredito.setPasswd(pass);
            loCredito.setCredito(getCredito());
            try {
                boolean llOk = loCredito.mxRefinanciar();
                if (!llOk) {
                    setError(loCredito.getError());
                } else {
                    setMensaje(loCredito.getMensaje());
                    setResult("frmCRERefinanciar");
                }
            } catch (SQLException | ParseException loErr) {
                setError(loErr.getMessage());
            }
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
        setResult("frmREPCRESolicitud");
        return getResult();
    }

    public String generarSolicitudXLS() {
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
            boolean llOk = loCreditos.mxGenerarReporteSolicitudesPresentadas();
            if (!llOk) {
                setError(loCreditos.getError());
            } else {
                llOk = loRep.mxGenerarSolicitudesPresentadas(loCreditos.getLstCreditos());
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
        return frmREPCRESolicitud();
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

    /*public void llenarListas(int lista) {
     switch (lista) {
     case 1:
     for(int x=0;x<getLstRangosCB().size();x++) {
     getLstVerifiPerfCB().get(x).setPerfil(getLstRangosCB().get(x).getNombre());
     }
     for(int x=0;x<getLstRangosCNB().size();x++) {
     getLstVerifiPerfCNB().get(x).setPerfil(getLstRangosCNB().get(x).getNombre());
     }
     break;
     case 2:
     for(int x=0;x<getLstRangosCB().size();x++) {
     getLstLineaCreCB().get(x).setPerfil(getLstRangosCB().get(x).getNombre());
     }
     for(int x=0;x<getLstRangosCNB().size();x++) {
     getLstLineaCreCNB().get(x).setPerfil(getLstRangosCNB().get(x).getNombre());
     }
     break;
     case 3:
     for(int x=0;x<getLstRangosCB().size();x++) {
     getLstPlazosCB().get(x).setPerfil(getLstRangosCB().get(x).getNombre());
     }
     for(int x=0;x<getLstRangosCNB().size();x++) {
     getLstPlazosCNB().get(x).setPerfil(getLstRangosCNB().get(x).getNombre());
     }
     break;
     case 4:
     for(int x=0;x<getLstRangosCB().size();x++) {
     getLstValorCuotaCB().get(x).setPerfil(getLstRangosCB().get(x).getNombre());
     }
     for(int x=0;x<getLstRangosCNB().size();x++) {
     getLstValorCuotaCNB().get(x).setPerfil(getLstRangosCNB().get(x).getNombre());
     }
     break;
     default:
     break;
     }
     }*/
    public double calcularTEM(double tea) {
        double tem = ((Math.pow((1 + (tea / 100)), (1.0 / 12.0))) - 1) * 100;
        tem = Math.rint(tem * 100) / 100;
        return tem;
    }

    public double calcularCuota(double monto, int n, double tea) {
        double tem = calcularTEM(tea);
        double cuota = monto * (((tem / 100) * Math.pow(1 + (tem / 100), n)) / (Math.pow(1 + (tem / 100), n) - 1));
        cuota = Math.rint(cuota * 100) / 100;
        return cuota;
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
     * @return the archivoClientes
     */
    public File getArchivoClientes1() {
        return archivoClientes1;
    }

    /**
     * @param archivoClientes the archivoClientes to set
     */
    public void setArchivoClientes1(File archivoClientes1) {
        this.archivoClientes1 = archivoClientes1;
    }

    /**
     * @return the archivoClientesFileName
     */
    public String getArchivoClientesFileName1() {
        return archivoClientesFileName1;
    }

    /**
     * @param archivoClientesFileName the archivoClientesFileName to set
     */
    public void setArchivoClientesFileName1(String archivoClientesFileName1) {
        this.archivoClientesFileName1 = archivoClientesFileName1;
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
     * @return the lstTipProf
     */
    public List<Tabla> getLstTipProf() {
        return lstTipProf;
    }

    /**
     * @param lstTipProf the lstNivEst to set
     */
    public void setLstTipProf(List<Tabla> lstTipProf) {
        this.lstNivIns = lstTipProf;
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

    public List<Rango> getLstRangosCB() {
        return lstRangosCB;
    }

    public void setLstRangosCB(List<Rango> lstRangosCB) {
        this.lstRangosCB = lstRangosCB;
    }

    public List<Rango> getLstRangosCNB() {
        return lstRangosCNB;
    }

    public void setLstRangosCNB(List<Rango> lstRangosCNB) {
        this.lstRangosCNB = lstRangosCNB;
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

    public int getTaxista() {
        return taxista;
    }

    public void setTaxista(int taxista) {
        this.taxista = taxista;
    }

    public int getMilOficio() {
        return milOficio;
    }

    public void setMilOficio(int milOficio) {
        this.milOficio = milOficio;
    }

    public int getEmprendedor() {
        return emprendedor;
    }

    public void setEmprendedor(int emprendedor) {
        this.emprendedor = emprendedor;
    }

    public int getAma() {
        return ama;
    }

    public void setAma(int ama) {
        this.ama = ama;
    }

    public int getEmpleada() {
        return empleada;
    }

    public void setEmpleada(int empleada) {
        this.empleada = empleada;
    }

    public int getJubilado() {
        return jubilado;
    }

    public void setJubilado(int jubilado) {
        this.jubilado = jubilado;
    }

    public int getRemesa() {
        return remesa;
    }

    public void setRemesa(int remesa) {
        this.remesa = remesa;
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

    public double getLineaTaxista() {
        return lineaTaxista;
    }

    public void setLineaTaxista(double lineaTaxista) {
        this.lineaTaxista = lineaTaxista;
    }

    public double getLineaMilOficio() {
        return lineaMilOficio;
    }

    public void setLineaMilOficio(double lineaMilOficio) {
        this.lineaMilOficio = lineaMilOficio;
    }

    public double getLineaEmprendedor() {
        return lineaEmprendedor;
    }

    public void setLineaEmprendedor(double lineaEmprendedor) {
        this.lineaEmprendedor = lineaEmprendedor;
    }

    public double getLineaAma() {
        return lineaAma;
    }

    public void setLineaAma(double lineaAma) {
        this.lineaAma = lineaAma;
    }

    public double getLineaEmpleada() {
        return lineaEmpleada;
    }

    public void setLineaEmpleada(double lineaEmpleada) {
        this.lineaEmpleada = lineaEmpleada;
    }

    public double getLineaJubilado() {
        return lineaJubilado;
    }

    public void setLineaJubilado(double lineaJubilado) {
        this.lineaJubilado = lineaJubilado;
    }

    public double getLineaRemesa() {
        return lineaRemesa;
    }

    public void setLineaRemesa(double lineaRemesa) {
        this.lineaRemesa = lineaRemesa;
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

    public int getCuotasTaxista() {
        return cuotasTaxista;
    }

    public void setCuotasTaxista(int cuotasTaxista) {
        this.cuotasTaxista = cuotasTaxista;
    }

    public int getCuotasMilOficio() {
        return cuotasMilOficio;
    }

    public void setCuotasMilOficio(int cuotasMilOficio) {
        this.cuotasMilOficio = cuotasMilOficio;
    }

    public int getCuotasEmprendedor() {
        return cuotasEmprendedor;
    }

    public void setCuotasEmprendedor(int cuotasEmprendedor) {
        this.cuotasEmprendedor = cuotasEmprendedor;
    }

    public int getCuotasAma() {
        return cuotasAma;
    }

    public void setCuotasAma(int cuotasAma) {
        this.cuotasAma = cuotasAma;
    }

    public int getCuotasEmpleada() {
        return cuotasEmpleada;
    }

    public void setCuotasEmpleada(int cuotasEmpleada) {
        this.cuotasEmpleada = cuotasEmpleada;
    }

    public int getCuotasJubilado() {
        return cuotasJubilado;
    }

    public void setCuotasJubilado(int cuotasJubilado) {
        this.cuotasJubilado = cuotasJubilado;
    }

    public int getCuotasRemesa() {
        return cuotasRemesa;
    }

    public void setCuotasRemesa(int cuotasRemesa) {
        this.cuotasRemesa = cuotasRemesa;
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

    public double getCuotaTaxista() {
        return cuotaTaxista;
    }

    public void setCuotaTaxista(double cuotaTaxista) {
        this.cuotaTaxista = cuotaTaxista;
    }

    public double getCuotaMilOficio() {
        return cuotaMilOficio;
    }

    public void setCuotaMilOficio(double cuotaMilOficio) {
        this.cuotaMilOficio = cuotaMilOficio;
    }

    public double getCuotaEmprendedor() {
        return cuotaEmprendedor;
    }

    public void setCuotaEmprendedor(double cuotaEmprendedor) {
        this.cuotaEmprendedor = cuotaEmprendedor;
    }

    public double getCuotaAma() {
        return cuotaAma;
    }

    public void setCuotaAma(double cuotaAma) {
        this.cuotaAma = cuotaAma;
    }

    public double getCuotaEmpleada() {
        return cuotaEmpleada;
    }

    public void setCuotaEmpleada(double cuotaEmpleada) {
        this.cuotaEmpleada = cuotaEmpleada;
    }

    public double getCuotaJubilado() {
        return cuotaJubilado;
    }

    public void setCuotaJubilado(double cuotaJubilado) {
        this.cuotaJubilado = cuotaJubilado;
    }

    public double getCuotaRemesa() {
        return cuotaRemesa;
    }

    public void setCuotaRemesa(double cuotaRemesa) {
        this.cuotaRemesa = cuotaRemesa;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the lstProducts
     */
    public List<Product> getLstProducts() {
        return lstProducts;
    }

    /**
     * @param lstProducts the lstProducts to set
     */
    public void setLstProducts(List<Product> lstProducts) {
        this.lstProducts = lstProducts;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    public List<String> getLstOficina() {
        return lstOficina;
    }

    public void setLstOficina(List<String> lstOficina) {
        this.lstOficina = lstOficina;
    }

    public java.sql.Date getFecmoraIni() {
        return FecmoraIni;
    }

    public void setFecmoraIni(java.sql.Date FecmoraIni) {
        this.FecmoraIni = FecmoraIni;
    }

    public java.sql.Date getFecmoraFin() {
        return FecmoraFin;
    }

    public void setFecmoraFin(java.sql.Date FecmoraFin) {
        this.FecmoraFin = FecmoraFin;
    }

    public String getSolCLIcodEvaluador() {
        return solCLIcodEvaluador;
    }

    public void setSolCLIcodEvaluador(String solCLIcodEvaluador) {
        this.solCLIcodEvaluador = solCLIcodEvaluador;
    }

    public String getSolCLIpuntVenta() {
        return solCLIpuntVenta;
    }

    public void setSolCLIpuntVenta(String solCLIpuntVenta) {
        this.solCLIpuntVenta = solCLIpuntVenta;
    }

    public String getSolCLIfecSolicitud() {
        return solCLIfecSolicitud;
    }

    public void setSolCLIfecSolicitud(String solCLIfecSolicitud) {
        this.solCLIfecSolicitud = solCLIfecSolicitud;
    }

    public String getSolCLIciudadExp() {
        return solCLIciudadExp;
    }

    public void setSolCLIciudadExp(String solCLIciudadExp) {
        this.solCLIciudadExp = solCLIciudadExp;
    }

    public String getSolCLInacionalidad() {
        return solCLInacionalidad;
    }

    public void setSolCLInacionalidad(String solCLInacionalidad) {
        this.solCLInacionalidad = solCLInacionalidad;
    }

    public String getSolCLIciudadNac() {
        return solCLIciudadNac;
    }

    public void setSolCLIciudadNac(String solCLIciudadNac) {
        this.solCLIciudadNac = solCLIciudadNac;
    }

    public String getSolCLIpaisNac() {
        return solCLIpaisNac;
    }

    public void setSolCLIpaisNac(String solCLIpaisNac) {
        this.solCLIpaisNac = solCLIpaisNac;
    }

    public String getSolCLInperDepend() {
        return solCLInperDepend;
    }

    public void setSolCLInperDepend(String solCLInperDepend) {
        this.solCLInperDepend = solCLInperDepend;
    }

    public String getSolCLI_conyugPrimerNomb() {
        return solCLI_conyugPrimerNomb;
    }

    public void setSolCLI_conyugPrimerNomb(String solCLI_conyugPrimerNomb) {
        this.solCLI_conyugPrimerNomb = solCLI_conyugPrimerNomb;
    }

    public String getSolCLI_conyugSegundoNomb() {
        return solCLI_conyugSegundoNomb;
    }

    public void setSolCLI_conyugSegundoNomb(String solCLI_conyugSegundoNomb) {
        this.solCLI_conyugSegundoNomb = solCLI_conyugSegundoNomb;
    }

    public String getSolCLI_conyugPrimerApel() {
        return solCLI_conyugPrimerApel;
    }

    public void setSolCLI_conyugPrimerApel(String solCLI_conyugPrimerApel) {
        this.solCLI_conyugPrimerApel = solCLI_conyugPrimerApel;
    }

    public String getSolCLI_conyugSegundoApel() {
        return solCLI_conyugSegundoApel;
    }

    public void setSolCLI_conyugSegundoApel(String solCLI_conyugSegundoApel) {
        this.solCLI_conyugSegundoApel = solCLI_conyugSegundoApel;
    }

    public String getSolCLI_conyugEmpresaTrab() {
        return solCLI_conyugEmpresaTrab;
    }

    public void setSolCLI_conyugEmpresaTrab(String solCLI_conyugEmpresaTrab) {
        this.solCLI_conyugEmpresaTrab = solCLI_conyugEmpresaTrab;
    }

    public String getSolCLI_conyugEmpresaCarg() {
        return solCLI_conyugEmpresaCarg;
    }

    public void setSolCLI_conyugEmpresaCarg(String solCLI_conyugEmpresaCarg) {
        this.solCLI_conyugEmpresaCarg = solCLI_conyugEmpresaCarg;
    }

    public String getSolCLI_conyugEmpresaTele() {
        return solCLI_conyugEmpresaTele;
    }

    public void setSolCLI_conyugEmpresaTele(String solCLI_conyugEmpresaTele) {
        this.solCLI_conyugEmpresaTele = solCLI_conyugEmpresaTele;
    }

    public String getSolCLI_vivienSuministro() {
        return solCLI_vivienSuministro;
    }

    public void setSolCLI_vivienSuministro(String solCLI_vivienSuministro) {
        this.solCLI_vivienSuministro = solCLI_vivienSuministro;
    }

    public String getSolCLI_vivienTitularSuminis() {
        return solCLI_vivienTitularSuminis;
    }

    public void setSolCLI_vivienTitularSuminis(String solCLI_vivienTitularSuminis) {
        this.solCLI_vivienTitularSuminis = solCLI_vivienTitularSuminis;
    }

    public String getSolCLI_vivienRelacionTitu() {
        return solCLI_vivienRelacionTitu;
    }

    public void setSolCLI_vivienRelacionTitu(String solCLI_vivienRelacionTitu) {
        this.solCLI_vivienRelacionTitu = solCLI_vivienRelacionTitu;
    }

    public String getSolCLI_vivienTipo() {
        return solCLI_vivienTipo;
    }

    public void setSolCLI_vivienTipo(String solCLI_vivienTipo) {
        this.solCLI_vivienTipo = solCLI_vivienTipo;
    }

    public String getSolCLI_vivienTiempo() {
        return solCLI_vivienTiempo;
    }

    public void setSolCLI_vivienTiempo(String solCLI_vivienTiempo) {
        this.solCLI_vivienTiempo = solCLI_vivienTiempo;
    }

    public String getSolCLI_vivienDireccion() {
        return solCLI_vivienDireccion;
    }

    public void setSolCLI_vivienDireccion(String solCLI_vivienDireccion) {
        this.solCLI_vivienDireccion = solCLI_vivienDireccion;
    }

    public String getSolCLI_vivienDistrito() {
        return solCLI_vivienDistrito;
    }

    public void setSolCLI_vivienDistrito(String solCLI_vivienDistrito) {
        this.solCLI_vivienDistrito = solCLI_vivienDistrito;
    }

    public String getSolCLI_vivienProvincia() {
        return solCLI_vivienProvincia;
    }

    public void setSolCLI_vivienProvincia(String solCLI_vivienProvincia) {
        this.solCLI_vivienProvincia = solCLI_vivienProvincia;
    }

    public String getSolCLI_vivienDepartamento() {
        return solCLI_vivienDepartamento;
    }

    public void setSolCLI_vivienDepartamento(String solCLI_vivienDepartamento) {
        this.solCLI_vivienDepartamento = solCLI_vivienDepartamento;
    }

    public String getSolCLI_empleadEmpresaNomb() {
        return solCLI_empleadEmpresaNomb;
    }

    public void setSolCLI_empleadEmpresaNomb(String solCLI_empleadEmpresaNomb) {
        this.solCLI_empleadEmpresaNomb = solCLI_empleadEmpresaNomb;
    }

    public String getSolCLI_empleadEmpresaRuc() {
        return solCLI_empleadEmpresaRuc;
    }

    public void setSolCLI_empleadEmpresaRuc(String solCLI_empleadEmpresaRuc) {
        this.solCLI_empleadEmpresaRuc = solCLI_empleadEmpresaRuc;
    }

    public String getSolCLI_empleadEmpresaActi() {
        return solCLI_empleadEmpresaActi;
    }

    public void setSolCLI_empleadEmpresaActi(String solCLI_empleadEmpresaActi) {
        this.solCLI_empleadEmpresaActi = solCLI_empleadEmpresaActi;
    }

    public String getSolCLI_empleadEmpresaDire() {
        return solCLI_empleadEmpresaDire;
    }

    public void setSolCLI_empleadEmpresaDire(String solCLI_empleadEmpresaDire) {
        this.solCLI_empleadEmpresaDire = solCLI_empleadEmpresaDire;
    }

    public String getSolCLI_empleadEmpresaDepa() {
        return solCLI_empleadEmpresaDepa;
    }

    public void setSolCLI_empleadEmpresaDepa(String solCLI_empleadEmpresaDepa) {
        this.solCLI_empleadEmpresaDepa = solCLI_empleadEmpresaDepa;
    }

    public String getSolCLI_empleadEmpresaDist() {
        return solCLI_empleadEmpresaDist;
    }

    public void setSolCLI_empleadEmpresaDist(String solCLI_empleadEmpresaDist) {
        this.solCLI_empleadEmpresaDist = solCLI_empleadEmpresaDist;
    }

    public String getSolCLI_empleadEmpresaProv() {
        return solCLI_empleadEmpresaProv;
    }

    public void setSolCLI_empleadEmpresaProv(String solCLI_empleadEmpresaProv) {
        this.solCLI_empleadEmpresaProv = solCLI_empleadEmpresaProv;
    }

    public String getSolCLI_independILabor() {
        return solCLI_independILabor;
    }

    public void setSolCLI_independILabor(String solCLI_independILabor) {
        this.solCLI_independILabor = solCLI_independILabor;
    }

    public String getSolCLI_independITiempoViv() {
        return solCLI_independITiempoViv;
    }

    public void setSolCLI_independITiempoViv(String solCLI_independITiempoViv) {
        this.solCLI_independITiempoViv = solCLI_independITiempoViv;
    }

    public String getSolCLI_independITipo() {
        return solCLI_independITipo;
    }

    public void setSolCLI_independITipo(String solCLI_independITipo) {
        this.solCLI_independITipo = solCLI_independITipo;
    }

    public String getSolCLI_independITipoaux() {
        return solCLI_independITipoaux;
    }

    public void setSolCLI_independITipoaux(String solCLI_independITipoaux) {
        this.solCLI_independITipoaux = solCLI_independITipoaux;
    }

    public String getSolCLI_independFEmpresaNomb() {
        return solCLI_independFEmpresaNomb;
    }

    public void setSolCLI_independFEmpresaNomb(String solCLI_independFEmpresaNomb) {
        this.solCLI_independFEmpresaNomb = solCLI_independFEmpresaNomb;
    }

    public String getSolCLI_independFEmpresaRuc() {
        return solCLI_independFEmpresaRuc;
    }

    public void setSolCLI_independFEmpresaRuc(String solCLI_independFEmpresaRuc) {
        this.solCLI_independFEmpresaRuc = solCLI_independFEmpresaRuc;
    }

    public String getSolCLI_independFCargo() {
        return solCLI_independFCargo;
    }

    public void setSolCLI_independFCargo(String solCLI_independFCargo) {
        this.solCLI_independFCargo = solCLI_independFCargo;
    }

    public String getSolCLI_independFLaboraDire() {
        return solCLI_independFLaboraDire;
    }

    public void setSolCLI_independFLaboraDire(String solCLI_independFLaboraDire) {
        this.solCLI_independFLaboraDire = solCLI_independFLaboraDire;
    }

    public String getSolCLI_independFLaboraDist() {
        return solCLI_independFLaboraDist;
    }

    public void setSolCLI_independFLaboraDist(String solCLI_independFLaboraDist) {
        this.solCLI_independFLaboraDist = solCLI_independFLaboraDist;
    }

    public String getSolCLI_independFLaboraProv() {
        return solCLI_independFLaboraProv;
    }

    public void setSolCLI_independFLaboraProv(String solCLI_independFLaboraProv) {
        this.solCLI_independFLaboraProv = solCLI_independFLaboraProv;
    }

    public String getSolCLI_independFLaboraDepa() {
        return solCLI_independFLaboraDepa;
    }

    public void setSolCLI_independFLaboraDepa(String solCLI_independFLaboraDepa) {
        this.solCLI_independFLaboraDepa = solCLI_independFLaboraDepa;
    }

    public String getSolCLI_independFTelefono() {
        return solCLI_independFTelefono;
    }

    public void setSolCLI_independFTelefono(String solCLI_independFTelefono) {
        this.solCLI_independFTelefono = solCLI_independFTelefono;
    }

    public String getSolCLI_independFAnexo() {
        return solCLI_independFAnexo;
    }

    public void setSolCLI_independFAnexo(String solCLI_independFAnexo) {
        this.solCLI_independFAnexo = solCLI_independFAnexo;
    }

    public String getSolCLI_independFCorreo() {
        return solCLI_independFCorreo;
    }

    public void setSolCLI_independFCorreo(String solCLI_independFCorreo) {
        this.solCLI_independFCorreo = solCLI_independFCorreo;
    }

    public String getSolCLI_jubilEmpresaNombJubi() {
        return solCLI_jubilEmpresaNombJubi;
    }

    public void setSolCLI_jubilEmpresaNombJubi(String solCLI_jubilEmpresaNombJubi) {
        this.solCLI_jubilEmpresaNombJubi = solCLI_jubilEmpresaNombJubi;
    }

    public String getSolCLI_jubilEmpresaNombApor() {
        return solCLI_jubilEmpresaNombApor;
    }

    public void setSolCLI_jubilEmpresaNombApor(String solCLI_jubilEmpresaNombApor) {
        this.solCLI_jubilEmpresaNombApor = solCLI_jubilEmpresaNombApor;
    }

    public String getSolCLI_jubilEmpresaTiempo() {
        return solCLI_jubilEmpresaTiempo;
    }

    public void setSolCLI_jubilEmpresaTiempo(String solCLI_jubilEmpresaTiempo) {
        this.solCLI_jubilEmpresaTiempo = solCLI_jubilEmpresaTiempo;
    }

    public double getSolCLI_infofinanIngSueldoBasic() {
        return solCLI_infofinanIngSueldoBasic;
    }

    public void setSolCLI_infofinanIngSueldoBasic(double solCLI_infofinanIngSueldoBasic) {
        this.solCLI_infofinanIngSueldoBasic = solCLI_infofinanIngSueldoBasic;
    }

    public double getSolCLI_infofinanIngComisiones() {
        return solCLI_infofinanIngComisiones;
    }

    public void setSolCLI_infofinanIngComisiones(double solCLI_infofinanIngComisiones) {
        this.solCLI_infofinanIngComisiones = solCLI_infofinanIngComisiones;
    }

    public double getSolCLI_infofinanIngHonorarios() {
        return solCLI_infofinanIngHonorarios;
    }

    public void setSolCLI_infofinanIngHonorarios(double solCLI_infofinanIngHonorarios) {
        this.solCLI_infofinanIngHonorarios = solCLI_infofinanIngHonorarios;
    }

    public double getSolCLI_infofinanIngAlquileres() {
        return solCLI_infofinanIngAlquileres;
    }

    public void setSolCLI_infofinanIngAlquileres(double solCLI_infofinanIngAlquileres) {
        this.solCLI_infofinanIngAlquileres = solCLI_infofinanIngAlquileres;
    }

    public double getSolCLI_infofinanIngOtros() {
        return solCLI_infofinanIngOtros;
    }

    public void setSolCLI_infofinanIngOtros(double solCLI_infofinanIngOtros) {
        this.solCLI_infofinanIngOtros = solCLI_infofinanIngOtros;
    }

    public double getSolCLI_infofinanIngTotal() {
        return solCLI_infofinanIngTotal;
    }

    public void setSolCLI_infofinanIngTotal(double solCLI_infofinanIngTotal) {
        this.solCLI_infofinanIngTotal = solCLI_infofinanIngTotal;
    }

    public double getSolCLI_infofinanIngTotalAct() {
        return solCLI_infofinanIngTotalAct;
    }

    public void setSolCLI_infofinanIngTotalAct(double solCLI_infofinanIngTotalAct) {
        this.solCLI_infofinanIngTotalAct = solCLI_infofinanIngTotalAct;
    }

    public double getSolCLI_infofinanGasAlquiler() {
        return solCLI_infofinanGasAlquiler;
    }

    public void setSolCLI_infofinanGasAlquiler(double solCLI_infofinanGasAlquiler) {
        this.solCLI_infofinanGasAlquiler = solCLI_infofinanGasAlquiler;
    }

    public double getSolCLI_infofinanGasCreditoViv() {
        return solCLI_infofinanGasCreditoViv;
    }

    public void setSolCLI_infofinanGasCreditoViv(double solCLI_infofinanGasCreditoViv) {
        this.solCLI_infofinanGasCreditoViv = solCLI_infofinanGasCreditoViv;
    }

    public double getSolCLI_infofinanGasFamiliar() {
        return solCLI_infofinanGasFamiliar;
    }

    public void setSolCLI_infofinanGasFamiliar(double solCLI_infofinanGasFamiliar) {
        this.solCLI_infofinanGasFamiliar = solCLI_infofinanGasFamiliar;
    }

    public double getSolCLI_infofinanGasTarjetasCred() {
        return solCLI_infofinanGasTarjetasCred;
    }

    public void setSolCLI_infofinanGasTarjetasCred(double solCLI_infofinanGasTarjetasCred) {
        this.solCLI_infofinanGasTarjetasCred = solCLI_infofinanGasTarjetasCred;
    }

    public double getSolCLI_infofinanGasOtros() {
        return solCLI_infofinanGasOtros;
    }

    public void setSolCLI_infofinanGasOtros(double solCLI_infofinanGasOtros) {
        this.solCLI_infofinanGasOtros = solCLI_infofinanGasOtros;
    }

    public double getSolCLI_infofinanGasTotal() {
        return solCLI_infofinanGasTotal;
    }

    public void setSolCLI_infofinanGasTotal(double solCLI_infofinanGasTotal) {
        this.solCLI_infofinanGasTotal = solCLI_infofinanGasTotal;
    }

    public double getSolCLI_infofinanGasTotalPat() {
        return solCLI_infofinanGasTotalPat;
    }

    public void setSolCLI_infofinanGasTotalPat(double solCLI_infofinanGasTotalPat) {
        this.solCLI_infofinanGasTotalPat = solCLI_infofinanGasTotalPat;
    }

    public String getSolCLI_refepersonPrimerNomb() {
        return solCLI_refepersonPrimerNomb;
    }

    public void setSolCLI_refepersonPrimerNomb(String solCLI_refepersonPrimerNomb) {
        this.solCLI_refepersonPrimerNomb = solCLI_refepersonPrimerNomb;
    }

    public String getSolCLI_refepersonSegundoNomb() {
        return solCLI_refepersonSegundoNomb;
    }

    public void setSolCLI_refepersonSegundoNomb(String solCLI_refepersonSegundoNomb) {
        this.solCLI_refepersonSegundoNomb = solCLI_refepersonSegundoNomb;
    }

    public String getSolCLI_refepersonPrimerApel() {
        return solCLI_refepersonPrimerApel;
    }

    public void setSolCLI_refepersonPrimerApel(String solCLI_refepersonPrimerApel) {
        this.solCLI_refepersonPrimerApel = solCLI_refepersonPrimerApel;
    }

    public String getSolCLI_refepersonSegundoApel() {
        return solCLI_refepersonSegundoApel;
    }

    public void setSolCLI_refepersonSegundoApel(String solCLI_refepersonSegundoApel) {
        this.solCLI_refepersonSegundoApel = solCLI_refepersonSegundoApel;
    }

    public String getSolCLI_refepersonDireccion() {
        return solCLI_refepersonDireccion;
    }

    public void setSolCLI_refepersonDireccion(String solCLI_refepersonDireccion) {
        this.solCLI_refepersonDireccion = solCLI_refepersonDireccion;
    }

    public String getSolCLI_refepersonDistrito() {
        return solCLI_refepersonDistrito;
    }

    public void setSolCLI_refepersonDistrito(String solCLI_refepersonDistrito) {
        this.solCLI_refepersonDistrito = solCLI_refepersonDistrito;
    }

    public String getSolCLI_refepersonProvincia() {
        return solCLI_refepersonProvincia;
    }

    public void setSolCLI_refepersonProvincia(String solCLI_refepersonProvincia) {
        this.solCLI_refepersonProvincia = solCLI_refepersonProvincia;
    }

    public String getSolCLI_refepersonEstado() {
        return solCLI_refepersonEstado;
    }

    public void setSolCLI_refepersonEstado(String solCLI_refepersonEstado) {
        this.solCLI_refepersonEstado = solCLI_refepersonEstado;
    }

    public String getSolCLI_refepersonTelefono() {
        return solCLI_refepersonTelefono;
    }

    public void setSolCLI_refepersonTelefono(String solCLI_refepersonTelefono) {
        this.solCLI_refepersonTelefono = solCLI_refepersonTelefono;
    }

    public String getSolCLI_refepersonCelular() {
        return solCLI_refepersonCelular;
    }

    public void setSolCLI_refepersonCelular(String solCLI_refepersonCelular) {
        this.solCLI_refepersonCelular = solCLI_refepersonCelular;
    }

    public String getSolCLI_refepersonParentesco() {
        return solCLI_refepersonParentesco;
    }

    public void setSolCLI_refepersonParentesco(String solCLI_refepersonParentesco) {
        this.solCLI_refepersonParentesco = solCLI_refepersonParentesco;
    }

    public String getSolCLI_refefamiliPrimerNomb() {
        return solCLI_refefamiliPrimerNomb;
    }

    public void setSolCLI_refefamiliPrimerNomb(String solCLI_refefamiliPrimerNomb) {
        this.solCLI_refefamiliPrimerNomb = solCLI_refefamiliPrimerNomb;
    }

    public String getSolCLI_refefamiliSegundoNomb() {
        return solCLI_refefamiliSegundoNomb;
    }

    public void setSolCLI_refefamiliSegundoNomb(String solCLI_refefamiliSegundoNomb) {
        this.solCLI_refefamiliSegundoNomb = solCLI_refefamiliSegundoNomb;
    }

    public String getSolCLI_refefamiliPrimerApel() {
        return solCLI_refefamiliPrimerApel;
    }

    public void setSolCLI_refefamiliPrimerApel(String solCLI_refefamiliPrimerApel) {
        this.solCLI_refefamiliPrimerApel = solCLI_refefamiliPrimerApel;
    }

    public String getSolCLI_refefamiliSegundoApel() {
        return solCLI_refefamiliSegundoApel;
    }

    public void setSolCLI_refefamiliSegundoApel(String solCLI_refefamiliSegundoApel) {
        this.solCLI_refefamiliSegundoApel = solCLI_refefamiliSegundoApel;
    }

    public String getSolCLI_refefamiliDireccion() {
        return solCLI_refefamiliDireccion;
    }

    public void setSolCLI_refefamiliDireccion(String solCLI_refefamiliDireccion) {
        this.solCLI_refefamiliDireccion = solCLI_refefamiliDireccion;
    }

    public String getSolCLI_refefamiliDistrito() {
        return solCLI_refefamiliDistrito;
    }

    public void setSolCLI_refefamiliDistrito(String solCLI_refefamiliDistrito) {
        this.solCLI_refefamiliDistrito = solCLI_refefamiliDistrito;
    }

    public String getSolCLI_refefamiliProvincia() {
        return solCLI_refefamiliProvincia;
    }

    public void setSolCLI_refefamiliProvincia(String solCLI_refefamiliProvincia) {
        this.solCLI_refefamiliProvincia = solCLI_refefamiliProvincia;
    }

    public String getSolCLI_refefamiliEstado() {
        return solCLI_refefamiliEstado;
    }

    public void setSolCLI_refefamiliEstado(String solCLI_refefamiliEstado) {
        this.solCLI_refefamiliEstado = solCLI_refefamiliEstado;
    }

    public String getSolCLI_refefamiliTelefono() {
        return solCLI_refefamiliTelefono;
    }

    public void setSolCLI_refefamiliTelefono(String solCLI_refefamiliTelefono) {
        this.solCLI_refefamiliTelefono = solCLI_refefamiliTelefono;
    }

    public String getSolCLI_refefamiliCelular() {
        return solCLI_refefamiliCelular;
    }

    public void setSolCLI_refefamiliCelular(String solCLI_refefamiliCelular) {
        this.solCLI_refefamiliCelular = solCLI_refefamiliCelular;
    }

    public String getSolCLI_refefamiliParentesco() {
        return solCLI_refefamiliParentesco;
    }

    public void setSolCLI_refefamiliParentesco(String solCLI_refefamiliParentesco) {
        this.solCLI_refefamiliParentesco = solCLI_refefamiliParentesco;
    }

    public String getSolCLI_refelabocliNombre() {
        return solCLI_refelabocliNombre;
    }

    public void setSolCLI_refelabocliNombre(String solCLI_refelabocliNombre) {
        this.solCLI_refelabocliNombre = solCLI_refelabocliNombre;
    }

    public String getSolCLI_refelabocliActividad() {
        return solCLI_refelabocliActividad;
    }

    public void setSolCLI_refelabocliActividad(String solCLI_refelabocliActividad) {
        this.solCLI_refelabocliActividad = solCLI_refelabocliActividad;
    }

    public String getSolCLI_refelabocliTelefono() {
        return solCLI_refelabocliTelefono;
    }

    public void setSolCLI_refelabocliTelefono(String solCLI_refelabocliTelefono) {
        this.solCLI_refelabocliTelefono = solCLI_refelabocliTelefono;
    }

    public String getSolCLI_refelabocliDireccion() {
        return solCLI_refelabocliDireccion;
    }

    public void setSolCLI_refelabocliDireccion(String solCLI_refelabocliDireccion) {
        this.solCLI_refelabocliDireccion = solCLI_refelabocliDireccion;
    }

    public String getSolCLI_refelabocliDistrito() {
        return solCLI_refelabocliDistrito;
    }

    public void setSolCLI_refelabocliDistrito(String solCLI_refelabocliDistrito) {
        this.solCLI_refelabocliDistrito = solCLI_refelabocliDistrito;
    }

    public String getSolCLI_refelabocliProvincia() {
        return solCLI_refelabocliProvincia;
    }

    public void setSolCLI_refelabocliProvincia(String solCLI_refelabocliProvincia) {
        this.solCLI_refelabocliProvincia = solCLI_refelabocliProvincia;
    }

    public String getSolCLI_refelabocliEstado() {
        return solCLI_refelabocliEstado;
    }

    public void setSolCLI_refelabocliEstado(String solCLI_refelabocliEstado) {
        this.solCLI_refelabocliEstado = solCLI_refelabocliEstado;
    }

    public String getSolCLI_refelaboproNombre() {
        return solCLI_refelaboproNombre;
    }

    public void setSolCLI_refelaboproNombre(String solCLI_refelaboproNombre) {
        this.solCLI_refelaboproNombre = solCLI_refelaboproNombre;
    }

    public String getSolCLI_refelaboproActividad() {
        return solCLI_refelaboproActividad;
    }

    public void setSolCLI_refelaboproActividad(String solCLI_refelaboproActividad) {
        this.solCLI_refelaboproActividad = solCLI_refelaboproActividad;
    }

    public String getSolCLI_refelaboproTelefono() {
        return solCLI_refelaboproTelefono;
    }

    public void setSolCLI_refelaboproTelefono(String solCLI_refelaboproTelefono) {
        this.solCLI_refelaboproTelefono = solCLI_refelaboproTelefono;
    }

    public String getSolCLI_refelaboproDireccion() {
        return solCLI_refelaboproDireccion;
    }

    public void setSolCLI_refelaboproDireccion(String solCLI_refelaboproDireccion) {
        this.solCLI_refelaboproDireccion = solCLI_refelaboproDireccion;
    }

    public String getSolCLI_refelaboproDistrito() {
        return solCLI_refelaboproDistrito;
    }

    public void setSolCLI_refelaboproDistrito(String solCLI_refelaboproDistrito) {
        this.solCLI_refelaboproDistrito = solCLI_refelaboproDistrito;
    }

    public String getSolCLI_refelaboproProvincia() {
        return solCLI_refelaboproProvincia;
    }

    public void setSolCLI_refelaboproProvincia(String solCLI_refelaboproProvincia) {
        this.solCLI_refelaboproProvincia = solCLI_refelaboproProvincia;
    }

    public String getSolCLI_refelaboproEstado() {
        return solCLI_refelaboproEstado;
    }

    public void setSolCLI_refelaboproEstado(String solCLI_refelaboproEstado) {
        this.solCLI_refelaboproEstado = solCLI_refelaboproEstado;
    }

    public File getArchivoSolFinan_EmpleadoRecibo() {
        return archivoSolFinan_EmpleadoRecibo;
    }

    public void setArchivoSolFinan_EmpleadoRecibo(File archivoSolFinan_EmpleadoRecibo) {
        this.archivoSolFinan_EmpleadoRecibo = archivoSolFinan_EmpleadoRecibo;
    }

    public String getArchivoSolFinan_EmpleadoReciboFileName() {
        return archivoSolFinan_EmpleadoReciboFileName;
    }

    public void setArchivoSolFinan_EmpleadoReciboFileName(String archivoSolFinan_EmpleadoReciboFileName) {
        this.archivoSolFinan_EmpleadoReciboFileName = archivoSolFinan_EmpleadoReciboFileName;
    }

    public File getArchivoSolFinan_EmpleadoCopiaDni() {
        return archivoSolFinan_EmpleadoCopiaDni;
    }

    public void setArchivoSolFinan_EmpleadoCopiaDni(File archivoSolFinan_EmpleadoCopiaDni) {
        this.archivoSolFinan_EmpleadoCopiaDni = archivoSolFinan_EmpleadoCopiaDni;
    }

    public String getArchivoSolFinan_EmpleadoCopiaDniFileName() {
        return archivoSolFinan_EmpleadoCopiaDniFileName;
    }

    public void setArchivoSolFinan_EmpleadoCopiadniFileName(String archivoSolFinan_EmpleadoCopiadniFileName) {
        this.archivoSolFinan_EmpleadoCopiaDniFileName = archivoSolFinan_EmpleadoCopiadniFileName;
    }

    public File getArchivoSolFinan_EmpleadoBoleta1() {
        return archivoSolFinan_EmpleadoBoleta1;
    }

    public void setArchivoSolFinan_EmpleadoBoleta1(File archivoSolFinan_EmpleadoBoleta1) {
        this.archivoSolFinan_EmpleadoBoleta1 = archivoSolFinan_EmpleadoBoleta1;
    }

    public String getArchivoSolFinan_EmpleadoBoleta1FileName() {
        return archivoSolFinan_EmpleadoBoleta1FileName;
    }

    public void setArchivoSolFinan_EmpleadoBoleta1FileName(String archivoSolFinan_EmpleadoBoleta1FileName) {
        this.archivoSolFinan_EmpleadoBoleta1FileName = archivoSolFinan_EmpleadoBoleta1FileName;
    }

    public File getArchivoSolFinan_EmpleadoBoleta2() {
        return archivoSolFinan_EmpleadoBoleta2;
    }

    public void setArchivoSolFinan_EmpleadoBoleta2(File archivoSolFinan_EmpleadoBoleta2) {
        this.archivoSolFinan_EmpleadoBoleta2 = archivoSolFinan_EmpleadoBoleta2;
    }

    public String getArchivoSolFinan_EmpleadoBoleta2FileName() {
        return archivoSolFinan_EmpleadoBoleta2FileName;
    }

    public void setArchivoSolFinan_EmpleadoBoleta2FileName(String archivoSolFinan_EmpleadoBoleta2FileName) {
        this.archivoSolFinan_EmpleadoBoleta2FileName = archivoSolFinan_EmpleadoBoleta2FileName;
    }

    public File getArchivoSolFinan_EmpleadoBoleta3() {
        return archivoSolFinan_EmpleadoBoleta3;
    }

    public void setArchivoSolFinan_EmpleadoBoleta3(File archivoSolFinan_EmpleadoBoleta3) {
        this.archivoSolFinan_EmpleadoBoleta3 = archivoSolFinan_EmpleadoBoleta3;
    }

    public String getArchivoSolFinan_EmpleadoBoleta3FileName() {
        return archivoSolFinan_EmpleadoBoleta3FileName;
    }

    public void setArchivoSolFinan_EmpleadoBoleta3FileName(String archivoSolFinan_EmpleadoBoleta3FileName) {
        this.archivoSolFinan_EmpleadoBoleta3FileName = archivoSolFinan_EmpleadoBoleta3FileName;
    }

    public File getArchivoSolFinan_EmpleadoCopiaArrendamiento() {
        return archivoSolFinan_EmpleadoCopiaArrendamiento;
    }

    public void setArchivoSolFinan_EmpleadoCopiaArrendamiento(File archivoSolFinan_EmpleadoCopiaArrendamiento) {
        this.archivoSolFinan_EmpleadoCopiaArrendamiento = archivoSolFinan_EmpleadoCopiaArrendamiento;
    }

    public String getArchivoSolFinan_EmpleadoCopiaArrendamientoFileName() {
        return archivoSolFinan_EmpleadoCopiaArrendamientoFileName;
    }

    public void setArchivoSolFinan_EmpleadoCopiaArrendamientoFileName(String archivoSolFinan_EmpleadoCopiaArrendamientoFileName) {
        this.archivoSolFinan_EmpleadoCopiaArrendamientoFileName = archivoSolFinan_EmpleadoCopiaArrendamientoFileName;
    }

    public File getArchivoSolFinan_IndependienteFReciboLuz() {
        return archivoSolFinan_IndependienteFReciboLuz;
    }

    public void setArchivoSolFinan_IndependienteFReciboLuz(File archivoSolFinan_IndependienteFReciboLuz) {
        this.archivoSolFinan_IndependienteFReciboLuz = archivoSolFinan_IndependienteFReciboLuz;
    }

    public String getArchivoSolFinan_IndependienteFReciboLuzFileName() {
        return archivoSolFinan_IndependienteFReciboLuzFileName;
    }

    public void setArchivoSolFinan_IndependienteFReciboLuzFileName(String archivoSolFinan_IndependienteFReciboLuzFileName) {
        this.archivoSolFinan_IndependienteFReciboLuzFileName = archivoSolFinan_IndependienteFReciboLuzFileName;
    }

    public File getArchivoSolFinan_IndependienteFCopiaDni() {
        return archivoSolFinan_IndependienteFCopiaDni;
    }

    public void setArchivoSolFinan_IndependienteFCopiaDni(File archivoSolFinan_IndependienteFCopiaDni) {
        this.archivoSolFinan_IndependienteFCopiaDni = archivoSolFinan_IndependienteFCopiaDni;
    }

    public String getArchivoSolFinan_IndependienteFCopiaDniFileName() {
        return archivoSolFinan_IndependienteFCopiaDniFileName;
    }

    public void setArchivoSolFinan_IndependienteFCopiaDniFileName(String archivoSolFinan_IndependienteFCopiaDniFileName) {
        this.archivoSolFinan_IndependienteFCopiaDniFileName = archivoSolFinan_IndependienteFCopiaDniFileName;
    }

    public File getArchivoSolFinan_IndependienteFCopiaRuc() {
        return archivoSolFinan_IndependienteFCopiaRuc;
    }

    public void setArchivoSolFinan_IndependienteFCopiaRuc(File archivoSolFinan_IndependienteFCopiaRuc) {
        this.archivoSolFinan_IndependienteFCopiaRuc = archivoSolFinan_IndependienteFCopiaRuc;
    }

    public String getArchivoSolFinan_IndependienteFCopiaRucFileName() {
        return archivoSolFinan_IndependienteFCopiaRucFileName;
    }

    public void setArchivoSolFinan_IndependienteFCopiaRucFileName(String archivoSolFinan_IndependienteFCopiaRucFileName) {
        this.archivoSolFinan_IndependienteFCopiaRucFileName = archivoSolFinan_IndependienteFCopiaRucFileName;
    }

    public File getArchivoSolFinan_IndependienteFExtracBanc1() {
        return archivoSolFinan_IndependienteFExtracBanc1;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc1(File archivoSolFinan_IndependienteFExtracBanc1) {
        this.archivoSolFinan_IndependienteFExtracBanc1 = archivoSolFinan_IndependienteFExtracBanc1;
    }

    public String getArchivoSolFinan_IndependienteFExtracBanc1FileName() {
        return archivoSolFinan_IndependienteFExtracBanc1FileName;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc1FileName(String archivoSolFinan_IndependienteFExtracBanc1FileName) {
        this.archivoSolFinan_IndependienteFExtracBanc1FileName = archivoSolFinan_IndependienteFExtracBanc1FileName;
    }

    public File getArchivoSolFinan_IndependienteFExtracBanc2() {
        return archivoSolFinan_IndependienteFExtracBanc2;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc2(File archivoSolFinan_IndependienteFExtracBanc2) {
        this.archivoSolFinan_IndependienteFExtracBanc2 = archivoSolFinan_IndependienteFExtracBanc2;
    }

    public String getArchivoSolFinan_IndependienteFExtracBanc2FileName() {
        return archivoSolFinan_IndependienteFExtracBanc2FileName;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc2FileName(String archivoSolFinan_IndependienteFExtracBanc2FileName) {
        this.archivoSolFinan_IndependienteFExtracBanc2FileName = archivoSolFinan_IndependienteFExtracBanc2FileName;
    }

    public File getArchivoSolFinan_IndependienteFExtracBanc3() {
        return archivoSolFinan_IndependienteFExtracBanc3;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc3(File archivoSolFinan_IndependienteFExtracBanc3) {
        this.archivoSolFinan_IndependienteFExtracBanc3 = archivoSolFinan_IndependienteFExtracBanc3;
    }

    public String getArchivoSolFinan_IndependienteFExtracBanc3FileName() {
        return archivoSolFinan_IndependienteFExtracBanc3FileName;
    }

    public void setArchivoSolFinan_IndependienteFExtracBanc3FileName(String archivoSolFinan_IndependienteFExtracBanc3FileName) {
        this.archivoSolFinan_IndependienteFExtracBanc3FileName = archivoSolFinan_IndependienteFExtracBanc3FileName;
    }

    public File getArchivoSolFinan_IndependienteFCopiaArrendamiento() {
        return archivoSolFinan_IndependienteFCopiaArrendamiento;
    }

    public void setArchivoSolFinan_IndependienteFCopiaArrendamiento(File archivoSolFinan_IndependienteFCopiaArrendamiento) {
        this.archivoSolFinan_IndependienteFCopiaArrendamiento = archivoSolFinan_IndependienteFCopiaArrendamiento;
    }

    public String getArchivoSolFinan_IndependienteFCopiaArrendamientoFileName() {
        return archivoSolFinan_IndependienteFCopiaArrendamientoFileName;
    }

    public void setArchivoSolFinan_IndependienteFCopiaArrendamientoFileName(String archivoSolFinan_IndependienteFCopiaArrendamientoFileName) {
        this.archivoSolFinan_IndependienteFCopiaArrendamientoFileName = archivoSolFinan_IndependienteFCopiaArrendamientoFileName;
    }

    public File getArchivoSolFinan_IndependienteFExtracAfp() {
        return archivoSolFinan_IndependienteFExtracAfp;
    }

    public void setArchivoSolFinan_IndependienteFExtracAfp(File archivoSolFinan_IndependienteFExtracAfp) {
        this.archivoSolFinan_IndependienteFExtracAfp = archivoSolFinan_IndependienteFExtracAfp;
    }

    public String getArchivoSolFinan_IndependienteFExtracAfpFileName() {
        return archivoSolFinan_IndependienteFExtracAfpFileName;
    }

    public void setArchivoSolFinan_IndependienteFExtracAfpFileName(String archivoSolFinan_IndependienteFExtracAfpFileName) {
        this.archivoSolFinan_IndependienteFExtracAfpFileName = archivoSolFinan_IndependienteFExtracAfpFileName;
    }

    public File getArchivoSolFinan_IndependienteIReciboLuz() {
        return archivoSolFinan_IndependienteIReciboLuz;
    }

    public void setArchivoSolFinan_IndependienteIReciboLuz(File archivoSolFinan_IndependienteIReciboLuz) {
        this.archivoSolFinan_IndependienteIReciboLuz = archivoSolFinan_IndependienteIReciboLuz;
    }

    public String getArchivoSolFinan_IndependienteIReciboLuzFileName() {
        return archivoSolFinan_IndependienteIReciboLuzFileName;
    }

    public void setArchivoSolFinan_IndependienteIReciboLuzFileName(String archivoSolFinan_IndependienteIReciboLuzFileName) {
        this.archivoSolFinan_IndependienteIReciboLuzFileName = archivoSolFinan_IndependienteIReciboLuzFileName;
    }

    public File getArchivoSolFinan_IndependienteICertificadoProveedor1() {
        return archivoSolFinan_IndependienteICertificadoProveedor1;
    }

    public File getArchivoSolFinan_IndependienteICopiaDni() {
        return archivoSolFinan_IndependienteICopiaDni;
    }

    public void setArchivoSolFinan_IndependienteICopiaDni(File archivoSolFinan_IndependienteICopiaDni) {
        this.archivoSolFinan_IndependienteICopiaDni = archivoSolFinan_IndependienteICopiaDni;
    }

    public String getArchivoSolFinan_IndependienteICopiaDniFileName() {
        return archivoSolFinan_IndependienteICopiaDniFileName;
    }

    public void setArchivoSolFinan_IndependienteICopiaDniFileName(String archivoSolFinan_IndependienteICopiaDniFileName) {
        this.archivoSolFinan_IndependienteICopiaDniFileName = archivoSolFinan_IndependienteICopiaDniFileName;
    }

    public void setArchivoSolFinan_IndependienteICertificadoProveedor1(File archivoSolFinan_IndependienteICertificadoProveedor1) {
        this.archivoSolFinan_IndependienteICertificadoProveedor1 = archivoSolFinan_IndependienteICertificadoProveedor1;
    }

    public String getArchivoSolFinan_IndependienteICertificadoProveedor1FileName() {
        return archivoSolFinan_IndependienteICertificadoProveedor1FileName;
    }

    public void setArchivoSolFinan_IndependienteICertificadoProveedor1FileName(String archivoSolFinan_IndependienteICertificadoProveedor1FileName) {
        this.archivoSolFinan_IndependienteICertificadoProveedor1FileName = archivoSolFinan_IndependienteICertificadoProveedor1FileName;
    }

    public File getArchivoSolFinan_IndependienteICertificadoProveedor2() {
        return archivoSolFinan_IndependienteICertificadoProveedor2;
    }

    public void setArchivoSolFinan_IndependienteICertificadoProveedor2(File archivoSolFinan_IndependienteICertificadoProveedor2) {
        this.archivoSolFinan_IndependienteICertificadoProveedor2 = archivoSolFinan_IndependienteICertificadoProveedor2;
    }

    public String getArchivoSolFinan_IndependienteICertificadoProveedor2FileName() {
        return archivoSolFinan_IndependienteICertificadoProveedor2FileName;
    }

    public void setArchivoSolFinan_IndependienteICertificadoProveedor2FileName(String archivoSolFinan_IndependienteICertificadoProveedor2FileName) {
        this.archivoSolFinan_IndependienteICertificadoProveedor2FileName = archivoSolFinan_IndependienteICertificadoProveedor2FileName;
    }

    public File getArchivoSolFinan_IndependienteIFactura1() {
        return archivoSolFinan_IndependienteIFactura1;
    }

    public void setArchivoSolFinan_IndependienteIFactura1(File archivoSolFinan_IndependienteIFactura1) {
        this.archivoSolFinan_IndependienteIFactura1 = archivoSolFinan_IndependienteIFactura1;
    }

    public String getArchivoSolFinan_IndependienteIFactura1FileName() {
        return archivoSolFinan_IndependienteIFactura1FileName;
    }

    public void setArchivoSolFinan_IndependienteIFactura1FileName(String archivoSolFinan_IndependienteIFactura1FileName) {
        this.archivoSolFinan_IndependienteIFactura1FileName = archivoSolFinan_IndependienteIFactura1FileName;
    }

    public File getArchivoSolFinan_IndependienteIFactura2() {
        return archivoSolFinan_IndependienteIFactura2;
    }

    public void setArchivoSolFinan_IndependienteIFactura2(File archivoSolFinan_IndependienteIFactura2) {
        this.archivoSolFinan_IndependienteIFactura2 = archivoSolFinan_IndependienteIFactura2;
    }

    public String getArchivoSolFinan_IndependienteIFactura2FileName() {
        return archivoSolFinan_IndependienteIFactura2FileName;
    }

    public void setArchivoSolFinan_IndependienteIFactura2FileName(String archivoSolFinan_IndependienteIFactura2FileName) {
        this.archivoSolFinan_IndependienteIFactura2FileName = archivoSolFinan_IndependienteIFactura2FileName;
    }

    public File getArchivoSolFinan_IndependienteICertificadoExp1() {
        return archivoSolFinan_IndependienteICertificadoExp1;
    }

    public void setArchivoSolFinan_IndependienteICertificadoExp1(File archivoSolFinan_IndependienteICertificadoExp1) {
        this.archivoSolFinan_IndependienteICertificadoExp1 = archivoSolFinan_IndependienteICertificadoExp1;
    }

    public String getArchivoSolFinan_IndependienteICertificadoExp1FileName() {
        return archivoSolFinan_IndependienteICertificadoExp1FileName;
    }

    public void setArchivoSolFinan_IndependienteICertificadoExp1FileName(String archivoSolFinan_IndependienteICertificadoExp1FileName) {
        this.archivoSolFinan_IndependienteICertificadoExp1FileName = archivoSolFinan_IndependienteICertificadoExp1FileName;
    }

    public File getArchivoSolFinan_IndependienteICertificadoExp2() {
        return archivoSolFinan_IndependienteICertificadoExp2;
    }

    public void setArchivoSolFinan_IndependienteICertificadoExp2(File archivoSolFinan_IndependienteICertificadoExp2) {
        this.archivoSolFinan_IndependienteICertificadoExp2 = archivoSolFinan_IndependienteICertificadoExp2;
    }

    public String getArchivoSolFinan_IndependienteICertificadoExp2FileName() {
        return archivoSolFinan_IndependienteICertificadoExp2FileName;
    }

    public void setArchivoSolFinan_IndependienteICertificadoExp2FileName(String archivoSolFinan_IndependienteICertificadoExp2FileName) {
        this.archivoSolFinan_IndependienteICertificadoExp2FileName = archivoSolFinan_IndependienteICertificadoExp2FileName;
    }

    public File getArchivoSolFinan_IndependienteIExtracAfp() {
        return archivoSolFinan_IndependienteIExtracAfp;
    }

    public void setArchivoSolFinan_IndependienteIExtracAfp(File archivoSolFinan_IndependienteIExtracAfp) {
        this.archivoSolFinan_IndependienteIExtracAfp = archivoSolFinan_IndependienteIExtracAfp;
    }

    public String getArchivoSolFinan_IndependienteIExtracAfpFileName() {
        return archivoSolFinan_IndependienteIExtracAfpFileName;
    }

    public void setArchivoSolFinan_IndependienteIExtracAfpFileName(String archivoSolFinan_IndependienteIExtracAfpFileName) {
        this.archivoSolFinan_IndependienteIExtracAfpFileName = archivoSolFinan_IndependienteIExtracAfpFileName;
    }

    public File getArchivoSolFinan_IndependienteICopiaArrendamiento() {
        return archivoSolFinan_IndependienteICopiaArrendamiento;
    }

    public void setArchivoSolFinan_IndependienteICopiaArrendamiento(File archivoSolFinan_IndependienteICopiaArrendamiento) {
        this.archivoSolFinan_IndependienteICopiaArrendamiento = archivoSolFinan_IndependienteICopiaArrendamiento;
    }

    public String getArchivoSolFinan_IndependienteICopiaArrendamientoFileName() {
        return archivoSolFinan_IndependienteICopiaArrendamientoFileName;
    }

    public void setArchivoSolFinan_IndependienteICopiaArrendamientoFileName(String archivoSolFinan_IndependienteICopiaArrendamientoFileName) {
        this.archivoSolFinan_IndependienteICopiaArrendamientoFileName = archivoSolFinan_IndependienteICopiaArrendamientoFileName;
    }

    public File getArchivoSolFinan_JubiladoRecibo() {
        return archivoSolFinan_JubiladoRecibo;
    }

    public void setArchivoSolFinan_JubiladoRecibo(File archivoSolFinan_JubiladoRecibo) {
        this.archivoSolFinan_JubiladoRecibo = archivoSolFinan_JubiladoRecibo;
    }

    public String getArchivoSolFinan_JubiladoReciboFileName() {
        return archivoSolFinan_JubiladoReciboFileName;
    }

    public void setArchivoSolFinan_JubiladoReciboFileName(String archivoSolFinan_JubiladoReciboFileName) {
        this.archivoSolFinan_JubiladoReciboFileName = archivoSolFinan_JubiladoReciboFileName;
    }

    public File getArchivoSolFinan_JubiladoCopiaDni() {
        return archivoSolFinan_JubiladoCopiaDni;
    }

    public void setArchivoSolFinan_JubiladoCopiaDni(File archivoSolFinan_JubiladoCopiaDni) {
        this.archivoSolFinan_JubiladoCopiaDni = archivoSolFinan_JubiladoCopiaDni;
    }

    public String getArchivoSolFinan_JubiladoCopiaDniFileName() {
        return archivoSolFinan_JubiladoCopiaDniFileName;
    }

    public void setArchivoSolFinan_JubiladoCopiaDniFileName(String archivoSolFinan_JubiladoCopiaDniFileName) {
        this.archivoSolFinan_JubiladoCopiaDniFileName = archivoSolFinan_JubiladoCopiaDniFileName;
    }

    public File getArchivoSolFinan_JubiladoBoleta1() {
        return archivoSolFinan_JubiladoBoleta1;
    }

    public void setArchivoSolFinan_JubiladoBoleta1(File archivoSolFinan_JubiladoBoleta1) {
        this.archivoSolFinan_JubiladoBoleta1 = archivoSolFinan_JubiladoBoleta1;
    }

    public String getArchivoSolFinan_JubiladoBoleta1FileName() {
        return archivoSolFinan_JubiladoBoleta1FileName;
    }

    public void setArchivoSolFinan_JubiladoBoleta1FileName(String archivoSolFinan_JubiladoBoleta1FileName) {
        this.archivoSolFinan_JubiladoBoleta1FileName = archivoSolFinan_JubiladoBoleta1FileName;
    }

    public File getArchivoSolFinan_JubiladoBoleta2() {
        return archivoSolFinan_JubiladoBoleta2;
    }

    public void setArchivoSolFinan_JubiladoBoleta2(File archivoSolFinan_JubiladoBoleta2) {
        this.archivoSolFinan_JubiladoBoleta2 = archivoSolFinan_JubiladoBoleta2;
    }

    public String getArchivoSolFinan_JubiladoBoleta2FileName() {
        return archivoSolFinan_JubiladoBoleta2FileName;
    }

    public void setArchivoSolFinan_JubiladoBoleta2FileName(String archivoSolFinan_JubiladoBoleta2FileName) {
        this.archivoSolFinan_JubiladoBoleta2FileName = archivoSolFinan_JubiladoBoleta2FileName;
    }

    public File getArchivoSolFinan_JubiladoBoleta3() {
        return archivoSolFinan_JubiladoBoleta3;
    }

    public void setArchivoSolFinan_JubiladoBoleta3(File archivoSolFinan_JubiladoBoleta3) {
        this.archivoSolFinan_JubiladoBoleta3 = archivoSolFinan_JubiladoBoleta3;
    }

    public String getArchivoSolFinan_JubiladoBoleta3FileName() {
        return archivoSolFinan_JubiladoBoleta3FileName;
    }

    public void setArchivoSolFinan_JubiladoBoleta3FileName(String archivoSolFinan_JubiladoBoleta3FileName) {
        this.archivoSolFinan_JubiladoBoleta3FileName = archivoSolFinan_JubiladoBoleta3FileName;
    }

    public File getArchivoSolFinan_JubiladoExtracBanc1() {
        return archivoSolFinan_JubiladoExtracBanc1;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc1(File archivoSolFinan_JubiladoExtracBanc1) {
        this.archivoSolFinan_JubiladoExtracBanc1 = archivoSolFinan_JubiladoExtracBanc1;
    }

    public String getArchivoSolFinan_JubiladoExtracBanc1FileName() {
        return archivoSolFinan_JubiladoExtracBanc1FileName;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc1FileName(String archivoSolFinan_JubiladoExtracBanc1FileName) {
        this.archivoSolFinan_JubiladoExtracBanc1FileName = archivoSolFinan_JubiladoExtracBanc1FileName;
    }

    public File getArchivoSolFinan_JubiladoExtracBanc2() {
        return archivoSolFinan_JubiladoExtracBanc2;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc2(File archivoSolFinan_JubiladoExtracBanc2) {
        this.archivoSolFinan_JubiladoExtracBanc2 = archivoSolFinan_JubiladoExtracBanc2;
    }

    public String getArchivoSolFinan_JubiladoExtracBanc2FileName() {
        return archivoSolFinan_JubiladoExtracBanc2FileName;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc2FileName(String archivoSolFinan_JubiladoExtracBanc2FileName) {
        this.archivoSolFinan_JubiladoExtracBanc2FileName = archivoSolFinan_JubiladoExtracBanc2FileName;
    }

    public File getArchivoSolFinan_JubiladoExtracBanc3() {
        return archivoSolFinan_JubiladoExtracBanc3;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc3(File archivoSolFinan_JubiladoExtracBanc3) {
        this.archivoSolFinan_JubiladoExtracBanc3 = archivoSolFinan_JubiladoExtracBanc3;
    }

    public String getArchivoSolFinan_JubiladoExtracBanc3FileName() {
        return archivoSolFinan_JubiladoExtracBanc3FileName;
    }

    public void setArchivoSolFinan_JubiladoExtracBanc3FileName(String archivoSolFinan_JubiladoExtracBanc3FileName) {
        this.archivoSolFinan_JubiladoExtracBanc3FileName = archivoSolFinan_JubiladoExtracBanc3FileName;
    }

    public File getArchivoSolFinan_JubiladoCopiaArrendamiento() {
        return archivoSolFinan_JubiladoCopiaArrendamiento;
    }

    public void setArchivoSolFinan_JubiladoCopiaArrendamiento(File archivoSolFinan_JubiladoCopiaArrendamiento) {
        this.archivoSolFinan_JubiladoCopiaArrendamiento = archivoSolFinan_JubiladoCopiaArrendamiento;
    }

    public String getArchivoSolFinan_JubiladoCopiaArrendamientoFileName() {
        return archivoSolFinan_JubiladoCopiaArrendamientoFileName;
    }

    public void setArchivoSolFinan_JubiladoCopiaArrendamientoFileName(String archivoSolFinan_JubiladoCopiaArrendamientoFileName) {
        this.archivoSolFinan_JubiladoCopiaArrendamientoFileName = archivoSolFinan_JubiladoCopiaArrendamientoFileName;
    }
}
