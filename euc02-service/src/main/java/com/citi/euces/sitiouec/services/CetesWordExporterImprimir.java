package com.citi.euces.sitiouec.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.citi.euces.sitiouec.dto.ReporteCetesDTO;

public class CetesWordExporterImprimir {

	private static final Logger LOGGER = LogManager.getLogger(CetesWordExporterImprimir.class);

	List<ReporteCetesDTO> listCetesVariacion;

	public CetesWordExporterImprimir() {
		// TODO Auto-generated constructor stub
	}

	public CetesWordExporterImprimir(List<ReporteCetesDTO> listCetesVariacion) {
		super();
		this.listCetesVariacion = listCetesVariacion;
	}

	public String createWord() throws IOException {

		Date date = java.util.Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String today = formatter.format(date);

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);

		XWPFRun titleRun = title.createRun();
		titleRun.setText("CURVA DE CETES   Unidad Especializada de Comercialización UEC" + "      Fecha de Subasta: "
				+ today + "");
		titleRun.setBold(true);
		titleRun.setFontFamily("Courier");
		titleRun.setFontSize(20);

		document.createParagraph().createRun().addBreak();

		XWPFParagraph titleVariacion = document.createParagraph();
		titleVariacion.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titleVariacion1 = titleVariacion.createRun();
		titleVariacion1.setText("Variación VS Subasta Anterior.");
		titleVariacion1.setBold(true);
		titleVariacion1.setFontFamily("Courier");
		titleVariacion1.setFontSize(20);

		XWPFTable table = document.createTable();

		XWPFTableRow row1 = table.getRow(0);
		row1.getCell(0).setText("Plazo");
		row1.addNewTableCell().setText("Cete");
		row1.addNewTableCell().setText("Variación");

		if( listCetesVariacion.get(0).getListaCetesVariacion()!=null  &&  listCetesVariacion.get(0).getListaCetesVariacion().size()>0) {
			
			
			for (int i = 0; i < listCetesVariacion.get(0).getListaCetesVariacion().size(); i++) {
				XWPFTableRow row2 = table.createRow();
				LOGGER.info("CetesWordExporter: createWord - CetesWordExporterImprimir ");
				
				if(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getPlazo()!=null) {
				  
					row2.getCell(0).setText(String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getPlazo().intValue()));
					
					LOGGER.info("CetesWordExporter: createWord - Plazo " +" " + 
					String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getPlazo()));				
				}
				
				if(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getTasa()!=null) {
				 
					row2.getCell(1).setText(String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getTasa()));
					LOGGER.info("CetesWordExporter: createWord - Tasas " +" " + 
							String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getTasa()));				
				}
				
						
				if(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion()!=null) {
					row2.getCell(2).setText(listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion());
					
					LOGGER.info("CetesWordExporter: createWord - Variacion " +" " + 
							listCetesVariacion.get(0).getListaCetesVariacion().get(i).getVariacion());
					
				}else {
					LOGGER.info("CetesWordExporter: createWord - No  hay Variacion "); 
					
					
				}
			}
		}else {
			
			LOGGER.info("NO SE ENCONTRO INFORMACION POR IMPRIRMIR" +  " " + "createWord");
			
		}
		
		

		document.createParagraph().createRun().addBreak();


		XWPFParagraph titlePlazoCete = document.createParagraph();
		titlePlazoCete.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titlePlazoCete1 = titlePlazoCete.createRun();
		titlePlazoCete1.setText("* El valor del CETE se consulta en: www.banxico.org.mx");
		titlePlazoCete1.setBold(true);
		titlePlazoCete1.setFontFamily("Courier");
		titlePlazoCete1.setFontSize(20);
		
		document.createParagraph().createRun().addBreak();

		/**
		 * Create Table for El valor del CETE se consulta en: www.banxico.org.mx
		 */
		XWPFTable table4 = document.createTable();

		XWPFTableRow row3 = table4.getRow(0);
		row3.getCell(0).setText("Plazo");
		row3.addNewTableCell().setText("Cete %");

		for (int i = 0; i < listCetesVariacion.get(0).getListaCetes().size(); i++) {
			XWPFTableRow row4 = table4.createRow();
			row4.getCell(0).setText(String.valueOf(listCetesVariacion.get(0).getListaCetes().get(i).getPlazo().intValue()));
			row4.getCell(1).setText(String.valueOf(listCetesVariacion.get(0).getListaCetes().get(i).getTasa()));
		}
		
		String directorio = new File("").getAbsolutePath();
		System.out.println(directorio + "\\campana_Cetes.docx");
		File fila = new File(directorio + "\\campana_Cetes.docx");
		fila.delete();
		FileOutputStream word = new FileOutputStream(directorio + "\\campana_Cetes.docx");
		document.write(word);
		word.close();
		byte[] input_file3 = Files.readAllBytes(Paths.get(directorio + "\\campana_Cetes.docx"));
		byte[] encodedBytes3 = Base64.getEncoder().encode(input_file3);
		String encodedString3 = new String(encodedBytes3);
		LOGGER.info(" - encodedString3 - "+ " " + encodedString3); 
		document.close();
		

		return encodedString3;

	}

}
