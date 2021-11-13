package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.ReporteResumenDTO;

public class ReporteResumenResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReporteResumenDTO listaReporte;
	private String code;
	
	public ReporteResumenResponse() {}
	
	public ReporteResumenResponse(ReporteResumenDTO listaReporte, String code) {
		super();
		this.listaReporte = listaReporte;
		this.code = code;
	}

	public ReporteResumenDTO getListaReporte() {
		return listaReporte;
	}

	public void setListaReporte(ReporteResumenDTO listaReporte) {
		this.listaReporte = listaReporte;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
