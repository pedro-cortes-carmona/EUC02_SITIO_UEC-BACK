package com.citi.euces.sitiouec.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.ArchivoAutorizadoresRequest;
import com.citi.euces.sitiouec.models.ArchivoRequest;
import com.citi.euces.sitiouec.models.AutDivisionales;
import com.citi.euces.sitiouec.models.AutRegionalesRequest;
import com.citi.euces.sitiouec.models.BoletinesRequest;
import com.citi.euces.sitiouec.models.CalculoRestantesRequest;
import com.citi.euces.sitiouec.models.CampanaDetalleOpeRequest;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.models.EstatusRequest;
import com.citi.euces.sitiouec.models.ListaComboResponse;
import com.citi.euces.sitiouec.models.MensajeResponse;
import com.citi.euces.sitiouec.models.ReporteAcumDTO;
import com.citi.euces.sitiouec.models.ReporteArchivoDiaCargaRequest;
import com.citi.euces.sitiouec.models.ReporteArchivoDiaCargaResponse;
import com.citi.euces.sitiouec.models.ReporteBoletinesResponse;
import com.citi.euces.sitiouec.models.ReporteCampanaDetalleResponse;
import com.citi.euces.sitiouec.models.ReporteCampanaResumenReponse;
import com.citi.euces.sitiouec.models.ReporteResumenRequest;
import com.citi.euces.sitiouec.models.ReporteResumenResponse;
import com.citi.euces.sitiouec.models.SolicitudResponse;
import com.citi.euces.sitiouec.models.SolicitudesAplicadasRequest;
import com.citi.euces.sitiouec.models.SolicitudesAplicadasResponse;
import com.citi.euces.sitiouec.models.CargaDatosRequest;
import com.citi.euces.sitiouec.models.CargaDatosResponse;
import com.citi.euces.sitiouec.models.ComboResponse;
import com.citi.euces.sitiouec.models.DivisionesRequest;
import com.citi.euces.sitiouec.services.api.SitioUECService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/sitioUEC", produces = MediaType.APPLICATION_JSON_VALUE)
public class SitioUECController {

	static final Logger log = LoggerFactory.getLogger(SitioUECController.class);
	
	@Autowired
	private SitioUECService sitioUECService;
	
	@PostMapping(path = "/reporteEspeciales")
	public ResponseEntity<?> generaReporteEspeciales(@RequestBody final AutoTasaGerenciaBEDTO request){
		try {
			if(request.getCampana().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			if(request.getFecha().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(sitioUECService.generaReporteEspe(request), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/cargaArchivoPlatino")
	public ResponseEntity<?> cargaArchivoPlatino(@RequestBody final ArchivoRequest request){
		try {
			if(request.getFile().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(sitioUECService.cargaArchivoPlatino(request.getFile()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}	

	@PostMapping(path = "/cargaArchivoRegistroSolicitudes")
	public ResponseEntity<?> cargaArchivoRegistroSolicitudes(@RequestBody final ArchivoRequest request){
		try {
			if(request.getFile().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(sitioUECService.cargaArchivoRegistroSolicitudes(request.getFile()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/cargaArchivoAutorizadores")
	public ResponseEntity<?> cargaArchivoAutorizadores(@RequestBody final ArchivoAutorizadoresRequest request){
		try {
			if(request.getFile().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(sitioUECService.cargaArchivoAutorizadores(request.getFile(), request.getFecha()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/calculaRestantes")
	public ResponseEntity<?> calculaRestantes(@RequestBody final CalculoRestantesRequest request){
		try {
			MensajeResponse response = new MensajeResponse(sitioUECService.calculoRestantes(request.getFecha()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}

	@PostMapping(path = "/eliminaDiaCarga")
	public ResponseEntity<?> eliminaDiaCarga(@RequestBody final CalculoRestantesRequest request){
		try {
			if(request.getFecha().isEmpty()) {
				throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(sitioUECService.eliminarDiaCarga(request.getFecha()), HttpStatus.OK.toString());
			return new ResponseEntity<MensajeResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}

	@PostMapping(path = "/descargaArchivoDiaCarga")
	public ResponseEntity<?> descargaArchivoDiaCarga(@RequestBody final ReporteArchivoDiaCargaRequest request){
		try {
			if(request.getFecha1().isEmpty()) {
				throw new GenericException("Falta la fecha inicio :: ", HttpStatus.BAD_REQUEST.toString());
			}
			
			if(request.getFecha2().isEmpty()) {
				throw new GenericException("Falta la fecha termino :: ", HttpStatus.BAD_REQUEST.toString());
			}
			
			ReporteArchivoDiaCargaResponse response = new ReporteArchivoDiaCargaResponse(sitioUECService.reporteArchivoDiaCarga(request.getFecha1(), request.getFecha2()), HttpStatus.OK.toString());
			return new ResponseEntity<ReporteArchivoDiaCargaResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}

	@PostMapping(path = "/busquedaSolicitudesAplicadasSinDatos")
	public ResponseEntity<?> searchSolicitudesAplicadasSinDatos(@RequestBody final SolicitudesAplicadasRequest request){
		try {
			if(request.getFechaBusqueda().isEmpty()) {
				throw new GenericException("Falta la fecha de busqueda :: ", HttpStatus.BAD_REQUEST.toString());
			}
			
			SolicitudesAplicadasResponse response = new SolicitudesAplicadasResponse(sitioUECService.busquedaSolicitudesAplicadasSinDatos(request.getFechaBusqueda()), HttpStatus.OK.toString());
			return new ResponseEntity<SolicitudesAplicadasResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getCampanaDetalleOperacion")
	public ResponseEntity<?> reporteCampanaDetalle(@RequestBody final CampanaDetalleOpeRequest request){
		try {
			if(request.getFecha1().isEmpty()) {
				throw new GenericException("Falta establecer alguna fecha de busqueda :: ", HttpStatus.BAD_REQUEST.toString());
			}
			if(request.getFecha2().isEmpty()) {
				throw new GenericException("Falta establecer alguna fecha de busqueda :: ", HttpStatus.BAD_REQUEST.toString());
			}
			ReporteCampanaDetalleResponse response = new ReporteCampanaDetalleResponse(sitioUECService.reporteCampanaDetalleOpe(request.getFecha1(), request.getFecha2(), request.getReporte()), HttpStatus.OK.toString());
			return new ResponseEntity<ReporteCampanaDetalleResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getCampanaResumen")
	public ResponseEntity<?> reporteCampanaResumen(@RequestBody final CampanaDetalleOpeRequest request){
		try {
			if(request.getFecha1().isEmpty()) {
				throw new GenericException("Falta establecer alguna fecha de busqueda :: ", HttpStatus.BAD_REQUEST.toString());
			}
			if(request.getFecha2().isEmpty()) {
				throw new GenericException("Falta establecer alguna fecha de busqueda :: ", HttpStatus.BAD_REQUEST.toString());
			}
			ReporteCampanaResumenReponse response = new ReporteCampanaResumenReponse(sitioUECService.reporteCampanaResumen(request.getFecha1(), request.getFecha2()), HttpStatus.OK.toString());
			return new ResponseEntity<ReporteCampanaResumenReponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getBoletines")
	public ResponseEntity<?> reporteBoletines(@RequestBody final BoletinesRequest request){
		try {
			ReporteBoletinesResponse response = new ReporteBoletinesResponse(sitioUECService.reporteBoletines(request.getEstatus(), request.getEnfoque(), 
												request.getFechaInicial(), request.getFechaFinal(), request.getReporte()), HttpStatus.OK.toString());
			return new ResponseEntity<ReporteBoletinesResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getResumen")
	public ResponseEntity<?> reporteResumen(@RequestBody final ReporteResumenRequest request){
		try {
			ReporteResumenResponse response = new ReporteResumenResponse(sitioUECService.reporteResumen(request.getFecha1(), request.getFecha2(), request.getReporte()), HttpStatus.OK.toString());
			return new ResponseEntity<ReporteResumenResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/transferirRegistros")
	public ResponseEntity<?> transferirRegistros(@RequestBody final CargaDatosRequest request){
		try {
			CargaDatosResponse response = new CargaDatosResponse(sitioUECService.transfiereDatos(request.getFecha()), HttpStatus.OK.toString());
			return new ResponseEntity<CargaDatosResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	
	@PostMapping(path = "/getCombo")
	public ResponseEntity<?> getCombo(){
		try {
			ComboResponse response = new ComboResponse(sitioUECService.getCombo(), HttpStatus.OK.toString());
			return new ResponseEntity<ComboResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getDivisiones")
	public ResponseEntity<?> getDivisiones(@RequestBody final DivisionesRequest request){
		try {
			ComboResponse response = new ComboResponse(sitioUECService.getDivisiones(request.getRegion(), request.getAutDivisionales()), HttpStatus.OK.toString());
			return new ResponseEntity<ComboResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getAutDivisionales")
	public ResponseEntity<?> getAutDivisionales(@RequestBody final AutDivisionales request){
		try {
			ComboResponse response = new ComboResponse(sitioUECService.getAutDivisionales(request.getRegion()), HttpStatus.OK.toString());
			return new ResponseEntity<ComboResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	
	@PostMapping(path = "/getRegiones")
	public ResponseEntity<?> getRegiones(@RequestBody final AutRegionalesRequest request){
		try {
			ComboResponse response = new ComboResponse(sitioUECService.getRegiones(request.getAutRegion(),request.getDivision()), HttpStatus.OK.toString());
			return new ResponseEntity<ComboResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/getListaCombo")
	public ResponseEntity<?> getListaCombo(){
		try {
			ListaComboResponse response = new ListaComboResponse(sitioUECService.getListaCombo(), HttpStatus.OK.toString());
			return new ResponseEntity<ListaComboResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
	
	@PostMapping(path = "/UpdateEstatus")
	public ResponseEntity<?> UpdateEstatus(@RequestBody final EstatusRequest request){
		try {
			SolicitudResponse response = new SolicitudResponse(sitioUECService.UpdateEstatus(request.getSoeid(), request.getIdTasa(), request.getEstatus()), HttpStatus.OK.toString());
			return new ResponseEntity<SolicitudResponse>(response, HttpStatus.OK);
		} catch (GenericException ex) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) 
		{
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            log.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
	}
}
