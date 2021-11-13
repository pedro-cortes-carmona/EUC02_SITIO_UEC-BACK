package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.ReporteBoletinesDTO;

public class ReporteBoletinesResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReporteBoletinesDTO datos;
	private String code;
	
	public ReporteBoletinesResponse() {}
	
	public ReporteBoletinesResponse(ReporteBoletinesDTO datos, String code) {
		super();
		this.datos = datos;
		this.code = code;
	}

	public ReporteBoletinesDTO getDatos() {
		return datos;
	}

	public void setDatos(ReporteBoletinesDTO datos) {
		this.datos = datos;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
