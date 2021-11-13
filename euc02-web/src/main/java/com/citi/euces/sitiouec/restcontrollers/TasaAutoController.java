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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.CargaCeteDTO;
import com.citi.euces.sitiouec.dto.CargaGridDTO;
import com.citi.euces.sitiouec.dto.EditarTasaAutoDTO;
import com.citi.euces.sitiouec.dto.EmailDTO;
import com.citi.euces.sitiouec.dto.InBuscarClickDTO;
import com.citi.euces.sitiouec.dto.ResendMailDTO;
import com.citi.euces.sitiouec.dto.ResultEditarDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.ActualizaSolicitudDTO;
import com.citi.euces.sitiouec.models.ChkRecibirRequest;
import com.citi.euces.sitiouec.models.EmailTasaEspecialRequest;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.models.MensajeResponse;
import com.citi.euces.sitiouec.models.UpdateInRechazarCancelar;
import com.citi.euces.sitiouec.models.UpdateInkCancelar;
import com.citi.euces.sitiouec.models.UpdateInkRechazarRequest;
import com.citi.euces.sitiouec.services.TasaAutoImpl;


@RestController
@RequestMapping(path = TasaAutoController.TASA_AUTO)
public class TasaAutoController {

	private static final Logger LOGGER = LogManager.getLogger(TasaAutoController.class);
	static final String TASA_AUTO = "/tasaAuto";
	
	@Autowired(required = true)
	private TasaAutoImpl tasaAutoImpl;

	

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/cargaGrid")
	public ResponseEntity<?> getCargaGrid(){
		try {
			List<CargaGridDTO> listaCargaGrid = tasaAutoImpl.getCargaGrid();
			return ResponseEntity.status(HttpStatus.OK).body(listaCargaGrid);
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	

	@PostMapping(path = "/chkRecibir")
	public ResponseEntity<?> TasaAuto_chkRecibir(@RequestBody final ChkRecibirRequest request){		
		try {
			if(request.getSoeid().isEmpty()){
				throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(tasaAutoImpl.insertChkRecibir(request.getSoeid(), request.getOnline(), request.getNombre(), request.getAction()), HttpStatus.OK.toString());
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
	
	
	
	//SERVICIO IN BUSCAR CLICK
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/inBuscarClick")
	public ResponseEntity<?> getInBuscarClick(@Valid @RequestBody InBuscarClickDTO inBuscarClickDTO){
		try {
			List<CargaGridDTO> listaInBuscarClick = tasaAutoImpl.getInBuscarClick(inBuscarClickDTO.getEstatus(), inBuscarClickDTO.getContrato(), inBuscarClickDTO.getNumeroCliente(), inBuscarClickDTO.getFechaSolicitud());
			return ResponseEntity.status(HttpStatus.OK).body(listaInBuscarClick);
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
	@PostMapping(path = "/inBuscar")
	public ResponseEntity<?> getInBuscarSolicitudes(@Valid @RequestBody InBuscarClickDTO inBuscarClickDTO){
		try {
			List<AutoTasasDTO> listaInBuscarClick = tasaAutoImpl.getInBuscarClickSolicitudes(inBuscarClickDTO.getEstatus(), inBuscarClickDTO.getContrato(), inBuscarClickDTO.getNumeroCliente(), inBuscarClickDTO.getFechaSolicitud());
			return ResponseEntity.status(HttpStatus.OK).body(listaInBuscarClick);
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
	@PostMapping(path = "/inBuscar/cliente/v1")
	public ResponseEntity<?> getInBuscarSolicitudesV1(@Valid @RequestBody InBuscarClickDTO inBuscarClickDTO){
		try {
			List<AutoTasasDTO> listaInBuscarClick = tasaAutoImpl.getInBuscarClickSolicitudesVersion2(inBuscarClickDTO.getEstatus(), inBuscarClickDTO.getContrato(), inBuscarClickDTO.getNumeroCliente(), inBuscarClickDTO.getFechaSolicitud());
			return ResponseEntity.status(HttpStatus.OK).body(listaInBuscarClick);
		} catch (Exception e) {
			ErrorGeneric errorResponse = new ErrorGeneric();
			errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMensaje(e.getMessage());
			errorResponse.setException(e);
			LOGGER.error(errorResponse.getException());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	
	//SERVICIO IN EDITAR BUSQUEDA
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/getEditSearch")
	public ResponseEntity<?> getInBuscarEditar(@Valid @RequestBody ResultEditarDTO resultEditarDTO){
		try {
			List<EditarTasaAutoDTO> listaEditar = tasaAutoImpl.getInBuscarEditar(resultEditarDTO.getIdAutoTasa());
			return ResponseEntity.status(HttpStatus.OK).body(listaEditar);
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
	@GetMapping(path = "/cargaCetes")
	public ResponseEntity<?> getCargaCetes(){
			try {
				List<CargaCeteDTO> listaCargaCetes = tasaAutoImpl.getCargaCetes();
				return ResponseEntity.status(HttpStatus.OK).body(listaCargaCetes);
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
	@PostMapping(path = "/inAceptarClick")
	public String inAceptarClick() {
		return "INGRESA AL ACEPTAR CLICK";
	}
	
	@PostMapping(path = "/inkRechazarClick")
	public ResponseEntity<?> TasaAuto_InkRechazarClick(@RequestBody final UpdateInkRechazarRequest rechazarRequest){		
		try {
			if(rechazarRequest.getId_tasaAuto().isEmpty()){
				throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(tasaAutoImpl.updateInkRechazar(rechazarRequest.getSoeidOpe(), rechazarRequest.getJustificacion(), rechazarRequest.getObservaWeb(), rechazarRequest.getId_tasaAuto(), rechazarRequest.getFechaSolicitud()), HttpStatus.OK.toString());
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
	
	//SERVICIO IN RECHAZAR CANCELAR CLICK
	@PostMapping(path = "/inkRechazarCancelar")
	public ResponseEntity<?> TasaAuto_inkRechazarCancelar(@RequestBody final UpdateInRechazarCancelar rechazarCancelarRequest){		
		try {
			if(rechazarCancelarRequest.getIdTasaAuto().isEmpty()){
				throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(tasaAutoImpl.updateInkRechazarCancelar(rechazarCancelarRequest.getSoeidOpe(), 
					rechazarCancelarRequest.getFechaEstatus(), rechazarCancelarRequest.getJustificacion(), 
					rechazarCancelarRequest.getObservacionWeb(), rechazarCancelarRequest.getNumAutoriEUC(), 
					rechazarCancelarRequest.getEstatus(), rechazarCancelarRequest.getIdTasaAuto()), HttpStatus.OK.toString());
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
	
	/**
	 * Servicio que recibe los siguiente parametros:
	 * 
	 * soeidOpe,estatus,justificacion,observacionWeb,numAutoriEUC;idTasaAuto;
	 * 
	 * y acutaliza cualquiera de ellos en la tabla de autoTasas al igual que actualiza la fecha
	 * estatus con el día y hora que se reailzo la actualización de dichos campos
	 * 
	 * @param cancelarRequest
	 * @return
	 */
	@PostMapping(path = "/inkCancelar")
		public ResponseEntity<?> TasaAuto_inkCancelar(@Valid @RequestBody UpdateInkCancelar cancelarRequest){		
			try {
				if(cancelarRequest.getIdTasaAuto().isEmpty()){
					throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
				}
				MensajeResponse response = new MensajeResponse(tasaAutoImpl.updateInkCancelar(cancelarRequest.getSoeidOpe(), 
						cancelarRequest.getEstatus(), cancelarRequest.getJustificacion(), 
						cancelarRequest.getObservacionWeb(), cancelarRequest.getNumAutoriEUC(), 
						cancelarRequest.getIdTasaAuto()), HttpStatus.OK.toString());
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
	
	
	/**
	 * SERVICIO QUE ACTUALIZA EL SOEID OPERADOR EN LA TABLA DE AUTOTASAS
	 * PARA INDICAR QUE ESTE SOEID ES QUIEN EN REALIDAD ATENDIO LA SOLICITUD.
	 * @param actualizar
	 * @return
	 */
	 @PostMapping(path = "/actualizar/solicitud")
	 public ResponseEntity<?> actualizaSolicitud(@Valid @RequestBody ActualizaSolicitudDTO actualizar){		
		try {
			if(actualizar.getIdTasaAuto().isEmpty()){
				throw new GenericException("Request Incompleto Id Tasa Auto ::", HttpStatus.BAD_REQUEST.toString());
			}
			MensajeResponse response = new MensajeResponse(tasaAutoImpl.actualizaSolicitud(actualizar.getSoeidOpe(), 
					actualizar.getIdTasaAuto()), HttpStatus.OK.toString());
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
	
	
	
		
		
		//SERVICIO MOSTRAR RESEND MAIL
		@GetMapping(path = "/cargaResendMail")
		public ResponseEntity<?> getCargaResendMail(){
			try {
				List<ResendMailDTO> listaResendMail = tasaAutoImpl.getCargaResendMail();
				return ResponseEntity.status(HttpStatus.OK).body(listaResendMail);
			} catch (Exception e) {
				ErrorGeneric errorResponse = new ErrorGeneric();
				errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
				errorResponse.setMensaje(e.getMessage());
				errorResponse.setException(e);
				LOGGER.error(errorResponse.getException());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
			}
		}
		
		//CORREO TASA ESPECIAL
		@PostMapping(path = "/emailTasaEspecial")
		public ResponseEntity<?> getEmailTasaEspecial(@RequestBody final EmailTasaEspecialRequest request){
			
			try {
				if (request.getFolio() == null || request.getLinkAutoriza() == null || request.getLinkRechaza() == null
	                    || request.getListAurotizadores() == null || request.getUrlRedirect() == null || request.getIdAutorizadores() == null) {
	                throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
	            }
				System.out.println("request :: " + request.toString());				
				EmailDTO response = new EmailDTO();
				return new ResponseEntity<EmailDTO>(response, HttpStatus.OK);				
			}catch (GenericException ex) {
	            ErrorGeneric error = new ErrorGeneric();
	            error.setCode(ex.getCodeError());
	            error.setMensaje(ex.getMessage());
	            error.setException(ex);
	            LOGGER.info(error.getException());
	            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	        } catch (Exception e) {
	            ErrorGeneric error = new ErrorGeneric();
	            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
	            error.setMensaje(e.getMessage());
	            error.setException(e);
	            LOGGER.info(error.getException());
	            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
	        }
						
		}
	
}
