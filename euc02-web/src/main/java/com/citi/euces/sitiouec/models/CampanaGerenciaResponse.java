package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.CampanaGerenciaResponseDTO;

public class CampanaGerenciaResponse {
	
	private List<CampanaGerenciaResponseDTO> campanaGerenciaResponseDTO;
	private String code;
	/**
	 * @param campanaGerenciaResponseDTO
	 * @param code
	 */
	public CampanaGerenciaResponse(List<CampanaGerenciaResponseDTO> campanaGerenciaResponseDTO, String code) {
		super();
		this.campanaGerenciaResponseDTO = campanaGerenciaResponseDTO;
		this.code = code;
	}
	public List<CampanaGerenciaResponseDTO> getCampanaGerenciaResponseDTO() {
		return campanaGerenciaResponseDTO;
	}
	public void setCampanaGerenciaResponseDTO(List<CampanaGerenciaResponseDTO> campanaGerenciaResponseDTO) {
		this.campanaGerenciaResponseDTO = campanaGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	
}
