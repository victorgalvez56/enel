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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
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
    
    public static final String IMG = "/enelLOGO.png";
    
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
    
    public boolean evFinancieraGE(List<Cliente> p_oCreditos) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/PRUEBAcliente_" + LibFunc.getFechaActual() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -20, -20, 15, 50);
            PdfWriter writer = PdfWriter.getInstance(loDoc, loArchivo);
            loDoc.open();
            Font fontContenido = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 9, Font.NORMAL,
                    BaseColor.BLACK);
            Font fontTitulos = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 12, Font.BOLD,
                    BaseColor.BLACK);
            Font fontSubTitulos = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 10, Font.NORMAL,
                    BaseColor.WHITE);
            Font fontTextos = FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 10, Font.NORMAL,
                    BaseColor.BLACK);
            
            Paragraph loTitulo = new Paragraph();
            Paragraph loEncabezado = new Paragraph();
            Paragraph loCuerpo = new Paragraph();
            PdfPTable loEncabTabla = new PdfPTable(2);
            PdfPTable loTableCuerpo = new PdfPTable(4);
            Paragraph loTexto = new Paragraph();
            
            Image logo = Image.getInstance(IMG);
            logo.scaleToFit(110, 35);
            logo.setAlignment(Element.ALIGN_CENTER);
            
            //Titulo
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            loTitulo.add(new Paragraph("SOLICITUD DE EVALUACIÓN FINANCIERA", fontTitulos));
            loTitulo.setAlignment(Element.ALIGN_CENTER);
            loTitulo.add(new Phrase(Chunk.NEWLINE));
            
            //Encabezado
            PdfPCell celda1 = new PdfPCell(new Phrase("Código o Nombres y Apellidos del Afiliador", fontContenido));
            celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
            loEncabTabla.addCell(celda1);
            PdfPCell celda2 = new PdfPCell(new Phrase("Fecha Solicitud", fontContenido));
            celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
            loEncabTabla.addCell(celda2);
            loEncabezado.add(loEncabTabla);
            loEncabezado.add(new Phrase(Chunk.NEWLINE));
            
            //Cuerpo de Tabla principal
            PdfPCell celdaCuerpo1 = new PdfPCell(new Phrase("I. DATOS DEL SOLICITANTE (TITULAR DEL SUMINISTRO)", fontSubTitulos));
            celdaCuerpo1.setColspan(4);
            celdaCuerpo1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaCuerpo1.setBackgroundColor(WebColors.getRGBColor("#FF0066"));
            loTableCuerpo.addCell(celdaCuerpo1);
            
            PdfPCell celdaC1 = new PdfPCell(new Phrase("Número Suministro", fontContenido));
            celdaC1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC2 = new PdfPCell(new Phrase("Apellido Paterno", fontContenido));
            celdaC2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC3 = new PdfPCell(new Phrase("Apellido Materno", fontContenido));
            celdaC3.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC4 = new PdfPCell(new Phrase("Nombres", fontContenido));
            celdaC4.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC5 = new PdfPCell(new Phrase("Sexo", fontContenido));
            celdaC5.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC6 = new PdfPCell(new Phrase("Fecha de Nacimiento", fontContenido));
            celdaC6.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC7 = new PdfPCell(new Phrase("Tipo de Documento de Identidad", fontContenido));
            celdaC7.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC8 = new PdfPCell(new Phrase("Número de Documento de Identidad", fontContenido));
            celdaC8.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell celdaC9 = new PdfPCell(new Phrase("Teléfono Fijo", fontContenido));
            celdaC9.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC10 = new PdfPCell(new Phrase("Teléfono Celular", fontContenido));
            celdaC10.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC11 = new PdfPCell(new Phrase("Correo Electrónico", fontContenido));
            celdaC11.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC11.setColspan(2);
            
            PdfPCell celdaC12 = new PdfPCell(new Phrase("Dirección", fontContenido));
            celdaC12.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC12.setColspan(2);
            PdfPCell celdaC13 = new PdfPCell(new Phrase("Número", fontContenido));
            celdaC13.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celdaC14 = new PdfPCell(new Phrase("Urbanización", fontContenido));
            celdaC14.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell celdaC15 = new PdfPCell(new Phrase("Distrito", fontContenido));
            celdaC15.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC15.setColspan(2);
            PdfPCell celdaC16 = new PdfPCell(new Phrase("Provincia", fontContenido));
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
            loTexto.setSpacingAfter(25);
            loTexto.setSpacingBefore(25);
            loTexto.setIndentationLeft(63);
            loTexto.setIndentationRight(63);
            loTexto.add(new Phrase("Declaro bajo juramento que la información proporcionada en la presente solicitud, así como toda aquella documentación adjunta es verídica, por lo que autorizo expresamente a ENEL DISTRIBUCIÓN PERÚ, en adelante ENEL DISTRIBUCIÓN, a verificar toda la información señalada en el presente documento y me hago responsable de cualquier daño o perjuicio derivado que la inexactitud de la información proporcionada pudiera causar a ENEL DISTRIBUCIÓN o a terceros.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("Asimismo, de acuerdo a la ley Nº 29733 Ley de Protección de Datos Personales, brindo mi conformidad y autorizo expresamente a ENEL DISTRIBUCIÓN para que recopile mis datos personales con la finalidad de incorporarlos en su banco de datos así como utilizarlos para gestionar la información del financiamiento de productos, realizar campañas de marketing y análisis estadístico.", fontContenido));
            loTexto.add(new Phrase("De la misma forma, autorizo expresamente a ENEL DISTRIBUCIÓN a transferir mis datos personales a otras empresas del mismo grupo económico y socios comerciales con la finalidad de:", fontContenido));
            
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(I)   Evaluar mi capacidad crediticia y capacidad de pago.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(II)  Otorgarme el producto y/o servicio solicitado.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(III) Almacenar y tratar mis datos personales, con fines estadisticos y/o historicos.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("Optativo (marca 'X').", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(IV)  Ofrecerme otros productos y/o servicios y/o ofertas y/o publicidad.", fontContenido));
            loTexto.add(new Phrase(Chunk.NEWLINE));
            loTexto.add(new Phrase("(V)   Futuras promociones.", fontContenido));
            
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
            
            contentByte.rectangle(rectHuella);
            contentByte.rectangle(rectABC);
            contentByte.rectangle(rectGrande);
            
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
            huellaText.setSimpleColumn(377, 40, 495, 90);  
            huellaText.addElement(new Paragraph("HUELLA DIGITAL", fontTextos));
            huellaText.addElement(new Paragraph("INDICE DERECHO", fontTextos));
            huellaText.go();
            
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
