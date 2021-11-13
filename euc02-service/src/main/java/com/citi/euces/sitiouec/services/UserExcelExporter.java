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

import com.citi.euces.sitiouec.dto.RegistrosTimeLineDTO;

public class UserExcelExporter {
	
	 private XSSFWorkbook workbook;
	 
	 private XSSFSheet sheet;
	 private List<RegistrosTimeLineDTO> lsRegistros;
	
	 public UserExcelExporter(List<RegistrosTimeLineDTO> lsRegistros) {
		super();
		this.lsRegistros = lsRegistros;
		workbook = new XSSFWorkbook();
	 }
	 	 
	 private void writeHeaderLine() {
	        sheet = workbook.createSheet("Users");
	         
	        Row row = sheet.createRow(0);
	         
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	         
	        createCell(row, 0, "idTasa", style);      
	        createCell(row, 1, "fechaEstatus", style);       
	        createCell(row, 2, "numCliente", style);    
	        createCell(row, 3, "contrato", style);
	        createCell(row, 4, "observaWeb", style);
	         
	    }
	 
	 
	  private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (value instanceof Integer) {
	            cell.setCellValue((Integer) value);
	        } else if (value instanceof Boolean) {
	            cell.setCellValue((Boolean) value);
	        }else {
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
	                 
	        for (RegistrosTimeLineDTO user : lsRegistros) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++, user.getIdTasa(), style);
	            createCell(row, columnCount++, user.getFechaEstatus(), style);
	            createCell(row, columnCount++, user.getNumCliente(), style);
	            createCell(row, columnCount++, user.getContrato().toString(), style);
	            createCell(row, columnCount++, user.getObservaWeb(), style);
	             
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
