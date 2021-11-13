package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.euces.sitiouec.dto.ReporteDetailDTO;


public class ReporteAccuracyExcelExporter {
	
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteAccuracyExcelExporter.class);

	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	private List<ReporteDetailDTO> lsDetailReport;
	
	private String fechaInicial;
	
	private String FechaFinal;
	
	public ReporteAccuracyExcelExporter(List<ReporteDetailDTO> lsDetailReport, String fechaInicial, String FechaFinal) {
		super();
		this.lsDetailReport = lsDetailReport;
		workbook = new XSSFWorkbook();
		this.fechaInicial=fechaInicial;
		this.FechaFinal=FechaFinal;

	}

	private void writeHeaderLine() {
		
		sheet = workbook.createSheet("Accuracy");

		int rowCount=0;
		
		Row row = sheet.createRow(rowCount);
		
		Map<String, CellStyle> styleFieldsColumnFecha = createStylesColumnFecha(workbook);		
		Map<String, CellStyle> styleFieldsColumnOperaciones = createStylesOperaciones(workbook);
		Map<String, CellStyle> styleFieldsColumnReprocesos = createStylesReprocesos(workbook);
		Map<String, CellStyle> styleFieldsColumnMeta = createStylesColumnMeta(workbook);
		Map<String, CellStyle> styleFieldsColumnAccuracy = createStylesAccuracy(workbook);
		Map<String, CellStyle> styleFieldsColumnTimeLiness = createStylesTimeLiness(workbook);
		
		

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		createCellWriteDataLines(row, 0, "Reprocesos" +  "     "  + fechaInicial  +   " " +   FechaFinal , style);
		
		rowCount=1;
		row = sheet.createRow(rowCount);

		createCellTituloscolumnFecha(row, 0, "Fecha", styleFieldsColumnFecha);
		createCellTitulosOperaciones(row, 1, "Operaciones Medidas", styleFieldsColumnOperaciones);
		createCellTitulosReprocesos(row, 2, "Reprocesos", styleFieldsColumnReprocesos);
		createCellTitulosMeta(row, 3, "Meta", styleFieldsColumnMeta);
		createCellTitulosAccuracy(row, 4, "Accuracy", styleFieldsColumnAccuracy);

		createCellTituloscolumnFecha(row, 6, "Fecha", styleFieldsColumnFecha);
		createCellTitulosOperaciones(row, 7, "Operaciones Medias", styleFieldsColumnOperaciones);
		createCellTitulosReprocesos(row, 8, "OutTime", styleFieldsColumnReprocesos);
		createCellTitulosMeta(row, 9, "Meta", styleFieldsColumnMeta);
		createCellTitulosTimeLiness(row, 10, "TimeLiness", styleFieldsColumnTimeLiness);

	}

	private void createCellTituloscolumnFecha(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("columnFecha"));		
	}
	
	private void createCellTitulosOperaciones(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("operaciones"));	
	}

	private void createCellTitulosReprocesos(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("reprocesos"));	
	}
	
	private void createCellTitulosMeta(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("meta"));	
	}
	
	private void createCellTitulosAccuracy(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("accuracy"));	
	}
	
	
	private void createCellTitulosTimeLiness(Row row, int columnCount, Object value, Map<String, CellStyle> styles) {
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
		cell.setCellStyle(styles.get("times"));	
	}

    
    private Map<String, CellStyle> createStylesColumnFecha(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        

        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("columnFecha", style);
        
       

        return styles;
    }
    
    
    private Map<String, CellStyle> createStylesOperaciones(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        

        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("operaciones", style);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        
       

        return styles;
    }
    
    private Map<String, CellStyle> createStylesReprocesos(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        

        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("reprocesos", style);
        
       

        return styles;
    }
    
    
    private Map<String, CellStyle> createStylesColumnMeta(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();


        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("meta", style);
        
       

        return styles;
    }
       
    private Map<String, CellStyle> createStylesAccuracy(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        

        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);        
        style.setFont(headerFont);
        styles.put("accuracy", style);
        
        return styles;
    }
    
    private Map<String, CellStyle> createStylesTimeLiness(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        
        CellStyle style = workbook.createCellStyle();
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);        
        style.setFont(headerFont);
        styles.put("times", style);
        
        return styles;
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

    
	private void writeDataLines() {
		int rowCount = 2;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (int j = 0; j < lsDetailReport.get(0).getLsDiasAccuracy().size(); j++) {
			
			    Row row = sheet.createRow(rowCount++);
			
			    int columnCount = 0;
			    int columnCount2 = 6;
			   
			    createCellWriteDataLines(row, columnCount++, lsDetailReport.get(0).getLsDiasAccuracy().get(j).getFecha(), style);
			    createCellWriteDataLines(row, columnCount++, String.valueOf(lsDetailReport.get(0).getLsDiasAccuracy().get(j).getVolumen()), style);
			    createCellWriteDataLines(row, columnCount++, String.valueOf(lsDetailReport.get(0).getLsDiasAccuracy().get(j).getCntRepro()), style);
			    createCellWriteDataLines(row, columnCount++, String.valueOf(lsDetailReport.get(0).getLsDiasAccuracy().get(j).getMeta()).concat("%"), style);
			    createCellWriteDataLines(row, columnCount++, String.valueOf(lsDetailReport.get(0).getLsDiasAccuracy().get(j).getPorcenAccuracy()).concat("%"), style);
				
			    createCellWriteDataLines(row, columnCount2++, lsDetailReport.get(0).getLsDiasTimes().get(j).getFecha(), style);
			    createCellWriteDataLines(row, columnCount2++, String.valueOf(lsDetailReport.get(0).getLsDiasTimes().get(j).getVolumen()), style);
			    createCellWriteDataLines(row, columnCount2++, String.valueOf(lsDetailReport.get(0).getLsDiasTimes().get(j).getCntTimeliness()), style);
			    createCellWriteDataLines(row, columnCount2++, String.valueOf(lsDetailReport.get(0).getLsDiasTimes().get(j).getMeta()).concat("%"), style);
			    createCellWriteDataLines(row, columnCount2++, String.valueOf(lsDetailReport.get(0).getLsDiasTimes().get(j).getPorcenTimeliness()).concat("%"), style);

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
