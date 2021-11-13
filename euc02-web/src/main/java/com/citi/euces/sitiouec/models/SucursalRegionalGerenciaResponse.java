package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.SucursalRegionalGerenciaResponseDTO;



public class SucursalRegionalGerenciaResponse {
	
	
	private List<SucursalRegionalGerenciaResponseDTO> sucursalRegionalGerenciaResponseDTO;
	private String code;
	/**
	 * @param sucursalRegionalGerenciaResponseDTO
	 * @param code
	 */
	public SucursalRegionalGerenciaResponse(
			List<SucursalRegionalGerenciaResponseDTO> sucursalRegionalGerenciaResponseDTO, String code) {
		super();
		this.sucursalRegionalGerenciaResponseDTO = sucursalRegionalGerenciaResponseDTO;
		this.code = code;
	}
	public List<SucursalRegionalGerenciaResponseDTO> getSucursalRegionalGerenciaResponseDTO() {
		return sucursalRegionalGerenciaResponseDTO;
	}
	public void setSucursalRegionalGerenciaResponseDTO(
			List<SucursalRegionalGerenciaResponseDTO> sucursalRegionalGerenciaResponseDTO) {
		this.sucursalRegionalGerenciaResponseDTO = sucursalRegionalGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
