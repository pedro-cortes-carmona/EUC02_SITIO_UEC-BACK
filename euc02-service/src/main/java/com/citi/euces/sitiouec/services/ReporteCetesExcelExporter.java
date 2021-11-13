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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.ReporteCetesDTO;

public class ReporteCetesExcelExporter {

	private static final Logger LOGGER = LogManager.getLogger(ReporteCetesExcelExporter.class);

	private XSSFWorkbook workbook;

	private XSSFSheet sheet;

	List<ReporteCetesDTO> listCetesVariacion;

	public ReporteCetesExcelExporter(List<ReporteCetesDTO> listCetesVariacion) {
		super();
		workbook = new XSSFWorkbook();
		this.listCetesVariacion = listCetesVariacion;
	}

	private void writeHeaderLine() {

		sheet = workbook.createSheet("Reporte Cetes");
		sheet.setPrintGridlines(false);
		sheet.setDisplayGridlines(false);

		Date date = java.util.Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String today = formatter.format(date);

		LOGGER.info("Metodo para crear los titulos del Excel ");

		int rowCount = 4;

		Row row = sheet.createRow(rowCount);

		Map<String, CellStyle> styleFieldsColumnCurvaCetes = createStylesCurvaCetes(workbook);
		Map<String, CellStyle> styleFieldsColumnCurvaCetes2 = createStylesCurvaCetes2(workbook);
		Map<String, CellStyle> styleFieldsColumnPlazo = createStylesColumnPlazo(workbook);
		Map<String, CellStyle> styleFieldsColumnPlazo2 = createStylesColumnPlazo2(workbook);
		Map<String, CellStyle> styleFieldsColumnCete = createStylesCete(workbook);
		Map<String, CellStyle> styleFieldsColumnVariacion = createStylesVariacion(workbook);

		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(false);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		// Titulo 1
		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("CURVA DE CETES   Unidad Especializada de Comercialización UEC"
				+ "      Fecha de Subasta: " + today + "");
		titleCell.setCellStyle(styleFieldsColumnCurvaCetes.get("curvacetes"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N1"));

		// Titulo 2
		Row titleRow2 = sheet.createRow(2);
		titleRow2.setHeightInPoints(35);
		Cell titleCell2 = titleRow2.createCell(2);
		titleCell2.setCellValue("Variación VS Subasta Anterior.");
		titleCell2.setCellStyle(styleFieldsColumnCurvaCetes2.get("curvacetes2"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$4:$E$4"));

		// Titulo 3
		int rowCountCete = 4;
		row = sheet.createRow(rowCountCete);

		CellStyle styleCete = workbook.createCellStyle();
		XSSFFont font2 = workbook.createFont();
		font2.setBold(true);
		font2.setFontHeight(16);
		style.setFont(font2);

		createCellWriteDataLines(row, 5, "* El valor del CETE se consulta en: www.banxico.org.mx", styleCete);

		rowCount = 7;
		row = sheet.createRow(rowCount);

		createCellTituloscolumnPlazo(row, 0, "PLAZO", styleFieldsColumnPlazo);
		createCellTituloscolumnCete(row, 1, "CETE %", styleFieldsColumnCete);
		createCellTituloscolumnVariacion(row, 2, "Variación", styleFieldsColumnVariacion);

		createCellTituloscolumnPlazo2(row, 8, "PLAZO", styleFieldsColumnPlazo2);
		createCellTituloscolumnCete(row, 9, "CETE %", styleFieldsColumnCete);

	}

	private Map<String, CellStyle> createStylesCurvaCetes(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(titleFont);
		styles.put("curvacetes", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesCurvaCetes2(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(titleFont);
		styles.put("curvacetes2", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesColumnPlazo(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("plazo", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesColumnPlazo2(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("plazo2", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesCete(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("cete", style);

		return styles;
	}

	private Map<String, CellStyle> createStylesVariacion(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();

		CellStyle style = workbook.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("variacion", style);

		return styles;
	}

	private void createCellTituloscolumnPlazo(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("plazo"));
	}

	private void createCellTituloscolumnPlazo2(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("plazo2"));
	}

	private void createCellTituloscolumnCete(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("cete"));
	}

	private void createCellTituloscolumnVariacion(Row row, int columnCount, Object value,
			Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("variacion"));
	}

	private void createCellWriteDataLines(Row row, int columnCount, Object value, CellStyle style) {
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



	public void writeDataLines() {

		LOGGER.info("Metodo - writeDataLines ");

		int rowCount = 10;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		if(listCetesVariacion.get(0).getListaCetes()!=null && listCetesVariacion.get(0).getListaCetes().size()>0) {
			
			for (int j = 0; j < listCetesVariacion.get(0).getListaCetes().size(); j++) {

				Row row = sheet.createRow(rowCount++);

				int columnCount = 0;
				int columnCount2 = 8;

				if (listCetesVariacion.get(0).getListaCetesVariacion().size() > j) {

					createCellWriteDataLines(row, columnCount++,
							listCetesVariacion.get(0).getListaCetesVariacion().get(j).getPlazo().intValue(), style);
					createCellWriteDataLines(row, columnCount++,
							String.valueOf(listCetesVariacion.get(0).getListaCetesVariacion().get(j).getTasa()).concat("%"),
							style);
					createCellWriteDataLines(row, columnCount++,
							listCetesVariacion.get(0).getListaCetesVariacion().get(j).getVariacion(), style);
				}

				createCellWriteDataLines(row, columnCount2++,
						listCetesVariacion.get(0).getListaCetes().get(j).getPlazo().intValue(), style);
				createCellWriteDataLines(row, columnCount2++,
						String.valueOf(listCetesVariacion.get(0).getListaCetes().get(j).getTasa()).concat("%"), style);

			}

		}
		else {			
			LOGGER.info("NO SE ENCONTRO INFORMACION POR IMPRIMIR EN REPORTE");			
		}	
	}

	public String createExcel() throws IOException {
		writeHeaderLine();
		writeDataLines();

		String directorio = new File("").getAbsolutePath();
		System.out.println(directorio + "\\campana_Cetes.xlsx");
		File fila = new File(directorio + "\\campana_Cetes.xlsx");
		fila.delete();
		FileOutputStream word = new FileOutputStream(directorio + "\\campana_Cetes.xlsx");
		workbook.write(word);
		byte[] input_file = Files.readAllBytes(Paths.get(directorio + "\\campana_Cetes.xlsx"));
		byte[] encodedBytes = Base64.getEncoder().encode(input_file);
		String encodedString = new String(encodedBytes);
		System.out.println("excel :: " + encodedString);
		word.close();

		return encodedString;

	}

}
