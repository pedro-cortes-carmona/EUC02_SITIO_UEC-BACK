package com.citi.euces.sitiouec.services.api;

import com.citi.euces.sitiouec.dto.EmailAprobacionTasaEspecialDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

public interface EmailTemplateAprobacionService {
	
	
	
	String emailTemplateTasaEspecial(EmailAprobacionTasaEspecialDTO request) throws GenericException;
	
	String emailTemplateAprobacionInversion(EmailAprobacionTasaEspecialDTO request) throws GenericException;

	
	
	
}
