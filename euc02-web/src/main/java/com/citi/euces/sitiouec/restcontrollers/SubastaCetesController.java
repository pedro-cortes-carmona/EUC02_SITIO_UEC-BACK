package com.citi.euces.sitiouec.restcontrollers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.dto.AutoTasasVolumenInputDTO;
import com.citi.euces.sitiouec.dto.CetePaginaDTO;
import com.citi.euces.sitiouec.dto.HistoricoCetesDTO;
import com.citi.euces.sitiouec.dto.InputReportesCetesDTO;
import com.citi.euces.sitiouec.dto.ReporteCetesDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.CargarArchivoAutoTasa;
import com.citi.euces.sitiouec.models.CetesResponse;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.models.MensajeResponse;
import com.citi.euces.sitiouec.models.UpdateSubastaCetesRequest;
import com.citi.euces.sitiouec.services.CetesPDFExporterImprimir;
import com.citi.euces.sitiouec.services.CetesWordExporterImprimir;
import com.citi.euces.sitiouec.services.ReporteCetesExcelExporter;
import com.citi.euces.sitiouec.services.SubastaCetesImpl;

@RestController
@RequestMapping(path = SubastaCetesController.SUBASTA_CETES)
public class SubastaCetesController {
	
	private static final Logger LOGGER = LogManager.getLogger(SubastaCetesController.class);
	static final String SUBASTA_CETES = "/pagWebCetes";
	
	@Autowired(required = true)
	private SubastaCetesImpl subastaCetesImpl;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/historicoCetes")
	public ResponseEntity<?>listadoHistoricoCetes(){
		try {
			
			List<HistoricoCetesDTO> historicoCetesDTO = subastaCetesImpl.listadoSubastaCetes();
			return ResponseEntity.status(HttpStatus.OK).body(historicoCetesDTO);
			
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/excel/reporte/cetes")
	public ResponseEntity<?> imprimirReporteCetes(){
		try {			
			List<CetePaginaDTO> listaCetesVariacion = subastaCetesImpl.excelCetesVariacion();
			return ResponseEntity.status(HttpStatus.OK).body(listaCetesVariacion);			
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/excel/reporte/cetes/v2")
	public ResponseEntity<?> imprimirReporteCetes2(){
		try {			
			List<ReporteCetesDTO> lsReporteCetes = subastaCetesImpl.getSubastaCetes();
			return ResponseEntity.status(HttpStatus.OK).body(lsReporteCetes);			
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	
	/**
	 * Reporte en Excel para Cetes
	 * @param response
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/cetes/excel/v1")
	public void getSubastaCetes(HttpServletResponse response){
		try {			
			response.setContentType("application/octet-stream");
	        String name ="Cetes";
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Reporte_" + name + ".xlsx";
	        response.setHeader(headerKey, headerValue);
			
			List<ReporteCetesDTO> lsReporteCetes = subastaCetesImpl.getSubastaCetes();
			
			ReporteCetesExcelExporter reporte = new ReporteCetesExcelExporter(lsReporteCetes);			
			//reporte.export(response);
						
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());			
		}
	}
	
	/**
	 * Servicio que generara los 3 reportes de Cetes 
	 * para formatos en Excel, Word y PDF 
	 * 
	 * @param response
	 * @return
	 */
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/cetes/formatos/v2")
	public ResponseEntity<?> getSubastgaCetes2 (HttpServletResponse response, @Valid @RequestBody InputReportesCetesDTO input){
		try {	
			if(input.getTipo().equals("excel")) {
				List<ReporteCetesDTO> lsReporteCetes = subastaCetesImpl.getSubastaCetes();				
				ReporteCetesExcelExporter reporte = new ReporteCetesExcelExporter(lsReporteCetes);				
				if(lsReporteCetes.isEmpty()) {
					CetesResponse respo = new CetesResponse("NO SE ENCONTRO INFORMACION", "300");
					return ResponseEntity.status(HttpStatus.OK).body(respo);
				}else {
					CetesResponse respo = new CetesResponse(reporte.createExcel(), "200");
					return ResponseEntity.status(HttpStatus.OK).body(respo);	
				}				
			}else if(input.getTipo().equals("word")) {				
				List<ReporteCetesDTO> lsReporteCetes = subastaCetesImpl.getSubastaCetes();				
				CetesWordExporterImprimir reporte = new CetesWordExporterImprimir(lsReporteCetes);
				if(lsReporteCetes.isEmpty()) {
					CetesResponse respo = new CetesResponse("NO SE ENCONTRO INFORMACION", "300");
			        return ResponseEntity.status(HttpStatus.OK).body(respo);	
				}else {
					CetesResponse respo = new CetesResponse(reporte.createWord(), "200");
			        return ResponseEntity.status(HttpStatus.OK).body(respo);	
				}		        		        
			}else {				
				List<ReporteCetesDTO> lsReporteCetes = subastaCetesImpl.getSubastaCetes();				
				CetesPDFExporterImprimir imprimir = new CetesPDFExporterImprimir(lsReporteCetes);				
				if(lsReporteCetes.isEmpty()) {
					CetesResponse respo = new CetesResponse("NO SE ENCONTRO INFORMACION", "300");				
					return ResponseEntity.status(HttpStatus.OK).body(respo);					
				}else {
					CetesResponse respo = new CetesResponse(imprimir.createPdf(), "200");				
					return ResponseEntity.status(HttpStatus.OK).body(respo);
				}		
			}
				
									
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());	
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}		
	}
		
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/cetes/excel")
	public void generarReporteCetesExcel (HttpServletResponse response,@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) throws IOException, ParseException {
		
		response.setContentType("application/octet-stream");
        String name ="ReporteKPI";
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + name + ".xlsx";
        response.setHeader(headerKey, headerValue);        
				
    }
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/calcularCetes")
	public ResponseEntity<?> insertHistoricoCetes(@RequestBody final UpdateSubastaCetesRequest request){
		
		try {			
			MensajeResponse response = new MensajeResponse(subastaCetesImpl.insertHistoricoCetes(request.getFecha(), request.getCete1plazo(), request.getCete1tasa(), request.getCete2plazo(), request.getCete2tasa(), request.getCete3plazo(), request.getCete3tasa(), request.getCete4plazo(), request.getCete4tasa(), request.getSubasta4plazos()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setException(ex);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			LOGGER.info(error.getException());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}		
	}
	
	@PostMapping(path = "/cargarTxt", produces = "application/json")
	public ResponseEntity<?> cargaTasasCete(@RequestBody final CargarArchivoAutoTasa request){
		try {
			if(request.getFile().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(subastaCetesImpl.cargarAutoRangos(request.getFile(),request.getFecha_inicio(),request.getFecha_fin()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		}catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            LOGGER.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            LOGGER.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	
	
}
