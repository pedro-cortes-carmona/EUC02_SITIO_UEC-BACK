package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasaGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.ReportDataSource;
import com.citi.euces.sitiouec.dto.SucursalGerenciaResponseDTO;



public class SucursalGerenciaResponse {
	
	private List<ReportDataSource> sucursalGerenciaResponse;
	private String code;
	/**
	 * @param sucursalGerenciaResponse
	 * @param code
	 */
	public SucursalGerenciaResponse(List<ReportDataSource> sucursalGerenciaResponse, String code) {
		super();
		this.sucursalGerenciaResponse = sucursalGerenciaResponse;
		this.code = code;
	}
	public List<ReportDataSource> getSucursalGerenciaResponse() {
		return sucursalGerenciaResponse;
	}
	public void setSucursalGerenciaResponse(List<ReportDataSource> sucursalGerenciaResponse) {
		this.sucursalGerenciaResponse = sucursalGerenciaResponse;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
