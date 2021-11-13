package com.citi.euces.sitiouec.models;

public class ObtenerDiasHabilesResponse {

	private Long dias;
	private String code;
	/**
	 * @param dias
	 * @param code
	 */
	public ObtenerDiasHabilesResponse(Long dias, String code) {
		super();
		this.dias = dias;
		this.code = code;
	}
	public Long getDias() {
		return dias;
	}
	public void setDias(Long dias) {
		this.dias = dias;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
