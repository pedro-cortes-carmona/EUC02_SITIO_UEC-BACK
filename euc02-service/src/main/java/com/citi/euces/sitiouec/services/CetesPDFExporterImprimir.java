package com.citi.euces.sitiouec.services;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.citi.euces.sitiouec.dto.ReporteCetesDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class CetesPDFExporterImprimir {

	
	private static final Logger LOGGER = LogManager.getLogger(CetesPDFExporterImprimir.class);

	List<ReporteCetesDTO> listCetesVariacion;
		
	public CetesPDFExporterImprimir() {
	
	}


	public CetesPDFExporterImprimir(List<ReporteCetesDTO> listCetesVariacion) {
		super();
		this.listCetesVariacion = listCetesVariacion;
	}

	
	
public String createPdf () throws IOException, DocumentException {
		
		Date date = java.util.Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String today = formatter.format(date);

		
		Document documento = new Document();
		FileOutputStream archivo;
		Path testFile = Files.createTempFile("campana_Cetes", ".pdf");
		archivo = new FileOutputStream(testFile.toFile());
		PdfWriter.getInstance(documento, archivo);
		
		
        documento.open();
        
        com.itextpdf.text.Font f = new com.itextpdf.text.Font();
        f.setSize(20);
        f.setFamily("Courier");
        f.setStyle(com.itextpdf.text.Font.BOLD);
        
        Paragraph paragraphHello = new Paragraph();
        paragraphHello.setFont(f);
        paragraphHello.add("CURVA DE CETES   Unidad Especializada de Comercialización UEC" + "      Fecha de Subasta: "
				+ today + "");
        paragraphHello.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraphHello);
        
        documento.add(new Paragraph("          \n"));        
        documento.add(new Paragraph("          \n"));
        
        LOGGER.info("SE CREA EL PRIMER PARRAFO"+ " " +  "createPdf::CetesPDFExporterImprimir");
        
        Paragraph paragraphHello2 = new Paragraph();
        paragraphHello2.setFont(f);
        paragraphHello2.add("Variación VS Subasta Anterior.");
        paragraphHello2.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraphHello2);
        
        
        LOGGER.info("SE CREA EL SEGUNDO PARRAFO"+ " " +  "createPdf::CetesPDFExporterImprimir");
        
        documento.add(new Paragraph("          \n"));        
        documento.add(new Paragraph("          \n"));
        
        
		PdfPTable tabla = new PdfPTable (3);
		
	    tabla.addCell("Plazo");
	    tabla.addCell("Cete %");
	    tabla.addCell("Variación");
	    
		
        if(listCetesVariacion.get(0).getListaCetesVariacion()!=null && listCetesVariacion.get(0).getListaCetesVariacion().size()>0) {
        	 for (int i = 0; i < listCetesVariacion.get(0).getListaCetesVariacion().size(); i++) {
             	
             	LOGGER.info("SE CREA EL SEGUNDO PARRAFO"+ " " +  "createPdf::listCetesVariacion.get(0).getListaCetesVariacion().size()");
             	
             	 tabla.addCell(String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getPlazo().intValue()));
             	 tabla.addCell(String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getTasa()));
             	 
             		if(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion()!=null) {
             			
             			tabla.addCell(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion());		
         				
             			LOGGER.info("CetesWordExporter: createWord - Variacion " +" " + 
         						listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion());
         				
         			}else {
         				tabla.addCell("   ");
         				LOGGER.info("CetesWordExporter: createWord - No  hay Variacion "); 
         			}	
             	             
     		}
        }else {
        	LOGGER.info("NO SE ENCONTRARON ELEMENTOS POR IMPRIMIR"
        			+ "   " +  "createPdf::listCetesVariacion.get(0).getListaCetesVariacion().size()");
        }
	    
         documento.add(tabla);
         documento.add(new Paragraph("          \n"));
	     documento.add(new Paragraph("          \n"));
	     
	     Paragraph paragraphHello3 = new Paragraph();
	     paragraphHello3.setFont(f);
	     paragraphHello3.add("* El valor del CETE se consulta en: www.banxico.org.mx");
	     paragraphHello3.setAlignment(Element.ALIGN_CENTER);
	     documento.add(paragraphHello3);
	        
	     LOGGER.info("SE CREA EL TERCER PARRAFO"+ " " +  "createPdf::");
	        
        /**
         * Create Table for AUTOCETES
         */
        PdfPTable tabla2 = new PdfPTable (2);
        
        tabla2.addCell("Plazo");
        tabla2.addCell("Cete %");
        
        
        if(listCetesVariacion.get(0).getListaCetes()!=null && listCetesVariacion.get(0).getListaCetes().size()>0) {
        	 for (int i = 0; i < listCetesVariacion.get(0).getListaCetes().size(); i++) {
             	
             	LOGGER.info("Segunda Lista - Plazo - Tasa "+ " " +  "listCetesVariacion.get(0).getListaCetes().size()::");
             	
             	tabla2.addCell(String.valueOf(listCetesVariacion.get(0).getListaCetes().get(i).getPlazo()));
             	tabla2.addCell(String.valueOf(listCetesVariacion.get(0).getListaCetes().get(i).getTasa()));
     		}
        }else {
        	LOGGER.info("NO SE ENCONTRARON ELEMENTOS POR IMPRIMIR"
        			+ "   " +  "createPdf::listCetesVariacion.get(0).getListaCetes()");
        }
        
        
       
        documento.add(tabla2);
        documento.close();
       
        String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(testFile.toFile()));
        String cadenaencodedBytes = new String(ecoder);
        LOGGER.info("Empieza -------");
        LOGGER.info(cadenaencodedBytes);
        LOGGER.info("ACABA -------");
		testFile.toFile().delete();
	
		return ecoder; 
          
	}
	
	
	
	
}
