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
import javax.swing.ImageIcon;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Roberto
 */
public class CReportePDF {
    private String pthFil;
    private String rutaReporte;
    private String error;
    
    //public static final String IMG = "/img/enelLOGO.png";
    
    public boolean evFinanciera() throws IOException {
        List<Cliente> lstClientes = new ArrayList<>();
        Cliente loCli = new Cliente();
        loCli.setNombre("ROBERTO");
        loCli.setApePat("DELGADO");
        loCli.setApeMat("CHOQUEHUANCA");
        loCli.setSexo("MASCULINO");
        loCli.setNroDoc("72908973");
        loCli.setTelefono("153032");
        loCli.setCelular("987303030");
        loCli.setCorreo("ROBERTO.MAIL.COM");
        loCli.setDireccion(new Direccion());
        loCli.getDireccion().setDistrito(new Distrito());
        loCli.getDireccion().getDistrito().setProvincia(new Provincia());
        loCli.getDireccion().setDireccion("Ca. Falsa 123");
        loCli.getDireccion().getDistrito().setNombre("J. L. B. Y RIVERO");
        loCli.getDireccion().getDistrito().getProvincia().setNombre("AREQUIPA");
        
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
    
    public boolean evFinancieraGE(List<Cliente> p_oClientes) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/PRUEBAcliente_" + LibFunc.getFechaActual() + ".pdf");
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
            
            for (Cliente loCliente : p_oClientes) {
                Paragraph loTitulo = new Paragraph();
                Paragraph loEncabezado = new Paragraph();
                Paragraph loCuerpo = new Paragraph();
                PdfPTable loEncabTabla = new PdfPTable(2);
                PdfPTable loTableCuerpo = new PdfPTable(4);
                Paragraph loTexto = new Paragraph();
                
                //ImageIcon Img = new ImageIcon(getClass().getResource("enelLogo.png"));
                Image logo = Image.getInstance("/enelLOGO.png");
                logo.scaleToFit(110, 35);
                logo.setAlignment(Element.ALIGN_CENTER);

                //Titulo
                loTitulo.add(new Phrase(Chunk.NEWLINE));
                loTitulo.add(new Paragraph("SOLICITUD DE EVALUACIÓN FINANCIERA", fontTitulos));
                loTitulo.setAlignment(Element.ALIGN_CENTER);
                loTitulo.add(new Phrase(Chunk.NEWLINE));
                
                //Encabezado
                Phrase contenido1 = new Phrase();
                contenido1.add(new Chunk("Código o Nombres y Apellidos del Afiliador\n\n", fontTabla));
                PdfPCell celda1 = new PdfPCell(contenido1);
                celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
                loEncabTabla.addCell(celda1);
                
                Phrase contenido2 = new Phrase();
                contenido2.add(new Chunk("Fecha Solicitud\n\n", fontTabla));
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
            
                PdfPCell celdaC1 = new PdfPCell(new Phrase("Número Suministro\n\n", fontContenido));
                celdaC1.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC2 = new Phrase();
                contenidoC2.add(new Chunk("Apellido Paterno\n\n", fontTabla));
                contenidoC2.add(new Chunk(loCliente.getApePat(), fontContenido));
                PdfPCell celdaC2 = new PdfPCell(contenidoC2);
                celdaC2.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC3 = new Phrase();
                contenidoC3.add(new Chunk("Apellido Materno\n\n", fontTabla));
                contenidoC3.add(new Chunk(loCliente.getApeMat(), fontContenido));
                PdfPCell celdaC3 = new PdfPCell(contenidoC3);
                celdaC3.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC4 = new Phrase();
                contenidoC4.add(new Chunk("Nombres\n\n", fontTabla));
                contenidoC4.add(new Chunk(loCliente.getNombre(), fontContenido));
                PdfPCell celdaC4 = new PdfPCell(contenidoC4);
                celdaC4.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC5 = new Phrase();
                contenidoC5.add(new Chunk("Sexo\n\n", fontTabla));
                contenidoC5.add(new Chunk(loCliente.getSexo(), fontContenido));
                PdfPCell celdaC5 = new PdfPCell(contenidoC5);
                celdaC5.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC6 = new Phrase();
                contenidoC6.add(new Chunk("Fecha de Nacimiento\n\n", fontTabla));
                PdfPCell celdaC6 = new PdfPCell(contenidoC6);
                celdaC6.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC7 = new Phrase();
                contenidoC7.add(new Chunk("Tipo de Documento de Identidad\n\n", fontTabla));
                PdfPCell celdaC7 = new PdfPCell(new Phrase(contenidoC7));
                celdaC7.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC8 = new Phrase();
                contenidoC8.add(new Chunk("Número de Documento de Identidad\n\n", fontTabla));
                contenidoC8.add(new Chunk(loCliente.getNroDoc(), fontContenido));
                PdfPCell celdaC8 = new PdfPCell(contenidoC8);
                celdaC8.setHorizontalAlignment(Element.ALIGN_CENTER);
            
                Phrase contenidoC9 = new Phrase();
                contenidoC9.add(new Chunk("Teléfono\n\n", fontTabla));
                contenidoC9.add(new Chunk(loCliente.getTelefono(), fontContenido));
                PdfPCell celdaC9 = new PdfPCell(contenidoC9);
                celdaC9.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC10 = new Phrase();
                contenidoC10.add(new Chunk("Teléfono Celular\n\n", fontTabla));
                contenidoC10.add(new Chunk(loCliente.getCelular(), fontContenido));
                PdfPCell celdaC10 = new PdfPCell(contenidoC10);
                celdaC10.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC11 = new Phrase();
                contenidoC11.add(new Chunk("Correo Electrónico\n\n", fontTabla));
                contenidoC11.add(new Chunk(loCliente.getCorreo(), fontContenido));
                PdfPCell celdaC11 = new PdfPCell(contenidoC11);
                celdaC11.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaC11.setColspan(2);
                
                Phrase contenidoC12 = new Phrase();
                contenidoC12.add(new Chunk("Dirección\n\n", fontTabla));
                contenidoC11.add(new Chunk(loCliente.getDireccion().getDireccion(), fontContenido));
                PdfPCell celdaC12 = new PdfPCell(contenidoC12);
                celdaC12.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaC12.setColspan(2);
                
                Phrase contenidoC13 = new Phrase();
                contenidoC13.add(new Chunk("Número\n\n", fontTabla));
                PdfPCell celdaC13 = new PdfPCell(contenidoC13);
                celdaC13.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC14 = new Phrase();
                contenidoC14.add(new Chunk("Urbanización\n\n", fontTabla));
                PdfPCell celdaC14 = new PdfPCell(contenidoC14);
                celdaC14.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                Phrase contenidoC15 = new Phrase();
                contenidoC15.add(new Chunk("Distrito\n\n", fontTabla));
                contenidoC15.add(new Chunk(loCliente.getDireccion().getDistrito().getNombre(), fontContenido));
                PdfPCell celdaC15 = new PdfPCell(contenidoC15);
                celdaC15.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaC15.setColspan(2);
                
                Phrase contenidoC16 = new Phrase();
                contenidoC16.add(new Chunk("Provincia\n\n", fontTabla));
                contenidoC16.add(new Chunk(loCliente.getDireccion().getDistrito().getProvincia().getNombre(), fontContenido));
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
                loTexto.setSpacingAfter(25);
                loTexto.setSpacingBefore(25);
                loTexto.setIndentationLeft(63);
                loTexto.setIndentationRight(63);
                loTexto.add(new Phrase("Declaro bajo juramento que la información proporcionada en la presente solicitud, así como toda aquella documentación adjunta es verídica, por lo que autorizo expresamente a ENEL DISTRIBUCIÓN PERÚ, en adelante ENEL DISTRIBUCIÓN, a verificar toda la información señalada en el presente documento y me hago responsable de cualquier daño o perjuicio derivado que la inexactitud de la información proporcionada pudiera causar a ENEL DISTRIBUCIÓN o a terceros.\n", fontContenido));
                loTexto.add(new Phrase(Chunk.NEWLINE));
                loTexto.add(new Phrase("Asimismo, de acuerdo a la ley Nº 29733 Ley de Protección de Datos Personales, brindo mi conformidad y autorizo expresamente a ENEL DISTRIBUCIÓN para que recopile mis datos personales con la finalidad de incorporarlos en su banco de datos así como utilizarlos para gestionar la información del financiamiento de productos, realizar campañas de marketing y análisis estadístico.", fontContenido));
                loTexto.add(new Phrase("De la misma forma, autorizo expresamente a ENEL DISTRIBUCIÓN a transferir mis datos personales a otras empresas del mismo grupo económico y socios comerciales con la finalidad de:\n", fontContenido));
                
                loTexto.add(new Phrase("(I)   Evaluar mi capacidad crediticia y capacidad de pago.", fontContenido));
                loTexto.add(new Phrase(Chunk.NEWLINE));
                loTexto.add(new Phrase("(II)  Otorgarme el producto y/o servicio solicitado.", fontContenido));
                loTexto.add(new Phrase(Chunk.NEWLINE));
                loTexto.add(new Phrase("(III) Almacenar y tratar mis datos personales, con fines estadisticos y/o historicos.", fontContenido));
                loTexto.add(new Phrase(Chunk.NEWLINE));
                loTexto.add(new Phrase("Optativo (marca 'X').", fontContenido));
                loTexto.add(new Phrase(Chunk.NEWLINE));
                loTexto.add(new Phrase("(IV)  Ofrecerme otros productos y/o servicios y/o ofertas y/o publicidad.\n", fontContenido));
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
            }
            loDoc.close();
            
        } catch (FileNotFoundException | DocumentException loErr) {
            setError(loErr.getMessage());
            llOk = false;
        }
        return llOk;
    }
    
    public boolean mxConFinan() throws IOException {
        List<Cliente> lstClientes = new ArrayList<>();
        Cliente loCli = new Cliente();
        loCli.setNombre("ROBERTO");
        loCli.setApePat("DELGADO");
        loCli.setApeMat("CHOQUEHUANCA");
        loCli.setSexo("MASCULINO");
        loCli.setNroDoc("72908973");
        loCli.setTelefono("153032");
        loCli.setCelular("987303030");
        loCli.setCorreo("ROBERTO.MAIL.COM");
        
        lstClientes.add(loCli);
        boolean llOk = mxConFinanArchivo(lstClientes);
        if (llOk) {
            setRutaReporte("/ftia/files/cartas/contratoFinanciamiento_" + LibFunc.getFechaActual() + ".pdf");
            LibFunc.mxLog("PRUEBA OK.");
        } else {
            LibFunc.mxLog("PRUEBA error: " + getError());
        }
        return llOk;
    }
    
    public boolean mxConFinanArchivo(List<Cliente> p_oClientes) throws IOException {
        boolean llOk = true;
        try {
            FileOutputStream loArchivo = new FileOutputStream("/ftia/files/cartas/contratoFinanciamiento_" + LibFunc.getFechaActual() + ".pdf");
            Document loDoc = new Document(PageSize.A4, -20, -20, 10, 50);
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
            
            for (Cliente loCliente : p_oClientes) {
                Paragraph loTitulo = new Paragraph();
                PdfPTable loTabla = new PdfPTable(3);
                Paragraph col1 = new Paragraph();
                Paragraph col3 = new Paragraph();
                
                //ImageIcon Img = new ImageIcon(getClass().getResource("enelLogo.png"));
                Image logo = Image.getInstance("/enelLOGO.png");
                logo.scaleToFit(110, 35);
                logo.setAlignment(Element.ALIGN_CENTER);

                //Titulo
                loTitulo.add(new Phrase(Chunk.NEWLINE));
                loTitulo.add(new Paragraph("CONTRATO DE FINANCIAMIENTO", fontTitulos));
                loTitulo.add(new Phrase(Chunk.NEWLINE));
                loTitulo.add(new Phrase(Chunk.NEWLINE));
                loTitulo.setAlignment(Element.ALIGN_CENTER);
                
                
                loTabla.setWidths(new float[] { 5, 1, 5 });
                //loTabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                
                //Primera columna
                col1.add(new Chunk("Conste por el presente documento el Contrato de Financiamiento (en adelante el “Contrato”), que celebran de una" +
                                    "parte ENEL DISTRIBUCIÓN PERÚ S.A.A. , con RUC Nº 20269985900, domiciliada en Calle César López Rojas 201," +
                                    "Urbanización Maranga, distrito de San Miguel, Provincia y Departamento de Lima, debidamente representada por el" +
                                    "funcionario que figura al final de este documento, con poderes inscritos en la partida electrónica 11008737 del Registro Público" +
                                    "de Personas Jurídicas de la Oficina Registral de Lima y Callao (en adelante “ENEL DISTRIBUCIÓN PERÚ”), y de la otra parte\n\n", fontContenido));
                col1.add(new Chunk("___________________________________________________\n\n", fontContenido));
                col1.add(new Chunk("___________________________________________________\n\n", fontContenido));
                col1.add(new Chunk("cuya identificación y demás generales de ley, figuran al final de este documento (en adelante el “CLIENTE”).\n\n", fontContenido));
                col1.add(new Phrase(Chunk.NEWLINE));
                col1.add(new Chunk("Este Contrato se regirá de acuerdo a lo establecido en las cláusulas siguientes:\n\n", fontContenido));
                col1.add(new Phrase(Chunk.NEWLINE));
                col1.add(new Chunk("PRIMERA.- ANTECEDENTES\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ es una empresa constituida en el Perú, que dentro de su objeto social está facultada a realizar actividades propias de la prestación del servicio de distribución, transmisión y generación de energía eléctrica de acuerdo con lo dispuesto en la legislación vigente, así como aquella relacionada a la prestación de servicios financieros y otros vinculados a estos fines.\n" +
                                    "El CLIENTE es una persona natural, domiciliada en el Perú, que ha s    olicitado a ENEL DISTRIBUCIÓN PERÚ el otorgamiento de un financiamiento para la compra de un producto para su uso personal y para la realización de actos lícitos, en la forma y dentro de los límites descritos en este documento, los mismos que le han sido debidamente explicados previamente a su suscripción.\n\n", fontContenido));
                col1.add(new Chunk("SEGUNDA.- OBJETO\n" +
                                    "Por medio de este documento, ENEL DISTRIBUCIÓN PERÚ concede financiamiento (en adelante, el \"financiamiento\") para la adquisición del producto a favor del CLIENTE (en adelante el PRODUCTO), cuyas características constan en la documentación anexa a este Contrato, la misma que el CLIENTE declara haber recibido y revisado en forma previa.\n\n", fontContenido));
                col1.add(new Chunk("TERCERA.- DEL FINANCIAMIENTO\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ se reserva la potestad de ampliar, reducir y/o suprimir el monto del financiamiento que otorga al CLIENTE, así como la facultad de otorgar, modificar y/o suprimir financiamientos adicionales, y/o financiamientos paralelos, en cualquier momento y a su sola discreción, bastando para ello una comunicación simple y oportuna al CLIENTE. De la misma manera, ENEL DISTRIBUCIÓN PERÚ podrá fijar frecuencias de pago, montos mínimos y máximos, así como otras condiciones por el monto del financiamiento otorgado al CLIENTE.\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ podrá cursar las comunicaciones en relación con los hechos descritos en el párrafo anterior por algunas de las siguientes vías: correo, fax, correo electrónico, publicación en las oficinas o cualquier otro medio idóneo para los fines descritos.\n\n", fontContenido));
                col1.add(new Chunk("CUARTA.- DE LA DISPOSICIÓN DEL FINANCIAMIENTO\n" +
                                    "El CLIENTE podrá disponer del importe financiado a partir de la suscripción del presente Contrato, la misma que podrá ser utilizada exclusivamente para la adquisición del PRODUCTO. EL CLIENTE autoriza a ENEL DISTRIBUCIÓN PERÚ a que este último deposite el importe total financiado directamente a la empresa proveedora o dueña del PRODUCTO. El CLIENTE gozará del beneficio de pagar en cuotas el monto del financiamiento otorgado, lo cual dará origen a la aplicación de una tasa de interés compensatoria, razón por la cual el CLIENTE se encuentra obligado a la devolución del capital, así como el pago de los intereses respectivos, de acuerdo a lo\n\n", fontContenido));
                //col1.setAlignment(Element.ALIGN_JUSTIFIED);
                
                Phrase col2 = new Phrase("");
                
                col3.add(new Chunk("previsto en este Contrato. De la misma manera, el CLIENTE estará obligado a pagar el Impuesto General a las Ventas (IGV) sobre los intereses compensatorios que se generen por el financiamiento que mediante el presente documento se otorga.\n" +
                                    "Asimismo, las partes acuerdan que el CLIENTE se obliga a pagar a ENEL DISTRIBUCIÓN PERÚ intereses moratorios, en caso incumpla con efectuar el pago de las cuotas pactadas en los plazos acordados en el presente contrato; dicho interés equivale a la tasa activa de interés anual máxima en moneda nacional permitida por el BCRP, sobre el importe de los saldos insolutos mientras dure su incumplimiento.\n\n", fontContenido));
                col3.add(new Phrase(Chunk.NEWLINE));
                col3.add(new Chunk("QUINTA.- DE LA MONEDA DEL FINANCIAMIENTO\n" +
                                    "El financiamiento que por este documento se otorga se pacta en moneda nacional (Soles).\n\n", fontContenido));
                col3.add(new Phrase(Chunk.NEWLINE));
                col3.add(new Chunk("SEXTA.- AUTORIZACIÓN DE CARGO \n" +
                                    "El CLIENTE autoriza en forma expresa a ENEL DISTRIBUCIÓN PERÚ el cobro de la (s) cuota (s) pendiente (s) de pago por el financiamiento otorgado en el recibo de energía eléctrica correspondiente al suministro consignado en la Solicitud de Evaluación Financiera. \n" +
                                    "La liquidación que se enviará en el recibo de energía eléctrica, se considerará aprobada por el CLIENTE si éste no formula observaciones por escrito, o lo hace en términos genéricos o sin detallar y sustentar los conceptos que observa dentro de los quince (15) días calendario posteriores a la recepción del recibo de energía eléctrica.\n\n", fontContenido));
                col3.add(new Chunk("En consecuencia, la periodicidad con la cual el CLIENTE deberá pagar las cuotas será mensual y el vencimiento será el mismo día en el cual vence la obligación del CLIENTE de pagar el monto facturado por consumo de energía eléctrica.\n\n", fontContenido));
                col3.add(new Chunk("Las partes declaran conocer que el día de facturación del servicio eléctrico, de acuerdo a las normas del sector eléctrico aplicables a ENEL DISTRIBUCIÓN PERÚ podrá ser variable, siempre que no sea inferior a veintiocho (28) días calendario ni supere los treinta y tres (33) días calendario. Siendo ello así, ambas partes aceptan que en caso exista alguna diferencia en el monto de alguna de las cuotas cargadas al CLIENTE por dicho motivo, ENEL DISTRIBUCIÓN PERÚ liquidará los montos abonados por el CLIENTE y compensará dicha situación en el monto correspondiente a la última cuota.\n\n", fontContenido));
                col3.add(new Chunk("En caso el CLIENTE dejara de ser el titular del suministro o el obligado a pagar los recibos de energía eléctrica, éste se obliga a comunicar a ENEL DISTRIBUCIÓN PERÚ en forma inmediata y en el plazo máximo de cuarenta y ocho (48) horas de producido el cambio de domicilio, su nueva dirección así como el nuevo número de suministro, los cuales deben encontrarse dentro de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ. Las deudas del financiamiento serán incluidas en el recibo de energía eléctrica en la nueva dirección y el número de suministro proporcionado por el cliente manteniéndose la obligación del pago de las cuotas y otros conceptos asociados. En caso el cliente no comunique estos cambios se mantendrá la obligación del pago de las cuotas incluidas en el recibo de energía del número de suministro vigente.\n\n", fontContenido));
                col3.add(new Chunk("Asimismo, las partes acuerdan que en caso el nuevo domicilio se encuentre fuera de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ, el CLIENTE se obliga a pagar la totalidad de las cuotas pendientes de pago a más tardar dentro de los cinco (5) días calendario de comunicado el cambio de domicilio.\n\n", fontContenido));
                
                /*PdfContentByte contentByte = writer.getDirectContent(); 
                ColumnText columna1 = new ColumnText(contentByte);
                columna1.setSimpleColumn(40, 40, 270, 745);
                columna1.addElement(col1);
                columna1.go();*/
                
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
                
                //PAGINA NUEVA
                loDoc.newPage();
                PdfPTable loTablap2 = new PdfPTable(3);
                Paragraph col1p2 = new Paragraph();
                Paragraph col3p2 = new Paragraph();
                
                loTablap2.setWidths(new float[] { 5, 1, 5 });
                //loTabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
                
                //Primera columna
                col1p2.add(new Chunk("SÉTIMA.- DEL LUGAR DE PAGO\n" +
                                    "El CLIENTE, se obliga a pagar y restituir a ENEL DISTRIBUCIÓN PERÚ las cantidades que disponga de su financiamiento, así como los intereses que se generen en términos del presente contrato, en las agencias de ENEL DISTRIBUCIÓN indicadas al dorso del recibo o en cualquier otro lugar que oportunamente le comunique ENEL DISTRIBUCIÓN PERÚ.\n\n", fontContenido));
                col1p2.add(new Chunk("___________________________________________________\n\n", fontContenido));
                col1p2.add(new Chunk("___________________________________________________\n\n", fontContenido));
                col1p2.add(new Chunk("cuya identificación y demás generales de ley, figuran al final de este documento (en adelante el “CLIENTE”).\n\n", fontContenido));
                col1p2.add(new Phrase(Chunk.NEWLINE));
                col1p2.add(new Chunk("Este Contrato se regirá de acuerdo a lo establecido en las cláusulas siguientes:\n\n", fontContenido));
                col1p2.add(new Phrase(Chunk.NEWLINE));
                col1p2.add(new Chunk("PRIMERA.- ANTECEDENTES\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ es una empresa constituida en el Perú, que dentro de su objeto social está facultada a realizar actividades propias de la prestación del servicio de distribución, transmisión y generación de energía eléctrica de acuerdo con lo dispuesto en la legislación vigente, así como aquella relacionada a la prestación de servicios financieros y otros vinculados a estos fines.\n" +
                                    "El CLIENTE es una persona natural, domiciliada en el Perú, que ha s    olicitado a ENEL DISTRIBUCIÓN PERÚ el otorgamiento de un financiamiento para la compra de un producto para su uso personal y para la realización de actos lícitos, en la forma y dentro de los límites descritos en este documento, los mismos que le han sido debidamente explicados previamente a su suscripción.\n\n", fontContenido));
                col1p2.add(new Chunk("SEGUNDA.- OBJETO\n" +
                                    "Por medio de este documento, ENEL DISTRIBUCIÓN PERÚ concede financiamiento (en adelante, el \"financiamiento\") para la adquisición del producto a favor del CLIENTE (en adelante el PRODUCTO), cuyas características constan en la documentación anexa a este Contrato, la misma que el CLIENTE declara haber recibido y revisado en forma previa.\n\n", fontContenido));
                col1p2.add(new Chunk("TERCERA.- DEL FINANCIAMIENTO\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ se reserva la potestad de ampliar, reducir y/o suprimir el monto del financiamiento que otorga al CLIENTE, así como la facultad de otorgar, modificar y/o suprimir financiamientos adicionales, y/o financiamientos paralelos, en cualquier momento y a su sola discreción, bastando para ello una comunicación simple y oportuna al CLIENTE. De la misma manera, ENEL DISTRIBUCIÓN PERÚ podrá fijar frecuencias de pago, montos mínimos y máximos, así como otras condiciones por el monto del financiamiento otorgado al CLIENTE.\n" +
                                    "ENEL DISTRIBUCIÓN PERÚ podrá cursar las comunicaciones en relación con los hechos descritos en el párrafo anterior por algunas de las siguientes vías: correo, fax, correo electrónico, publicación en las oficinas o cualquier otro medio idóneo para los fines descritos.\n\n", fontContenido));
                col1p2.add(new Chunk("CUARTA.- DE LA DISPOSICIÓN DEL FINANCIAMIENTO\n" +
                                    "El CLIENTE podrá disponer del importe financiado a partir de la suscripción del presente Contrato, la misma que podrá ser utilizada exclusivamente para la adquisición del PRODUCTO. EL CLIENTE autoriza a ENEL DISTRIBUCIÓN PERÚ a que este último deposite el importe total financiado directamente a la empresa proveedora o dueña del PRODUCTO. El CLIENTE gozará del beneficio de pagar en cuotas el monto del financiamiento otorgado, lo cual dará origen a la aplicación de una tasa de interés compensatoria, razón por la cual el CLIENTE se encuentra obligado a la devolución del capital, así como el pago de los intereses respectivos, de acuerdo a lo\n\n", fontContenido));
                //col1.setAlignment(Element.ALIGN_JUSTIFIED);
                
                Phrase col2p2 = new Phrase("");
                
                col3p2.add(new Chunk("previsto en este Contrato. De la misma manera, el CLIENTE estará obligado a pagar el Impuesto General a las Ventas (IGV) sobre los intereses compensatorios que se generen por el financiamiento que mediante el presente documento se otorga.\n" +
                                    "Asimismo, las partes acuerdan que el CLIENTE se obliga a pagar a ENEL DISTRIBUCIÓN PERÚ intereses moratorios, en caso incumpla con efectuar el pago de las cuotas pactadas en los plazos acordados en el presente contrato; dicho interés equivale a la tasa activa de interés anual máxima en moneda nacional permitida por el BCRP, sobre el importe de los saldos insolutos mientras dure su incumplimiento.\n\n", fontContenido));
                col3p2.add(new Phrase(Chunk.NEWLINE));
                col3p2.add(new Chunk("QUINTA.- DE LA MONEDA DEL FINANCIAMIENTO\n" +
                                    "El financiamiento que por este documento se otorga se pacta en moneda nacional (Soles).\n\n", fontContenido));
                col3p2.add(new Phrase(Chunk.NEWLINE));
                col3p2.add(new Chunk("SEXTA.- AUTORIZACIÓN DE CARGO \n" +
                                    "El CLIENTE autoriza en forma expresa a ENEL DISTRIBUCIÓN PERÚ el cobro de la (s) cuota (s) pendiente (s) de pago por el financiamiento otorgado en el recibo de energía eléctrica correspondiente al suministro consignado en la Solicitud de Evaluación Financiera. \n" +
                                    "La liquidación que se enviará en el recibo de energía eléctrica, se considerará aprobada por el CLIENTE si éste no formula observaciones por escrito, o lo hace en términos genéricos o sin detallar y sustentar los conceptos que observa dentro de los quince (15) días calendario posteriores a la recepción del recibo de energía eléctrica.\n\n", fontContenido));
                col3p2.add(new Chunk("En consecuencia, la periodicidad con la cual el CLIENTE deberá pagar las cuotas será mensual y el vencimiento será el mismo día en el cual vence la obligación del CLIENTE de pagar el monto facturado por consumo de energía eléctrica.\n\n", fontContenido));
                col3p2.add(new Chunk("Las partes declaran conocer que el día de facturación del servicio eléctrico, de acuerdo a las normas del sector eléctrico aplicables a ENEL DISTRIBUCIÓN PERÚ podrá ser variable, siempre que no sea inferior a veintiocho (28) días calendario ni supere los treinta y tres (33) días calendario. Siendo ello así, ambas partes aceptan que en caso exista alguna diferencia en el monto de alguna de las cuotas cargadas al CLIENTE por dicho motivo, ENEL DISTRIBUCIÓN PERÚ liquidará los montos abonados por el CLIENTE y compensará dicha situación en el monto correspondiente a la última cuota.\n\n", fontContenido));
                col3p2.add(new Chunk("En caso el CLIENTE dejara de ser el titular del suministro o el obligado a pagar los recibos de energía eléctrica, éste se obliga a comunicar a ENEL DISTRIBUCIÓN PERÚ en forma inmediata y en el plazo máximo de cuarenta y ocho (48) horas de producido el cambio de domicilio, su nueva dirección así como el nuevo número de suministro, los cuales deben encontrarse dentro de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ. Las deudas del financiamiento serán incluidas en el recibo de energía eléctrica en la nueva dirección y el número de suministro proporcionado por el cliente manteniéndose la obligación del pago de las cuotas y otros conceptos asociados. En caso el cliente no comunique estos cambios se mantendrá la obligación del pago de las cuotas incluidas en el recibo de energía del número de suministro vigente.\n\n", fontContenido));
                col3p2.add(new Chunk("Asimismo, las partes acuerdan que en caso el nuevo domicilio se encuentre fuera de la zona de concesión de ENEL DISTRIBUCIÓN PERÚ, el CLIENTE se obliga a pagar la totalidad de las cuotas pendientes de pago a más tardar dentro de los cinco (5) días calendario de comunicado el cambio de domicilio.\n\n", fontContenido));
                
                /*PdfContentByte contentByte = writer.getDirectContent(); 
                ColumnText columna1 = new ColumnText(contentByte);
                columna1.setSimpleColumn(40, 40, 270, 745);
                columna1.addElement(col1);
                columna1.go();*/
                
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
                
                //loDoc = new Document(PageSize.A4, -20, -20, 10, 50);
                //loDoc.newPage();
            }
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
}
