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
import com.softia.models.Cliente;
import com.softia.models.Credito;
import com.softia.models.Departamento;
import com.softia.models.Direccion;
import com.softia.models.Distrito;
import com.softia.models.Provincia;
import com.softia.utils.LibFunc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author carlosgaldos
 */
public class CReporteXls {    
    private String pthFil;
    private String rutaReporte;
    private String error;

    public boolean mxGenerarReporteCarteraXls() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();

        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setCodCli("000001");
        loCre.getCliente().setNroDoc("72382128");
        loCre.getCliente().setNombre("RENZO");
        loCre.getCliente().setApePat("CUADROS");
        loCre.getCliente().setApeMat("ARENAS");
        //oficina - cnorref 
        loCre.setNomAna("BRENDA ORDONEZ");
        loCre.setCondic("VIGENTE");
        loCre.setMoneda("SOLES");
        loCre.setPriori("PRIORIDAD A");
        loCre.setCapSol(1000);
        loCre.setSalCap(1000);
        loCre.setCapPag(0);
        loCre.setCuotas(10);
        loCre.setFecCom(LibFunc.fxStrToDate("2018-01-01"));
        loCre.setFecPag(LibFunc.fxStrToDate("2018-01-05"));
        loCre.setTasa(79.5);
        loCre.setCosEfe(5.2);
        loCre.setInteres(500);
        loCre.setIntPag(0);
        loCre.setMorPag(0);
        loCre.setGasPag(25);
        loCre.setMonTot(1550);
        loCre.setMonPag(25);
        loCre.setTotPag(25);
        //ncapven
        // estado ppg - fechavig
        loCre.setDiaAtr(0);
        loCre.setCapAtr(0);
        loCre.setCuoAtr(1);
        loCre.setIntAtr(200);
        loCre.setMorAtr(32);
        loCre.setGasAtr(0);
        // plazo ccalint
        loCre.setCalifi("Normal");
        //especifica- provision pro
        loCre.setProvis(10);
        loCre.setProAce(0);
        loCre.setProduc("CRE - AHORRO");
        //interes devengado - interes suspenso - monto de garantia
        //interes moratorio - garantia -aval
        loCre.setCuenta("CREDITO AHORRO");
        //cuotas pagadas - atraso maximo - tipo de cambio - oficina - departamento - tipo de garantia -tipo de cliente
        loCre.getCliente().setCelular("992256487");
        loCre.getCliente().setDireccion(new Direccion());
        loCre.getCliente().getDireccion().setDireccion("LA DOLORES, TRADICION AREQUIPENIA");
        loCre.getCliente().getDireccion().setDistrito(new Distrito());
        loCre.getCliente().getDireccion().getDistrito().setNombre("JOSE LUIS BUSTAMANTE Y RIVERO");
        loCre.getCliente().getDireccion().getDistrito().setProvincia(new Provincia());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setNombre("AREQUIPA");
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().getDepartamento().setNombre("AREQUIPA");
        loCre.getCliente().getDireccion().setReferencia("CERCA DE ADEPA, PARALELA");
        lstCreditos.add(loCre);
        boolean llOk = mxCarteraXls(lstCreditos,"REPORTE - CARTERA DE CRÉDITOS");
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }

    public boolean mxCarteraXls(List<Credito> p_oCreditos, String titulo) throws FileNotFoundException, IOException {
        boolean llOk = true;
        HSSFWorkbook loWB = new HSSFWorkbook();
        HSSFSheet loSheet = loWB.createSheet("RECUPERACION");
        HSSFRow loRowHeadTitle = loSheet.createRow((short) 0);
        HSSFRow loRowHeadTitle1 = loSheet.createRow((short) 1);
        HSSFRow loRowHead = loSheet.createRow((short) 2);
        CellStyle style = loWB.createCellStyle();
        CellStyle style1 = loWB.createCellStyle();
        CellStyle stylehead = loWB.createCellStyle();
        //cabecera
        loRowHead.createCell((short) 0).setCellValue("Crédito");
        loRowHead.createCell((short) 1).setCellValue("Cod.Cliente");
        loRowHead.createCell((short) 2).setCellValue("Documento");
        loRowHead.createCell((short) 3).setCellValue("Nombre");
        loRowHead.createCell((short) 4).setCellValue("Apellido Paterno");
        loRowHead.createCell((short) 5).setCellValue("Apellido Materno");
        loRowHead.createCell((short) 6).setCellValue("Analista");
        loRowHead.createCell((short) 7).setCellValue("Condición");
        loRowHead.createCell((short) 8).setCellValue("Moneda");
        loRowHead.createCell((short) 9).setCellValue("Prioridad");
        loRowHead.createCell((short) 10).setCellValue("Cap.Solicitado");
        loRowHead.createCell((short) 11).setCellValue("Saldo Cap.");
        loRowHead.createCell((short) 12).setCellValue("Cap.Pagado");
        loRowHead.createCell((short) 13).setCellValue("Cuotas");
        loRowHead.createCell((short) 14).setCellValue("Compromiso");
        loRowHead.createCell((short) 15).setCellValue("Fecha de pago");
        loRowHead.createCell((short) 16).setCellValue("Tasa");
        loRowHead.createCell((short) 17).setCellValue("Costo efectivo");
        loRowHead.createCell((short) 18).setCellValue("Interes");
        loRowHead.createCell((short) 19).setCellValue("Interes Pag.");
        loRowHead.createCell((short) 20).setCellValue("Mora Pag.");
        loRowHead.createCell((short) 21).setCellValue("Gasto Pag.");
        loRowHead.createCell((short) 22).setCellValue("Monto total");
        loRowHead.createCell((short) 23).setCellValue("Monto Pag.");
        loRowHead.createCell((short) 24).setCellValue("Dias de Atraso");
        loRowHead.createCell((short) 25).setCellValue("Cap.Atrasado");
        loRowHead.createCell((short) 26).setCellValue("Cuota Atrasada");
        loRowHead.createCell((short) 27).setCellValue("Int.Atrasado");
        loRowHead.createCell((short) 28).setCellValue("Mora Atrasada");
        loRowHead.createCell((short) 29).setCellValue("Gasto Atrasado");
        loRowHead.createCell((short) 30).setCellValue("Calificación");
        loRowHead.createCell((short) 31).setCellValue("Provisión");
        loRowHead.createCell((short) 32).setCellValue("Provision Acelerada");
        loRowHead.createCell((short) 33).setCellValue("Producto");
        loRowHead.createCell((short) 34).setCellValue("Cuenta");
        loRowHead.createCell((short) 35).setCellValue("Celular");
        loRowHead.createCell((short) 36).setCellValue("Direccion");
        loRowHead.createCell((short) 37).setCellValue("Distrito");
        loRowHead.createCell((short) 38).setCellValue("Provincia");
        loRowHead.createCell((short) 39).setCellValue("Departamento");
        loRowHead.createCell((short) 40).setCellValue("Referencia");
        //ESTILO
        HSSFFont font = loWB.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        style1.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setFont(font);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylehead.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        stylehead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
	style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        stylehead.setBorderBottom(BorderStyle.THIN);
	stylehead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        for (int j=0; j<= 40; j++){
            loRowHeadTitle1.createCell((short) j).setCellStyle(style);
            loRowHeadTitle.createCell((short) j).setCellStyle(style1);
            loRowHead.getCell(j).setCellStyle(stylehead);
        }
        //FIN ESTILO
        loRowHeadTitle1.getCell(0).setCellValue("FECHA:");
        loRowHeadTitle1.getCell(1).setCellValue(LibFunc.getFechaActual());
        loRowHeadTitle.getCell(10).setCellValue(titulo);
        //cuerpo
        int index = 3;
        for (Credito loCredito : p_oCreditos) {
            HSSFRow loRow = loSheet.createRow((short) index);
            loRow.createCell((short) 0).setCellValue(loCredito.getCodCta());
            loRow.createCell((short) 1).setCellValue(loCredito.getCliente().getCodCli());
            loRow.createCell((short) 2).setCellValue(loCredito.getCliente().getNroDoc());
            loRow.createCell((short) 3).setCellValue(loCredito.getCliente().getNombre());
            loRow.createCell((short) 4).setCellValue(loCredito.getCliente().getApePat());
            loRow.createCell((short) 5).setCellValue(loCredito.getCliente().getApeMat());
            loRow.createCell((short) 6).setCellValue(loCredito.getNomAna());
            loRow.createCell((short) 7).setCellValue(loCredito.getCondic());
            loRow.createCell((short) 8).setCellValue(loCredito.getMoneda());
            loRow.createCell((short) 9).setCellValue(loCredito.getPriori());
            loRow.createCell((short) 10).setCellValue(loCredito.getCapSol());
            loRow.createCell((short) 11).setCellValue(loCredito.getSalCap());
            loRow.createCell((short) 12).setCellValue(loCredito.getCapPag());
            loRow.createCell((short) 13).setCellValue(loCredito.getCuotas());
            loRow.createCell((short) 14).setCellValue(loCredito.getFecCom());
            loRow.createCell((short) 15).setCellValue(loCredito.getFecPag());
            loRow.createCell((short) 16).setCellValue(loCredito.getTasa());
            loRow.createCell((short) 17).setCellValue(loCredito.getCosEfe());
            loRow.createCell((short) 18).setCellValue(loCredito.getInteres());
            loRow.createCell((short) 19).setCellValue(loCredito.getIntPag());
            loRow.createCell((short) 20).setCellValue(loCredito.getMorPag());
            loRow.createCell((short) 21).setCellValue(loCredito.getGasPag());
            loRow.createCell((short) 22).setCellValue(loCredito.getMonTot());
            loRow.createCell((short) 23).setCellValue(loCredito.getMonPag());
            loRow.createCell((short) 24).setCellValue(loCredito.getDiaAtr());
            loRow.createCell((short) 25).setCellValue(loCredito.getCapAtr());
            loRow.createCell((short) 26).setCellValue(loCredito.getCuoAtr());
            loRow.createCell((short) 27).setCellValue(loCredito.getIntAtr());
            loRow.createCell((short) 28).setCellValue(loCredito.getMorAtr());
            loRow.createCell((short) 29).setCellValue(loCredito.getGasAtr());
            loRow.createCell((short) 30).setCellValue(loCredito.getCalifi());
            loRow.createCell((short) 31).setCellValue(loCredito.getProvis());
            loRow.createCell((short) 32).setCellValue(loCredito.getProAce());
            loRow.createCell((short) 33).setCellValue(loCredito.getProduc());
            loRow.createCell((short) 34).setCellValue(loCredito.getCuenta());
            loRow.createCell((short) 35).setCellValue(loCredito.getCliente().getCelular());
            loRow.createCell((short) 36).setCellValue(loCredito.getCliente().getDireccion().getDireccion());
            loRow.createCell((short) 37).setCellValue(loCredito.getCliente().getDireccion().getDistrito().getNombre());
            loRow.createCell((short) 38).setCellValue(loCredito.getCliente().getDireccion().getDistrito().getProvincia().getNombre());
            loRow.createCell((short) 39).setCellValue(loCredito.getCliente().getDireccion().getDistrito().getProvincia().getDepartamento().getNombre());
            loRow.createCell((short) 40).setCellValue(loCredito.getCliente().getDireccion().getReferencia());
            index++;
        }
        setRutaReporte("/ftia/files/cierres/CARTERA_" + LibFunc.getFechaActual() + ".xls");
        try (FileOutputStream fileOut = new FileOutputStream(getRutaReporte())) {
            loWB.write(fileOut);
        }
        return llOk;
    }
    //REPORTE MORA
    public boolean mxGenerarReporteMoraXls() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        
        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setCodCli("000001");
        loCre.getCliente().setNombre("RENZO");
        loCre.getCliente().setApePat("CUADROS");
        loCre.getCliente().setApeMat("ARENAS");

        //oficina - cnorref 
        loCre.setNomAna("BRENDA ORDONEZ");
        loCre.setCondic("VIGENTE");
        loCre.setMoneda("SOLES");
        loCre.setPriori("PRIORIDAD A");
        loCre.setCapSol(1000);
        loCre.setSalCap(1000);
        loCre.setCapPag(0);
        loCre.setCuotas(10);
        loCre.setFecCom(LibFunc.fxStrToDate("2018-01-01"));
        loCre.setFecPag(LibFunc.fxStrToDate("2018-01-05"));
        loCre.setTasa(79.5);
        loCre.setCosEfe(5.2);
        loCre.setInteres(500);
        loCre.setIntPag(0);
        loCre.setMorPag(0);
        loCre.setGasPag(25);
        loCre.setMonTot(1550);
        loCre.setMonPag(25);
        loCre.setTotPag(25);
        //ncapven
        // estado ppg - fechavig
        loCre.setDiaAtr(0);
        loCre.setCapAtr(0);
        loCre.setCuoAtr(1);
        loCre.setIntAtr(200);
        loCre.setMorAtr(32);
        loCre.setGasAtr(0);
        // plazo ccalint
        loCre.setCalifi("Normal");
        //especifica- provision pro
        loCre.setProvis(10);
        loCre.setProAce(0);
        loCre.setProduc("CRE - AHORRO");
        //interes devengado - interes suspenso - monto de garantia
        //interes moratorio - garantia -aval
        loCre.setCuenta("CREDITO AHORRO");
        //cuotas pagadas - atraso maximo - tipo de cambio - oficina - departamento - tipo de garantia -tipo de cliente
        loCre.getCliente().setCelular("992256487");
        loCre.getCliente().setDireccion(new Direccion());
        loCre.getCliente().getDireccion().setDireccion("LA DOLORES, TRADICION AREQUIPENIA");
        loCre.getCliente().getDireccion().setDistrito(new Distrito());
        loCre.getCliente().getDireccion().getDistrito().setNombre("JOSE LUIS BUSTAMANTE Y RIVERO");
        loCre.getCliente().getDireccion().getDistrito().setProvincia(new Provincia());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setNombre("AREQUIPA");
        loCre.getCliente().getDireccion().getDistrito().getProvincia().setDepartamento(new Departamento());
        loCre.getCliente().getDireccion().getDistrito().getProvincia().getDepartamento().setNombre("AREQUIPA");
        loCre.getCliente().getDireccion().setReferencia("CERCA DE ADEPA, PARALELA");
        lstCreditos.add(loCre);
        boolean llOk = mxCarteraXls(lstCreditos,"REPORTE - CARTERA DE CRÉDITOS EN MORA");
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }

    public boolean mxgenerarOPEDesembolsoXLS() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        
        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setCodCli("000001");
        loCre.getCliente().setNombre("RENZO");
        loCre.getCliente().setApePat("CUADROS");
        loCre.getCliente().setApeMat("ARENAS");
        loCre.setCapSol(1000);
        loCre.setMoneda("SOLES");
        //forma desembolso: efectivo, no efectivo, cheque N°..
        loCre.setTasa(79.5);
        loCre.setNomAna("BRENDA ORDONEZ");        
        
        lstCreditos.add(loCre);
        boolean llOk = mxOPEDesembolsoXls(lstCreditos);
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }
    public boolean mxOPEDesembolsoXls(List<Credito> p_oCreditos) throws FileNotFoundException, IOException {
        boolean llOk = true;
        HSSFWorkbook loWB = new HSSFWorkbook();
        HSSFSheet loSheet = loWB.createSheet("RECUPERACION");
        HSSFRow loRowHeadTitle = loSheet.createRow((short) 0);
        HSSFRow loRowHeadlineaA = loSheet.createRow((short) 1);
        HSSFRow loRowHeadlineaB = loSheet.createRow((short) 2);
        HSSFRow loRowHead = loSheet.createRow((short) 3);
        CellStyle styleTitle = loWB.createCellStyle();
        CellStyle stylehead = loWB.createCellStyle();
        CellStyle styleRowhead = loWB.createCellStyle();
        //cabecera
        loRowHead.createCell((short) 0).setCellValue("Fecha");
        loRowHead.createCell((short) 1).setCellValue("Crédito");
        loRowHead.createCell((short) 2).setCellValue("Cod.Cliente");
        loRowHead.createCell((short) 3).setCellValue("Nombre");
        loRowHead.createCell((short) 4).setCellValue("Desembolso");
        loRowHead.createCell((short) 5).setCellValue("Moneda");
        loRowHead.createCell((short) 6).setCellValue("Tipo");
        loRowHead.createCell((short) 7).setCellValue("TEA");
        loRowHead.createCell((short) 8).setCellValue("Analista");
        //cuerpo
        int index = 4;
        for (Credito loCredito : p_oCreditos) {
            HSSFRow loRow = loSheet.createRow((short) index);
            loRow.createCell((short) 0).setCellValue("2018-08-08");
            loRow.createCell((short) 1).setCellValue(loCredito.getCodCta());
            loRow.createCell((short) 2).setCellValue(loCredito.getCliente().getCodCli());
            loRow.createCell((short) 3).setCellValue(loCredito.getCliente().getNomCom());
            loRow.createCell((short) 4).setCellValue(loCredito.getCapSol());
            loRow.createCell((short) 5).setCellValue(loCredito.getMoneda());
            loRow.createCell((short) 6).setCellValue("CHEQUE N°00001");
            loRow.createCell((short) 7).setCellValue(loCredito.getTasa());
            loRow.createCell((short) 8).setCellValue(loCredito.getNomAna());
            index++;
        }
        //ESTILO
        HSSFFont fontTitle = loWB.createFont();
        fontTitle.setColor(IndexedColors.WHITE.getIndex());
        styleTitle.setFont(fontTitle);
        stylehead.setFont(fontTitle);
        styleTitle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        styleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylehead.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        stylehead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        styleRowhead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setBorderBottom(BorderStyle.THIN);
	styleRowhead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        stylehead.setBorderBottom(BorderStyle.THIN);
	stylehead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        for (int j=0; j<= 8; j++){
            loRowHeadTitle.createCell((short) j).setCellStyle(styleTitle);
            loRowHeadlineaA.createCell((short) j).setCellStyle(stylehead);
            loRowHeadlineaB.createCell((short) j).setCellStyle(stylehead);
            loRowHead.getCell(j).setCellStyle(styleRowhead);
        }
        //FIN ESTILO
        loRowHeadlineaA.getCell(0).setCellValue("FECHA:");
        loRowHeadlineaA.getCell(1).setCellValue(LibFunc.getFechaActual());
        loRowHeadlineaB.getCell(0).setCellValue("Nro.Operaciones:");
        loRowHeadlineaB.getCell(1).setCellValue(1);
        loRowHeadlineaB.getCell(3).setCellValue("Monto Total:");
        loRowHeadlineaB.getCell(4).setCellValue(1000);
        loRowHeadTitle.getCell(2).setCellValue("REPORTE OPERACIONES - DESEMBOLSOS");
        setRutaReporte("/ftia/files/cierres/OPE_DES_" + LibFunc.getFechaActual() + ".xls");
        try (FileOutputStream fileOut = new FileOutputStream(getRutaReporte())) {
            loWB.write(fileOut);
        }
        return llOk;
    }
    
    public boolean mxgenerarOPEPagoXLS() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        //fecha
        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setCodCli("000001");
        loCre.getCliente().setNombre("RENZO");
        loCre.getCliente().setApePat("CUADROS");
        loCre.getCliente().setApeMat("ARENAS");
        //nro de documento
        loCre.setCapPag(500);
        loCre.setIntPag(250);
        loCre.setMorPag(0);
        loCre.setGasPag(0);
        loCre.setMonPag(750);
        loCre.setMoneda("SOLES");
        //forma de pago: efectivo, no efectivo, cheque N°..
        
        lstCreditos.add(loCre);
        boolean llOk = mxOPEPagoXls(lstCreditos);
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }
    public boolean mxOPEPagoXls(List<Credito> p_oCreditos) throws FileNotFoundException, IOException {
        boolean llOk = true;
        HSSFWorkbook loWB = new HSSFWorkbook();
        HSSFSheet loSheet = loWB.createSheet("RECUPERACION");
        HSSFRow loRowHeadTitle = loSheet.createRow((short) 0);
        HSSFRow loRowHeadlineaA = loSheet.createRow((short) 1);
        HSSFRow loRowHeadlineaB = loSheet.createRow((short) 2);
        HSSFRow loRowHead = loSheet.createRow((short) 3);
        CellStyle styleTitle = loWB.createCellStyle();
        CellStyle stylehead = loWB.createCellStyle();
        CellStyle styleRowhead = loWB.createCellStyle();
        //cabecera
        loRowHead.createCell((short) 0).setCellValue("Fecha");
        loRowHead.createCell((short) 1).setCellValue("Crédito");
        loRowHead.createCell((short) 2).setCellValue("Cod.Cliente");
        loRowHead.createCell((short) 3).setCellValue("Nombre");
        loRowHead.createCell((short) 4).setCellValue("Documento");
        loRowHead.createCell((short) 5).setCellValue("Capital");
        loRowHead.createCell((short) 6).setCellValue("Interes");
        loRowHead.createCell((short) 7).setCellValue("Mora");
        loRowHead.createCell((short) 8).setCellValue("Otros Gastos");
        loRowHead.createCell((short) 9).setCellValue("Monto Total");
        loRowHead.createCell((short) 10).setCellValue("Moneda");
        loRowHead.createCell((short) 11).setCellValue("Forma");
        //cuerpo
        int index = 4;
        for (Credito loCredito : p_oCreditos) {
            HSSFRow loRow = loSheet.createRow((short) index);
            loRow.createCell((short) 0).setCellValue("2018-08-08");
            loRow.createCell((short) 1).setCellValue(loCredito.getCodCta());
            loRow.createCell((short) 2).setCellValue(loCredito.getCliente().getCodCli());
            loRow.createCell((short) 3).setCellValue(loCredito.getCliente().getNomCom());
            loRow.createCell((short) 4).setCellValue("COB00001");
            loRow.createCell((short) 5).setCellValue(loCredito.getCapPag());
            loRow.createCell((short) 6).setCellValue(loCredito.getIntPag());
            loRow.createCell((short) 7).setCellValue(loCredito.getMorPag());
            loRow.createCell((short) 8).setCellValue(loCredito.getGasPag());
            loRow.createCell((short) 9).setCellValue(loCredito.getMonPag());
            loRow.createCell((short) 10).setCellValue(loCredito.getMoneda());
            loRow.createCell((short) 11).setCellValue("EFECTIVO");
            index++;
        }
        //ESTILO
        HSSFFont fontTitle = loWB.createFont();
        fontTitle.setColor(IndexedColors.WHITE.getIndex());
        styleTitle.setFont(fontTitle);
        stylehead.setFont(fontTitle);
        styleTitle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        styleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylehead.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        stylehead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        styleRowhead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setBorderBottom(BorderStyle.THIN);
	styleRowhead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        stylehead.setBorderBottom(BorderStyle.THIN);
	stylehead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        for (int j=0; j<= 11; j++){
            loRowHeadTitle.createCell((short) j).setCellStyle(styleTitle);
            loRowHeadlineaA.createCell((short) j).setCellStyle(stylehead);
            loRowHeadlineaB.createCell((short) j).setCellStyle(stylehead);
            loRowHead.getCell(j).setCellStyle(styleRowhead);
        }
        //FIN ESTILO
        loRowHeadlineaA.getCell(0).setCellValue("FECHA:");
        loRowHeadlineaA.getCell(1).setCellValue(LibFunc.getFechaActual());
        loRowHeadlineaB.getCell(0).setCellValue("Nro.Operaciones:");
        loRowHeadlineaB.getCell(1).setCellValue(1);
        loRowHeadlineaB.getCell(3).setCellValue("Monto Ingreso Efectivo:");
        loRowHeadlineaB.getCell(4).setCellValue(750);
        loRowHeadlineaB.getCell(6).setCellValue("Monto Ingreso No-Efectivo:");
        loRowHeadlineaB.getCell(7).setCellValue(0);
        loRowHeadTitle.getCell(2).setCellValue("REPORTE OPERACIONES - PAGOS");
        setRutaReporte("/ftia/files/cierres/OPE_DES_" + LibFunc.getFechaActual() + ".xls");
        try (FileOutputStream fileOut = new FileOutputStream(getRutaReporte())) {
            loWB.write(fileOut);
        }
        return llOk;
    }
    
    public boolean mxgenerarSolicitudXLS() throws SQLException, IOException, ParseException {
        List<Credito> lstCreditos = new ArrayList<>();
        Credito loCre = new Credito();
        //fecha
        loCre.setCodCta("1234567890");
        loCre.setCliente(new Cliente());
        loCre.getCliente().setCodCli("000001");
        loCre.getCliente().setNombre("RENZO");
        loCre.getCliente().setApePat("CUADROS");
        loCre.getCliente().setApeMat("ARENAS");
        loCre.setCapSol(15000);
        loCre.setMoneda("SOLES");
        loCre.setTasa(79.5);
        loCre.setFecCom(LibFunc.fxStrToDate("2018-01-01"));
        loCre.setNomAna("BRENDA ORDOÑEZ LUJAN");

        lstCreditos.add(loCre);
        boolean llOk = mxSolicitudXls(lstCreditos);
        if (llOk) {
            LibFunc.mxLog("REPORTE XLS OK.");
        } else {
            LibFunc.mxLog("REPORTE XLS error: " + getError());
        }
        return llOk;
    }
    public boolean mxSolicitudXls(List<Credito> p_oCreditos) throws FileNotFoundException, IOException {
        boolean llOk = true;
        HSSFWorkbook loWB = new HSSFWorkbook();
        HSSFSheet loSheet = loWB.createSheet("RECUPERACION");
        HSSFRow loRowHeadTitle = loSheet.createRow((short) 0);
        HSSFRow loRowHeadlineaA = loSheet.createRow((short) 1);
        HSSFRow loRowHeadlineaB = loSheet.createRow((short) 2);
        HSSFRow loRowHead = loSheet.createRow((short) 3);
        CellStyle styleTitle = loWB.createCellStyle();
        CellStyle stylehead = loWB.createCellStyle();
        CellStyle styleRowhead = loWB.createCellStyle();
        //cabecera
        loRowHead.createCell((short) 0).setCellValue("Fecha");
        loRowHead.createCell((short) 1).setCellValue("Crédito");
        loRowHead.createCell((short) 2).setCellValue("Cod.Cliente");
        loRowHead.createCell((short) 3).setCellValue("Nombre");
        loRowHead.createCell((short) 4).setCellValue("M.Desembolso");
        loRowHead.createCell((short) 5).setCellValue("Moneda");
        loRowHead.createCell((short) 6).setCellValue("TEA");
        loRowHead.createCell((short) 7).setCellValue("Fecha desembolso");
        loRowHead.createCell((short) 8).setCellValue("Analista");
        //cuerpo
        int index = 4;
        for (Credito loCredito : p_oCreditos) {
            HSSFRow loRow = loSheet.createRow((short) index);
            loRow.createCell((short) 0).setCellValue("2018-08-08");
            loRow.createCell((short) 1).setCellValue(loCredito.getCodCta());
            loRow.createCell((short) 2).setCellValue(loCredito.getCliente().getCodCli());
            loRow.createCell((short) 3).setCellValue(loCredito.getCliente().getNomCom());
            loRow.createCell((short) 4).setCellValue(loCredito.getCapSol());
            loRow.createCell((short) 5).setCellValue(loCredito.getMoneda());
            loRow.createCell((short) 6).setCellValue(loCredito.getTasa());
            loRow.createCell((short) 7).setCellValue(loCredito.getFecCom());
            loRow.createCell((short) 8).setCellValue(loCredito.getNomAna());
            index++;
        }
        //ESTILO
        HSSFFont fontTitle = loWB.createFont();
        fontTitle.setColor(IndexedColors.WHITE.getIndex());
        styleTitle.setFont(fontTitle);
        stylehead.setFont(fontTitle);
        styleTitle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        styleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylehead.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        stylehead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        styleRowhead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleRowhead.setBorderBottom(BorderStyle.THIN);
	styleRowhead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        stylehead.setBorderBottom(BorderStyle.THIN);
	stylehead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        for (int j=0; j<= 8; j++){
            loRowHeadTitle.createCell((short) j).setCellStyle(styleTitle);
            loRowHeadlineaA.createCell((short) j).setCellStyle(stylehead);
            loRowHeadlineaB.createCell((short) j).setCellStyle(stylehead);
            loRowHead.getCell(j).setCellStyle(styleRowhead);
        }
        //FIN ESTILO
        loRowHeadlineaA.getCell(0).setCellValue("FECHA:");
        loRowHeadlineaA.getCell(1).setCellValue(LibFunc.getFechaActual());
        loRowHeadlineaB.getCell(0).setCellValue("Nro.Operaciones:");
        loRowHeadlineaB.getCell(1).setCellValue(1);
        loRowHeadlineaB.getCell(3).setCellValue("Monto Total:");
        loRowHeadlineaB.getCell(4).setCellValue(15000);
        loRowHeadTitle.getCell(2).setCellValue("REPORTE OPERACIONES - SOLICITUDES");
        setRutaReporte("/ftia/files/cierres/OPE_SOL_" + LibFunc.getFechaActual() + ".xls");
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
