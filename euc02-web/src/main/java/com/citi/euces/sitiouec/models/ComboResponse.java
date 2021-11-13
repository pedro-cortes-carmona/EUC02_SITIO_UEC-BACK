package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.CombosFacultamientoDTO;

public class ComboResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CombosFacultamientoDTO combos;
	private String code;
	
	public ComboResponse() {}
	
	public ComboResponse(CombosFacultamientoDTO combos, String code) {
		super();
		this.combos = combos;
		this.code = code;
	}

	public CombosFacultamientoDTO getCombos() {
		return combos;
	}

	public void setCombos(CombosFacultamientoDTO combos) {
		this.combos = combos;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
