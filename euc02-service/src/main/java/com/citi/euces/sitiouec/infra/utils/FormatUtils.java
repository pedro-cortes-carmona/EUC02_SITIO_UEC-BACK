package com.citi.euces.sitiouec.infra.utils;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatUtils {
	
	static final Logger log = LoggerFactory.getLogger(FormatUtils.class);
	
	public static Date stringToDate(String fecha) throws ParseException {
        String pattern = "dd/MM/yyyy";
        Date formatFecha = new SimpleDateFormat(pattern).parse(fecha);
        return formatFecha;
    }
	
	public static String obtenerMes(String nuMes) {
		String mes = "";
		
		switch(nuMes){
			case "01":
				mes = "ENERO";
				break;
			case "02":
				mes = "FEBRERO";
				break;
			case "03":
				mes = "MARZO";
				break;
			case "04":
				mes = "ABRIL";
				break;
			case "05":
				mes = "MAYO";
				break;
			case "06":
				mes = "JUNIO";
				break;
			case "07":
				mes = "JULIO";
				break;
			case "08":
				mes = "AGOSTO";
				break;
			case "09":
				mes = "SEPTIEMBRE";
				break;
			case "10":
				mes = "OCTUBRE";
				break;
			case "11":
				mes = "NOVIEMBRE";
				break;
			case "12":
				mes = "DICIEMBRE";
				break;
		}
		return mes;
	}
	
	
	public static Path convertZip(Path fileReporteRebaja) throws IOException {
        Path fileZip = Files.createTempFile("FileZip", ".zip");
        fileZip.toFile().deleteOnExit();
        byte[] buffer = new byte[1024];
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fileZip.toFile()));
            ZipEntry ze = new ZipEntry(fileReporteRebaja.toFile().getName());
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(fileReporteRebaja.toFile());
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            zos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileZip;
    }
	
	public static Path createExcel(List<String> titulos, List<List<String>> renglones, String nameFile ) throws IOException {
        Path testFile = Files.createTempFile("fileExcel", ".xlsx");
        try(XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet(nameFile);
            int colHeader = 0;
            Row rowheader = sheet.createRow(colHeader++);
            int colCell = 0;
            for (String field : titulos) {
                Cell cell = rowheader.createCell(colCell++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                }
            }
            int rowNum = 1;
            for (List<String> key : renglones) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String field : key) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            bos.close();
            Files.write(testFile, bos.toByteArray());
        }
        return testFile;
    }
	
	
	public static String seleccionarFecha(String fecha, Integer totalVenta)
    {
        String query = " ";
        switch (fecha)
        {                
            case "2021-05-03": query = query + " 2021_05_03 = " + totalVenta; break;
            case "2021-05-04": query = query + " 2021_05_04 = " + totalVenta; break;
            case "2021-05-05": query = query + " 2021_05_05 = " + totalVenta; break;
            case "2021-05-06": query = query + " 2021_05_06 = " + totalVenta; break;
            case "2021-05-07": query = query + " 2021_05_07 = " + totalVenta; break;

            case "2021-05-10": query = query + " 2021_05_10 = " + totalVenta; break;
            case "2021-05-11": query = query + " 2021_05_11 = " + totalVenta; break;
            case "2021-05-12": query = query + " 2021_05_12 = " + totalVenta; break;
            case "2021-05-13": query = query + " 2021_05_13 = " + totalVenta; break;
            case "2021-05-14": query = query + " 2021_05_14 = " + totalVenta; break;

            case "2021-05-17": query = query + " 2021_05_17 = " + totalVenta; break;
            case "2021-05-18": query = query + " 2021_05_18 = " + totalVenta; break;
            case "2021-05-19": query = query + " 2021_05_19 = " + totalVenta; break;
            case "2021-05-20": query = query + " 2021_05_20 = " + totalVenta; break;
            case "2021-05-21": query = query + " 2021_05_21 = " + totalVenta; break;

            case "2021-05-24": query = query + " 2021_05_24 = " + totalVenta; break;
            case "2021-05-25": query = query + " 2021_05_25 = " + totalVenta; break;
            case "2021-05-26": query = query + " 2021_05_26 = " + totalVenta; break;
            case "2021-05-27": query = query + " 2021_05_27 = " + totalVenta; break;
            case "2021-05-28": query = query + " 2021_05_28 = " + totalVenta; break;

            case "2021-05-31": query = query + " 2021_05_31 = " + totalVenta; break;
            case "2021-06-01": query = query + " 2021_06_01 = " + totalVenta; break;
            case "2021-06-02": query = query + " 2021_06_02 = " + totalVenta; break;
            case "2021-06-03": query = query + " 2021_06_03 = " + totalVenta; break;
            case "2021-06-04": query = query + " 2021_06_04 = " + totalVenta; break;

            case "2021-06-07": query = query + " 2021_06_07 = " + totalVenta; break;
            case "2021-06-08": query = query + " 2021_06_08 = " + totalVenta; break;
            case "2021-06-09": query = query + " 2021_06_09 = " + totalVenta; break;
            case "2021-06-10": query = query + " 2021_06_10 = " + totalVenta; break;
            case "2021-06-11": query = query + " 2021_06_11 = " + totalVenta; break;

            case "2021-06-14": query = query + " 2021_06_14 = " + totalVenta; break;
            case "2021-06-15": query = query + " 2021_06_15 = " + totalVenta; break;
            case "2021-06-16": query = query + " 2021_06_16 = " + totalVenta; break;
            case "2021-06-17": query = query + " 2021_06_17 = " + totalVenta; break;
            case "2021-06-18": query = query + " 2021_06_18 = " + totalVenta; break;

            case "2021-06-21": query = query + " 2021_06_21 = " + totalVenta; break;
            case "2021-06-22": query = query + " 2021_06_22 = " + totalVenta; break;
            case "2021-06-23": query = query + " 2021_06_23 = " + totalVenta; break;
            case "2021-06-24": query = query + " 2021_06_24 = " + totalVenta; break;
            case "2021-06-25": query = query + " 2021_06_25 = " + totalVenta; break;

            case "2021-06-28": query = query + " 2021_06_28 = " + totalVenta; break;
            case "2021-06-29": query = query + " 2021_06_29 = " + totalVenta; break;
            case "2021-06-30": query = query + " 2021_06_30 = " + totalVenta; break;
            case "2021-07-01": query = query + " 2021_07_01 = " + totalVenta; break;
            case "2021-07-02": query = query + " 2021_07_02 = " + totalVenta; break;

            case "2021-07-05": query = query + " 2021_07_05 = " + totalVenta; break;
            case "2021-07-06": query = query + " 2021_07_06 = " + totalVenta; break;
            case "2021-07-07": query = query + " 2021_07_07 = " + totalVenta; break;
            case "2021-07-08": query = query + " 2021_07_08 = " + totalVenta; break;
            case "2021-07-09": query = query + " 2021_07_09 = " + totalVenta; break;

            case "2021-07_12": query = query + " 2021_07_12 = " + totalVenta; break;
            case "2021-07-13": query = query + " 2021_07_13 = " + totalVenta; break;
            case "2021-07-14": query = query + " 2021_07_14 = " + totalVenta; break;
            case "2021-07-15": query = query + " 2021_07_15 = " + totalVenta; break;
            case "2021-07-16": query = query + " 2021_07_16 = " + totalVenta; break;

            case "2021-07-19": query = query + " 2021_07_19 = " + totalVenta; break;
            case "2021-07-20": query = query + " 2021_07_20 = " + totalVenta; break;
            case "2021-07-21": query = query + " 2021_07_21 = " + totalVenta; break;
            case "2021-07-22": query = query + " 2021_07_22 = " + totalVenta; break;
            case "2021-07-23": query = query + " 2021_07_23 = " + totalVenta; break;

            case "2021-07-26": query = query + " 2021_07_26 = " + totalVenta; break;
            case "2021-07-27": query = query + " 2021_07_27 = " + totalVenta; break;
            case "2021-07-28": query = query + " 2021_07_28 = " + totalVenta; break;
            case "2021-07-29": query = query + " 2021_07_29 = " + totalVenta; break;
            case "2021-07-30": query = query + " 2021_07_30 = " + totalVenta; break;
        }
        return query;
    }
	
	
	// Suma los días recibidos a la fecha  
	 public static Date sumarRestarDiasFecha(Date fecha, int dias){
	      Calendar calendar = Calendar.getInstance();
	      
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
	 
	      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	 }
}