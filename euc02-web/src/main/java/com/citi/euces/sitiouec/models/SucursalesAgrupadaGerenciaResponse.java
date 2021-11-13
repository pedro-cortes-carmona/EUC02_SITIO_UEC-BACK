package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaResponseDTO;



public class SucursalesAgrupadaGerenciaResponse {

	private List<SucursalesAgrupadaGerenciaResponseDTO> sucursalesAgrupadaGerenciaResponseDTO;
    private String code;
	/**
	 * @param sucursalesAgrupadaGerenciaResponseDTO
	 * @param code
	 */
	public SucursalesAgrupadaGerenciaResponse(
			List<SucursalesAgrupadaGerenciaResponseDTO> sucursalesAgrupadaGerenciaResponseDTO, String code) {
		super();
		this.sucursalesAgrupadaGerenciaResponseDTO = sucursalesAgrupadaGerenciaResponseDTO;
		this.code = code;
	}
	public List<SucursalesAgrupadaGerenciaResponseDTO> getSucursalesAgrupadaGerenciaResponseDTO() {
		return sucursalesAgrupadaGerenciaResponseDTO;
	}
	public void setSucursalesAgrupadaGerenciaResponseDTO(
			List<SucursalesAgrupadaGerenciaResponseDTO> sucursalesAgrupadaGerenciaResponseDTO) {
		this.sucursalesAgrupadaGerenciaResponseDTO = sucursalesAgrupadaGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
