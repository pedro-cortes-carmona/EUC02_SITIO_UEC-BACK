package com.citi.euces.sitiouec.restcontrollers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.citi.euces.sitiouec.dto.ActualizarAsignacionesInputDTO;
import com.citi.euces.sitiouec.dto.ActualizarFechasFestivasDTO;
import com.citi.euces.sitiouec.dto.ActualizarSoeidAtendidoInputDTO;
import com.citi.euces.sitiouec.dto.ActualizarSolicitudKPIDTO;
import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AsignacionesSoeidInputDTO;
import com.citi.euces.sitiouec.dto.AutoAutorizadorDTO;
import com.citi.euces.sitiouec.dto.AutoCetesDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.AutoTasasEmailDTO;
import com.citi.euces.sitiouec.dto.AutoTasasInputDTO;
import com.citi.euces.sitiouec.dto.AutoTasasVolumenInputDTO;
import com.citi.euces.sitiouec.dto.AutorizadorElegidoDTO;
import com.citi.euces.sitiouec.dto.CompletarInformacionKPIDTO;
import com.citi.euces.sitiouec.dto.DivisionesInputDTO;
import com.citi.euces.sitiouec.dto.EjecutivosAsignacionesInputDTO;
import com.citi.euces.sitiouec.dto.EjecutivosInputDTO;
import com.citi.euces.sitiouec.dto.EliminarClienteRepetidosDTO;
import com.citi.euces.sitiouec.dto.EliminarContratosRepetidosDTO;
import com.citi.euces.sitiouec.dto.EliminarRegistrosObservacionesDTO;
import com.citi.euces.sitiouec.dto.EliminarReprocesosTimeLinessDTO;
import com.citi.euces.sitiouec.dto.EmailAprobacionResponseDTO;
import com.citi.euces.sitiouec.dto.EmailAprobacionTasaEspecialDTO;
import com.citi.euces.sitiouec.dto.EstatusClienteDTO;
import com.citi.euces.sitiouec.dto.EstatusEjecutivoInputDTO;
import com.citi.euces.sitiouec.dto.FechasFestivasDTO;
import com.citi.euces.sitiouec.dto.FechasInputDTO;
import com.citi.euces.sitiouec.dto.FolioNumAutorizacionDTO;
import com.citi.euces.sitiouec.dto.FolioNumInputDTO;
import com.citi.euces.sitiouec.dto.HistoricoAsignacionesDTO;
import com.citi.euces.sitiouec.dto.HistoricoAsignacionesInputDTO;
import com.citi.euces.sitiouec.dto.HistoricoCetesResponseBEDTO;
import com.citi.euces.sitiouec.dto.InsertarReprocesosDTO;
import com.citi.euces.sitiouec.dto.InsertarTimeLinessDTO;
import com.citi.euces.sitiouec.dto.ListaUsuariosSoeidDTO;
import com.citi.euces.sitiouec.dto.MontoPlazoTasaCampanaDTO;
import com.citi.euces.sitiouec.dto.ObtenerAutorizadorInputDTO;
import com.citi.euces.sitiouec.dto.PerCatParametrosDTO;
import com.citi.euces.sitiouec.dto.PerCatSucursalesInputDTO;
import com.citi.euces.sitiouec.dto.PetCatEjecutivoSucursalCampanaDTO;
import com.citi.euces.sitiouec.dto.RegistrosTimeLineDTO;
import com.citi.euces.sitiouec.dto.ReporteAccuracyDTO;
import com.citi.euces.sitiouec.dto.ReporteDetailDTO;
import com.citi.euces.sitiouec.dto.ReporteEjecutivoKPIDTO;
import com.citi.euces.sitiouec.dto.ReporteWeekDTO;
import com.citi.euces.sitiouec.dto.ResponseActualizarSolicitudDTO;
import com.citi.euces.sitiouec.dto.ResponseBorradoExitosoDTO;
import com.citi.euces.sitiouec.dto.ResponseGuardarFechaDTO;
import com.citi.euces.sitiouec.dto.ResponseInsertExitosoDTO;
import com.citi.euces.sitiouec.dto.ResponseSinDatosDTO;
import com.citi.euces.sitiouec.dto.SoeidInputEjecutivoDTO;
import com.citi.euces.sitiouec.dto.SubastaCetesDTO;
import com.citi.euces.sitiouec.dto.TasasDTO;
import com.citi.euces.sitiouec.dto.TasasInputDTO;
import com.citi.euces.sitiouec.dto.TasasReprocesoDTO;
import com.citi.euces.sitiouec.dto.TasasTimeLinessDTO;
import com.citi.euces.sitiouec.dto.UsuariosActivosInputDTO;
import com.citi.euces.sitiouec.entities.FechasFestivas;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.infra.utils.MensajesUtils;
import com.citi.euces.sitiouec.models.ErrorGeneric;

import com.citi.euces.sitiouec.models.HistoricoCetesResponse;
import com.citi.euces.sitiouec.models.MensajeResponse;
 
import com.citi.euces.sitiouec.models.MensajeResponseDivisiones;
import com.citi.euces.sitiouec.services.CetesServiceImpl;
import com.citi.euces.sitiouec.services.CetesWordExporter;
import com.citi.euces.sitiouec.services.EmailTemplateAprobacionServiceImpl;
import com.citi.euces.sitiouec.services.PerCatFolioSolicitudesUECServiceImpl;
import com.citi.euces.sitiouec.services.PerCatSucursalesServiceImpl;
import com.citi.euces.sitiouec.services.PetCatEjecutivoSucursalCampanaServiceImpl;
import com.citi.euces.sitiouec.services.ReporteAccuracyExcelExporter;
import com.citi.euces.sitiouec.services.ReporteHistoricoAsignacionesExcelExporter;
import com.citi.euces.sitiouec.services.ReporteKPIEjecutivoExcelExporter;
import com.citi.euces.sitiouec.services.ReporteKPIExcelExporter;
import com.citi.euces.sitiouec.services.TasasServiceImpl;
import com.citi.euces.sitiouec.services.UserExcelExporter;
import com.itextpdf.text.DocumentException;

/**
 * 
 * @author cesar.alducin
 *
 */
@RestController
@RequestMapping(path = SitioUEController.SITIOUEC_RESOURCE)
public class SitioUEController {

	private static final Logger LOGGER = LogManager.getLogger(SitioUEController.class);
	static final String SITIOUEC_RESOURCE = "/sitioUEC";

	@Autowired(required = true)
	private TasasServiceImpl tasasServiceImpl;
	
	@Autowired
	private CetesServiceImpl cetesServiceImpl;
	
	@Autowired
	private EmailTemplateAprobacionServiceImpl emailAprobacion;
	
	@Autowired
	private PetCatEjecutivoSucursalCampanaServiceImpl ejecutivoSucursal;
	
	@Autowired
	private PerCatSucursalesServiceImpl perCatSucursalesServiceImpl;
	
	@Autowired
	private PerCatFolioSolicitudesUECServiceImpl perCatFolioSolicitudesUECServiceImpl;
	
	
	/**
	 * Servicio que corresponde la historia de Usuario 
	 * Página Web Accuracy
	 * 
	 * Archivo : Accuracy.aspx del código .NET
	 * 
	 * @param autoTasasInput
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/contratos/repetidos/mis")
	public ResponseEntity<?> getContratosRepetidosMis(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			
			List<TasasDTO> lsAutoTasas = tasasServiceImpl.getContratosRepetidosCampana(autoTasasInput.getFechaInicial(),autoTasasInput.getFechaFinal());
			
			if(lsAutoTasas==null || lsAutoTasas.size()<=0) {
				responseSinDatosDTO.setSinRegistrosContratosRpetidos(MensajesUtils.NOSEENCONTRARONREGISTROSCONTRATOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoTasas);
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
	 * Servicio que corresponde la historia de Usuario 
	 * Página Web Accuracy
	 * 
	 * Archivo : Accuracy.aspx del código .NET
	 * 
	 * @param autoTasasInput
	 * @return
	 */	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/contratos/repetidos/operativo")
	public ResponseEntity<?> getContratosRepetidosOperativo(@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasDTO> lsAutoTasas = tasasServiceImpl.getContratosRepetidosOperativo(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
			
			if(lsAutoTasas==null || lsAutoTasas.size()<=0) {
				responseSinDatosDTO.setSinRegistrosContratosRpetidos(MensajesUtils.NOSEENCONTRARONREGISTROSCONTRATOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoTasas);
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
	 * Servicio que corresponde la historia de Usuario 
	 * Página Web Accuracy
	 * 
	 * Archivo : Accuracy.aspx del código .NET
	 * 
	 * @param autoTasasInput
	 * @return
	 */		
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/clientes/repetidos/mis")
	public ResponseEntity<?> getClientesRepetidosMis(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<TasasDTO> lsClientesRepTasas = tasasServiceImpl.getClientesRepetidosCampana(autoTasasInput.getFechaInicial(),autoTasasInput.getFechaFinal());
			
			if(lsClientesRepTasas==null || lsClientesRepTasas.size()<=0) {
				responseSinDatosDTO.setSinRegistrosClientesRepetidos(MensajesUtils.NOSEENCONTRARONREGISTROSCIENTES);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			
			return ResponseEntity.status(HttpStatus.OK).body(lsClientesRepTasas);
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
	 * Servicio que corresponde la historia de Usuario 
	 * Página Web Accuracy
	 * 
	 * Archivo : Accuracy.aspx del código .NET
	 * 
	 * @param autoTasasInput
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/clientes/repetidos/operativo")
	public ResponseEntity<?> getClientesRepetidosOperativo(@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasDTO> lsClientesRepOperativo = tasasServiceImpl.getClientesRepetidosOperativo(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
			
			if(lsClientesRepOperativo==null || lsClientesRepOperativo.size()<=0) {
				responseSinDatosDTO.setSinRegistrosClientesRepetidos(MensajesUtils.NOSEENCONTRARONREGISTROSCIENTES);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			LOGGER.info("getClientesRepetidosOperativo Size() " + " " +lsClientesRepOperativo.size());
			
			return ResponseEntity.status(HttpStatus.OK).body(lsClientesRepOperativo);
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
	 * Servicio que corresponde la historia de Usuario 
	 * Página Web Accuracy
	 * 
	 * Archivo : Accuracy.aspx del código .NET
	 * 
	 * @param autoTasasInput
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/registro/observaciones/tasaOperativa")
	public ResponseEntity<?> getRegistroObservacionesTasaOperativa(@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasDTO> lsRegistrosOb = tasasServiceImpl.getRegistroObservacionesTasaOperativa(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
			
			if(lsRegistrosOb==null || lsRegistrosOb.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			
			return ResponseEntity.status(HttpStatus.OK).body(lsRegistrosOb);
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
	 * 
	 * @param autoTasasInputDTO
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/registros/timeLiness")
	public ResponseEntity<?> getRegistrosTimeLines(@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<RegistrosTimeLineDTO> lsRegistrosTime = tasasServiceImpl.getRegistrosTimeLines(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
			
			if(lsRegistrosTime==null || lsRegistrosTime.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			
			return ResponseEntity.status(HttpStatus.OK).body(lsRegistrosTime);
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
	 * 
	 * @param autoTasasInput
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/datos/repetidos/montoPlazoTasa")
	public ResponseEntity<?> getMontoPlazoTasaRepetidoCampana(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<MontoPlazoTasaCampanaDTO> lsMontoPlazoTasa = tasasServiceImpl.getMontoPlazoTasaRepetidoCampana(autoTasasInput.getFechaInicial(), autoTasasInput.getFechaFinal());
			
			if(lsMontoPlazoTasa==null || lsMontoPlazoTasa.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			
			
			return ResponseEntity.status(HttpStatus.OK).body(lsMontoPlazoTasa);
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
	@PostMapping(path = "/resumen/accuracy")
	public void exportResumen (HttpServletResponse response,@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) throws IOException {
		
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        List<RegistrosTimeLineDTO> lsRegistrosTime = 
        		tasasServiceImpl.getRegistrosTimeLines(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
        
        UserExcelExporter excelExporter = new UserExcelExporter(lsRegistrosTime);
        excelExporter.export(response);    
           
     }   
		
	/**
	 * Servicio para obtener los Procesos Almacenados
	 * @param autoTasasInput
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/datos/reprocesos")
	public ResponseEntity<?> getReprocesosPorFecha(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			List<TasasReprocesoDTO> lsReprocesos = tasasServiceImpl.getReprocesosPorFecha(autoTasasInput.getFechaInicial(),autoTasasInput.getFechaFinal());
			return ResponseEntity.status(HttpStatus.OK).body(lsReprocesos);
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
	 * 
	 * @param autoTasasInput
	 * @return
	 * 
	 * Cuando se almacenan los datos que son Re procesos
	 * se consulta el siguiente servicio para saber cuales fueron los procesados.
	 * 
	 * Al dar click en el botón Almacenar registros,
     * Y sólo guarda los registros marcados, y los muestra en la pantalla
     * de Registros Recolectados (GRID DE TIMELINESS).
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/datos/timeLiness")
	public ResponseEntity<?> getTimelinessPorFecha(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			List<TasasTimeLinessDTO> lsTimeLiness = tasasServiceImpl.getTimelinessPorFecha(autoTasasInput.getFechaInicial(), autoTasasInput.getFechaFinal());
			return ResponseEntity.status(HttpStatus.OK).body(lsTimeLiness);
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
	@PostMapping(path = "/datos/volumen/fecha")
	public ResponseEntity<?> getVolumenPorFecha(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			Integer countTimesLiness = tasasServiceImpl.getVolumenPorFecha(autoTasasInput.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(countTimesLiness);
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
	@PostMapping(path = "/reporte/accuracy")
	public ResponseEntity<?> getReporteAccuracy(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			
			List<ReporteAccuracyDTO> lsDiasAccuracy = tasasServiceImpl.reporteDiasAccuracy(autoTasasInput.getFechaInicial(), autoTasasInput.getFechaFinal());
			
			List<ReporteAccuracyDTO> lsDiasTimes = tasasServiceImpl.reporteTimesAccuracy(autoTasasInput.getFechaInicial(), autoTasasInput.getFechaFinal());
			
			List<ReporteDetailDTO> lsDetailReport = new ArrayList<>();
			
			ReporteDetailDTO detail = new ReporteDetailDTO();
			detail.setLsDiasAccuracy(lsDiasAccuracy);
			detail.setLsDiasTimes(lsDiasTimes);
			
			lsDetailReport.add(detail);			
			
			return ResponseEntity.status(HttpStatus.OK).body(lsDetailReport);
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
	 * 
	 * @param response
	 * @param tasasInputDTO
	 * @throws IOException
	 * @throws ParseException
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/resumen/accuracy/excel")
	public void getReporteAccuracyExcel (HttpServletResponse response,@Valid @RequestBody TasasInputDTO tasasInputDTO) throws IOException, ParseException {
		
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        
        List<ReporteAccuracyDTO> lsDiasAccuracy = tasasServiceImpl.reporteDiasAccuracy(tasasInputDTO.getFechaInicial(), tasasInputDTO.getFechaFinal());
		
		List<ReporteAccuracyDTO> lsDiasTimes = tasasServiceImpl.reporteTimesAccuracy(tasasInputDTO.getFechaInicial(), tasasInputDTO.getFechaFinal());
		
		List<ReporteDetailDTO> lsDetailReport = new ArrayList<>();
		
		ReporteDetailDTO detail = new ReporteDetailDTO();
		detail.setLsDiasAccuracy(lsDiasAccuracy);
		detail.setLsDiasTimes(lsDiasTimes);
		
		lsDetailReport.add(detail);
		
		ReporteAccuracyExcelExporter excelReport = new ReporteAccuracyExcelExporter(lsDetailReport,tasasInputDTO.getFechaInicial(), tasasInputDTO.getFechaFinal());
		excelReport.export(response);
				
     }   
	
	
	/**
	 * 
	 * @param response
	 * @param tasasInputDTO
	 * @throws IOException
	 * @throws ParseException
	 * 
	 * Reporte KPI Excel
	 */
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/excel")
	public void generarReporteKPIExcel (HttpServletResponse response,@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) throws IOException, ParseException {
		
		response.setContentType("application/octet-stream");
        String name ="ReporteKPI";
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + name + ".xlsx";
        response.setHeader(headerKey, headerValue);
       
        List<ReporteWeekDTO> listaWeek  = tasasServiceImpl.generarReporteKPI(autoTasasVolumenInputDTO.getFechaInicial());
        
        Map<String, List<ReporteEjecutivoKPIDTO>> mapGente  = tasasServiceImpl.generarReporteEjecutivo(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getLsUsuariosSoeid());
        
        ReporteKPIExcelExporter excelReport = new ReporteKPIExcelExporter(listaWeek,autoTasasVolumenInputDTO.getFechaInicial(),mapGente);
        excelReport.export(response);
				
     }
	
	
	/**
	 * 
	 * @param response
	 * @param autoTasasVolumenInputDTO
	 * @throws IOException
	 * @throws ParseException
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/semanal/excel")
	public void generarReporteKPISemanalExcel (HttpServletResponse response,@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) throws IOException, ParseException {
		
		response.setContentType("application/octet-stream");
        String name ="ReporteKPI";
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + name + ".xlsx";
        response.setHeader(headerKey, headerValue);
       
        List<ReporteWeekDTO> listaWeek  = tasasServiceImpl.generarReporteKPISemanal(autoTasasVolumenInputDTO.getFechaInicial());
        
        Map<String, List<ReporteEjecutivoKPIDTO>> mapGente  = tasasServiceImpl.generarReporteEjecutivo(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getLsUsuariosSoeid());
        
        ReporteKPIExcelExporter excelReport = new ReporteKPIExcelExporter(listaWeek,autoTasasVolumenInputDTO.getFechaInicial(),mapGente);
        excelReport.export(response);
				
     }
	
	
	/**
	 * 
	 * @param autoTasasVolumenInputDTO
	 * @return
	 * 
	 * Reporte KPI por ejecutivo UEC 
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/ejecutivo/excel")
	public void generarReporteEjecutivoExcel(HttpServletResponse response,@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) 
			throws ParseException, IOException {
		
		response.setContentType("application/octet-stream");
        String name ="ReporteKPI";
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + name + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        Map<String, List<ReporteEjecutivoKPIDTO>> mapGente  = tasasServiceImpl.generarReporteEjecutivo(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getLsUsuariosSoeid());
        
        ReporteKPIEjecutivoExcelExporter excelReport = new ReporteKPIEjecutivoExcelExporter(mapGente);
        excelReport.export(response);
        
	}
	
	
	/**
	 * 
	 * @param autoTasasVolumenInputDTO
	 * @return
	 * 
	 * Reporte KPI por ejecutivo UEC 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/ejecutivo")
	public ResponseEntity<?> generarReporteEjecutivo(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Map<String, List<ReporteEjecutivoKPIDTO>> mapGente  = tasasServiceImpl.generarReporteEjecutivo(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getLsUsuariosSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(mapGente);
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
	 * 
	 * @param autoTasasVolumenInputDTO
	 * @return
	 * 
	 * Reporte KPI semanal 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/semanal")
	public ResponseEntity<?> generarReporteKPISemanal(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			List<ReporteWeekDTO> listaWeek  = tasasServiceImpl.generarReporteKPISemanal(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(listaWeek);
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
	 * 
	 * @param autoTasasVolumenInputDTO
	 * @return
	 * 
	 * Reporte KPI
	 * Calcula los indicadores de desempeño de las operaciones de inversion 
	 * 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI")
	public ResponseEntity<?> generarReporteKPI(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			List<ReporteWeekDTO> listaWeek  = tasasServiceImpl.generarReporteKPI(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(listaWeek);
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
	@PostMapping(path = "/volumen/asignadas")
	public ResponseEntity<?> getVolumenAsignadas(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer countVolumenAsignadas = tasasServiceImpl.getVolumenAsignadas(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(countVolumenAsignadas);
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
	@PostMapping(path = "/volumen/operadas")
	public ResponseEntity<?> getVolumenOperadas(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer countVolumenOperadas = tasasServiceImpl.getVolumenOperadas(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(countVolumenOperadas);
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
	@PostMapping(path = "/volumen/reproceso")
	public ResponseEntity<?> getVolumenReproceso(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer countVolumenReproceso = tasasServiceImpl.getVolumenReproceso(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(countVolumenReproceso);
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
	@PostMapping(path = "/volumen/timeLiness")
	public ResponseEntity<?> getVolumenTimeliness(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer countVolumenTimeLiness = tasasServiceImpl.getVolumenTimeliness(autoTasasVolumenInputDTO.getFechaInicial(),autoTasasVolumenInputDTO.getSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(countVolumenTimeLiness);
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
	@PostMapping(path = "/obtener/volumen")
	public ResponseEntity<?> obtenerVolumen(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer volumen = tasasServiceImpl.obtenerVolumen(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(volumen);
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
	@PostMapping(path = "/obtener/monto")
	public ResponseEntity<?> obtenerMonto(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer monto = tasasServiceImpl.obtenerMonto(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(monto);
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
	@PostMapping(path = "/obtener/timeliness")
	public ResponseEntity<?> obtenerVolTimeliness(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer volumen = tasasServiceImpl.obtenerVolTimeliness(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(volumen);
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
	@PostMapping(path = "/obtener/accuracy")
	public ResponseEntity<?> obtenerVolAccuracy(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer accuracy = tasasServiceImpl.obtenerVolAccuracy(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(accuracy);
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
	@PostMapping(path = "/obtener/operadoresDia")
	public ResponseEntity<?> obtenerOperadoresporDia(@Valid @RequestBody AutoTasasVolumenInputDTO autoTasasVolumenInputDTO) {
		try {
			Integer operadores = tasasServiceImpl.obtenerOperadoresporDia(autoTasasVolumenInputDTO.getFechaInicial());
			return ResponseEntity.status(HttpStatus.OK).body(operadores);
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
	 * 
	 * @param autoTasasInput
	 * @return
	 * 
	 * Complementar la información de las solicitudes sin SOEID
	 * asignado de origen 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/reporte/KPI/complemento")
	public ResponseEntity<?> reporteComplementoKPI(@Valid @RequestBody TasasInputDTO autoTasasInput) {
		try {
			List<CompletarInformacionKPIDTO> lsCompletarInfo  = tasasServiceImpl.reporteComplementoKPI(autoTasasInput.getFechaInicial(),autoTasasInput.getFechaFinal());
			return ResponseEntity.status(HttpStatus.OK).body(lsCompletarInfo);
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
	@PostMapping(path = "/obtener/fechas")
	public ResponseEntity<?> obtenerListaFechas() {
		try {
			List<FechasFestivasDTO> lsFechasFestivas  = tasasServiceImpl.obtenerListaFechas();
			return ResponseEntity.status(HttpStatus.OK).body(lsFechasFestivas);
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
	@PostMapping(path = "/guardar/fecha")
	public ResponseEntity<?> guardarFecha(@Valid @RequestBody FechasFestivasDTO fechasFestivasDTO) {
		try {
			ResponseGuardarFechaDTO responseGuardarFechaDTO = new ResponseGuardarFechaDTO();
			FechasFestivas          fechasFestivas          = new FechasFestivas();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(fechasFestivasDTO.getFechaDescrip());			
			fechasFestivas.setFecha(date);
			fechasFestivas.setDescripcion(fechasFestivasDTO.getDescripcion());			
			tasasServiceImpl.guardarFecha(fechasFestivas);			
			responseGuardarFechaDTO.setDescripcion(MensajesUtils.FECHAGUARDADOEXITO);
			responseGuardarFechaDTO.setRespuesta(0);
			return ResponseEntity.status(HttpStatus.OK).body(responseGuardarFechaDTO);
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
	@PostMapping(path = "/actualizar/solicitudKPI")
	public ResponseEntity<?> complementarSolicitudKPI(@Valid @RequestBody ActualizarSolicitudKPIDTO solicitudDTO) {
		try {			
			ResponseActualizarSolicitudDTO responseSolicitud = new ResponseActualizarSolicitudDTO();
			int res = tasasServiceImpl.complementarSolicitudKPI(solicitudDTO);
			responseSolicitud.setDescripcion(res==1?MensajesUtils.SOLICITUDACTUALIZADAEXITO:MensajesUtils.NOSEENCONTROID);
			responseSolicitud.setRespuesta(0);
			return ResponseEntity.status(HttpStatus.OK).body(responseSolicitud);
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
	@PostMapping(path = "/editar/fechasFestivas")
	public ResponseEntity<?> editarFechasFestivas(@Valid @RequestBody ActualizarFechasFestivasDTO editarFechas) {
		try {			
			ResponseActualizarSolicitudDTO responseSolicitud = new ResponseActualizarSolicitudDTO();
			int res = tasasServiceImpl.editarFechasFestivas(editarFechas);
			responseSolicitud.setDescripcion(res==1?MensajesUtils.FECHAEDITADAEXITO:MensajesUtils.NOSEENCONTROID);
			responseSolicitud.setRespuesta(res);
			return ResponseEntity.status(HttpStatus.OK).body(responseSolicitud);
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
	@PostMapping(path = "/borrar/fecha")
	public ResponseEntity<?> borrarFecha(@Valid @RequestBody FechasFestivasDTO fechasFestivasDTO) {
		try {
			ResponseGuardarFechaDTO responseGuardarFechaDTO = new ResponseGuardarFechaDTO();
			int res  = tasasServiceImpl.borrarFecha(fechasFestivasDTO.getIdFecha());
			responseGuardarFechaDTO.setRespuesta(res);
			responseGuardarFechaDTO.setDescripcion(res==1?MensajesUtils.FECHAELIMINAREXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseGuardarFechaDTO);
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
	@PostMapping(path = "/borrar/contratos/repetidos")
	public ResponseEntity<?> borrarContratosRepetidos(@Valid @RequestBody EliminarContratosRepetidosDTO eliminarDTO) {
		try {
			ResponseBorradoExitosoDTO responseExitoso = new ResponseBorradoExitosoDTO();
			int res  = tasasServiceImpl.borrarContratosRepetidos(eliminarDTO.getLsContratosRepetidos());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.CONTRATOREPETIDOEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/borrar/clientes/repetidos")
	public ResponseEntity<?> borrarClienteRepetidos(@Valid @RequestBody EliminarClienteRepetidosDTO eliminarDTO) {
		try {
			ResponseBorradoExitosoDTO responseExitoso = new ResponseBorradoExitosoDTO();
			int res  = tasasServiceImpl.borrarClienteRepetidos(eliminarDTO.getLsClientesRepetidos());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.CONTRATOREPETIDOEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/borrar/registros/observaciones")
	public ResponseEntity<?> borrarObservacionesDigitosEnTasa(@Valid @RequestBody EliminarRegistrosObservacionesDTO eliminarDTO) {
		try {
			ResponseBorradoExitosoDTO responseExitoso = new ResponseBorradoExitosoDTO();
			int res  = tasasServiceImpl.borrarObservacionesDigitosEnTasa(eliminarDTO.getLsRegistros());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.ELIMINADOCONEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/usuarios/soeid")
	public ResponseEntity<?> getUsuariosSoeid(@Valid @RequestBody AutoTasasInputDTO autoTasasInputDTO) {
		try {
			List<ListaUsuariosSoeidDTO> lsUsuariosSoeid = tasasServiceImpl.getUsuariosSoeid(autoTasasInputDTO.getFechaInicial(),autoTasasInputDTO.getFechaFinal());
			return ResponseEntity.status(HttpStatus.OK).body(lsUsuariosSoeid);
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
	@PostMapping(path = "/usuarios/activos/KPI")
	public ResponseEntity<?> getUsuariosSoeidKPI(@Valid @RequestBody UsuariosActivosInputDTO usuariosActivosInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<ListaUsuariosSoeidDTO> lsUsuariosSoeid = tasasServiceImpl.getUsuariosSoeidActivos(usuariosActivosInputDTO.getFechaInicial());
			
			if(lsUsuariosSoeid.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINUSUARIOSACTIVOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);		
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(lsUsuariosSoeid);
			
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
	@PostMapping(path = "/nombre/soeid")
	public ResponseEntity<?> getNombreSoeidAsignacion(@Valid @RequestBody AsignacionesDTO asignacionesDTO) {
		try {
			AsignacionesDTO asignacion = tasasServiceImpl.getNombreSoeidAsignacion(asignacionesDTO.getSoeid());
			return ResponseEntity.status(HttpStatus.OK).body(asignacion);
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
	@PostMapping(path = "/listado/parametros")
	public ResponseEntity<?> getParametros() {
		try {
			List<PerCatParametrosDTO> parametros = tasasServiceImpl.getParametros();
			return ResponseEntity.status(HttpStatus.OK).body(parametros);
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
	@PostMapping(path = "/insertar/timeLiness")
	public ResponseEntity<?> insertarTimeLiness(@Valid @RequestBody InsertarTimeLinessDTO insertarDTO) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = tasasServiceImpl.insertarTimeLiness(insertarDTO.getLsTimeLiness());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.TIMElINESSEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/insertar/reprocesos")
	public ResponseEntity<?> insertarReprocesos(@Valid @RequestBody InsertarReprocesosDTO insertarDTO) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = tasasServiceImpl.insertarReprocesos(insertarDTO.getLsReprocesos());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.REPROCESOEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/eliminar/reprocesos")
	public ResponseEntity<?> eliminarReprocesos(@Valid @RequestBody EliminarReprocesosTimeLinessDTO eliminarDTO) {
		try {
			ResponseBorradoExitosoDTO responseExitoso = new ResponseBorradoExitosoDTO();
			int res  = tasasServiceImpl.eliminarReprocesos(eliminarDTO.getLsRegistros());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.REGISTROSEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/eliminar/timeLiness")
	public ResponseEntity<?> eliminarTimeLiness(@Valid @RequestBody EliminarReprocesosTimeLinessDTO eliminarDTO) {
		try {
			ResponseBorradoExitosoDTO responseExitoso = new ResponseBorradoExitosoDTO();
			int res  = tasasServiceImpl.eliminarTimeLiness(eliminarDTO.getLsRegistros());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.REGISTROSEXITO:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/historico/cetes")
	public ResponseEntity<?> getSubastaCetes() {
		try {
			
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();			
			List<SubastaCetesDTO> lsSubasta = cetesServiceImpl.getSubastaCetes();
			
			if(lsSubasta==null || lsSubasta.size()<=0) {
				responseSinDatosDTO.setSinRegistrosSubastas(MensajesUtils.NOSEENCONTRARONREGISTROSSUBASTAS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(lsSubasta);
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
	@PostMapping(path = "/obtener/autocetes")
	public ResponseEntity<?> getAutoCetes() {
		try {
			
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();			
			List<AutoCetesDTO> lsAutoCetes = cetesServiceImpl.getAutoCetes();
			
			if(lsAutoCetes==null || lsAutoCetes.size()<=0) {
				responseSinDatosDTO.setSinRegistrosAutoCetes(MensajesUtils.NOSEENCONTRARONREGISTROSCETES);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}			
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoCetes);
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
	 * No tocar este servicio 
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/obtener/autocetes/word", produces = "application/json")
	public ResponseEntity<?> getAutoCetesWord (@RequestBody final HistoricoCetesResponseBEDTO request) throws IOException, ParseException, DocumentException  {
		
        try {
        	
        List<AutoCetesDTO>   lsAutoCetes = cetesServiceImpl.getAutoCetes();
		List<SubastaCetesDTO> lsSubasta  = cetesServiceImpl.getSubastaCetes();
		
	////	if(lsAutoCetes == null || lsAutoCetes.size() == 0 || lsSubasta == null || lsSubasta.size() == 0) {
		//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		//	throw new GenericException("No se puede procesar la solicitud","500");
	//	}else {
			CetesWordExporter wordReport = new CetesWordExporter(lsAutoCetes,lsSubasta);
			if (request.getTipo_doc().equals("word")) {
				HistoricoCetesResponse response = new HistoricoCetesResponse(wordReport.createWord(), "200");
				return new ResponseEntity<HistoricoCetesResponse>(response, HttpStatus.OK);
			}else if (request.getTipo_doc().equals("pdf")) {
				HistoricoCetesResponse response = new HistoricoCetesResponse(wordReport.createPdf(), "200");
				return new ResponseEntity<HistoricoCetesResponse>(response, HttpStatus.OK);
			}else if (request.getTipo_doc().equals("excel")) {
				HistoricoCetesResponse response = new HistoricoCetesResponse(wordReport.createExel(), "200");
				return new ResponseEntity<HistoricoCetesResponse>(response, HttpStatus.OK);
//          wordReport.createExel(response);
			}
	//	}
        }/*catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("No hay Datos".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}*/catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
		}
		return null;
				
     }  
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/enviar/email/aprobaciones")
	public ResponseEntity<?> enviarEmialAprobaciones(@Valid @RequestBody EmailAprobacionTasaEspecialDTO aprobacion) {
		try {			
			EmailAprobacionResponseDTO responseSinDatosDTO = new EmailAprobacionResponseDTO();	
			String response = emailAprobacion.emailTemplateTasaEspecial(aprobacion);
			responseSinDatosDTO.setBody(response);
			responseSinDatosDTO.setCode("200");
			if(response==null) {
				throw new GenericException("No se puede procesar la solicitud", "500");
			}else {
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}			
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setException(ex);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.INTERNAL_SERVER_ERROR);
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
	@PostMapping(path = "/enviar/email/aprobaciones/inversion")
	public ResponseEntity<?> enviarEmialAprobacionesInversion(@Valid @RequestBody EmailAprobacionTasaEspecialDTO aprobacion) {
		try {			
			EmailAprobacionResponseDTO responseSinDatosDTO = new EmailAprobacionResponseDTO();	
			String response = emailAprobacion.emailTemplateAprobacionInversion(aprobacion);
			responseSinDatosDTO.setBody(response);
			responseSinDatosDTO.setCode("200");
			if(response==null) {
				throw new GenericException("No se puede procesar la solicitud", "500");
			}else {
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}			
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setException(ex);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.INTERNAL_SERVER_ERROR);
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
	 * 
	 * @param ejecutivosInputDTO
	 * @return
	 * 
	 * Servicio que busca en la tabla  per_cat_ejecutivo_sucursal los ejecutivos
	 * por puesto tipo
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ejecutivos/soied")
	public ResponseEntity<?> getEjecutivosSucursal(@Valid @RequestBody EjecutivosAsignacionesInputDTO ejecutivosInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<PetCatEjecutivoSucursalCampanaDTO> lsEjecutivos = ejecutivoSucursal.getEjecutivosSucursal(ejecutivosInputDTO.getLsEjecutivos());
			if(lsEjecutivos==null || lsEjecutivos.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROSEJECUTIVOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsEjecutivos);
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
	 * 
	 * @param ejecutivosInputDTO
	 * @return
	 * 
	 * Servicio que buscara en la tabla de Asignaciones por SOEID y validara
	 * si este cuenta con los permisos para poder recibir solicitudes, dichas solicitudes
	 * son las que llegan desde la tabla de AutoTasas.
	 * 
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ejecutivos/uec/solicitudes")
	public ResponseEntity<?> getEjecutivoUEC(@Valid @RequestBody SoeidInputEjecutivoDTO ejecutivosInputDTO) {
		try {			
			if(ejecutivosInputDTO==null){
				throw new GenericException("Request Incorrecto", HttpStatus.BAD_REQUEST.toString());
			}
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			AsignacionesDTO ejecutivo = ejecutivoSucursal.getEjecutivosUECAsignados(ejecutivosInputDTO.getSoeid());
			if(ejecutivo.getId()==null || ejecutivo.getOnline()==null){
				responseSinDatosDTO.setSinRegistros(MensajesUtils.EJECUTIVONOPUEDERECIBIR);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(ejecutivo);			
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
	 * Servicio que regresa todos los SOIED que se pueden asignar
	 * son ejecutivos UEC y tienen el estatus de 1 en la tabla de asignaciones.
	 * 
	 * Estos son los que se deben enviar al servicio 
	 * 
	 * /ejecutivos/asignaciones/autoTasas/activos
	 * 
	 * 
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/ejecutivos/asignaciones")
	public ResponseEntity<?> getAsignacionesEjecutivos() {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			EjecutivosAsignacionesInputDTO ejecutivosInputDTO   = new EjecutivosAsignacionesInputDTO();
			List<String> lsEjecutivos = new ArrayList<>();
			lsEjecutivos.add("ejecutivo UEC");
			ejecutivosInputDTO.setLsEjecutivos(lsEjecutivos);			
			List<PetCatEjecutivoSucursalCampanaDTO> lsEjecutivosUEC = ejecutivoSucursal.getEjecutivosSucursal(ejecutivosInputDTO.getLsEjecutivos());
			List<AsignacionesDTO> lsAsignaciones = ejecutivoSucursal.getAsignacionesEjecutivos(lsEjecutivosUEC);
			if(lsAsignaciones==null || lsAsignaciones.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROSEJECUTIVOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsAsignaciones);
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
	 * 
	 * @param ejecutivosInputDTO
	 * @return
	 * 
	 * Servicio que recibe como parámetro de Entrada una lista de soeid, busca en
	 * la tabla de autotasas todos los registros donde soeid_asig es null y posteriormente
	 * les va asignando a cada uno de estos registros un ejecutivo SOEID.
	 * 
	 * Este servicio regresa la lista de los elementos que se insertaron y que se actualizaron
	 * su SOEID en el campo soeid_asig.
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ejecutivos/asignaciones/autoTasas/activos")
	public ResponseEntity<?> getAsignacionAutoTasas(@Valid @RequestBody EjecutivosInputDTO ejecutivosInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasDTO> lsAsignaciones = ejecutivoSucursal.getAsignacionAutoTasas(ejecutivosInputDTO.getLsEjecutivos());
			if(lsAsignaciones==null || lsAsignaciones.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.NOSENCONTRARONREGISTROSEJECUTIVOS);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsAsignaciones);
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
	@PostMapping(path = "/insertar/historico/asignaciones")
	public ResponseEntity<?> insertarHistoricoAsignaciones(@Valid @RequestBody HistoricoAsignacionesInputDTO insertarDTO) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = ejecutivoSucursal.insertarHistoricoAsignaciones(insertarDTO.getLsAsignaciones());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.INSERTARHISTORICOASIGNACIONES:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/actualizar/asignaciones/inactivos")
	public ResponseEntity<?> actualizarAsignacionesInactivas(@Valid @RequestBody AsignacionesSoeidInputDTO inactivos) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = ejecutivoSucursal.actualizarAsignacionesInactivas(inactivos.getLsSoeidInactivos());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.SOEIDACTUALIZADOS:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/actualizar/asignaciones/atendidas")
	public ResponseEntity<?> actualizarSoeidAsignadosSupervisor(@Valid @RequestBody ActualizarSoeidAtendidoInputDTO actualizarDTO) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = ejecutivoSucursal.actualizarSoeidAsignadosSupervisor(actualizarDTO.getLsSoeidAtendido());
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.INSERTARHISTORICOASIGNACIONES:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/historico/asignaciones/excel")
	public void getHistoricoAsignacionesExcel (HttpServletResponse response,@Valid @RequestBody FechasInputDTO fechasDTO) throws IOException, ParseException {
		
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=historico_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        List<HistoricoAsignacionesDTO> getHistoricoAsignacionesExcel = ejecutivoSucursal.getHistoricoAsignacionesExcel(fechasDTO);
        ReporteHistoricoAsignacionesExcelExporter excelReport = new ReporteHistoricoAsignacionesExcelExporter(getHistoricoAsignacionesExcel,fechasDTO.getFechaInicial(), fechasDTO.getFechaFinal());
		excelReport.export(response);
				
     }   
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/sucursal/division")
	public ResponseEntity<?> getDivisiones(@Valid @RequestBody PerCatSucursalesInputDTO inputDTO) {
		try {			
			if(inputDTO.getDescripcion()==null){
				throw new GenericException("Request Incompleto ::", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponseDivisiones response = new MensajeResponseDivisiones(perCatSucursalesServiceImpl.getDivisiones(inputDTO.getDescripcion()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponseDivisiones>(response, HttpStatus.OK);			
		} catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setException(ex);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			LOGGER.info(error.getException());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/actualizar/asignaciones/online")
	public ResponseEntity<?> actualizarSoeidAsignaciones(@Valid @RequestBody ActualizarAsignacionesInputDTO actualizarDTO) {
		try {
			ResponseInsertExitosoDTO responseExitoso = new ResponseInsertExitosoDTO();
			int res  = ejecutivoSucursal.actualizarSoeidAsignaciones(actualizarDTO.getOnline(), actualizarDTO.getSoeid(),actualizarDTO.getNombre());					
			responseExitoso.setRespuesta(res);
			responseExitoso.setDescripcion(res==1?MensajesUtils.ACTUALIZACIONOK:MensajesUtils.FAVORVALIDAR);
			return ResponseEntity.status(HttpStatus.OK).body(responseExitoso);
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
	@PostMapping(path = "/registros/sinAutorizacion")
	public ResponseEntity<?> obtenerRegistrosSinAutorizacion() {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasEmailDTO> lsAutoTasasEmail = tasasServiceImpl.obtenerRegistrosSinAutorizacion();
			if(lsAutoTasasEmail==null || lsAutoTasasEmail.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINREGISTROSLISTA);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoTasasEmail);
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
	@PostMapping(path = "/autorizadores/divisionales")
	public ResponseEntity<?> obtenerAutorizadoresDivisionales(@Valid @RequestBody DivisionesInputDTO divisionesInputDTO) {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoAutorizadorDTO> lsAutoAutorizador = tasasServiceImpl.ObtenerAutorizadoresDivisionales(divisionesInputDTO.getSoeid(), divisionesInputDTO.getDivision());
			if(lsAutoAutorizador==null || lsAutoAutorizador.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINREGISTROSLISTA);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoAutorizador);
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
	@PostMapping(path = "/cargaResendMail/v2")
	public ResponseEntity<?> obtenerSolicitudes() {
		try {
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<AutoTasasEmailDTO> lsAutoTasasEmail = tasasServiceImpl.obtenerRegistrosSinAutorizacion();
			if(lsAutoTasasEmail==null || lsAutoTasasEmail.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINREGISTROSLISTA);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(lsAutoTasasEmail);
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
	@PostMapping(path = "/ejecutivo/soeid/online")
	public ResponseEntity<?> getStatusEjecutivo(@Valid @RequestBody EstatusEjecutivoInputDTO asignacionesDTO) {
		try {
			if(asignacionesDTO.getSoeid().isEmpty() || asignacionesDTO.getSoeid()==null){
				throw new GenericException("Request Incompleto, Favor de Validar::", HttpStatus.BAD_REQUEST.toString());
			}
			
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			AsignacionesDTO     asignacion          = tasasServiceImpl.getStatusEjecutivo(asignacionesDTO.getSoeid());
			
			if(asignacion.getId()==null && asignacion.getNombre()==null) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINREGISTROSLISTA);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}			
			return ResponseEntity.status(HttpStatus.OK).body(asignacion);
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
	@PostMapping(path = "/folioUECExistente")
	public ResponseEntity<?> getFoliosAutorizacion(@Valid @RequestBody FolioNumInputDTO folioNumInputDTO) {
		try {
			if(folioNumInputDTO.getNumAutoriEuc().isEmpty() || folioNumInputDTO.getNumAutoriEuc()==null){
				throw new GenericException("Request Incompleto, Favor de Validar::", HttpStatus.BAD_REQUEST.toString());
			}			
			ResponseSinDatosDTO responseSinDatosDTO = new ResponseSinDatosDTO();
			List<FolioNumAutorizacionDTO> lsFoliosAutorizacion = tasasServiceImpl.getFoliosAutorizacion(folioNumInputDTO.getNumAutoriEuc());
			
			if(lsFoliosAutorizacion.size()<=0) {
				responseSinDatosDTO.setSinRegistros(MensajesUtils.SINREGISTROSLISTA);
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}			
			return ResponseEntity.status(HttpStatus.OK).body(lsFoliosAutorizacion);
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
	@PostMapping(path = "/actualizar/estatus/cliente")
	public ResponseEntity<?> actualizaEstatusCliente(@Valid @RequestBody EstatusClienteDTO cliente) {
		try {
			if(cliente.getNumCliente().isEmpty() || cliente.getNumCliente()==null){
				throw new GenericException("Request Incompleto, Favor de Validar::", HttpStatus.BAD_REQUEST.toString());
			}			
			ResponseInsertExitosoDTO responseSinDatosDTO = new ResponseInsertExitosoDTO();
			Integer lsFoliosActualizar = perCatFolioSolicitudesUECServiceImpl.getPDFFolioCliente(cliente.getNumCliente());
			if(lsFoliosActualizar==1) {
				responseSinDatosDTO.setRespuesta(lsFoliosActualizar);
				responseSinDatosDTO.setDescripcion("ESTATUS DEL CLIENTE ACTUALIZADO CORRECTAMENTE");
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);
			}else {
				responseSinDatosDTO.setRespuesta(lsFoliosActualizar);
				responseSinDatosDTO.setDescripcion("ESTATUS DEL CLIENTE NO ACTUALIZADO CORRECTAMENTE (NO SE ENCONTRO CLIENTE)");
				return ResponseEntity.status(HttpStatus.OK).body(responseSinDatosDTO);	
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
	@GetMapping(path = "/calcular/soeidAsignado")
	public ResponseEntity<?> calcularSoeidAsignadoNoAplica(@Valid @RequestBody EstatusClienteDTO cliente) {
		try {
			String  soeidAsignado = ejecutivoSucursal.calcularSoeidAsignadoNoAplica();
			if(soeidAsignado.equals("")) {
				soeidAsignado ="NO HAY SOEID POR ASIGNAR";
				return ResponseEntity.status(HttpStatus.OK).body(soeidAsignado);
			}else {				
				return ResponseEntity.status(HttpStatus.OK).body(soeidAsignado);	
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
}
