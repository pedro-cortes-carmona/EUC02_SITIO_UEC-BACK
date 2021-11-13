package com.citi.euces.sitiouec.models;

import java.util.List;

public class ObtenerListaTodasCampanasResponse {

	private List<String> campana;
	private String code;
	/**
	 * @param todasCampanas
	 * @param code
	 */
	/**
	 * @param campana
	 * @param code
	 */
	public ObtenerListaTodasCampanasResponse(List<String> campana, String code) {
		super();
		this.campana = campana;
		this.code = code;
	}
	public List<String> getCampana() {
		return campana;
	}
	public void setCampana(List<String> campana) {
		this.campana = campana;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
