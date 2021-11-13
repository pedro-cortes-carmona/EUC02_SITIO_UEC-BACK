package com.citi.euces.sitiouec.services;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import javax.mail.util.SharedFileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.citi.euces.sitiouec.dto.AutoCetesDTO;
import com.citi.euces.sitiouec.dto.SubastaCetesDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CetesWordExporter {
	
	
	private static final Logger LOGGER = LogManager.getLogger(CetesWordExporter.class);
	
	private List<AutoCetesDTO> lsAutoCetes;
	
	private List<SubastaCetesDTO> lsSubasta;
	
	public CetesWordExporter() {
		
	}
	
	public CetesWordExporter(List<AutoCetesDTO> lsAutoCetes,List<SubastaCetesDTO> lsSubasta) {
		super();
		this.lsAutoCetes = lsAutoCetes;
		this.lsSubasta= lsSubasta;
	}

	public String createWord () throws IOException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		
		XWPFRun titleRun = title.createRun();
		titleRun.setText("Historico CETES");
		//titleRun.setColor("092290");
		titleRun.setBold(true);
		titleRun.setFontFamily("Courier");
		titleRun.setFontSize(20);
	
		XWPFTable table = document.createTable();
		
	    XWPFTableRow row1 = table.getRow(0);
        row1.getCell(0).setText("Fecha");
        row1.addNewTableCell().setText("Plazo 1");
        row1.addNewTableCell().setText("Tasa 1");
        row1.addNewTableCell().setText("Plazo 2");
        row1.addNewTableCell().setText("Tasa 2");
        row1.addNewTableCell().setText("Plazo 3");
        row1.addNewTableCell().setText("Tasa 3");
        row1.addNewTableCell().setText("Plazo 4");
        row1.addNewTableCell().setText("Tasa 4");
		
		
        for (int i = 0; i < lsSubasta.size(); i++) {
        	XWPFTableRow row2 = table.createRow();
        	String fecha = format.format(lsSubasta.get(i).getFecha());
        	LOGGER.info("Fechas - CetesWordExporter: createWord - Class:CetesWordExporter " + " " +  fecha);
        	row2.getCell(0).setText(fecha);
            row2.getCell(1).setText(String.valueOf(lsSubasta.get(i).getCete1plazo()));
            row2.getCell(2).setText(String.valueOf(lsSubasta.get(i).getCete1tasa()*100));
            row2.getCell(3).setText(String.valueOf(lsSubasta.get(i).getCete2plazo()));
            row2.getCell(4).setText(String.valueOf(lsSubasta.get(i).getCete2tasa()*100));
            row2.getCell(5).setText(String.valueOf(lsSubasta.get(i).getCete3plazo()));
            row2.getCell(6).setText(String.valueOf(lsSubasta.get(i).getCete3tasa()*100));
            row2.getCell(7).setText(String.valueOf(lsSubasta.get(i).getCete4plazo()));
            row2.getCell(8).setText(String.valueOf(lsSubasta.get(i).getCete4tasa()*100));            
		}
        
        document.createParagraph().createRun().addBreak();

        /**
         * Create Table for AUTOCETES
         */
        XWPFTable table3 = document.createTable();
        
        
        XWPFTableRow row3 = table3.getRow(0);
        row3.getCell(0).setText("ID Plazo");
        row3.addNewTableCell().setText("Cete");
        
        for (int i = 0; i < lsAutoCetes.size(); i++) {
        	XWPFTableRow row4 = table3.createRow();
        	row4.getCell(0).setText(String.valueOf(lsAutoCetes.get(i).getIdPlazo()));
            row4.getCell(1).setText(String.valueOf(lsAutoCetes.get(i).getCete()));                       
		}
        
      
		
		/*ByteArrayOutputStream out = new ByteArrayOutputStream();
		  document.write(out);
		  out.close();
		  document.close();
		  byte[] xwpfDocumentBytes = out.toByteArray();
		  byte[] encodedBytes = Base64.getEncoder().encode(xwpfDocumentBytes);
		  // do something with the byte array
          String cadenaencodedBytes = new String(encodedBytes);
          System.out.println("EMPIESA -------");
          System.out.println(cadenaencodedBytes);
          System.out.println("ACABA -------");
          */
       /* ServletOutputStream outputStream = response.getOutputStream();
  		document.write(outputStream);
  		outputStream.close();
  		document.close();*/
          String encodedString3 = null;
          String directorio = new File ("").getAbsolutePath();
          System.out.println(directorio+"\\campana_Cetes.docx");
          File fila = new File(directorio+"\\campana_Cetes.docx");
              FileOutputStream word = new FileOutputStream(directorio+"\\campana_Cetes.docx");
              document.write(word);
              word.close(); 
              byte[] input_file3 = Files.readAllBytes(Paths.get(directorio+"\\campana_Cetes.docx"));
              byte[] encodedBytes3 = Base64.getEncoder().encode(input_file3);
              encodedString3 =  new String(encodedBytes3);
              System.out.println(encodedString3);
        	  fila.delete();  


		return encodedString3;
          
	}
	
public String createExel () throws IOException {
		
	    ByteArrayOutputStream out = new ByteArrayOutputStream();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 //Crear libro de trabajo en blanco
        Workbook workbook = new HSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

        //Crea hoja nueva
        Sheet sheet =  workbook.createSheet("ReporteHistoricoCetes");
        Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLACK.getIndex());
       
		Font headerFont2 = workbook.createFont();
		headerFont2.setColor(IndexedColors.WHITE.getIndex());

   
		
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
	
		
		//-------Color-------------------
		CellStyle headerCellStyle2 = workbook.createCellStyle();
		headerCellStyle2.setFont(headerFont2);
		headerCellStyle2.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
		headerCellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle headerCellStyle3 = workbook.createCellStyle();
		headerCellStyle3.setFont(headerFont2);
		headerCellStyle3.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
		headerCellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle headerCellStyle4 = workbook.createCellStyle();
		headerCellStyle4.setFont(headerFont2);
		headerCellStyle4.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
		headerCellStyle4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle headerCellStyle5 = workbook.createCellStyle();
		headerCellStyle5.setFont(headerFont2);
		headerCellStyle5.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		headerCellStyle5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle headerCellStyle6 = workbook.createCellStyle();
		headerCellStyle6.setFont(headerFont2);
		headerCellStyle6.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerCellStyle6.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//-------Color-------------------
		
		//---------------titulo-----------
		Row ini = sheet.createRow(0);
		Cell cellini = ini.createCell(6);
		cellini.setCellValue("Histórico CETES");
		cellini.setCellStyle(headerCellStyle);
	//	sheet.addMergedRegion(new CellRangeAddress(-1, -1, 6, 7));
		//---------------titulo-----------
		
		//---------------titulo-----------
	//	Row inilinea = sheet.createRow(1);
	//	Cell cellinilinea = inilinea.createCell(0);
	//	cellinilinea.setCellValue("________");
	//	cellinilinea.setCellStyle(headerCellStyle);
	//	sheet.addMergedRegion(new CellRangeAddress(-1, -1, -1, 9));
		//---------------titulo-----------

		Row headerRow = sheet.createRow(6);

		
		Cell cell1 = headerRow.createCell(1);
		cell1.setCellValue("Fecha");
		cell1.setCellStyle(headerCellStyle2);
		
		Cell cell2 = headerRow.createCell(2);
		cell2.setCellValue("Plazo 1");
		cell2.setCellStyle(headerCellStyle3);
		
		Cell cell3 = headerRow.createCell(3);
		cell3.setCellValue("Tasa 1");
		cell3.setCellStyle(headerCellStyle3);
		
		Cell cell4 = headerRow.createCell(4);
		cell4.setCellValue("Plazo 2");
		cell4.setCellStyle(headerCellStyle4);
		
		Cell cell5 = headerRow.createCell(5);
		cell5.setCellValue("Tasa 2");
		cell5.setCellStyle(headerCellStyle4);
		
		Cell cell6 = headerRow.createCell(6);
		cell6.setCellValue("Plazo 3");
		cell6.setCellStyle(headerCellStyle5);
		
		Cell cell7 = headerRow.createCell(7);
		cell7.setCellValue("Tasa 3");
		cell7.setCellStyle(headerCellStyle5);
		
		Cell cell8 = headerRow.createCell(8);
		cell8.setCellValue("Plazo 4");
		cell8.setCellStyle(headerCellStyle4);
		
		Cell cell9 = headerRow.createCell(9);
		cell9.setCellValue("Tasa 4");
		cell9.setCellStyle(headerCellStyle4);
		
		
		
		/*  String[] COLUMNs = {"Fecha", "Plazo 1", "Tasa 1","Plazo 2", "Tasa 2","Plazo 3", "Tasa 3","Plazo 4", "Tasa 4"};
		  for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				
				if(col == 0) {
					cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle2);
				}else if (col == 1 || col == 2 ) {
					cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle3);
				}else if (col == 3 || col == 4) {
					cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle4);
				}else if (col == 5 || col == 6 ) {
					cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle5);
				}else if (col == 7 || col == 8 ){
					cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle6);
				}

			}*/
		  
		int rowIdx = 7;
        for (int i = 0; i < lsSubasta.size(); i++) {
        	Row row = sheet.createRow(rowIdx++);
        	String fecha = format.format(lsSubasta.get(i).getFecha());
        	row.createCell(1).setCellValue(fecha);
        	row.createCell(2).setCellValue(String.valueOf(lsSubasta.get(i).getCete1plazo()));
        	row.createCell(3).setCellValue(String.valueOf(lsSubasta.get(i).getCete1tasa()*100));
        	row.createCell(4).setCellValue(String.valueOf(lsSubasta.get(i).getCete2plazo()));
        	row.createCell(5).setCellValue(String.valueOf(lsSubasta.get(i).getCete2tasa()*100));
        	row.createCell(6).setCellValue(String.valueOf(lsSubasta.get(i).getCete3plazo()));
        	row.createCell(7).setCellValue(String.valueOf(lsSubasta.get(i).getCete3tasa()*100));
        	row.createCell(8).setCellValue(String.valueOf(lsSubasta.get(i).getCete4plazo()));
        	row.createCell(9).setCellValue(String.valueOf(lsSubasta.get(i).getCete4tasa()*100));            
		}
        Row headerRow2 = sheet.createRow(rowIdx+3);
        
        Cell cell11 = headerRow2.createCell(4);
        cell11.setCellValue("ID Plazo");
		cell11.setCellStyle(headerCellStyle3);
		
		Cell cell12 = headerRow2.createCell(5);
	        cell12.setCellValue("Cete");
			cell12.setCellStyle(headerCellStyle3);
		
		
		
      /*  String[] COLUMNs2 = {"ID Plazo", "Cete"};
        for (int col1 = 0; col1 < COLUMNs2.length+1; col1++) {
			Cell cell11 = headerRow2.createCell(col1);
			if(col1 == 0) {
				cell11.setCellValue(COLUMNs2[col1]);
				cell11.setCellStyle(headerCellStyle3);
			}else {
				cell11.setCellValue(COLUMNs2[col1]);
				cell11.setCellStyle(headerCellStyle3);
			}
*/
	//	}
        int rowIdx2 = rowIdx+4;
        for (int i = 0; i < lsAutoCetes.size(); i++) {
        	Row row2 = sheet.createRow(rowIdx2++);
        	row2.createCell(4).setCellValue(String.valueOf(lsAutoCetes.get(i).getIdPlazo()));
        	row2.createCell(5).setCellValue(String.valueOf(lsAutoCetes.get(i).getCete()));                       
		}

        String directorio = new File ("").getAbsolutePath();
        System.out.println(directorio+"\\campana_Cetes.xlsx");
        File fila = new File(directorio+"\\campana_Cetes.xlsx");
      	  fila.delete();
            FileOutputStream word = new FileOutputStream(directorio+"\\campana_Cetes.xlsx");
            workbook.write(word);
            byte[] input_file = Files.readAllBytes(Paths.get(directorio+"\\campana_Cetes.xlsx"));
            byte[] encodedBytes = Base64.getEncoder().encode(input_file);
            String encodedString =  new String(encodedBytes);
            System.out.println("excel :: " + encodedString);
            word.close(); 
        
            return encodedString; 
          
	}

 	public void ConvertToPDF(String docPath, String pdfPath) throws DocumentException {
 		try {
           /* InputStream doc = new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, out, options);*/
 		// 1) Load DOCX into XWPFDocument
 			String linea, FileName;
 		    File InFile = null;
 		    FileReader fr = null;
 		    BufferedReader br = null;
 	 
 		    //Selecciona el archivo a convertir.
 		    FileName = docPath;
 	 
 		    // Abre el archivo y crea el reader.
 		    InFile = new File (FileName);
 		    fr = new FileReader (InFile);
 	            br = new BufferedReader(fr);
 	 
 	            //Crea el documento de salida.
 		    FileOutputStream archivo = new FileOutputStream(pdfPath);
 		    Document documento = new Document();
 		    PdfWriter.getInstance(documento, archivo);
 		    documento.open();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
 	}
 	
	public String createPdf () throws IOException, DocumentException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Document documento = new Document();
		FileOutputStream archivo;
		Path testFile = Files.createTempFile("campana_Cetes", ".pdf");
		archivo = new FileOutputStream(testFile.toFile());
		PdfWriter.getInstance(documento, archivo);
		
		
       /* String directorio = new File ("").getAbsolutePath();
        System.out.println(directorio+"\\campana_Cetes.pdf");
        PdfWriter.getInstance(documento, new FileOutputStream(directorio+"\\campana_Cetes.pdf"));*/
        documento.open();
        
        com.itextpdf.text.Font f = new com.itextpdf.text.Font();
        f.setSize(20);
        f.setFamily("Courier");
        f.setStyle(com.itextpdf.text.Font.BOLD);
        
        Paragraph paragraphHello = new Paragraph();
        paragraphHello.setFont(f);
        paragraphHello.add("Historico CETES");
        paragraphHello.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraphHello);
        
        documento.add(new Paragraph("          \n"));
		PdfPTable tabla = new PdfPTable (9);
		
	    tabla.addCell("Fecha");
	    tabla.addCell("Plazo 1");
	    tabla.addCell("Tasa 1");
	    tabla.addCell("Plazo 2");
	    tabla.addCell("Tasa 2");
	    tabla.addCell("Plazo 3");
	    tabla.addCell("Tasa 3");
	    tabla.addCell("Plazo 4");
	    tabla.addCell("Tasa 4");
		
		
        for (int i = 0; i < lsSubasta.size(); i++) {
        	String fecha = format.format(lsSubasta.get(i).getFecha());
        	LOGGER.info("Fechas - CetesWordExporter: createWord - Class:CetesWordExporter " + " " +  fecha);
        	 tabla.addCell(fecha);
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete1plazo()));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete1tasa()*100));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete2plazo()));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete2tasa()*100));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete3plazo()));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete3tasa()*100));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete4plazo()));
        	 tabla.addCell(String.valueOf(lsSubasta.get(i).getCete4tasa()*100));            
		}
         documento.add(tabla);
         documento.add(new Paragraph("          \n"));
	     documento.add(new Paragraph("          \n"));
        /**
         * Create Table for AUTOCETES
         */
        PdfPTable tabla2 = new PdfPTable (2);
        
        tabla2.addCell("ID Plazo");
        tabla2.addCell("Cete");
        
        for (int i = 0; i < lsAutoCetes.size(); i++) {
        	tabla2.addCell(String.valueOf(lsAutoCetes.get(i).getIdPlazo()));
        	tabla2.addCell(String.valueOf(lsAutoCetes.get(i).getCete()));                       
		}
        documento.add(tabla2);
        documento.close();
       
        String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));
        String cadenaencodedBytes = new String(ecoder);
        System.out.println("EMPIESA -------");
        System.out.println(cadenaencodedBytes);
        System.out.println("ACABA -------");
		testFile.toFile().delete();
        return ecoder; 
          
	}
	

}
