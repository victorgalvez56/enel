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
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.softia.models.Cliente;
import com.softia.models.Credito;
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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author carlosgaldos
 */
public class CReporte {

    private String pthFil;
    private String rutaReporte;
    private String error;
    
    public boolean evFinanciera() throws IOException {
        List<Cliente> lstClientes = new ArrayList<>();
        Cliente loCli = new Cliente();
        loCli.setNombre("Roberto");
        lstClientes.add(loCli);
        boolean llOk = evFinancieraGE(lstClientes);
        if (llOk) {
            setRutaReporte("/ftia/files/cartas/PRUEBAcliente_" + LibFunc.getFechaActual() + ".pdf");
            LibFunc.mxLog("PRUEBA OK.");
        } else {
            LibFunc.mxLog("PRUEBA error: " + getError());
        }
        return llOk;
    }
    
    public boolean evFinancieraGE(List<Cliente> p_oCreditos) {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/PRUEBAcliente_" + LibFunc.getFechaActual() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -20, -20, 50, 50);
            PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 9, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 11, Font.BOLD,
                    BaseColor.BLACK);
            Font fontSubrayado = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 11, Font.UNDERLINE,
                    BaseColor.BLACK);
            
            Paragraph loTitulo = new Paragraph();
            PdfPTable loTable = new PdfPTable(2);
            loTitulo.add(new Paragraph("SOLICITUD DE EVALUACIÓN FINANCIERA", fontTitulos));
            loTitulo.setAlignment(Element.ALIGN_CENTER);
            
            PdfPCell celda1 = new PdfPCell(new Phrase("Código o Nombres y Apellidos del Afiliador", fontContenido));
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            loTable.addCell(celda1);
            PdfPCell celda2 = new PdfPCell(new Phrase("Fecha Solicitud", fontContenido));
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            loTable.addCell(celda2);
            
            loDoc.add(loTitulo);
            loDoc.add(loTable);
            loDoc.close();
            
        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public boolean mxGenerarReporte() throws IOException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        loCre.setCodCta("11234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setNombre("AAA");
        loCre.getCliente().setApePat("BBB");
        loCre.getCliente().setApeMat("CCC");
        loCre.getCliente().setDireccion(new Direccion());
        loCre.getCliente().getDireccion().setDireccion("SU CASA");
        loCre.getCliente().getDireccion().setDistrito(new Distrito());
        loCre.getCliente().getDireccion().getDistrito().setNombre("AQP");
        loCre.getCliente().getDireccion().getDistrito().setProvincia(new Provincia());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setNombre("AQP");
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().getDepartamento().setNombre("AQP");
        loCre.setSalCap(1000);
        loCre.setDiaAtr(10);
        loCre.setMoneda("SOLES");
        lstCreditos.add(loCre);
        boolean llOk = mxArchivo(lstCreditos);
        if (llOk) {
            setRutaReporte("/ftia/files/cartas/PRUEBA_" + LibFunc.getFechaActual() + ".pdf");
            LibFunc.mxLog("PRUEBA OK.");
        } else {
            LibFunc.mxLog("PRUEBA error: " + getError());
        }
        return llOk;
    }

    public boolean mxGenerarReporteXls() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setNombre("AAA");
        loCre.getCliente().setApePat("BBB");
        loCre.getCliente().setApeMat("CCC");
        loCre.setSalCap(1000);
        loCre.setDiaAtr(20);
        loCre.setMoneda("SOLES");
        loCre.setFecCom(LibFunc.fxStrToDate("2018-01-01"));
        loCre.setFecPag(LibFunc.fxStrToDate("2018-01-05"));
        loCre.setCapPag(200);
        loCre.setIntPag(100);
        loCre.setMorPag(50);
        loCre.setGasPag(25);
        lstCreditos.add(loCre);
        boolean llOk = mxArchivoXls(lstCreditos);
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }

    public boolean mxArchivo(List<Credito> p_oCreditos) {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/PRUEBA_" + LibFunc.getFechaActual() + ".pdf");
            Document loDoc = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 11, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 11, Font.BOLD,
                    BaseColor.BLACK);
            Font fontSubrayado = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 11, Font.UNDERLINE,
                    BaseColor.BLACK);
            for (Credito loCredito : p_oCreditos) {
                Paragraph loTitulo = new Paragraph();
                if (loCredito.getDiaAtr() > 360) {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA - MODELO 5", fontTitulos));
                } else if (loCredito.getDiaAtr() > 180) {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA - MODELO 5", fontTitulos));
                } else if (loCredito.getDiaAtr() > 90) {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA - MODELO 3", fontTitulos));
                } else if (loCredito.getDiaAtr() > 45) {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA - MODELO 2", fontTitulos));
                } else if (loCredito.getDiaAtr() > 30) {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA - MODELO 1", fontTitulos));
                } else {
                    loTitulo.add(new Phrase("CARTA DE COBRANZA", fontTitulos));
                }
                loTitulo.setAlignment(Element.ALIGN_CENTER);
                loDoc.add(loTitulo);
                Paragraph loParrafo = new Paragraph();
                loParrafo.setAlignment(Element.ALIGN_JUSTIFIED);
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loParrafo.add(new Phrase("Crédito: " + loCredito.getCodCta(), fontContenido));
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loParrafo.add(new Phrase("Nombre: " + loCredito.getCliente().getNomCom(), fontContenido));
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loParrafo.add(new Phrase("Dirección: " + loCredito.getCliente().getDireccion().getDireccion().trim()
                        + " " + loCredito.getCliente().getDireccion().getDistrito().getNombre().trim()
                        + " " + loCredito.getCliente().getDireccion().getDistrito().getProvincia().getNombre().trim()
                        + " " + loCredito.getCliente().getDireccion().getDistrito().getProvincia().getDepartamento().getNombre().trim(),
                        fontContenido));
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loParrafo.add(new Phrase("Saldo: " + loCredito.getSalCap() + " " + loCredito.getMoneda(), fontContenido));
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loParrafo.add(new Phrase("Atraso: " + loCredito.getDiaAtr(), fontContenido));
                loParrafo.add(new Phrase(Chunk.NEWLINE));
                loDoc.add(loParrafo);
                loDoc.newPage();
            }
            loDoc.close();
        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }

    public boolean mxArchivoXls(List<Credito> p_oCreditos) throws FileNotFoundException, IOException {
        boolean llOk = true;
        HSSFWorkbook loWB = new HSSFWorkbook();
        HSSFSheet loSheet = loWB.createSheet("RECUPERACION");
        HSSFRow loRowHead = loSheet.createRow((short) 0);
        loRowHead.createCell((short) 0).setCellValue("Crédito");
        loRowHead.createCell((short) 1).setCellValue("Nombre");
        loRowHead.createCell((short) 2).setCellValue("Saldo");
        loRowHead.createCell((short) 3).setCellValue("Moneda");
        loRowHead.createCell((short) 4).setCellValue("Atraso");
        loRowHead.createCell((short) 5).setCellValue("Compromiso");
        loRowHead.createCell((short) 6).setCellValue("Pago");
        loRowHead.createCell((short) 7).setCellValue("Capital");
        loRowHead.createCell((short) 8).setCellValue("Interes");
        loRowHead.createCell((short) 9).setCellValue("Mora");
        loRowHead.createCell((short) 10).setCellValue("Gastos");
        int index = 1;
        for (Credito loCredito : p_oCreditos) {
            HSSFRow loRow = loSheet.createRow((short) index);
            loRow.createCell((short) 0).setCellValue(loCredito.getCodCta());
            loRow.createCell((short) 1).setCellValue(loCredito.getCliente().getNomCom());
            loRow.createCell((short) 2).setCellValue(loCredito.getSalCap());
            loRow.createCell((short) 3).setCellValue(loCredito.getMoneda());
            loRow.createCell((short) 4).setCellValue(loCredito.getDiaAtr());
            loRow.createCell((short) 5).setCellValue(loCredito.getFecCom());
            loRow.createCell((short) 6).setCellValue(loCredito.getFecPag());
            loRow.createCell((short) 7).setCellValue(loCredito.getCapPag());
            loRow.createCell((short) 8).setCellValue(loCredito.getIntPag());
            loRow.createCell((short) 9).setCellValue(loCredito.getMorPag());
            loRow.createCell((short) 10).setCellValue(loCredito.getGasPag());
            index++;
        }
        setRutaReporte("/ftia/files/cierres/PRUEBA_" + LibFunc.getFechaActual() + ".xls");
        try (FileOutputStream fileOut = new FileOutputStream(getRutaReporte())) {
            loWB.write(fileOut);
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

}
