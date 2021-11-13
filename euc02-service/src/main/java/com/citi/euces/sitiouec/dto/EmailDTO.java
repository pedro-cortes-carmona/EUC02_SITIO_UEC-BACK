package com.citi.euces.sitiouec.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private EmailDTO emailDTO;

	private String code;

		
	
	public EmailDTO() {
		
	}

	public EmailDTO(EmailDTO emailDTO, String code) {
		super();
		this.emailDTO = emailDTO;
		this.code = code;
	}

	public EmailDTO getEmailDTO() {
		return emailDTO;
	}

	public void setEmailDTO(EmailDTO emailDTO) {
		this.emailDTO = emailDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
