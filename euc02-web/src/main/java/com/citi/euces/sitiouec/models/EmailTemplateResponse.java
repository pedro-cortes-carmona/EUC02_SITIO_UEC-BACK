package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.EmailTemplateDTO;


public class EmailTemplateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmailTemplateDTO emailTemplateDTO;

	private String code;

	public EmailTemplateResponse() {
	}

	public EmailTemplateResponse(EmailTemplateDTO emailTemplateDTO, String code) {
		this.emailTemplateDTO = emailTemplateDTO;
		this.code = code;
	}

	public EmailTemplateDTO getEmailTemplateDTO() {
		return emailTemplateDTO;
	}

	public void setEmailTemplateDTO(EmailTemplateDTO emailTemplateDTO) {
		this.emailTemplateDTO = emailTemplateDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
