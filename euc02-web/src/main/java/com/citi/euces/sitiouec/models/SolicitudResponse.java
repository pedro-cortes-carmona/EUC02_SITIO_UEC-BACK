package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.EstatusDTO;

public class SolicitudResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EstatusDTO response;
	private String code;
	
	public SolicitudResponse() {}
	
	public SolicitudResponse(EstatusDTO response, String code) {
		super();
		this.response = response;
		this.code = code;
	}

	public EstatusDTO getResponse() {
		return response;
	}

	public void setResponse(EstatusDTO response) {
		this.response = response;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
