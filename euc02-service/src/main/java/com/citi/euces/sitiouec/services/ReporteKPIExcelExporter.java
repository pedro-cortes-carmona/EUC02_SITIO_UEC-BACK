package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.ReporteEjecutivoKPIDTO;
import com.citi.euces.sitiouec.dto.ReporteWeekDTO;

public class ReporteKPIExcelExporter {

	private static final Logger LOGGER = LogManager.getLogger(ReporteKPIExcelExporter.class);

	private XSSFWorkbook workbook;

	private XSSFSheet sheet;

	private XSSFSheet sheetEjecutivo;

	private String fechaInicial;

	List<ReporteWeekDTO> listaWeek;

	Map<String, List<ReporteEjecutivoKPIDTO>> mapGente;

	public ReporteKPIExcelExporter(List<ReporteWeekDTO> listaWeek, String fechaInicial,
			Map<String, List<ReporteEjecutivoKPIDTO>> mapGente) {
		super();
		this.listaWeek = listaWeek;
		this.mapGente = mapGente;
		workbook = new XSSFWorkbook();
		this.fechaInicial = fechaInicial;
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Sheet1");

		int rowCount = 0;
		Row row = sheet.createRow(rowCount);

		Map<String, CellStyle> styleFieldsConceptos = createStylesTitulos(workbook);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCell(row, 0, fechaInicial, style);

		rowCount = 1;
		row = sheet.createRow(rowCount);

		createCellTitulos(row, 0, "Concepto", styleFieldsConceptos);
		createCellTitulos(row, 1, "Sáb", styleFieldsConceptos);
		createCellTitulos(row, 2, "Lun", styleFieldsConceptos);
		createCellTitulos(row, 3, "Mar", styleFieldsConceptos);
		createCellTitulos(row, 4, "Mie", styleFieldsConceptos);
		createCellTitulos(row, 5, "Jue", styleFieldsConceptos);
		createCellTitulos(row, 6, "Vie", styleFieldsConceptos);
		createCellTitulos(row, 7, "Sem", styleFieldsConceptos);

	}

	/**
	 * Metodo para el reporte Ejecutivo
	 */
	private void writeHeaderLineEjecutivo() {

		sheetEjecutivo = workbook.createSheet("Sheet2");

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

	private void createCellEjecutivo(Row row, int columnCount, Object value, CellStyle style) {
		sheetEjecutivo.autoSizeColumn(columnCount);
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

	private void createCellTitulos(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {

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
		cell.setCellStyle(styles.get("titulos"));
	}

	private void createCellTitulos2(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {

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
		cell.setCellStyle(styles.get("titulos2"));
	}

	private Map<String, CellStyle> createStylesTitulos(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("titulos", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesTitulos2(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("titulos2", style);

		return styles;
	}

	private void createCellEjecutivo2(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
		sheetEjecutivo.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {

		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(styles.get("ejecutivo"));
	}

	private void writeDataLines() {
		int rowCount = 2;

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

	/**
	 * create a library of cell styles
	 */
	private Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("ejecutivo", style);

		return styles;

	}

	private void writeDataLinesEjecutivo() {

		LOGGER.info("Method: writeDataLinesEjecutivo() - Classs:ReporteKPIExcelExporter");

		int rowCount = 2;
		int rowInitial = 1;
		int rowInitialSR = 0;

		Map<String, CellStyle> styleFields = createStyles(workbook);

		String primerNombre = "";
		String segundoNombre = "";
		String iniciales = "";

		Iterator<Map.Entry<String, List<ReporteEjecutivoKPIDTO>>> entry = mapGente.entrySet().iterator();

		while (entry.hasNext()) {

			Map.Entry<String, List<ReporteEjecutivoKPIDTO>> entry2 = entry.next();

			Row row = sheetEjecutivo.createRow(rowInitialSR);

			String[] inicialesArray = entry2.getKey().split(" ");

			if (inicialesArray[0] != null) {
				primerNombre = inicialesArray[0].substring(0, 1);
			}

			try {
				if (inicialesArray[1] != null) {
					segundoNombre = inicialesArray[1].substring(0, 1);
				}
				iniciales = primerNombre.concat(segundoNombre);
			} catch (Exception e) {
				LOGGER.error("ERROR:: NO SE ENCONTRO SEGUNDO NOMBRE CLASS:: ReporteKPIEjecutivoExcelExporter");
			}

			createCellEjecutivo2(row, 0, iniciales, styleFields);
			createCellEjecutivo2(row, 1, entry2.getKey(), styleFields);

			CellStyle style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			font.setFontHeight(14);
			style.setFont(font);

			row = sheetEjecutivo.createRow(rowInitial);

			Map<String, CellStyle> styleFieldsConceptos = createStylesTitulos2(workbook);

			createCellTitulos2(row, 0, "Fecha", styleFieldsConceptos);
			createCellTitulos2(row, 1, "Asignadas", styleFieldsConceptos);
			createCellTitulos2(row, 2, "Operadas", styleFieldsConceptos);
			createCellTitulos2(row, 3, "Productividad", styleFieldsConceptos);
			createCellTitulos2(row, 4, "Reprocesos", styleFieldsConceptos);
			createCellTitulos2(row, 5, "Accuracy", styleFieldsConceptos);
			createCellTitulos2(row, 6, "Fuera de Tiempo", styleFieldsConceptos);
			createCellTitulos2(row, 7, "TimeLiness", styleFieldsConceptos);

			for (ReporteEjecutivoKPIDTO reporte : entry2.getValue()) {

				row = sheetEjecutivo.createRow(rowCount++);
				int columnCount = 0;

				createCellEjecutivo(row, columnCount++, reporte.getFecha(), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getAsignadas()), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getOperadas()), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getProductividad()).concat("%"), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getReprocesos()), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getAccuracy()).concat("%"), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getFueraDeTiempo()), style);
				createCellEjecutivo(row, columnCount++, String.valueOf(reporte.getTimeliness()).concat("%"), style);
			}

			rowInitialSR += 8;
			rowInitial += 8;
			rowCount += 2;
		}

	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		writeHeaderLineEjecutivo();
		writeDataLinesEjecutivo();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}

}
