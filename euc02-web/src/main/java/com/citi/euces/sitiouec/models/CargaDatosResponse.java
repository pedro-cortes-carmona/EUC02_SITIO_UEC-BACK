package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.CargaDatosDTO;

public class CargaDatosResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CargaDatosDTO datos;
	private String code;
	
	public CargaDatosResponse() {}
	
	public CargaDatosResponse(CargaDatosDTO datos, String code) {
		super();
		this.datos = datos;
		this.code = code;
	}

	public CargaDatosDTO getDatos() {
		return datos;
	}

	public void setDatos(CargaDatosDTO datos) {
		this.datos = datos;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
