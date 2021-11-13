package com.citi.euces.sitiouec.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.dto.BuscarWebAutorizadoresDTO;
import com.citi.euces.sitiouec.dto.BuscarWebDTO;
import com.citi.euces.sitiouec.dto.CatSucursalesDTO;
import com.citi.euces.sitiouec.dto.ConsultarAutorizadorDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.models.InsertAutorizadoresRequest;
import com.citi.euces.sitiouec.models.MensajeResponse;
import com.citi.euces.sitiouec.models.ResponseAutorizador;
import com.citi.euces.sitiouec.models.ResponseBuscarAutorizador;
import com.citi.euces.sitiouec.models.ResponseListaSucursal;
import com.citi.euces.sitiouec.services.WebAutorizadoresServiceImpl;


@RestController
@RequestMapping(path = WebAutorizadoresController.WEB_AUTORIZADORES)
public class WebAutorizadoresController {

	
	private static final Logger log = LogManager.getLogger(WebAutorizadoresController.class);
	static final String WEB_AUTORIZADORES = "/webAutorizadores";
	
	@Autowired(required = true)
	private WebAutorizadoresServiceImpl webAutorizadoresServiceImpl;
	
	//SERVICIO BUSCAR WEB AUTORIZADORES
	@PostMapping(path = "/buscarWeb")
	public ResponseEntity<?> getBuscarWebAutorizadores(@Valid @RequestBody BuscarWebAutorizadoresDTO buscarWebAutorizadoresDTO){
		try {
			ResponseBuscarAutorizador listaBuscarWeb = new ResponseBuscarAutorizador(webAutorizadoresServiceImpl.getBuscarWebAutorizadores(buscarWebAutorizadoresDTO.getSoeid(),  
																buscarWebAutorizadoresDTO.getDivision()), HttpStatus.OK.toString());
			return new ResponseEntity<ResponseBuscarAutorizador>(listaBuscarWeb, HttpStatus.OK);
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
	
	//SERVICIO DE BUSCAR SUCURSAL
		@GetMapping(path = "/listaSucursal")
		public ResponseEntity<?> getListaSucursal(){
			try {
				ResponseListaSucursal listaSucursal = new ResponseListaSucursal(webAutorizadoresServiceImpl.getListaSucursal(), HttpStatus.OK.toString());
				return new ResponseEntity<ResponseListaSucursal>(listaSucursal, HttpStatus.OK);
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
		
		//DESACTIVAR EL USUARIO
		@PostMapping(path = "/desactivarUsuario")
		public ResponseEntity<?> desativarUsuario(@RequestBody final BuscarWebAutorizadoresDTO desactivarRequest){
			try {
				if(desactivarRequest.getSoeid().isEmpty()){
					throw new GenericException("Request Incompleto Soeid ::", HttpStatus.BAD_REQUEST.toString());
				}
				MensajeResponse response = new MensajeResponse(webAutorizadoresServiceImpl.desativarUsuario(desactivarRequest.getSoeid()), HttpStatus.OK.toString());
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
		
		//INSERTAR CATALOGOS AUTORIZADORES
		@PostMapping(path = "/insertarAutorizadores")
		public ResponseEntity<?> insertarAutorizador(@RequestBody final InsertAutorizadoresRequest request){		
			try {
				if(request.getSoeid().isEmpty()){
					throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
				}
				MensajeResponse response = new MensajeResponse(webAutorizadoresServiceImpl.insertarAutorizadores(request.getSoeid(),
						request.getSoeidDivisional(), request.getSoeidDistrital(), request.getDivision(), request.getDistrito(), 
						request.getNombre(), request.getInic(), request.getFechaInicio(), request.getFechaTermino(), request.getAlta(),
						request.getCorreo(), request.getIsCete100(), request.getIsCampesp(), request.getIdNivelAuto()), HttpStatus.OK.toString());
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
		
		//BUSCAR EL AUTORIZADOR A MODIFICAR
		@PostMapping(path = "/consultarModificar")
		public ResponseEntity<?> consultarAutorizadores(@Valid @RequestBody BuscarWebAutorizadoresDTO buscarWebAutorizadoresDTO){
			
			try {
				ResponseAutorizador listaAutorizadorUpdate = new ResponseAutorizador(webAutorizadoresServiceImpl.consultarAutorizadores(
																	buscarWebAutorizadoresDTO.getSoeid()), HttpStatus.OK.toString());
				return new ResponseEntity<ResponseAutorizador>(listaAutorizadorUpdate, HttpStatus.OK);
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
		
		//MODIFICAR EL AUTORIZADOR
		@PostMapping(path = "/modificarAutorizadores")
		public ResponseEntity<?> modificarAutorizadores(@RequestBody final InsertAutorizadoresRequest request){		
			try {
				if(request.getSoeid().isEmpty()){
					throw new GenericException("Request Incompleto para modificar el Autorizador ::", HttpStatus.BAD_REQUEST.toString());
				}
				MensajeResponse response = new MensajeResponse(webAutorizadoresServiceImpl.modificarAutorizadores(request.getSoeid(),
						request.getSoeidDivisional(), request.getSoeidDistrital(), request.getDivision(), request.getDistrito(), 
						request.getNombre(), request.getInic(), request.getFechaInicio(), request.getFechaTermino(), request.getAlta(),
						request.getCorreo(), request.getIsCete100(), request.getIsCampesp(), request.getIdNivelAuto()), HttpStatus.OK.toString());
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
		
	
	
}
