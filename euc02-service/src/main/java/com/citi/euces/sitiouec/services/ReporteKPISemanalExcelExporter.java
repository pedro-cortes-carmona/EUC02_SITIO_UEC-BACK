package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.ReporteWeekDTO;

public class ReporteKPISemanalExcelExporter {
	
	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	List<ReporteWeekDTO> listaWeek;
	
	private String fechaInicial;

	
	public ReporteKPISemanalExcelExporter(List<ReporteWeekDTO> listaWeek, String fechaInicial) {
		super();
		this.listaWeek = listaWeek;
		workbook = new XSSFWorkbook();
		this.fechaInicial=fechaInicial;
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("KPI");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, "Concepto", style);
		createCell(row, 1, "Sáb", style);
		createCell(row, 2, "Lun", style);
		createCell(row, 3, "Mar", style);
		createCell(row, 4, "Mie", style);
		createCell(row, 5, "Jue", style);
		createCell(row, 6, "Vie", style);
		createCell(row, 7, "Sem", style);

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
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (ReporteWeekDTO reporte : listaWeek) {

			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, reporte.getConcepto(), style);
			createCell(row, columnCount++, String.valueOf(reporte.getSab()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getLun()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getMar()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getMie()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getJue()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getVie()), style);
			createCell(row, columnCount++, String.valueOf(reporte.getSem()), style);
			
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
