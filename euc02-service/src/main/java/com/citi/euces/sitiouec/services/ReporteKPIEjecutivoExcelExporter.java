package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.ReporteEjecutivoKPIDTO;

public class ReporteKPIEjecutivoExcelExporter {
	
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteKPIEjecutivoExcelExporter.class);

	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	Map<String, List<ReporteEjecutivoKPIDTO>> mapGente;
	

	public ReporteKPIEjecutivoExcelExporter(Map<String, List<ReporteEjecutivoKPIDTO>> mapGente) {
		// TODO Auto-generated constructor stub
		super();
		this.mapGente = mapGente;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Sheet2");

		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {

		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	
	
	private void createCell2(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {

		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		cell.setCellStyle(style);
	}


	private void writeDataLines() {
		
		int rowCount = 2;
		int rowInitial=1;
		int rowInitialSR=0;
		
		CellStyle styleFields = workbook.createCellStyle();
		styleFields.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
		
		String primerNombre="";
		String segundoNombre="";
		String iniciales="";		
		
		Iterator<Map.Entry<String, List<ReporteEjecutivoKPIDTO>>> entry = mapGente.entrySet().iterator();
		
		while(entry.hasNext()) {
			
			Map.Entry<String, List<ReporteEjecutivoKPIDTO>> entry2 = entry.next();
			
			Row row = sheet.createRow(rowInitialSR);
			
			String []  inicialesArray = entry2.getKey().split(" ");
			
			if(inicialesArray[0]!=null) {
				primerNombre = inicialesArray[0].substring(0,1); 
			}
			
			try {
				if(inicialesArray[1]!=null) {
					segundoNombre = inicialesArray[1].substring(0,1); 
				}	
				iniciales = primerNombre.concat(segundoNombre);
			} catch (Exception e) {
				LOGGER.error("ERROR:: NO SE ENCONTRO SEGUNDO NOMBRE CLASS:: ReporteKPIEjecutivoExcelExporter");				
			}
			
			createCell2(row, 0, iniciales, styleFields);
			createCell2(row, 1, entry2.getKey(), styleFields);
			
			CellStyle style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			font.setFontHeight(14);
			style.setFont(font);
			
			
			row = sheet.createRow(rowInitial);

			createCell(row, 0, "Fecha", style);
			createCell(row, 1, "Asignadas", style);
			createCell(row, 2, "Operadas", style);
			createCell(row, 3, "Productividad", style);
			createCell(row, 4, "Reprocesos", style);
			createCell(row, 5, "Accuracy", style);
			createCell(row, 6, "Fuera de Tiempo", style);
			createCell(row, 7, "TimeLiness", style);
			
			for (ReporteEjecutivoKPIDTO reporte : entry2.getValue()) {
				
				LOGGER.info("INGRESA AL CICLO ReporteEjecutivoKPIDTO : CLASS  ");
				row = sheet.createRow(rowCount++);
				int columnCount = 0;
				
				createCell(row, columnCount++, reporte.getFecha(), style);
				createCell(row, columnCount++, String.valueOf(reporte.getAsignadas()), style);
				createCell(row, columnCount++, String.valueOf(reporte.getOperadas()), style);
				createCell(row, columnCount++, String.valueOf(reporte.getProductividad()).concat("%"), style);
				createCell(row, columnCount++, String.valueOf(reporte.getReprocesos()), style);
				createCell(row, columnCount++, String.valueOf(reporte.getAccuracy()).concat("%"), style);
				createCell(row, columnCount++, String.valueOf(reporte.getFueraDeTiempo()), style);
				createCell(row, columnCount++, String.valueOf(reporte.getTimeliness()).concat("%"), style);									
			}
			rowInitialSR +=8;
			rowInitial +=8;
			rowCount +=2;
		}
		
	  
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
