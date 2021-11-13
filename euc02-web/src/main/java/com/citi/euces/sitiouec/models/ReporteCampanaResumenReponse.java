package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaResumenDTO;

public class ReporteCampanaResumenReponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusquedaCampanaResumenDTO consultaResumen;
	private String code;
	
	public ReporteCampanaResumenReponse() {}
	
	public ReporteCampanaResumenReponse(BusquedaCampanaResumenDTO consultaResumen, String code) {
		super();
		this.consultaResumen = consultaResumen;
		this.code = code;
	}

	public BusquedaCampanaResumenDTO getConsultaResumen() {
		return consultaResumen;
	}

	public void setConsultaResumen(BusquedaCampanaResumenDTO consultaResumen) {
		this.consultaResumen = consultaResumen;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
