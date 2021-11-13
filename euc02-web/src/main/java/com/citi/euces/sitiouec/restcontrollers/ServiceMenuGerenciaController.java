package com.citi.euces.sitiouec.restcontrollers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseBEDTO;
import com.citi.euces.sitiouec.dto.DibujarChartResponseBEDTO;
import com.citi.euces.sitiouec.dto.EjecutivosPriorityGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO;
import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaBEDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.AutoTasaAcomuladoCampGerenciaResponse;
import com.citi.euces.sitiouec.models.AutoTasaMontoVolumenGerenciaResponse;
import com.citi.euces.sitiouec.models.AutoTasasOnLineGerenciaResponse;
import com.citi.euces.sitiouec.models.CampanaGerenciaResponse;
import com.citi.euces.sitiouec.models.CampanaporSucursalesResponse;
import com.citi.euces.sitiouec.models.ConfirmacionResponce;
import com.citi.euces.sitiouec.models.DibujarChartResponse;
import com.citi.euces.sitiouec.models.EjecutivosPriorityGerenciaResponse;
import com.citi.euces.sitiouec.models.EjecutivosPrioritySinVentaGerenciaResponse;
import com.citi.euces.sitiouec.models.EjecutivosPriorityVentaGerenciaResponse;
import com.citi.euces.sitiouec.models.GetNumRegTbAcumuladoTasasResponse;
import com.citi.euces.sitiouec.models.LeerExcelGerenciaResponse;
import com.citi.euces.sitiouec.models.ObtenerDiasHabilesResponse;
import com.citi.euces.sitiouec.models.ObtenerFechaMaximaResponse;
import com.citi.euces.sitiouec.models.ObtenerListaCampanasResponse;
import com.citi.euces.sitiouec.models.ObtenerListaTodasCampanasResponse;
import com.citi.euces.sitiouec.models.ObtenerTotalEjecutivosDivisionResponse;
import com.citi.euces.sitiouec.models.ObtenerTotalEjecutivosRegionResponse;
import com.citi.euces.sitiouec.models.ObtenerlistaEjecutivosNoLocalizablesResponse;
import com.citi.euces.sitiouec.models.SucursalGerenciaRegionResponse;
import com.citi.euces.sitiouec.models.SucursalGerenciaResponse;
import com.citi.euces.sitiouec.models.SucursalRegionalGerenciaResponse;
import com.citi.euces.sitiouec.models.SucursalesAgrupadaGerenciaResponse;
import com.citi.euces.sitiouec.services.ServiceMenuGerenciaImp;
import com.citi.euces.sitiouec.exceptions.ErrorGeneric;






@RestController
//@RequestMapping(ServiceSolicitudInversionController.GR_RESOURCE)
@RequestMapping(ServiceMenuGerenciaController.GREETING_RESOURCE)

public class ServiceMenuGerenciaController {
	
    private static final Logger LOGGER = LogManager.getLogger(ServiceMenuGerenciaController.class);
	
	static final String GREETING_RESOURCE = "/ServiceMenuGerencia";
	
	@Autowired(required = true)
	ServiceMenuGerenciaImp serviceMenuGerenciaImp;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ImprimirReporteOnLine", produces = "application/json") //ok
	public ResponseEntity<?> ImprimirReporteOnLine(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			SucursalGerenciaResponse response  = new SucursalGerenciaResponse(serviceMenuGerenciaImp.ObtenerVistaCampanaporDivision(request), "200");
			if(response.getSucursalGerenciaResponse() == null || response.getSucursalGerenciaResponse().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ImprimirReporteOnLineAplicadas", produces = "application/json") //ok
	public ResponseEntity<?> ImprimirReporteOnLineAplicadas(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			SucursalGerenciaResponse response  = new SucursalGerenciaResponse(serviceMenuGerenciaImp.ImprimirReporteOnLine(request), "200");
			if(response.getSucursalGerenciaResponse() == null || response.getSucursalGerenciaResponse().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	
	/*@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerVistaCampanaporDirRegional", produces = "application/json") // faltan
	public ResponseEntity<?> ObtenerVistaCampanaporDirRegional(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			SucursalRegionalGerenciaResponse response  = new SucursalRegionalGerenciaResponse(serviceMenuGerenciaImp.ObtenerVistaCampanaporDirRegional(request), "200");
			if(response.getSucursalRegionalGerenciaResponseDTO() == null || response.getSucursalRegionalGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalRegionalGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}*/

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerSucursalesAgrupadasEnCampanaPorDivision", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerSucursalesAgrupadasEnCampanaPorDivision(@RequestBody final SucursalesAgrupadaGerenciaBEDTO request) {
		try {
			SucursalesAgrupadaGerenciaResponse response  = new SucursalesAgrupadaGerenciaResponse(serviceMenuGerenciaImp.ObtenerSucursalesAgrupadasEnCampanaPorDivision(request), "200");
			if(response.getSucursalesAgrupadaGerenciaResponseDTO() == null || response.getSucursalesAgrupadaGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalesAgrupadaGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
/*	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerVistaCampanaporSucursales", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerVistaCampanaporSucursales(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			CampanaporSucursalesResponse response  = new CampanaporSucursalesResponse(serviceMenuGerenciaImp.ObtenerVistaCampanaporSucursales(request), "200");
			if(response.getCampanaporSucursalesResponseDTO() == null || response.getCampanaporSucursalesResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<CampanaporSucursalesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}*/
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerRegistrosAutoTasasOnLine", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerRegistrosAutoTasasOnLine() {
		try {
			AutoTasasOnLineGerenciaResponse response  = new AutoTasasOnLineGerenciaResponse(serviceMenuGerenciaImp.ObtenerRegistrosAutoTasasOnLine(), "200");
			if(response.getAutoTasasOnLineGerenciaResponseDTO() == null || response.getAutoTasasOnLineGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutoTasasOnLineGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerListaTodasCampanas", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerListaTodasCampanas() {
		try {
			ObtenerListaTodasCampanasResponse response  = new ObtenerListaTodasCampanasResponse(serviceMenuGerenciaImp.ObtenerListaTodasCampanas(), "200");
			if(response.getCampana() == null || response.getCampana().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerListaTodasCampanasResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/LeerInsumosReporteDiario",  produces = "application/json" ) //ok
	public ResponseEntity<?> LeerInsumosReporteDiario(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			LeerExcelGerenciaResponse response  = new LeerExcelGerenciaResponse(serviceMenuGerenciaImp.LeerInsumosReporteDiario(request), "200");
			
			if(response.getLeerExcelGerenciaResponseDTO().isEmpty() || response.getLeerExcelGerenciaResponseDTO().equals("Error")) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<LeerExcelGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping(path ="/EliminarCargaAcumulado", produces = "application/json") //ok
	public ResponseEntity<?> EliminarCargaAcumulado( @RequestBody final AutoTasaAcomuladoCampGerenciaBEDTO request) {
		
		try {
			String mensaje = serviceMenuGerenciaImp.EliminarCargaAcumulado(request); 
			if(mensaje == null || mensaje.isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");	
			}else {
				ConfirmacionResponce response = new ConfirmacionResponce(mensaje, "200");
				return new ResponseEntity<ConfirmacionResponce>(response,HttpStatus.OK);
			}
		} catch (GenericException ex) {
			System.out.println("etro");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametro no encontrado".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("etro 2");
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje("No se puede procesar la solicitud");
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
			
		}	
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerRegistrosAcumuCamp", produces = "application/json") //falta
	public ResponseEntity<?> ObtenerRegistrosAcumuCamp() {
		try {
			AutoTasaAcomuladoCampGerenciaResponse response  = new AutoTasaAcomuladoCampGerenciaResponse(serviceMenuGerenciaImp.ObtenerRegistrosAcumuCamp(), "200");
			if(response.getObtenerListaCampanas() == null || response.getObtenerListaCampanas().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutoTasaAcomuladoCampGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	//falta probar
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerEjecutivosPriority", produces = "application/json")//ok
	public ResponseEntity<?> ObtenerEjecutivosPriority( @RequestBody final EjecutivosPriorityGerenciaBEDTO request) {
		
		try {
			EjecutivosPriorityGerenciaResponse response  = new EjecutivosPriorityGerenciaResponse(serviceMenuGerenciaImp.ObtenerEjecutivosPriority(request), "200");
			if(response.getEjecutivosPriorityGerenciaResponseDTO() == null || response.getEjecutivosPriorityGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<EjecutivosPriorityGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerEjecutivosPriorityConVentas", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerEjecutivosPriorityConVentas( @RequestBody final EjecutivosPriorityGerenciaBEDTO request) {
		
		try {
			EjecutivosPriorityVentaGerenciaResponse response  = new EjecutivosPriorityVentaGerenciaResponse(serviceMenuGerenciaImp.ObtenerEjecutivosPriorityConVentas(request), "200");
			if(response.getEjecutivosPriorityVentaGerenciaResponseDTO() == null || response.getEjecutivosPriorityVentaGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<EjecutivosPriorityVentaGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerEjecutivosPrioritySinVentas", produces = "application/json")//ok
	public ResponseEntity<?> ObtenerEjecutivosPrioritySinVentas( @RequestBody final EjecutivosPriorityGerenciaBEDTO request) {
		
		try {
			EjecutivosPrioritySinVentaGerenciaResponse response  = new EjecutivosPrioritySinVentaGerenciaResponse(serviceMenuGerenciaImp.ObtenerEjecutivosPrioritySinVentas(request), "200");
			if(response.getEjecutivosPrioritySinVentaGerenciaResponseDTO() == null || response.getEjecutivosPrioritySinVentaGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<EjecutivosPrioritySinVentaGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerDiasHabiles", produces = "application/json")//ok
	public ResponseEntity<?> ObtenerDiasHabiles( @RequestBody final EjecutivosPriorityGerenciaBEDTO request) {
		
		try {
			ObtenerDiasHabilesResponse response  = new ObtenerDiasHabilesResponse(serviceMenuGerenciaImp.ObtenerDiasHabiles(request), "200");
			if(response.getDias() == null) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerDiasHabilesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerFechaMaxima", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerFechaMaxima( @RequestBody final EjecutivosPriorityGerenciaBEDTO request) {
		
		try {
			ObtenerFechaMaximaResponse response  = new ObtenerFechaMaximaResponse(serviceMenuGerenciaImp.ObtenerFechaMaxima(request), "200");
			if(response.getFecha().toString().isEmpty()) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerFechaMaximaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path ="/ObtenerTotalEjecutivosDivision", produces = "application/json")//ok
	public ResponseEntity<?> ObtenerTotalEjecutivosDivision() {
		
		try {
			ObtenerTotalEjecutivosDivisionResponse response  = new ObtenerTotalEjecutivosDivisionResponse(serviceMenuGerenciaImp.ObtenerTotalEjecutivosDivision(), "200");
			if(response.getObtenerTotalEjecutivosDivisionResponseDTO() == null || response.getObtenerTotalEjecutivosDivisionResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerTotalEjecutivosDivisionResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
		
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path ="/ObtenerTotalEjecutivosRegion", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerTotalEjecutivosRegion() {
		
		try {
			ObtenerTotalEjecutivosRegionResponse response  = new ObtenerTotalEjecutivosRegionResponse(serviceMenuGerenciaImp.ObtenerTotalEjecutivosRegion(), "200");
			if(response.getObtenerTotalEjecutivosRegionResponseDTO() == null || response.getObtenerTotalEjecutivosRegionResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerTotalEjecutivosRegionResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
		
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/GetNumRegTbAcumuladoTasas", produces = "application/json") //OK
	public ResponseEntity<?> GetNumRegTbAcumuladoTasas( @RequestBody final GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO request) {
		
		try {
			GetNumRegTbAcumuladoTasasResponse response  = new GetNumRegTbAcumuladoTasasResponse(serviceMenuGerenciaImp.GetNumRegTbAcumuladoTasas(request), "200");
			if(response.getTotal() == null) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<GetNumRegTbAcumuladoTasasResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
			
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path ="/ObtenerlistaEAV", produces = "application/json") //OK
	public ResponseEntity<?> ObtenerlistaEAV(@RequestBody final AutoTasaGerenciaBEDTO request) {
		
		try {
			CampanaGerenciaResponse response  = new CampanaGerenciaResponse(serviceMenuGerenciaImp.ObtenerlistaEAV(request), "200");
			if(response.getCampanaGerenciaResponseDTO() == null) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<CampanaGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
			
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerListaCampanas", produces = "application/json") //falta
	public ResponseEntity<?> ObtenerListaCampanas() {
		try {
			ObtenerListaCampanasResponse response  = new ObtenerListaCampanasResponse(serviceMenuGerenciaImp.ObtenerListaCampanas(), "200");
			if(response.getCampGerenciaResponseDTO() == null || response.getCampGerenciaResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerListaCampanasResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerlistaEjecutivosNoLocalizables", produces = "application/json") //falta
	public ResponseEntity<?> ObtenerlistaEjecutivosNoLocalizables() {
		try {
			ObtenerlistaEjecutivosNoLocalizablesResponse response  = new ObtenerlistaEjecutivosNoLocalizablesResponse(serviceMenuGerenciaImp.ObtenerlistaEjecutivosNoLocalizables(), "200");
			if(response.getObtenerlistaEjecutivosNoLocalizablesResponseDTO() == null || response.getObtenerlistaEjecutivosNoLocalizablesResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<ObtenerlistaEjecutivosNoLocalizablesResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerVistaCampanaporGerMercado", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerVistaCampanaporGerMercado(@RequestBody final AutoTasaGerenciaBEDTO request) {
		try {
			SucursalGerenciaRegionResponse response  = new SucursalGerenciaRegionResponse(serviceMenuGerenciaImp.ObtenerVistaCampanaporGerMercado(request), "200");
			if(response.getSucursalGerenciaRegionResponseDTO() == null || response.getSucursalGerenciaRegionResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<SucursalGerenciaRegionResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerMontoVolumenPorDiaCampanaProcesada", produces = "application/json") //ok
	public ResponseEntity<?> ObtenerMontoVolumenPorDiaCampanaProcesada(@RequestBody final AutoTasaMontoVolumenGerenciaRepoResponseBEDTO request) {
		try {
			AutoTasaMontoVolumenGerenciaResponse response  = new AutoTasaMontoVolumenGerenciaResponse(serviceMenuGerenciaImp.ObtenerMontoVolumenPorDiaCampanaProcesada(request), "200");
			if(response.getDibujarChartAgrupadoResponseDTO() == null || response.getDibujarChartAgrupadoResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<AutoTasaMontoVolumenGerenciaResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/LoadCharts", produces = "application/json") //ok
	public ResponseEntity<?> LoadCharts(@RequestBody final DibujarChartResponseBEDTO request) {
		try {
			DibujarChartResponse response  = new DibujarChartResponse(serviceMenuGerenciaImp.LoadCharts(request), "200");
			if(response.getDibujarChartResponseDTO() == null || response.getDibujarChartResponseDTO().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<DibujarChartResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e);
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
		
	}
}
