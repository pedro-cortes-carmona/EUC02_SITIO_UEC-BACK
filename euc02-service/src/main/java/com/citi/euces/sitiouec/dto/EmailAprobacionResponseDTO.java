package com.citi.euces.sitiouec.dto;

public class EmailAprobacionResponseDTO {
	
	
	
	
	private String body;
	private String code;
	/**
	 * @param body
	 * @param code
	 */
	
	public EmailAprobacionResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	public EmailAprobacionResponseDTO(String body, String code) {
		super();
		this.body = body;
		this.code = code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
