package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.util.List;

import com.citi.euces.sitiouec.infra.dto.AutoAutorizadorBEDTO;
import com.citi.euces.sitiouec.infra.dto.EmailTemplateDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;


public interface SolicitudCampanaService {
	
	EmailTemplateDTO emailTemplate(String folio, String linkAutoriza, String linkRechaza,
		    String urlRedirect, List<AutoAutorizadorBEDTO> listadoAutorizadores) throws GenericException;

	EmailTemplateDTO emailTemplate21(String folio, String linkAutoriza, String linkRechaza, 
			String urlRedirect,	List<AutoAutorizadorBEDTO> listadoAutorizadores) throws GenericException;
	
//	String generateTemplate(EnviarPhpDTO request) throws GenericException;

}
