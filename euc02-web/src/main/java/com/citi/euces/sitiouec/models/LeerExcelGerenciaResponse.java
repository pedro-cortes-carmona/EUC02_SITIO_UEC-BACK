package com.citi.euces.sitiouec.models;

import java.util.List;



public class LeerExcelGerenciaResponse {
	
	private String leerExcelGerenciaResponseDTO;
	private String code;
	/**
	 * @param leerExcelGerenciaResponseDTO
	 * @param code
	 */
	public LeerExcelGerenciaResponse(String leerExcelGerenciaResponseDTO, String code) {
		super();
		this.leerExcelGerenciaResponseDTO = leerExcelGerenciaResponseDTO;
		this.code = code;
	}
	public String getLeerExcelGerenciaResponseDTO() {
		return leerExcelGerenciaResponseDTO;
	}
	public void setLeerExcelGerenciaResponseDTO(String leerExcelGerenciaResponseDTO) {
		this.leerExcelGerenciaResponseDTO = leerExcelGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
}
