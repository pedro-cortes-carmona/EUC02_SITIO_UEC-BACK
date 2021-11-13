package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.HistoricoAsignacionesDTO;


public class ReporteHistoricoAsignacionesExcelExporter {

	
	private static final Logger LOGGER = LogManager.getLogger(ReporteHistoricoAsignacionesExcelExporter.class);

	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	List<HistoricoAsignacionesDTO> lsHistorico;
	
	private String fechaInicial;
	
	private String FechaFinal;

	public ReporteHistoricoAsignacionesExcelExporter() {
		// TODO Auto-generated constructor stub
	}

	
	public ReporteHistoricoAsignacionesExcelExporter(List<HistoricoAsignacionesDTO> lsHistorico, String fechaInicial, String FechaFinal) {
		super();
		this.lsHistorico = lsHistorico;
		workbook = new XSSFWorkbook();
		this.fechaInicial=fechaInicial;
		this.FechaFinal=FechaFinal;

	}
	
	    private void writeHeaderLine() {
		
		sheet = workbook.createSheet("HistoricoAsignaciones");

		LOGGER.info("writeHeaderLine :: ReporteHistoricoAsignacionesExcelExporter ");
		
		int rowCount=0;
		
		Row row = sheet.createRow(rowCount);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		createCell(row, 0, "HISTORICO DE ASIGNACIONES" +  " "
				+ "FECHA INICIAL    "  + "     " +  fechaInicial  +   " FECHA FINAL  " + "   "  +   FechaFinal , style);
		
		rowCount=1;
		row = sheet.createRow(rowCount);

		createCell(row, 0, "ID Auto Tasa", style);
		createCell(row, 1, "Soeid", style);
		createCell(row, 2, "Soeid Atendido", style);
		createCell(row, 3, "Fecha Solicitud", style);
		createCell(row, 4, "Fecha Desconexion", style);
		createCell(row, 5, "Estatus", style);
		
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
	
	private void writeDataLines() {
		int rowCount = 2;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (HistoricoAsignacionesDTO historicoAsignacionesDTO : lsHistorico) {
		    Row row = sheet.createRow(rowCount++);
			
		    int columnCount = 0;
		   
		    LOGGER.info("writeHeaderLine :: ReporteHistoricoAsignacionesExcelExporter - Elemento"+ " " + historicoAsignacionesDTO.toString());
		   
			createCell(row, columnCount++, String.valueOf(historicoAsignacionesDTO.getIdTasaAuto()), style);
			createCell(row, columnCount++, String.valueOf(historicoAsignacionesDTO.getSoeid()), style);
			
			if(historicoAsignacionesDTO.getSoeidAtendido()!=null) {
				createCell(row, columnCount++, String.valueOf(historicoAsignacionesDTO.getSoeidAtendido()), style);	
			}else {
				createCell(row, columnCount++, "N/A".toString(), style);
			}
			createCell(row, columnCount++, historicoAsignacionesDTO.getFechaSoli().toString(), style);
			
			if(historicoAsignacionesDTO.getFechaDesc()!=null) {
				createCell(row, columnCount++, historicoAsignacionesDTO.getFechaDesc().toString(), style);	
			}else {
				createCell(row, columnCount++, "NA".toString(), style);
			}
			
			createCell(row, columnCount++, String.valueOf(historicoAsignacionesDTO.getEstatus()), style);
			
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
