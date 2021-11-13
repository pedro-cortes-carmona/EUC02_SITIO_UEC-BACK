package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaDetalleDTO;

public class ReporteCampanaDetalleResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusquedaCampanaDetalleDTO ReporteCampana;
	private String code;
	
	public ReporteCampanaDetalleResponse() {}
	
	public ReporteCampanaDetalleResponse(BusquedaCampanaDetalleDTO reporteCampana, String code) {
		super();
		ReporteCampana = reporteCampana;
		this.code = code;
	}

	public BusquedaCampanaDetalleDTO getReporteCampana() {
		return ReporteCampana;
	}

	public void setReporteCampana(BusquedaCampanaDetalleDTO reporteCampana) {
		ReporteCampana = reporteCampana;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
