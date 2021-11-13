package com.citi.euces.sitiouec.restcontrollers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoRequest;
import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoResponse;
import com.citi.euces.sitiouec.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.DiasFestivosResponse;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.services.ServiceSolicitudInversionImp;


@RestController
//@RequestMapping(ServiceSolicitudInversionController.GR_RESOURCE)
@RequestMapping(ServiceSolicitudInversionController.GREETING_RESOURCE)
public class ServiceSolicitudInversionController  {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSolicitudInversionController.class);
	
	static final String GREETING_RESOURCE = "/SolicitudDeInversion";
	

	@Autowired
	ServiceSolicitudInversionImp serviceSolicitudInversionImp;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/ObtenerDiasFeriados", produces = "application/json")
	public  ResponseEntity<?> ObtenerDiasFeriados(@RequestBody final DiasFestivosBEDTO request){
		try {
			DiasFestivosResponse response  = new DiasFestivosResponse(serviceSolicitudInversionImp.ObtenerDiasFeriados(request), "200");
			if(response.getDiasFestivos() == null || response.getDiasFestivos().size() == 0) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {			
				return new ResponseEntity<DiasFestivosResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e.toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "/actSolicitud", produces = "application/json")
	public  ResponseEntity<?> actSolicitud(@RequestBody final ActSolicitudDtoRequest request){
		try {
			ActSolicitudDtoResponse response  = serviceSolicitudInversionImp.actSolicitud(request);
			if(!response.getStatus()) {
				throw new GenericException("No se puede procesar la solicitud","500");
			}else {	
                response.setCode("200");
				return new ResponseEntity<ActSolicitudDtoResponse>(response, HttpStatus.OK);
			}
		}catch (GenericException ex) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(ex.getCodeError());
			error.setMensaje(ex.getMessage());
			error.setError("Parametros Incorrecto o Parametros no existen".toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			ErrorGeneric error = new ErrorGeneric();
			error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			error.setMensaje(e.getMessage());
			error.setError(e.toString());
			return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
		}
	}
	
}
