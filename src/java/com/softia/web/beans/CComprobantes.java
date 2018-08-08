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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.ListItem;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CComprobantes {
    
    private Cliente cliente;
    private Credito credito;
    private String pthFil;
    private String rutaReporte;
    private String error;
    private String url;
    private String user;
    private String passwd;
    
    public boolean mxCobranza() throws SQLException, IOException {
        CClientes loCli = new CClientes();
        loCli.setUrl(getUrl());
        loCli.setUser(getUser());
        loCli.setPasswd(getPasswd());
        loCli.setCliente(getCliente());
        boolean llOk = loCli.mxAplicar();
        if (llOk) {
            llOk = loCli.mxCreditos();
            if (llOk) {
                llOk = mxCobranzaComprobante(loCli.getCliente());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/cobranzaComprobante_" + getCliente().getCodCli() + ".pdf");
                    LibFunc.mxLog("Comprobante de cobranza OK.");
                } else {
                    LibFunc.mxLog("Comprobante de cobranza error: " + getError());
                }
            } else {
                setError(loCli.getError());
            }
        } else {
            setError(loCli.getError());
        }
        return llOk;
    }
    
    public boolean mxCobranzaComprobante(Cliente p_oCliente) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/cobranzaComprobante_" + p_oCliente.getCodCli() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -30, -30, 70, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTitulo = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.BOLD,
                    BaseColor.BLACK);
            PdfPTable loTablaDatos = new PdfPTable(7);

            loTablaDatos.setWidths(new float[]{3, 1, 6, 5, 3, 1, 6});

            //Primera Tabla
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("***COMPROBANTE COBRANZA***", fontTitulo));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            celda1T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda1T1.setColspan(3);
            PdfPCell celda2T1 = new PdfPCell();
            celda2T1.setBorder(PdfPCell.NO_BORDER);
            celda2T1.setRowspan(7);
            PdfPCell celda3T1 = new PdfPCell(new Phrase("***COMPROBANTE COBRANZA***", fontTitulo));
            celda3T1.setBorder(PdfPCell.NO_BORDER);
            celda3T1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda3T1.setColspan(3);

            //Segunda fila
            PdfPCell celda4T1 = new PdfPCell(new Phrase("FECHA", fontContenido));
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda5T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda6T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda6T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda7T1 = new PdfPCell(new Phrase("FECHA", fontContenido));
            celda7T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda8T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda9T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);

            //Tercera fila
            PdfPCell celda10T1 = new PdfPCell(new Phrase("COMPROBANTE", fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda11T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda12T1 = new PdfPCell(new Phrase("01 - 000534", fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda13T1 = new PdfPCell(new Phrase("COMPROBANTE", fontContenido));
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda14T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda14T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T1 = new PdfPCell(new Phrase("01 - 000534", fontContenido));
            celda15T1.setBorder(PdfPCell.NO_BORDER);
            
            //Cuarta fila
            PdfPCell celda16T1 = new PdfPCell(new Phrase("CREDITO", fontContenido));
            celda16T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda17T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda17T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T1 = new PdfPCell(new Phrase("", fontContenido));
            celda18T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda19T1 = new PdfPCell(new Phrase("CREDITO", fontContenido));
            celda19T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda20T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda20T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda21T1 = new PdfPCell(new Phrase("", fontContenido));
            celda21T1.setBorder(PdfPCell.NO_BORDER);
            
            //Quinta fila
            PdfPCell celda22T1 = new PdfPCell(new Phrase("PRODUCTO", fontContenido));
            celda22T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda23T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda23T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda24T1 = new PdfPCell(new Phrase("", fontContenido));
            celda24T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda25T1 = new PdfPCell(new Phrase("PRODUCTO", fontContenido));
            celda25T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda26T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda26T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda27T1 = new PdfPCell(new Phrase("", fontContenido));
            celda27T1.setBorder(PdfPCell.NO_BORDER);
            
            //Sexta fila
            PdfPCell celda28T1 = new PdfPCell(new Phrase("MONTO", fontContenido));
            celda28T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda29T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda29T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda30T1 = new PdfPCell(new Phrase("", fontContenido));
            celda30T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda31T1 = new PdfPCell(new Phrase("MONTO", fontContenido));
            celda31T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda32T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda32T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda33T1 = new PdfPCell(new Phrase("", fontContenido));
            celda33T1.setBorder(PdfPCell.NO_BORDER);
            
            //Septima fila
            PdfPCell celda34T1 = new PdfPCell(new Phrase("CAJA/BANCOS", fontContenido));
            celda34T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda35T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda35T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda36T1 = new PdfPCell(new Phrase("BCP", fontContenido));
            celda36T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda37T1 = new PdfPCell(new Phrase("CAJA/BANCOS", fontContenido));
            celda37T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda38T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda38T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda39T1 = new PdfPCell(new Phrase("BCP", fontContenido));
            celda39T1.setBorder(PdfPCell.NO_BORDER);

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
            loTablaDatos.addCell(celda27T1);
            loTablaDatos.addCell(celda28T1);
            loTablaDatos.addCell(celda29T1);
            loTablaDatos.addCell(celda30T1);
            loTablaDatos.addCell(celda31T1);
            loTablaDatos.addCell(celda32T1);
            loTablaDatos.addCell(celda33T1);
            loTablaDatos.addCell(celda34T1);
            loTablaDatos.addCell(celda35T1);
            loTablaDatos.addCell(celda36T1);
            loTablaDatos.addCell(celda37T1);
            loTablaDatos.addCell(celda38T1);
            loTablaDatos.addCell(celda39T1);
            
            loDoc.add(loTablaDatos);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public boolean mxDesembolso() throws SQLException, IOException {
        CClientes loCli = new CClientes();
        loCli.setUrl(getUrl());
        loCli.setUser(getUser());
        loCli.setPasswd(getPasswd());
        loCli.setCliente(getCliente());
        boolean llOk = loCli.mxAplicar();
        if (llOk) {
            llOk = loCli.mxCreditos();
            if (llOk) {
                llOk = mxDesembolsoComprobante(loCli.getCliente());
                if (llOk) {
                    setRutaReporte("/ftia/files/cartas/desembolsoComprobante_" + getCliente().getCodCli() + ".pdf");
                    LibFunc.mxLog("Comprobante de desembolso OK.");
                } else {
                    LibFunc.mxLog("Comprobante de desembolso error: " + getError());
                }
            } else {
                setError(loCli.getError());
            }
        } else {
            setError(loCli.getError());
        }
        return llOk;
    }
    
    public boolean mxDesembolsoComprobante(Cliente p_oCliente) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/desembolsoComprobante_" + p_oCliente.getCodCli() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -30, -30, 70, 5);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTitulo = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 7, Font.BOLD,
                    BaseColor.BLACK);
            PdfPTable loTablaDatos = new PdfPTable(7);

            loTablaDatos.setWidths(new float[]{3, 1, 6, 5, 3, 1, 6});

            //Primera Tabla
            //Primera fila
            PdfPCell celda1T1 = new PdfPCell(new Phrase("FECHA", fontTitulo));
            celda1T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda2T1 = new PdfPCell(new Phrase(":", fontTitulo));
            celda2T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda3T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontTitulo));
            celda3T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda4T1 = new PdfPCell();
            celda4T1.setBorder(PdfPCell.NO_BORDER);
            celda4T1.setRowspan(8);
            PdfPCell celda5T1 = new PdfPCell(new Phrase("FECHA", fontTitulo));
            celda5T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda6T1 = new PdfPCell(new Phrase(":", fontTitulo));
            celda6T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda7T1 = new PdfPCell(new Phrase(LibFunc.getFechaActual(), fontTitulo));
            celda7T1.setBorder(PdfPCell.NO_BORDER);

            //Segundo fila
            PdfPCell celda8T1 = new PdfPCell(new Phrase("COMPROBANTE", fontContenido));
            celda8T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda9T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda9T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda10T1 = new PdfPCell(new Phrase("01 - 000534", fontContenido));
            celda10T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda11T1 = new PdfPCell(new Phrase("COMPROBANTE", fontContenido));
            celda11T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda12T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda12T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda13T1 = new PdfPCell(new Phrase("01 - 000534", fontContenido));
            celda13T1.setBorder(PdfPCell.NO_BORDER);
            
            //Tercera fila
            PdfPCell celda14T1 = new PdfPCell(new Phrase("CREDITO", fontContenido));
            celda14T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda15T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda15T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda16T1 = new PdfPCell(new Phrase("", fontContenido));
            celda16T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda17T1 = new PdfPCell(new Phrase("CREDITO", fontContenido));
            celda17T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda18T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda18T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda19T1 = new PdfPCell(new Phrase("", fontContenido));
            celda19T1.setBorder(PdfPCell.NO_BORDER);
            
            //Cuarta fila
            PdfPCell celda20T1 = new PdfPCell(new Phrase("CLIENTE", fontContenido));
            celda20T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda21T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda21T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda22T1 = new PdfPCell(new Phrase("", fontContenido));
            celda22T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda23T1 = new PdfPCell(new Phrase("CLIENTE", fontContenido));
            celda23T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda24T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda24T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda25T1 = new PdfPCell(new Phrase("", fontContenido));
            celda25T1.setBorder(PdfPCell.NO_BORDER);
            
            //Quinta fila
            PdfPCell celda26T1 = new PdfPCell(new Phrase("MONTO", fontContenido));
            celda26T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda27T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda27T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda28T1 = new PdfPCell(new Phrase("", fontContenido));
            celda28T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda29T1 = new PdfPCell(new Phrase("MONTO", fontContenido));
            celda29T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda30T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda30T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda31T1 = new PdfPCell(new Phrase("", fontContenido));
            celda31T1.setBorder(PdfPCell.NO_BORDER);
            
            //Sexta fila
            PdfPCell celda32T1 = new PdfPCell(new Phrase("CAJA/BANCOS", fontContenido));
            celda32T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda33T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda33T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda34T1 = new PdfPCell(new Phrase("", fontContenido));
            celda34T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda35T1 = new PdfPCell(new Phrase("CAJA/BANCOS", fontContenido));
            celda35T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda36T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda36T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda37T1 = new PdfPCell(new Phrase("", fontContenido));
            celda37T1.setBorder(PdfPCell.NO_BORDER);
            
            //Septima fila
            PdfPCell celda38T1 = new PdfPCell(new Phrase("NRO.TRX.", fontContenido));
            celda38T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda39T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda39T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda40T1 = new PdfPCell(new Phrase("", fontContenido));
            celda40T1.setBorder(PdfPCell.NO_BORDER);
            
            PdfPCell celda41T1 = new PdfPCell(new Phrase("NRO.TRX.", fontContenido));
            celda41T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda42T1 = new PdfPCell(new Phrase(":", fontContenido));
            celda42T1.setBorder(PdfPCell.NO_BORDER);
            PdfPCell celda43T1 = new PdfPCell(new Phrase("", fontContenido));
            celda43T1.setBorder(PdfPCell.NO_BORDER);
            
            //Octava fila
            PdfPCell celda44T1 = new PdfPCell(new Phrase("9999-002-18", fontContenido));
            celda44T1.setBorder(PdfPCell.NO_BORDER);
            celda44T1.setColspan(3);
            
            PdfPCell celda45T1 = new PdfPCell(new Phrase("9999-002-18", fontContenido));
            celda45T1.setBorder(PdfPCell.NO_BORDER);
            celda45T1.setColspan(3);
             
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
            loTablaDatos.addCell(celda27T1);
            loTablaDatos.addCell(celda28T1);
            loTablaDatos.addCell(celda29T1);
            loTablaDatos.addCell(celda30T1);
            loTablaDatos.addCell(celda31T1);
            loTablaDatos.addCell(celda32T1);
            loTablaDatos.addCell(celda33T1);
            loTablaDatos.addCell(celda34T1);
            loTablaDatos.addCell(celda35T1);
            loTablaDatos.addCell(celda36T1);
            loTablaDatos.addCell(celda37T1);
            loTablaDatos.addCell(celda38T1);
            loTablaDatos.addCell(celda39T1);
            loTablaDatos.addCell(celda40T1);
            loTablaDatos.addCell(celda41T1);
            loTablaDatos.addCell(celda42T1);
            loTablaDatos.addCell(celda43T1);
            loTablaDatos.addCell(celda44T1);
            loTablaDatos.addCell(celda45T1);
            
            loDoc.add(loTablaDatos);
            loDoc.close();

        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public String getPthFil() {
        return pthFil;
    }

    public void setPthFil(String pthFil) {
        this.pthFil = pthFil;
    }

    public String getRutaReporte() {
        return rutaReporte;
    }

    public void setRutaReporte(String rutaReporte) {
        this.rutaReporte = rutaReporte;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    
}
