package com.citi.euces.sitiouec.restcontrollers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.models.EmailTemplateResponse;
import com.citi.euces.sitiouec.models.EmailTemplateSolTarifasRequest;
import com.citi.euces.sitiouec.models.ErrorGeneric;
import com.citi.euces.sitiouec.services.api.SolicitudCampanaService;

@RestController
@RequestMapping(path = SolicitudCampanaController.SOLICITUD_CAMPANA,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudCampanaController {

	private static final Logger LOGER = LogManager.getLogger(SolicitudCampanaController.class);
	
	static final String SOLICITUD_CAMPANA = "/solicitudCampana";
	
	@Autowired
	private SolicitudCampanaService solicitudCampanaService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/RenviarPHP")
    public ResponseEntity<?> EnviarPHP(@RequestBody final EmailTemplateSolTarifasRequest request) {

        try {
            if (request.getUrlRedirect() == null) {
                throw new GenericException("Request incompleto :: ", HttpStatus.BAD_REQUEST.toString());
            }
            System.out.println("request :: " + request.toString());
            EmailTemplateResponse response = new EmailTemplateResponse(
            		solicitudCampanaService.emailTemplate(request.getFolio(), request.getLinkAutoriza(),
                            request.getLinkRechaza() , request.getUrlRedirect(), request.getListadoAutorizadores()), "200");
            return new ResponseEntity<EmailTemplateResponse>(response, HttpStatus.OK);
        } catch (GenericException ex) {
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(ex.getCodeError());
            error.setMensaje(ex.getMessage());
            error.setException(ex);
            LOGER.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        } catch (Exception e) {
            ErrorGeneric error = new ErrorGeneric();
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            error.setMensaje(e.getMessage());
            error.setException(e);
            LOGER.info(error.getException());
            return new ResponseEntity<ErrorGeneric>(error, HttpStatus.OK);
        }
    }
}