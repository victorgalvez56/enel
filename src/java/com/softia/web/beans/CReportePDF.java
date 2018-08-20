/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softia.web.beans;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.softia.beans.CClientes;
import com.softia.beans.CCreditos;
import com.softia.models.Cliente;
import com.softia.models.Credito;
import com.softia.models.Cuenta;
import com.softia.models.Cuota;
import com.softia.models.Departamento;
import com.softia.models.Direccion;
import com.softia.models.Distrito;
import com.softia.models.Provincia;
import com.softia.sql.CSql;
import com.softia.utils.LibFunc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Roberto
 */
public class CReportePDF {

    private Cliente cliente;
    private Credito credito;
    private String pthFil;
    private String rutaReporte;
    private String error;
    private String url;
    private String user;
    private String passwd;
    
    public String formateador(String fecha) throws ParseException {
        DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formateador.parse(fecha);
        
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fec = formatter.format(date);
        return fec;
    }
    
    public boolean mxPosicionCliente() throws SQLException, IOException {
        CClientes loCli = new CClientes();
        loCli.setUrl(getUrl());
        loCli.setUser(getUser());
        loCli.setPasswd(getPasswd());
        loCli.setCliente(getCliente());
        boolean llOk = loCli.mxAplicar();
        if (llOk) {
            llOk = loCli.mxCreditos();
            if (llOk) {
                llOk = mxPosicionClienteArchivo(loCli.getCliente());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/posicionCliente_" + getCliente().getCodCli() + ".pdf");
                    LibFunc.mxLog("Posicion de Cliente OK.");
                } else {
                    LibFunc.mxLog("Posicion de Cliente error: " + getError());
                }
            } else {
                setError(loCli.getError());
            }
        } else {
            setError(loCli.getError());
        }
        return llOk;
    }

    public boolean mxPosicionClienteArchivo(Cliente p_oCliente) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/posicionCliente_" + p_oCliente.getCodCli() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -50, -50, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);
            PdfPTable loTablaDatos = new PdfPTable(3);
            PdfPTable loTablaCliente = new PdfPTable(3);
            PdfPTable loTablaCreditos = new PdfPTable(10);

            loTablaDatos.setWidths(new float[]{5, 5, 5});
            loTablaCliente.setWidths(new float[]{1, 1, 9});
            loTablaCreditos.setWidths(new float[]{2, 1, 1, 1, 1, 1, 1, 1, 1, 1});

            //Primera Tabla
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("ENEL", fontContenido));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda2T1 = new PdfPCell(new Phrase("POSICIÓN DE CLIENTE", fontContenido));
            celda2T1.setBorder(PdfPCell.BOTTOM);
            celda2T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T1.setRowspan(3);
            PdfPCell celda3T1 = new PdfPCell(new Phrase("", fontContenido));
            celda3T1.setBorder(PdfPCell.NO_BORDER);
            celda3T1.setHorizontalAlignment(Element.ALIGN_RIGHT);

            //Segunda fila
            PdfPCell celda4T1 = new PdfPCell(new Phrase("CREDITOS", fontContenido));
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda5T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            celda5T1.setHorizontalAlignment(Element.ALIGN_RIGHT);

            //Tercera fila
            PdfPCell celda6T1 = new PdfPCell(new Phrase("frmCLIPosicion - " + getUser(), fontContenido));
            celda6T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda7T1 = new PdfPCell(new Phrase("HR: " + LibFunc.getHoraActual(), fontContenido));
            celda7T1.setPaddingBottom(10);
            celda7T1.setBorder(PdfPCell.BOTTOM);
            celda7T1.setHorizontalAlignment(Element.ALIGN_RIGHT);

            loTablaDatos.addCell(celda1T1);
            loTablaDatos.addCell(celda2T1);
            loTablaDatos.addCell(celda3T1);
            loTablaDatos.addCell(celda4T1);
            loTablaDatos.addCell(celda5T1);
            loTablaDatos.addCell(celda6T1);
            loTablaDatos.addCell(celda7T1);

            //Segunda Tabla
            loTablaDatos.setSpacingAfter(20);
            //Primera fila
            PdfPCell celda1T2 = new PdfPCell(new Phrase("* DATOS DEL CLIENTE *", fontContenido));
            celda1T2.setBorder(PdfPCell.NO_BORDER);
            celda1T2.setColspan(3);

            //Segunda fila
            PdfPCell celda2T2 = new PdfPCell(new Phrase("CÓDIGO", fontContenido));
            celda2T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda3T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda3T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda4T2 = new PdfPCell(new Phrase(p_oCliente.getCodCli(), fontContenido));
            celda4T2.setBorder(PdfPCell.NO_BORDER);

            //Tercera fila
            PdfPCell celda5T2 = new PdfPCell(new Phrase("NOMBRE", fontContenido));
            celda5T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda6T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda6T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda7T2 = new PdfPCell(new Phrase(p_oCliente.getNomCom(), fontContenido));
            celda7T2.setBorder(PdfPCell.NO_BORDER);

            //Cuarta fila
            PdfPCell celda8T2 = new PdfPCell(new Phrase("DOCUMENTO", fontContenido));
            celda8T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda9T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda9T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda10T2 = new PdfPCell(new Phrase(p_oCliente.getNroDocCiv(), fontContenido));
            celda10T2.setBorder(PdfPCell.NO_BORDER);

            //Quinta fila
            PdfPCell celda11T2 = new PdfPCell(new Phrase("DIRECCIÓN", fontContenido));
            celda11T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda12T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda12T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda13T2 = new PdfPCell(new Phrase(p_oCliente.getDireccion().getDireccion(), fontContenido));
            celda13T2.setBorder(PdfPCell.NO_BORDER);

            //Sexta fila
            PdfPCell celda14T2 = new PdfPCell(new Phrase("TELÉFONO", fontContenido));
            celda14T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda15T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda16T2 = new PdfPCell(new Phrase(p_oCliente.getTelefono(), fontContenido));
            celda16T2.setBorder(PdfPCell.NO_BORDER);

            //Septima fila
            PdfPCell celda17T2 = new PdfPCell(new Phrase("CELULAR", fontContenido));
            celda17T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda18T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda19T2 = new PdfPCell(new Phrase(p_oCliente.getCelular(), fontContenido));
            celda19T2.setBorder(PdfPCell.NO_BORDER);

            //Octava fila
            PdfPCell celda20T2 = new PdfPCell(new Phrase("ANALISTA", fontContenido));
            celda20T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda21T2 = new PdfPCell(new Phrase(":", fontContenido));
            celda21T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda22T2 = new PdfPCell(new Phrase(p_oCliente.getAnalista().getNombre(), fontContenido));
            celda22T2.setBorder(PdfPCell.NO_BORDER);

            loTablaCliente.addCell(celda1T2);
            loTablaCliente.addCell(celda2T2);
            loTablaCliente.addCell(celda3T2);
            loTablaCliente.addCell(celda4T2);
            loTablaCliente.addCell(celda5T2);
            loTablaCliente.addCell(celda6T2);
            loTablaCliente.addCell(celda7T2);
            loTablaCliente.addCell(celda8T2);
            loTablaCliente.addCell(celda9T2);
            loTablaCliente.addCell(celda10T2);
            loTablaCliente.addCell(celda11T2);
            loTablaCliente.addCell(celda12T2);
            loTablaCliente.addCell(celda13T2);
            loTablaCliente.addCell(celda14T2);
            loTablaCliente.addCell(celda15T2);
            loTablaCliente.addCell(celda16T2);
            loTablaCliente.addCell(celda17T2);
            loTablaCliente.addCell(celda18T2);
            loTablaCliente.addCell(celda19T2);
            loTablaCliente.addCell(celda20T2);
            loTablaCliente.addCell(celda21T2);
            loTablaCliente.addCell(celda22T2);

            //Cuarta Tabla
            loTablaCreditos.setSpacingBefore(30);
            //Primera fila
            PdfPCell celda1T4 = new PdfPCell(new Phrase("* REGISTRO DE CRÉDITOS *", fontContenido));
            celda1T4.setBorder(PdfPCell.NO_BORDER);
            celda1T4.setColspan(10);

            //Segunda fila
            PdfPCell celda2T4 = new PdfPCell(new Phrase("CREDITO", fontContenido));
            celda2T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda3T4 = new PdfPCell(new Phrase("FECHA DESEMB.", fontContenido));
            celda3T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda3T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda4T4 = new PdfPCell(new Phrase("MONTO", fontContenido));
            celda4T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda4T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda5T4 = new PdfPCell(new Phrase("NRO CUOTA", fontContenido));
            celda5T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda5T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda6T4 = new PdfPCell(new Phrase("ATRASO MAXIMO", fontContenido));
            celda6T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda6T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda7T4 = new PdfPCell(new Phrase("DÍA ATRASO", fontContenido));
            celda7T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda7T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda8T4 = new PdfPCell(new Phrase("ATR PROM", fontContenido));
            celda8T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda8T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda9T4 = new PdfPCell(new Phrase("FECHA CANC.", fontContenido));
            celda9T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda9T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda10T4 = new PdfPCell(new Phrase("SALDO", fontContenido));
            celda10T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda10T4.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda11T4 = new PdfPCell(new Phrase("ESTADO", fontContenido));
            celda11T4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda11T4.setBorder(PdfPCell.BOTTOM);

            loTablaCreditos.addCell(celda1T4);
            loTablaCreditos.addCell(celda2T4);
            loTablaCreditos.addCell(celda3T4);
            loTablaCreditos.addCell(celda4T4);
            loTablaCreditos.addCell(celda5T4);
            loTablaCreditos.addCell(celda6T4);
            loTablaCreditos.addCell(celda7T4);
            loTablaCreditos.addCell(celda8T4);
            loTablaCreditos.addCell(celda9T4);
            loTablaCreditos.addCell(celda10T4);
            loTablaCreditos.addCell(celda11T4);

            for (Cuenta loCuenta : p_oCliente.getLstCuentas()) {
                celda2T4 = new PdfPCell(new Phrase(loCuenta.getCuenta(), fontContenido));
                celda2T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda2T4.setBorder(PdfPCell.NO_BORDER);
                celda3T4 = new PdfPCell(new Phrase(loCuenta.getFecDes(), fontContenido));
                celda3T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda3T4.setBorder(PdfPCell.NO_BORDER);
                celda4T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getCapDes()), fontContenido));
                celda4T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda4T4.setBorder(PdfPCell.NO_BORDER);
                celda5T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getCuotas()), fontContenido));
                celda5T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda5T4.setBorder(PdfPCell.NO_BORDER);
                celda6T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getAtrMax()), fontContenido));
                celda6T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda6T4.setBorder(PdfPCell.NO_BORDER);
                celda7T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getAtraso()), fontContenido));
                celda7T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda7T4.setBorder(PdfPCell.NO_BORDER);
                celda8T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getAtrPro()), fontContenido));
                celda8T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda8T4.setBorder(PdfPCell.NO_BORDER);
                celda9T4 = new PdfPCell(new Phrase(loCuenta.getFecCan(), fontContenido));
                celda9T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda9T4.setBorder(PdfPCell.NO_BORDER);
                celda10T4 = new PdfPCell(new Phrase(String.valueOf(loCuenta.getSaldo()), fontContenido));
                celda10T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda10T4.setBorder(PdfPCell.NO_BORDER);
                celda11T4 = new PdfPCell(new Phrase(loCuenta.getEstado(), fontContenido));
                celda11T4.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda11T4.setBorder(PdfPCell.NO_BORDER);
                loTablaCreditos.addCell(celda2T4);
                loTablaCreditos.addCell(celda3T4);
                loTablaCreditos.addCell(celda4T4);
                loTablaCreditos.addCell(celda5T4);
                loTablaCreditos.addCell(celda6T4);
                loTablaCreditos.addCell(celda7T4);
                loTablaCreditos.addCell(celda8T4);
                loTablaCreditos.addCell(celda9T4);
                loTablaCreditos.addCell(celda10T4);
                loTablaCreditos.addCell(celda11T4);
            }
            loDoc.add(loTablaDatos);
            loDoc.add(loTablaCliente);
            loDoc.add(loTablaCreditos);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    //public static final String IMG = "/img/enelLOGO.png";
    public boolean mxEvaluacionFinanciera() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            //llOk = loCre.mxAplicar();
            if (llOk) {
                llOk = mxEvaluacionFinancieraArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/solicitud_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Solicitud de Evaluación Financiera OK.");
                } else {
                    LibFunc.mxLog("Solicitud de Evaluación Financiera error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxEvaluacionFinancieraArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/solicitud_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -20, -20, 15, 50);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTabla = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.BOLD,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.HELVETICA, 12, Font.BOLD,
                    BaseColor.BLACK);
            Font fontSubTitulos = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.BOLD,
                    BaseColor.WHITE);
            Font fontTextos = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.NORMAL,
                    BaseColor.BLACK);

            Paragraph loTitulo = new Paragraph();
            Paragraph loEncabezado = new Paragraph();
            Paragraph loCuerpo = new Paragraph();
            PdfPTable loEncabTabla = new PdfPTable(2);
            PdfPTable loTableCuerpo = new PdfPTable(4);
            Paragraph loTexto = new Paragraph();

            //ImageIcon Img = new ImageIcon(getClass().getResource("enelLogo.png"));
            Image logo = Image.getInstance("/ftia/img/enelLOGO.png");
            logo.scaleToFit(110, 35);
            logo.setAlignment(Element.ALIGN_CENTER);

            //Titulo
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Paragraph("SOLICITUD DE EVALUACIÓN FINANCIERA", fontTitulos));
            loTitulo.setAlignment(Element.ALIGN_CENTER);
            loTitulo.add(new Phrase(Chunk.NEWLINE));

            //Encabezado
            Phrase contenido1 = new Phrase();
            contenido1.add(new Chunk("Código o Nombres y Apellidos del Afiliador\n\n\n", fontTabla));
            contenido1.add(new Chunk(p_oCredito.getNomAna(), fontContenido));
            PdfPCell celda1 = new PdfPCell(contenido1);
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            loEncabTabla.addCell(celda1);

            Phrase contenido2 = new Phrase();
            contenido2.add(new Chunk("Fecha Solicitud\n\n\n", fontTabla));
            contenido2.add(new Chunk(p_oCredito.getFecSol(), fontContenido));
            PdfPCell celda2 = new PdfPCell(contenido2);
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            loEncabTabla.addCell(celda2);
            loEncabezado.add(loEncabTabla);
            loEncabezado.add(new Phrase(Chunk.NEWLINE));

            //Cuerpo de Tabla principal
            PdfPCell celdaCuerpo1 = new PdfPCell(new Phrase("I. DATOS DEL SOLICITANTE (TITULAR DEL SUMINISTRO)\n\n", fontSubTitulos));
            celdaCuerpo1.setColspan(4);
            celdaCuerpo1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaCuerpo1.setBackgroundColor(WebColors.getRGBColor("#FF0066"));
            loTableCuerpo.addCell(celdaCuerpo1);

            Phrase contenidoC1 = new Phrase();
            contenidoC1.add(new Chunk("Número Suministro\n\n", fontTabla));
            contenidoC1.add(new Chunk(p_oCredito.getCliente().getSumini(), fontContenido));
            PdfPCell celdaC1 = new PdfPCell(contenidoC1);
            celdaC1.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC2 = new Phrase();
            contenidoC2.add(new Chunk("Apellido Paterno\n\n", fontTabla));
            contenidoC2.add(new Chunk(p_oCredito.getCliente().getApePat(), fontContenido));
            PdfPCell celdaC2 = new PdfPCell(contenidoC2);
            celdaC2.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC3 = new Phrase();
            contenidoC3.add(new Chunk("Apellido Materno\n\n", fontTabla));
            contenidoC3.add(new Chunk(p_oCredito.getCliente().getApeMat(), fontContenido));
            PdfPCell celdaC3 = new PdfPCell(contenidoC3);
            celdaC3.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC4 = new Phrase();
            contenidoC4.add(new Chunk("Nombres\n\n", fontTabla));
            contenidoC4.add(new Chunk(p_oCredito.getCliente().getNombre(), fontContenido));
            PdfPCell celdaC4 = new PdfPCell(contenidoC4);
            celdaC4.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC5 = new Phrase();
            contenidoC5.add(new Chunk("Sexo\n\n", fontTabla));
            contenidoC5.add(new Chunk(p_oCredito.getCliente().getSexo(), fontContenido));
            PdfPCell celdaC5 = new PdfPCell(contenidoC5);
            celdaC5.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC6 = new Phrase();
            contenidoC6.add(new Chunk("Fecha de Nacimiento\n\n", fontTabla));
            contenidoC6.add(new Chunk(p_oCredito.getCliente().getFecNac(), fontContenido));
            PdfPCell celdaC6 = new PdfPCell(contenidoC6);
            celdaC6.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC7 = new Phrase();
            contenidoC7.add(new Chunk("Tipo de Documento de Identidad\n\n", fontTabla));
            contenidoC7.add(new Chunk(p_oCredito.getCliente().getTipDocCiv(), fontContenido));
            PdfPCell celdaC7 = new PdfPCell(new Phrase(contenidoC7));
            celdaC7.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC8 = new Phrase();
            contenidoC8.add(new Chunk("Número de Documento de Identidad\n\n", fontTabla));
            contenidoC8.add(new Chunk(p_oCredito.getCliente().getNroDocCiv(), fontContenido));
            PdfPCell celdaC8 = new PdfPCell(contenidoC8);
            celdaC8.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC9 = new Phrase();
            contenidoC9.add(new Chunk("Teléfono\n\n", fontTabla));
            contenidoC9.add(new Chunk(p_oCredito.getCliente().getTelefono(), fontContenido));
            PdfPCell celdaC9 = new PdfPCell(contenidoC9);
            celdaC9.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC10 = new Phrase();
            contenidoC10.add(new Chunk("Teléfono Celular\n\n", fontTabla));
            contenidoC10.add(new Chunk(p_oCredito.getCliente().getCelular(), fontContenido));
            PdfPCell celdaC10 = new PdfPCell(contenidoC10);
            celdaC10.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC11 = new Phrase();
            contenidoC11.add(new Chunk("Correo Electrónico\n\n", fontTabla));
            contenidoC11.add(new Chunk(p_oCredito.getCliente().getCorreo(), fontContenido));
            PdfPCell celdaC11 = new PdfPCell(contenidoC11);
            celdaC11.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC11.setColspan(2);

            Phrase contenidoC12 = new Phrase();
            contenidoC12.add(new Chunk("Dirección\n\n", fontTabla));
            contenidoC12.add(new Chunk(p_oCredito.getCliente().getDireccion().getDireccion(), fontContenido));
            PdfPCell celdaC12 = new PdfPCell(contenidoC12);
            celdaC12.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC12.setColspan(2);

            Phrase contenidoC13 = new Phrase();
            contenidoC13.add(new Chunk("Número\n\n\n", fontTabla));
            contenidoC13.add(new Chunk("Interior/Departamento\n\n\n", fontTabla));
            PdfPCell celdaC13 = new PdfPCell(contenidoC13);
            celdaC13.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC14 = new Phrase();
            contenidoC14.add(new Chunk("Urbanización\n\n", fontTabla));
            PdfPCell celdaC14 = new PdfPCell(contenidoC14);
            celdaC14.setHorizontalAlignment(Element.ALIGN_CENTER);

            Phrase contenidoC15 = new Phrase();
            contenidoC15.add(new Chunk("Distrito\n\n", fontTabla));
            contenidoC15.add(new Chunk(p_oCredito.getCliente().getDireccion().getDistrito().getNombre(), fontContenido));
            PdfPCell celdaC15 = new PdfPCell(contenidoC15);
            celdaC15.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC15.setColspan(2);

            Phrase contenidoC16 = new Phrase();
            contenidoC16.add(new Chunk("Provincia\n\n", fontTabla));
            contenidoC16.add(new Chunk(p_oCredito.getCliente().getDireccion().getDistrito().getProvincia().getNombre(), fontContenido));
            PdfPCell celdaC16 = new PdfPCell(contenidoC16);
            celdaC16.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC16.setColspan(2);

            loTableCuerpo.addCell(celdaC1);
            loTableCuerpo.addCell(celdaC2);
            loTableCuerpo.addCell(celdaC3);
            loTableCuerpo.addCell(celdaC4);
            loTableCuerpo.addCell(celdaC5);
            loTableCuerpo.addCell(celdaC6);
            loTableCuerpo.addCell(celdaC7);
            loTableCuerpo.addCell(celdaC8);
            loTableCuerpo.addCell(celdaC9);
            loTableCuerpo.addCell(celdaC10);
            loTableCuerpo.addCell(celdaC11);
            loTableCuerpo.addCell(celdaC12);
            loTableCuerpo.addCell(celdaC13);
            loTableCuerpo.addCell(celdaC14);
            loTableCuerpo.addCell(celdaC15);
            loTableCuerpo.addCell(celdaC16);
            loCuerpo.add(loTableCuerpo);

            loTexto.setAlignment(Element.ALIGN_JUSTIFIED);
            loTexto.setSpacingBefore(5);
            loTexto.setIndentationLeft(63);
            loTexto.setIndentationRight(63);
            loTexto.add(new Phrase("Declaro bajo juramento que la información proporcionada en la presente solicitud, así como toda aquella documentación adjunta es verídica, por lo que autorizo expresamente a ENEL DISTRIBUCIÓN PERÚ, en adelante ENEL DISTRIBUCIÓN, a verificar toda la información señalada en el presente documento y me hago responsable de cualquier daño o perjuicio derivado que la inexactitud de la información proporcionada pudiera causar a ENEL DISTRIBUCIÓN o a terceros.\n", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("Asimismo, de acuerdo a la ley Nº 29733 Ley de Protección de Datos Personales, brindo mi conformidad y autorizo expresamente a ENEL DISTRIBUCIÓN para que recopile mis datos personales con la finalidad de incorporarlos en su banco de datos así como utilizarlos para gestionar la información del financiamiento de productos, realizar campañas de marketing y análisis estadístico.", fontContenido));
            loTexto.add(new Phrase("De la misma forma, autorizo expresamente a ENEL DISTRIBUCIÓN a transferir mis datos personales a otras empresas del mismo grupo económico y socios comerciales con la finalidad de:\n", fontContenido));

            loTexto.add(new Phrase("(I)       Evaluar mi capacidad crediticia y capacidad de pago.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(II)      Otorgarme el producto y/o servicio solicitado.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(III)     Almacenar y tratar mis datos personales, con fines estadisticos y/o historicos.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("Optativo (marca 'X').", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(IV)      Ofrecerme otros productos y/o servicios y/o ofertas y/o publicidad.\n", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(V)       Futuras promociones.", fontContenido));

            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("Por último, declaro haber sido informado por parte de ENEL DISTRIBUCIÓN de manera oportuna acerca de todos los temas referidos al uso y obtención del financiamiento de ENEL DISTRIBUCIÓN.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));

            //Rectangulos
            PdfContentByte contentByte = writer.getDirectContent();
            Rectangle rectGrande = new Rectangle(120, 50, 480, 180);
            rectGrande.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectGrande.setBorderWidth(1);

            Rectangle rectABC = new Rectangle(43, 800, 165, 825);
            rectABC.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectABC.setBorderWidth(1);

            Rectangle rectHuella = new Rectangle(385, 85, 450, 170);
            rectHuella.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectHuella.setBorderWidth(1);

            Rectangle rectSi1 = new Rectangle(385, 245, 400, 260);
            rectSi1.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectSi1.setBorderWidth(1);

            Rectangle rectSi2 = new Rectangle(385, 215, 400, 230);
            rectSi2.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectSi2.setBorderWidth(1);

            Rectangle rectNo1 = new Rectangle(435, 245, 450, 260);
            rectNo1.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectNo1.setBorderWidth(1);

            Rectangle rectNo2 = new Rectangle(435, 215, 450, 230);
            rectNo2.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectNo2.setBorderWidth(1);

            contentByte.rectangle(rectHuella);
            contentByte.rectangle(rectABC);
            contentByte.rectangle(rectGrande);
            contentByte.rectangle(rectSi1);
            contentByte.rectangle(rectSi2);
            contentByte.rectangle(rectNo1);
            contentByte.rectangle(rectNo2);

            //Linea Firma
            contentByte.moveTo(150, 90);
            contentByte.lineTo(295, 90);
            contentByte.closePathStroke();

            //Linea ABC
            contentByte.moveTo(85, 805);
            contentByte.lineTo(155, 805);
            contentByte.closePathStroke();

            //Textos en los rectangulos
            ColumnText abcText = new ColumnText(contentByte);
            abcText.setSimpleColumn(48, 800, 165, 825);
            abcText.addElement(new Paragraph("ABC-", fontTextos));
            abcText.go();

            ColumnText firmaText = new ColumnText(contentByte);
            firmaText.setSimpleColumn(175, 75, 350, 95);
            firmaText.addElement(new Paragraph("FIRMA DEL TITULAR", fontTextos));
            firmaText.go();

            ColumnText huellaText = new ColumnText(contentByte);
            huellaText.setSimpleColumn(375, 40, 493, 90);
            huellaText.addElement(new Paragraph(" HUELLA DIGITAL", fontTextos));
            huellaText.addElement(new Paragraph("INDICE DERECHO", fontTextos));
            huellaText.go();

            ColumnText siNoText = new ColumnText(contentByte);
            firmaText.setSimpleColumn(385, 278, 550, 293);
            firmaText.addElement(new Paragraph(" SI              NO", fontTextos));
            firmaText.go();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loEncabezado);
            loDoc.add(loCuerpo);
            loDoc.add(loTexto);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxContratoFinanciamiento() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            //llOk = loCre.mxAplicar();
            if (llOk) {
                llOk = mxContratoFinanciamientoArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/contratoFinanciamiento_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Contrato de Financiamiento OK.");
                } else {
                    LibFunc.mxLog("Contrato de Financiamiento error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxContratoFinanciamientoArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/contratoFinanciamiento_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -20, -20, 10, 50);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontSub = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.BOLD,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.HELVETICA, 12, Font.BOLD,
                    BaseColor.BLACK);

            Paragraph loTitulo = new Paragraph();
            PdfPTable loTabla = new PdfPTable(3);
            Paragraph col1 = new Paragraph();
            Paragraph col3 = new Paragraph();

            Image logo = Image.getInstance("/ftia/img/enelLOGO.png");
            logo.scaleToFit(110, 35);
            logo.setAlignment(Element.ALIGN_CENTER);

            //Titulo
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Paragraph("CONTRATO DE FINANCIAMIENTO", fontTitulos));
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.setAlignment(Element.ALIGN_CENTER);

            loTabla.setWidths(new float[]{5, 1, 5});
            //loTabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            //Primera columna
            col1.add(new Chunk("Conste por el presente documento el Contrato de Financiamiento (en adelante el “Contrato”), que celebran de una"
                    + "parte ENEL DISTRIBUCIÓN PERÚ S.A.A. , con RUC Nº 20269985900, domiciliada en Calle César López Rojas 201,"
                    + "Urbanización Maranga, distrito de San Miguel, Provincia y Departamento de Lima, debidamente representada por el"
                    + "funcionario que figura al final de este documento, con poderes inscritos en la partida electrónica 11008737 del Registro Público"
                    + "de Personas Jurídicas de la Oficina Registral de Lima y Callao (en adelante “ENEL DISTRIBUCIÓN PERÚ”), y de la otra parte\n\n", fontContenido));
            col1.add(new Chunk(p_oCredito.getCliente().getNomCom() + "\n\n", fontContenido));
            col1.add(new Chunk("cuya identificación y demás generales de ley, figuran al final de este documento (en adelante el “CLIENTE”).\n\n", fontContenido));
            col1.add(new Phrase(Chunk.NEWLINE));
            col1.add(new Chunk("Este Contrato se regirá de acuerdo a lo establecido en las cláusulas siguientes:\n\n", fontContenido));
            col1.add(new Phrase(Chunk.NEWLINE));
            col1.add(new Chunk("PRIMERA.- ANTECEDENTES\n", fontSub));
            col1.add(new Chunk("1.1       ENEL DISTRIBUCIÓN PERÚ es una empresa constituida en el Perú, que dentro de su objeto social está facultada a realizar actividades propias de la prestación del servicio de distribución, transmisión y generación de energía eléctrica de acuerdo con lo dispuesto en la legislación vigente, así como aquella relacionada a la prestación de servicios financieros y otros vinculados a estos fines.\n"
                    + "1.2            El CLIENTE es una persona natural, domiciliada en el Perú, que ha solicitado a ENEL DISTRIBUCIÓN PERÚ el otorgamiento de un financiamiento para la compra de un producto para su uso personal y para la realización de actos lícitos, en la forma y dentro de los límites descritos en este documento, los mismos que le han sido debidamente explicados previamente a su suscripción.\n\n", fontContenido));
            col1.add(new Phrase(Chunk.NEWLINE));
            col1.add(new Chunk("SEGUNDA.- OBJETO\n", fontSub));
            col1.add(new Chunk("Por medio de este documento, ENEL DISTRIBUCIÓN PERÚ concede financiamiento (en adelante, el \"financiamiento\") para la adquisición del producto a favor del CLIENTE (en adelante el PRODUCTO), cuyas características constan en la documentación anexa a este Contrato, la misma que el CLIENTE declara haber recibido y revisado en forma previa.\n\n", fontContenido));
            col1.add(new Phrase(Chunk.NEWLINE));
            col1.add(new Chunk("TERCERA.- DEL FINANCIAMIENTO\n", fontSub));
            col1.add(new Chunk("ENEL DISTRIBUCIÓN PERÚ se reserva la potestad de ampliar, reducir y/o suprimir el monto del financiamiento que otorga al CLIENTE, así como la facultad de otorgar, modificar y/o suprimir financiamientos adicionales, y/o financiamientos paralelos, en cualquier momento y a su sola discreción, bastando para ello una comunicación simple y oportuna al CLIENTE. De la misma manera, ENEL DISTRIBUCIÓN PERÚ podrá fijar frecuencias de pago, montos mínimos y máximos, así como otras condiciones por el monto del financiamiento otorgado al CLIENTE.\n"
                    + "ENEL DISTRIBUCIÓN PERÚ podrá cursar las comunicaciones en relación con los hechos descritos en el párrafo anterior por algunas de las siguientes vías: correo, fax, correo electrónico, publicación en las oficinas o cualquier otro medio idóneo para los fines descritos.\n\n", fontContenido));
            col1.add(new Phrase(Chunk.NEWLINE));
            col1.add(new Chunk("CUARTA.- DE LA DISPOSICIÓN DEL FINANCIAMIENTO\n", fontSub));
            col1.add(new Chunk("El CLIENTE podrá disponer del importe financiado a partir de la suscripción del presente Contrato, la misma que podrá ser utilizada exclusivamente para la adquisición del PRODUCTO. EL CLIENTE autoriza a ENEL DISTRIBUCIÓN PERÚ a que este último deposite el importe total financiado directamente a la empresa proveedora o dueña del PRODUCTO. El CLIENTE gozará del beneficio de pagar en cuotas el monto del financiamiento otorgado, lo cual dará origen a la aplicación de una tasa de interés compensatoria, razón por la cual el CLIENTE se encuentra obligado a la devolución del capital, así como el pago de los intereses respectivos, de acuerdo a lo\n\n", fontContenido));

            Phrase col2 = new Phrase();

            col3.add(new Chunk("previsto en este Contrato. De la misma manera, el CLIENTE estará obligado a pagar el Impuesto General a las Ventas (IGV) sobre los intereses compensatorios que se generen por el financiamiento que mediante el presente documento se otorga.\n"
                    + "Asimismo, las partes acuerdan que el CLIENTE se obliga a pagar a ENEL DISTRIBUCIÓN PERÚ intereses moratorios, en caso incumpla con efectuar el pago de las cuotas pactadas en los plazos acordados en el presente contrato; dicho interés equivale a la tasa activa de interés anual máxima en moneda nacional permitida por el BCRP, sobre el importe de los saldos insolutos mientras dure su incumplimiento.\n\n", fontContenido));
            col3.add(new Phrase(Chunk.NEWLINE));
            col3.add(new Chunk("QUINTA.- DE LA MONEDA DEL FINANCIAMIENTO\n", fontSub));
            col3.add(new Chunk("El financiamiento que por este documento se otorga se pacta en moneda nacional (Soles).\n\n", fontContenido));
            col3.add(new Phrase(Chunk.NEWLINE));
            col3.add(new Chunk("SEXTA.- AUTORIZACIÓN DE CARGO \n", fontSub));
            col3.add(new Chunk("El CLIENTE autoriza en forma expresa a ENEL DISTRIBUCIÓN PERÚ el cobro de la (s) cuota (s) pendiente (s) de pago por el financiamiento otorgado en el recibo de energía eléctrica correspondiente al suministro consignado en la Solicitud de Evaluación Financiera. \n"
                    + "La liquidación que se enviará en el recibo de energía eléctrica, se considerará aprobada por el CLIENTE si éste no formula observaciones por escrito, o lo hace en términos genéricos o sin detallar y sustentar los conceptos que observa dentro de los quince (15) días calendario posteriores a la recepción del recibo de energía eléctrica.\n", fontContenido));
            col3.add(new Chunk("En consecuencia, la periodicidad con la cual el CLIENTE deberá pagar las cuotas será mensual y el vencimiento será el mismo día en el cual vence la obligación del CLIENTE de pagar el monto facturado por consumo de energía eléctrica.\n", fontContenido));
            col3.add(new Chunk("Las partes declaran conocer que el día de facturación del servicio eléctrico, de acuerdo a las normas del sector eléctrico aplicables a ENEL DISTRIBUCIÓN PERÚ podrá ser variable, siempre que no sea inferior a veintiocho (28) días calendario ni supere los treinta y tres (33) días calendario. Siendo ello así, ambas partes aceptan que en caso exista alguna diferencia en el monto de alguna de las cuotas cargadas al CLIENTE por dicho motivo, ENEL DISTRIBUCIÓN PERÚ liquidará los montos abonados por el CLIENTE y compensará dicha situación en el monto correspondiente a la última cuota.\n", fontContenido));
            col3.add(new Chunk("En caso el CLIENTE dejara de ser el titular del suministro o el obligado a pagar los recibos de energía eléctrica, éste se obliga a comunicar a ENEL DISTRIBUCIÓN PERÚ en forma inmediata y en el plazo máximo de cuarenta y ocho (48) horas de producido el cambio de domicilio, su nueva dirección así como el nuevo número de suministro, los cuales deben encontrarse dentro de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ. Las deudas del financiamiento serán incluidas en el recibo de energía eléctrica en la nueva dirección y el número de suministro proporcionado por el cliente manteniéndose la obligación del pago de las cuotas y otros conceptos asociados. En caso el cliente no comunique estos cambios se mantendrá la obligación del pago de las cuotas incluidas en el recibo de energía del número de suministro vigente.\n", fontContenido));
            col3.add(new Chunk("Asimismo, las partes acuerdan que en caso el nuevo domicilio se encuentre fuera de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ, el CLIENTE se obliga a pagar la totalidad de las cuotas pendientes de pago a más tardar dentro de los cinco (5) días calendario de comunicado el cambio de domicilio.\n", fontContenido));
            col3.add(new Phrase(Chunk.NEWLINE));
            col3.add(new Chunk("SÉTIMA.- DEL LUGAR DE PAGO\n", fontSub));
            col3.add(new Chunk("El CLIENTE, se obliga a pagar y restituir a ENEL DISTRIBUCIÓN PERÚ las cantidades que disponga de su financiamiento, así como los intereses que se generen en términos del presente contrato, en las agencias de ENEL DISTRIBUCIÓN indicadas al dorso del recibo o en cualquier otro lugar que oportunamente le comunique ENEL DISTRIBUCIÓN PERÚ.\n\n", fontContenido));

            PdfPCell celda1 = new PdfPCell(col1);
            celda1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda1.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda2 = new PdfPCell(col2);
            celda2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda2.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda3 = new PdfPCell(col3);
            celda3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda3.setBorder(PdfPCell.NO_BORDER);
            loTabla.addCell(celda1);
            loTabla.addCell(celda2);
            loTabla.addCell(celda3);

            PdfContentByte contentByte = writer.getDirectContent();
            Rectangle rectABC = new Rectangle(43, 800, 165, 825);
            rectABC.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectABC.setBorderWidth(1);
            contentByte.rectangle(rectABC);

            //Textos en los rectangulos
            ColumnText abcText = new ColumnText(contentByte);
            abcText.setSimpleColumn(48, 800, 165, 825);
            abcText.addElement(new Paragraph("ABC-", fontTitulos));
            abcText.go();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loTabla);

            //SEGUNDA PAGINA
            loDoc.newPage();
            PdfPTable loTablap2 = new PdfPTable(3);
            Paragraph col1p2 = new Paragraph();
            Paragraph col3p2 = new Paragraph();

            loTablap2.setWidths(new float[]{5, 1, 5});
            //loTabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            //Primera columna
            col1p2.add(new Chunk("OCTAVA.- DEL PAGO\n", fontSub));
            col1p2.add(new Chunk("8.1         Una vez que el CLIENTE reciba el financiamiento, ENEL DISTRIBUCIÓN PERÚ le informará por cualquier medio escrito el monto de su cuota mensual correspondiente al plazo que ha financiado la compra del PRODUCTO, así como las tasas de interés aplicables, comisiones y otros conceptos.\n", fontContenido));
            col1p2.add(new Chunk("8.2            Facturado el concepto correspondiente en el recibo de energía eléctrica, de acuerdo a lo señalado en la Cláusula Sexta precedente, el CLIENTE deberá acercarse a los lugares de pago autorizados a cancelar su deuda, la cual solo estará acreditada por los comprobantes de pago que el CLIENTE recibirá una vez registrado el pago. Los eventuales pagos en exceso efectuados por parte del CLIENTE que generen saldos a favor, no generarán la obligación de pago de interés alguno por parte de ENEL DISTRIBUCIÓN.\n", fontContenido));
            col1p2.add(new Chunk("8.3          El CLIENTE se obliga a cubrir íntegramente el importe del financiamiento en la forma pactada en este Contrato y en caso de no cumplir con dos (2) o más pagos mensuales, sucesivos o no, ENEL DISTRIBUCIÓN PERÚ tendrá la potestad de dar por vencido anticipadamente este Contrato haciéndose exigible el pago total de la deuda que pudiera tener el CLIENTE más los intereses compensatorios y moratorios que se hayan generado por dicho incumplimiento.\n", fontContenido));
            col1p2.add(new Phrase(Chunk.NEWLINE));
            col1p2.add(new Chunk("NOVENA.- TRIBUTOS\n", fontSub));
            col1p2.add(new Chunk("Salvo los impuestos que de acuerdo a la legislación aplicable le corresponda pagar a ENEL DISTRIBUCIÓN PERÚ, el CLIENTE tendrá que efectuar todos los pagos conforme al presente Contrato, libres de cualquier impuesto, retención, contribución o derecho que se establezcan. En caso que existan dichos impuestos, el monto de los pagos que el CLIENTE deba realizar conforme a este documento se incrementará "
                    + "a la cantidad que sea necesaria para asegurar que, después de cubiertos dichos impuestos, ENEL DISTRIBUCIÓN PERÚ reciba la cantidad que recibiría en términos del presente Contrato si dichos impuestos no existieran. En caso de que, por cualquier motivo, ENEL DISTRIBUCIÓN PERÚ pague el monto de dichos impuestos, el CLIENTE deberá reembolsar a ENEL DISTRIBUCIÓN PERÚ el monto pagado en los términos "
                    + "señalados o exigirle la devolución de otra manera, según lo requiera ENEL DISTRIBUCIÓN PERÚ. Las obligaciones contenidas en la presente cláusula continuarán vigentes durante el plazo en que el pago de dichos impuestos sea exigible por la legislación aplicable, a pesar de que el Contrato haya culminado.\n\n", fontContenido));
            col1p2.add(new Phrase(Chunk.NEWLINE));
            col1p2.add(new Chunk("DÉCIMA.- TÍTULO VALOR\n", fontSub));
            col1p2.add(new Chunk("Adicionalmente, a las otras garantías a que se refiere este documento, el CLIENTE emite, suscribe y entrega a favor de ENEL DISTRIBUCIÓN PERÚ, un título valor incompleto, autorizando en forma expresa e irrevocable a que ésta lo complete y ejecute en caso de incumplimiento parcial o total en el pago del financiamiento otorgado, de acuerdo a los términos previstos en la Cláusula Décimo Primera siguiente. El CLIENTE declara expresamente que ha sido informado de los alcances y "
                    + "características de dicho título valor y que ENEL DISTRIBUCIÓN PERÚ ha cumplido con entregarle una copia del mismo.\n\n", fontContenido));
            col1p2.add(new Phrase(Chunk.NEWLINE));
            col1p2.add(new Chunk("DÉCIMO PRIMERA.- INCUMPLIMIENTO\n", fontSub));
            col1p2.add(new Chunk("El CLIENTE y ENEL DISTRIBUCIÓN PERÚ convienen en pactar, al amparo del artículo 1430° del Código Civil, la presente cláusula resolutoria expresa, en virtud de la cual, si el CLIENTE dejara de pagar dos o más cuotas mensuales consecutivas o alternadas, ENEL DISTRIBUCIÓN PERÚ podrá dar por vencidos todos los plazos y fechas de vencimiento concedidos a favor del CLIENTE; procediendo a exigir y cobrar "
                    + "el íntegro de lo adeudado, incluyendo los intereses compensatorios, moratorios y demás conceptos que correspondan  de acuerdo a los términos de este contrato. Las cuotas pagadas por el CLIENTE a ENEL DISTRIBUCIÓN PERÚ quedarán a favor de la segunda, sin derecho a reembolso.\n\n", fontContenido));

            Phrase col2p2 = new Phrase();

            col3p2.add(new Chunk("En este caso, el título valor mencionado en la Cláusula Décima será completado incluyendo como monto total del mismo la suma que comprenda las cuotas vencidas y no pagadas, las cuotas futuras, los intereses compensatorios, moratorios y gastos señalados en este contrato, así como cualquier otro aplicable. Dicho monto total devengará intereses compensatorios, moratorios, así como los gastos a cargo "
                    + "del CLIENTE, en las mismas tasas y condiciones previstas en este contrato. El referido título valor será presentado al CLIENTE para su inmediato pago dentro del año siguiente a la fecha de integración del mismo, de acuerdo a lo establecido por la Ley de Títulos Valores.\n\n", fontContenido));
            col3p2.add(new Phrase(Chunk.NEWLINE));
            col3p2.add(new Chunk("DÉCIMO SEGUNDA.- FACULTADES Y OBLIGACIONES DE ENEL DISTRIBUCIÓN PERÚ\n", fontSub));
            col3p2.add(new Chunk("ENEL DISTRIBUCIÓN PERÚ tendrá los siguientes derechos y obligaciones:\n", fontContenido));
            col3p2.add(new Chunk("12.1       Enviar mensualmente la (s) cuota (s) pendiente (s) de pago del financiamiento incluido en el recibo de energía eléctrica del CLIENTE.\n", fontContenido));
            col3p2.add(new Chunk("12.2       Enviar mensualmente al correo electrónico o dirección autorizada por el CLIENTE en la Solicitud de Evaluación Financiera, una boleta electrónica por el cobro de los intereses compensatorios del financiamiento y otros conceptos, en caso correspondiese.\n", fontContenido));
            col3p2.add(new Chunk("12.3        Podrá proporcionar y recabar información sobre la solvencia del CLIENTE en cualquier momento, a lo cual, el CLIENTE declara su expresa aceptación.\n", fontContenido));
            col3p2.add(new Chunk("12.4       Se reserva el derecho de resolver el presente contrato mediante comunicación escrita dirigida al CLIENTE.\n\n", fontContenido));
            col3p2.add(new Phrase(Chunk.NEWLINE));
            col3p2.add(new Chunk("DÉCIMO TERCERA.- CESIÓN DE POSICIÓN CONTRACTUAL\n", fontSub));
            col3p2.add(new Chunk("El CLIENTE reconoce y acepta expresamente que, en cualquier momento y a sola discreción de ENEL DISTRIBUCIÓN PERÚ, este último podrá ceder sus derechos derivados del presente Contrato, ya sea mediante una cesión de derechos, venta de cartera o mecanismos similares que este último decida. "
                    + "Para tal efecto, y por este solo hecho, el CLIENTE se da por expresamente notificado en este acto de dicha cesión o cesiones consintiendo y aceptando expresamente dicho (s) acto (s). Asimismo, las partes acuerdan que el CLIENTE no podrá ceder su posición contractual, ya sea de forma parcial "
                    + "y/o total, salvo que ENEL DISTRIBUCIÓN PERÚ brinde su autorización expresa.\n\n", fontContenido));
            col3p2.add(new Phrase(Chunk.NEWLINE));
            col3p2.add(new Chunk("DÉCIMO CUARTA.- INFORMACIÓN ACERCA DEL CLIENTE\n", fontSub));
            col3p2.add(new Chunk("ENEL DISTRIBUCIÓN PERÚ se encuentra autorizada por el CLIENTE para proporcionar a las centrales privadas de riesgo y a terceros en general, información relativa al cumplimiento y demás características relacionadas al financiamiento otorgado al CLIENTE, cuando ENEL DISTRIBUCIÓN PERÚ así lo estime "
                    + "conveniente. La autorización que efectúa el CLIENTE comprende asimismo la difusión o comercialización de dicha información a terceros, sin responsabilidad ulterior para ENEL DISTRIBUCIÓN PERÚ ni para los terceros.\n", fontContenido));
            col3p2.add(new Chunk("Asimismo, con la finalidad de evaluar permanentemente la capacidad de pago del CLIENTE, éste autoriza irrevocablemente a ENEL DISTRIBUCIÓN PERÚ a verificar las informaciones que le proporcione, y a actualizarlas e intercambiarlas con otros acreedores y/o con centrales de riesgo públicas y/o privadas. Los costos que se generen por la obtención y análisis de esta información serán de cargo del CLIENTE.\n", fontContenido));
            col3p2.add(new Chunk("La información reportada permanecerá en la referidas centrales de riesgo durante el tiempo que establezcan las normas que regulan la materia y de acuerdo con los términos y condiciones definidos por ellas.\n", fontContenido));

            PdfPCell celda1p2 = new PdfPCell(col1p2);
            celda1p2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda1p2.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda2p2 = new PdfPCell(col2p2);
            celda2p2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda2p2.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda3p2 = new PdfPCell(col3p2);
            celda3p2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda3p2.setBorder(PdfPCell.NO_BORDER);
            loTablap2.addCell(celda1p2);
            loTablap2.addCell(celda2p2);
            loTablap2.addCell(celda3p2);

            PdfContentByte contentBytep2 = writer.getDirectContent();
            Rectangle rectABCp2 = new Rectangle(43, 800, 165, 825);
            rectABCp2.setBorder(Rectangle.BOX);
            contentBytep2.setColorStroke(BaseColor.BLACK);
            rectABCp2.setBorderWidth(1);
            contentBytep2.rectangle(rectABC);

            //Textos en los rectangulos
            ColumnText abcText2 = new ColumnText(contentByte);
            abcText2.setSimpleColumn(48, 800, 165, 825);
            abcText2.addElement(new Paragraph("ABC-", fontTitulos));
            abcText2.go();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loTablap2);

            //TERCERA PAGINA
            loDoc.newPage();
            PdfPTable loTablap3 = new PdfPTable(3);
            Paragraph col1p3 = new Paragraph();

            loTablap3.setWidths(new float[]{5, 1, 5});
            //loTabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            //Primera columna
            col1p3.add(new Chunk("DÉCIMO QUINTA.- NOTIFICACIONES\n", fontSub));
            col1p3.add(new Chunk("Para todos los efectos judiciales y extrajudiciales del presente contrato, las partes señalan como sus domicilios los indicados en este Contrato en donde se entregarán todas las comunicaciones y notificaciones a que hubiere lugar. "
                    + "Mientras el CLIENTE no comunique a ENEL DISTRIBUCIÓN PERÚ por escrito el cambio de su domicilio, con una anticipación no menor de treinta (30) días calendario en forma previa al cambio efectivo de domicilio, toda la correspondencia "
                    + "se practicará y se tendrá por válidamente realizada en el domicilio señalado originalmente.\n", fontContenido));
            col1p3.add(new Phrase(Chunk.NEWLINE));
            col1p3.add(new Chunk("DÉCIMO SEXTA.- VIGENCIA\n", fontSub));
            col1p3.add(new Chunk("Este Contrato entrará en vigor a partir de la fecha de su suscripción y durará hasta el momento en que el CLIENTE haya cubierto la totalidad de los montos adeudados.\n", fontContenido));
            col1p3.add(new Phrase(Chunk.NEWLINE));
            col1p3.add(new Phrase("DÉCIMO SÉTIMA.- DISPOSICIONES VARIAS\n", fontSub));
            col1p3.add(new Phrase("La nulidad o invalidez, total o parcial, de una o más de las disposiciones contenidas en este Contrato no afectará la validez de las demás disposiciones.\n", fontContenido));
            col1p3.add(new Phrase("Los términos de este Contrato deben entenderse e interpretarse en forma integral, no pudiendo interpretarse separadamente unos de otros.\n", fontContenido));
            col1p3.add(new Phrase("Ninguna modificación o cambio a los términos o condiciones de este Contrato se considerará válida y obligatoria para ninguna de las partes a menos que se haga por escrito.\n", fontContenido));
            col1p3.add(new Phrase(Chunk.NEWLINE));
            col1p3.add(new Phrase("DÉCIMO OCTAVA.- JURISDICCIÓN Y LEY APLICABLE \n", fontSub));
            col1p3.add(new Phrase("Este Contrato se rige e interpretará de conformidad con las leyes de la República del Perú, las mismas que se aplicarán en forma supletoria a lo pactado por las partes.\n", fontContenido));
            col1p3.add(new Phrase("Las partes se someten expresamente a la competencia de los jueces y tribunales de Lima.\n", fontContenido));

            for (int cont = 0; cont < 11; cont++) {
                col1p3.add(new Phrase(Chunk.NEWLINE));
            }

            col1p3.add(new Phrase("Suscrito en la ciudad de Lima, a los " + LibFunc.getFechaLargaActual() + ", en dos ejemplares de igual tenor literal.", fontContenido));

            Phrase col2p3 = new Phrase();
            Phrase col3p3 = new Phrase();

            PdfPCell celda1p3 = new PdfPCell(col1p3);
            celda1p3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda1p3.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda2p3 = new PdfPCell(col2p3);
            celda2p3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda2p3.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda3p3 = new PdfPCell(col3p3);
            celda3p3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda3p3.setBorder(PdfPCell.NO_BORDER);
            loTablap3.addCell(celda1p3);
            loTablap3.addCell(celda2p3);
            loTablap3.addCell(celda3p3);

            PdfContentByte contentBytep3 = writer.getDirectContent();
            Rectangle rectABCp3 = new Rectangle(43, 800, 165, 825);
            rectABCp3.setBorder(Rectangle.BOX);
            contentBytep3.setColorStroke(BaseColor.BLACK);
            rectABCp3.setBorderWidth(1);

            Rectangle rectHuella = new Rectangle(480, 150, 545, 235);
            rectHuella.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectHuella.setBorderWidth(1);
            contentBytep3.rectangle(rectABC);
            contentBytep3.rectangle(rectHuella);

            //Textos en los rectangulos
            ColumnText abcText3 = new ColumnText(contentByte);
            abcText3.setSimpleColumn(48, 800, 165, 825);
            abcText3.addElement(new Paragraph("ABC-", fontTitulos));
            abcText3.go();

            ColumnText huellaText = new ColumnText(contentByte);
            huellaText.setSimpleColumn(480, 132, 560, 152);
            huellaText.addElement(new Paragraph("HUELLA DIGITAL", fontContenido));
            huellaText.go();
            ColumnText indiceText = new ColumnText(contentByte);
            indiceText.setSimpleColumn(478, 122, 555, 142);
            indiceText.addElement(new Paragraph("INDICE DERECHO", fontContenido));
            indiceText.go();

            ColumnText firmaText1 = new ColumnText(contentByte);
            firmaText1.setSimpleColumn(85, 98, 250, 118);
            firmaText1.addElement(new Paragraph("ENEL DISTRIBUCIÓN PERÚ", fontSub));
            firmaText1.go();
            ColumnText firmaText2 = new ColumnText(contentByte);
            firmaText2.setSimpleColumn(89, 87, 250, 108);
            firmaText2.addElement(new Paragraph("Carlos Alberto Solis Pino", fontSub));
            firmaText2.go();
            ColumnText firmaText3 = new ColumnText(contentByte);
            firmaText3.setSimpleColumn(97, 79, 250, 98);
            firmaText3.addElement(new Paragraph("Head of Market Perú", fontSub));
            firmaText3.go();

            ColumnText clienteText1 = new ColumnText(contentByte);
            clienteText1.setSimpleColumn(260, 106, 400, 126);
            clienteText1.addElement(new Paragraph("EL CLIENTE", fontSub));
            clienteText1.go();
            ColumnText clienteText2 = new ColumnText(contentByte);
            clienteText2.setSimpleColumn(260, 100, 700, 115);
            clienteText2.addElement(new Paragraph("Nombre y Apellidos: " + p_oCredito.getCliente().getNombre() + " " + p_oCredito.getCliente().getApePat() + " " + p_oCredito.getCliente().getApeMat(), fontSub));
            clienteText2.go();
            ColumnText clienteText3 = new ColumnText(contentByte);
            clienteText3.setSimpleColumn(260, 82, 400, 98);
            clienteText3.addElement(new Paragraph("Documento de identidad: " + p_oCredito.getCliente().getNroDocCiv(), fontSub));
            clienteText3.go();
            ColumnText clienteText4 = new ColumnText(contentByte);
            clienteText4.setSimpleColumn(260, 64, 400, 80);
            clienteText4.addElement(new Paragraph("Domicilio: " + p_oCredito.getCliente().getDireccion().getDireccion(), fontSub));
            clienteText4.go();

            //Lineas
            contentByte.moveTo(70, 120);
            contentByte.lineTo(210, 120);
            contentByte.closePathStroke();

            contentByte.moveTo(260, 130);
            contentByte.lineTo(410, 130);
            contentByte.closePathStroke();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loTablap3);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxAutorizacionCobranza() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            llOk = mxAutorizacionCobranzaArchivo(loCre.getCredito());
            if (llOk) {
                setRutaReporte("/ftia/files/cartas/autorizacionCobranza_" + loCre.getCredito().getCodCta() + ".pdf");
                LibFunc.mxLog("Autorización de Cobranza OK.");
            } else {
                LibFunc.mxLog("Autorización de Cobranza error: " + getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxAutorizacionCobranzaArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/autorizacionCobranza_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, 30, 30, 10, 50);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontSub = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.BOLD,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.HELVETICA, 12, Font.BOLD,
                    BaseColor.BLACK);
            Font fontMensaje = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Paragraph loTitulo = new Paragraph();
            PdfPTable loTablaCuerpo = new PdfPTable(1);
            PdfPTable loTablaMedia = new PdfPTable(3);
            Paragraph loParrafo = new Paragraph();

            Image logo = Image.getInstance("/ftia/img/enelLOGO.png");
            logo.scaleToFit(110, 35);
            logo.setAlignment(Element.ALIGN_CENTER);

            //Titulo
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Paragraph("AUTORIZACIÓN DE ENCARGO DE COBRANZA", fontTitulos));
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.setAlignment(Element.ALIGN_CENTER);

            //Cuerpo de Tabla principal
            PdfPCell celda1 = new PdfPCell(new Phrase("Producto Adquirido\n\n", fontSub));
            celda1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda1.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda2 = new PdfPCell(new Phrase(p_oCredito.getProducto().getNombre() + "\n\n\n", fontContenido));
            celda2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            Phrase contenido3 = new Phrase();
            contenido3.add(new Phrase(Chunk.NEWLINE));
            contenido3.add(new Chunk("Yo, " + p_oCredito.getCliente().getNomCom(), fontContenido));
            contenido3.add(new Chunk(" con Documento de Identidad Nº " + p_oCredito.getCliente().getNroDocCiv() + " declaro ser titular del suministro eléctrico N° ", fontContenido));
            contenido3.add(new Chunk(p_oCredito.getCliente().getSumini() + " el cual corresponde al predio ubicado en ", fontContenido));
            contenido3.add(new Chunk(p_oCredito.getCliente().getDireccion().getDireccion() + ".\n\n", fontContenido));
            PdfPCell celda3 = new PdfPCell(contenido3);
            celda3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda3.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido4 = new Phrase();
            contenido4.add(new Phrase("Por el presente documento, solicito y autorizo a ENEL DISTRIBUCION PERU S.A.A. a que, "
                    + "bajo la modalidad de ENCARGO DE COBRANZA, se cargue en el recibo de energía eléctrica "
                    + "del suministro indicado, los montos que corresponden a las cuotas pactadas para la "
                    + "cancelación del producto.\n\n", fontContenido));
            PdfPCell celda4 = new PdfPCell(contenido4);
            celda4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda4.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido5 = new Phrase("Yo, como RESPONSABLE DE PAGO, cancelaré las cuotas de manera puntual junto con el monto correspondiente al consumo eléctrico.\n\n", fontContenido);
            PdfPCell celda5 = new PdfPCell(contenido5);
            celda5.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda5.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido6 = new Phrase("Las condiciones de pago que conozco y autorizo son las siguientes:\n\n", fontContenido);
            contenido6.add(new Phrase(Chunk.NEWLINE));
            PdfPCell celda6 = new PdfPCell(contenido6);
            celda6.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda6.setBorder(PdfPCell.NO_BORDER);

            loTablaCuerpo.addCell(celda1);
            loTablaCuerpo.addCell(celda2);
            loTablaCuerpo.addCell(celda3);
            loTablaCuerpo.addCell(celda4);
            loTablaCuerpo.addCell(celda5);
            loTablaCuerpo.addCell(celda6);

            //SEGUNDA TABLA
            PdfPCell celda1T2 = new PdfPCell(new Phrase("MONTO TOTAL", fontSub));
            celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda2T2 = new PdfPCell(new Phrase("N° DE CUOTAS", fontSub));
            celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda3T2 = new PdfPCell(new Phrase("VALOR DE CUOTA", fontSub));
            celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell celda4T2 = new PdfPCell(new Phrase(String.valueOf(p_oCredito.getCapSol()), fontContenido));
            celda4T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            PdfPCell celda5T2 = new PdfPCell(new Phrase(String.valueOf(p_oCredito.getCuotas()), fontContenido));
            celda5T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            PdfPCell celda6T2 = new PdfPCell(new Phrase(String.valueOf(p_oCredito.getCuota()), fontContenido));
            celda6T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            loTablaMedia.addCell(celda1T2);
            loTablaMedia.addCell(celda2T2);
            loTablaMedia.addCell(celda3T2);
            loTablaMedia.addCell(celda4T2);
            loTablaMedia.addCell(celda5T2);
            loTablaMedia.addCell(celda6T2);

            //Texto
            loParrafo.setIndentationLeft(53);
            loParrafo.setIndentationRight(53);

            loParrafo.add(new Phrase("(*) La primera cuota será incluida en el recibo de energía eléctrica al mes siguiente de la venta del producto.\n", fontMensaje));
            loParrafo.add(new Phrase(Chunk.NEWLINE));
            loParrafo.add(new Phrase("Tasa de Interés Compensatoria:", fontSub));
            loParrafo.add(new Phrase(Chunk.NEWLINE));
            loParrafo.add(new Phrase("TEA: " + p_oCredito.getTasa() + "%", fontContenido));
            loParrafo.add(new Phrase(Chunk.NEWLINE));
            loParrafo.add(new Phrase("TCEA: " + p_oCredito.getTCEA() + "%", fontContenido));

            for (int cont = 0; cont < 4; cont++) {
                loParrafo.add(new Phrase(Chunk.NEWLINE));
            }

            loParrafo.add(new Phrase(LibFunc.getFechaLargaActual(), fontContenido));

            for (int cont = 0; cont < 8; cont++) {
                loParrafo.add(new Phrase(Chunk.NEWLINE));
            }

            loParrafo.add(new Phrase("Firma: ____________________________", fontContenido));

            PdfContentByte contentByte = writer.getDirectContent();
            Rectangle rectABC = new Rectangle(43, 800, 165, 825);
            rectABC.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectABC.setBorderWidth(1);

            Rectangle rectHuella = new Rectangle(436, 150, 501, 235);
            rectHuella.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectHuella.setBorderWidth(1);
            contentByte.rectangle(rectHuella);
            contentByte.rectangle(rectABC);

            //Textos en los rectangulos
            ColumnText abcText = new ColumnText(contentByte);
            abcText.setSimpleColumn(48, 800, 165, 825);
            abcText.addElement(new Paragraph("ABC-", fontTitulos));
            abcText.go();
            ColumnText huellaText = new ColumnText(contentByte);
            huellaText.setSimpleColumn(430, 132, 550, 152);
            huellaText.addElement(new Paragraph("HUELLA DIGITAL", fontContenido));
            huellaText.go();
            ColumnText indiceText = new ColumnText(contentByte);
            indiceText.setSimpleColumn(427, 119, 550, 142);
            indiceText.addElement(new Paragraph("INDICE DERECHO", fontContenido));
            indiceText.go();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loTablaCuerpo);
            loDoc.add(loTablaMedia);
            loDoc.add(loParrafo);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxPagareIncompleto() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            //llOk = loCre.mxAplicar();
            if (llOk) {
                llOk = mxPagareIncompletoArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/pagareIncompleto_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Pagaré incompleto a la vista OK.");
                } else {
                    LibFunc.mxLog("Pagaré incompleto a la vista error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxPagareIncompletoArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/pagareIncompleto_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, 30, 30, 10, 50);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontSub = FontFactory.getFont(
                    FontFactory.HELVETICA, 10, Font.BOLD,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.HELVETICA, 12, Font.BOLD,
                    BaseColor.BLACK);

            Paragraph loTitulo = new Paragraph();
            PdfPTable loTablaCuerpo = new PdfPTable(2);
            PdfPTable loTablaMedia = new PdfPTable(1);
            PdfPTable loTablaFin = new PdfPTable(4);
            Paragraph loParrafo = new Paragraph();

            Image logo = Image.getInstance("/ftia/img/enelLOGO.png");
            logo.scaleToFit(110, 35);
            logo.setAlignment(Element.ALIGN_CENTER);

            //Titulo
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Paragraph("PAGARÉ INCOMPLETO A LA VISTA", fontTitulos));
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.setAlignment(Element.ALIGN_CENTER);

            //Cuerpo de Tabla principal
            PdfPCell celda1 = new PdfPCell(new Phrase("Pagaré Nro.", fontContenido));
            celda1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            Phrase contenido2 = new Phrase(p_oCredito.getCodCta(), fontContenido);
            PdfPCell celda2 = new PdfPCell(contenido2);
            celda2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            PdfPCell celda3 = new PdfPCell(new Phrase("Moneda e Importe", fontContenido));
            celda3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            Phrase contenido4 = new Phrase();
            PdfPCell celda4 = new PdfPCell(contenido4);
            celda4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            PdfPCell celda5 = new PdfPCell(new Phrase("Lugar y Fecha de Emisión", fontContenido));
            celda5.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            Phrase contenido6 = new Phrase("Lima, " + LibFunc.getFechaLargaActual(), fontContenido);
            PdfPCell celda6 = new PdfPCell(contenido6);
            celda6.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            loTablaCuerpo.addCell(celda1);
            loTablaCuerpo.addCell(celda2);
            loTablaCuerpo.addCell(celda3);
            loTablaCuerpo.addCell(celda4);
            loTablaCuerpo.addCell(celda5);
            loTablaCuerpo.addCell(celda6);

            //SEGUNDA TABLA
            Phrase contenido1T2 = new Phrase();
            contenido1T2.add(new Phrase(Chunk.NEWLINE));
            contenido1T2.add(new Chunk("Por este Pagaré, yo " + p_oCredito.getCliente().getNombre() + " " + p_oCredito.getCliente().getApePat() + " " + p_oCredito.getCliente().getApeMat() + ", ", fontContenido));
            contenido1T2.add(new Chunk("me comprometo, solidaria e  incondicionalmente, a pagar a la  orden de ENEL DISTRIBUCIÓN ", fontContenido));
            contenido1T2.add(new Chunk("PERÚ S.A.A., la cantidad de ______________________________________________ ", fontContenido));
            contenido1T2.add(new Chunk("Soles (S/. _______________), importe correspondiente a la liquidación de las sumas adeudadas a ", fontContenido));
            contenido1T2.add(new Chunk("ENEL  DISTRIBUCIÓN  PERÚ  S.A.A. y  que  me  obligo a  pagar en la  misma  moneda, en ", fontContenido));
            contenido1T2.add(new Chunk("(domicilio) " + p_oCredito.getCliente().getDireccion().getDireccion() + ".\n\n", fontContenido));
            PdfPCell celda1T2 = new PdfPCell(contenido1T2);
            celda1T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda1T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido2T2 = new Phrase("Queda establecido que si, a la fecha de presentación del presente documento, no cancelo el "
                    + "importe arriba indicado, éste generará un interés compensatorio a razón de una Tasa Efectiva Anual "
                    + "(TEA) de " + p_oCredito.getTasa() + "%. Asimismo, si no pagáramos el íntegro del importe adeudado, se aplicará, sin que "
                    + "sea necesario requerimiento ni intimación alguna, un monto por concepto de intereses moratorios a "
                    + "razón de una Tasa Efectiva Anual (TEA) de " + p_oCredito.getTasa() + "% sobre el importe no pagado, más las comisiones, "
                    + "penalidades, gastos notariales y gastos de cobranza judicial o extrajudicial que se devenguen por "
                    + "todo el plazo que pudiera transcurrir hasta la fecha efectiva de pago de la obligación de este Pagaré.\n\n", fontContenido);
            PdfPCell celda2T2 = new PdfPCell(contenido2T2);
            celda2T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda2T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido3T2 = new Phrase("El presente Pagaré ha sido emitido incompleto conforme lo permite el artículo 10 de la Ley de No. 27287 – "
                    + "Ley de Títulos Valores, por lo tanto, tiene pendiente de indicación su importe y fecha de integración, data "
                    + "que ENEL DISTRIBUCIÓN PERÚ S.A.A. queda facultado a completar conforme lo señalado en el Contrato de Financiamiento. "
                    + "Su vencimiento es a la vista y podrá ser presentado para su pago dentro del año siguiente a su fecha de integración, "
                    + "la cual será determinada por ENEL DISTRIBUCIÓN PERÚ S.A.A.\n\n", fontContenido);
            PdfPCell celda3T2 = new PdfPCell(contenido3T2);
            celda3T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda3T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido4T2 = new Phrase("De otro lado, acepto (amos) expresamente toda renovación o prórroga, total o parcial de este Pagaré que efectúe ENEL "
                    + "DISTRIBUCIÓN PERÚ S.A.A., la misma que será anotada en este documento. Dicha anotación no requerirá mi (nuestra) suscripción, "
                    + "bastando en todo caso para su validez, que las prórrogas sean suscritas por el tenedor, en este mismo instrumento o en hoja adherida. "
                    + "Asimismo, se deja constancia que este Pagaré no requerirá ser protestado para ejercer las acciones derivadas del mismo.\n\n", fontContenido);
            PdfPCell celda4T2 = new PdfPCell(contenido4T2);
            celda4T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda4T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido5T2 = new Phrase("Queda expresamente establecido que nuestro domicilio es el indicado en este Pagaré, lugar donde se dirigirán todas las comunicaciones y notificaciones derivadas del mismo, judiciales o extrajudiciales. \n\n", fontContenido);
            PdfPCell celda5T2 = new PdfPCell(contenido5T2);
            celda5T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda5T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido6T2 = new Phrase("El presente Pagaré está sujeto a la ley peruana y a la competencia de los jueces y tribunales del Distrito Judicial de Lima "
                    + "(Cercado), salvo que ENEL DISTRIBUCIÓN PERÚ S.A.A. decida unilateralmente someterse a la competencia de los jueces y tribunales "
                    + "del domicilio del obligado principal. \n\n", fontContenido);
            PdfPCell celda6T2 = new PdfPCell(contenido6T2);
            celda6T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda6T2.setBorder(PdfPCell.NO_BORDER);

            Phrase contenido7T2 = new Phrase("Fecha de integración del monto de este Pagaré: " + LibFunc.getFechaLargaActual() + "\n\n", fontContenido);
            PdfPCell celda7T2 = new PdfPCell(contenido7T2);
            celda7T2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            celda7T2.setBorder(PdfPCell.NO_BORDER);

            loTablaMedia.addCell(celda1T2);
            loTablaMedia.addCell(celda2T2);
            loTablaMedia.addCell(celda3T2);
            loTablaMedia.addCell(celda4T2);
            loTablaMedia.addCell(celda5T2);
            loTablaMedia.addCell(celda6T2);
            loTablaMedia.addCell(celda7T2);

            //Tabla Final - primera fila
            loTablaFin.setSpacingBefore(15);
            loTablaFin.setWidths(new float[]{1, 4, 1, 1});

            PdfPCell celda1T3 = new PdfPCell();
            celda1T3.setBorder(PdfPCell.NO_BORDER);
            celda1T3.setRowspan(4);

            Phrase contenido2T3 = new Phrase();
            contenido2T3.add(new Phrase("\n\n\n\n\n\nDeudor Principal", fontSub));
            PdfPCell celda2T3 = new PdfPCell(contenido2T3);
            celda2T3.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T3.setVerticalAlignment(Element.ALIGN_BOTTOM);

            PdfPCell celda3T3 = new PdfPCell();

            PdfPCell celda4T3 = new PdfPCell();
            celda4T3.setBorder(PdfPCell.NO_BORDER);
            celda4T3.setRowspan(4);

            //segunda fila
            Phrase contenido6T3 = new Phrase();
            contenido6T3.add(new Phrase("Nombres y Apellidos:\n", fontSub));
            contenido6T3.add(new Phrase(p_oCredito.getCliente().getNombre() + " " + p_oCredito.getCliente().getApePat() + " " + p_oCredito.getCliente().getApeMat(), fontContenido));
            PdfPCell celda6T3 = new PdfPCell(contenido6T3);
            celda6T3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            Phrase contenido7T3 = new Phrase();
            contenido7T3.add(new Phrase("\nHUELLA DIGITAL\n INDICE DERECHO", fontContenido));
            PdfPCell celda7T3 = new PdfPCell(contenido7T3);
            celda7T3.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda7T3.setVerticalAlignment(Element.ALIGN_CENTER);
            celda7T3.setRowspan(3);

            //Tercera Fila
            Phrase contenido10T3 = new Phrase();
            contenido10T3.add(new Phrase("Documento de Identidad:\n", fontSub));
            contenido10T3.add(new Phrase(p_oCredito.getCliente().getNroDocCiv(), fontContenido));
            PdfPCell celda10T3 = new PdfPCell(contenido10T3);
            celda10T3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            //Cuarta Fila
            Phrase contenido14T3 = new Phrase();
            contenido14T3.add(new Phrase("Dirección:\n", fontSub));
            contenido14T3.add(new Phrase(p_oCredito.getCliente().getDireccion().getDireccion(), fontContenido));
            PdfPCell celda14T3 = new PdfPCell(contenido14T3);
            celda14T3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            loTablaFin.addCell(celda1T3);
            loTablaFin.addCell(celda2T3);
            loTablaFin.addCell(celda3T3);
            loTablaFin.addCell(celda4T3);
            loTablaFin.addCell(celda6T3);
            loTablaFin.addCell(celda7T3);
            loTablaFin.addCell(celda10T3);
            loTablaFin.addCell(celda14T3);

            PdfContentByte contentByte = writer.getDirectContent();
            Rectangle rectABC = new Rectangle(43, 800, 165, 825);
            rectABC.setBorder(Rectangle.BOX);
            contentByte.setColorStroke(BaseColor.BLACK);
            rectABC.setBorderWidth(1);
            contentByte.rectangle(rectABC);

            //Textos en los rectangulos
            ColumnText abcText = new ColumnText(contentByte);
            abcText.setSimpleColumn(48, 800, 165, 825);
            abcText.addElement(new Paragraph("ABC-", fontTitulos));
            abcText.go();

            loDoc.add(logo);
            loDoc.add(loTitulo);
            loDoc.add(loTablaCuerpo);
            loDoc.add(loTablaMedia);
            loDoc.add(loTablaFin);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxKardex() throws SQLException, IOException, ParseException  {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            //llOk = loCre.mxAplicar();
            if (llOk) {
                llOk = mxKardexArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/kardex_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Kardex OK.");
                } else {
                    LibFunc.mxLog("Kardex error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxKardexArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/kardex_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -50, -50, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);

            PdfPTable loTablaDatos = new PdfPTable(4);
            PdfPTable loTablaCreditos = new PdfPTable(11);
            Paragraph loParrafo = new Paragraph();
            Paragraph loFrase = new Paragraph();

            loTablaDatos.setWidths(new float[]{2, 4, 4, 1});

            //Primera Tabla
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("ENEL", fontContenido));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda2T1 = new PdfPCell(new Phrase("KARDEX DE CRÉDITOS", fontContenido));
            celda2T1.setBorder(PdfPCell.NO_BORDER);
            celda2T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T1.setColspan(2);
            PdfPCell celda3T1 = new PdfPCell(new Phrase("PAG.:", fontContenido));
            celda3T1.setBorder(PdfPCell.NO_BORDER);

            //Segunda fila
            PdfPCell celda4T1 = new PdfPCell(new Phrase("CREDITOS", fontContenido));
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda5T1 = new PdfPCell(new Phrase("CUENTA: " + p_oCredito.getCodCta(), fontContenido));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            celda5T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda6T1 = new PdfPCell(new Phrase("CLIENTE: " + p_oCredito.getCliente().getCodCli() , fontContenido));
            celda6T1.setBorder(PdfPCell.NO_BORDER);
            celda6T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda7T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda7T1.setBorder(PdfPCell.NO_BORDER);

            //Tercera fila
            PdfPCell celda8T1 = new PdfPCell(new Phrase("frmCREMovimientos - " + getUser(), fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            celda8T1.setRowspan(2);
            PdfPCell celda9T1 = new PdfPCell(new Phrase("CLIENTE: " + p_oCredito.getCliente().getNomCom(), fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);
            celda9T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda10T1 = new PdfPCell(new Phrase("MONEDA: " + p_oCredito.getMoneda(), fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            celda10T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11T1 = new PdfPCell(new Phrase("HR: " + LibFunc.getHoraActual(), fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            celda11T1.setRowspan(2);

            //Cuarta fila
            PdfPCell celda12T1 = new PdfPCell(new Phrase("LINEA: " + p_oCredito.getProducto().getNombre(), fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            celda12T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda13T1 = new PdfPCell(new Phrase("TASA INT: " + p_oCredito.getTasa() + "%", fontContenido));
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            celda13T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            loTablaDatos.addCell(celda1T1);
            loTablaDatos.addCell(celda2T1);
            loTablaDatos.addCell(celda3T1);
            loTablaDatos.addCell(celda4T1);
            loTablaDatos.addCell(celda5T1);
            loTablaDatos.addCell(celda6T1);
            loTablaDatos.addCell(celda7T1);
            loTablaDatos.addCell(celda8T1);
            loTablaDatos.addCell(celda9T1);
            loTablaDatos.addCell(celda10T1);
            loTablaDatos.addCell(celda11T1);
            loTablaDatos.addCell(celda12T1);
            loTablaDatos.addCell(celda13T1);

            loParrafo.add(new Phrase(Chunk.NEWLINE));

            //Segunda Tabla
            //Primera Fila
            PdfPCell celda1T2 = new PdfPCell(new Phrase("MOV", fontContenido));
            celda1T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda2T2 = new PdfPCell(new Phrase("NRO.", fontContenido));
            celda2T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda3T2 = new PdfPCell(new Phrase("CAPITAL", fontContenido));
            celda3T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda4T2 = new PdfPCell(new Phrase("INTERES", fontContenido));
            celda4T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda4T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda5T2 = new PdfPCell(new Phrase("MORA", fontContenido));
            celda5T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda5T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda6T2 = new PdfPCell(new Phrase("GASTOS", fontContenido));
            celda6T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda6T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda7T2 = new PdfPCell(new Phrase("TOTAL", fontContenido));
            celda7T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda7T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda8T2 = new PdfPCell(new Phrase("FECHA", fontContenido));
            celda8T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda8T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda9T2 = new PdfPCell(new Phrase("OF", fontContenido));
            celda9T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda9T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda10T2 = new PdfPCell(new Phrase("DOCUMENTO", fontContenido));
            celda10T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda10T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11T2 = new PdfPCell(new Phrase("HORA", fontContenido));
            celda11T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda11T2.setHorizontalAlignment(Element.ALIGN_CENTER);

            loTablaCreditos.addCell(celda1T2);
            loTablaCreditos.addCell(celda2T2);
            loTablaCreditos.addCell(celda3T2);
            loTablaCreditos.addCell(celda4T2);
            loTablaCreditos.addCell(celda5T2);
            loTablaCreditos.addCell(celda6T2);
            loTablaCreditos.addCell(celda7T2);
            loTablaCreditos.addCell(celda8T2);
            loTablaCreditos.addCell(celda9T2);
            loTablaCreditos.addCell(celda10T2);
            loTablaCreditos.addCell(celda11T2);
            
            loFrase.setIndentationLeft(70);
            loFrase.add(new Phrase(Chunk.NEWLINE));
            loFrase.add(new Phrase("SECTORISTA:    " + p_oCredito.getNomAna(), fontContenido));

            loDoc.add(loTablaDatos);
            loDoc.add(loParrafo);
            loDoc.add(loTablaCreditos);
            loDoc.add(loFrase);
            
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxEstadoCuenta() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            llOk = loCre.mxPlanPagos();
            if (llOk) {
                llOk = mxEstadoCuentaArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/estadoCuenta_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Estado de Cuenta OK.");
                } else {
                    LibFunc.mxLog("Estado de Cuenta error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }

    public boolean mxEstadoCuentaArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/estadoCuenta_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4.rotate(), -80, -80, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);
            
            PdfPTable loTablaDatos = new PdfPTable(6);
            PdfPTable loTablaCuenta = new PdfPTable(14);
            PdfPTable loTablaLista = new PdfPTable(7);
            Phrase loParrafo = new Phrase();
            Paragraph loFrase = new Paragraph();
            Phrase loEspacio = new Phrase();

            loTablaDatos.setWidths(new float[]{2, 2, 2, 2, 2, 1});
            loTablaLista.setWidths(new float[]{2, 1, 2, 2, 1, 1, 11});

            //Primera Tabla
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("ENEL", fontContenido));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda2T1 = new PdfPCell(new Phrase("ESTADO DE CUENTA DE SALDO DEUDOR", fontContenido));
            celda2T1.setBorder(PdfPCell.NO_BORDER);
            celda2T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T1.setColspan(4);
            PdfPCell celda3T1 = new PdfPCell(new Phrase("PAG.:", fontContenido));
            celda3T1.setBorder(PdfPCell.NO_BORDER);

            //Segunda fila
            PdfPCell celda4T1 = new PdfPCell(new Phrase("CREDITOS", fontContenido));
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda5T1 = new PdfPCell(new Phrase("A FECHA: " + LibFunc.getFechaActual(), fontContenido));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            celda5T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda5T1.setColspan(4);
            celda5T1.setRowspan(2);
            PdfPCell celda6T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda6T1.setBorder(PdfPCell.NO_BORDER);

            //Tercera fila
            PdfPCell celda8T1 = new PdfPCell(new Phrase("frmCREMovimientos - " + getUser(), fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda9T1 = new PdfPCell(new Phrase(LibFunc.getHoraActual(), fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);

            //Cuarta fila
            PdfPCell celda10T1 = new PdfPCell(new Phrase("CUENTA: " + p_oCredito.getCodCta(), fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda11T1 = new PdfPCell(new Phrase("CLIENTE: " + p_oCredito.getCliente().getCodCli(), fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda12T1 = new PdfPCell(new Phrase(p_oCredito.getCliente().getNomCom(), fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda13T1 = new PdfPCell(new Phrase("MODA.: ORDINARIO", fontContenido));
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda14T1 = new PdfPCell(new Phrase("ATR.: " + p_oCredito.getDiaAtr() , fontContenido));
            celda14T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T1 = new PdfPCell(new Phrase("MONEDA: " + p_oCredito.getMoneda(), fontContenido));
            celda15T1.setBorder(PdfPCell.NO_BORDER);

            //Quinta fila
            PdfPCell celda16T1 = new PdfPCell(new Phrase("DESEMB.: 10,000.00", fontContenido));
            celda16T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda17T1 = new PdfPCell(new Phrase("FECHA 20-ABR-2015", fontContenido));
            celda17T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T1 = new PdfPCell(new Phrase("TASA EFECTIVA ANUAL:" + p_oCredito.getTasa() + "%", fontContenido));
            celda18T1.setBorder(PdfPCell.NO_BORDER);
            celda18T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda18T1.setColspan(2);
            PdfPCell celda19T1 = new PdfPCell(new Phrase("TASA MORATORIA ANUAL: 150.00%", fontContenido));
            celda19T1.setBorder(PdfPCell.NO_BORDER);
            celda19T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda19T1.setColspan(2);

            loTablaDatos.addCell(celda1T1);
            loTablaDatos.addCell(celda2T1);
            loTablaDatos.addCell(celda3T1);
            loTablaDatos.addCell(celda4T1);
            loTablaDatos.addCell(celda5T1);
            loTablaDatos.addCell(celda6T1);
            loTablaDatos.addCell(celda8T1);
            loTablaDatos.addCell(celda9T1);
            loTablaDatos.addCell(celda10T1);
            loTablaDatos.addCell(celda11T1);
            loTablaDatos.addCell(celda12T1);
            loTablaDatos.addCell(celda13T1);
            loTablaDatos.addCell(celda14T1);
            loTablaDatos.addCell(celda15T1);
            loTablaDatos.addCell(celda16T1);
            loTablaDatos.addCell(celda17T1);
            loTablaDatos.addCell(celda18T1);
            loTablaDatos.addCell(celda19T1);

            loParrafo.add(new Phrase(Chunk.NEWLINE));

            //Segunda Tabla
            //Primera fila
            PdfPCell celda0T2 = new PdfPCell();
            celda0T2.setBorder(PdfPCell.TOP);
            celda0T2.setColspan(4);
            PdfPCell celda1T2 = new PdfPCell(new Phrase("CAPITAL", fontContenido));
            celda1T2.setBorder(PdfPCell.TOP);
            celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda1T2.setColspan(2);
            PdfPCell celda2T2 = new PdfPCell(new Phrase("INTERÉS.", fontContenido));
            celda2T2.setBorder(PdfPCell.TOP);
            celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T2.setColspan(2);
            PdfPCell celda3T2 = new PdfPCell(new Phrase("MORA", fontContenido));
            celda3T2.setBorder(PdfPCell.TOP);
            celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda3T2.setColspan(2);
            PdfPCell celda4T2 = new PdfPCell(new Phrase("GASTOS", fontContenido));
            celda4T2.setBorder(PdfPCell.TOP);
            celda4T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda4T2.setColspan(2);
            PdfPCell celda5T2 = new PdfPCell(new Phrase("TOTAL PAGADO", fontContenido));
            celda5T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda5T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda5T2.setRowspan(2);
            PdfPCell celda6T2 = new PdfPCell(new Phrase("TOTAL A PAGAR", fontContenido));
            celda6T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda6T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda6T2.setRowspan(2);

            //Segunda fila
            PdfPCell celda7T2 = new PdfPCell(new Phrase("NRO.", fontContenido));
            celda7T2.setBorder(PdfPCell.BOTTOM);
            celda7T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda8T2 = new PdfPCell(new Phrase("VENCIM.", fontContenido));
            celda8T2.setBorder(PdfPCell.BOTTOM);
            celda8T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda9T2 = new PdfPCell(new Phrase("PAGADO", fontContenido));
            celda9T2.setBorder(PdfPCell.BOTTOM);
            celda9T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda10T2 = new PdfPCell(new Phrase("ATR.", fontContenido));
            celda10T2.setBorder(PdfPCell.BOTTOM);
            celda10T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11T2 = new PdfPCell(new Phrase("PROGRAM.", fontContenido));
            celda11T2.setBorder(PdfPCell.BOTTOM);
            celda11T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda12T2 = new PdfPCell(new Phrase("PAGADO", fontContenido));
            celda12T2.setBorder(PdfPCell.BOTTOM);
            celda12T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda13T2 = new PdfPCell(new Phrase("PENDIEN.", fontContenido));
            celda13T2.setBorder(PdfPCell.BOTTOM);
            celda13T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda14T2 = new PdfPCell(new Phrase("PAGADO", fontContenido));
            celda14T2.setBorder(PdfPCell.BOTTOM);
            celda14T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda15T2 = new PdfPCell(new Phrase("PEND.", fontContenido));
            celda15T2.setBorder(PdfPCell.BOTTOM);
            celda15T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda16T2 = new PdfPCell(new Phrase("PAG.", fontContenido));
            celda16T2.setBorder(PdfPCell.BOTTOM);
            celda16T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda17T2 = new PdfPCell(new Phrase("CARG.", fontContenido));
            celda17T2.setBorder(PdfPCell.BOTTOM);
            celda17T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda18T2 = new PdfPCell(new Phrase("PAG.", fontContenido));
            celda18T2.setBorder(PdfPCell.BOTTOM);
            celda18T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            loTablaCuenta.addCell(celda0T2);
            loTablaCuenta.addCell(celda1T2);
            loTablaCuenta.addCell(celda2T2);
            loTablaCuenta.addCell(celda3T2);
            loTablaCuenta.addCell(celda4T2);
            loTablaCuenta.addCell(celda5T2);
            loTablaCuenta.addCell(celda6T2);
            loTablaCuenta.addCell(celda7T2);
            loTablaCuenta.addCell(celda8T2);
            loTablaCuenta.addCell(celda9T2);
            loTablaCuenta.addCell(celda10T2);
            loTablaCuenta.addCell(celda11T2);
            loTablaCuenta.addCell(celda12T2);
            loTablaCuenta.addCell(celda13T2);
            loTablaCuenta.addCell(celda14T2);
            loTablaCuenta.addCell(celda15T2);
            loTablaCuenta.addCell(celda16T2);
            loTablaCuenta.addCell(celda17T2);
            loTablaCuenta.addCell(celda18T2);
            
            for (Cuota loCuota : p_oCredito.getPlanPagos()) {
                celda7T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getNumero()), fontContenido));
                celda7T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda7T2.setBorder(PdfPCell.NO_BORDER);
                celda8T2 = new PdfPCell(new Phrase("", fontContenido));
                celda8T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda8T2.setBorder(PdfPCell.NO_BORDER);
                celda9T2 = new PdfPCell(new Phrase("", fontContenido));
                celda9T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda9T2.setBorder(PdfPCell.NO_BORDER);
                celda10T2 = new PdfPCell(new Phrase("", fontContenido));
                celda10T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda10T2.setBorder(PdfPCell.NO_BORDER);
                celda11T2 = new PdfPCell(new Phrase("", fontContenido));
                celda11T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda11T2.setBorder(PdfPCell.NO_BORDER);
                celda12T2 = new PdfPCell(new Phrase("", fontContenido));
                celda12T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda12T2.setBorder(PdfPCell.NO_BORDER);
                celda13T2 = new PdfPCell(new Phrase("", fontContenido));
                celda13T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda13T2.setBorder(PdfPCell.NO_BORDER);
                celda14T2 = new PdfPCell(new Phrase("", fontContenido));
                celda14T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda14T2.setBorder(PdfPCell.NO_BORDER);
                celda15T2 = new PdfPCell(new Phrase("", fontContenido));
                celda15T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda15T2.setBorder(PdfPCell.NO_BORDER);
                celda16T2 = new PdfPCell(new Phrase("", fontContenido));
                celda16T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda16T2.setBorder(PdfPCell.NO_BORDER);
                celda17T2 = new PdfPCell(new Phrase("", fontContenido));
                celda17T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda17T2.setBorder(PdfPCell.NO_BORDER);
                celda18T2 = new PdfPCell(new Phrase("", fontContenido));
                celda18T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda18T2.setBorder(PdfPCell.NO_BORDER);
                celda5T2 = new PdfPCell(new Phrase("", fontContenido));
                celda5T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda5T2.setBorder(PdfPCell.NO_BORDER);
                celda6T2 = new PdfPCell(new Phrase("", fontContenido));
                celda6T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda6T2.setBorder(PdfPCell.NO_BORDER);
                
                loTablaCuenta.addCell(celda7T2);
                loTablaCuenta.addCell(celda8T2);
                loTablaCuenta.addCell(celda9T2);
                loTablaCuenta.addCell(celda10T2);
                loTablaCuenta.addCell(celda11T2);
                loTablaCuenta.addCell(celda12T2);
                loTablaCuenta.addCell(celda13T2);
                loTablaCuenta.addCell(celda14T2);
                loTablaCuenta.addCell(celda15T2);
                loTablaCuenta.addCell(celda16T2);
                loTablaCuenta.addCell(celda17T2);
                loTablaCuenta.addCell(celda18T2);
                loTablaCuenta.addCell(celda5T2);
                loTablaCuenta.addCell(celda6T2);
            }
            
            loEspacio.add(new Phrase(Chunk.NEWLINE));

            //Tercera fila
            PdfPCell celda1T3 = new PdfPCell(new Phrase("CAPITAL POR VENCER", fontContenido));
            celda1T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda2T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda2T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda3T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda3T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda4T3 = new PdfPCell(new Phrase("NOTA OBJETIVA", fontContenido));
            celda4T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda5T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda5T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda6T3 = new PdfPCell(new Phrase("1", fontContenido));
            celda6T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda7T3 = new PdfPCell();
            celda7T3.setBorder(PdfPCell.NO_BORDER);
            celda7T3.setRowspan(6);

            PdfPCell celda8T3 = new PdfPCell(new Phrase("CAPITAL VENCIDO", fontContenido));
            celda8T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda9T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda9T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda10T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda10T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda11T3 = new PdfPCell(new Phrase("PROMEDIO ATRASO", fontContenido));
            celda11T3.setBorder(PdfPCell.NO_BORDER);
            celda11T3.setRowspan(5);
            PdfPCell celda12T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda12T3.setBorder(PdfPCell.NO_BORDER);
            celda12T3.setRowspan(5);
            PdfPCell celda13T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda13T3.setBorder(PdfPCell.NO_BORDER);
            celda13T3.setRowspan(5);

            PdfPCell celda14T3 = new PdfPCell(new Phrase("INTERES PENDIENTE", fontContenido));
            celda14T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda15T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda16T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda16T3.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda17T3 = new PdfPCell(new Phrase("MORA PENDIENTE", fontContenido));
            celda17T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda18T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda19T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda19T3.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda20T3 = new PdfPCell(new Phrase("GASTOS PENDIENTES", fontContenido));
            celda20T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda21T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda21T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda22T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda22T3.setBorder(PdfPCell.NO_BORDER);

            PdfPCell celda23T3 = new PdfPCell(new Phrase("TOTAL", fontContenido));
            celda23T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda24T3 = new PdfPCell(new Phrase(":", fontContenido));
            celda24T3.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda25T3 = new PdfPCell(new Phrase("0.00", fontContenido));
            celda25T3.setBorder(PdfPCell.TITLE);

            loTablaLista.addCell(celda1T3);
            loTablaLista.addCell(celda2T3);
            loTablaLista.addCell(celda3T3);
            loTablaLista.addCell(celda4T3);
            loTablaLista.addCell(celda5T3);
            loTablaLista.addCell(celda6T3);
            loTablaLista.addCell(celda7T3);
            loTablaLista.addCell(celda8T3);
            loTablaLista.addCell(celda9T3);
            loTablaLista.addCell(celda10T3);
            loTablaLista.addCell(celda11T3);
            loTablaLista.addCell(celda12T3);
            loTablaLista.addCell(celda13T3);
            loTablaLista.addCell(celda14T3);
            loTablaLista.addCell(celda15T3);
            loTablaLista.addCell(celda16T3);
            loTablaLista.addCell(celda17T3);
            loTablaLista.addCell(celda18T3);
            loTablaLista.addCell(celda19T3);
            loTablaLista.addCell(celda20T3);
            loTablaLista.addCell(celda21T3);
            loTablaLista.addCell(celda22T3);
            loTablaLista.addCell(celda23T3);
            loTablaLista.addCell(celda24T3);
            loTablaLista.addCell(celda25T3);

            loFrase.setIndentationLeft(100);
            loFrase.add(new Phrase(Chunk.NEWLINE));
            loFrase.add(new Phrase("SECTORISTA         :  " + p_oCredito.getNomAna(), fontContenido));
            loFrase.add(new Phrase(Chunk.NEWLINE));
            loFrase.add(new Phrase("ABOGADO             :  ", fontContenido));

            loDoc.add(loTablaDatos);
            loDoc.add(loParrafo);
            loDoc.add(loTablaCuenta);
            loDoc.add(loEspacio);
            loDoc.add(loTablaLista);
            loDoc.add(loFrase);
            
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public boolean mxCalendarioPagos() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            llOk = loCre.mxPlanPagos();
            if (llOk) {
                llOk = mxCalendarioPagosArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/calendarioPagos_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Calendario de pagos OK.");
                } else {
                    LibFunc.mxLog("Calendario de pagos error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }
    
    public boolean mxCalendarioPagosArchivo(Credito p_oCredito) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/calendarioPagos_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -50, -50, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTexto = FontFactory.getFont(
                    FontFactory.HELVETICA, 8, Font.NORMAL,
                    BaseColor.BLACK);

            PdfPTable loTablaDatos = new PdfPTable(6);
            PdfPTable loTablaPagos = new PdfPTable(12);

            //Primera Tabla
            PdfPCell celda0T1 = new PdfPCell(new Phrase("ENEL", fontContenido));
            celda0T1.setBorder(PdfPCell.NO_BORDER);
            celda0T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda0T1.setColspan(6);
                
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("CREDITOS", fontContenido));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            celda1T1.setColspan(2);
            PdfPCell celda2T1 = new PdfPCell(new Phrase("01 - OFICINA PRINCIPAL", fontContenido));
            celda2T1.setBorder(PdfPCell.NO_BORDER);
            celda2T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda2T1.setColspan(2);
            PdfPCell celda3T1 = new PdfPCell(new Phrase("PAG.:", fontContenido));
            celda3T1.setBorder(PdfPCell.NO_BORDER);
            celda3T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda3T1.setColspan(2);

            //Segunda fila
            PdfPCell celda4T1 = new PdfPCell(new Phrase("frmCREDocumentos " + getUser(), fontContenido));
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            celda4T1.setColspan(2);
            celda4T1.setRowspan(2);
            PdfPCell celda5T1 = new PdfPCell(new Phrase("CALENDARIO DE PAGOS", fontContenido));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            celda5T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda5T1.setColspan(2);
            PdfPCell celda6T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda6T1.setBorder(PdfPCell.NO_BORDER);
            celda6T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda6T1.setColspan(2);

            //Tercera fila
            PdfPCell celda7T1 = new PdfPCell(new Phrase("MICROEMPRESAS - ACTIVO FIJO MUEBLES MN", fontContenido));
            celda7T1.setBorder(PdfPCell.NO_BORDER);
            celda7T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda7T1.setColspan(2);
            PdfPCell celda8T1 = new PdfPCell(new Phrase("HR: " + LibFunc.getHoraActual(), fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            celda8T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda8T1.setColspan(2);

            //Cuarta fila
            PdfPCell celda9T1 = new PdfPCell(new Phrase("CREDITO: " + p_oCredito.getCodCta(), fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);
            celda9T1.setColspan(2);
            PdfPCell celda10T1 = new PdfPCell(new Phrase("CLIENTE: " + p_oCredito.getCliente().getNomCom(), fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            celda10T1.setColspan(4);
            celda10T1.setRowspan(2);

            //Quinta fila
            PdfPCell celda11T1 = new PdfPCell(new Phrase("MONTO: s/ 9,900.00", fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            celda11T1.setColspan(2);
            PdfPCell celda12T1 = new PdfPCell(new Phrase("T.EFECTIVA ANUAL: " + p_oCredito.getTasa() + "%", fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            celda12T1.setColspan(2);
                
            //Sexta fila
            PdfPCell celda13T1 = new PdfPCell(new Phrase("CUOTA: " + p_oCredito.getCuota(), fontContenido));
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            celda13T1.setColspan(2);
            PdfPCell celda14T1 = new PdfPCell(new Phrase("DNI: " + p_oCredito.getCliente().getNroDocCiv(), fontContenido));
            celda14T1.setBorder(PdfPCell.NO_BORDER);
            celda14T1.setColspan(2);
            PdfPCell celda15T1 = new PdfPCell(new Phrase("TASA MORATORIA ANUAL:: 100.00%", fontContenido));
            celda15T1.setBorder(PdfPCell.NO_BORDER);
            celda15T1.setColspan(2);

            //Septima fila
            PdfPCell celda16T1 = new PdfPCell(new Phrase("NRO. CUOTAS : " + p_oCredito.getCuotas(), fontContenido));
            celda16T1.setBorder(PdfPCell.NO_BORDER);
            celda16T1.setColspan(6);

            //Octava fila
            PdfPCell celda17T1 = new PdfPCell(new Phrase("ASESOR FINANCIERO: " + p_oCredito.getNomAna(), fontContenido));
            celda17T1.setBorder(PdfPCell.NO_BORDER);
            celda17T1.setColspan(6);
                
            //Novena fila
            PdfPCell celda18T1 = new PdfPCell(new Phrase("COSTO EFECTIVO ANUAL: " + p_oCredito.getTCEA() + "%", fontContenido));
            celda18T1.setBorder(PdfPCell.NO_BORDER);
            celda18T1.setColspan(6);

            loTablaDatos.addCell(celda0T1);
            loTablaDatos.addCell(celda1T1);
            loTablaDatos.addCell(celda2T1);
            loTablaDatos.addCell(celda3T1);
            loTablaDatos.addCell(celda4T1);
            loTablaDatos.addCell(celda5T1);
            loTablaDatos.addCell(celda6T1);
            loTablaDatos.addCell(celda7T1);
            loTablaDatos.addCell(celda8T1);
            loTablaDatos.addCell(celda9T1);
            loTablaDatos.addCell(celda10T1);
            loTablaDatos.addCell(celda11T1);
            loTablaDatos.addCell(celda12T1);
            loTablaDatos.addCell(celda13T1);
            loTablaDatos.addCell(celda14T1);
            loTablaDatos.addCell(celda15T1);
            loTablaDatos.addCell(celda16T1);
            loTablaDatos.addCell(celda17T1);
            loTablaDatos.addCell(celda18T1);
            loTablaDatos.setSpacingAfter(20);

            //Segunda Tabla
            //Primera Fila
            PdfPCell celda1T2 = new PdfPCell(new Phrase("DES", fontContenido));
            celda1T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda2T2 = new PdfPCell(new Phrase("CUO", fontContenido));
            celda2T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda3T2 = new PdfPCell(new Phrase("FECHA", fontContenido));
            celda3T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda4T2 = new PdfPCell(new Phrase("DÍA", fontContenido));
            celda4T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda4T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda5T2 = new PdfPCell(new Phrase("OPER.", fontContenido));
            celda5T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda5T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda6T2 = new PdfPCell(new Phrase("CAPITAL", fontContenido));
            celda6T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda6T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda7T2 = new PdfPCell(new Phrase("INTERÉS", fontContenido));
            celda7T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda7T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda8T2 = new PdfPCell(new Phrase("SEGUROS DESG./HIP.", fontContenido));
            celda8T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda8T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda9T2 = new PdfPCell(new Phrase("SEG GARANT.", fontContenido));
            celda9T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda9T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda10T2 = new PdfPCell(new Phrase("I.T.F.", fontContenido));
            celda10T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda10T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11T2 = new PdfPCell(new Phrase("CUOTA", fontContenido));
            celda11T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda11T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda12T2 = new PdfPCell(new Phrase("SALDO CAP.", fontContenido));
            celda12T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda12T2.setHorizontalAlignment(Element.ALIGN_CENTER);

            loTablaPagos.addCell(celda1T2);
            loTablaPagos.addCell(celda2T2);
            loTablaPagos.addCell(celda3T2);
            loTablaPagos.addCell(celda4T2);
            loTablaPagos.addCell(celda5T2);
            loTablaPagos.addCell(celda6T2);
            loTablaPagos.addCell(celda7T2);
            loTablaPagos.addCell(celda8T2);
            loTablaPagos.addCell(celda9T2);
            loTablaPagos.addCell(celda10T2);
            loTablaPagos.addCell(celda11T2);
            loTablaPagos.addCell(celda12T2);
            
            for (Cuota loCuota : p_oCredito.getPlanPagos()) {
                celda1T2 = new PdfPCell(new Phrase("", fontContenido));
                celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda1T2.setBorder(PdfPCell.NO_BORDER);
                celda2T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getNumero()), fontContenido));
                celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda2T2.setBorder(PdfPCell.NO_BORDER);
                celda3T2 = new PdfPCell(new Phrase(loCuota.getFecha(), fontContenido));
                celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda3T2.setBorder(PdfPCell.NO_BORDER);
                celda4T2 = new PdfPCell(new Phrase("", fontContenido));
                celda4T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda4T2.setBorder(PdfPCell.NO_BORDER);
                celda5T2 = new PdfPCell(new Phrase("", fontContenido));
                celda5T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda5T2.setBorder(PdfPCell.NO_BORDER);
                celda6T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getCapital()), fontContenido));
                celda6T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda6T2.setBorder(PdfPCell.NO_BORDER);
                celda7T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getInteres()), fontContenido));
                celda7T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda7T2.setBorder(PdfPCell.NO_BORDER);
                celda8T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getSegDes()), fontContenido));
                celda8T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda8T2.setBorder(PdfPCell.NO_BORDER);
                celda9T2 = new PdfPCell(new Phrase("", fontContenido));
                celda9T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda9T2.setBorder(PdfPCell.NO_BORDER);
                celda10T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getItf()), fontContenido));
                celda10T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda10T2.setBorder(PdfPCell.NO_BORDER);
                celda11T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getCuota()), fontContenido));
                celda11T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda11T2.setBorder(PdfPCell.NO_BORDER);
                celda12T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getSalCap()), fontContenido));
                celda12T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda12T2.setBorder(PdfPCell.NO_BORDER);
                
                loTablaPagos.addCell(celda1T2);
                loTablaPagos.addCell(celda2T2);
                loTablaPagos.addCell(celda3T2);
                loTablaPagos.addCell(celda4T2);
                loTablaPagos.addCell(celda5T2);
                loTablaPagos.addCell(celda6T2);
                loTablaPagos.addCell(celda7T2);
                loTablaPagos.addCell(celda8T2);
                loTablaPagos.addCell(celda9T2);
                loTablaPagos.addCell(celda10T2);
                loTablaPagos.addCell(celda11T2);
                loTablaPagos.addCell(celda12T2);
            }
            
            //Fila total
            PdfPCell celda13T2 = new PdfPCell(new Phrase("TOTAL", fontContenido));
            celda13T2.setBorder(PdfPCell.TOP);
            celda13T2.setColspan(5);
            PdfPCell celda14T2 = new PdfPCell(new Phrase("", fontContenido));
            celda14T2.setBorder(PdfPCell.TOP);
            celda14T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda15T2 = new PdfPCell(new Phrase("", fontContenido));
            celda15T2.setBorder(PdfPCell.TOP);
            celda15T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda16T2 = new PdfPCell(new Phrase("", fontContenido));
            celda16T2.setBorder(PdfPCell.TOP);
            celda16T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda17T2 = new PdfPCell(new Phrase("", fontContenido));
            celda17T2.setBorder(PdfPCell.TOP);
            celda17T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda18T2 = new PdfPCell(new Phrase("", fontContenido));
            celda18T2.setBorder(PdfPCell.TOP);
            celda18T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda19T2 = new PdfPCell(new Phrase("", fontContenido));
            celda19T2.setBorder(PdfPCell.TOP);
            celda19T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda20T2 = new PdfPCell();
            celda20T2.setBorder(PdfPCell.TOP);

            loTablaPagos.addCell(celda13T2);
            loTablaPagos.addCell(celda14T2);
            loTablaPagos.addCell(celda15T2);
            loTablaPagos.addCell(celda16T2);
            loTablaPagos.addCell(celda17T2);
            loTablaPagos.addCell(celda18T2);
            loTablaPagos.addCell(celda19T2);
            loTablaPagos.addCell(celda20T2);

            loDoc.add(loTablaDatos);
            loDoc.add(loTablaPagos);

            //SEGUNDA PAGINA
            loDoc.newPage();
            Paragraph loParrafo = new Paragraph();
            com.itextpdf.text.List listado = new com.itextpdf.text.List(false, true, 20);

            loParrafo.setIndentationRight(40);
            loParrafo.setIndentationLeft(80);
            listado.setIndentationLeft(-80);

            loParrafo.add(new Phrase("Información de importancia", fontTexto));

            ListItem item0 = new ListItem("Puedes realizar tus pagos en el Banco Interbank, a través de:", fontTexto);
            listado.add(item0);

            com.itextpdf.text.List sublist1;
            sublist1 = new com.itextpdf.text.List(10);
            ListItem subItem0 = new ListItem("Agentes: Código de Caja Centro es 2753001 y el código del crédito 03-0-1-1002052.3 SIN COMISIONES.", fontTexto);
            ListItem subItem1 = new ListItem("Ventanillas: Código de Caja Centro es 0753001 y el código del crédito 03-0-1-1002052.3 COMISIÓN S/ 4.00.", fontTexto);
            sublist1.add(subItem0);
            sublist1.add(subItem1);
            listado.add(sublist1);

            ListItem item1 = new ListItem("Puedes realizar tus pagos en el BCP, a través de:", fontTexto);
            listado.add(item1);

            com.itextpdf.text.List sublist2;
            sublist2 = new com.itextpdf.text.List(10);
            ListItem subItem2 = new ListItem("Agentes: Código de Caja Centro es 12127 y el código del crédito 03-0-1-1002052.3 COMISIÓN S/ 2.50.", fontTexto);
            ListItem subItem3 = new ListItem("Ventanillas: Código de Caja Centro es 12127 y el código del crédito 03-0-1-1002052.3 COMISIÓN S/ 4.00.", fontTexto);
            sublist2.add(subItem2);
            sublist2.add(subItem3);
            listado.add(sublist2);

            ListItem item2 = new ListItem("Caja Centro te informa que tienes derecho a efectuar pagos por encima de la cuota exigible del periodo, pudiendo éstas clasificarse en:", fontTexto);
            listado.add(item2);

            com.itextpdf.text.List sublist3;
            sublist3 = new com.itextpdf.text.List(10);
            ListItem subItem4 = new ListItem("Adelanto de cuotas: Pago aplicable a las cuotas inmediatamente posteriores a la exigible en el periodo, sin que se produzca una reducción de los intereses, las comisiones y gastos.", fontTexto);
            subItem4.setAlignment(Element.ALIGN_JUSTIFIED);
            ListItem subItem5 = new ListItem("Pago anticipado: Pago aplicable al capital del crédito, con la consiguiente reducción de los intereses, comisiones y gastos. El cliente debe informar la decisión de disminuir el monto de la cuota manteniendo el plazo original o disminuir el número de cuotas con la consecuente reducción del plazo de crédito.", fontTexto);
            subItem5.setAlignment(Element.ALIGN_JUSTIFIED);
            sublist3.add(subItem4);
            sublist3.add(subItem5);
            listado.add(sublist3);

            ListItem item3 = new ListItem("La opción elegida debe ser comunicada al personal autorizado de Caja Centro, caso contrario y cuando la operación sea realizada por una tercera persona, por defecto si optará lo siguiente:", fontTexto);
            item3.setAlignment(Element.ALIGN_JUSTIFIED);
            listado.add(item3);

            com.itextpdf.text.List sublist4;
            sublist4 = new com.itextpdf.text.List(10);
            ListItem subItem6 = new ListItem("Para pagos menores o iguales al equivalente de dos cuotas, incluye la cuota exigible en el periodo, serán consideradas adelanto de cuotas.", fontTexto);
            subItem6.setAlignment(Element.ALIGN_JUSTIFIED);
            ListItem subItem7 = new ListItem("Para pagos mayores a dos cuotas, incluye la cuota exigible en el periodo, se aplicará la disminución de plazo, el nuevo cronograma de pagos generado debe ser solicitado por el titular del crédito en las oficinas de Caja Centro o solicitar el envío a su correo electrónico.", fontTexto);
            subItem7.setAlignment(Element.ALIGN_JUSTIFIED);
            ListItem subItem8 = new ListItem("El cliente tiene un plazo de 15 días calendarios, los cuales deben ser dentro del mes, para informar el cambio de condición aplicado por defecto.", fontTexto);
            subItem8.setAlignment(Element.ALIGN_JUSTIFIED);
            sublist4.add(subItem6);
            sublist4.add(subItem7);
            sublist4.add(subItem8);
            listado.add(sublist4);

            ListItem item4 = new ListItem("Las cancelaciones anticipadas de crédito no están afectas a comisiones ni penalidades, las mismas que se pueden realizar en las agencias donde se lleva a cabo los desembolsos.", fontTexto);
            item4.setAlignment(Element.ALIGN_JUSTIFIED);
            listado.add(item4);

            loParrafo.add(listado);
            loParrafo.setAlignment(Element.ALIGN_JUSTIFIED);

            loDoc.add(loParrafo);
            
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public boolean mxPlanPagos() throws SQLException, IOException, ParseException {
        CCreditos loCre = new CCreditos();
        loCre.setUrl(getUrl());
        loCre.setUser(getUser());
        loCre.setPasswd(getPasswd());
        loCre.setCredito(getCredito());
        boolean llOk = loCre.mxAplicar();
        if (llOk) {
            llOk = loCre.mxPlanPagos();
            if (llOk) {
                llOk = mxPlanPagosArchivo(loCre.getCredito());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/planPagos_" + loCre.getCredito().getCodCta() + ".pdf");
                    LibFunc.mxLog("Plan de pagos OK.");
                } else {
                    LibFunc.mxLog("Plan de pagos error: " + getError());
                }
            } else {
                setError(loCre.getError());
            }
        } else {
            setError(loCre.getError());
        }
        return llOk;
    }
    
    public boolean mxPlanPagosArchivo(Credito p_oCredito) throws IOException, ParseException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/planPagos_" + p_oCredito.getCodCta() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -50, -50, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 8, Font.NORMAL,
                    BaseColor.BLACK);

            PdfPTable loTablaDatos = new PdfPTable(6);
            PdfPTable loTablaPagos = new PdfPTable(5);
            
            loTablaDatos.setWidths(new float[]{10, 20, 11, 40, 10, 10});
            //sloTablaPagos.setWidths(new float[]{4, 3, 3, 3, 4});
            
            //Primera Tabla
            PdfPCell celda0T1 = new PdfPCell(new Phrase("ENEL", fontContenido));
            celda0T1.setBorder(PdfPCell.NO_BORDER);
            celda0T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda0T1.setColspan(6);
            
            //Segunda fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("CLIENTE", fontContenido));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            celda1T1.setColspan(6);
            
            //Tercera fila
            PdfPCell celda2T1 = new PdfPCell(new Phrase("Código" , fontContenido));
            celda2T1.setBorder(PdfPCell.BOTTOM);
            celda2T1.setFixedHeight(20);
            PdfPCell celda3T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCliente().getCodCli(), fontContenido));
            celda3T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda4T1 = new PdfPCell(new Phrase("Nombre", fontContenido));
            celda4T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda5T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCliente().getNomCom(), fontContenido));
            celda5T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda6T1 = new PdfPCell(new Phrase("Documento", fontContenido));
            celda6T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda7T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCliente().getNroDocCiv(), fontContenido));
            celda7T1.setBorder(PdfPCell.BOTTOM);
            //celda7T1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            //Cuarta fila
            PdfPCell celda8T1 = new PdfPCell(new Phrase("CRÉDITO", fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            celda8T1.setColspan(6);
            
            //Quinta fila
            PdfPCell celda9T1 = new PdfPCell(new Phrase("Crédito", fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda10T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCodCta(), fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda11T1 = new PdfPCell(new Phrase("Fecha de solicitud", fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda12T1 = new PdfPCell(new Phrase(": " + formateador(p_oCredito.getFecSol()), fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda13T1 = new PdfPCell();
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            celda13T1.setColspan(2);

            //Sexta fila
            PdfPCell celda14T1 = new PdfPCell(new Phrase("Monto: ", fontContenido));
            celda14T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T1 = new PdfPCell(new Phrase(": ", fontContenido));
            celda15T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda16T1 = new PdfPCell(new Phrase("Tasa de interés", fontContenido));
            celda16T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda17T1 = new PdfPCell(new Phrase(": " + p_oCredito.getTasa() + "%", fontContenido));
            celda17T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T1 = new PdfPCell(new Phrase("Tasa de mora" , fontContenido));
            celda18T1.setBorder(PdfPCell.NO_BORDER);
            //celda18T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda19T1 = new PdfPCell(new Phrase(": 0.0%" , fontContenido));
            celda19T1.setBorder(PdfPCell.NO_BORDER);
            //celda19T1.setHorizontalAlignment(Element.ALIGN_RIGHT);

            //Septima fila
            PdfPCell celda20T1 = new PdfPCell(new Phrase("Nro. de cuotas", fontContenido));
            celda20T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda21T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCuotas(), fontContenido));
            celda21T1.setBorder(PdfPCell.BOTTOM);
            celda21T1.setFixedHeight(20);
            PdfPCell celda22T1 = new PdfPCell(new Phrase("Monto por cuota", fontContenido));
            celda22T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda23T1 = new PdfPCell(new Phrase(": " + p_oCredito.getCuota(), fontContenido));
            celda23T1.setBorder(PdfPCell.BOTTOM);
            PdfPCell celda24T1 = new PdfPCell();
            celda24T1.setBorder(PdfPCell.BOTTOM);
            celda24T1.setColspan(2);
            
            //Octava fila
            PdfPCell celda25T1 = new PdfPCell(new Phrase("Asesor financiero", fontContenido));
            celda25T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda26T1 = new PdfPCell(new Phrase(": " + p_oCredito.getNomAna(), fontContenido));
            celda26T1.setBorder(PdfPCell.NO_BORDER);
            celda26T1.setColspan(5);

            loTablaDatos.addCell(celda0T1);
            loTablaDatos.addCell(celda1T1);
            loTablaDatos.addCell(celda2T1);
            loTablaDatos.addCell(celda3T1);
            loTablaDatos.addCell(celda4T1);
            loTablaDatos.addCell(celda5T1);
            loTablaDatos.addCell(celda6T1);
            loTablaDatos.addCell(celda7T1);
            loTablaDatos.addCell(celda8T1);
            loTablaDatos.addCell(celda9T1);
            loTablaDatos.addCell(celda10T1);
            loTablaDatos.addCell(celda11T1);
            loTablaDatos.addCell(celda12T1);
            loTablaDatos.addCell(celda13T1);
            loTablaDatos.addCell(celda14T1);
            loTablaDatos.addCell(celda15T1);
            loTablaDatos.addCell(celda16T1);
            loTablaDatos.addCell(celda17T1);
            loTablaDatos.addCell(celda18T1);
            loTablaDatos.addCell(celda19T1);
            loTablaDatos.addCell(celda20T1);
            loTablaDatos.addCell(celda21T1);
            loTablaDatos.addCell(celda22T1);
            loTablaDatos.addCell(celda23T1);
            loTablaDatos.addCell(celda24T1);
            loTablaDatos.addCell(celda25T1);
            loTablaDatos.addCell(celda26T1);
            loTablaDatos.setSpacingAfter(20);

            //Segunda Tabla
            //Primera Fila
            PdfPCell celda0T2 = new PdfPCell();
            celda0T2.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda1T2 = new PdfPCell(new Phrase("Nro. cuota", fontContenido));
            celda1T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda2T2 = new PdfPCell(new Phrase("Monto cuota S/", fontContenido));
            celda2T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda3T2 = new PdfPCell(new Phrase("Fecha de vencimiento", fontContenido));
            celda3T2.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
            celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celda00T2 = new PdfPCell();
            celda00T2.setBorder(PdfPCell.NO_BORDER);

            loTablaPagos.addCell(celda0T2);
            loTablaPagos.addCell(celda1T2);
            loTablaPagos.addCell(celda2T2);
            loTablaPagos.addCell(celda3T2);
            loTablaPagos.addCell(celda00T2);
            
            for (Cuota loCuota : p_oCredito.getPlanPagos()) {
                celda0T2 = new PdfPCell();
                celda0T2.setBorder(PdfPCell.NO_BORDER);
                celda1T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getNumero()), fontContenido));
                celda1T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda1T2.setBorder(PdfPCell.NO_BORDER);
                celda2T2 = new PdfPCell(new Phrase(String.valueOf(loCuota.getCuota()), fontContenido));
                celda2T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda2T2.setBorder(PdfPCell.NO_BORDER);
                celda3T2 = new PdfPCell(new Phrase(formateador(loCuota.getFecha()), fontContenido));
                celda3T2.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda3T2.setBorder(PdfPCell.NO_BORDER);
                celda00T2 = new PdfPCell();
                celda00T2.setBorder(PdfPCell.NO_BORDER);
                
                loTablaPagos.addCell(celda0T2);
                loTablaPagos.addCell(celda1T2);
                loTablaPagos.addCell(celda2T2);
                loTablaPagos.addCell(celda3T2);
                loTablaPagos.addCell(celda00T2);
            }
            
            loDoc.add(loTablaDatos);
            loDoc.add(loTablaPagos);
            
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    /**
     * @return the pthFil
     */
    public String getPthFil() {
        return pthFil;
    }

    /**
     * @param pthFil the pthFil to set
     */
    public void setPthFil(String pthFil) {
        this.pthFil = pthFil;
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
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
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
     * @return the cliente
     */
    public Credito getCredito() {
        return credito;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
